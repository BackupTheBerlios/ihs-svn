<?xml version="1.0"?>
	<jsp:root version="2.0"
		xmlns:jsp="http://java.sun.com/JSP/Page"
		xmlns:f="http://java.sun.com/jsf/core"
		xmlns:h="http://java.sun.com/jsf/html"
		xmlns:c="http://java.sun.com/jstl/core">
					
	<jsp:directive.page contentType="text/html"/>
	<f:subview id="footer">
		<div id="footer">
			<f:verbatim><![CDATA[<a target="_blank" href="http://sourceforge.net/tracker/?func=add&group_id=134802&atid=731096">]]></f:verbatim>
				<h:outputText value="#{msgs.footerIssueABug}"/>
			<f:verbatim><![CDATA[</a>]]></f:verbatim>
			
			<f:verbatim>&amp;nbsp;|&amp;nbsp;</f:verbatim>
			
			<f:verbatim><![CDATA[<a target="_blank" href="http://ihs.foo-baz.com">]]></f:verbatim>
				<h:outputText value="#{msgs.footerProjectsPage}"/>
			<f:verbatim><![CDATA[</a>]]></f:verbatim>
		</div>
	</f:subview>
</jsp:root>