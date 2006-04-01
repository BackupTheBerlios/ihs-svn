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
			<c:import url="commonHeader.jsp"/>
			<f:verbatim><![CDATA[<div id="menu">]]></f:verbatim>
			<h:form id="commonMenu">
				<h:panelGrid>
					<h:panelGroup>
						<h:panelGrid columns="2" id="localeGrid">
							<h:commandLink id="en" immediate="true" 
								actionListener="#{locale.changeLocale}">
								<h:graphicImage value="/images/i18n/flags/en.png" style="border: 0px"/>
							</h:commandLink>
							
							<h:commandLink id="pl" immediate="true" 
								actionListener="#{locale.changeLocale}">
								<h:graphicImage value="/images/i18n/flags/pl.png" style="border: 0px"/>
							</h:commandLink>
						</h:panelGrid>
					</h:panelGroup>
				</h:panelGrid>
			</h:form>
			<f:verbatim><![CDATA[</div>]]></f:verbatim>

			<div id="main">
				<div id="content">
					<h2><h:outputText value="#{msgs.loginTitle}"/></h2>
				</div>
				<form method="POST" action="j_security_check">
					<p><h:outputText value="#{msgs.loginWelcome}"/></p>
					
					<h:panelGrid columns="2">
						<h:outputText value="#{msgs.commonLoginLabel}"/>
						<f:verbatim><input type="text" name="j_username"/></f:verbatim>
	
						<h:outputText value="#{msgs.commonPasswordLabel}"/>
						<f:verbatim><input type="password" name="j_password"/></f:verbatim>
	
						<h:panelGroup>
							<f:verbatim><![CDATA[<input type="submit" value="]]></f:verbatim>
							<h:outputText value="#{msgs.loginLoginButton}"/>
							<f:verbatim><![CDATA["/>]]></f:verbatim>
						</h:panelGroup>
					</h:panelGrid>
				</form>		
			</div>
			<c:import url="commonFooter.jsp"/>
		</body>
	</html>
</f:view>
</jsp:root>
