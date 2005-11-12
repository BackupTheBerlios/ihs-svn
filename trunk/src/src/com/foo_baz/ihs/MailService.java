/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs;

import java.util.ArrayList;

import javax.naming.NamingException;

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
}
