package com.foo_baz.ihs.plugin;

import com.foo_baz.ihs.NavigationElement;

public abstract class Plugin {
	/**
	 * Returns name of the plug-in, if you want to use some properties file use Messages class
	 * @see com.foo_baz.util.faces.Messages
	 * @return name of the plug-in
	 */
	public String getTitle() {
		return null;
	}
	
	/**
	 * Returns description of the plug-in, if you want to use some properties file use Messages class
	 * @see com.foo_baz.util.faces.Messages
	 * @return description of the plug-in
	 */
	public String getDescription() {
		return null;
	}
	
	public String getViewId() {
		return null;
	}
	
	public NavigationElement[] getMenuElements() {
		return null;
	}
}
