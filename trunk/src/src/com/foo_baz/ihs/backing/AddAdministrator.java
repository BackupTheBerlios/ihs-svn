package com.foo_baz.ihs.backing;
//import javax.faces.component.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.*;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;

import com.foo_baz.ihs.Administrator;
import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.util.faces.Messages;
import com.foo_baz.v_q.ivqPackage.err_code;

public class AddAdministrator extends Administrator {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");
	
	private HtmlMessage addAdministratorLoginMessage;

	public void setAddAdministratorLoginMessage(HtmlMessage message1) {
		this.addAdministratorLoginMessage = message1;
	}

	public HtmlMessage getAddAdministratorLoginMessage() {
		return addAdministratorLoginMessage;
	}

	private HtmlInputSecret addAdministratorPasswordInput;

	public void setAddAdministratorPasswordInput(HtmlInputSecret inputText1) {
		this.addAdministratorPasswordInput = inputText1;
	}

	public HtmlInputSecret getAddAdministratorPasswordInput() {
		return addAdministratorPasswordInput;
	}

	private HtmlInputSecret addAdministratorPasswordConfirmInput;

	public void setAddAdministratorPasswordConfirmInput(HtmlInputSecret inputSecret1) {
		this.addAdministratorPasswordConfirmInput = inputSecret1;
	}

	public HtmlInputSecret getAddAdministratorPasswordConfirmInput() {
		return addAdministratorPasswordConfirmInput;
	}

	//@{
	private HtmlMessage validatePasswordConfirmMessage;

	public void setValidatePasswordConfirmMessage(HtmlMessage message1) {
		this.validatePasswordConfirmMessage = message1;
	}

	public HtmlMessage getValidatePasswordConfirmMessage() {
		return validatePasswordConfirmMessage;
	}
	
	public void validatePasswordConfirm( FacesContext context, 
			UIComponent component, Object value) throws ValidatorException {
	
		if(addAdministratorPasswordInput == null 
			&& value == null) {
			logger.finest("validatePasswordConfirm: both are nulls");
			return;
		}
		
		String pass = null;
		if(addAdministratorPasswordInput != null) {
			pass = (String)addAdministratorPasswordInput.getLocalValue();
		}
		if( pass == null ) pass = "";
		if( value == null ) value = "";
		
		//logger.finest("validatePasswordConfirm: password: "+(pass==null ? "null" : pass));
		//logger.finest("validatePasswordConfirm: password confirmation: "+(value==null ? "null" : (String)value));
		
		if( ! pass.equals(value) ) {
			FacesMessage message = Messages.getMessage("com.foo_baz.ihs.messages", "addAdministratorPasswordConfirmMismatch", null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);	
		}
	}
	//@}
	
	//@{
	protected String commonAddUpdate( boolean updating ) throws Exception {
		IncredibleHostingSystem adminsDB = null;
		
		String ret = "success";
		
		try {
			adminsDB = new IncredibleHostingSystem();
			adminsDB.open();
			
			logger.info(this.getClass().getName()
					+".addAdministrator: going to: "+(updating ? "update" : "add"));
			
			err_code res = updating ? 
				adminsDB.updateAdministrator(this).ec
				: adminsDB.addAdministrator(this).ec; 
			if ( res == err_code.err_no ) {
				this.setResult(
						Messages.getString(
							"com.foo_baz.ihs.messages", 
							updating ? "addAdministratorUpdated" : "addAdministratorAdded", null));
				if( ! updating )
					this.clear();
			} else {
				logger.info(this.getClass().getName()
					+".addAdministrator: Returned code: "+Integer.toString(res.value()));
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.errors", 
						"error_"+Integer.toString(res.value()), null));
				ret = "error";
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
		return ret;
	}
	
	public String addAdministrator() throws Exception {
		return commonAddUpdate(isUpdating());
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
	
	//@}

	//@{
	private boolean updating = false;
	
	/**
	 * @return Returns the updating.
	 */
	public boolean isUpdating() {
		return updating;
	}
	/**
	 * @param updating The updating to set.
	 */
	public void setUpdating(boolean updating) {
		this.updating = updating;
	}
	
	/**
	 * 
	 * @return action to perform
	 */
	public String cancel() {
		clear();
		setUpdating(false);
		return "cancel";
	}
}