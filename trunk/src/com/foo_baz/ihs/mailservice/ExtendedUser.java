package com.foo_baz.ihs.mailservice;

/**
 * This class represents
 * @author Pawe� Niewiadomski
 */
public class ExtendedUser extends User {
	private User wrappedData;
	
	private boolean selected = false;
	
	public ExtendedUser() {
		super();
	}
	
	public ExtendedUser( User user ) {
		super();
		setWrappedData(user);
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
	
	public User getWrappedData() {
		return wrappedData;
	}
	
	public void setWrappedData(User wrappedData) {
		this.wrappedData = wrappedData;
	}

	// following methods delegate directly to the decorated object
	public String getDir() {
		return wrappedData.getDir();
	}
	public String getDomain() {
		return wrappedData.getDomain();
	}
	public short getFlags() {
		return wrappedData.getFlags();
	}
	public short getGid() {
		return wrappedData.getGid();
	}
	public int getIdDomain() {
		return wrappedData.getIdDomain();
	}
	public String getLogin() {
		return wrappedData.getLogin();
	}
	public String getPassword() {
		return wrappedData.getPassword();
	}
	public short getUid() {
		return wrappedData.getUid();
	}
	public void setDir(String dir) {
		wrappedData.setDir(dir);
	}
	public void setDomain(String domain) {
		wrappedData.setDomain(domain);
	}
	public void setFlags(short flags) {
		wrappedData.setFlags(flags);
	}
	public void setGid(short gid) {
		wrappedData.setGid(gid);
	}
	public void setIdDomain(int idDomain) {
		wrappedData.setIdDomain(idDomain);
	}
	public void setLogin(String login) {
		wrappedData.setLogin(login);
	}
	public void setPassword(String password) {
		wrappedData.setPassword(password);
	}
	public void setUid(short uid) {
		wrappedData.setUid(uid);
	}
	public void clear() {
		setWrappedData(new User());
		setSelected(false);
	}
	
}
