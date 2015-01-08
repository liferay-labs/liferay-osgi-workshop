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

package com.liferay.monitoring.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.monitoring.exception.NoSuchMetricException;
import com.liferay.monitoring.model.Metric;
import com.liferay.monitoring.model.impl.MetricImpl;
import com.liferay.monitoring.model.impl.MetricModelImpl;
import com.liferay.monitoring.service.persistence.MetricPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the metric service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MetricPersistence
 * @see MetricUtil
 * @generated
 */
@ProviderType
public class MetricPersistenceImpl extends BasePersistenceImpl<Metric>
	implements MetricPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetricUtil} to access the metric persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetricImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricModelImpl.FINDER_CACHE_ENABLED, MetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricModelImpl.FINDER_CACHE_ENABLED, MetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricModelImpl.FINDER_CACHE_ENABLED, MetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricModelImpl.FINDER_CACHE_ENABLED, MetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MetricModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the metrics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching metrics
	 */
	@Override
	public List<Metric> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Metric> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Metric> findByUuid(String uuid, int start, int end,
		OrderByComparator<Metric> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Metric> list = (List<Metric>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Metric metric : list) {
				if (!Validator.equals(uuid, metric.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_METRIC_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MetricModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Metric>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Metric>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first metric in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metric
	 * @throws com.liferay.monitoring.NoSuchMetricException if a matching metric could not be found
	 */
	@Override
	public Metric findByUuid_First(String uuid,
		OrderByComparator<Metric> orderByComparator)
		throws NoSuchMetricException {
		Metric metric = fetchByUuid_First(uuid, orderByComparator);

		if (metric != null) {
			return metric;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMetricException(msg.toString());
	}

	/**
	 * Returns the first metric in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metric, or <code>null</code> if a matching metric could not be found
	 */
	@Override
	public Metric fetchByUuid_First(String uuid,
		OrderByComparator<Metric> orderByComparator) {
		List<Metric> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last metric in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metric
	 * @throws com.liferay.monitoring.NoSuchMetricException if a matching metric could not be found
	 */
	@Override
	public Metric findByUuid_Last(String uuid,
		OrderByComparator<Metric> orderByComparator)
		throws NoSuchMetricException {
		Metric metric = fetchByUuid_Last(uuid, orderByComparator);

		if (metric != null) {
			return metric;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMetricException(msg.toString());
	}

	/**
	 * Returns the last metric in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metric, or <code>null</code> if a matching metric could not be found
	 */
	@Override
	public Metric fetchByUuid_Last(String uuid,
		OrderByComparator<Metric> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Metric> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Metric[] findByUuid_PrevAndNext(long metricId, String uuid,
		OrderByComparator<Metric> orderByComparator)
		throws NoSuchMetricException {
		Metric metric = findByPrimaryKey(metricId);

		Session session = null;

		try {
			session = openSession();

			Metric[] array = new MetricImpl[3];

			array[0] = getByUuid_PrevAndNext(session, metric, uuid,
					orderByComparator, true);

			array[1] = metric;

			array[2] = getByUuid_PrevAndNext(session, metric, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Metric getByUuid_PrevAndNext(Session session, Metric metric,
		String uuid, OrderByComparator<Metric> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METRIC_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MetricModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(metric);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Metric> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the metrics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Metric metric : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(metric);
		}
	}

	/**
	 * Returns the number of metrics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching metrics
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_METRIC_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "metric.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "metric.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(metric.uuid IS NULL OR metric.uuid = '')";

	public MetricPersistenceImpl() {
		setModelClass(Metric.class);
	}

	/**
	 * Caches the metric in the entity cache if it is enabled.
	 *
	 * @param metric the metric
	 */
	@Override
	public void cacheResult(Metric metric) {
		EntityCacheUtil.putResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricImpl.class, metric.getPrimaryKey(), metric);

		metric.resetOriginalValues();
	}

	/**
	 * Caches the metrics in the entity cache if it is enabled.
	 *
	 * @param metrics the metrics
	 */
	@Override
	public void cacheResult(List<Metric> metrics) {
		for (Metric metric : metrics) {
			if (EntityCacheUtil.getResult(
						MetricModelImpl.ENTITY_CACHE_ENABLED, MetricImpl.class,
						metric.getPrimaryKey()) == null) {
				cacheResult(metric);
			}
			else {
				metric.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metrics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MetricImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MetricImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metric.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Metric metric) {
		EntityCacheUtil.removeResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricImpl.class, metric.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Metric> metrics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Metric metric : metrics) {
			EntityCacheUtil.removeResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
				MetricImpl.class, metric.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metric with the primary key. Does not add the metric to the database.
	 *
	 * @param metricId the primary key for the new metric
	 * @return the new metric
	 */
	@Override
	public Metric create(long metricId) {
		Metric metric = new MetricImpl();

		metric.setNew(true);
		metric.setPrimaryKey(metricId);

		String uuid = PortalUUIDUtil.generate();

		metric.setUuid(uuid);

		return metric;
	}

	/**
	 * Removes the metric with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metricId the primary key of the metric
	 * @return the metric that was removed
	 * @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	 */
	@Override
	public Metric remove(long metricId) throws NoSuchMetricException {
		return remove((Serializable)metricId);
	}

	/**
	 * Removes the metric with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metric
	 * @return the metric that was removed
	 * @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	 */
	@Override
	public Metric remove(Serializable primaryKey) throws NoSuchMetricException {
		Session session = null;

		try {
			session = openSession();

			Metric metric = (Metric)session.get(MetricImpl.class, primaryKey);

			if (metric == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetricException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metric);
		}
		catch (NoSuchMetricException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Metric removeImpl(Metric metric) {
		metric = toUnwrappedModel(metric);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metric)) {
				metric = (Metric)session.get(MetricImpl.class,
						metric.getPrimaryKeyObj());
			}

			if (metric != null) {
				session.delete(metric);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metric != null) {
			clearCache(metric);
		}

		return metric;
	}

	@Override
	public Metric updateImpl(com.liferay.monitoring.model.Metric metric) {
		metric = toUnwrappedModel(metric);

		boolean isNew = metric.isNew();

		MetricModelImpl metricModelImpl = (MetricModelImpl)metric;

		if (Validator.isNull(metric.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			metric.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (metric.isNew()) {
				session.save(metric);

				metric.setNew(false);
			}
			else {
				session.merge(metric);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MetricModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((metricModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { metricModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { metricModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
			MetricImpl.class, metric.getPrimaryKey(), metric, false);

		metric.resetOriginalValues();

		return metric;
	}

	protected Metric toUnwrappedModel(Metric metric) {
		if (metric instanceof MetricImpl) {
			return metric;
		}

		MetricImpl metricImpl = new MetricImpl();

		metricImpl.setNew(metric.isNew());
		metricImpl.setPrimaryKey(metric.getPrimaryKey());

		metricImpl.setUuid(metric.getUuid());
		metricImpl.setMetricId(metric.getMetricId());
		metricImpl.setMetricName(metric.getMetricName());
		metricImpl.setMetricValue(metric.getMetricValue());
		metricImpl.setCreateDate(metric.getCreateDate());

		return metricImpl;
	}

	/**
	 * Returns the metric with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metric
	 * @return the metric
	 * @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	 */
	@Override
	public Metric findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetricException {
		Metric metric = fetchByPrimaryKey(primaryKey);

		if (metric == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetricException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metric;
	}

	/**
	 * Returns the metric with the primary key or throws a {@link com.liferay.monitoring.NoSuchMetricException} if it could not be found.
	 *
	 * @param metricId the primary key of the metric
	 * @return the metric
	 * @throws com.liferay.monitoring.NoSuchMetricException if a metric with the primary key could not be found
	 */
	@Override
	public Metric findByPrimaryKey(long metricId) throws NoSuchMetricException {
		return findByPrimaryKey((Serializable)metricId);
	}

	/**
	 * Returns the metric with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metric
	 * @return the metric, or <code>null</code> if a metric with the primary key could not be found
	 */
	@Override
	public Metric fetchByPrimaryKey(Serializable primaryKey) {
		Metric metric = (Metric)EntityCacheUtil.getResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
				MetricImpl.class, primaryKey);

		if (metric == _nullMetric) {
			return null;
		}

		if (metric == null) {
			Session session = null;

			try {
				session = openSession();

				metric = (Metric)session.get(MetricImpl.class, primaryKey);

				if (metric != null) {
					cacheResult(metric);
				}
				else {
					EntityCacheUtil.putResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
						MetricImpl.class, primaryKey, _nullMetric);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
					MetricImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metric;
	}

	/**
	 * Returns the metric with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metricId the primary key of the metric
	 * @return the metric, or <code>null</code> if a metric with the primary key could not be found
	 */
	@Override
	public Metric fetchByPrimaryKey(long metricId) {
		return fetchByPrimaryKey((Serializable)metricId);
	}

	@Override
	public Map<Serializable, Metric> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Metric> map = new HashMap<Serializable, Metric>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Metric metric = fetchByPrimaryKey(primaryKey);

			if (metric != null) {
				map.put(primaryKey, metric);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Metric metric = (Metric)EntityCacheUtil.getResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
					MetricImpl.class, primaryKey);

			if (metric == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, metric);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_METRIC_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Metric metric : (List<Metric>)q.list()) {
				map.put(metric.getPrimaryKeyObj(), metric);

				cacheResult(metric);

				uncachedPrimaryKeys.remove(metric.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(MetricModelImpl.ENTITY_CACHE_ENABLED,
					MetricImpl.class, primaryKey, _nullMetric);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the metrics.
	 *
	 * @return the metrics
	 */
	@Override
	public List<Metric> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Metric> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Metric> findAll(int start, int end,
		OrderByComparator<Metric> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Metric> list = (List<Metric>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_METRIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METRIC;

				if (pagination) {
					sql = sql.concat(MetricModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Metric>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Metric>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the metrics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Metric metric : findAll()) {
			remove(metric);
		}
	}

	/**
	 * Returns the number of metrics.
	 *
	 * @return the number of metrics
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_METRIC);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the metric persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MetricImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_METRIC = "SELECT metric FROM Metric metric";
	private static final String _SQL_SELECT_METRIC_WHERE_PKS_IN = "SELECT metric FROM Metric metric WHERE metricId IN (";
	private static final String _SQL_SELECT_METRIC_WHERE = "SELECT metric FROM Metric metric WHERE ";
	private static final String _SQL_COUNT_METRIC = "SELECT COUNT(metric) FROM Metric metric";
	private static final String _SQL_COUNT_METRIC_WHERE = "SELECT COUNT(metric) FROM Metric metric WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metric.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Metric exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Metric exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = com.liferay.portal.util.PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
	private static final Log _log = LogFactoryUtil.getLog(MetricPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final Metric _nullMetric = new MetricImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Metric> toCacheModel() {
				return _nullMetricCacheModel;
			}
		};

	private static final CacheModel<Metric> _nullMetricCacheModel = new CacheModel<Metric>() {
			@Override
			public Metric toEntityModel() {
				return _nullMetric;
			}
		};
}