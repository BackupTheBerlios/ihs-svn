package com.foo_baz.ihs.backing;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.faces.application.Application;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.naming.NamingException;

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.plugin.Plugin;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author: paweln $
 * @version $Id: Configuration.java 180 2006-04-14 19:22:19Z paweln $
 */
public class ConfigurationsPlugins {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	private Map config = null;
	private boolean fromIhs = false;
	private String result;
	
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
				stat = ihsConfig.set(IncredibleHostingSystem.class, key, config.get(key));
				
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
	
	/**
	 * @return Returns the addAdministratorResult.
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param addAdministratorResult The addAdministratorResult to set.
	 */
	public void setResult(String addAdministratorResult) {
		this.result = addAdministratorResult;
	}
	
	public String[] getPlugins() {
		return null;
	}
}
