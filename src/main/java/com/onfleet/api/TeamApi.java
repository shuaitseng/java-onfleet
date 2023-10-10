package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Tasks;
import com.onfleet.models.Team;
import com.onfleet.models.VehicleType;
import com.onfleet.models.WorkerRoute;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeamApi extends ApiBase {

	public TeamApi(OkHttpClient client) {
		super(client, "/teams");
	}

	public Team createTeam(Team team) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(team);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Team.class);
	}

	public Team updateTeam(Team team) throws ApiException {
		String url = String.format("%s/%s", baseUrl, team.getId());
		String jsonPayload = GsonSingleton.getInstance().toJson(team);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Team.class);
	}

	public List<Team> listTeams() throws ApiException {
		return handleResponse(sendRequest(HttpMethodType.GET, baseUrl), new TypeToken<List<Team>>() {
		}.getType());
	}

	public Team getTeam(String teamId) throws ApiException {
		return handleResponse(
				sendRequest(HttpMethodType.GET,
						String.format("%s/%s", baseUrl, teamId)),
				Team.class);
	}

	public void deleteTeam(String teamId) throws ApiException {
		sendRequest(HttpMethodType.DELETE,
				String.format("%s/%s", baseUrl, teamId));
	}

	public WorkerRoute getDriverTimeEstimate(String teamId,
	                                         String dropoffLocation,
	                                         String pickupLocation,
	                                         Long pickupTime,
	                                         VehicleType[] restrictedVehicleTypes,
	                                         Long serviceTime) throws ApiException {
		String url = String.format("%s/%s", baseUrl, teamId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (!dropoffLocation.isEmpty())
			urlBuilder.addQueryParameter("dropoffLocation", dropoffLocation);
		if (!pickupLocation.isEmpty())
			urlBuilder.addQueryParameter("pickupLocation", pickupLocation);
		if (pickupTime != null)
			urlBuilder.addQueryParameter("pickupTime", pickupTime.toString());
		if (restrictedVehicleTypes != null && restrictedVehicleTypes.length > 0) {
			String restrictedTypesString = Arrays.stream(restrictedVehicleTypes)
					.map(VehicleType::getValue)
					.collect(Collectors.joining(","));
			urlBuilder.addQueryParameter("restrictedVehiclesTypes", restrictedTypesString);
		}
		if (serviceTime != null)
			urlBuilder.addQueryParameter("serviceTime", serviceTime.toString());
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, WorkerRoute.class);
	}

	public Tasks getUnassignedTasks(String teamId, Boolean isPickupTask, Long from, Long to, String lastId) throws ApiException {
		String url = String.format("%s/%s/tasks", baseUrl, teamId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (isPickupTask != null) {
			urlBuilder.addQueryParameter("isPickupTask", isPickupTask.toString());
		}
		if (from != null) {
			urlBuilder.addQueryParameter("from", from.toString());
		}
		if (to != null) {
			urlBuilder.addQueryParameter("to", to.toString());
		}
		if (!lastId.isEmpty()) {
			urlBuilder.addQueryParameter("lastId", lastId);
		}
		return handleResponse(sendRequest(HttpMethodType.GET, url), Tasks.class);
	}

}
