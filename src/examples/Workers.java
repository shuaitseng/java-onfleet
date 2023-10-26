public class Workers {
	private static final OnFleet onFleet = new OnFleet("ApiKey");


	public void createWorker() {
		// https://docs.onfleet.com/reference/create-worker
		WorkerVehicle vehicle = new WorkerVehicle.Builder(VehicleType.CAR).build();
		WorkerCreateParams params = new WorkerCreateParams.Builder("A Swartz", "617-342-8853", Collections.singletonList("nz1nG1Hpx9EHjQCJsT2VAs~o"))
				.setWorkerVehicle(vehicle)
				.build();
		onFleet.getWorkerApi().createWorker(params);
	}

	public void listWorkers() {
		// https://docs.onfleet.com/reference/list-workers
		onFleet.getWorkerApi().listWorkers();
	}

	public void getWorkersTasks() {
		// https://docs.onfleet.com/reference/list-workers-assigned-tasks
		onFleet.getWorkerApi().getWorkersTasks("sFtvhYK2l26zS0imptJJdC2q");
	}

	public void getWorkersByLocation() {
		// https://docs.onfleet.com/reference/get-workers-by-location
		onFleet.getWorkerApi().getWorkersByLocation(-122.41275787353516, 37.78998061344339, 6000);
	}

	public void getSingleWorker() {
		// https://docs.onfleet.com/reference/get-single-worker
		WorkerQueryParams queryParams = new WorkerQueryParams.Builder()
				.setEnableAnalytics(true)
				.build();
		onFleet.getWorkerApi().getSingleWorker("1LjhGUWdxFbvdsTAAXs0TFos", queryParams);
	}

	public void updateWorker() {
		// https://docs.onfleet.com/reference/update-worker
		WorkerUpdateParams updateParams = new WorkerUpdateParams.Builder()
				.setName("Laura P")
				.setTeams(Collections.singletonList("lHCUJFvh6v0YDURKjokZbvau"))
				.build();
		onFleet.getWorkerApi().updateWorker("sFtvhYK2l26zS0imptJJdC2q", updateParams);
	}

	public void deleteWorker() {
		// https://docs.onfleet.com/reference/delete-worker
		onFleet.getWorkerApi().deleteWorker("sFtvhYK2l26zS0imptJJdC2q");
	}

	public void getWorkerSchedule() {
		// https://docs.onfleet.com/reference/get-workers-schedule
		onFleet.getWorkerApi().getWorkerSchedule("GPOQQjU84QPN~fP*pbunT2CW");
	}

	public void setWorkerSchedule() {
		// https://docs.onfleet.com/reference/set-workers-schedule
		List<WorkerScheduleEntry> entries = Arrays.asList(
				new WorkerScheduleEntry.Builder()
						.setDate("2017-07-16")
						.addShift(1500213600000L, 1500249600000L)
						.setTimezone("America/Los_Angeles")
						.build(),
				new WorkerScheduleEntry.Builder()
						.setDate("2017-07-20")
						.addShift(1500591600000L, 1500613200000L)
						.setTimezone("America/Los_Angeles")
						.build(),
				new WorkerScheduleEntry.Builder()
						.setDate("2017-07-17")
						.addShift(1500307200000L, 1500314400000L)
						.addShift(1500323100000L, 1500336000000L)
						.setTimezone("America/Los_Angeles")
						.build(),
				new WorkerScheduleEntry.Builder()
						.setDate("2016-07-17")
						.addShift(1500307200000L, 1500314400000L)
						.addShift(1500323100000L, 1500336000000L)
						.setTimezone("America/Los_Angeles")
						.build()
		);
		onFleet.getWorkerApi().setWorkerSchedule("GPOQQjU84QPN~fP*pbunT2CW", entries);
	}
}