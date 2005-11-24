/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs;

/**
 * @author new
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Service {
	//@{
	/// Supported types of services
	final static Integer MAIL_SERVICE = new Integer(1);
	//@}
	
	abstract Integer getType();

	/**
	 * Returns true if service has been opened 
	 * @return true if open
	 */
	abstract boolean isOpen();
	
	/**
	 * Initialize service
	 * @throws Exception
	 */
	abstract void open() throws Exception;
	
	/**
	 * Shutdown service
	 * @throws Exception
	 */
	abstract void close() throws Exception;
}
