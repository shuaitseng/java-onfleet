package com.onfleet.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Container;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ContainerApi extends BaseApi {

	public ContainerApi(OkHttpClient client) {
		super(client, "/containers/workers");
	}

	public Container getContainer(String id) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Container.class);
	}

	public Container insertTasks(String id, int index, String[] taskIds) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		String jsonPayload = buildInsertTasksJson(index, taskIds);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Container.class);

	}

	public Container updateTasks(String id, String[] tasksIds) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		String jsonPayload = GsonSingleton.getInstance().toJson(tasksIds);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Container.class);
	}

	private String buildInsertTasksJson(int index, String[] ids) {
		JsonObject payload = new JsonObject();
		payload.addProperty("tasks", index);
		JsonArray taskArray = new JsonArray();
		for (String id : ids) {
			taskArray.add(id);
		}
		payload.add("taskIds", taskArray);
		return payload.toString();
	}

}
