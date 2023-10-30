public class Webhooks {
	private static final Onfleet onfleet = new Onfleet("ApiKey");

	public void createWebhook() {
		// https://docs.onfleet.com/reference/create-webhook
		WebhookCreateParams params = new WebhookCreateParams.Builder()
				.setUrl("https://11ec4a02.ngrok.com/onfleet/taskStart")
				.setTrigger(0)
				.build();
		onfleet.getWebhookApi().create(params);
	}

	public void listWebhooks() {
		// https://docs.onfleet.com/reference/list-webhooks
		onfleet.getWebhookApi().list();
	}

	public void deleteWebhook() {
		// https://docs.onfleet.com/reference/delete-webhook
		onfleet.getWebhookApi().delete("ZnVRY8rdfUwNPjHQy2QthtxZ");
	}
}
