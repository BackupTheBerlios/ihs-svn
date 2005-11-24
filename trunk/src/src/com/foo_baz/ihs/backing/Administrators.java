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
import com.foo_baz.ihs.ErrorCode;
import com.foo_baz.ihs.ExtendedAdministrator;
import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.util.faces.Messages;

public class Administrators {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	//@{
	/**
	 * Model representing table
	 */
	ListDataModel adminsModel;
	
	public DataModel getAdministrators() throws Exception {
		IncredibleHostingSystem adminsDB = null;
		ArrayList admins = new ArrayList();
		ArrayList extAdmins = new ArrayList();
		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			int res = adminsDB.getAdministrators(admins).errorCode.value;
			if ( res != ErrorCode.ERR_NO) {
				logger.info(this.getClass().getName()
					+".getAdministrators: Returned code: "+Integer.toString(res));
			} else {
				Iterator eaIter = admins.iterator();
				for( int i=0; eaIter.hasNext(); ++i ) {
					ExtendedAdministrator ea = new ExtendedAdministrator((Administrator)eaIter.next());
					ea.setOrder(i);
					extAdmins.add(ea);
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
		adminsModel = new ListDataModel(extAdmins);
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
		int ret = 0;
		
		IncredibleHostingSystem adminsDB = null;
		
		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			
			int res;
			boolean partial = false;
			Iterator adminsIter = admins.iterator();
			ExtendedAdministrator curAdmin;
			while( adminsIter.hasNext() ) {
				curAdmin = (ExtendedAdministrator)adminsIter.next();
				if(! curAdmin.isSelected())
					continue;
				
				res = adminsDB.deleteAdministrator(curAdmin).errorCode.value;
				
				if ( res == ErrorCode.ERR_NO) {
					this.setResult(
						Messages.getString(
							"com.foo_baz.ihs.messages", 
							"administratorsRemoved", null));
				} else {
					logger.info(this.getClass().getName()
						+".removeAdministrators: Returned code: "+Integer.toString(res)
						+" for user: "+curAdmin.getLogin());
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", "administratorsRemovePartial", null));
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
		
		//adminsModel = (ListDataModel)getAdministrators();
		return "reload";
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
		aa.setLogin("");
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
		aa.setLogin((String) login.getValue(context));
		aa.setUpdating(true);
		return "editAdministrator";
	}
}