package com.foo_baz.ihs.backing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;

import com.foo_baz.ihs.Administrator;
import com.foo_baz.ihs.ExtendedAdministrator;
import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class Administrators {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	//@{
	/**
	 * Model representing table
	 */
	AdministratorsDataModel adminsModel;
	
	public DataModel getAdministrators() throws Exception {
		IncredibleHostingSystem adminsDB = null;
		ArrayList admins = new ArrayList();
		ArrayList extAdmins = new ArrayList();
		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			OperationStatus stat = adminsDB.getAdministrators(admins);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getAdministrators: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = admins.iterator();
				for( int i=0; eaIter.hasNext(); ++i ) {
					extAdmins.add(new ExtendedAdministrator((Administrator) eaIter.next()));
				}
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
		adminsModel = new AdministratorsDataModel(new ListDataModel(extAdmins));
		return adminsModel;
	}
	
	/**
	 * 
	 * @return Number of administrators selected for deletion in adminsModel
	 */
	public int getNumberOfAdministratorsSelectedForDeletion() {
		ArrayList admins = (ArrayList) adminsModel.getWrappedData();
		int ret = 0;
		Iterator adminsIter = admins.iterator();
		while( adminsIter.hasNext() ) {
			if( ((ExtendedAdministrator)adminsIter.next()).isSelected() )
				++ret;
		}
		return ret;
	}
	//@}

	//@{
	private String result;
	
	/**
	 * @return Returns the removeAdministratorsResult.
	 */
	public String getResult() {
		String temp = result;
		result = "";
		return temp;
	}
	/**
	 * @param removeAdministratorsResult The removeAdministratorsResult to set.
	 */
	public void setResult(String removeAdministratorsResult) {
		this.result = removeAdministratorsResult;
	}
	
	/**
	 * Removes selected administrators.
	 * @throws Exception
	 */
	public String removeAdministrators() throws Exception {
		int count = getNumberOfAdministratorsSelectedForDeletion();
		if( count == 0 ) {
			return null; // finito, nothing to do
		}
		logger.info("Administrators.removeAdministrators: " +
			"number of administrators selected for deletion: " +
			Integer.toString(count) );

		ArrayList admins = (ArrayList) adminsModel.getWrappedData();
		
		IncredibleHostingSystem adminsDB = null;
		
		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			
			OperationStatus stat;
			boolean partial = false;
			Iterator adminsIter = admins.iterator();
			ExtendedAdministrator curAdmin;
			while( adminsIter.hasNext() ) {
				curAdmin = (ExtendedAdministrator)adminsIter.next();
				if(! curAdmin.isSelected())
					continue;
				
				stat = adminsDB.deleteAdministrator(curAdmin);
				
				if ( ! OperationStatus.SUCCESS.equals(stat) ) {
					logger.info(this.getClass().getName()
						+".removeAdministrators: Error: "+stat.getDescription()
						+" for user: "+curAdmin.getLogin());
					partial = true;
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"administratorsRemovePartial", null));
			} else {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"administratorsRemoved", null));
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
	//@}
	
	/**
	 * 
	 */
	public String addAdministrator() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addAdministrator}");
		AddAdministrator aa = (AddAdministrator) binding.getValue(context);
		aa.clear();
		aa.setUpdating(false);
		return "addAdministrator";
	}
	
	/**
	 * 
	 * @return
	 */
	public String editAdministrator() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addAdministrator}");
		ValueBinding login = app.createValueBinding("#{param.login}");
		AddAdministrator aa = (AddAdministrator) binding.getValue(context);
		aa.clear();
		aa.setLogin((String) login.getValue(context));
		aa.setUpdating(true);
		return "editAdministrator";
	}
}