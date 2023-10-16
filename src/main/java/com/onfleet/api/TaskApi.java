package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.CompletionDetails;
import com.onfleet.models.Task;
import com.onfleet.models.Tasks;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

public class TaskApi extends BaseApi {

    public TaskApi(OkHttpClient client) {
        super(client, "/tasks");
    }

    public Task createTask(Task task) throws ApiException {
        String jsonPayload = GsonSingleton.getInstance().toJson(task);
        RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
        Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
        return handleResponse(response, Task.class);
    }

    public Tasks createTasksBatch(Tasks tasks) throws ApiException {
        String url = String.format("%s/batch", baseUrl);
        String jsonPayload = GsonSingleton.getInstance().toJson(tasks);
        RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
        Response response = sendRequest(HttpMethodType.POST, body, url);
        return handleResponse(response, Tasks.class);
    }

    /*public BatchJobStatus createTasksBatchAsync(Tasks tasks) throws ApiException {
        String url = String.format("%s/batch-async", baseUrl);
        String jsonPayload = GsonSingleton.getInstance().toJson(tasks);
        RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
        Response response = sendRequest(HttpMethodType.POST, body, url);
        return handleResponse(response, BatchJobStatus.class);
    }*/

    /*public BatchJobStatus getBatchJobStatus(String jobId) throws ApiException {
        Response response = sendRequest(HttpMethodType.GET, baseUrl);
        return handleResponse(response, BatchJobStatus.class);
    }*/

    // TODO: check this one later
    public void RecipientOverrides() {

    }

    /**
     *
     * @param from Required. The starting time in Unix time of the search range. Tasks created or completed at or after this time will be included.
     * @param to Optional. If missing, defaults to the current time. The ending time in Unix time of the range. Tasks created or completed before this time will be included.
     * @param lastId Optional. Used to walk the paginated response, if there is one. Tasks created after this ID will be returned.
     * @param states Optional. A comma-separated list of task states.
     * @param workerId Optional. The ID of a worker whom is currently assigned to the tasks or has previously completed the tasks.
     * @param completeBeforeBefore Optional. The timestamp in Unix time before which the task completeBefore value must be.
     * @param completeAfterAfter Optional. The timestamp in Unix time after which the task completeAfter value must be.
     * @return
     */
    public Tasks listTasks(long from,
                           Long to,
                           String lastId,
                           List<Integer> states,
                           String workerId,
                           Long completeBeforeBefore,
                           Long completeAfterAfter,
                           List<String> dependencies) {

        return null;
    }

    /*public Task getSingleTask(String taskId) {
        return handleResponse(response, Task.class);
    }*/

    /*public Task getTaskByShortId(String taskShortId) {

    }*/

    public Task updateTask(Task task) {
        return null;
    }

    public void completeTask(CompletionDetails completionDetails) {

    }

    /*public void cloneTask(CloningOptions options) {

    }*/

    public void deleteTask(String taskId) {

    }

    /*public void autoAssign(List<String> tasksIds, AssignOptions options) {

    }*/

}
