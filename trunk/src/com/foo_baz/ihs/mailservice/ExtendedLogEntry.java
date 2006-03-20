package com.foo_baz.ihs.mailservice;

import com.foo_baz.util.faces.Messages;

/**
 * This class represents
 * @author Pawe� Niewiadomski
 */
public class ExtendedLogEntry extends LogEntry {
	public ExtendedLogEntry() {
		super();
	}
	
	/**
	 * Creates copy of passed object
	 */
	public ExtendedLogEntry( LogEntry obj ) {
		this();
		LogEntry tmpObj = (LogEntry) obj.clone();
		setIdLog(tmpObj.getIdLog());
		setTime(tmpObj.getTime());
		setService(tmpObj.getService());
		setMessage(tmpObj.getMessage());
		setLogin(tmpObj.getLogin());
		setDomain(tmpObj.getDomain());
		setIp(tmpObj.getIp());
		setResult(tmpObj.getResult());
	}
	
	//@{
	private boolean selected = false;
		
	/**
	 * @return Returns the selected.
	 */
	public boolean isSelected() {
		return selected;
	}
	/**
	 * @param selected The selected to set.
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	//@}
	
	public String getResultAsString() {
		return Messages.getString("com.foo_baz.ihs.errors", 
			"virtualQmailLoggerResult_"+Integer.toString(getResult()), null);
	}
	
	public String getServiceAsString() {
		return Messages.getString("com.foo_baz.ihs.errors", 
			"virtualQmailLoggerService_"+Integer.toString(getService()), null);
	}
}
