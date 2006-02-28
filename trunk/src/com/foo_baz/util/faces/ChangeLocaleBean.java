/*
 * Created on 2006-02-26
 * 
 * @author new
 */
package com.foo_baz.util.faces;

import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 * @author new
 */
public class ChangeLocaleBean {

	public String changeLocale() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding localeBin = app.createValueBinding("#{param.localeCode}");
		String localeCode = "";
		if( localeBin != null ) 
			localeCode = (String) localeBin.getValue(context);
				
		if( "pl".equals(localeCode) ) {
			context.getViewRoot().setLocale(new Locale("pl"));
		} else if( "en".equals(localeCode) ) {
			context.getViewRoot().setLocale(Locale.ENGLISH);
		} else {
			context.getViewRoot().setLocale(Locale.getDefault());
		}
		return null;
	}
	
}
