package com.foo_baz.ihs.backing.mailservice;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.User;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class AddUser extends User {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");
	private HtmlInputSecret passwordInput;
	private HtmlInputSecret passwordConfirmInput;
	private String result;
	private boolean defaultDir = true;
	protected MailServiceSession controller = null;

	public AddUser() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{mailService}");
		controller = (MailServiceSession) binding.getValue(context);

		setIdDomain(controller.getSelectedDomain().getIdDomain());
		setDomain(controller.getSelectedDomain().getDomain());
		if( controller.isUpdatingSelectedUser() )
			readUser();
	}
	
	protected void readUser() throws Exception {
		IncredibleHostingSystem usersDB = null;
		this.setLogin(controller.getSelectedUser().getLogin());
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();
			
			OperationStatus stat = mailService.getUser(this);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getUser: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			}
		} finally {
			try { usersDB.close(); } catch (Exception e) {};
			setPassword("");
			setDefaultDir(false);
		}
	}

	public void setPasswordInput(HtmlInputSecret inputText1) {
		this.passwordInput = inputText1;
	}

	public HtmlInputSecret getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordConfirmInput(HtmlInputSecret inputSecret1) {
		this.passwordConfirmInput = inputSecret1;
	}

	public HtmlInputSecret getPasswordConfirmInput() {
		return passwordConfirmInput;
	}

	public void validatePasswordConfirm( FacesContext context, 
			UIComponent component, Object value) throws ValidatorException {
	
		if(passwordInput == null 
			&& value == null) {
			logger.finest("validatePasswordConfirm: both are nulls");
			return;
		}
		
		String pass = null;
		if(passwordInput != null) {
			pass = (String)passwordInput.getLocalValue();
		}
		if( pass == null ) pass = "";
		if( value == null ) value = "";
		
		//logger.finest("validatePasswordConfirm: password: "+(pass==null ? "null" : pass));
		//logger.finest("validatePasswordConfirm: password confirmation: "+(value==null ? "null" : (String)value));
		
		if( ! pass.equals(value) ) {
			FacesMessage message = Messages.getMessage("com.foo_baz.ihs.messages", "addUserPasswordConfirmMismatch", null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);	
		}
	}

	protected String commonAddUpdate( boolean updating ) throws Exception {
		IncredibleHostingSystem usersDB = null;
		
		String ret = "success";
		
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();

			logger.info(this.getClass().getName()
					+".addUser: going to: "+(updating ? "update" : "add"));
			
			if( isDefaultDir() ) {
				setDir("");
			}
			
			OperationStatus stat = updating ? 
				mailService.updateUser(this, ! getPassword().equals(""), true)
				: mailService.addUser(this); 
			if ( OperationStatus.SUCCESS.equals(stat) ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						updating ? "mailServiceAddUserUpdated" : "mailServiceAddUserAdded", null));
				if( ! updating ) {
					User au = (User) this.clone();
					this.clear();
					this.setDomain(au.getDomain());
					this.setIdDomain(au.getIdDomain());
				}
			} else {
				logger.info(this.getClass().getName()
					+".addUser: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
				ret = "error";
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
		return ret;
	}
	
	public String addUser() throws Exception {
		return commonAddUpdate(controller.isUpdatingSelectedUser());
	}

	/**
	 * @return Returns the addUserResult.
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param addUserResult The addUserResult to set.
	 */
	public void setResult(String addUserResult) {
		this.result = addUserResult;
	}	
	
	/**
	 * 
	 * @return action to perform
	 */
	public String cancel() {
		return "cancel";
	}
	
	/**
	 * @return Returns the defaultDir.
	 */
	public boolean isDefaultDir() {
		return defaultDir;
	}
	/**
	 * @param defaultDir The defaultDir to set.
	 */
	public void setDefaultDir(boolean defaultDir) {
		this.defaultDir = defaultDir;
	}
	
	/**
	 * 
	 */
	public void defaultDirChanged( ValueChangeEvent event ) {
		defaultDir = ((Boolean)event.getNewValue()).booleanValue();
		FacesContext.getCurrentInstance().renderResponse();
	}
}