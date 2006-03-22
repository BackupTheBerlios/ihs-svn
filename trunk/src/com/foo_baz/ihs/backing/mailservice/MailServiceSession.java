package com.foo_baz.ihs.backing.mailservice;

public class MailServiceSession {
	ExtendedDomainsDataModelConfiguration domainsSorting = new ExtendedDomainsDataModelConfiguration();
	UsersDataModelConfiguration usersSorting = new UsersDataModelConfiguration();
	ExtendedLogsDataModelConfiguration logsSorting = new ExtendedLogsDataModelConfiguration(); 
	
	public ExtendedDomainsDataModelConfiguration getDomainsSorting() {
		return domainsSorting;
	}
	
	public UsersDataModelConfiguration getUsersSorting() {
		return usersSorting;
	}
	
	public ExtendedLogsDataModelConfiguration getLogsSorting() {
		return logsSorting;
	}
}
