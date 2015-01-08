package com.liferay.monitoring.whiteboard.internal.provider;

import com.liferay.monitoring.model.Metric;
import com.liferay.monitoring.model.impl.MetricImpl;
import com.liferay.monitoring.whiteboard.model.MetricProvider;
import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Pastor
 */
@Component(immediate = true)
public class MemoryUsageProvider implements MetricProvider {
	@Override
	public Metric get() {
		Metric metric = new MetricImpl();

		Runtime runtime = Runtime.getRuntime();
		metric.setMetricValue(runtime.totalMemory() - runtime.freeMemory());

		return metric;
	}

}
