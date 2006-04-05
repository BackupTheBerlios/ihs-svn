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
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class Users {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");
	protected MailServiceSession controller;

	public Users() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{mailService}");
		controller = (MailServiceSession) binding.getValue(context);

		readUsers();
	}
	
	protected void readUsers() throws Exception {
		IncredibleHostingSystem usersDB = null;
		ArrayList users = new ArrayList();
		ArrayList extUsers = new ArrayList();
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();
			
			OperationStatus stat = mailService.getUsersInDomain(
				controller.getCurrentDomain().getIdDomain(), 0, 0, users);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getUsers: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = users.iterator();
				
				for( int i=0; eaIter.hasNext(); ++i ) {
					extUsers.add(new ExtendedUser((User)eaIter.next()));
				}
			}
		} finally {
			try { usersDB.close(); } catch (Exception e) {};
		}
		usersModel = new UsersDataModel(new ListDataModel(extUsers));
	}
	
	/**
	 * Model representing table
	 */
	private UsersDataModel usersModel;
	
	public DataModel getUsers() {
		controller.getUsersSorting().sortDataModel(usersModel);
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

	private String result;
	
	/**
	 * @return Returns the result.
	 */
	public String getResult() {
		return result;
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
				
		IncredibleHostingSystem usersDB = null;
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();
			
			OperationStatus stat;
			boolean partial = false;
			Iterator usersIter = users.iterator();
			ExtendedUser curUser;
			while( usersIter.hasNext() ) {
				curUser = (ExtendedUser)usersIter.next();
				if(! curUser.isSelected())
					continue;
				
				stat = mailService.removeUser(
					curUser.getIdDomain(), curUser.getLogin());
				
				if ( ! OperationStatus.SUCCESS.equals(stat) ) {
					logger.info(this.getClass().getName()
						+".removeUsers: Error: "+stat.getDescription()
						+" for element: "+curUser.getDomain());
					partial = true;
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"mailServiceUsersRemovePartial", null));
			} else {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"mailServiceUsersRemoved", null));
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
		readUsers();
		return "";
	}
	
	/**
	 * 
	 */
	public String addUser() {
		controller.setUpdatingCurrentUser(false);
		return "addUser";
	}
	
	/**
	 * 
	 * @return
	 */
	public String editUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding login = app.createValueBinding("#{param.login}");
		User user = new User();
		user.setLogin((String) login.getValue(context));
		user.setIdDomain(controller.getCurrentDomain().getIdDomain());
		user.setDomain(controller.getCurrentDomain().getDomain());
		controller.setCurrentUser(user);
		controller.setUpdatingCurrentUser(true);
		return "editUser";
	}
}
