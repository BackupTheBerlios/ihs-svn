<?xml version="1.0"?>
<jsp:root version="2.0"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core">
	
	<jsp:directive.page contentType="text/html"/>

	<f:subview id="menu">	
		<f:verbatim><![CDATA[<div id="menu">]]></f:verbatim>
		<h:form id="commonMenu">
			<h:panelGrid>
				<h:panelGrid columns="2" id="localeGrid">
					<h:commandLink id="en" immediate="true" 
						actionListener="#{locale.changeLocale}">
						<h:graphicImage value="/images/i18n/flags/en.png" style="border: 0px"/>
					</h:commandLink>
					
					<h:commandLink id="pl" immediate="true" 
						actionListener="#{locale.changeLocale}">
						<h:graphicImage value="/images/i18n/flags/pl.png" style="border: 0px"/>
					</h:commandLink>
				</h:panelGrid>
			
				<h:commandLink immediate="true" actionListener="#{backing_ihs.logout}">
					<h:outputText value="#{msgs.logoutTitle}"/>
					</h:commandLink>
			</h:panelGrid>
			
			<h:dataTable id="menuElements"
				var="curItem"
				value="#{ihs.menuElements}">
				<h:column>
					<h:panelGrid>
						<h:outputLink value="#{curItem.viewId}">
							<h:outputText value="#{curItem.title}"/>
						</h:outputLink>
						<h:outputText value="#{curItem.description}"/>
					</h:panelGrid>
				</h:column>
			</h:dataTable>
<!--			
				<h:commandLink immediate="true" action="gotoConfiguration">
					<h:outputText value="#{msgs.configurationTitle}"/>
				</h:commandLink>
	
				<h:commandLink immediate="true" action="gotoAdministrators">
					<h:outputText value="#{msgs.administratorsTitle}"/>
				</h:commandLink>
	
				<h:commandLink immediate="true" action="#{backing_administrators.addAdministrator}">
					<h:outputText value="#{msgs.addAdministratorTitle}"/>
				</h:commandLink>
						 
				<h:commandLink immediate="true" action="gotoMailServiceDomains">
					<h:outputText value="#{msgs.mailServiceDomainsTitle}"/>
				</h:commandLink>
			
				<h:commandLink immediate="true" action="#{backing_domains.addDomain}">
					<h:outputText value="#{msgs.mailServiceAddDomainTitle}"/>
				</h:commandLink>
	
				<h:commandLink immediate="true" action="gotoMailServiceLogs">
					<h:outputText value="#{msgs.mailServiceLogsTitle}"/>
				</h:commandLink>
-->
		</h:form>
		<f:verbatim><![CDATA[</div>]]></f:verbatim>
	</f:subview>
</jsp:root>
