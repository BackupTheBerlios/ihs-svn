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
			<c:import url="../commonHeader.jsp"/>
			<c:import url="../commonMenu.jsp"/>

			<div id="main">
				<div id="content">
					<h2><h:outputText value="#{msgs.mailServiceDomainsTitle}"/></h2>
				</div>
				<h:form id="domains">
					<h:panelGrid>
						<!-- result messages -->
						<h:panelGrid>
							<h:messages styleClass="error" globalOnly="false" layout="table"/>
							<h:outputText styleClass="message" value="#{backing_domains.result}"/>
						</h:panelGrid>
		
						<h:dataTable id="domainsList" 
							rows="#{backing_configuration.maxDomainsInList}" var="curDomain"
							value="#{backing_domains.domains}" styleClass="listing">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{msgs.commonSelectHeader}"/>
								</f:facet>
								<h:selectBooleanCheckbox 
									value="#{curDomain.selected}" id="selected"/>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.domainsSorting.sortedByDomain}"
											actionListener="#{backing_mailService.domainsSorting.sortByDomain}">
											<h:outputText value="#{msgs.mailServiceDomainsDomainHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.domainsSorting.sortedByDomain}"
											value="#{msgs.mailServiceDomainsDomainHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:commandLink action="#{backing_domains.editDomain}" value="#{curDomain.domain}">
									<f:param name="idDomain" value="#{curDomain.idDomain}"/>
								</h:commandLink>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.domainsSorting.sortedByNumberOfUsers}"
											actionListener="#{backing_mailService.domainsSorting.sortByNumberOfUsers}">
											<h:outputText value="#{msgs.mailServiceDomainsUsersHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.domainsSorting.sortedByNumberOfUsers}"
											value="#{msgs.mailServiceDomainsUsersHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:commandLink action="#{backing_domains.listUsers}">
									<h:outputText value="#{curDomain.numberOfUsers}"/>
									<f:param name="idDomain" value="#{curDomain.idDomain}"/>
								</h:commandLink>
							</h:column>
						</h:dataTable>
						<corejsf:pager dataTableId="domainsList" 
							showpages="#{backing_configuration.maxPagesInPager}"
							selectedStyleClass="pagerSelected"
							styleClass="pager"/>

						<h:panelGroup>
							<h:commandButton value="#{msgs.commonAdd}"
								action="#{backing_domains.addDomain}"/>
							<h:commandButton value="#{msgs.commonRemove}"
								action="#{backing_domains.removeDomains}"/>
							<h:commandButton value="#{msgs.commonReload}"
								action="reload"/>
						</h:panelGroup>
					</h:panelGrid>
				</h:form>
			</div>
			<c:import url="../commonFooter.jsp"/>
		</body>
	</html>
</f:view>
</jsp:root>