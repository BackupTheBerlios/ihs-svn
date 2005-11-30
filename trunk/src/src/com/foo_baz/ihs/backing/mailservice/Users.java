package com.foo_baz.ihs.backing.mailservice;

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

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.ExtendedUser;
import com.foo_baz.ihs.mailservice.User;
import com.foo_baz.util.faces.Messages;
import com.foo_baz.v_q.ivqPackage.err_code;

public class Users {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	//@{
	/**
	 * Model representing table
	 */
	ListDataModel usersModel;
	
	public DataModel getUsers() throws Exception {
		IncredibleHostingSystem usersDB = null;
		ArrayList users = new ArrayList();
		ArrayList extUsers = new ArrayList();
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();
			
			err_code res = mailService.getUsersInDomain(getIdDomain(), 
				0, 0, users).ec;
			if ( res != err_code.err_no ) {
				logger.info(this.getClass().getName()
					+".getUsers: Returned code: "+Integer.toString(res.value()));
			} else {
				Iterator eaIter = users.iterator();
				
				for( int i=0; eaIter.hasNext(); ++i ) {
					ExtendedUser ea = new ExtendedUser((User)eaIter.next());
					extUsers.add(ea);
				}
			}
		} finally {
			try { usersDB.close(); } catch (Exception e) {};
		}
		usersModel = new ListDataModel(extUsers);
		return usersModel;
	}
	
	/**
	 * 
	 * @return Number of administrators selected for deletion in usersModel
	 */
	public int getNumberOfUsersSelectedForDeletion() {
		ArrayList users = (ArrayList) usersModel.getWrappedData();
		int ret = 0;
		Iterator usersIter = users.iterator();
		while( usersIter.hasNext() ) {
			if( ((ExtendedUser)usersIter.next()).isSelected() )
				++ret;
		}
		return ret;
	}
	//@}

	//@{
	private String result;
	
	/**
	 * @return Returns the result.
	 */
	public String getResult() {
		String temp = result;
		result = "";
		return temp;
	}
	/**
	 * @param result The result to set.
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Removes selected administrators.
	 * @throws Exception
	 */
	public String removeUsers() throws Exception {
		int count = getNumberOfUsersSelectedForDeletion();
		if( count == 0 ) {
			return null; // finito, nothing to do
		}
		logger.info(this.getClass().getName()+".removeUsers: " +
			"number of elements selected for deletion: " +
			Integer.toString(count) );

		ArrayList users = (ArrayList) usersModel.getWrappedData();
		int ret = 0;
		
		IncredibleHostingSystem usersDB = null;
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();
			
			err_code res;
			boolean partial = false;
			Iterator usersIter = users.iterator();
			ExtendedUser curUser;
			while( usersIter.hasNext() ) {
				curUser = (ExtendedUser)usersIter.next();
				if(! curUser.isSelected())
					continue;
				
				res = mailService.removeUser(
					curUser.getIdDomain(), curUser.getLogin()).ec;
				
				if ( res == err_code.err_no ) {
					this.setResult(
						Messages.getString(
							"com.foo_baz.ihs.messages", 
							"mailServiceUsersRemoved", null));
				} else {
					logger.info(this.getClass().getName()
						+".removeUsers: Returned code: "+Integer.toString(res.value())
						+" for element: "+curUser.getDomain());
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", "mailServiceUsersRemovePartial", null));
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQL error", e);
			throw e;
		} catch (NamingException e) {
			logger.log(Level.SEVERE, "JNDI error", e);
			throw e;
		} finally {
			try { usersDB.close(); } catch (Exception e) {};
		}
		return "reload";
	}
	//@}
	
	/**
	 * 
	 */
	public String addUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addUser}");
		AddUser aa = (AddUser) binding.getValue(context);
		aa.clear();
		aa.setIdDomain(getIdDomain());
		aa.setDomain(getDomain());
		aa.setUpdating(false);
		return "addUser";
	}
	
	/**
	 * 
	 * @return
	 */
	public String editUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addUser}");
		ValueBinding login = app.createValueBinding("#{param.login}");
		AddUser aa = (AddUser) binding.getValue(context);
		aa.clear();
		aa.setLogin((String) login.getValue(context));
		aa.setIdDomain(getIdDomain());
		aa.setDomain(getDomain());
		aa.setUpdating(true);
		return "editUser";
	}
	
	private int idDomain;
	
	/**
	 * @return Returns the idDomain.
	 */
	public int getIdDomain() {
		return idDomain;
	}
	/**
	 * @param idDomain The idDomain to set.
	 */
	public void setIdDomain(int idDomain) {
		this.idDomain = idDomain;
	}
	
	String domain;
	
	/**
	 * @return Returns the domain.
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain The domain to set.
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
}