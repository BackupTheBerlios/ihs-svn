<?xml version="1.0"?>
<jsp:root version="2.0"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core">
	
	<jsp:directive.page contentType="text/html"/>
	
	<f:verbatim><![CDATA[<div id="menu">]]></f:verbatim>
	<h:form id="commonMenu">
		<h:panelGrid>
			<h:panelGroup>
				<h:panelGrid columns="2" id="localeGrid">
					<h:commandLink immediate="true" action="#{backing_locale.changeLocale}">
						<h:graphicImage value="/images/i18n/flags/en.png" style="border: 0px"/>
						<f:param name="localeCode" value="en"/>
					</h:commandLink>
					
					<h:commandLink immediate="true" action="#{backing_locale.changeLocale}">
						<h:graphicImage value="/images/i18n/flags/pl.png" style="border: 0px"/>
						<f:param name="localeCode" value="pl"/>
					</h:commandLink>
				</h:panelGrid>
			</h:panelGroup>
			
			<h:commandLink immediate="true" action="gotoConfiguration">
				<h:outputText value="#{msgs.configurationTitle}"/>
			</h:commandLink>

			<h:commandLink immediate="true" action="gotoAdministrators">
				<h:outputText value="#{msgs.administratorsTitle}"/>
			</h:commandLink>

			<h:commandLink immediate="true" action="gotoAddAdministrator">
				<h:outputText value="#{msgs.addAdministratorTitle}"/>
			</h:commandLink>
					 
			<h:commandLink immediate="true" action="gotoMailServiceDomains">
				<h:outputText value="#{msgs.mailServiceDomainsTitle}"/>
			</h:commandLink>
		
			<h:commandLink immediate="true" action="gotoMailServiceAddDomain">
				<h:outputText value="#{msgs.mailServiceAddDomainTitle}"/>
			</h:commandLink>
		</h:panelGrid>
	</h:form>
	<f:verbatim><![CDATA[</div>]]></f:verbatim>
</jsp:root>