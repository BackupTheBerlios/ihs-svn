package com.foo_baz.ihs;

public class Administrator implements Cloneable
{
	private String password;
	
	private java.lang.String login;
	
	public void clear() {
		setLogin("");
		setPassword("");
	}
	/**
	 * Set login. Login is a primary key for this object.
	 * @param login Login
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public java.lang.String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Performs deep copy of the object
	 */
	public Object clone() {
		Administrator admin = new Administrator();
		admin.setLogin(this.getLogin());
		admin.setPassword(this.getPassword());
		return admin;
	}
}

