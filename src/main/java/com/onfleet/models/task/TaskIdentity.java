package com.onfleet.models.task;

public class TaskIdentity {
	private Integer failedScanCount;
	private Object checksum;

	public Integer getFailedScanCount() {
		return failedScanCount;
	}

	public void setFailedScanCount(Integer failedScanCount) {
		this.failedScanCount = failedScanCount;
	}

	public Object getChecksum() {
		return checksum;
	}

	public void setChecksum(Object checksum) {
		this.checksum = checksum;
	}
}
