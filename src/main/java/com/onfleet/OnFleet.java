package com.onfleet;

import com.onfleet.api.AdministratorApi;
import com.onfleet.api.ContainerApi;
import com.onfleet.api.DestinationApi;
import com.onfleet.api.HubApi;
import com.onfleet.api.OrganizationApi;
import com.onfleet.api.RecipientApi;
import com.onfleet.api.TaskApi;
import com.onfleet.api.TeamApi;
import com.onfleet.api.WebhookApi;
import com.onfleet.api.WorkerApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Base64;

public class OnFleet {
	public static final String URL = "https://onfleet.com/api/v2";
	private OkHttpClient client;
	private final OrganizationApi organizationApi;
	private final AdministratorApi administratorApi;
	private final WorkerApi workerApi;
	private final HubApi hubApi;
	private final TeamApi teamApi;
	private final DestinationApi destinationApi;
	private final RecipientApi recipientApi;
	private final TaskApi taskApi;
	private final ContainerApi containerApi;
	private final WebhookApi webhookApi;

	public OnFleet(String apiKey) {
		initClient(apiKey);
		organizationApi = new OrganizationApi(client);
		administratorApi = new AdministratorApi(client);
		workerApi = new WorkerApi(client);
		hubApi = new HubApi(client);
		teamApi = new TeamApi(client);
		destinationApi = new DestinationApi(client);
		recipientApi = new RecipientApi(client);
		taskApi = new TaskApi(client);
		containerApi = new ContainerApi(client);
		webhookApi = new WebhookApi(client);
	}

	public OrganizationApi getOrganizationApi() {
		return organizationApi;
	}

	public AdministratorApi getAdministratorApi() {
		return administratorApi;
	}

	public WorkerApi getWorkerApi() {
		return workerApi;
	}

	public HubApi getHubApi() {
		return hubApi;
	}

	public TeamApi getTeamApi() {
		return teamApi;
	}

	public DestinationApi getDestinationApi() {
		return destinationApi;
	}

	public RecipientApi getRecipientApi() {
		return recipientApi;
	}

	public TaskApi getTaskApi() {
		return taskApi;
	}

	public ContainerApi getContainerApi() {
		return containerApi;
	}

	public WebhookApi getWebhookApi() {
		return webhookApi;
	}

	private void initClient(String apiKey) {
		String credentials = Base64.getEncoder().encodeToString((apiKey).getBytes());
		this.client = new OkHttpClient.Builder()
				.addInterceptor(chain -> {
					Request originalRequest = chain.request();
					Request newRequest = originalRequest.newBuilder()
							.header("Authorization", "Basic " + credentials)
							.build();
					return chain.proceed(newRequest);
				}).build();
	}
}
