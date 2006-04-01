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

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.ihs.mailservice.ExtendedDomain;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class Domains {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	//@{
	/**
	 * Model representing table
	 */
	ExtendedDomainsDataModel domainsModel;
	
	public DataModel getDomains() throws Exception {
		IncredibleHostingSystem domainsDB = null;
		ArrayList domains = new ArrayList();
		ArrayList extDomains = new ArrayList();
		try {
			domainsDB = new IncredibleHostingSystem();
			domainsDB.open();
			
			MailService mailService = domainsDB.getMailService();
			
			OperationStatus stat = mailService.getDomains(domains);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getDomains: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = domains.iterator();
				
				for( int i=0; eaIter.hasNext(); ++i ) {
					ExtendedDomain eobj = new ExtendedDomain( (Domain) eaIter.next() );
				
					IntHolder cnt = new IntHolder(0);
					stat = mailService.getNumberOfUsersInDomain(
						eobj.getIdDomain(), cnt);
					if( OperationStatus.SUCCESS.equals(stat) ) {
						eobj.setNumberOfUsers(cnt.value);
					}
					
					extDomains.add(eobj);
				}
			}
		} finally {
			try { domainsDB.close(); } catch (Exception e) {};
		}
		domainsModel = new ExtendedDomainsDataModel(new ListDataModel(extDomains));
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_mailService}");
		((MailServiceSession) binding.getValue(context)).getDomainsSorting().sortDataModel(domainsModel);
		return domainsModel;
	}
	
	/**
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
		
		IncredibleHostingSystem domainsDB = null;
		try {
			domainsDB = new IncredibleHostingSystem();
			domainsDB.open();
			
			MailService mailService = domainsDB.getMailService();
			
			boolean partial = false;
			Iterator domainsIter = domains.iterator();
			ExtendedDomain curDomain;
			while( domainsIter.hasNext() ) {
				curDomain = (ExtendedDomain)domainsIter.next();
				if(! curDomain.isSelected())
					continue;
				
				OperationStatus stat = mailService.removeDomain(
					curDomain.getIdDomain());
				
				if ( ! OperationStatus.SUCCESS.equals(stat) ) {
					logger.info(this.getClass().getName()
						+".removeDomains: Error: "+stat.getDescription()
						+" for element: "+curDomain.getDomain());
					partial = true;
				}	
			}
			if( partial ) {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"mailServiceDomainsRemovePartial", null));
			} else {
				this.setResult(
					Messages.getString(
						"com.foo_baz.ihs.messages", 
						"mailServiceDomainsRemoved", null));
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
		return "";
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
		aa.clear();
		aa.setUpdating(false);
		return "addDomain";
	}
	
	/**
	 * 
	 * @return
	 */
	public String editDomain() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_addDomain}");
		ValueBinding idDomain = app.createValueBinding("#{param.idDomain}");
		
		Domain dom = new Domain();
		dom.setIdDomain(Integer.parseInt((String) idDomain.getValue(context)));
		String act = fillNameOfDomain(dom);
		if( ! act.equals("") ) return act;
		
		AddDomain aa = (AddDomain) binding.getValue(context);
		aa.clear();
		aa.setDomain(dom.getDomain());
		aa.setIdDomain(dom.getIdDomain());
		aa.setUpdating(true);
		return "editDomain";
	}
	
	/**
	 * 
	 * @return
	 */
	public String listUsers() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_users}");
		ValueBinding idDomain = app.createValueBinding("#{param.idDomain}");
		Domain dom = new Domain();
		dom.setIdDomain(Integer.parseInt((String) idDomain.getValue(context)));
		String act = fillNameOfDomain(dom);
		if( ! act.equals("") ) return act;
		
		Users aa = (Users) binding.getValue(context);
		aa.setIdDomain(dom.getIdDomain());
		aa.setDomain(dom.getDomain());
		return "listUsers";
	}
	
	/**
	 * @throws Exception
	 */
	public String fillNameOfDomain( Domain dom ) throws Exception {
		IncredibleHostingSystem domainsDB = null;
		try {
			domainsDB = new IncredibleHostingSystem();
			domainsDB.open();
			
			MailService mailService = domainsDB.getMailService();
			
			OperationStatus stat = mailService.getNameOfDomain( dom );
				
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".fillNameOfDomain: Error: "+stat.getDescription()
					+" for element: "+dom.getIdDomain());
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
		return "";
	}

}