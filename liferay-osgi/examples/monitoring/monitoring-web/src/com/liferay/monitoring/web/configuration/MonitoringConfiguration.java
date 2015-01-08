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

package com.liferay.monitoring.web.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Miguel Pastor
 */
@Meta.OCD(id = "com.liferay.monitoring.web")
public interface MonitoringConfiguration {
	@Meta.AD(
		deflt = "10000",
		required = false)
	public String frequency();

}