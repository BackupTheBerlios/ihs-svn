package com.foo_baz.ihs;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.StringHolder;

import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.ihs.mailservice.LogEntry;
import com.foo_baz.ihs.mailservice.User;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;
import com.foo_baz.v_q.db_error;
import com.foo_baz.v_q.except;
import com.foo_baz.v_q.ilogger;
import com.foo_baz.v_q.iloggerHelper;
import com.foo_baz.v_q.ivq;
import com.foo_baz.v_q.ivqHelper;
import com.foo_baz.v_q.null_error;
import com.foo_baz.v_q.iloggerPackage.log_entry_listHolder;
import com.foo_baz.v_q.iloggerPackage.result_type_listHolder;
import com.foo_baz.v_q.iloggerPackage.service_type_listHolder;
import com.foo_baz.v_q.iloggerPackage.string_list2Holder;
import com.foo_baz.v_q.iloggerPackage.string_listHolder;
import com.foo_baz.v_q.ivqPackage.domain_info_listHolder;
import com.foo_baz.v_q.ivqPackage.err_code;
import com.foo_baz.v_q.ivqPackage.error;
import com.foo_baz.v_q.ivqPackage.user_info;
import com.foo_baz.v_q.ivqPackage.user_infoHolder;
import com.foo_baz.v_q.ivqPackage.user_info_listHolder;
import com.foo_baz.ihs.backing.Configuration;

/**
 * @author $Author$
 * @version $Id$
 */
public class VirtualQmailMailService extends MailService {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs.mailservice");
	protected Configuration conf;
	
