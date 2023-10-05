package com.onfleet;

import com.onfleet.containers.ContainerApi;
import com.onfleet.destinations.DestinationApi;
import com.onfleet.tasks.TaskApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Base64;

public class OnFleet {
	public static final String URL = "https://onfleet.com/api/v2";
	private final TaskApi taskApi;
	private final DestinationApi destinationApi;
	private final ContainerApi containerApi;

	public OnFleet(String apiKey) {
		String credentials = Base64.getEncoder().encodeToString((apiKey).getBytes());
		OkHttpClient httpClient = new OkHttpClient.Builder()
				.addInterceptor(chain -> {
					Request originalRequest = chain.request();
					Request newRequest = originalRequest.newBuilder()
							.header("Authorization", "Basic " + credentials)
							.build();
					return chain.proceed(newRequest);
				}).build();
		taskApi = new TaskApi(httpClient);
		destinationApi = new DestinationApi(httpClient);
		containerApi = new ContainerApi(httpClient);
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

}
