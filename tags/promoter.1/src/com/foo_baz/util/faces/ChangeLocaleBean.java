package com.foo_baz.util.faces;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author $Author$
 * @version $Id$
 */
public class ChangeLocaleBean {

	public void changeLocale( ActionEvent event ) {
		String current = event.getComponent().getId();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getViewRoot().setLocale(new Locale(current));
		} catch( Exception e ) {
			// fallback for unsupported locales
			context.getViewRoot().setLocale(Locale.getDefault());
		}
	}
	
}
