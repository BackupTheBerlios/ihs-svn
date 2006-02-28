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
import com.foo_baz.util.OperationStatus;

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

	abstract public OperationStatus getDomains( ArrayList domains ) throws Exception;

	/// Add domain
	abstract public OperationStatus addDomain( Domain dom ) throws Exception;
	/// Update domain
	abstract public OperationStatus updateDomain( Domain dom ) throws Exception;
	/// Removes domain
	abstract public OperationStatus removeDomain( int dom_id ) throws Exception;
	/// Validates domain name
	abstract public OperationStatus validateDomain( String dom ) throws Exception;
	/// Gets ID of domain
	abstract public OperationStatus getIdOfDomain( Domain dom ) throws Exception;
	/// Gets name of a domain
	abstract public OperationStatus getNameOfDomain( Domain dom ) throws Exception;
	/// Gets users in domain
	abstract public OperationStatus getUsersInDomain( int dom_id, int start, int cnt, ArrayList users ) throws Exception;
	/// Get number of users in domain
	abstract public OperationStatus getNumberOfUsersInDomain( int dom_id, IntHolder cnt ) throws Exception;
	/// Add user
	abstract public OperationStatus addUser( User user ) throws Exception;
	/// Update user
	abstract public OperationStatus updateUser( User user, boolean pass, boolean dir ) throws Exception;
	/// Removes user
	abstract public OperationStatus removeUser( int dom_id, String user ) throws Exception;
}
