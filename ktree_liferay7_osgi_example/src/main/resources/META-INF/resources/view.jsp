<%@include file="init.jsp" %>
<aui:form action="<%=addContentToWikiUrl %>" name="wikiform">
<h3>Enter content here</h3>
	<liferay-ui:input-editor name="wikiEditor" placeholder="Enter content here"></liferay-ui:input-editor>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	<br/>
	<h3><u>Wiki List</u></h3>
	<liferay-portlet:runtime portletName="com_liferay_wiki_web_portlet_WikiPortlet"/>
</aui:form>