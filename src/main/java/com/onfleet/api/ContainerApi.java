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

	static final String UPDATE_CONTAINER_TYPE = ContainerType.WORKER.getPluralName();

	public ContainerApi(OkHttpClient client) {
		super(client, "/containers");
	}

	/**
	 * Retrieve information about a specific container by its ID and container type. This method allows you to obtain
	 * details about a container
	 * <a href="https://docs.onfleet.com/reference/get-container">Api Docs</a>
	 * @param containerId The ID of the container to retrieve.
	 * @param containerType The type of the container (e.g., organization, team or worker).
	 * @return A Container object representing the retrieved container's details.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Container getContainer(String containerId, ContainerType containerType) throws ApiException {
		String url = String.format("%s/%s/%s", baseUrl, containerType.getPluralName(), containerId);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Container.class);
	}

	/**
	 * Insert a list of tasks into a container at a specified index.
	 * <a href="https://docs.onfleet.com/reference/insert-tasks-at-index-or-append">Api Docs</a>
	 * @param id The ID of the container to insert tasks into.
	 * @param index The index at which the tasks should be inserted.
	 * @param containerType The type of the container (e.g., organization, team or worker).
	 * @param taskIds A list of task IDs to insert into the container.
	 * @return A Container object representing the updated container with inserted tasks.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Container insertTasks(String id, int index, ContainerType containerType, List<String> taskIds, Boolean includeDependencies) throws ApiException {
		String url = String.format("%s/%s/%s", baseUrl, containerType.getPluralName(), id);
		String jsonPayload = buildInsertTasksJson(index, taskIds, includeDependencies);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Container.class);
	}

	/**
	 * Insert a list of tasks into a container at a specified index without considering task dependencies.
	 * <a href="https://docs.onfleet.com/reference/insert-tasks-at-index-or-append">Api Docs</a>
	 * @param id The ID of the container to insert tasks into.
	 * @param index The index at which the tasks should be inserted.
	 * @param containerType The type of the container (e.g., organization, team or worker).
	 * @param taskIds A list of task IDs to insert into the container.
	 * @return A Container object representing the updated container with inserted tasks.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Container insertTasks(String id, int index, ContainerType containerType, List<String> taskIds) throws ApiException {
		return this.insertTasks(id, index, containerType, taskIds, null);
	}

	/**
	 * Update a list of tasks in a container
	 * <a href="https://docs.onfleet.com/reference/update-tasks">Api Docs</a>
	 * @param id The ID of the container to update tasks within.
	 * @param tasksIds A list of task IDs to update within the container.
	 * @param includeDependencies A boolean flag indicating whether to consider task dependencies.
	 * @return A Container object representing the updated container with modified tasks.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Container updateTasks(String id, List<String> tasksIds, Boolean includeDependencies) throws ApiException {
		String url = String.format("%s/%s/%s", baseUrl, UPDATE_CONTAINER_TYPE, id);
		String jsonPayload = buildInsertTasksJson(null, tasksIds, includeDependencies);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Container.class);
	}

	/**
	 * Update a list of tasks in a container without considering task dependencies.
	 * <a href="https://docs.onfleet.com/reference/update-tasks">Api Docs</a>
	 * @param id The ID of the container to update tasks within.
	 * @param tasksIds A list of task IDs to update within the container.
	 * @return A Container object representing the updated container with modified tasks.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
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
