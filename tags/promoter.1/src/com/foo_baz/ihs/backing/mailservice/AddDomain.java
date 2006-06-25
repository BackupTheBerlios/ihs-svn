package com.foo_baz.ihs.backing.mailservice;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
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
	private String result;
	private HtmlInputText domainInput;
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");
	protected MailServiceSession controller = null;
	
	public AddDomain() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{mailService}");
		controller = (MailServiceSession) binding.getValue(context);

		if( controller.isUpdatingSelectedDomain() )
			readDomain();
	}
	
	protected void readDomain() throws Exception {
		IncredibleHostingSystem usersDB = null;
		this.setIdDomain(controller.getSelectedDomain().getIdDomain());
		try {
			usersDB = new IncredibleHostingSystem();
			usersDB.open();
			
			MailService mailService = usersDB.getMailService();
			
			OperationStatus stat = mailService.getDomain(this);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getUser: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			}
		} finally {
			try { usersDB.close(); } catch (Exception e) {};
		}
	}
	
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
		return commonAddUpdate(controller.isUpdatingSelectedDomain());
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
	
	/**
	 * 
	 * @return action to perform
	 */
	public String cancel() {
		return "cancel";
	}
}
