package com.foo_baz.ihs.mailservice;

import com.foo_baz.v_q.ivqPackage.user_info;

public class User implements Cloneable
{
	private String password;
	
	private String login;
	
	private String dir;
	
	private int idDomain;
	
	private short flags;
	
	private short gid;
	
	private short uid;
	
	public User() {
		super();
	}
	
	public User( user_info ui ) {
		this();
		setIdDomain(ui.id_domain);
		setLogin(ui.login);
		setPassword(ui.pass);
		setDir(ui.dir);
		setFlags(ui.flags);
		setUid(ui.uid);
		setGid(ui.gid);
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
	 * @return Returns the dir.
	 */
	public String getDir() {
		return dir;
	}
	/**
	 * @param dir The dir to set.
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	/**
	 * @return Returns the flags.
	 */
	public short getFlags() {
		return flags;
	}
	/**
	 * @param flags The flags to set.
	 */
	public void setFlags(short flags) {
		this.flags = flags;
	}
	/**
	 * @return Returns the idDomain.
	 */
	public int getIdDomain() {
		return idDomain;
	}
	/**
	 * @param idDomain The idDomain to set.
	 */
	public void setIdDomain(int idDomain) {
		this.idDomain = idDomain;
	}
		
	/**
	 * @return Returns the gid.
	 */
	public short getGid() {
		return gid;
	}
	/**
	 * @param gid The gid to set.
	 */
	public void setGid(short gid) {
		this.gid = gid;
	}
	/**
	 * @return Returns the uid.
	 */
	public short getUid() {
		return uid;
	}
	/**
	 * @param uid The uid to set.
	 */
	public void setUid(short uid) {
		this.uid = uid;
	}
	/**
	 * Performs deep copy of the object
	 */
	public Object clone() {
		User item = new User();
		item.setIdDomain(this.getIdDomain());
		item.setLogin(this.getLogin());
		item.setPassword(this.getPassword());
		item.setDir(this.getDir());
		item.setFlags(this.getFlags());
		item.setUid(this.getUid());
		item.setGid(this.getGid());
		return item;
	}
}

