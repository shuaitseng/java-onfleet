public class Organizations {
	private static final OnFleet onFleet = new OnFleet("ApiKey");

	public void getOrganizationDetails() {
		// https://docs.onfleet.com/reference/get-details
		onFleet.getOrganizationApi().getOrgDetails();
	}

	public void getDelegateeDetails() {
		// https://docs.onfleet.com/reference/get-delegatee-details
		onFleet.getOrganizationApi().getDelegateeDetails("cBrUjKvQQgdRp~s1qvQNLpK*");
	}

}