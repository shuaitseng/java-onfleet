package com.onfleet.models.worker;

public class WorkerAddresses {
	private WorkerRouting routing;

	public WorkerAddresses(WorkerRouting routing) {
		this.routing = routing;
	}

	public WorkerRouting getRouting() {
		return routing;
	}

	public void setRouting(WorkerRouting routing) {
		this.routing = routing;
	}
}
