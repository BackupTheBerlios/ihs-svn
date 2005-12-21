package com.foo_baz.ihs;

/**
 * This class represents
 * @author Pawe³ Niewiadomski
 */
public class ExtendedAdministrator extends Administrator {
	public ExtendedAdministrator() {
	}
	
	/**
	 * Creates copy of passed object
	 */
	public ExtendedAdministrator( Administrator admin ) {
		this();
		Administrator tmpAdmin = (Administrator) admin.clone();
		this.setLogin(tmpAdmin.getLogin());
		this.setPassword(tmpAdmin.getPassword());
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
}
