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

package com.liferay.monitoring.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.monitoring.model.Metric;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Metric in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Metric
 * @generated
 */
@ProviderType
public class MetricCacheModel implements CacheModel<Metric>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetricCacheModel)) {
			return false;
		}

		MetricCacheModel metricCacheModel = (MetricCacheModel)obj;

		if (metricId == metricCacheModel.metricId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, metricId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", metricId=");
		sb.append(metricId);
		sb.append(", metricName=");
		sb.append(metricName);
		sb.append(", metricValue=");
		sb.append(metricValue);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Metric toEntityModel() {
		MetricImpl metricImpl = new MetricImpl();

		if (uuid == null) {
			metricImpl.setUuid(StringPool.BLANK);
		}
		else {
			metricImpl.setUuid(uuid);
		}

		metricImpl.setMetricId(metricId);

		if (metricName == null) {
			metricImpl.setMetricName(StringPool.BLANK);
		}
		else {
			metricImpl.setMetricName(metricName);
		}

		metricImpl.setMetricValue(metricValue);

		if (createDate == Long.MIN_VALUE) {
			metricImpl.setCreateDate(null);
		}
		else {
			metricImpl.setCreateDate(new Date(createDate));
		}

		metricImpl.resetOriginalValues();

		return metricImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		metricId = objectInput.readLong();
		metricName = objectInput.readUTF();
		metricValue = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(metricId);

		if (metricName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metricName);
		}

		objectOutput.writeLong(metricValue);
		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long metricId;
	public String metricName;
	public long metricValue;
	public long createDate;
}