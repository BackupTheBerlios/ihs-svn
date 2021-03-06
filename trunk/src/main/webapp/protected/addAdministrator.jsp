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
					<h2>
						<h:outputText rendered="#{!ihs.updatingSelectedUser}" value="#{msgs.addAdministratorTitle}"/>
						<h:outputText rendered="#{ihs.updatingSelectedUser}" value="#{msgs.editAdministratorTitle}"/>
					</h2>
				</div>
				<h:form id="addAdministrator">
					<h:panelGrid>
						<h:messages errorClass="error" fatalClass="fatal" globalOnly="true" layout="table"/>
						<h:outputText styleClass="message" value="#{backing_addAdministrator.result}"/>
					</h:panelGrid>

					<h:panelGrid styleClass="editing" columns="3" rowClasses="odd,even">
						<h:outputText value="#{msgs.addAdministratorLogin}"/>
						<h:inputText size="25" required="true" id="login"
							value="#{backing_addAdministrator.login}"
							disabled="#{ihs.updatingSelectedUser}">
							<f:validateLength minimum="1" maximum="512"/>
						</h:inputText>
						<h:message styleClass="error" for="login"/>

						<h:outputText value="#{msgs.addAdministratorPassword}"/>
						<h:inputSecret binding="#{backing_addAdministrator.addAdministratorPasswordInput}"
							size="25" required="true" id="password"
							value="#{backing_addAdministrator.password}">
							<f:validateLength minimum="1" maximum="512"/>
						</h:inputSecret>
						<h:message styleClass="error" for="password"/>
						
						<h:outputText value="#{msgs.addAdministratorPasswordConfirm}"/>
						<h:inputSecret binding="#{backing_addAdministrator.addAdministratorPasswordConfirmInput}"
							size="25" id="passwordConfirm" required="true" validator="#{backing_addAdministrator.validatePasswordConfirm}">
							<f:validateLength minimum="1" maximum="512"/>
						</h:inputSecret>
						<h:message styleClass="error" for="passwordConfirm"/>

						<f:facet name="footer">	
							<h:panelGroup>
								<h:commandButton value="#{msgs.commonCancel}"
									action="#{backing_addAdministrator.cancel}" immediate="true"/>
								<h:commandButton value="#{ihs.updatingSelectedUser ? msgs.commonUpdate : msgs.commonAdd}"
									immediate="false" action="#{backing_addAdministrator.addAdministrator}"/>
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