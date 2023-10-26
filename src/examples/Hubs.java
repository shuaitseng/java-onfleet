public class Hubs {
	private static final OnFleet onFleet = new OnFleet("ApiKey");

	public void createHub() {
		// https://docs.onfleet.com/reference/create-hub
		Address address = new Address.Builder()
				.setState("California")
				.setPostalCode("92806")
				.setNumber("2695")
				.setStreet("East Katella Avenue")
				.setCity("Anaheim")
				.setCountry("United States")
				.setName("VIP customer")
				.build();
		HubParams params = new HubParams.Builder(address, "VIP customer")
				.setTeams(Collections.singletonList("kq5MFBzYNWhp1rumJEfGUTqS"))
				.build();
		onFleet.getHubApi().createHub(params);
	}

	public void updateHub() {
		// https://docs.onfleet.com/reference/update-hub
		Address newAddress = new Address.Builder()
				.setState("California")
				.setPostalCode("90015")
				.setNumber("1111")
				.setStreet("South Figueroa Street")
				.setCity("Los Angeles")
				.setCountry("United States")
				.setName("VIP customer")
				.build();
		HubParams updateParams = new HubParams.Builder(newAddress, "VIP customer Hub").setTeams(Collections.singletonList("kq5MFBzYNWhp1rumJEfGUTqS")).build();
		onFleet.getHubApi().updateHub("i4FoP*dTVrdnGqvIVvvA69aB", updateParams);
	}

	public void listHubs() {
		// https://docs.onfleet.com/reference/list-hubs
		onFleet.getHubApi().listHubs();
	}

}
