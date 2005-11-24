/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs.mailservice;

import com.foo_baz.v_q.ivqPackage.domain_info;

/**
 * @author new
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Domain implements Cloneable {
	int idDomain;
	String domain;

	/**
	 * 
	 */
	public Domain() {
		super();
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
		return domain;
	}
	/**
	 * @param domain The domain to set.
	 */
	public void setDomain(String domain) {
		this.domain = domain;
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
	 * Performs deep copy of the object
	 */
	public Object clone() {
		Domain domain = new Domain();
		domain.setDomain(this.getDomain());
		domain.setIdDomain(this.getIdDomain());
		return domain;
	}
}
