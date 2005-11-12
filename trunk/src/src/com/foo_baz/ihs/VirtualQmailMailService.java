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

import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.v_q.db_error;
import com.foo_baz.v_q.except;
import com.foo_baz.v_q.ivq;
import com.foo_baz.v_q.ivqHelper;
import com.foo_baz.v_q.null_error;
import com.foo_baz.v_q.ivqPackage.domain_info_listHolder;
import com.foo_baz.v_q.ivqPackage.err_code;
import com.foo_baz.v_q.ivqPackage.error;

//import com.foo_baz.v_q.*;
//import com.foo_baz.v_q.ivqPackage.*;

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
			env.put("java.naming.corba.orb", orb);
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
			env.put(Context.PROVIDER_URL, "iiop://localhost:2809");
			Context ic = new InitialContext(env);
			return ic;
		} else
			return null;
	}
	
	protected ivq getVirtualQmail() throws NamingException {
		Context ic = getNamingContext();
		ivq vqo = ivqHelper.narrow((org.omg.CORBA.Object) ic.lookup("VQ.ivq"));
		return vqo;
	}
	
	/**
	 * @param domains Array of Domain objects
	 * @see com.foo_baz.ihs.mailservice.Domain
	 */
	public Error getDomains( ArrayList domains ) throws NamingException {
		ivq vq = getVirtualQmail();
		
		domain_info_listHolder diList = null;
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
		if( err.ec == err_code.err_no ) {
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
}
