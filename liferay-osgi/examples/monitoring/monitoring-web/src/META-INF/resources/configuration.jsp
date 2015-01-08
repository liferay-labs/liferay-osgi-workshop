<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<liferay-ui:error exception="<%= ValidatorException.class %>">

		<%
		ValidatorException ve = (ValidatorException)errorException;
		%>

		<liferay-ui:message key="the-following-value-is-an-invalid-frequency" />

		<%
		Enumeration enu = ve.getFailedKeys();

		while (enu.hasMoreElements()) {
			String key = (String)enu.nextElement();
		%>

			<strong><%= key %></strong><%= (enu.hasMoreElements()) ? ", " : "." %>

		<%
		}
		%>

	</liferay-ui:error>

	<aui:fieldset>
		<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) || windowState.equals(LiferayWindowState.POP_UP) %>" cssClass="lfr-textarea-container" label="configure-frequency" name="preferences--frequency--" type="textarea" value="<%= frequency %>" wrap="soft" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>