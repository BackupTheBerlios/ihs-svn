package com.foo_baz.ihs.mailservice;

/**
 * This class represents
 * @author Pawe³ Niewiadomski
 */
public class ExtendedUser extends User {
	public ExtendedUser() {
		super();
	}
	
	/**
	 * Creates copy of passed object
	 */
	public ExtendedUser( User User ) {
		this();
		User tmpUser = (User) User.clone();
		setIdDomain(tmpUser.getIdDomain());
		setLogin(tmpUser.getLogin());
		setPassword(tmpUser.getPassword());
		setDir(tmpUser.getDir());
		setFlags(tmpUser.getFlags());
		setUid(tmpUser.getUid());
		setGid(tmpUser.getGid());
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
}
