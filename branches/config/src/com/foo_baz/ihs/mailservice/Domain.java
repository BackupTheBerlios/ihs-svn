package com.foo_baz.ihs.mailservice;

import com.foo_baz.v_q.ivqPackage.domain_info;

/**
 * @author $Author$
 * @version $Id$
 */
public class Domain implements Cloneable {
	private domain_info domainInfo = null;

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
		return domainInfo.domain;
	}
	/**
	 * @param domain The domain to set.
	 */
	public void setDomain(String domain) {
		this.domainInfo.domain = domain;
	}
	/**
	 * @return Returns the idDomain.
	 */
	public int getIdDomain() {
		return domainInfo.id_domain;
	}
	/**
	 * @param idDomain The idDomain to set.
	 */
	public void setIdDomain(int idDomain) {
		this.domainInfo.id_domain = idDomain;
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
		domainInfo = new domain_info();
	}

	public domain_info getDomainInfo() {
		return domainInfo;
	}

	public void setDomainInfo(domain_info domainInfo) {
		this.domainInfo = domainInfo;
	}
}
