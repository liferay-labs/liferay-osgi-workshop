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

package com.liferay.monitoring.web.portlet;

import aQute.bnd.annotation.metatype.Configurable;

import com.liferay.monitoring.web.configuration.MonitoringConfiguration;
import com.liferay.monitoring.whiteboard.collector.MetricsCollector;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Miguel Pastor
 */
@Component(
	configurationPid = "com.liferay.monitoring.web",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=portlet-liferay-monitoring",
		"com.liferay.portlet.display-category=category.tools",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=0",
		"com.liferay.portlet.remoteable=true",
		"javax.portlet.display-name=Liferay Monitoring",
		"com.liferay.portlet.struts-path=liferay_monitoring",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.preferences=classpath:/META-INF/portlet-preferences/default-portlet-preferences.xml",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MetricsPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
			MonitoringConfiguration.class.getName(),
			_monitoringConfiguration);

		renderRequest.setAttribute("metrics",  _metricsCollector.collect());

		super.doView(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_monitoringConfiguration = Configurable.createConfigurable(
			MonitoringConfiguration.class, properties);
	}

	@Reference
	protected void setMetricsCollector(MetricsCollector metricsCollector) {
		_metricsCollector = metricsCollector;
	}

	protected void unsetMetricsCollector(MetricsCollector metricsCollector) {
		_metricsCollector = null;
	}

	private MetricsCollector _metricsCollector;
	private volatile MonitoringConfiguration _monitoringConfiguration;

}