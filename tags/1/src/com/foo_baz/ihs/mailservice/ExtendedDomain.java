package com.foo_baz.ihs.mailservice;

/**
 * This class represents
 * @author Pawe³ Niewiadomski
 */
public class ExtendedDomain extends Domain {
	public ExtendedDomain() {
	}
	
	/**
	 * Creates copy of passed object
	 */
	public ExtendedDomain( Domain domain ) {
		this();
		Domain tmpDomain = (Domain) domain.clone();
		this.setDomain(tmpDomain.getDomain());
		this.setIdDomain(tmpDomain.getIdDomain());
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
	
	//@{
	/**
	 * Order of this element in the collection
	 */
	private int order = -1;
	
	/**
	 * @return Returns the order.
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order The order to set.
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	//@}
	
	int numberOfUsers;
	
	/**
	 * @return Returns the numberOfUsers.
	 */
	public int getNumberOfUsers() {
		return numberOfUsers;
	}
	/**
	 * @param numberOfUsers The numberOfUsers to set.
	 */
	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}
}
