<?xml version="1.0"?>
<jsp:root version="2.0"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core"
	xmlns:corejsf="http://corejsf.com/pager">
<jsp:directive.page contentType="text/html"/>
<f:view>
<f:verbatim><![CDATA[<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">]]></f:verbatim>
	<html xmlns="http://www.w3c.org/1999/xhtml">
		<head>
			<f:loadBundle basename="com.foo_baz.ihs.messages" var="msgs"/>
			<title>
				<h:outputText value="#{msgs.applicationTitle}"/>
			</title>
			<![CDATA[<link rel="stylesheet" href="]]><h:outputText value="#{facesContext.externalContext.requestContextPath}"/><![CDATA[/web.css" type="text/css" />]]>
		</head>
		<body>
			<c:import url="/commonHeader.jsp"/>
			<c:import url="/commonMenu.jsp"/>
			
			<div id="main">
				<div id="content">
					<h2><h:outputText value="#{msgs.configurationTitle}"/></h2>
				</div>
				<h:form id="configuration">
					<h:panelGrid>
						<h:messages errorClass="error" fatalClass="fatal" globalOnly="true" layout="table"/>
						<h:outputText styleClass="message" value="#{backing_configuration.result}"/>
					</h:panelGrid>

					<h:panelGrid styleClass="editing" rowClasses="odd,even" columns="3">
						<h:outputText value="#{msgs.configurationMaxPagesInPager}"/>
						<h:inputText size="25" required="true" id="maxPagesInPager"
							value="#{backing_configuration.maxPagesInPager}">
							<f:validateLongRange minimum="2" maximum="100"/>
						</h:inputText>
						<h:message styleClass="error" for="maxPagesInPager"/>

						<h:outputText value="#{msgs.configurationMaxUsersInList}"/>
						<h:inputText size="25" required="true" id="maxUsersInList"
							value="#{backing_configuration.maxUsersInList}">
							<f:validateLongRange minimum="5" maximum="1000"/>
						</h:inputText>
						<h:message styleClass="error" for="maxUsersInList"/>
						
						<h:outputText value="#{msgs.configurationMaxDomainsInList}"/>
						<h:inputText size="25" required="true" id="maxDomainsInList"
							value="#{backing_configuration.maxDomainsInList}">
							<f:validateLongRange minimum="5" maximum="1000"/>
						</h:inputText>
						<h:message styleClass="error" for="maxDomainsInList"/>

						<h:outputText value="#{msgs.configurationMaxLogsInList}"/>
						<h:inputText size="25" required="true" id="maxLogsInList"
							value="#{backing_configuration.maxLogsInList}">
							<f:validateLongRange minimum="5" maximum="1000"/>
						</h:inputText>
						<h:message styleClass="error" for="maxLogsInList"/>

						<h:outputText value="#{msgs.configurationMaxAdministratorsInList}"/>
						<h:inputText size="25" required="true" id="maxAdministratorsInList"
							value="#{backing_configuration.maxAdministratorsInList}">
							<f:validateLongRange minimum="5" maximum="1000"/>
						</h:inputText>
						<h:message styleClass="error" for="maxAdministratorsInList"/>
						
						<h:outputText value="#{msgs.configurationOrbInitRef}"/>
						<h:inputText size="25" required="true" id="orbInitRef"
							value="#{backing_configuration.orbInitRef}">
						</h:inputText>
						<h:message styleClass="error" for="orbInitRef"/>
						
						<h:outputText value="#{msgs.configurationOrbInitialContextFactory}"/>
						<h:inputText size="25" required="true" id="orbInitialContextFactory"
							value="#{backing_configuration.orbInitialContextFactory}">
						</h:inputText>
						<h:message styleClass="error" for="orbInitialContextFactory"/>
						
						<h:outputText value="#{msgs.configurationOrbProviderUrl}"/>
						<h:inputText size="25" required="true" id="orbProviderUrl"
							value="#{backing_configuration.orbProviderUrl}">
						</h:inputText>
						<h:message styleClass="error" for="orbProviderUrl"/>
						
						<h:outputText value="#{msgs.configurationOrbVirtualQmail}"/>
						<h:inputText size="25" required="true" id="orbVirtualQmail"
							value="#{backing_configuration.orbVirtualQmail}">
						</h:inputText>
						<h:message styleClass="error" for="orbVirtualQmail"/>
						
						<h:outputText value="#{msgs.configurationOrbVirtualQmailLogger}"/>
						<h:inputText size="25" required="true" id="orbVirtualQmailLogger"
							value="#{backing_configuration.orbVirtualQmailLogger}">
						</h:inputText>
						<h:message styleClass="error" for="orbVirtualQmailLogger"/>
						
						<f:facet name="footer">
							<h:panelGroup>
								<h:commandButton value="#{msgs.commonReload}"
									immediate="false" action="#{backing_configuration.reload}"/>
								<h:commandButton value="#{msgs.commonUpdate}"
									immediate="false" action="#{backing_configuration.update}"/>
							</h:panelGroup>
						</f:facet>
					</h:panelGrid>
				</h:form>
			</div>
			<c:import url="/commonFooter.jsp"/>
		</body>
	</html>
</f:view>
</jsp:root>