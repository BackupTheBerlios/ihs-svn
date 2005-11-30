/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs.mailservice;

import com.foo_baz.v_q.ivqPackage.domain_info;

/**
 * @author new
 */
public class Domain implements Cloneable {
	private domain_info di = null;

	/**
	 * 
	 */
	public Domain() {
		super();
		clear();
	}
	
	/**
	 * 
	 */
	public Domain( domain_info di ) {
		this();
		setDomain(di.domain);
		setIdDomain(di.id_domain);
	}
	
	/**
	 * @return Returns the domain.
	 */
	public String getDomain() {
		return di.domain;
	}
	/**
	 * @param domain The domain to set.
	 */
	public void setDomain(String domain) {
		this.di.domain = domain;
	}
	/**
	 * @return Returns the idDomain.
	 */
	public int getIdDomain() {
		return di.id_domain;
	}
	/**
	 * @param idDomain The idDomain to set.
	 */
	public void setIdDomain(int idDomain) {
		this.di.id_domain = idDomain;
	}
	
	/**
	 * Performs deep copy of the object
	 */
	public Object clone() {
		Domain domain = new Domain();
		domain.setDomain(this.getDomain());
		domain.setIdDomain(this.getIdDomain());
		return domain;
	}
	
	public void clear() {
		di = new domain_info();
	}
}