	/**
	 * 
	 */
	public VirtualQmailMailService() {
		super();
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_configuration}");
		conf = (Configuration) binding.getValue(context);
	}

	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	protected Context getNamingContext() throws Exception {
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
		if( orb != null ) {
			Hashtable env = new Hashtable();
			env.put("org.omg.CORBA.ORBInitRef", conf.getOrbInitRef());
			env.put("java.naming.corba.orb", orb);
			env.put(Context.INITIAL_CONTEXT_FACTORY, conf.getOrbInitialContextFactory());
			env.put(Context.PROVIDER_URL, conf.getOrbProviderUrl());
			Context ic = new InitialContext(env);
			return ic;
		} else
			return null;
	}
	
	private ivq vqo = null;
	
	protected ivq getVirtualQmail() throws Exception {
		if( vqo == null ) {
			Context ic = getNamingContext();
			this.vqo = ivqHelper.narrow((org.omg.CORBA.Object) ic.lookup(conf.getOrbVirtualQmail()));
		}
		return this.vqo;
	}
	
	private ilogger logo = null;
	
	protected ilogger getVirtualQmailLogger() throws Exception {
		if( logo == null ) {
			Context ic = getNamingContext();
			this.logo = iloggerHelper.narrow((org.omg.CORBA.Object) ic.lookup(conf.getOrbVirtualQmailLogger()));
		}
		return this.logo;
	}
	
	/**
	 * @param domains Array of Domain objects
	 * @see com.foo_baz.ihs.mailservice.Domain
	 */
	public OperationStatus getDomains( ArrayList domains ) throws Exception {
		ivq vq = getVirtualQmail();
		
		domain_info_listHolder diList = new domain_info_listHolder();

		error err;
		try {
			err = vq.dom_ls(diList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			domains.clear();
			for( int i=0, s = diList.value.length; i<s; ++i ) {
				domains.add(new Domain(diList.value[i]));
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus(OperationStatus.FAILURE, toString(err));
	}

	/**
	 * @param domain idDomain must be set
	 * @see com.foo_baz.ihs.mailservice.Domain
	 */
	public OperationStatus getDomain( Domain domain ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		StringHolder domName = new StringHolder();
		try {
			err = vq.dom_name(domain.getIdDomain(), domName);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			domain.setDomain(domName.value);
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	
	/**
	 * 
	 */
	protected String toString( error err ) {
		Object[] args = {
				err.what,
				err.file,
				new Integer(err.line)
		};
		return Messages.getString(
			"com.foo_baz.ihs.errors", 
			"virtualQmailError_"+Integer.toString(err.ec.value()), args); 
	}

	boolean open = false;
	
	/* (non-Javadoc)
	 * @see com.foo_baz.ihs.Service#open()
	 */
	public void open() throws Exception {
		open = true;
	}

	/* (non-Javadoc)
	 * @see com.foo_baz.ihs.Service#close()
	 */
	public void close() throws Exception {
		open = false;
	}
	
	public boolean isOpen() {
		return open;
	}

	/// Update domain
	public OperationStatus updateDomain( Domain dom ) throws Exception {
		return OperationStatus.FAILURE;
	}
	
	/// Add domain
	public OperationStatus addDomain( Domain dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		IntHolder domId = new IntHolder();
		try {
			err = vq.dom_add(dom.getDomain(), domId);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus(OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			dom.setIdDomain(domId.value);
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	/// Removes domain
	public OperationStatus removeDomain( int domId ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		try {
			err = vq.dom_rm(domId);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}
		return err.ec == err_code.err_no ? OperationStatus.SUCCESS
			: new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	/// Validates domain name
	public OperationStatus validateDomain( String dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		try {
			err = vq.dom_val(dom);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}
		return err.ec == err_code.err_no ? OperationStatus.SUCCESS
			: new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	/// Gets ID of domain
	public OperationStatus getIdOfDomain( Domain dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		IntHolder domId = new IntHolder();
		try {
			err = vq.dom_id(dom.getDomain(), domId);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			dom.setIdDomain(domId.value);
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	
	/// Gets name of a domain
	public OperationStatus getNameOfDomain( Domain dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		StringHolder domName = new StringHolder();
		try {
			err = vq.dom_name(dom.getIdDomain(), domName);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			dom.setDomain(domName.value);
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	
	/**
	 * 
	 */
	public OperationStatus getUsersInDomain( int domId, int start, int cnt,
			ArrayList users ) throws Exception {
		ivq vq = getVirtualQmail();
		
		user_info_listHolder uiList = new user_info_listHolder();
		error err;
		try {
			err = vq.user_ls_by_dom(domId, start, cnt, uiList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			users.clear();
			for( int i=0, s = uiList.value.length; i<s; ++i ) {
				users.add(new User(uiList.value[i]));
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}

	/**
	 * 
	 */
	public OperationStatus getUser( User user ) throws Exception {
		ivq vq = getVirtualQmail();
		
		user_infoHolder ui = new user_infoHolder(new user_info());
		ui.value.id_domain = user.getIdDomain();
		ui.value.login = user.getLogin();
		ui.value.pass = "";
		ui.value.dir = "";
		error err;
		try {
			err = vq.user_get(ui);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			user.setUserInfo(ui.value);
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}
	
	/// Get number of users in domain
	public OperationStatus getNumberOfUsersInDomain( int dom_id, IntHolder cnt ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		IntHolder cntHold = new IntHolder();
		try {
			err = vq.user_cnt_by_dom(dom_id, cntHold);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}
		if( err != null && err.ec == err_code.err_no ) {
			cnt.value = cntHold.value;
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}
	
	/// Add user
	public OperationStatus addUser( User user ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		user_info ui = new user_info( user.getIdDomain(), user.getLogin(), 
			user.getPassword(), user.getDir(), user.getFlags(), 
			user.getGid(), user.getUid());
		try {
			err = vq.user_add(ui, false);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		return err.ec == err_code.err_no ? OperationStatus.SUCCESS
			: new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	
	/// Update user
	public OperationStatus updateUser( User user, boolean pass, boolean dir ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		user_info ui = new user_info( user.getIdDomain(), user.getLogin(), 
			user.getPassword(), user.getDir(), user.getFlags(), 
			user.getGid(), user.getUid());
		try {
			err = vq.user_rep(ui, pass, dir);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		return err.ec == err_code.err_no ? OperationStatus.SUCCESS
			: new OperationStatus(OperationStatus.FAILURE, toString(err));
	}
	
	/// Removes user
	public OperationStatus removeUser( int dom_id, String user ) throws Exception {
		return OperationStatus.FAILURE;
	}
	
	/**
	 * 
	 */
	public OperationStatus getLogs( int start, int cnt, ArrayList al ) throws Exception {
		ilogger log = getVirtualQmailLogger();
		
		log_entry_listHolder leList = new log_entry_listHolder();
		error err;
		try {
			err = log.read(start, cnt, leList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			al.clear();
			for( int i=0, s = leList.value.length; i<s; ++i ) {
				al.add(new LogEntry(leList.value[i]));
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}

	/**
	 * 
	 */
	public OperationStatus getLogsByDomain( String dom, int start, int cnt, ArrayList al ) throws Exception {
		ilogger log = getVirtualQmailLogger();
		
		log_entry_listHolder leList = new log_entry_listHolder();
		error err;
		try {
			log.domain_set(dom);
			err = log.read_by_dom(start, cnt, leList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			al.clear();
			for( int i=0, s = leList.value.length; i<s; ++i ) {
				al.add(new LogEntry(leList.value[i]));
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}

	/**
	 * @param al list of String[]
	 */
	public OperationStatus getLogsBySql( String sql, int start, int cnt, ArrayList al ) throws Exception {
		ilogger log = getVirtualQmailLogger();
		
		string_list2Holder leList = new string_list2Holder();
		error err;
		try {
			err = log.read_by_sql(sql, start, cnt, leList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			al.clear();
			for( int i=0, s = leList.value.length; i<s; ++i ) {
				al.add(leList.value[i]);
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}

	/**
	 * 
	 */
	public OperationStatus getDomainsInLogs( ArrayList al ) throws Exception {
		ilogger log = getVirtualQmailLogger();
		
		string_listHolder leList = new string_listHolder();
		error err;
		try {
			err = log.dom_ls(leList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			al.clear();
			for( int i=0, s = leList.value.length; i<s; ++i ) {
				al.add(leList.value[i]);
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}

	/**
	 * 
	 */
	public OperationStatus getServicesInLogs( ArrayList al ) throws Exception {
		ilogger log = getVirtualQmailLogger();
		
		service_type_listHolder leList = new service_type_listHolder();
		error err;
		try {
			err = log.service_ls(leList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			al.clear();
			for( int i=0, s = leList.value.length; i<s; ++i ) {
				al.add(new Short(leList.value[i]));
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}
	
	/**
	 * 
	 */
	public OperationStatus getResultsInLogs( ArrayList al ) throws Exception {
		ilogger log = getVirtualQmailLogger();
		
		result_type_listHolder leList = new result_type_listHolder();
		error err;
		try {
			err = log.result_ls(leList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new OperationStatus( OperationStatus.FAILURE, e.toString());
		}

		if( err != null && err.ec == err_code.err_no ) {
			al.clear();
			for( int i=0, s = leList.value.length; i<s; ++i ) {
				al.add(new Short(leList.value[i]));
			}
			return OperationStatus.SUCCESS;
		}
		return new OperationStatus( OperationStatus.FAILURE, toString(err));
	}
}
