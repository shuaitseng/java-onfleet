public class Recipients {
	private static final OnFleet onFleet = new OnFleet("ApiKey");

	public void createRecipient() {
		// https://docs.onfleet.com/reference/create-recipient
		RecipientCreateParams params = new RecipientCreateParams.Builder("Boris Foster", "+1111111111")
				.setNotes("Always orders our GSC special")
				.setSkipPhoneNumberValidation(true)
				.build();
		onFleet.getRecipientApi().createRecipient(params);
	}

	public void updateRecipient() {
		// https://docs.onfleet.com/reference/update-recipient
		RecipientUpdateParams updateParams = new RecipientUpdateParams.Builder()
				.setName("Neiman Runtilly")
				.build();
		onFleet.getRecipientApi().updateRecipient("VVLx5OdKvw0dRSjT2rGOc6Y*", updateParams);
	}

	public void findRecipientByName() {
		// https://docs.onfleet.com/reference/find-recipient
		onFleet.getRecipientApi().findRecipientByName("neiman runtilly");
	}

	public void getSingleRecipient() {
		// https://docs.onfleet.com/reference/get-single-recipient
		onFleet.getRecipientApi().getSingleRecipient("VVLx5OdKvw0dRSjT2rGOc6Y*");
	}

}
