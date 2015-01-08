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

package com.liferay.monitoring.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.monitoring.service.http.MetricServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.monitoring.service.http.MetricServiceSoap
 * @generated
 */
@ProviderType
public class MetricSoap implements Serializable {
	public static MetricSoap toSoapModel(Metric model) {
		MetricSoap soapModel = new MetricSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMetricId(model.getMetricId());
		soapModel.setMetricName(model.getMetricName());
		soapModel.setMetricValue(model.getMetricValue());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static MetricSoap[] toSoapModels(Metric[] models) {
		MetricSoap[] soapModels = new MetricSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetricSoap[][] toSoapModels(Metric[][] models) {
		MetricSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetricSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetricSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetricSoap[] toSoapModels(List<Metric> models) {
		List<MetricSoap> soapModels = new ArrayList<MetricSoap>(models.size());

		for (Metric model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetricSoap[soapModels.size()]);
	}

	public MetricSoap() {
	}

	public long getPrimaryKey() {
		return _metricId;
	}

	public void setPrimaryKey(long pk) {
		setMetricId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMetricId() {
		return _metricId;
	}

	public void setMetricId(long metricId) {
		_metricId = metricId;
	}

	public String getMetricName() {
		return _metricName;
	}

	public void setMetricName(String metricName) {
		_metricName = metricName;
	}

	public long getMetricValue() {
		return _metricValue;
	}

	public void setMetricValue(long metricValue) {
		_metricValue = metricValue;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private String _uuid;
	private long _metricId;
	private String _metricName;
	private long _metricValue;
	private Date _createDate;
}