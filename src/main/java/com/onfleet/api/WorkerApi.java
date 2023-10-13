package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.ScheduleEntries;
import com.onfleet.models.ScheduleEntry;
import com.onfleet.models.Tasks;
import com.onfleet.models.Worker;
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

	public Worker createWorker(Worker worker) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(worker);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Worker.class);
	}

	public List<Worker> listWorkers(List<String> fields,
	                                List<String> teamIds,
	                                List<Integer> workerStates,
	                                List<String> phoneNumbers,
	                                boolean includePasswordDetails) throws ApiException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
		if (fields != null && !fields.isEmpty()) {
			urlBuilder.addQueryParameter("fields", String.join(",", fields));
		}
		if (teamIds != null && !teamIds.isEmpty()) {
			urlBuilder.addQueryParameter("teamsIds", String.join(",", teamIds));
		}
		if (workerStates != null && !workerStates.isEmpty()) {
			urlBuilder.addQueryParameter("states", workerStates
					.stream()
					.map(Object::toString)
					.collect(Collectors.joining(",")));
		}
		if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
			urlBuilder.addQueryParameter("phoneNumbers", String.join(",", phoneNumbers));
		}
		if (includePasswordDetails) {
			urlBuilder.addQueryParameter("includePasswordDetails", "true");
		}
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.toString());
		return handleResponse(response, new TypeToken<List<Worker>>() {
		}.getType());
	}

	public Tasks getWorkersTasks(String workerId, Long from, Long to, String lastId, Boolean isPickUpTask) throws ApiException {
		String url = String.format("%s/%s/tasks", baseUrl, workerId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (from != null)
			urlBuilder.addQueryParameter("from", from.toString());
		if (to != null)
			urlBuilder.addQueryParameter("to", to.toString());
		if (lastId != null)
			urlBuilder.addQueryParameter("lastId", lastId);
		if (isPickUpTask != null)
			urlBuilder.addQueryParameter("isPickUpTask", isPickUpTask.toString());
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, Tasks.class);
	}

	public Worker getWorkersByLocation(Long longitude, Long latitude, Integer radius) throws ApiException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
		urlBuilder.addQueryParameter("longitude", longitude.toString());
		urlBuilder.addQueryParameter("latitude", latitude.toString());
		if (radius != null) {
			urlBuilder.addQueryParameter("radius", radius.toString());
		}
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, Worker.class);
	}

	public Worker getSingleWorker(String workerId, List<WorkerFilterFields> filterFields, Boolean enableAnalytics) throws ApiException {
		String url = String.format("%s/%s", baseUrl, workerId);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (filterFields != null && !filterFields.isEmpty()) {
			String filterQuery = filterFields.stream()
					.map(WorkerFilterFields::getValue)
					.collect(Collectors.joining(","));
			urlBuilder.addQueryParameter("filter", filterQuery);
		}
		if (enableAnalytics != null) {
			urlBuilder.addQueryParameter("analytics", enableAnalytics.toString());
		}
		Response response = sendRequest(HttpMethodType.GET, urlBuilder.build().toString());
		return handleResponse(response, Worker.class);
	}

	public Worker updateWorker(Worker worker) throws ApiException {
		String url = String.format("%s/%s", baseUrl, worker.getId());
		String jsonPayload = GsonSingleton.getInstance().toJson(worker);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Worker.class);
	}

	public void deleteWorker(String workerId) throws ApiException {
		sendRequest(HttpMethodType.DELETE, String.format("%s/%s", baseUrl, workerId));
	}

	public ScheduleEntries getWorkerSchedule(String workerId) throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, String.format("%s/%s/schedule", baseUrl, workerId));
		return handleResponse(response, ScheduleEntries.class);
	}

	public ScheduleEntries setWorkerSchedule(String workerId, List<ScheduleEntry> entries) throws ApiException {
		String url = String.format("%s/%s/schedule", baseUrl, workerId);
		JsonObject jsonPayload = new JsonObject();
		JsonArray entriesArray = new JsonArray();

		for (ScheduleEntry entry : entries) {
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
		return handleResponse(response, ScheduleEntries.class);
	}

}
