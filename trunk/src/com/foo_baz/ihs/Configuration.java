/*
 * Created on 2006-01-04
 * 
 * @author new
 */
package com.foo_baz.ihs;

import java.sql.SQLException;
import java.util.Map;

import com.foo_baz.util.OperationStatus;

/**
 * @author new
 */
public interface Configuration {
	
	public OperationStatus set( String key, String value ) throws SQLException;
	
	public String get( String key ) throws SQLException;
	
	public Map getAll() throws SQLException;

}
