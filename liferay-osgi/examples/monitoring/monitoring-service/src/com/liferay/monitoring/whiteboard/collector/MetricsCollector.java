package com.liferay.monitoring.whiteboard.collector;

import com.liferay.monitoring.model.Metric;
import com.liferay.monitoring.whiteboard.model.MetricProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Miguel Pastor
 */
@Component(immediate = true, service = MetricsCollector.class)
public class MetricsCollector {

	public List<Metric> collect() {
		List<Metric> metrics = new ArrayList<>(_metricProviders.size());

		for (MetricProvider metricProvider : _metricProviders) {
			metrics.add(metricProvider.get());
		}

		return metrics;
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		unbind = "removeMetricProvider")
	protected void addMetricProvider(MetricProvider metricProvider) {
		_metricProviders.add(metricProvider);
	}

	protected void removeMetricProvider(MetricProvider metricProvider) {
		_metricProviders.remove(metricProvider);
	}

	private List<MetricProvider> _metricProviders = new CopyOnWriteArrayList<>();
}
