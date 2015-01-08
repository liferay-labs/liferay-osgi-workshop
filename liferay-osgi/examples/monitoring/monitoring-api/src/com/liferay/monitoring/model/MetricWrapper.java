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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Metric}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Metric
 * @generated
 */
@ProviderType
public class MetricWrapper implements Metric, ModelWrapper<Metric> {
	public MetricWrapper(Metric metric) {
		_metric = metric;
	}

	@Override
	public Class<?> getModelClass() {
		return Metric.class;
	}

	@Override
	public String getModelClassName() {
		return Metric.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("metricId", getMetricId());
		attributes.put("metricName", getMetricName());
		attributes.put("metricValue", getMetricValue());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long metricId = (Long)attributes.get("metricId");

		if (metricId != null) {
			setMetricId(metricId);
		}

		String metricName = (String)attributes.get("metricName");

		if (metricName != null) {
			setMetricName(metricName);
		}

		Long metricValue = (Long)attributes.get("metricValue");

		if (metricValue != null) {
			setMetricValue(metricValue);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new MetricWrapper((Metric)_metric.clone());
	}

	@Override
	public int compareTo(com.liferay.monitoring.model.Metric metric) {
		return _metric.compareTo(metric);
	}

	/**
	* Returns the create date of this metric.
	*
	* @return the create date of this metric
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _metric.getCreateDate();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metric.getExpandoBridge();
	}

	/**
	* Returns the metric ID of this metric.
	*
	* @return the metric ID of this metric
	*/
	@Override
	public long getMetricId() {
		return _metric.getMetricId();
	}

	/**
	* Returns the metric name of this metric.
	*
	* @return the metric name of this metric
	*/
	@Override
	public java.lang.String getMetricName() {
		return _metric.getMetricName();
	}

	/**
	* Returns the metric value of this metric.
	*
	* @return the metric value of this metric
	*/
	@Override
	public long getMetricValue() {
		return _metric.getMetricValue();
	}

	/**
	* Returns the primary key of this metric.
	*
	* @return the primary key of this metric
	*/
	@Override
	public long getPrimaryKey() {
		return _metric.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metric.getPrimaryKeyObj();
	}

	/**
	* Returns the uuid of this metric.
	*
	* @return the uuid of this metric
	*/
	@Override
	public java.lang.String getUuid() {
		return _metric.getUuid();
	}

	@Override
	public int hashCode() {
		return _metric.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _metric.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _metric.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _metric.isNew();
	}

	@Override
	public void persist() {
		_metric.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metric.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this metric.
	*
	* @param createDate the create date of this metric
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_metric.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metric.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metric.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metric.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the metric ID of this metric.
	*
	* @param metricId the metric ID of this metric
	*/
	@Override
	public void setMetricId(long metricId) {
		_metric.setMetricId(metricId);
	}

	/**
	* Sets the metric name of this metric.
	*
	* @param metricName the metric name of this metric
	*/
	@Override
	public void setMetricName(java.lang.String metricName) {
		_metric.setMetricName(metricName);
	}

	/**
	* Sets the metric value of this metric.
	*
	* @param metricValue the metric value of this metric
	*/
	@Override
	public void setMetricValue(long metricValue) {
		_metric.setMetricValue(metricValue);
	}

	@Override
	public void setNew(boolean n) {
		_metric.setNew(n);
	}

	/**
	* Sets the primary key of this metric.
	*
	* @param primaryKey the primary key of this metric
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metric.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metric.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this metric.
	*
	* @param uuid the uuid of this metric
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_metric.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.monitoring.model.Metric> toCacheModel() {
		return _metric.toCacheModel();
	}

	@Override
	public com.liferay.monitoring.model.Metric toEscapedModel() {
		return new MetricWrapper(_metric.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metric.toString();
	}

	@Override
	public com.liferay.monitoring.model.Metric toUnescapedModel() {
		return new MetricWrapper(_metric.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _metric.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetricWrapper)) {
			return false;
		}

		MetricWrapper metricWrapper = (MetricWrapper)obj;

		if (Validator.equals(_metric, metricWrapper._metric)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public Metric getWrappedMetric() {
		return _metric;
	}

	@Override
	public Metric getWrappedModel() {
		return _metric;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _metric.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _metric.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_metric.resetOriginalValues();
	}

	private final Metric _metric;
}