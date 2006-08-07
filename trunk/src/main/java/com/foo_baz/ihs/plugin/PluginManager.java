package com.foo_baz.ihs.plugin;

import com.foo_baz.util.faces.Messages;

public class PluginManager extends Plugin {

	public String getTitle() {
		return Messages.getString(PluginManager.class, "title", null);
	}

	public String getDescription() {
		return Messages.getString(PluginManager.class, "description", null);
	}

	public String getViewId() {
		// TODO Auto-generated method stub
		return null;
	}

}
