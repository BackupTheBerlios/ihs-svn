package com.foo_baz.ihs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.foo_baz.util.OperationStatus;

/**
 * @author $Author$
 * @version $Id$
 */
public interface Configuration {
	
	public OperationStatus set( Class type, String key, Object value ) 
		throws SQLException, IOException, ClassNotFoundException;
	
	public OperationStatus get( Class type, String key, Object value ) 
		throws SQLException, IOException, ClassNotFoundException;
	
	public Map getAll() throws SQLException;

}
