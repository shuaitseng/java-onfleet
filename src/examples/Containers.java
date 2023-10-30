public class Containers {
	private static final Onfleet onfleet = new Onfleet("ApiKey");

	public void getContainer() {
		// https://docs.onfleet.com/reference/get-container
		onfleet.getContainerApi().getContainer("2Fwp6wS5wLNjDn36r1LJPscA", ContainerType.WORKER);
	}

	public void insertTasks() {
		// https://docs.onfleet.com/reference/insert-tasks-at-index-or-append
		List<String> tasksIds = Arrays.asList("l33lg5WLrja3Tft*MO383Gub", "tsc4jFSETlXBIvi8XotH28Wt");
		onfleet.getContainerApi().insertTasks("2Fwp6wS5wLNjDn36r1LJPscA", 3, ContainerType.WORKER, tasksIds);
	}

	public void updateTasks() {
		// https://docs.onfleet.com/reference/update-tasks
		onfleet.getContainerApi().updateTasks("2Fwp6wS5wLNjDn36r1LJPscA", Arrays.asList("b3F~z2sU7H*auNKkM6LoiXzP", "1ry863mrjoQaqMNxnrD5YvxH", "l33lg5WLrja3Tft*MO383Gub"));
	}
}
