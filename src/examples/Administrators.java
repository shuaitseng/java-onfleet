public class Administrators {
	private static final OnFleet onFleet = new OnFleet("ApiKey");

	public void createAdministrator() {
		// https://docs.onfleet.com/reference/create-administrator
		AdminCreateParams createParams = new AdminCreateParams.Builder("Chelsea M", "cm@onf.lt", AdministratorType.SUPER).build();
		onFleet.getAdministratorApi().createAdministrator(createParams);
	}

	public void listAdministrators() {
		// https://docs.onfleet.com/reference/list-administrators
		onFleet.getAdministratorApi().listAdministrators();
	}

	public void updateAdministrator() {
		// https://docs.onfleet.com/reference/update-administrator
		AdminUpdateParams updateParams = new AdminUpdateParams.Builder()
				.setName("C Manning")
				.build();
		onFleet.getAdministratorApi().updateAdministrator("8AxaiKwMd~np7I*YP2NfukBE", updateParams);
	}

	public void deleteAdministrator() {
		// https://docs.onfleet.com/reference/delete-administrator
		onFleet.getAdministratorApi().deleteAdministrator("8AxaiKwMd~np7I*YP2NfukBE");
	}

}