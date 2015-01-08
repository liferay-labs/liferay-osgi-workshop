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

import com.liferay.monitoring.exception.NoSuchMetricException;
import com.liferay.monitoring.model.Metric;
import com.liferay.monitoring.service.MetricLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AggregateTestRule;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.PersistenceTestRule;
import com.liferay.portal.test.TransactionalTestRule;
import com.liferay.portal.util.test.RandomTestUtil;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class MetricPersistenceTest {
	@Rule
	public final AggregateTestRule aggregateTestRule = new AggregateTestRule(PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@After
	public void tearDown() throws Exception {
		Iterator<Metric> iterator = _metrics.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Metric metric = _persistence.create(pk);

		Assert.assertNotNull(metric);

		Assert.assertEquals(metric.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Metric newMetric = addMetric();

		_persistence.remove(newMetric);

		Metric existingMetric = _persistence.fetchByPrimaryKey(newMetric.getPrimaryKey());

		Assert.assertNull(existingMetric);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addMetric();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Metric newMetric = _persistence.create(pk);

		newMetric.setUuid(RandomTestUtil.randomString());

		newMetric.setMetricName(RandomTestUtil.randomString());

		newMetric.setMetricValue(RandomTestUtil.nextLong());

		newMetric.setCreateDate(RandomTestUtil.nextDate());

		_metrics.add(_persistence.update(newMetric));

		Metric existingMetric = _persistence.findByPrimaryKey(newMetric.getPrimaryKey());

		Assert.assertEquals(existingMetric.getUuid(), newMetric.getUuid());
		Assert.assertEquals(existingMetric.getMetricId(),
			newMetric.getMetricId());
		Assert.assertEquals(existingMetric.getMetricName(),
			newMetric.getMetricName());
		Assert.assertEquals(existingMetric.getMetricValue(),
			newMetric.getMetricValue());
		Assert.assertEquals(Time.getShortTimestamp(
				existingMetric.getCreateDate()),
			Time.getShortTimestamp(newMetric.getCreateDate()));
	}

	@Test
	public void testCountByUuid() {
		try {
			_persistence.countByUuid(StringPool.BLANK);

			_persistence.countByUuid(StringPool.NULL);

			_persistence.countByUuid((String)null);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Metric newMetric = addMetric();

		Metric existingMetric = _persistence.findByPrimaryKey(newMetric.getPrimaryKey());

		Assert.assertEquals(existingMetric, newMetric);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchMetricException");
		}
		catch (NoSuchMetricException nsee) {
		}
	}

	@Test
	public void testFindAll() throws Exception {
		try {
			_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				getOrderByComparator());
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	protected OrderByComparator<Metric> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Metric", "uuid", true,
			"metricId", true, "metricName", true, "metricValue", true,
			"createDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Metric newMetric = addMetric();

		Metric existingMetric = _persistence.fetchByPrimaryKey(newMetric.getPrimaryKey());

		Assert.assertEquals(existingMetric, newMetric);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Metric missingMetric = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingMetric);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Metric newMetric1 = addMetric();
		Metric newMetric2 = addMetric();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMetric1.getPrimaryKey());
		primaryKeys.add(newMetric2.getPrimaryKey());

		Map<Serializable, Metric> metrics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, metrics.size());
		Assert.assertEquals(newMetric1, metrics.get(newMetric1.getPrimaryKey()));
		Assert.assertEquals(newMetric2, metrics.get(newMetric2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Metric> metrics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(metrics.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Metric newMetric = addMetric();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMetric.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Metric> metrics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, metrics.size());
		Assert.assertEquals(newMetric, metrics.get(newMetric.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Metric> metrics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(metrics.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Metric newMetric = addMetric();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMetric.getPrimaryKey());

		Map<Serializable, Metric> metrics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, metrics.size());
		Assert.assertEquals(newMetric, metrics.get(newMetric.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = MetricLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod() {
				@Override
				public void performAction(Object object) {
					Metric metric = (Metric)object;

					Assert.assertNotNull(metric);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Metric newMetric = addMetric();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Metric.class,
				Metric.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("metricId",
				newMetric.getMetricId()));

		List<Metric> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Metric existingMetric = result.get(0);

		Assert.assertEquals(existingMetric, newMetric);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Metric.class,
				Metric.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("metricId",
				RandomTestUtil.nextLong()));

		List<Metric> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Metric newMetric = addMetric();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Metric.class,
				Metric.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("metricId"));

		Object newMetricId = newMetric.getMetricId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("metricId",
				new Object[] { newMetricId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingMetricId = result.get(0);

		Assert.assertEquals(existingMetricId, newMetricId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Metric.class,
				Metric.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("metricId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("metricId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Metric addMetric() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Metric metric = _persistence.create(pk);

		metric.setUuid(RandomTestUtil.randomString());

		metric.setMetricName(RandomTestUtil.randomString());

		metric.setMetricValue(RandomTestUtil.nextLong());

		metric.setCreateDate(RandomTestUtil.nextDate());

		_metrics.add(_persistence.update(metric));

		return metric;
	}

	private List<Metric> _metrics = new ArrayList<Metric>();
	private MetricPersistence _persistence = MetricUtil.getPersistence();
}