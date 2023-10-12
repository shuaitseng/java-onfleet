package com.onfleet;

import com.onfleet.api.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Base64;

public class OnFleet {
	public static final String URL = "https://onfleet.com/api/v2";
	private OkHttpClient client;
	private final TaskApi taskApi;
	private final DestinationApi destinationApi;
	private final ContainerApi containerApi;
	private final AdministratorApi administratorApi;
	private final OrganizationApi organizationApi;
	private final HubApi hubApi;

	public OnFleet(String apiKey) {
		initClient(apiKey);
		taskApi = new TaskApi(client);
		destinationApi = new DestinationApi(client);
		containerApi = new ContainerApi(client);
		administratorApi = new AdministratorApi(client);
		organizationApi = new OrganizationApi(client);
		hubApi = new HubApi(client);
	}

	public TaskApi getTaskApi() {
		return taskApi;
	}

	public DestinationApi getDestinationApi() {
		return destinationApi;
	}

	public ContainerApi getContainerApi() {
		return containerApi;
	}

	public AdministratorApi getAdministratorApi() {
		return administratorApi;
	}

	public OrganizationApi getOrganizationApi() {
		return organizationApi;
	}

	public HubApi getHubApi() {
		return hubApi;
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
