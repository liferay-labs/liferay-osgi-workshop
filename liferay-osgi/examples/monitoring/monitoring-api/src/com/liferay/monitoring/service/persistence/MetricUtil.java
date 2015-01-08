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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the metric service. This utility wraps {@link MetricPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MetricPersistence
 * @see MetricPersistenceImpl
 * @generated
 */
@ProviderType
public class MetricUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Metric metric) {
		getPersistence().clearCache(metric);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Metric> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Metric> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Metric> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Metric> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Metric update(Metric metric) {
		return getPersistence().update(metric);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Metric update(Metric metric, ServiceContext serviceContext) {
		return getPersistence().update(metric, serviceContext);
	}

	/**
	* Returns all the metrics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching metrics
	*/
	public static java.util.List<com.liferay.monitoring.model.Metric> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.liferay.monitoring.model.Metric> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.liferay.monitoring.model.Metric> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a matching metric could not be found
	*/
	public static com.liferay.monitoring.model.Metric findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator)
		throws com.liferay.monitoring.exception.NoSuchMetricException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching metric, or <code>null</code> if a matching metric could not be found
	*/
	public static com.liferay.monitoring.model.Metric fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a matching metric could not be found
	*/
	public static com.liferay.monitoring.model.Metric findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator)
		throws com.liferay.monitoring.exception.NoSuchMetricException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last metric in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching metric, or <code>null</code> if a matching metric could not be found
	*/
	public static com.liferay.monitoring.model.Metric fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the metrics before and after the current metric in the ordered set where uuid = &#63;.
	*
	* @param metricId the primary key of the current metric
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	*/
	public static com.liferay.monitoring.model.Metric[] findByUuid_PrevAndNext(
		long metricId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator)
		throws com.liferay.monitoring.exception.NoSuchMetricException {
		return getPersistence()
				   .findByUuid_PrevAndNext(metricId, uuid, orderByComparator);
	}

	/**
	* Removes all the metrics where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of metrics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching metrics
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the metric in the entity cache if it is enabled.
	*
	* @param metric the metric
	*/
	public static void cacheResult(com.liferay.monitoring.model.Metric metric) {
		getPersistence().cacheResult(metric);
	}

	/**
	* Caches the metrics in the entity cache if it is enabled.
	*
	* @param metrics the metrics
	*/
	public static void cacheResult(
		java.util.List<com.liferay.monitoring.model.Metric> metrics) {
		getPersistence().cacheResult(metrics);
	}

	/**
	* Creates a new metric with the primary key. Does not add the metric to the database.
	*
	* @param metricId the primary key for the new metric
	* @return the new metric
	*/
	public static com.liferay.monitoring.model.Metric create(long metricId) {
		return getPersistence().create(metricId);
	}

	/**
	* Removes the metric with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metricId the primary key of the metric
	* @return the metric that was removed
	* @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	*/
	public static com.liferay.monitoring.model.Metric remove(long metricId)
		throws com.liferay.monitoring.exception.NoSuchMetricException {
		return getPersistence().remove(metricId);
	}

	public static com.liferay.monitoring.model.Metric updateImpl(
		com.liferay.monitoring.model.Metric metric) {
		return getPersistence().updateImpl(metric);
	}

	/**
	* Returns the metric with the primary key or throws a {@link com.liferay.monitoring.NoSuchMetricException} if it could not be found.
	*
	* @param metricId the primary key of the metric
	* @return the metric
	* @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	*/
	public static com.liferay.monitoring.model.Metric findByPrimaryKey(
		long metricId)
		throws com.liferay.monitoring.exception.NoSuchMetricException {
		return getPersistence().findByPrimaryKey(metricId);
	}

	/**
	* Returns the metric with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metricId the primary key of the metric
	* @return the metric, or <code>null</code> if a metric with the primary key could not be found
	*/
	public static com.liferay.monitoring.model.Metric fetchByPrimaryKey(
		long metricId) {
		return getPersistence().fetchByPrimaryKey(metricId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.monitoring.model.Metric> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the metrics.
	*
	* @return the metrics
	*/
	public static java.util.List<com.liferay.monitoring.model.Metric> findAll() {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.monitoring.model.Metric> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.monitoring.model.Metric> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.monitoring.model.Metric> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the metrics from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of metrics.
	*
	* @return the number of metrics
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MetricPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(MetricPersistence persistence) {
	}

	private static ServiceTracker<MetricPersistence, MetricPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MetricUtil.class);

		_serviceTracker = new ServiceTracker<MetricPersistence, MetricPersistence>(bundle.getBundleContext(),
				MetricPersistence.class, null);

		_serviceTracker.open();
	}
}