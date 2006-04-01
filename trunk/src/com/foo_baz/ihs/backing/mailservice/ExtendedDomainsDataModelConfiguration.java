package com.foo_baz.ihs.backing.mailservice;

import javax.faces.event.ActionEvent;

/**
 * @author $Author$
 * @version $Id$
 */
public class ExtendedDomainsDataModelConfiguration {
	final public Integer BY_DOMAIN = new Integer(1);
	final public Integer BY_NUMBER_OF_USERS = new Integer(2);
	private Integer sortingOrder = BY_DOMAIN;
	
	/**
	 * 
	 */
	public void sortByDomain( ActionEvent event ) {
		setSortingOrder(BY_DOMAIN);
	}
	public boolean isSortedByDomain() {
		return getSortingOrder().equals(BY_DOMAIN);
	}
	
	public void sortByNumberOfUsers( ActionEvent event ) {
		setSortingOrder(BY_NUMBER_OF_USERS);
	}
	public boolean isSortedByNumberOfUsers() {
		return getSortingOrder().equals(BY_NUMBER_OF_USERS);
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}
	public void setSortingOrder( Integer s ) {
		sortingOrder = s;
	}

	public void sortDataModel(ExtendedDomainsDataModel dm) {
		if( getSortingOrder().equals(BY_NUMBER_OF_USERS) )
			dm.sortByNumberOfUsers();
		else
			dm.sortByDomain();
	}
	
}
