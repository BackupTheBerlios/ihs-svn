package com.foo_baz.ihs.mailservice;

import com.foo_baz.v_q.iloggerPackage.log_entry;

/**
 * @author $Author$
 * @version $Id$
 */
public class LogEntry implements Cloneable
{
	private log_entry le = null;
		
	public LogEntry() {
		super();
		clear();
	}
	
	public LogEntry( log_entry le ) {
		this();
		setIdLog(le.id_log);
		setTime(le.time);
		setService(le.ser);
		setMessage(le.msg);
		setLogin(le.login);
		setDomain(le.domain);
		setIp(le.ip);
		setResult(le.res);
	}
	
	public void setIdLog( String id ) {
		this.le.id_log = id;
	}
	
	public String getIdLog() {
		return this.le.id_log;
	}

	public void setTime( String time ) {
		this.le.time = time;
	}
	
	public String getTime() {
		return this.le.time;
	}
	
	public void setService( short ser ) {
		this.le.ser = ser;
	}
	
	public short getService() {
		return this.le.ser;
	}
	
	public void setMessage( String msg ) {
		this.le.msg = msg;
	}
	
	public String getMessage() {
		return this.le.msg;
	}
	
	public void setLogin( String log ) {
		this.le.login = log;
	}
	
	public String getLogin() {
		return this.le.login;
	}
	
	public void setDomain( String dom ) {
		this.le.domain = dom;
	}
	
	public String getDomain() {
		return this.le.domain;
	}
	
	public void setIp( String ip ) {
		this.le.ip = ip;
	}
	
	public String getIp() {
		return this.le.ip;
	}
	
	public void setResult( short res ) {
		this.le.res = res;
	}
	
	public short getResult() {
		return this.le.res;
	}
	
	/**
	 * Performs deep copy of the object
	 */
	public Object clone() {
		LogEntry item = new LogEntry();
		item.setIdLog(getIdLog());
		item.setTime(getTime());
		item.setService(getService());
		item.setMessage(getMessage());
		item.setLogin(getLogin());
		item.setDomain(getDomain());
		item.setIp(getIp());
		item.setResult(getResult());
		return item;
	}
	
	public void clear() {
		le = new log_entry();
	}
}

