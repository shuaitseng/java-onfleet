public class Tasks {
	private static final Onfleet onfleet = new Onfleet("ApiKey");

	public void createTask() {
		// https://docs.onfleet.com/reference/create-task
		TaskParams params = new TaskParams.Builder()
				.setDestination(new Destination.Builder()
						.setAddress(new Address.Builder()
								.setUnparsed("2829 Vallejo St, SF, CA, USA").build())
						.setNotes("Small green door by garage door has pin pad, enter *4821*")
						.build())
				.setRecipients(Collections.singletonList(new Recipient.Builder()
						.setName("Blas Silkovich")
						.setPhone("650-555-4481")
						.setNotes("Knows Neiman, VIP status.").build()))
				.setCompleteAfter(1455151071727L)
				.setAutoAssign(new TaskAutoAssignParam.Builder().setMode(TaskAutoAssignMode.DISTANCE).build())
				.build();
		onfleet.getTaskApi().createTask(params);
	}

	public void createTasksBatch() {
		// https://docs.onfleet.com/reference/create-tasks-in-batch
		List<TaskParams> tasks = Arrays.asList(
				new TaskParams.Builder()
						.setDestination(new Destination.Builder()
								.setAddress(new Address.Builder().setUnparsed("2829 Vallejo St, SF, CA, USA").build())
								.setNotes("Small green door by garage door has pin pad, enter *4821*")
								.build())
						.setRecipients(Collections.singletonList(new Recipient.Builder()
								.setName("Blas Silkovich")
								.setPhone("650-555-4481")
								.setNotes("Knows Neiman, VIP status.")
								.build()))
						.setNotes("Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches")
						.build(),
				new TaskParams.Builder()
						.setDestination(new Destination.Builder()
								.setAddress(new Address.Builder()
										.setNumber("1264")
										.setStreet("W. Augusta Blvd. ")
										.setCity("Chicago")
										.setState("IL")
										.setCountry("USA")
										.build())
								.build())
						.setNotes("12 x 2016 Getariako Txakolina (Rosé)")
						.setPickupTask(true)
						.setMetadata(Collections.singletonList(new Metadata.Builder()
								.setName("caseId")
								.setType("number")
								.setValue(33162).build()))
						.build(),
				new TaskParams.Builder()
						.setDestination(new Destination.Builder()
								.setAddress(new Address.Builder()
										.setNumber("420")
										.setStreet("Infinite Loop")
										.setCity("Redmond")
										.setState("WA")
										.setCountry("USA")
										.build())
								.build())
						.setRecipients(Collections.singletonList(new Recipient.Builder()
								.setName("S.N.")
								.setPhone("206-341-8826")
								.build()))
						.build()
		);
		onfleet.getTaskApi().createTasksBatch(tasks);
	}

	public void getBatchJobStatus() {
		// https://docs.onfleet.com/reference/batch-job-status
		onfleet.getTaskApi().getBatchJobStatus("S3oI~WNX4b5cbF1adQxuEeJD");
	}

	public void listTasks() {
		// https://docs.onfleet.com/reference/list-tasks
		TaskListQueryParams queryParams = new TaskListQueryParams
				.Builder(1455072025000L)
				.setLastId("tPMO~h03sOIqFbnhqaOXgUsd")
				.build();
		onfleet.getTaskApi().listTasks(queryParams);
	}

	public void getSingleTask() {
		// https://docs.onfleet.com/reference/get-single-task
		onfleet.getTaskApi().getSingleTask("qNMz6CKwQ*26FOslywsiQxhY");
	}

	public void getTaskByShortId() {
		// https://docs.onfleet.com/reference/get-single-task-by-shortid
		onfleet.getTaskApi().getTaskByShortId("e5f0cc28");
	}

	public void updateTask() {
		// https://docs.onfleet.com/reference/update-task
		onfleet.getTaskApi().updateTask("kc8SS1tzuZ~jqjlebKGrUmpe",
				new TaskParams.Builder()
						.setNotes("Patxi's deep dish meat lover special, 2 bottles of Basque cider")
						.setContainer(new TaskContainer.Builder()
								.setType(ContainerType.TEAM)
								.setTeam("fwflFNVvrK~4t0m5hKFIxBUl")
								.build())
						.build());
	}

	public void completeTask() {
		// https://docs.onfleet.com/reference/complete-task
		onfleet.getTaskApi().completeTask("uO2vKr07h6zg7Fzf~2NC3KLg",
				new TaskForceCompletionParams(true));
	}

	public void cloneTask() {
		// https://docs.onfleet.com/reference/clone-task
		onfleet.getTaskApi().cloneTask("uO2vKr07h6zg7Fzf~2NC3KLg");
	}

	public void deleteTask() {
		// https://docs.onfleet.com/reference/delete-task
		onfleet.getTaskApi().deleteTask("d2N*68bTBAM6Rd6txuWdH9Xj");
	}

	public void autoAssign() {
		// https://docs.onfleet.com/reference/automatically-assign-list-of-tasks
		TaskAutoAssignMultiParams autoAssignParams = new TaskAutoAssignMultiParams.Builder()
				.setTasks(Arrays.asList("11z1BbsQUZFHD1XAd~emDDeK", "kc8SS1tzuZ~jqjlebKGrUmpe"))
				.setOptions(new TaskAutoAssignOptions.Builder()
						.setMode(TaskAutoAssignMode.DISTANCE)
						.setTeams(Collections.singletonList("fwflFNVvrK~4t0m5hKFIxBUl"))
						.setConsiderDependencies(true)
						.build())
				.build();
		onfleet.getTaskApi().autoAssign(autoAssignParams);
	}
}
