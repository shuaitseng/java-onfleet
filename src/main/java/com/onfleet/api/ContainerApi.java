package com.onfleet.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.container.Container;
import com.onfleet.models.container.ContainerType;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

public class ContainerApi extends BaseApi {

	private final String UPDATE_CONTAINER_TYPE = ContainerType.WORKER.getPluralName();

	public ContainerApi(OkHttpClient client) {
		super(client, "/containers");
	}

	public Container getContainer(String containerId, ContainerType containerType) throws ApiException {
		String url = String.format("%s/%s/%s", baseUrl, containerType.getPluralName(), containerId);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Container.class);
	}

	public Container insertTasks(String id, int index, ContainerType containerType, List<String> taskIds, Boolean includeDependencies) throws ApiException {
		String url = String.format("%s/%s/%s", baseUrl, containerType.getPluralName(), id);
		String jsonPayload = buildInsertTasksJson(index, taskIds, includeDependencies);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Container.class);
	}

	public Container insertTasks(String id, int index, ContainerType containerType, List<String> taskIds) throws ApiException {
		return this.insertTasks(id, index, containerType, taskIds, null);
	}

	public Container updateTasks(String id, List<String> tasksIds, Boolean includeDependencies) throws ApiException {
		String url = String.format("%s/%s/%s", baseUrl, UPDATE_CONTAINER_TYPE, id);
		String jsonPayload = buildInsertTasksJson(null, tasksIds, includeDependencies);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Container.class);
	}

	public Container updateTasks(String id, List<String> tasksIds) throws ApiException {
		return this.updateTasks(id, tasksIds, null);
	}

	private String buildInsertTasksJson(Integer index, List<String> ids, Boolean includeDependencies) {
		JsonObject payload = new JsonObject();
		JsonArray taskArray = new JsonArray();
		if (index != null) {
			taskArray.add(index);
		}

		for (String id : ids) {
			taskArray.add(id);
		}
		payload.add("tasks", taskArray);
		if (includeDependencies != null) {
			payload.addProperty("includeDependencies", includeDependencies);
		}
		return payload.toString();
	}

}
