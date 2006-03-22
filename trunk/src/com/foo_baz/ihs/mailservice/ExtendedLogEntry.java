package com.foo_baz.ihs.mailservice;

import com.foo_baz.util.faces.Messages;

/**
 * This class represents
 * @author Pawe� Niewiadomski
 */
public class ExtendedLogEntry extends LogEntry {
	private LogEntry wrappedData;
	private boolean selected = false;
	
	public ExtendedLogEntry() {
		super();
	}
	
	public ExtendedLogEntry( LogEntry obj ) {
		super();
		setWrappedData(obj);
	}
		
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
	
	public String getResultAsString() {
		return Messages.getString("com.foo_baz.ihs.errors", 
			"virtualQmailLoggerResult_"+Integer.toString(getResult()), null);
	}
	
	public String getServiceAsString() {
		return Messages.getString("com.foo_baz.ihs.errors", 
			"virtualQmailLoggerService_"+Integer.toString(getService()), null);
	}
	
	public LogEntry getWrappedData() {
		return wrappedData;
	}
	public void setWrappedData(LogEntry wrappedData) {
		this.wrappedData = wrappedData;
	}
	public String getDomain() {
		return wrappedData.getDomain();
	}
	public String getIdLog() {
		return wrappedData.getIdLog();
	}
	public String getIp() {
		return wrappedData.getIp();
	}
	public String getLogin() {
		return wrappedData.getLogin();
	}
	public String getMessage() {
		return wrappedData.getMessage();
	}
	public short getResult() {
		return wrappedData.getResult();
	}
	public short getService() {
		return wrappedData.getService();
	}
	public String getTime() {
		return wrappedData.getTime();
	}
	public void setDomain(String dom) {
		wrappedData.setDomain(dom);
	}
	public void setIdLog(String id) {
		wrappedData.setIdLog(id);
	}
	public void setIp(String ip) {
		wrappedData.setIp(ip);
	}
	public void setLogin(String log) {
		wrappedData.setLogin(log);
	}
	public void setMessage(String msg) {
		wrappedData.setMessage(msg);
	}
	public void setResult(short res) {
		wrappedData.setResult(res);
	}
	public void setService(short ser) {
		wrappedData.setService(ser);
	}
	public void setTime(String time) {
		wrappedData.setTime(time);
	}
	public void clear() {
		setWrappedData(new LogEntry());
		setSelected(false);
	}
	
}
