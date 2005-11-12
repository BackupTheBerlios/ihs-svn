/*
 * Created on 2005-10-30
 * 
 * @author new
 */
package com.foo_baz.ihs.backing.mailservice;
import com.foo_baz.ihs.mailservice.ExtendedDomain;
;

/**
 * @author new
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddDomain extends ExtendedDomain {

	private boolean updating = false;
	private String result;
	
	/**
	 * @return Returns the updating.
	 */
	public boolean isUpdating() {
		return updating;
	}
	/**
	 * @param updating The updating to set.
	 */
	public void setUpdating(boolean updating) {
		this.updating = updating;
	}
	
	/**
	 * @return Returns the result.
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result The result to set.
	 */
	public void setResult(String result) {
		this.result = result;
	}
}
