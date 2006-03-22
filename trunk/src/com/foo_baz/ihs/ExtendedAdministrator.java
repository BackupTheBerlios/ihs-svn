package com.foo_baz.ihs;

/**
 * This class represents
 * @author Pawe� Niewiadomski
 */
public class ExtendedAdministrator extends Administrator {
	private Administrator wrappedData;	
	private boolean selected = false;
	
	public ExtendedAdministrator() {
		super();
		setWrappedData(new Administrator());
	}
	
	public ExtendedAdministrator( Administrator obj ) {
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

	public Administrator getWrappedData() {
		return wrappedData;
	}

	public void setWrappedData(Administrator wrappedData) {
		this.wrappedData = wrappedData;
	}

	public String getLogin() {
		return wrappedData.getLogin();
	}

	public String getPassword() {
		return wrappedData.getPassword();
	}

	public void setLogin(String login) {
		wrappedData.setLogin(login);
	}

	public void setPassword(String password) {
		wrappedData.setPassword(password);
	}

}
