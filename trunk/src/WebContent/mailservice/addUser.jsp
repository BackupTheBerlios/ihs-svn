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
					<h2><h:outputText value="#{msgs.mailServiceAddUserTitle}"/></h2>
				</div>
				<h:form id="addUser">
				<f:verbatim>&lt;p&gt;</f:verbatim>
					<h:messages styleClass="error" globalOnly="true" layout="table"/>
					<h:outputText value="#{backing_addUser.result}"/>
				<f:verbatim>&lt;/p&gt;</f:verbatim>
				<h:panelGrid styleClass="editing" rowClasses="odd,even" columns="3">
					<h:outputText value="#{msgs.mailServiceAddUserDomain}"/>
					<h:outputText value="#{backing_addUser.domain}"/>
					<f:verbatim/>
					
					<h:outputText value="#{msgs.mailServiceAddUserLogin}"/>
					<h:inputText size="25" required="true" id="login"
						value="#{backing_addUser.login}"
						disabled="#{backing_addUser.updating}">
						<f:validateLength minimum="1" maximum="512"/>
					</h:inputText>
					<h:message styleClass="error" for="login"/>

					<h:outputText value="#{msgs.mailServiceAddUserPassword}"/>
					<h:inputSecret binding="#{backing_addUser.passwordInput}"
						size="25" required="true" id="password"
						value="#{backing_addUser.password}">
						<f:validateLength minimum="1" maximum="512"/>
					</h:inputSecret>
					<h:message styleClass="error" for="password"/>

					<h:outputText value="#{msgs.mailServiceAddUserPasswordConfirm}"/>
					<h:inputSecret binding="#{backing_addUser.passwordConfirmInput}"
						size="25" id="passwordConfirm" required="true" validator="#{backing_addUser.validatePasswordConfirm}">
						<f:validateLength minimum="1" maximum="512"/>
					</h:inputSecret>
					<h:message styleClass="error" for="passwordConfirm"/>

					<h:outputText value="#{msgs.mailServiceAddUserFlags}"/>
					<h:inputSecret size="25" id="flags" required="true"/>
					<h:message styleClass="error" for="flags"/>

					<h:outputText value="#{msgs.mailServiceAddUserHomeDir}"/>
					<h:panelGroup>
						<h:selectBooleanCheckbox id="defaultDir" value="defaultDir"
							onclick="submit()"/>
						<f:verbatim>&amp;nbsp;</f:verbatim>
						<h:outputText value="#{msgs.mailServiceAddUserHomeDirDefault}"/>
					</h:panelGroup>
					<h:message styleClass="error" for="defaultDir"/>

					<h:outputText value="#{msgs.mailServiceAddUserHomeDirOther}"/>
					<h:inputText size="25" id="dir" 
						disabled="#{backing_addUser.defaultDir}" required="#{!backing_addUser.defaultDir}"
						value="#{backing_addUser.dir}"/>
					<h:message styleClass="error" for="dir"/>

					<f:facet name="footer">
						<h:panelGroup>
							<h:commandButton value="#{msgs.commonCancel}"
								action="#{backing_addUser.cancel}" immediate="true"/>
							<h:commandButton value="#{backing_addUser.updating ? msgs.commonUpdate : msgs.commonAdd}"
								immediate="false" action="#{backing_addUser.addUser}"/>
						</h:panelGroup>
					</f:facet>
				</h:panelGrid>
			</h:form>
		</div>
		<f:subview id="footer">
			<c:import url="../commonFooter.jsp"/>
		</f:subview>
	</body>
</html>
</f:view>
</jsp:root>