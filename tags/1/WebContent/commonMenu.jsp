<?xml version="1.0"?>
<jsp:root version="2.0"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core">
	
	<jsp:directive.page contentType="text/html"/>
	<f:verbatim><![CDATA[<div id="menu"><ul>]]></f:verbatim>
	
	<f:verbatim><![CDATA[<li><a href="/ihs/faces/configuration.jsp">]]></f:verbatim>
		<h:outputText value="#{msgs.configurationTitle}"/>
	<f:verbatim><![CDATA[</a></li>]]></f:verbatim>

	<f:verbatim><![CDATA[<li><a href="/ihs/faces/administrators.jsp">]]></f:verbatim>
		<h:outputText value="#{msgs.administratorsTitle}"/>
	<f:verbatim><![CDATA[</a></li>]]></f:verbatim>
	
	<f:verbatim><![CDATA[<li><a href="/ihs/faces/addAdministrator.jsp">]]></f:verbatim>
		<h:outputText value="#{msgs.addAdministratorTitle}"/>
	<f:verbatim><![CDATA[</a></li>]]></f:verbatim>
		
	<f:verbatim><![CDATA[<li><a href="/ihs/faces/mailservice/domains.jsp">]]></f:verbatim>
		<h:outputText value="#{msgs.mailServiceDomainsTitle}"/>
	<f:verbatim><![CDATA[</a></li>]]></f:verbatim>

	<f:verbatim><![CDATA[<li><a href="/ihs/faces/mailservice/addDomain.jsp">]]></f:verbatim>
		<h:outputText value="#{msgs.mailServiceAddDomainTitle}"/>
	<f:verbatim><![CDATA[</a></li>]]></f:verbatim>
	
	<f:verbatim><![CDATA[</ul></div>]]></f:verbatim>
</jsp:root>