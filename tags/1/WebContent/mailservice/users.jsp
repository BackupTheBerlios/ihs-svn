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
			<link rel="stylesheet" href="../web.css" type="text/css" />
		</head>
		<body>
			<f:subview id="header">
				<c:import url="../commonHeader.jsp"/>
			</f:subview>
			<f:subview id="menu">
				<c:import url="../commonMenu.jsp"/>
			</f:subview>
			<div id="main">
				<h:form id="users">
					<div id="content">
						<h2>
							<h:outputText value="#{msgs.mailServiceUsersTitle}"/>
							<h:commandLink action="#{backing_domains.editDomain}" value="#{backing_users.domain}">
								<f:param name="idDomain" value="#{backing_users.idDomain}"/>
							</h:commandLink>
						</h2>
					</div>
					<h:panelGrid>
						<!-- result messages -->
						<h:panelGrid>
							<h:messages styleClass="error" globalOnly="false" layout="table"/>
							<h:outputText styleClass="message" value="#{backing_users.result}"/>
						</h:panelGrid>
				
						<h:dataTable id="usersList" rows="#{backing_configuration.maxUsersInList}" var="curUser"
							value="#{backing_users.users}" styleClass="listing">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.commonSelectHeader}"/>
								</f:facet>
								<h:selectBooleanCheckbox 
									value="#{curUser.selected}" id="selected"/>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.mailServiceUsersLoginHeader}"/>
								</f:facet>
								<h:commandLink action="#{backing_users.editUser}" value="#{curUser.login}">
									<f:param name="login" value="#{curUser.login}"/>
								</h:commandLink>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.mailServiceUsersFlagsHeader}"/>
								</f:facet>
								<h:outputText value="#{curUser.flags}"/>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.mailServiceUsersDirectoryHeader}"/>
								</f:facet>
								<h:outputText value="#{curUser.dir}"/>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.mailServiceUsersUidHeader}"/>
								</f:facet>
								<h:outputText value="#{curUser.uid}"/>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.mailServiceUsersGidHeader}"/>
								</f:facet>
								<h:outputText value="#{curUser.gid}"/>
							</h:column>
						</h:dataTable>
						<corejsf:pager dataTableId="usersList" 
							showpages="#{backing_configuration.maxPagesInPager}"
							selectedStyleClass="pagerSelected"
							styleClass="pager"/>

						<h:panelGroup>
							<h:commandButton value="#{msgs.commonAdd}"
								action="#{backing_users.addUser}"/>
							<h:commandButton value="#{msgs.commonRemove}"
								action="#{backing_users.removeUsers}"/>
							<h:commandButton value="#{msgs.commonReload}"
								action="reload"/>
						</h:panelGroup>
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