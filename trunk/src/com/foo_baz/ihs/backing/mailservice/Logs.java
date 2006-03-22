package com.foo_baz.ihs.backing.mailservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.ExtendedLogEntry;
import com.foo_baz.ihs.mailservice.LogEntry;
import com.foo_baz.util.OperationStatus;
import com.foo_baz.util.faces.Messages;

public class Logs {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	/**
	 * Model representing table
	 */
	protected ExtendedLogsDataModel logsModel = null;
	protected SelectItem [] domains = null;
	protected SelectItem [] services = null;
	protected SelectItem [] results = null;
	private String serviceType = "";
	private String resultType = "";
	private String domain = "";
	private String result = "";
	
	public Logs() throws Exception {
		IncredibleHostingSystem logsDB = null;
		ArrayList logs = new ArrayList();
		ArrayList extLogs = new ArrayList();
		
		domains = new SelectItem[1];
		domains[0] = new SelectItem("", "");
		services = new SelectItem[1];
		services[0] = new SelectItem("", "");
		results = new SelectItem[1];
		results[0] = new SelectItem("", "");
		
		try {
			logsDB = new IncredibleHostingSystem();
			logsDB.open();
			
			MailService mailService = logsDB.getMailService();
			
			// get logs
			OperationStatus stat = null;
			if("".equals(getDomain())) { 
				stat = mailService.getLogs(0, 0, logs);
			} else {
				stat = mailService.getLogsByDomain(getDomain(), 0, 0, logs);
			}
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getLogs: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = logs.iterator();
				
				for( int i=0; eaIter.hasNext(); ++i ) {
					ExtendedLogEntry ea = new ExtendedLogEntry((LogEntry) eaIter.next());
					
					if( ! "".equals(getServiceType())
						&& ! getServiceType().equals(new Short(ea.getService()).toString())) {
						continue;
					}
					
					if( ! "".equals(getResultType())
						&& ! getResultType().equals(new Short(ea.getResult()).toString())) {
						continue;
					}
					
					extLogs.add(ea);
				}
			}
			
			// get results
			ArrayList itemsList = new ArrayList();
			stat = mailService.getResultsInLogs(itemsList);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getResultsInLogs: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = itemsList.iterator();
				
				results = new SelectItem[itemsList.size()+1];
				results[0] = new SelectItem("", "");
				for( int i=1; eaIter.hasNext(); ++i ) {
					String cur = eaIter.next().toString();
					results[i] = new SelectItem(cur, 
						Messages.getString("com.foo_baz.ihs.errors", 
							"virtualQmailLoggerResult_"+cur, null ));
				}
			}
			
			// get domains
			itemsList = new ArrayList();
			stat = mailService.getDomainsInLogs(itemsList);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getDomainsInLogs: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = itemsList.iterator();
				
				domains = new SelectItem[itemsList.size()+1];
				domains[0] = new SelectItem("", "");
				for( int i=1; eaIter.hasNext(); ++i ) {
					String cur = (String) eaIter.next();
					domains[i] = new SelectItem(cur, cur);
				}
			}
			
			// get services
			itemsList = new ArrayList();
			stat = mailService.getServicesInLogs(itemsList);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getServicesInLogs: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = itemsList.iterator();
				
				services = new SelectItem[itemsList.size()+1];
				services[0] = new SelectItem("", "");
				for( int i=1; eaIter.hasNext(); ++i ) {
					String cur = eaIter.next().toString();
					services[i] = new SelectItem(cur, 
						Messages.getString("com.foo_baz.ihs.errors", 
							"virtualQmailLoggerService_"+cur, null ));
				}
			}
		} finally {
			try { logsDB.close(); } catch (Exception e) {};
		}
		logsModel = new ExtendedLogsDataModel(new ListDataModel(extLogs));
	}
	
	public DataModel getLogs() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{backing_mailService}");
		((MailServiceSession) binding.getValue(context)).getLogsSorting().sortDataModel(logsModel);
		return logsModel;
	}
	
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
	
	public SelectItem[] getDomains() {
		return domains;
	}
	
	public SelectItem[] getServices() {
		return services;
	}
	
	public SelectItem[] getResults() {
		return results;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String val) {
		if( ! "".equals(val) ) {
			try {
				Integer.parseInt(val);
			} catch (NumberFormatException e) {
				val = "";
			}
		}
		this.serviceType = val;
	}
	
	/**
	 * 
	 */
	public void serviceTypeChanged( ValueChangeEvent event ) {
		setServiceType((String)event.getNewValue());
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public String getResultType() {
		return resultType;
	}
	
	public void setResultType(String val) {
		if( ! "".equals(val) ) {
			try {
				Integer.parseInt(val);
			} catch (NumberFormatException e) {
				val = "";
			}
		}
		this.resultType = val;
	}
	
	/**
	 * 
	 */
	public void resultTypeChanged( ValueChangeEvent event ) {
		setResultType((String)event.getNewValue());
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	/**
	 * 
	 */
	public void domainChanged( ValueChangeEvent event ) {
		setDomain((String)event.getNewValue());
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	/**
	 * 
	 */
	public boolean isIpRendered() {
		return true;
	}
	
	public boolean isMessageRendered() {
		return true;
	}
	
	public boolean isLoginRendered() {
		return true;
	}
	
	public boolean isDomainRendered() {
		return "".equals(getDomain());
	}
	
	public boolean isServiceRendered() {
		return "".equals(getServiceType());
	}
	
	public boolean isResultRendered() {
		return "".equals(getResultType());
	}
}