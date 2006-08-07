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
					<h2><h:outputText value="#{msgs.groupsTitle}"/></h2>
				</div>
				<h:form id="groups">
					<!-- result messages -->
					<h:panelGrid>
						<h:messages errorClass="error" fatalClass="fatal" globalOnly="false" layout="table"/>
						<h:outputText styleClass="message" value="#{backing_groups.result}"/>
					</h:panelGrid>

					<h:panelGrid>
						<h:dataTable rows="#{backing_configuration.maxAdministratorsInList}" 
							id="groupsList"
							var="curAdmin"
							value="#{backing_groups.groups}"
							styleClass="listing" rowClasses="odd,even">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.commonSelectHeader}"/>
								</f:facet>
								<h:selectBooleanCheckbox value="#{curAdmin.selected}" id="selected"/>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.groupsLoginHeader}"/>
								</f:facet>
								<h:commandLink action="#{backing_groups.editAdministrator}" value="#{curAdmin.login}">
									<f:param name="login" value="#{curAdmin.login}"/>
								</h:commandLink>
							</h:column>
						</h:dataTable>
		
						<corejsf:pager dataTableId="groupsList" 
							showpages="#{backing_configuration.maxPagesInPager}"
							selectedStyleClass="pagerSelected"
							styleClass="pager"/>
		
						<h:panelGroup>
							<h:commandButton value="#{msgs.commonAdd}"
								action="#{backing_groups.addAdministrator}"/>
							<h:commandButton value="#{msgs.commonRemove}"
								action="#{backing_groups.removeAdministrators}"/>
							<h:commandButton value="#{msgs.commonReload}"
								action="reload"/>
						</h:panelGroup>
					</h:panelGrid>
				</h:form>
			</div>
			<c:import url="/commonFooter.jsp"/>
		</body>
	</html>
</f:view>
</jsp:root>