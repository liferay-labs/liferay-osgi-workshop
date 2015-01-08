create table Metric (
	uuid_ VARCHAR(75) null,
	metricId LONG not null primary key,
	metricName VARCHAR(75) null,
	metricValue LONG,
	createDate DATE null
);