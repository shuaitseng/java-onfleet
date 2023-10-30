public class Organizations {
	private static final Onfleet onfleet = new Onfleet("ApiKey");

	public void getOrganizationDetails() {
		// https://docs.onfleet.com/reference/get-details
		onfleet.getOrganizationApi().getOrgDetails();
	}

	public void getDelegateeDetails() {
		// https://docs.onfleet.com/reference/get-delegatee-details
		onfleet.getOrganizationApi().getDelegateeDetails("cBrUjKvQQgdRp~s1qvQNLpK*");
	}

}