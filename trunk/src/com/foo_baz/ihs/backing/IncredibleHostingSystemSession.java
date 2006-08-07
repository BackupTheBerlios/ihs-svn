package com.foo_baz.ihs.backing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.foo_baz.ihs.Administrator;
import com.foo_baz.ihs.NavigationElement;
import com.foo_baz.util.faces.Messages;

/**
 * @author $Author$
 * @version $Id$
 */
public class IncredibleHostingSystemSession {
	protected static final Logger logger = Logger.getLogger("com.foo_baz.ihs");
	private Administrator selectedUser;
	private boolean updatingSelectedUser = false;
	private ArrayList initialPluginList = null;
	
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

	public Administrator getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(Administrator currentUser) {
		this.selectedUser = currentUser;
	}

	public boolean isUpdatingSelectedUser() {
		return updatingSelectedUser;
	}

	public void setUpdatingSelectedUser(boolean updatingCurrentUser) {
		this.updatingSelectedUser = updatingCurrentUser;
	}
	
	public String redirectByParam() { 
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding action = app.createValueBinding("#{param.action}");

		return (String) action.getValue(context);
	}
	
	public NavigationElement[] getMenuElements() {
		NavigationElement [] menuElements = {
				new NavigationElement() {
					public String getTitle() {
						return Messages.getString("com.foo_baz.ihs.messages", "configurationTitle", null);
					}

					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					public String getViewId() {
						return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() 
							+ "/faces/protected/configuration.jsp";
					}
				},
				new NavigationElement() {
					public String getTitle() {
						return Messages.getString("com.foo_baz.ihs.messages", "administratorsTitle", null);
					}

					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					public String getViewId() {
						return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() 
							+ "/faces/protected/administrators.jsp";
					}					
				},
				new NavigationElement() {
					public String getTitle() {
						return Messages.getString("com.foo_baz.ihs.messages", "addAdministratorTitle", null);
					}

					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					public String getViewId() {
						return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() 
							+ "/faces/protected/addAdministrator.jsp";
					}					
				},
				new NavigationElement() {
					public String getTitle() {
						return Messages.getString("com.foo_baz.ihs.messages", "mailServiceDomainsTitle", null);
					}

					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					public String getViewId() {
						return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() 
							+ "/faces/protected/mailservice/domains.jsp";
					}					
				},
				new NavigationElement() {
					public String getTitle() {
						return Messages.getString("com.foo_baz.ihs.messages", "mailServiceAddDomainTitle", null);
					}

					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					public String getViewId() {
						return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() 
							+ "/faces/protected/mailservice/addDomain.jsp";
					}					
				},
				new NavigationElement() {
					public String getTitle() {
						return Messages.getString("com.foo_baz.ihs.messages", "mailServiceLogsTitle", null);
					}

					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}

					public String getViewId() {
						return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() 
							+ "/faces/protected/mailservice/logs.jsp";
					}					
				}
		};
		return menuElements;
	}

	public ArrayList getInitialPluginList() {
		return initialPluginList;
	}

	public void setInitialPluginList(ArrayList initialPluginList) {
		this.initialPluginList = initialPluginList;
	}
}
