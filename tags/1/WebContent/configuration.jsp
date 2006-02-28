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
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2"></meta>
			<title>
				<h:outputText value="#{msgs.applicationTitle}"/>
			</title>
			<link rel="stylesheet" href="web.css" type="text/css" />
		</head>
		<body>
			<f:subview id="header">
				<c:import url="commonHeader.jsp"/>
			</f:subview>
			<f:subview id="menu">
				<c:import url="commonMenu.jsp"/>
			</f:subview>
			<div id="main">
				<div id="content">
					<h2><h:outputText value="#{msgs.configurationTitle}"/></h2>
				</div>
				<h:form id="configuration">
					<h:panelGrid>
						<h:panelGrid>
							<h:messages styleClass="error" globalOnly="true" layout="table"/>
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
							
							<h:outputText value="#{msgs.configurationMaxAdministratorsInList}"/>
							<h:inputText size="25" required="true" id="maxAdministratorsInList"
								value="#{backing_configuration.maxAdministratorsInList}">
								<f:validateLongRange minimum="5" maximum="1000"/>
							</h:inputText>
							<h:message styleClass="error" for="maxAdministratorsInList"/>
							
							<f:facet name="footer">
								<h:panelGroup>
									<h:commandButton value="#{msgs.commonReload}"
										immediate="false" action="#{backing_configuration.reload}"/>
									<h:commandButton value="#{msgs.commonUpdate}"
										immediate="false" action="#{backing_configuration.update}"/>
								</h:panelGroup>
							</f:facet>
						</h:panelGrid>
					</h:panelGrid>
				</h:form>
			</div>
			<f:subview id="footer">
				<c:import url="commonFooter.jsp"/>
			</f:subview>
		</body>
	</html>
</f:view>
</jsp:root>