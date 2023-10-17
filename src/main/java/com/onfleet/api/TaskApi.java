package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.BatchJobStatus;
import com.onfleet.models.Metadata;
import com.onfleet.models.task.Task;
import com.onfleet.models.task.TaskBatchCreateResponse;
import com.onfleet.models.task.TaskCloneParams;
import com.onfleet.models.task.TaskForceCompletionParams;
import com.onfleet.models.task.TaskListQueryParams;
import com.onfleet.models.task.TaskParams;
import com.onfleet.models.task.TaskState;
import com.onfleet.models.task.Tasks;
import com.onfleet.models.task.TasksPaginated;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;
import java.util.Objects;

public class TaskApi extends BaseApi {

	public TaskApi(OkHttpClient client) {
		super(client, "/tasks");
	}

	public Task createTask(TaskParams task) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(task);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Task.class);
	}

	public Tasks createTasksBatch(List<TaskParams> tasks) throws ApiException {
		String url = String.format("%s/batch", baseUrl);
		String jsonPayload = GsonSingleton.getInstance().toJson(tasks);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, url);
		return handleResponse(response, Tasks.class);
	}

	public TaskBatchCreateResponse createTasksBatchAsync(List<TaskParams> tasks) throws ApiException {
		String url = String.format("%s/batch-async", baseUrl);
		String jsonPayload = GsonSingleton.getInstance().toJson(tasks);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, url);
		return handleResponse(response, TaskBatchCreateResponse.class);
	}

	public BatchJobStatus getBatchJobStatus(String jobId) throws ApiException {
		String url = String.format("%s/batch/%s", baseUrl, jobId);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, BatchJobStatus.class);
	}

	// TODO: check this one later
	public void RecipientOverrides() {

	}

	/**
	 * Retrieves a list of tasks based on the provided query parameters.
	 *
	 * <ul>
	 * <li><code>from</code>: The starting time in Unix time of the search range. Tasks created or completed at or after this time will be included.</li>
	 * <li><code>to</code>: The ending time in Unix time of the range. Tasks created or completed before this time will be included.</li>
	 * <li><code>lastId</code>: The last ID used to walk paginated responses. Tasks created after this ID will be returned.</li>
	 * <li><code>worker</code>: The ID of a worker who is currently assigned to the tasks or has previously completed the tasks.</li>
	 * <li><code>completeBeforeBefore</code>: The timestamp in Unix time before which the task <code>completeBefore</code> value must be.</li>
	 * <li><code>completeAfterAfter</code>: The timestamp in Unix time after which the task <code>completeAfter</code> value must be.</li>
	 * <li><code>states</code>: A list of task states, represented as a comma-separated string.</li>
	 * <li><code>taskDependencies</code>: A comma-separated list of dependency task IDs. A task gets returned in the response if it has at least one of the dependencies provided.</li>
	 * </ul>
	 *
	 * @param queryParams The query parameters for filtering tasks.
	 * @return A paginated list of tasks.
	 * @throws ApiException             if an error occurs during the API request.
	 * @throws IllegalArgumentException if the 'from' parameter is missing or invalid.
	 */
	public TasksPaginated listTasks(TaskListQueryParams queryParams) throws ApiException {
		HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl)).newBuilder();
		if (queryParams.getFrom() > 0) {
			urlBuilder.addQueryParameter("from", String.valueOf(queryParams.getFrom()));
		} else {
			throw new IllegalArgumentException("'from' parameter is required");
		}
		if (queryParams.getTo() != null) {
			urlBuilder.addQueryParameter("to", String.valueOf(queryParams.getTo()));
		}
		if (queryParams.getLastId() != null) {
			urlBuilder.addQueryParameter("lastId", queryParams.getLastId());
		}
		if (queryParams.getStates() != null) {
			for (TaskState state : queryParams.getStates()) {
				urlBuilder.addQueryParameter("state", state.toString());
			}
		}
		if (queryParams.getWorker() != null) {
			urlBuilder.addQueryParameter("worker", queryParams.getWorker());
		}
		if (queryParams.getCompleteBeforeBefore() != null) {
			urlBuilder.addQueryParameter("completeBeforeBefore", String.valueOf(queryParams.getCompleteBeforeBefore()));
		}
		if (queryParams.getCompleteAfterAfter() != null) {
			urlBuilder.addQueryParameter("completeAfterAfter", String.valueOf(queryParams.getCompleteAfterAfter()));
		}
		if (queryParams.getTaskDependencies() != null) {
			for (String dependency : queryParams.getTaskDependencies()) {
				urlBuilder.addQueryParameter("dependencies", dependency);
			}
		}
		return handleResponse(sendRequest(HttpMethodType.GET, urlBuilder.build().toString()), TasksPaginated.class);
	}

	public List<Task> listWithMetadataQuery(List<Metadata> metadata) throws ApiException {
		String url = String.format("%s/metadata", baseUrl);
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, url);
		return handleResponse(response, new TypeToken<List<Task>>() {
		}.getType());
	}

	public Task getSingleTask(String taskId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, taskId);
		Response response = sendRequest(HttpMethodType.POST, url);
		return handleResponse(response, Task.class);
	}

	public Task getTaskByShortId(String taskShortId) throws ApiException {
		String url = String.format("%s/shortId/%s", baseUrl, taskShortId);
		Response response = sendRequest(HttpMethodType.POST, url);
		return handleResponse(response, Task.class);
	}

	public Task updateTask(String taskId, TaskParams task) throws ApiException {
		String url = String.format("%s/%s", baseUrl, taskId);
		String jsonPayload = GsonSingleton.getInstance().toJson(task);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, url);
		return handleResponse(response, Task.class);
	}

	public void completeTask(String taskId, TaskForceCompletionParams completionDetails) throws ApiException {
		String url = String.format("%s/%s/complete", baseUrl, taskId);
		String jsonPayload = GsonSingleton.getInstance().toJson(completionDetails);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		sendRequest(HttpMethodType.POST, body, url);
	}

	public Task cloneTask(String taskId, TaskCloneParams options) throws ApiException {
		String url = String.format("%s/%s/clone", baseUrl, taskId);
		String jsonPayload = GsonSingleton.getInstance().toJson(options);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, url);
		return handleResponse(response, Task.class);
	}

	public void deleteTask(String taskId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, taskId);
		sendRequest(HttpMethodType.DELETE, url);
	}

    /*public void autoAssign(TaskAutoAssignMultiParams params) throws ApiException {
	    String url = String.format("%s/autoAssign", baseUrl);
	    String jsonPayload = GsonSingleton.getInstance().toJson(params);
	    RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
	    Response response = sendRequest(HttpMethodType.POST, body, url);
	    return handleResponse(response, Task.class);
    }*/

}
