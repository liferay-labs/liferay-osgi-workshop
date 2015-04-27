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

package com.liferay.auth.pub.path.internal;

import com.liferay.portal.kernel.struts.path.AuthPublicPath;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Pastor
 */
@Component(
	immediate = true,
	property = "auth.public.path=/portal/update_reminder_query"
)
public class SimpleAuthPublicPath implements AuthPublicPath {
	@Override
	public String path() {
		return _path;
	}

	@Activate
	protected void activate(Map<String, String> properties) {
		updatePath(properties);
	}

	protected void updatePath(Map<String, String> properties) {
		if (!properties.containsKey("auth.public.path")) {
			_path = null;

			return;
		}

		String path = properties.get("auth.public.path");

		_path = path;
	}

	private String _path;

}