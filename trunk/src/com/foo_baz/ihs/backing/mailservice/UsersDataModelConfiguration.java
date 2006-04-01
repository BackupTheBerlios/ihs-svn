package com.foo_baz.ihs.backing.mailservice;

import javax.faces.event.ActionEvent;

/**
 * @author $Author$
 * @version $Id$
 */
public class UsersDataModelConfiguration {
	final public Integer BY_LOGIN = new Integer(1);
	final public Integer BY_PASSWORD = new Integer(2);
	final public Integer BY_DIR = new Integer(3);
	final public Integer BY_FLAGS = new Integer(4);
	final public Integer BY_UID = new Integer(5);
	final public Integer BY_GID = new Integer(6);
	private Integer sortingOrder = BY_LOGIN;
	
	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public void sortByLogin( ActionEvent ae ) {
		setSortingOrder(BY_LOGIN);
	}
	public boolean isSortedByLogin() {
		return getSortingOrder().equals(BY_LOGIN);
	}
	
	public void sortByPassword( ActionEvent ae ) {
		setSortingOrder(BY_PASSWORD);
	}
	public boolean isSortedByPassword() {
		return getSortingOrder().equals(BY_PASSWORD);
	}
	
	public void sortByDir( ActionEvent ae ) {
		setSortingOrder(BY_DIR);
	}
	public boolean isSortedByDir() {
		return getSortingOrder().equals(BY_DIR);
	}
	
	public void sortByFlags( ActionEvent ae ) {
		setSortingOrder(BY_FLAGS);
	}
	public boolean isSortedByFlags() {
		return getSortingOrder().equals(BY_FLAGS);
	}

	public void sortByUid( ActionEvent ae ) {
		setSortingOrder(BY_UID);
	}
	public boolean isSortedByUid() {
		return getSortingOrder().equals(BY_UID);
	}
	
	public void sortByGid( ActionEvent ae ) {
		setSortingOrder(BY_GID);
	}
	public boolean isSortedByGid() {
		return getSortingOrder().equals(BY_GID);
	}

	public void sortDataModel(UsersDataModel dm) {
		if( getSortingOrder().equals(BY_PASSWORD) )
			dm.sortByPassword();
		else if( getSortingOrder().equals(BY_DIR) )
			dm.sortByDir();
		else if( getSortingOrder().equals(BY_FLAGS) )
			dm.sortByFlags();
		else if( getSortingOrder().equals(BY_UID) )
			dm.sortByUid();
		else if( getSortingOrder().equals(BY_GID) )
			dm.sortByGid();
		else
			dm.sortByLogin();
	}
}
