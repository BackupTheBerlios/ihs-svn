/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.StringHolder;

import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.ihs.mailservice.User;
import com.foo_baz.v_q.db_error;
import com.foo_baz.v_q.except;
import com.foo_baz.v_q.ivq;
import com.foo_baz.v_q.ivqHelper;
import com.foo_baz.v_q.null_error;
import com.foo_baz.v_q.ivqPackage.domain_info_listHolder;
import com.foo_baz.v_q.ivqPackage.err_code;
import com.foo_baz.v_q.ivqPackage.error;
import com.foo_baz.v_q.ivqPackage.user_info_listHolder;

/**
 * @author new
 */
public class VirtualQmailMailService extends MailService {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs.mailservice");

	/**
	 * 
	 */
	public VirtualQmailMailService() {
		super();
	}

	/**
	 * 
	 * @return
	 * @throws NamingException
	 */
	protected Context getNamingContext() throws NamingException {
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
		if( orb != null ) {
			Hashtable env = new Hashtable();
			env.put("org.omg.CORBA.ORBInitRef", "NameService=corbaloc::localhost:2809/NameService");
			env.put("java.naming.corba.orb", orb);
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
			env.put(Context.PROVIDER_URL, "iiop://localhost:2809");
			Context ic = new InitialContext(env);
			return ic;
		} else
			return null;
	}
	
	private ivq vqo = null;
	
	protected ivq getVirtualQmail() throws NamingException {
		if( vqo == null ) {
			Context ic = getNamingContext();
			this.vqo = ivqHelper.narrow((org.omg.CORBA.Object) ic.lookup("VQ.ivq"));
		}
		return this.vqo;
	}
	
	/**
	 * @param domains Array of Domain objects
	 * @see com.foo_baz.ihs.mailservice.Domain
	 */
	public Error getDomains( ArrayList domains ) throws NamingException {
		ivq vq = getVirtualQmail();
		
		domain_info_listHolder diList = new domain_info_listHolder();
		error err;
		try {
			err = vq.dom_ls(diList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_NO, "");
		if( err != null && err.ec == err_code.err_no ) {
			domains.clear();
			for( int i=0, s = diList.value.length; i<s; ++i ) {
				domains.add(new Domain(diList.value[i]));
			}
		} else {
			ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		}
		return ret;
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
	
	/// Add domain
	public Error addDomain( Domain dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		IntHolder domId = new IntHolder();
		try {
			err = vq.dom_add(dom.getDomain(), domId);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_NO, "");
		if( err != null && err.ec == err_code.err_no ) {
			dom.setIdDomain(domId.value);
		} else {
			ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		}
		return ret;
	}
	/// Removes domain
	public Error removeDomain( int domId ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		try {
			err = vq.dom_rm(domId);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		if( err != null && err.ec == err_code.err_no ) {
			ret = new Error(ErrorCode.ERR_NO, "");
		}
		return ret;
	}
	/// Validates domain name
	public Error validateDomain( String dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		try {
			err = vq.dom_val(dom);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		if( err != null ) {
			if( err.ec == err_code.err_no ) {
				ret = new Error(ErrorCode.ERR_NO, "");
			} else if( err.ec == err_code.err_dom_inv ) {
				ret = new Error(ErrorCode.ERR_INV, "");
			}
		}
		return ret;
	}
	/// Gets ID of domain
	public Error getIdOfDomain( Domain dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		IntHolder domId = new IntHolder();
		try {
			err = vq.dom_id(dom.getDomain(), domId);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_NO, "");
		if( err != null && err.ec == err_code.err_no ) {
			dom.setIdDomain(domId.value);
		} else {
			ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		}
		return ret;
	}
	/// Gets name of a domain
	public Error getNameOfDomain( Domain dom ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		StringHolder domName = new StringHolder();
		try {
			err = vq.dom_name(dom.getIdDomain(), domName);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_NO, "");
		if( err != null && err.ec == err_code.err_no ) {
			dom.setDomain(domName.value);
		} else {
			ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		}
		return ret;
	}
	
	/**
	 * 
	 */
	public Error getUsersInDomain( int domId, int start, int cnt,
			ArrayList users ) throws Exception {
		ivq vq = getVirtualQmail();
		
		user_info_listHolder uiList = new user_info_listHolder();
		error err;
		try {
			err = vq.user_ls_by_dom(domId, start, cnt, uiList);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}

		Error ret = new Error(ErrorCode.ERR_NO, "");
		if( err != null && err.ec == err_code.err_no ) {
			users.clear();
			for( int i=0, s = uiList.value.length; i<s; ++i ) {
				users.add(new User(uiList.value[i]));
			}
		} else {
			ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		}
		return ret;
	}
	
	/// Get number of users in domain
	public Error getNumberOfUsersInDomain( int dom_id, IntHolder cnt ) throws Exception {
		ivq vq = getVirtualQmail();
		
		error err;
		IntHolder cntHold = new IntHolder();
		try {
			err = vq.user_cnt_by_dom(dom_id, cntHold);
		} catch (null_error e) {
			logger.log(Level.SEVERE, "null_error", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (except e) {
			logger.log(Level.SEVERE, "except", e);
			return new Error(ErrorCode.ERR_SERVICE_INTERNAL, "");
		} catch (db_error e) {
			logger.log(Level.SEVERE, "db_error", e);
			return new Error(ErrorCode.ERR_SERVICE_DB, "");
		}
		Error ret = new Error(ErrorCode.ERR_NO, "");
		if( err != null && err.ec == err_code.err_no ) {
			cnt.value = cntHold.value;
		} else {
			ret = new Error(ErrorCode.ERR_SERVICE_INTERNAL, err.toString());
		}
		return ret;
	}
	
	/// Add user
	public Error addUser( User user ) throws Exception {
		return new Error(ErrorCode.ERR_FUNC_NI, "");
	}
	/// Update user
	public Error updateUser( User user ) throws Exception {
		return new Error(ErrorCode.ERR_FUNC_NI, "");
	}
	/// Removes user
	public Error removeUser( int dom_id, String user ) throws Exception {
		return new Error(ErrorCode.ERR_FUNC_NI, "");		
	}
}
