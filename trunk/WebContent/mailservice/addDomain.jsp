<?xml version="1.0"?>
<jsp:root version="2.0"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core">
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
			<link rel="stylesheet" href="../web.css" type="text/css" />
		</head>
		<body>
			<f:subview id="header">
				<c:import url="/commonHeader.jsp"/>
			</f:subview>
			<f:subview id="menu">
				<c:import url="/commonMenu.jsp"/>
			</f:subview>
			<div id="main">
				<div id="content">
					<h2>
						<h:outputText rendered="#{!backing_addDomain.updating}" value="#{msgs.mailServiceAddDomainTitle}"/>
						<h:outputText rendered="#{backing_addDomain.updating}" value="#{msgs.mailServiceEditDomainTitle}"/>
					</h2>
				</div>
				<h:form id="addDomain">
					<f:verbatim>&lt;p&gt;</f:verbatim>
						<h:messages styleClass="error" globalOnly="true" layout="table"/>
						<h:outputText styleClass="message" value="#{backing_addDomain.result}"/>
					<f:verbatim>&lt;/p&gt;</f:verbatim>
					<h:panelGrid styleClass="editing" rowClasses="odd,even" columns="3">
						<h:outputText value="#{msgs.mailServiceAddDomainDomain}"/>
						<h:inputText size="25" required="true" id="domain"
							value="#{backing_addDomain.domain}"
							disabled="#{backing_addDomain.updating}"
							validator="#{backing_addDomain.validateDomain}">
							<f:validateLength minimum="1" maximum="512"/>
						</h:inputText>
						<h:message styleClass="error" for="domain"/>

						<f:facet name="footer">
							<h:panelGroup>
								<h:commandButton value="#{msgs.commonCancel}"
									action="#{backing_addDomain.cancel}" immediate="true"/>
								<h:commandButton value="#{backing_addDomain.updating ? msgs.commonUpdate : msgs.commonAdd}"
									immediate="false" action="#{backing_addDomain.addDomain}"/>
							</h:panelGroup>
						</f:facet>
					</h:panelGrid>
				</h:form>
			</div>
			<f:subview id="footer">
				<c:import url="/commonFooter.jsp"/>
			</f:subview>
		</body>
	</html>
</f:view>
</jsp:root>