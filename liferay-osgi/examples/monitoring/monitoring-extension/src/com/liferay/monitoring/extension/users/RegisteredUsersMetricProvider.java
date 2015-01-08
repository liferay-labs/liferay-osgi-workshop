package com.liferay.monitoring.extension.users;

import com.liferay.monitoring.model.Metric;
import com.liferay.monitoring.service.MetricLocalService;
import com.liferay.monitoring.whiteboard.model.MetricProvider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Random;

/**
 * @author Miguel Pastor
 */
@Component(immediate = true)
public class RegisteredUsersMetricProvider implements MetricProvider {
	@Override
	public Metric get() {
		Metric metric = _metricLocalService.createMetric(1);

		metric.setMetricName("Registered users");
		metric.setMetricValue(new Random().nextLong());

		return metric;
	}

	@Reference
	protected void setMetricLocalService(MetricLocalService metricLocalService) {
		_metricLocalService = metricLocalService;
	}

	protected void unsetMetricLocalService(MetricLocalService metricLocalService) {
		_metricLocalService = null;
	}

	private MetricLocalService _metricLocalService;

}
