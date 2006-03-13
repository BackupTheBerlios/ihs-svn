package com.foo_baz.ihs.backing.mailservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.foo_baz.ihs.IncredibleHostingSystem;
import com.foo_baz.ihs.MailService;
import com.foo_baz.ihs.mailservice.ExtendedLogEntry;
import com.foo_baz.ihs.mailservice.LogEntry;
import com.foo_baz.util.OperationStatus;

public class Logs {
	protected Logger logger = Logger.getLogger("com.foo_baz.ihs");

	/**
	 * Model representing table
	 */
	ListDataModel logsModel;
	
	public DataModel getLogs() throws Exception {
		IncredibleHostingSystem logsDB = null;
		ArrayList logs = new ArrayList();
		ArrayList extLogs = new ArrayList();
		try {
			logsDB = new IncredibleHostingSystem();
			logsDB.open();
			
			MailService mailService = logsDB.getMailService();
			
			OperationStatus stat = mailService.getLogs(0, 0, logs);
			if ( ! OperationStatus.SUCCESS.equals(stat) ) {
				logger.info(this.getClass().getName()
					+".getLogs: Error: "+stat.getDescription());
				this.setResult(stat.getDescription());
			} else {
				Iterator eaIter = logs.iterator();
				
				for( int i=0; eaIter.hasNext(); ++i ) {
					ExtendedLogEntry ea = new ExtendedLogEntry((LogEntry)eaIter.next());
					extLogs.add(ea);
				}
			}
		} finally {
			try { logsDB.close(); } catch (Exception e) {};
		}
		logsModel = new ListDataModel(extLogs);
		return logsModel;
	}
	
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