package com.foo_baz.ihs.backing.mailservice;

import javax.faces.event.ActionEvent;

/**
 * @author $Author$
 * @version $Id$
 */
public class ExtendedLogsDataModelConfiguration {
	final public Integer BY_TIME = new Integer(1);
	final public Integer BY_SERVICE = new Integer(2);
	final public Integer BY_MESSAGE = new Integer(3);
	final public Integer BY_LOGIN = new Integer(4);
	final public Integer BY_DOMAIN = new Integer(5);
	final public Integer BY_IP = new Integer(6);
	final public Integer BY_RESULT = new Integer(7);
	private Integer sortingOrder = BY_TIME;
		
	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public void sortByTime( ActionEvent ae ) {
		setSortingOrder(BY_TIME);
	}
	public boolean isSortedByTime() {
		return getSortingOrder().equals(BY_TIME);
	}
	
	public void sortByService( ActionEvent ae ) {
		setSortingOrder(BY_SERVICE);
	}
	public boolean isSortedByService() {
		return getSortingOrder().equals(BY_SERVICE);
	}
	
	public void sortByMessage( ActionEvent ae ) {
		setSortingOrder(BY_MESSAGE);
	}
	public boolean isSortedByMessage() {
		return getSortingOrder().equals(BY_MESSAGE);
	}
	
	public void sortByLogin( ActionEvent ae ) {
		setSortingOrder(BY_LOGIN);
	}
	public boolean isSortedByLogin() {
		return getSortingOrder().equals(BY_LOGIN);
	}
	
	public void sortByDomain( ActionEvent ae ) {
		setSortingOrder(BY_DOMAIN);
	}
	public boolean isSortedByDomain() {
		return getSortingOrder().equals(BY_DOMAIN);
	}
	
	public void sortByIp( ActionEvent ae ) {
		setSortingOrder(BY_IP);
	}
	public boolean isSortedByIp() {
		return getSortingOrder().equals(BY_IP);
	}
	
	public void sortByResult( ActionEvent ae ) {
		setSortingOrder(BY_RESULT);
	}
	public boolean isSortedByResult() {
		return getSortingOrder().equals(BY_RESULT);
	}

	public void sortDataModel(ExtendedLogsDataModel dm) {
		if( getSortingOrder().equals(BY_SERVICE) )
			dm.sortByService();
		else if( getSortingOrder().equals(BY_MESSAGE) )
			dm.sortByMessage();
		else if( getSortingOrder().equals(BY_LOGIN) )
			dm.sortByLogin();
		else if( getSortingOrder().equals(BY_DOMAIN) )
			dm.sortByDomain();
		else if( getSortingOrder().equals(BY_IP) )
			dm.sortByIp();
		else if( getSortingOrder().equals(BY_RESULT) )
			dm.sortByResult();
		else
			dm.sortByTime();
	}
}
