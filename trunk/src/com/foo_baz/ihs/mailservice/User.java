package com.foo_baz.ihs.mailservice;

import com.foo_baz.v_q.ivqPackage.user_info;

/**
 * @author $Author$
 * @version $Id$
 */
public class User implements Cloneable
{
	private user_info userInfo = null;
	private String domain;
	
	public User() {
		super();
		clear();
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
		this.userInfo.login = login;
	}
	
	public String getLogin()
	{
		return userInfo.login;
	}
	
	public java.lang.String getPassword()
	{
		return userInfo.pass;
	}
	
	public void setPassword(String password)
	{
		this.userInfo.pass = password;
	}
	
	/**
	 * @return Returns the dir.
	 */
	public String getDir() {
		return userInfo.dir;
	}
	/**
	 * @param dir The dir to set.
	 */
	public void setDir(String dir) {
		this.userInfo.dir = dir;
	}
	/**
	 * @return Returns the flags.
	 */
	public short getFlags() {
		return userInfo.flags;
	}
	/**
	 * @param flags The flags to set.
	 */
	public void setFlags(short flags) {
		this.userInfo.flags = flags;
	}
	/**
	 * @return Returns the idDomain.
	 */
	public int getIdDomain() {
		return userInfo.id_domain;
	}
	/**
	 * @param idDomain The idDomain to set.
	 */
	public void setIdDomain(int idDomain) {
		this.userInfo.id_domain = idDomain;
	}
		
	/**
	 * @return Returns the gid.
	 */
	public short getGid() {
		return userInfo.gid;
	}
	/**
	 * @param gid The gid to set.
	 */
	public void setGid(short gid) {
		this.userInfo.gid = gid;
	}
	/**
	 * @return Returns the uid.
	 */
	public short getUid() {
		return userInfo.uid;
	}
	/**
	 * @param uid The uid to set.
	 */
	public void setUid(short uid) {
		this.userInfo.uid = uid;
	}
	
	/**
	 * Performs deep copy of the object
	 */
	public Object clone() {
		User item = new User();
		item.setDomain(this.getDomain());
		item.setIdDomain(this.getIdDomain());
		item.setLogin(this.getLogin());
		item.setPassword(this.getPassword());
		item.setDir(this.getDir());
		item.setFlags(this.getFlags());
		item.setUid(this.getUid());
		item.setGid(this.getGid());
		return item;
	}
	
	/**
	 * @return Returns the domain.
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain The domain to set.
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public void clear() {
		userInfo = new user_info();
		domain = "";
	}

	public user_info getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(user_info userInfo) {
		this.userInfo = userInfo;
	}
}

