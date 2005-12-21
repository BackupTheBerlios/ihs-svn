package com.foo_baz.ihs;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

/**
 * @author Pawe³ Niewiadomski
 */
public class IncredibleHostingSystem
implements com.foo_baz.ihs.Administrators {
	
	protected Connection dbCon;
	
	protected void openDatabases() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		if (ctx == null)
			throw new NamingException(Messages.getString("com.foo_baz.ihs.errors", "contextNotFound", null));
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ihsDB");
		dbCon = ds.getConnection();
		if (dbCon == null)
			throw new SQLException(Messages.getString("com.foo_baz.ihs.errors", "databaseConnectionFailed", null));
		dbCon.setAutoCommit(true);
	}
	
	/**
	 * Setup array of existing services
	 * @throws Exception
	 */
	protected void addServices() throws Exception {
		services.put(Service.MAIL_SERVICE, new VirtualQmailMailService());
	}
	
	/**
	 * Add and initialize services
	 * @throws Exception
	 */
	protected void openServices() throws Exception {
		addServices();
		
		/*Enumeration en = services.elements();
		while( en.hasMoreElements() ) {
			((Service)en.nextElement()).open();
		}*/
	}
	
	/**
	 * 
	 * @throws NamingException
	 * @throws SQLException
	 */
	public void open() throws Exception
	{
		openDatabases();
		openServices();
	}
	
	/**
	 * Close all connections to databases
	 */
	protected void closeDatabases() throws SQLException {
		if (dbCon != null)
		{
			dbCon.close();
			dbCon = null;
		}
	}
	
	protected void closeServices() throws Exception {
		Enumeration en = services.elements();
		while( en.hasMoreElements() ) {
			((Service)en.nextElement()).close();
		}
	}
	
	/**
	 */
	public void close() throws Exception {
		closeDatabases();
		closeServices();
	}
	
	/**
	 * Add administrator.
	 * @param administrator Administrator to add
	 * @return Error
	 * @throws SQLException When SQL fails
	 */
	public OperationStatus addAdministrator(com.foo_baz.ihs.Administrator administrator) throws SQLException {
		String func = "IHS_ADMINISTRATOR_ADD";
		CallableStatement call = null;
		
		OperationStatus stat = OperationStatus.SUCCESS;
			
		try {
			call = dbCon.prepareCall("{? = call "+ func +"(?, ?)}");
			int idx = 1;
			call.registerOutParameter(idx++, Types.INTEGER);
			call.setString(idx++, administrator.getLogin());
			call.setString(idx++, administrator.getPassword());
			call.execute();
			
			int res = call.getInt(1);
			boolean wasNull = call.wasNull();
			
			if( wasNull ) {
				stat = new OperationStatus( 
					OperationStatus.FAILURE,
					Messages.getString(
						"com.foo_baz.ihs.errors", 
						"ihsFuncRes", new Object[] {func}) );
			} else {		
				if( res < 0 ) {
					switch( res ) {
					case -1:
						stat = new OperationStatus(
							OperationStatus.FAILURE,
							Messages.getString(
								"com.foo_baz.ihs.errors", 
								"ihsElementExists", new Object[] {administrator.getLogin()}));
						break;
					default:
						stat = new OperationStatus( 
							OperationStatus.FAILURE,
							Messages.getString(
								"com.foo_baz.ihs.errors", 
								"ihsFuncRes", new Object[] {func}) );
					}
				}
			}
		} finally {
			try { if( call!= null) call.close(); } catch( Exception e ) {};
		}
		return stat;
	}
	
	/**
	 * Calls function that removes entry.
	 * @param func function's name
	 * @param id identifier
	 * @return error
	 * @throws SQLException when SQL fails
	 */
	public OperationStatus removeByFunctionAndString( String func, String id ) throws SQLException {
		CallableStatement call = null;
		OperationStatus stat = OperationStatus.SUCCESS;
		
		try {
			call = dbCon.prepareCall("{? = call "+ func +"(?)}");
			int idx = 1;
			call.registerOutParameter(idx++, Types.INTEGER);
			call.setString(idx++, id);
			call.execute();
			
			int res = call.getInt(1);
			boolean wasNull = call.wasNull();
			
			if( wasNull ) {
				stat = new OperationStatus( 
					OperationStatus.FAILURE,
					Messages.getString(
						"com.foo_baz.ihs.errors", 
						"ihsFuncRes", new Object[] {func}) );
			} else {
				if( res != 0 ) {
					switch( res ) {
					case -1:
						stat = new OperationStatus( 
							OperationStatus.FAILURE,
							Messages.getString(
								"com.foo_baz.ihs.errors", 
								"ihsElementMissing", new Object[] {id}) );
						break;
					default:
						stat = new OperationStatus( 
							OperationStatus.FAILURE,
							Messages.getString(
								"com.foo_baz.ihs.errors", 
								"ihsFuncRes", new Object[] {func}) );
					}
				}
			}
		} finally {
			try { if( call!= null) call.close(); } catch( Exception e ) {};
		}
		return stat;
	}
	
	public OperationStatus deleteAdministrator(com.foo_baz.ihs.Administrator administrator) throws SQLException {
		return removeByFunctionAndString( "IHS_ADMINISTRATOR_RM", administrator.getLogin());
	}
	
	public OperationStatus updateAdministrator(com.foo_baz.ihs.Administrator administrator) throws SQLException {
		String func = "IHS_ADMINISTRATOR_CHANGE";
		CallableStatement call = null;
		OperationStatus stat = OperationStatus.SUCCESS;
		
		try {
			call = dbCon.prepareCall("{? = call "+ func +"(?, ?)}");
			int idx = 1;
			call.registerOutParameter(idx++, Types.INTEGER);
			call.setString(idx++, administrator.getLogin());
			call.setString(idx++, administrator.getPassword());
			call.execute();
			
			int res = call.getInt(1);
			boolean wasNull = call.wasNull();
			
			if( wasNull ) {
				stat = new OperationStatus( 
					OperationStatus.FAILURE,
					Messages.getString(
						"com.foo_baz.ihs.errors", 
						"ihsFuncRes", new Object[] {func}) );
			} else {
				if( res < 0 ) {
					switch( res ) {
					case -1:
						stat = new OperationStatus( 
							OperationStatus.FAILURE,
							Messages.getString(
								"com.foo_baz.ihs.errors", 
								"ihsElementMissing", new Object[] {administrator.getLogin()}) );
						break;
					default:
						stat = new OperationStatus( 
							OperationStatus.FAILURE,
							Messages.getString(
								"com.foo_baz.ihs.errors", 
								"ihsFuncRes", new Object[] {func}) );
					}
				}
			}
		} finally {
			try { if( call!= null) call.close(); } catch( Exception e ) {};
		}
		return stat;
	}
	
	/**
	 * Read administrators from storage medium.
	 * @param administrators List of administrators read
	 * @return error
	 * @throws SQLException When SQL query fails
	 */
	public OperationStatus getAdministrators(java.util.ArrayList administrators) throws SQLException {
		PreparedStatement st = null;
		ResultSet res = null;
		
		try {
			st = dbCon.prepareStatement("SELECT login,password FROM ihs_view_administrators ORDER BY login");
			res = st.executeQuery();
			
			administrators.clear();
			
			Administrator admin;
			for( int idx=1; res.next(); idx=1 ) {
				admin = new Administrator();
				admin.setLogin( res.getString(idx++) );
				if( res.wasNull() ) admin.setLogin("");
				admin.setPassword( res.getString(idx++) );
				if( res.wasNull() ) admin.setPassword("");
				
				administrators.add( admin );  
			}
		} finally {
			try { if( res!=null ) res.close(); } catch( Exception e ) {};
			try { if( st!= null) st.close(); } catch( Exception e ) {};
		}
		return OperationStatus.SUCCESS;
	}
	
	/**
	 * Read administrator from storage medium.
	 * @param administrator Administrator, login must be set
	 * @return error
	 * @throws SQLException When SQL query fails
	 */
	public OperationStatus getAdministrator(Administrator administrator) throws SQLException {
		PreparedStatement st = null;
		ResultSet res = null;
		OperationStatus stat = OperationStatus.SUCCESS;
		
		try {
			int idx = 1;
			st = dbCon.prepareStatement("SELECT password FROM ihs_view_administrators WHERE login=? ORDER BY login");
			st.setString(idx++, administrator.getLogin());
			res = st.executeQuery();
			
			if( res.next() ) {
				administrator.setPassword( res.getString(idx++) );
				if( res.wasNull() ) administrator.setPassword("");
			} else {
				stat = new OperationStatus( 
					OperationStatus.FAILURE,
					Messages.getString(
						"com.foo_baz.ihs.errors", 
						"ihsElementMissing", new Object[] {administrator.getLogin()}) );
			}
		} finally {
			try { if( res!=null ) res.close(); } catch( Exception e ) {};
			try { if( st!= null) st.close(); } catch( Exception e ) {};
		}
		return stat;
	}

	Hashtable services = new Hashtable();
	
	/**
	 * @return Returns the services.
	 */
	public Hashtable getServices() {
		return services;
	}
	/**
	 * @param services The services to set.
	 */
	public void setServices(Hashtable services) {
		this.services = services;
	}
	
	public MailService getMailService() throws Exception {
		MailService ser = (MailService) services.get(Service.MAIL_SERVICE);
		if( ser != null && ! ser.isOpen() ) {
			ser.open();
		}
		return ser;
	}
	
	public void setMailService( MailService ms ) {
		services.put(Service.MAIL_SERVICE, ms);
	}
}

