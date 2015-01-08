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

package com.liferay.monitoring.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.monitoring.model.Metric;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the metric service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MetricPersistenceImpl
 * @see MetricUtil
 * @generated
 */
@ProviderType
public interface MetricPersistence extends BasePersistence<Metric> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MetricUtil} to access the metric persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the metrics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching metrics
	*/
	public java.util.List<com.liferay.monitoring.model.Metric> findByUuid(
		java.lang.String uuid);

	/**
	* Returns a range of all the metrics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitoring.model.impl.MetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of metrics
	* @param end the upper bound of the range of metrics (not inclusive)
	* @return the range of matching metrics
	*/
	public java.util.List<com.liferay.monitoring.model.Metric> findByUuid(
		java.lang.String uuid, int start, int end);

	/**
	* Returns an ordered range of all the metrics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitoring.model.impl.MetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of metrics
	* @param end the upper bound of the range of metrics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching metrics
	*/
	public java.util.List<com.liferay.monitoring.model.Metric> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator);

	/**
	* Returns the first metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a matching metric could not be found
	*/
	public com.liferay.monitoring.model.Metric findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator)
		throws com.liferay.monitoring.exception.NoSuchMetricException;

	/**
	* Returns the first metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching metric, or <code>null</code> if a matching metric could not be found
	*/
	public com.liferay.monitoring.model.Metric fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator);

	/**
	* Returns the last metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a matching metric could not be found
	*/
	public com.liferay.monitoring.model.Metric findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator)
		throws com.liferay.monitoring.exception.NoSuchMetricException;

	/**
	* Returns the last metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching metric, or <code>null</code> if a matching metric could not be found
	*/
	public com.liferay.monitoring.model.Metric fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator);

	/**
	* Returns the metrics before and after the current metric in the ordered set where uuid = &#63;.
	*
	* @param metricId the primary key of the current metric
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	*/
	public com.liferay.monitoring.model.Metric[] findByUuid_PrevAndNext(
		long metricId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator)
		throws com.liferay.monitoring.exception.NoSuchMetricException;

	/**
	* Removes all the metrics where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of metrics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching metrics
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the metric in the entity cache if it is enabled.
	*
	* @param metric the metric
	*/
	public void cacheResult(com.liferay.monitoring.model.Metric metric);

	/**
	* Caches the metrics in the entity cache if it is enabled.
	*
	* @param metrics the metrics
	*/
	public void cacheResult(
		java.util.List<com.liferay.monitoring.model.Metric> metrics);

	/**
	* Creates a new metric with the primary key. Does not add the metric to the database.
	*
	* @param metricId the primary key for the new metric
	* @return the new metric
	*/
	public com.liferay.monitoring.model.Metric create(long metricId);

	/**
	* Removes the metric with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metricId the primary key of the metric
	* @return the metric that was removed
	* @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	*/
	public com.liferay.monitoring.model.Metric remove(long metricId)
		throws com.liferay.monitoring.exception.NoSuchMetricException;

	public com.liferay.monitoring.model.Metric updateImpl(
		com.liferay.monitoring.model.Metric metric);

	/**
	* Returns the metric with the primary key or throws a {@link com.liferay.monitoring.NoSuchMetricException} if it could not be found.
	*
	* @param metricId the primary key of the metric
	* @return the metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	*/
	public com.liferay.monitoring.model.Metric findByPrimaryKey(long metricId)
		throws com.liferay.monitoring.exception.NoSuchMetricException;

	/**
	* Returns the metric with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metricId the primary key of the metric
	* @return the metric, or <code>null</code> if a metric with the primary key could not be found
	*/
	public com.liferay.monitoring.model.Metric fetchByPrimaryKey(long metricId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.monitoring.model.Metric> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the metrics.
	*
	* @return the metrics
	*/
	public java.util.List<com.liferay.monitoring.model.Metric> findAll();

	/**
	* Returns a range of all the metrics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitoring.model.impl.MetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metrics
	* @param end the upper bound of the range of metrics (not inclusive)
	* @return the range of metrics
	*/
	public java.util.List<com.liferay.monitoring.model.Metric> findAll(
		int start, int end);

	/**
	* Returns an ordered range of all the metrics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitoring.model.impl.MetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metrics
	* @param end the upper bound of the range of metrics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of metrics
	*/
	public java.util.List<com.liferay.monitoring.model.Metric> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator);

	/**
	* Removes all the metrics from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of metrics.
	*
	* @return the number of metrics
	*/
	public int countAll();
}