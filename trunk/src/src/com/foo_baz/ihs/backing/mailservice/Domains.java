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

import org.omg.CORBA.IntHolder;

import com.foo_baz.ihs.ErrorCode;
import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.ihs.mailservice.ExtendedDomain;
import com.foo_baz.util.faces.Messages;

public class Domains {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	//@{
	/**
	 * Model representing table
	 */
	ListDataModel domainsModel;
	
	public DataModel getDomains() throws Exception {
		IncredibleHostingSystem domainsDB = null;
		ArrayList domains = new ArrayList();
		ArrayList extDomains = new ArrayList();
		try {
			domainsDB = new IncredibleHostingSystem();
			domainsDB.open();
			
			MailService mailService = domainsDB.getMailService();
			
			int res = mailService.getDomains(domains).errorCode.value;
			if ( res != ErrorCode.ERR_NO) {
				logger.info(this.getClass().getName()
					+".getDomains: Returned code: "+Integer.toString(res));
			} else {
				Iterator eaIter = domains.iterator();
				
				for( int i=0; eaIter.hasNext(); ++i ) {
					ExtendedDomain ea = new ExtendedDomain((Domain)eaIter.next());
					ea.setOrder(i);
				
					IntHolder cnt = new IntHolder(0);
					res = mailService.getNumberOfUsersInDomain(
						ea.getIdDomain(), cnt).errorCode.value;
					if( res == ErrorCode.ERR_NO ) {
						ea.setNumberOfUsers(cnt.value);
					}
					
					extDomains.add(ea);
				}
			}
		} finally {
			try { domainsDB.close(); } catch (Exception e) {};
		}
		domainsModel = new ListDataModel(extDomains);
		return domainsModel;
	}
	
	/**
	 * 
	 * @return Number of administrators selected for deletion in domainsModel
	 */
	public int getNumberOfDomainsSelectedForDeletion() {
		ArrayList domains = (ArrayList) domainsModel.getWrappedData();
		int ret = 0;
		Iterator domainsIter = domains.iterator();
		while( domainsIter.hasNext() ) {
			if( ((ExtendedDomain)domainsIter.next()).isSelected() )
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
	public String removeDomains() throws Exception {
		int count = getNumberOfDomainsSelectedForDeletion();
		if( count == 0 ) {
			return null; // finito, nothing to do
		}
		logger.info(this.getClass().getName()+".removeDomains: " +
			"number of elements selected for deletion: " +
			Integer.toString(count) );

		ArrayList domains = (ArrayList) domainsModel.getWrappedData();
		int ret = 0;
		
		IncredibleHostingSystem domainsDB = null;
		try {
			domainsDB = new IncredibleHostingSystem();
			domainsDB.open();
			
			MailService mailService = domainsDB.getMailService();
			
			int res;
			boolean partial = false;
			Iterator domainsIter = domains.iterator();
			ExtendedDomain curDomain;
			while( domainsIter.hasNext() ) {
				curDomain = (ExtendedDomain)domainsIter.next();
				if(! curDomain.isSelected())
					continue;
				
				res = mailService.removeDomain(
					curDomain.getIdDomain()).errorCode.value;
				
				if ( res == ErrorCode.ERR_NO) {
					this.setResult(
						Messages.getString(
							"com.foo_baz.ihs.messages", 
							"mailServiceDomainsRemoved", null));
				} else {
					logger.info(this.getClass().getName()
						+".removeDomains: Returned code: "+Integer.toString(res)
						+" for element: "+curDomain.getDomain());
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", "mailServiceDomainsRemovePartial", null));
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
		return "reload";
	}
	//@}
	
	/**
	 * 
	 */
	public String addDomain() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addDomain}");
		AddDomain aa = (AddDomain) binding.getValue(context);
		aa.setDomain("");
		aa.setUpdating(false);
		return "addDomain";
	}
	
	/**
	 * 
	 * @return
	 */
	public String editDomain() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addDomain}");
		ValueBinding domain = app.createValueBinding("#{param.domain}");
		ValueBinding idDomain = app.createValueBinding("#{param.idDomain}");
		AddDomain aa = (AddDomain) binding.getValue(context);
		aa.setDomain((String) domain.getValue(context));
		aa.setIdDomain(Integer.parseInt((String) idDomain.getValue(context)));
		aa.setUpdating(true);
		return "editDomain";
	}
	
	/**
	 * 
	 * @return
	 */
	public String listUsers() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_users}");
		ValueBinding idDomain = app.createValueBinding("#{param.idDomain}");
		Users aa = (Users) binding.getValue(context);
		aa.setIdDomain(Integer.parseInt((String) idDomain.getValue(context)));
		return "listUsers";
	}
}