/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs;

import java.util.ArrayList;

import org.omg.CORBA.IntHolder;

import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.ihs.mailservice.User;
import com.foo_baz.v_q.ivqPackage.error;

/**
 * @author new
 */
public abstract class MailService implements Service {

	/**
	 * 
	 */
	public MailService() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.foo_baz.ihs.Service#getType()
	 */
	public Integer getType() {
		return Service.MAIL_SERVICE;
	}

	abstract public error getDomains( ArrayList domains ) throws Exception;

	/// Add domain
	abstract public error addDomain( Domain dom ) throws Exception; 
	/// Removes domain
	abstract public error removeDomain( int dom_id ) throws Exception;
	/// Validates domain name
	abstract public error validateDomain( String dom ) throws Exception;
	/// Gets ID of domain
	abstract public error getIdOfDomain( Domain dom ) throws Exception;
	/// Gets name of a domain
	abstract public error getNameOfDomain( Domain dom ) throws Exception;
	/// Gets users in domain
	abstract public error getUsersInDomain( int dom_id, int start, int cnt, ArrayList users ) throws Exception;
	/// Get number of users in domain
	abstract public error getNumberOfUsersInDomain( int dom_id, IntHolder cnt ) throws Exception;
	/// Add user
	abstract public error addUser( User user ) throws Exception;
	/// Update user
	abstract public error updateUser( User user ) throws Exception;
	/// Removes user
	abstract public error removeUser( int dom_id, String user ) throws Exception;
}
