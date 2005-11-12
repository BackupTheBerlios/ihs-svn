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
					<h2><h:outputText value="#{msgs.addAdministratorTitle}"/></h2>
				</div>
				<h:form id="addAdministrator">
					<f:verbatim>&lt;p&gt;</f:verbatim>
						<h:messages styleClass="error" globalOnly="true" layout="table"/>
						<h:outputText styleClass="message" value="#{backing_addAdministrator.result}"/>
					<f:verbatim>&lt;/p&gt;</f:verbatim>
					<table class="editing">
						<tbody>
							<tr class="odd">
								<th>
									<h:outputText value="#{msgs.addAdministratorLogin}"/>
								</th>
								<td>
									<h:inputText size="25" required="true" id="login"
										value="#{backing_addAdministrator.login}"
										disabled="#{backing_addAdministrator.updating}">
										<f:validateLength minimum="1" maximum="512"/>
									</h:inputText>
								</td>
								<td>
									<h:message styleClass="error" for="login"/>
								</td>
							</tr>
							<tr class="even">
								<th>
									<h:outputText value="#{msgs.addAdministratorPassword}"/>
								</th>
								<td>
									<h:inputSecret binding="#{backing_addAdministrator.addAdministratorPasswordInput}"
										size="25" required="true" id="password"
										value="#{backing_addAdministrator.password}">
										<f:validateLength minimum="1" maximum="512"/>
									</h:inputSecret>
								</td>
								<td>
									<h:message styleClass="error" for="password"/>
								</td>
							</tr>
							<tr class="odd">
								<th>
									<h:outputText value="#{msgs.addAdministratorPasswordConfirm}"/>
								</th>
								<td>
									<h:inputSecret binding="#{backing_addAdministrator.addAdministratorPasswordConfirmInput}"
										size="25" id="passwordConfirm" required="true" validator="#{backing_addAdministrator.validatePasswordConfirm}">
										<f:validateLength minimum="1" maximum="512"/>
									</h:inputSecret>
								</td>
								<td>
									<h:message styleClass="error" for="passwordConfirm"/>
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>
								</td>
								<td>
									<h:commandButton value="#{msgs.commonCancel}"
										action="#{backing_addAdministrator.cancel}" immediate="true"/>
									<h:commandButton value="#{backing_addAdministrator.updating ? msgs.commonUpdate : msgs.commonAdd}"
										immediate="false" action="#{backing_addAdministrator.addAdministrator}"/>
								</td>
							</tr>
						</tfoot>
					</table>
				</h:form>
			</div>
			<f:subview id="footer">
				<c:import url="commonFooter.jsp"/>
			</f:subview>
		</body>
	</html>
</f:view>
</jsp:root>