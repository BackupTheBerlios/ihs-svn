package com.foo_baz.ihs.mailservice;

/**
 * @author $Author$
 * @version $Id$
 */
public class ExtendedDomain extends Domain {
	private Domain wrappedData;
	private boolean selected = false;
	private int numberOfUsers = 0;
	
	public ExtendedDomain() {
		super();
	}
		
	public ExtendedDomain( Domain obj ) {
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
	
	public Domain getWrappedData() {
		return wrappedData;
	}
	public void setWrappedData(Domain wrappedData) {
		this.wrappedData = wrappedData;
	}

	public String getDomain() {
		return wrappedData.getDomain();
	}

	public int getIdDomain() {
		return wrappedData.getIdDomain();
	}

	public void setDomain(String domain) {
		wrappedData.setDomain(domain);
	}

	public void setIdDomain(int idDomain) {
		wrappedData.setIdDomain(idDomain);
	}
	public void clear() {
		setWrappedData(new Domain());
		setNumberOfUsers(0);
		setSelected(false);
	}
}
