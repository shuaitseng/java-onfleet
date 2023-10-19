package com.onfleet.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Metadata;
import com.onfleet.models.WorkerFilterFields;
import com.onfleet.models.Workers;
import com.onfleet.models.worker.Worker;
import com.onfleet.models.worker.WorkerCreateParams;
import com.onfleet.models.worker.WorkerListQueryParams;
import com.onfleet.models.worker.WorkerQueryParams;
import com.onfleet.models.worker.WorkerScheduleEntries;
import com.onfleet.models.worker.WorkerScheduleEntry;
import com.onfleet.models.worker.WorkerTasks;
import com.onfleet.models.worker.WorkerTasksQueryParams;
import com.onfleet.models.worker.WorkerUpdateParams;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;
import java.util.stream.Collectors;

public class WorkerApi extends BaseApi {

	public WorkerApi(OkHttpClient client) {
		super(client, "/workers");
	}

	public Worker createWorker(WorkerCreateParams worker) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(worker);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Worker.class);
	}

	public List<Worker> listWorkers(WorkerListQueryParams params) throws ApiException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
		if (params.getFields() != null && !params.getFields().isEmpty()) {
			urlBuilder.addQueryParameter("fields", String.join(",", params.getFields()));
		}
		if (params.getTeamIds() != null && !params.getTeamIds().isEmpty()) {
			urlBuilder.addQueryParameter("teamsIds", String.join(",", params.getTeamIds()));
		}
		if (params.getWorkerStates() != null && !params.getWorkerStates().isEmpty()) {
			urlBuilder.addQueryParameter("states", params.getWorkerStates()
					.stream()
					.map(Object::toString)
					.collect(Collectors.joining(",")));
		}
		if (params.getPhoneNumbers() != null && !params.getPhoneNumbers().isEmpty()) {
			urlBuilder.addQueryParameter("phoneNumbers", String.join(",", params.getPhoneNumbers()));
		}
		if (params.getIncludePasswordDetails()) {
			urlBuilder.addQueryParameter("includePasswordDetails", "true");
		}
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.toString());
		return handleResponse(response, new TypeToken<List<Worker>>() {
		}.getType());
	}

	public WorkerTasks getWorkersTasks(String workerId, WorkerTasksQueryParams params) throws ApiException {
		String url = String.format("%s/%s/tasks", baseUrl, workerId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (params.getFrom() != null)
			urlBuilder.addQueryParameter("from", params.getFrom().toString());
		if (params.getTo() != null)
			urlBuilder.addQueryParameter("to", params.getTo().toString());
		if (params.getLastId() != null)
			urlBuilder.addQueryParameter("lastId", params.getLastId());
		if (params.getPickUpTask() != null)
			urlBuilder.addQueryParameter("isPickUpTask", params.getPickUpTask().toString());
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, WorkerTasks.class);
	}

	public WorkerTasks getWorkersTasks(String workerId) throws ApiException {
		return this.getWorkersTasks(workerId, null);
	}

	public Workers getWorkersByLocation(Double longitude, Double latitude, Integer radius) throws ApiException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl + "/location").newBuilder();
		urlBuilder.addQueryParameter("longitude", longitude.toString());
		urlBuilder.addQueryParameter("latitude", latitude.toString());
		if (radius != null) {
			urlBuilder.addQueryParameter("radius", radius.toString());
		}
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, Workers.class);
	}


	/**
	 * filter - Optional. A comma-separated list of fields to return, if all are not desired. For example, name, location
	 * phones - Optional. A comma-separated list of workers' phone numbers.
	 * states - Optional. A comma-separated list of worker states, where 0 is off-duty,
	 * 1 is idle (on-duty, no active task) and 2 is active (on-duty, active task).
	 * teams - Optional. A comma-separated list of the team IDs that workers must be part of.
	 * analytics
	 */
	public Worker getSingleWorker(String workerId, WorkerQueryParams params) throws ApiException {
		String url = String.format("%s/%s", baseUrl, workerId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (params.getFilterFields() != null && !params.getFilterFields().isEmpty()) {
			String filterQuery = params.getFilterFields().stream()
					.map(WorkerFilterFields::getValue)
					.collect(Collectors.joining(","));
			urlBuilder.addQueryParameter("filter", filterQuery);
		}
		if (params.getPhones() != null && !params.getPhones().isEmpty()) {
			urlBuilder.addQueryParameter("phones", String.join(",", params.getPhones()));
		}
		if (params.getStates() != null) {
			urlBuilder.addQueryParameter("states", params.getStates()
					.stream()
					.map(Object::toString)
					.collect(Collectors.joining(",")));
		}
		if (params.getTeams() != null) {
			urlBuilder.addQueryParameter("teams", String.join(",", params.getTeams()));
		}
		if (params.getEnableAnalytics() != null) {
			urlBuilder.addQueryParameter("analytics", params.getEnableAnalytics().toString());
		}
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, Worker.class);
	}

	public List<Worker> queryWithMetadata(List<Metadata> metadata) throws ApiException {
		String url = String.format("%s/metadata", baseUrl);
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, new TypeToken<List<Worker>>() {
		}.getType());
	}

	public Worker updateWorker(String workerId, WorkerUpdateParams params) throws ApiException {
		String url = String.format("%s/%s", baseUrl, workerId);
		String jsonPayload = GsonSingleton.getInstance().toJson(params);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Worker.class);
	}

	public void deleteWorker(String workerId) throws ApiException {
		sendRequest(HttpMethodType.DELETE, String.format("%s/%s", baseUrl, workerId));
	}

	public WorkerScheduleEntries getWorkerSchedule(String workerId) throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, String.format("%s/%s/schedule", baseUrl, workerId));
		return handleResponse(response, WorkerScheduleEntries.class);
	}

	public WorkerScheduleEntries setWorkerSchedule(String workerId, List<WorkerScheduleEntry> entries) throws ApiException {
		String url = String.format("%s/%s/schedule", baseUrl, workerId);
		JsonObject jsonPayload = new JsonObject();
		JsonArray entriesArray = new JsonArray();

		for (WorkerScheduleEntry entry : entries) {
			JsonObject entryObject = new JsonObject();
			entryObject.addProperty("date", entry.getDate());
			entryObject.addProperty("timezone", entry.getTimezone());

			JsonArray shiftsArray = new JsonArray();
			for (List<Long> shift : entry.getShifts()) {
				JsonArray shiftArray = new JsonArray();
				shiftArray.add(shift.get(0));
				shiftArray.add(shift.get(1));
				shiftsArray.add(shiftArray);
			}
			entryObject.add("shifts", shiftsArray);
			entriesArray.add(entryObject);
		}
		jsonPayload.add("entries", entriesArray);
		RequestBody body = RequestBody.create(jsonPayload.toString(), MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, url);
		return handleResponse(response, WorkerScheduleEntries.class);
	}

}
