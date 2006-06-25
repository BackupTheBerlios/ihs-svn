package com.foo_baz.ihs;

import java.sql.SQLException;
import java.util.Map;

import com.foo_baz.util.OperationStatus;

/**
 * @author $Author$
 * @version $Id$
 */
public interface Configuration {
	
	public OperationStatus set( String key, String value ) throws SQLException;
	
	public String get( String key ) throws SQLException;
	
	public Map getAll() throws SQLException;

}
