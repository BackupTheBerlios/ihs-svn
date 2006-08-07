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
					<h2><h:outputText value="#{msgs.configurationPluginsTitle}"/></h2>
				</div>
				
				<h:form id="plguins">
					<h:dataTable id="pluginsList"
						var="curItem"
						value="#{backing_configurationPlugins.plugins}"
						styleClass="listing" rowClasses="odd,even">
						<h:column>
							<f:facet name="header">
								<h:outputText value="#{msgs.configurationPluginsPluginClassHeader}"/>
							</f:facet>
							<h:panelGrid>
								<h:outputText value="#{curItem}"/>
							</h:panelGrid>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
			<c:import url="/commonFooter.jsp"/>
		</body>
	</html>
</f:view>
</jsp:root>
