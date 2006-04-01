package com.foo_baz.ihs.backing.mailservice;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.ExtendedDomain;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class AddDomain extends ExtendedDomain {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");
	
	private HtmlInputText domainInput;

	/**
	 * @return Returns the domainInput.
	 */
	public HtmlInputText getDomainInput() {
		return domainInput;
	}
	/**
	 * @param domainInput The domainInput to set.
	 */
	public void setDomainInput(HtmlInputText domainInput) {
		this.domainInput = domainInput;
	}

	public void validateDomain( FacesContext context, 
			UIComponent component, Object value) throws ValidatorException {
	
		if(domainInput == null 
			&& value == null) {
			logger.finest("validateDomain: both are nulls");
			return;
		}
		
		/*
		if( ! pass.equals(value) ) {
			FacesMessage message = Messages.getMessage("com.foo_baz.ihs.messages", "addAdministratorPasswordConfirmMismatch", null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);	
		}*/
	}
	
	protected String commonAddUpdate( boolean updating ) throws Exception {
		String ret = "success";
		
		IncredibleHostingSystem domainsDB = null;
		try {
			domainsDB = new IncredibleHostingSystem();
			domainsDB.open();
			
			MailService mailService = domainsDB.getMailService();
			
			logger.info(this.getClass().getName()
				+".addDomain: going to: "+(updating ? "update" : "add"));
			
			OperationStatus stat = updating ? 
				mailService.updateDomain(this)
				: mailService.addDomain(this); 
			if ( OperationStatus.SUCCESS.equals(stat) ) {
				this.setResult(
						Messages.getString(
							"com.foo_baz.ihs.messages", 
							updating ? "mailServiceAddDomainUpdated" : "mailServiceAddDomainAdded", null));
				if( ! updating )
					this.clear();
			} else {
				logger.info(this.getClass().getName()
					+".addDomain: Error: "+stat.getDescription());
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
			try { domainsDB.close(); } catch (Exception e) {};
		}
		return ret;
	}
	
	public String addDomain() throws Exception {
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
