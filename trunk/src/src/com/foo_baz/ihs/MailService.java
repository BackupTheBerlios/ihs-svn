/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs;

import java.util.ArrayList;

import com.foo_baz.ihs.mailservice.Domain;

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

	abstract public Error getDomains( ArrayList domains ) throws Exception;

	/// Add domain
	abstract public Error addDomain( Domain dom ) throws Exception; 
	/// Removes domain
	abstract public Error removeDomain( Integer dom_id ) throws Exception;
	/// Validates domain name
	abstract public Error validateDomain( String dom ) throws Exception;
	/// Gets ID of domain
	abstract public Error getIdOfDomain( Domain dom ) throws Exception;
	/// Gets name of a domain
	abstract public Error getNameOfDomain( Domain dom ) throws Exception;
}