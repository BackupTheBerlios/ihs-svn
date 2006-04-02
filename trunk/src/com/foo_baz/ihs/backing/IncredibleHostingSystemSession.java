package com.foo_baz.ihs.backing;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author $Author$
 * @version $Id$
 */
public class IncredibleHostingSystemSession {
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if( session != null ) {
			session.invalidate();
		}
		return "gotoLogin";
	}
}
