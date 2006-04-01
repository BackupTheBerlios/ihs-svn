package com.foo_baz.ihs.backing;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class Configuration {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	Map config = null;
	boolean fromIhs = false;
	
	/**
	 * @return Returns the maxAdministratorsInList.
	 * @throws Exception
	 */
	public int getMaxAdministratorsInList() throws Exception {
		if( ! fromIhs ) readFromIhs();
		String field = "maxAdministratorsInList"; 
		String val = (String) config.get(field);
		if( val == null || "".equals(val) ) {
			val = Messages.getString(
				"com.foo_baz.ihs.configuration", 
				"ihsDefaultConfiguration_"+field, null);
		}
		return val == null ? 0 : Integer.parseInt(val);
	}
	/**
	 * @param maxAdministratorsInList The maxAdministratorsInList to set.
	 */
	public void setMaxAdministratorsInList(int val) {
		String field = "maxAdministratorsInList";
		config.put(field, new Integer(val).toString());
	}
	
	/**
	 * @return Returns the maxDomainsInList.
	 * @throws Exception
	 */
	public int getMaxDomainsInList() throws Exception {
		if( ! fromIhs ) readFromIhs();
		String field = "maxDomainsInList"; 
		String val = (String) config.get(field);
		if( val == null || "".equals(val) ) {
			val = Messages.getString(
				"com.foo_baz.ihs.configuration", 
				"ihsDefaultConfiguration_"+field, null);
		}
		return val == null ? 0 : Integer.parseInt(val);
	}
	/**
	 * @param maxDomainsInList The maxDomainsInList to set.
	 */
	public void setMaxDomainsInList(int val) {
		String field = "maxDomainsInList";
		config.put(field, new Integer(val).toString());
	}
	/**
	 * @return Returns the maxPagesInPager.
	 * @throws Exception
	 */
	public int getMaxPagesInPager() throws Exception {
		if( ! fromIhs ) readFromIhs();
		String field = "maxPagesInPager"; 
		String val = (String) config.get(field);
		if( val == null || "".equals(val) ) {
			val = Messages.getString(
				"com.foo_baz.ihs.configuration", 
				"ihsDefaultConfiguration_"+field, null);
		}
		return val == null ? 0 : Integer.parseInt(val);
	}
	/**
	 * @param maxPagesInPager The maxPagesInPager to set.
	 */
	public void setMaxPagesInPager(int val) {
		String field = "maxPagesInPager";
		config.put(field, new Integer(val).toString());
	}
	/**
	 * @return Returns the maxUsersInList.
	 * @throws Exception
	 */
	public int getMaxUsersInList() throws Exception {
		if( ! fromIhs ) readFromIhs();
		String field = "maxUsersInList"; 
		String val = (String) config.get(field);
		if( val == null || "".equals(val) ) {
			val = Messages.getString(
				"com.foo_baz.ihs.configuration", 
				"ihsDefaultConfiguration_"+field, null);
		}
		return val == null ? 0 : Integer.parseInt(val);
	}
	/**
	 * @param maxUsersInList The maxUsersInList to set.
	 */
	public void setMaxUsersInList(int val) {
		String field = "maxUsersInList";
		config.put(field, new Integer(val).toString());
	}
	/**
	 * @return Returns the maxUsersInList.
	 * @throws Exception
	 */
	public int getMaxLogsInList() throws Exception {
		if( ! fromIhs ) readFromIhs();
		String field = "maxLogsInList"; 
		String val = (String) config.get(field);
		if( val == null || "".equals(val) ) {
			val = Messages.getString(
				"com.foo_baz.ihs.configuration", 
				"ihsDefaultConfiguration_"+field, null);
		}
		return val == null ? 0 : Integer.parseInt(val);
	}
	/**
	 * @param maxUsersInList The maxUsersInList to set.
	 */
	public void setMaxLogsInList(int val) {
		String field = "maxLogsInList";
		config.put(field, new Integer(val).toString());
	}
	/**
	 * @throws Exception
	 * 
	 */
	private void readFromIhs() throws Exception {
		IncredibleHostingSystem adminsDB = null;

		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			
			com.foo_baz.ihs.Configuration ihsConfig = adminsDB.getConfiguration();
			
			config = ihsConfig.getAll();
			fromIhs = true;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQL error", e);
			throw e;
		} catch (NamingException e) {
			logger.log(Level.SEVERE, "JNDI error", e);
			throw e;
		} finally {
			try { adminsDB.close(); } catch (Exception e) {};
		}
	}
	
	/**
	 * 
	 */
	public String reload() {
		fromIhs = false;
		return "";
	}
	
	/**
	 * @throws Exception
	 * 
	 */
	public String update() throws Exception {
		IncredibleHostingSystem adminsDB = null;
		
		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			
			com.foo_baz.ihs.Configuration ihsConfig = adminsDB.getConfiguration();
			
			OperationStatus stat;
			boolean partial = false;
			Set keys = config.keySet();
			Iterator keysIter = keys.iterator();
			String key;
			while( keysIter.hasNext() ) {
				key = (String) keysIter.next();
				stat = ihsConfig.set(key, (String) config.get(key));
				
				if ( ! OperationStatus.SUCCESS.equals(stat) ) {
					logger.info(this.getClass().getName()
						+".update: Error: "+stat.getDescription()
						+" for config: "+key);
					partial = true;
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"configurationUpdatePartial", null));
			} else {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"configurationUpdated", null));
			}
 		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQL error", e);
			throw e;
		} catch (NamingException e) {
			logger.log(Level.SEVERE, "JNDI error", e);
			throw e;
		} finally {
			try { adminsDB.close(); } catch (Exception e) {};
		}
		
		return "";
	}
	
	private String result;
	
	/**
	 * @return Returns the addAdministratorResult.
	 */
	public String getResult() {
		String temp = result;
		result = "";
		return temp;
	}
	/**
	 * @param addAdministratorResult The addAdministratorResult to set.
	 */
	public void setResult(String addAdministratorResult) {
		this.result = addAdministratorResult;
	}	
}
