package com.foo_baz.ihs.backing.mailservice;

import com.foo_baz.ihs.mailservice.Domain;
import com.foo_baz.ihs.mailservice.User;

/**
 * @author $Author$
 * @version $Id$
 */
public class MailServiceSession {
	private ExtendedDomainsDataModelConfiguration domainsSorting = new ExtendedDomainsDataModelConfiguration();
	private UsersDataModelConfiguration usersSorting = new UsersDataModelConfiguration();
	private ExtendedLogsDataModelConfiguration logsSorting = new ExtendedLogsDataModelConfiguration();
	private Domain currentDomain = new Domain();
	private boolean updatingCurrentDomain = false;
	private User currentUser = new User();
	private boolean updatingCurrentUser = false;
	
	public ExtendedDomainsDataModelConfiguration getDomainsSorting() {
		return domainsSorting;
	}
	
	public UsersDataModelConfiguration getUsersSorting() {
		return usersSorting;
	}
	
	public ExtendedLogsDataModelConfiguration getLogsSorting() {
		return logsSorting;
	}
	
	public Domain getCurrentDomain() {
		return currentDomain;
	}
	
	public void setCurrentDomain( Domain domain ) {
		currentDomain = domain;
	}

	public boolean isUpdatingCurrentDomain() {
		return updatingCurrentDomain;
	}

	public void setUpdatingCurrentDomain(boolean updatingCurrentDomain) {
		this.updatingCurrentDomain = updatingCurrentDomain;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public boolean isUpdatingCurrentUser() {
		return updatingCurrentUser;
	}

	public void setUpdatingCurrentUser(boolean updatingCurrentUser) {
		this.updatingCurrentUser = updatingCurrentUser;
	}
		
}
