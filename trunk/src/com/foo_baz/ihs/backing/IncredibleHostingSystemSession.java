package com.foo_baz.ihs.backing;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 * @author $Author$
 * @version $Id$
 */
public class IncredibleHostingSystemSession {
	protected static final Logger logger = Logger.getLogger("com.foo_baz.ihs");
	
	public void logout(ActionEvent event) throws AbortProcessingException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Object session = externalContext.getSession(false);
		if (session != null) {
			if (session instanceof HttpSession) {
				((HttpSession) session).invalidate();
			}
			// TODO: PortletRequest ??
		}
		String forward = externalContext.getRequestContextPath() + "/";
		try {
			externalContext.redirect(forward);
		} catch (IOException e) {
			logger.severe(e.toString());
			// TODO: may do error handling
			throw new FacesException("Can't redirect to '" + forward + "'");
		}
		facesContext.responseComplete();
	}
	
}
