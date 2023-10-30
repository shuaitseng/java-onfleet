public class Teams {

	public void createTeam() {
		// https://docs.onfleet.com/reference/create-team
		TeamCreateParams params = new TeamCreateParams.Builder("Sunset",
				Arrays.asList("1LjhGUWdxFbvdsTAAXs0TFos", "F8WPCqGmQYWpCkQ2c8zJTCpW"),
				Collections.singletonList("Mrq7aKqzPFKX22pmjdLx*ohM"))
				.setHub("tKxSfU7psqDQEBVn5e2VQ~*O")
				.build();
		onfleet.getTeamApi().createTeam(params);
	}

	public void updateTeam() {
		// https://docs.onfleet.com/reference/update-team
		TeamUpdateParams updateParams = new TeamUpdateParams.Builder()
				.setWorkers(Arrays.asList(
						"1LjhGUWdxFbvdsTAAXs0TFos",
						"F8WPCqGmQYWpCkQ2c8zJTCpW",
						"3joS0Jh19VpJZgSTxFOK9fTf"
				)).build();
		onfleet.getTeamApi().updateTeam("FFqPs1KHayxorfA~~xIj0us4", updateParams);
	}

	public void listTeams() {
		// https://docs.onfleet.com/reference/list-teams
		onfleet.getTeamApi().listTeams();
	}

	public void getSingleTeam() {
		// https://docs.onfleet.com/reference/get-single-team
		onfleet.getTeamApi().getTeam("9dyuPqHt6kDK5JKHFhE0xihh");
	}

	public void deleteTeam() {
		// https://docs.onfleet.com/reference/delete-team
		onfleet.getTeamApi().deleteTeam("FFqPs1KHayxorfA~~xIj0us4");
	}

	public void deliveryEstimate() {
		// https://docs.onfleet.com/reference/delivery-estimate
		TeamDriverEtaQueryParams queryParams = new TeamDriverEtaQueryParams.Builder()
				.setDropoffLocation("122.2442512,37.8097414")
				.setServiceTime(300L)
				.setPickupLocation("122.2514556,37.7577242")
				.setPickupTime(1614895847L)
				.setRestrictedVehicleTypes(Collections.singletonList(VehicleType.CAR))
				.build();
		onfleet.getTeamApi().getDriverTimeEstimate("aasZ3KnsrPapys5M5Ug3qXom", queryParams);
	}

	public void listTeamTasks() {
		// https://docs.onfleet.com/reference/list-tasks-in-team
		TeamTasksQueryParams tasksQueryParams = new TeamTasksQueryParams.Builder()
				.setFrom(1455072025000L)
				.setLastId("tPMO~h03sOIqFbnhqaOXgUsd")
				.build();
		onfleet.getTeamApi().getUnassignedTasks("h*wSb*apKlDkUFnuLTtjPke7", tasksQueryParams);
	}

}
