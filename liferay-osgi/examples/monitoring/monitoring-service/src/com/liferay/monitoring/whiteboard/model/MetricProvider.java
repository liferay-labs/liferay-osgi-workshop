package com.liferay.monitoring.whiteboard.model;

import com.liferay.monitoring.model.Metric;

/**
 * @author Miguel Pastor
 */
public interface MetricProvider {
	Metric get();
}
