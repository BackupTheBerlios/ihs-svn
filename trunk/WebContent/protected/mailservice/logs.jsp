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
				<h:form id="users">
					<div id="content">
						<h2>
							<h:outputText value="#{msgs.mailServiceLogsTitle}"/>
						</h2>
					</div>
					<h:panelGrid columns="6">
						<h:outputText value="#{msgs.mailServiceLogsDomainHeader}"/>
						<h:selectOneMenu value="#{backing_logs.domain}" onchange="submit()"
							valueChangeListener="#{backing_logs.domainChanged}">
							<f:selectItems value="#{backing_logs.domains}"/>
						</h:selectOneMenu>
						
						<h:outputText value="#{msgs.mailServiceLogsServiceHeader}"/>
						<h:selectOneMenu value="#{backing_logs.serviceType}" onchange="submit()"
							valueChangeListener="#{backing_logs.serviceTypeChanged}">
							<f:selectItems value="#{backing_logs.services}"/>
						</h:selectOneMenu>
						
						<h:outputText value="#{msgs.mailServiceLogsResultHeader}"/>
						<h:selectOneMenu value="#{backing_logs.resultType}" onchange="submit()"
							valueChangeListener="#{backing_logs.resultTypeChanged}">
							<f:selectItems value="#{backing_logs.results}"/>
						</h:selectOneMenu>
					</h:panelGrid>
					
					<!-- result messages -->
					<h:panelGrid>
						<h:messages errorClass="error" fatalClass="fatal" globalOnly="false" layout="table"/>
						<h:outputText styleClass="message" value="#{backing_logs.result}"/>
					</h:panelGrid>
					
					<h:panelGrid>
						<h:dataTable id="logsList" rows="#{backing_configuration.maxLogsInList}" var="curLog"
							value="#{backing_logs.logs}" styleClass="listing">
							<h:column>
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByTime}"
											actionListener="#{backing_mailService.logsSorting.sortByTime}">
											<h:outputText value="#{msgs.mailServiceLogsTimeHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByTime}"
											value="#{msgs.mailServiceLogsTimeHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.time}"/>
							</h:column>
							<h:column rendered="#{backing_logs.domainRendered}">
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByDomain}"
											actionListener="#{backing_mailService.logsSorting.sortByDomain}">
											<h:outputText value="#{msgs.mailServiceLogsDomainHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByDomain}"
											value="#{msgs.mailServiceLogsDomainHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.domain}"/>
							</h:column>
							<h:column rendered="#{backing_logs.loginRendered}">
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByLogin}"
											actionListener="#{backing_mailService.logsSorting.sortByLogin}">
											<h:outputText value="#{msgs.mailServiceLogsLoginHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByLogin}"
											value="#{msgs.mailServiceLogsLoginHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.login}"/>
							</h:column>
							<h:column rendered="#{backing_logs.serviceRendered}">
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByService}"
											actionListener="#{backing_mailService.logsSorting.sortByService}">
											<h:outputText value="#{msgs.mailServiceLogsServiceHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByService}"
											value="#{msgs.mailServiceLogsServiceHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.serviceAsString}"/>
							</h:column>
							<h:column rendered="#{backing_logs.resultRendered}">
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByResult}"
											actionListener="#{backing_mailService.logsSorting.sortByResult}">
											<h:outputText value="#{msgs.mailServiceLogsResultHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByResult}"
											value="#{msgs.mailServiceLogsResultHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.resultAsString}"/>
							</h:column>
							<h:column rendered="#{backing_logs.ipRendered}">
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByIp}"
											actionListener="#{backing_mailService.logsSorting.sortByIp}">
											<h:outputText value="#{msgs.mailServiceLogsIpHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByIp}"
											value="#{msgs.mailServiceLogsIpHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.ip}"/>
							</h:column>
							<h:column rendered="#{backing_logs.messageRendered}">
								<f:facet name="header">
									<h:panelGroup>
										<h:commandLink 
											rendered="#{!backing_mailService.logsSorting.sortedByMessage}"
											actionListener="#{backing_mailService.logsSorting.sortByMessage}">
											<h:outputText value="#{msgs.mailServiceLogsMessageHeader}"/>
										</h:commandLink>
										<h:outputText 
											rendered="#{backing_mailService.logsSorting.sortedByMessage}"
											value="#{msgs.mailServiceLogsMessageHeader}"/>
									</h:panelGroup>
								</f:facet>
								<h:outputText value="#{curLog.message}"/>
							</h:column>
						</h:dataTable>
						<corejsf:pager dataTableId="logsList" 
							showpages="#{backing_configuration.maxPagesInPager}"
							selectedStyleClass="pagerSelected"
							styleClass="pager"/>

						<h:panelGroup>
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