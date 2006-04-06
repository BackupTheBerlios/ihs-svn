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
	private Domain selectedDomain = new Domain();
	private boolean updatingSelectedDomain = false;
	private User selectedUser = new User();
	private boolean updatingSelectedUser = false;
	
	public ExtendedDomainsDataModelConfiguration getDomainsSorting() {
		return domainsSorting;
	}
	
	public UsersDataModelConfiguration getUsersSorting() {
		return usersSorting;
	}
	
	public ExtendedLogsDataModelConfiguration getLogsSorting() {
		return logsSorting;
	}
	
	public Domain getSelectedDomain() {
		return selectedDomain;
	}
	
	public void setSelectedDomain( Domain domain ) {
		selectedDomain = domain;
	}

	public boolean isUpdatingSelectedDomain() {
		return updatingSelectedDomain;
	}

	public void setUpdatingSelectedDomain(boolean updatingCurrentDomain) {
		this.updatingSelectedDomain = updatingCurrentDomain;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User currentUser) {
		this.selectedUser = currentUser;
	}

	public boolean isUpdatingSelectedUser() {
		return updatingSelectedUser;
	}

	public void setUpdatingSelectedUser(boolean updatingCurrentUser) {
		this.updatingSelectedUser = updatingCurrentUser;
	}
		
}
