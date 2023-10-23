package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.VehicleType;
import com.onfleet.models.team.*;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;
import java.util.stream.Collectors;

public class TeamApi extends BaseApi {

	public TeamApi(OkHttpClient client) {
		super(client, "/teams");
	}

	public Team getTeam(String teamId) throws ApiException {
		return handleResponse(
				sendRequest(HttpMethodType.GET,
						String.format("%s/%s", baseUrl, teamId)),
				Team.class);
	}

	public List<Team> listTeams() throws ApiException {
		return handleResponse(sendRequest(HttpMethodType.GET, baseUrl), new TypeToken<List<Team>>() {
		}.getType());
	}

	public Team createTeam(TeamCreateParams team) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(team);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Team.class);
	}

	public Team updateTeam(String teamId, TeamUpdateParams params) throws ApiException {
		String url = String.format("%s/%s", baseUrl, teamId);
		String jsonPayload = GsonSingleton.getInstance().toJson(params);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Team.class);
	}

	public void deleteTeam(String teamId) throws ApiException {
		sendRequest(HttpMethodType.DELETE,
				String.format("%s/%s", baseUrl, teamId));
	}

	public WorkerRoute getDriverTimeEstimate(String teamId,
	                                         TeamDriverEtaQueryParams params) throws ApiException {
		if ((params.getDropoffLocation() == null || params.getDropoffLocation().isEmpty()) && (params.getPickupLocation() == null || params.getPickupLocation().isEmpty())) {
			throw new IllegalArgumentException("Request must have at least one of dropoffLocation or pickupLocation.");
		}
		String url = String.format("%s/%s/estimate", baseUrl, teamId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (params.getDropoffLocation() != null && !params.getDropoffLocation().isEmpty())
			urlBuilder.addQueryParameter("dropoffLocation", params.getDropoffLocation());
		if (params.getPickupLocation() != null && !params.getPickupLocation().isEmpty())
			urlBuilder.addQueryParameter("pickupLocation", params.getPickupLocation());
		if (params.getPickupTime() != null)
			urlBuilder.addQueryParameter("pickupTime", params.getPickupTime().toString());
		if (params.getRestrictedVehicleTypes() != null && !params.getRestrictedVehicleTypes().isEmpty()) {
			String restrictedTypesString = params.getRestrictedVehicleTypes().stream()
					.map(VehicleType::getValue)
					.collect(Collectors.joining(","));
			urlBuilder.addQueryParameter("restrictedVehiclesTypes", restrictedTypesString);
		}
		if (params.getServiceTime() != null)
			urlBuilder.addQueryParameter("serviceTime", params.getServiceTime().toString());
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, WorkerRoute.class);
	}

	public TeamTasks getUnassignedTasks(String teamId, TeamTasksQueryParams params) throws ApiException {
		String url = String.format("%s/%s/tasks", baseUrl, teamId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (params.getIsPickupTask() != null) {
			urlBuilder.addQueryParameter("isPickupTask", params.getIsPickupTask().toString());
		}
		if (params.getFrom() != null) {
			urlBuilder.addQueryParameter("from", params.getFrom().toString());
		}
		if (params.getTo() != null) {
			urlBuilder.addQueryParameter("to", params.getTo().toString());
		}
		if (params.getLastId() != null && !params.getLastId().isEmpty()) {
			urlBuilder.addQueryParameter("lastId", params.getLastId());
		}
		return handleResponse(sendRequest(HttpMethodType.GET, urlBuilder.build().toString()), TeamTasks.class);
	}

}
