package com.foo_baz.ihs;

/**
 * @author $Author$
 * @version $Id$
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
