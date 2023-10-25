package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.models.Metadata;
import com.onfleet.models.MetadataVisibility;
import com.onfleet.models.destination.Address;
import com.onfleet.models.destination.Destination;
import com.onfleet.models.recipient.Recipient;
import com.onfleet.models.task.AutomaticallyAssignTaskResult;
import com.onfleet.models.task.BatchJobStatus;
import com.onfleet.models.task.Task;
import com.onfleet.models.task.TaskAppearance;
import com.onfleet.models.task.TaskAutoAssignMode;
import com.onfleet.models.task.TaskAutoAssignMultiParams;
import com.onfleet.models.task.TaskAutoAssignOptions;
import com.onfleet.models.task.TaskAutoAssignParam;
import com.onfleet.models.task.TaskBarcode;
import com.onfleet.models.task.TaskBatchCreateResponseAsync;
import com.onfleet.models.task.TaskCloneParams;
import com.onfleet.models.task.TaskContainer;
import com.onfleet.models.task.TaskForceCompletionParams;
import com.onfleet.models.task.TaskListQueryParams;
import com.onfleet.models.task.TaskParams;
import com.onfleet.models.task.TaskState;
import com.onfleet.models.task.Tasks;
import com.onfleet.models.task.TasksPaginated;
import com.onfleet.utils.GsonSingleton;
import okhttp3.HttpUrl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskApiTest extends BaseApiTest {
	private TaskApi taskApi;

	@BeforeEach
	void setUp() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/tasks");
		taskApi = new TaskApi(okHttpClient);
		setBaseUrl(taskApi, baseUrl.toString());
	}

	@Test
	void testCreateTask() throws Exception {
		String json = "{\"id\":\"kc8SS1tzuZ~jqjlebKGrUmpe\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667234,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"8f983639\",\"trackingURL\":\"https://onf.lt/8f98363993\",\"worker\":\"1LjhGUWdxFbvdsTAAXs0TFos\",\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":0,\"completeAfter\":1455151071727,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches\",\"completionDetails\":{\"events\":[],\"time\":null},\"feedback\":[],\"metadata\":[],\"overrides\":{\"recipientSkipSMSNotifications\":null,\"recipientNotes\":null,\"recipientName\":null},\"container\":{\"type\":\"WORKER\",\"worker\":\"1LjhGUWdxFbvdsTAAXs0TFos\"},\"recipients\":[{\"id\":\"G7rcM2nqblmh8vj2do1FpaOQ\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667229,\"name\":\"Blas Silkovich\",\"phone\":\"+16505554481\",\"notes\":\"Knows Neiman, VIP status.\",\"skipSMSNotifications\":false,\"metadata\":[]}],\"destination\":{\"id\":\"zrVXZi5aDzOZlAghZaLfGAfA\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667220,\"location\":[-122.4438337,37.7940329],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Vallejo Street\",\"number\":\"2829\"},\"notes\":\"Small green door by garage door has pin pad, enter *4821*\",\"metadata\":[]},\"didAutoAssign\":true}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Recipient recipient = new Recipient.Builder()
				.setName("Blas Silkovich")
				.setPhone("650-555-4481")
				.setNotes("Knows Neiman, VIP status.")
				.build();

		Address address = new Address.Builder()
				.setUnparsed("2829 Vallejo St, SF, CA, USA")
				.build();


		Destination destination = new Destination.Builder()
				.setAddress(address)
				.setNotes("Small green door by garage door has pin pad, enter *4821*")
				.build();

		TaskParams params = new TaskParams.Builder()
				.setDestination(destination)
				.setRecipients(Collections.singletonList(recipient))
				.setCompleteAfter(1455151071727L)
				.setAutoAssign(new TaskAutoAssignParam.Builder().setMode(TaskAutoAssignMode.DISTANCE).build())
				.build();
		Task response = taskApi.createTask(params);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Task.class));
	}

	@Test
	void createTaskBatch() throws Exception {
		String json = "{\"tasks\":[{\"id\":\"C2AN77VYi1mqHwbKRBNCuEPZ\",\"timeCreated\":1507072619000,\"timeLastModified\":1507072619880,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"0dadas4c\",\"trackingURL\":\"https://onf.lt/0dadas4c\",\"worker\":null,\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":0,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches\",\"completionDetails\":{\"events\":[],\"failureReason\":\"NONE\",\"time\":null,\"firstLocation\":[],\"lastLocation\":[]},\"feedback\":[],\"metadata\":[],\"overrides\":{\"recipientSkipSMSNotifications\":null,\"recipientNotes\":null,\"recipientName\":null},\"quantity\":0,\"serviceTime\":0,\"container\":{\"type\":\"ORGANIZATION\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\"},\"recipients\":[{\"id\":\"G7rcM2nqblmh8vj2do1FpaOQ\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1491957797000,\"timeLastModified\":1507072619873,\"name\":\"Blas Silkovich\",\"phone\":\"+16505554481\",\"notes\":\"Knows Neiman, VIP status.\",\"skipSMSNotifications\":false,\"metadata\":[]}],\"destination\":{\"id\":\"h9nzV88L1gVkxxQywHqGUXOi\",\"timeCreated\":1507072619000,\"timeLastModified\":1507072619857,\"location\":[-122.4438337,37.7940329],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Vallejo Street\",\"number\":\"2829\"},\"notes\":\"Small green door by garage door has pin pad, enter *4821*\",\"metadata\":[]}},{\"id\":\"9l2s~L~jNB32TZmb*XRHCDJe\",\"timeCreated\":1507072620000,\"timeLastModified\":1507072620557,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"cafaqf73\",\"trackingURL\":\"https://onf.lt/cafaqf73\",\"worker\":null,\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":0,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":true,\"notes\":\"12 x 2016 Getariako Txakolina (Rosé)\",\"completionDetails\":{\"events\":[],\"failureReason\":\"NONE\",\"time\":null,\"firstLocation\":[],\"lastLocation\":[]},\"feedback\":[],\"metadata\":[{\"name\":\"caseId\",\"type\":\"number\",\"value\":33162,\"visibility\":[\"api\"]}],\"overrides\":{\"recipientSkipSMSNotifications\":null,\"recipientNotes\":null,\"recipientName\":null},\"quantity\":0,\"serviceTime\":0,\"container\":{\"type\":\"ORGANIZATION\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\"},\"recipients\":[],\"destination\":{\"id\":\"nzr69litF0Lw~rZjAdw8hx2s\",\"timeCreated\":1507072620000,\"timeLastModified\":1507072620548,\"location\":[-87.66117659999999,41.8999945],\"address\":{\"apartment\":\"\",\"state\":\"Illinois\",\"postalCode\":\"60642\",\"country\":\"United States\",\"city\":\"Chicago\",\"street\":\"West Augusta Boulevard\",\"number\":\"1264\"},\"notes\":\"\",\"metadata\":[]}}],\"errors\":[{\"error\":{\"statusCode\":400,\"error\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"cause\":\"Geocoding errors found. \"},\"task\":{\"destination\":{\"address\":{\"number\":\"420\",\"street\":\"Infinite Loop\",\"city\":\"Redmond\",\"state\":\"WA\",\"country\":\"USA\"}},\"recipients\":[{\"name\":\"S.N.\",\"phone\":\"206-341-8826\"}]}}]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		TaskParams params = getTaskParams();
		Tasks tasks = taskApi.createTasksBatch(Collections.singletonList(params));

		Assertions.assertThat(tasks).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Tasks.class));
	}

	@Test
	void testBatchAsync() throws Exception {
		String json = "{\"status\":\"pending\",\"jobId\":\"S3oI~WNX4b5cbF1adQxuEeJD\"}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		TaskBatchCreateResponseAsync responseAsync = taskApi.createTasksBatchAsync(Collections.singletonList(getTaskParams()));

		Assertions.assertThat(responseAsync)
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(json, TaskBatchCreateResponseAsync.class));
	}

	@Test
	void testGetBatchStatusJob() throws Exception {
		String json = "{\"status\":\"completedWithErrors\",\"submitted\":\"Less than a minute ago.\",\"tasksReceived\":3,\"tasksCreated\":2,\"tasksErrored\":1,\"errors\":[{\"statusCode\":400,\"errorCode\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"cause\":\"Geocoding errors found. \",\"taskData\":{\"destination\":{\"address\":{\"number\":\"420\",\"street\":\"Infinite Loop\",\"city\":\"Redmond\",\"state\":\"WA\",\"country\":\"USA\"}},\"recipients\":[{\"name\":\"S.N.\",\"phone\":\"206-341-8826\"}]}}],\"failedTasks\":[{\"destination\":{\"address\":{\"number\":\"420\",\"street\":\"Infinite Loop\",\"city\":\"Redmond\",\"state\":\"WA\",\"country\":\"USA\"}},\"recipients\":[{\"name\":\"S.N.\",\"phone\":\"206-341-8826\"}]}],\"newTasks\":[{\"id\":\"Du5FQzHhUPWgrQGbhjH*1g60\",\"timeCreated\":1685475228000,\"timeLastModified\":1685475228101,\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"shortId\":\"14e00e4f\",\"trackingURL\":\"https://onf.lt/14e00e4f\",\"worker\":null,\"merchant\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"executor\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"creator\":\"vjw*RDMKDljKVDve1Vtcplgu\",\"dependencies\":[],\"state\":0,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":true,\"notes\":\"12 x 2016 Getariako Txakolina (Rosé)\",\"completionDetails\":{\"failureNotes\":\"\",\"successNotes\":\"\",\"failureReason\":\"NONE\",\"events\":[],\"actions\":[],\"time\":null,\"signatureUploadId\":null,\"photoUploadId\":null,\"photoUploadIds\":null,\"firstLocation\":[],\"lastLocation\":[],\"unavailableAttachments\":[]},\"feedback\":[],\"metadata\":[{\"type\":\"number\",\"visibility\":[\"api\"],\"value\":33162,\"name\":\"caseId\"}],\"overrides\":{\"recipientName\":null,\"recipientNotes\":null,\"recipientSkipSMSNotifications\":null,\"useMerchantForProxy\":null},\"quantity\":0,\"additionalQuantities\":{\"quantityA\":0,\"quantityB\":0,\"quantityC\":0},\"serviceTime\":0,\"identity\":{\"failedScanCount\":0,\"checksum\":null},\"appearance\":{\"triangleColor\":null},\"scanOnlyRequiredBarcodes\":false,\"container\":{\"type\":\"ORGANIZATION\",\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\"},\"trackingViewed\":false,\"recipients\":[],\"destination\":{\"id\":\"bxiJ0IJxyEKA~iDiTtop9oBR\",\"timeCreated\":1685475228000,\"timeLastModified\":1685475228034,\"location\":[-87.6611882,41.8999943],\"address\":{\"apartment\":\"\",\"state\":\"Illinois\",\"postalCode\":\"60642\",\"number\":\"1264\",\"street\":\"West Augusta Boulevard\",\"city\":\"Chicago\",\"country\":\"United States\"},\"notes\":\"\",\"metadata\":[],\"googlePlaceId\":\"EisxMjY0IFcgQXVndXN0YSBCbHZkLCBDaGljYWdvLCBJTCA2MDY0MiwgVVNBIjESLwoUChIJC3XaOdTSD4gRvWkApUN78tgQ8AkqFAoSCbEoXPNKzQ-IEfZd3WVEWaiw\",\"warnings\":[],\"useGPS\":false}},{\"id\":\"1PCBuPGezUle8DpeSc~ytxSM\",\"timeCreated\":1685475228000,\"timeLastModified\":1685475228358,\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"shortId\":\"05b52298\",\"trackingURL\":\"https://onf.lt/05b52298b7\",\"worker\":null,\"merchant\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"executor\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"creator\":\"vjw*RDMKDljKVDve1Vtcplgu\",\"dependencies\":[],\"state\":0,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches\",\"completionDetails\":{\"failureNotes\":\"\",\"successNotes\":\"\",\"failureReason\":\"NONE\",\"events\":[],\"actions\":[],\"time\":null,\"signatureUploadId\":null,\"photoUploadId\":null,\"photoUploadIds\":null,\"firstLocation\":[],\"lastLocation\":[],\"unavailableAttachments\":[]},\"feedback\":[],\"metadata\":[],\"overrides\":{\"recipientName\":null,\"recipientNotes\":null,\"recipientSkipSMSNotifications\":null,\"useMerchantForProxy\":null},\"quantity\":0,\"additionalQuantities\":{\"quantityA\":0,\"quantityB\":0,\"quantityC\":0},\"serviceTime\":0,\"identity\":{\"failedScanCount\":0,\"checksum\":null},\"appearance\":{\"triangleColor\":null},\"scanOnlyRequiredBarcodes\":false,\"container\":{\"type\":\"ORGANIZATION\",\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\"},\"trackingViewed\":false,\"recipients\":[{\"id\":\"lYJtdciPMZpWksO5zqTnoedw\",\"timeCreated\":1643147927000,\"timeLastModified\":1685475228068,\"name\":\"Blas Silkovich\",\"phone\":\"+16505554481\",\"notes\":\"Knows Neiman, VIP status.\",\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"skipSMSNotifications\":false,\"metadata\":[]}],\"destination\":{\"id\":\"xFblWCJo2fqpC9nOM23w2gC9\",\"timeCreated\":1685475228000,\"timeLastModified\":1685475228030,\"location\":[-122.4438376,37.7939987],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"number\":\"2829\",\"street\":\"Vallejo Street\",\"city\":\"San Francisco\",\"country\":\"United States\"},\"notes\":\"Small green door by garage door has pin pad, enter *4821*\",\"metadata\":[],\"googlePlaceId\":\"ChIJQSINYtKAhYARCKOYhQ6z3nI\",\"warnings\":[],\"useGPS\":false}}],\"newTasksWithWarnings\":[]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		BatchJobStatus batchJobStatus = taskApi.getBatchJobStatus("jobId");


		Assertions.assertThat(batchJobStatus).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, BatchJobStatus.class));
	}

	@Test
	void testListTasks() throws Exception {
		String json = "{\"lastId\":\"tPMO~h03sOIqFbnhqaOXgUsd\",\"tasks\":[{\"id\":\"11z1BbsQUZFHD1XAd~emDDeK\",\"timeCreated\":1455072025000,\"timeLastModified\":1455072025278,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"31aac0a5\",\"trackingURL\":\"https://onf.lt/31aac0a5c\",\"worker\":\"h*wSb*apKlDkUFnuLTtjPke7\",\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":1,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"\",\"completionDetails\":{\"events\":[],\"time\":null},\"feedback\":[],\"metadata\":[],\"overrides\":{},\"container\":{\"type\":\"WORKER\",\"worker\":\"h*wSb*apKlDkUFnuLTtjPke7\"},\"recipients\":[{\"id\":\"xX87G1gSkeLvGXlHn2tn0~iB\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455072004000,\"timeLastModified\":1455072025272,\"name\":\"Blake Turing\",\"phone\":\"+16505552811\",\"notes\":\"\",\"skipSMSNotifications\":false,\"metadata\":[]}],\"destination\":{\"id\":\"pfT5L1JclTdhvRnP9GQzMFuL\",\"timeCreated\":1455072025000,\"timeLastModified\":1455072025264,\"location\":[-122.41289010000003,37.787933],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94109\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Post Street\",\"number\":\"666\"},\"notes\":\"\",\"metadata\":[]}},{\"id\":\"kc8SS1tzuZ~jqjlebKGrUmpe\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667234,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"8f983639\",\"trackingURL\":\"https://onf.lt/8f98363993\",\"worker\":\"1LjhGUWdxFbvdsTAAXs0TFos\",\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":1,\"completeAfter\":1455151071727,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches\",\"completionDetails\":{\"events\":[],\"time\":null},\"feedback\":[],\"metadata\":[],\"overrides\":{\"recipientSkipSMSNotifications\":null,\"recipientNotes\":null,\"recipientName\":null},\"container\":{\"type\":\"WORKER\",\"worker\":\"1LjhGUWdxFbvdsTAAXs0TFos\"},\"recipients\":[{\"id\":\"G7rcM2nqblmh8vj2do1FpaOQ\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667229,\"name\":\"Blas Silkovich\",\"phone\":\"+16505554481\",\"notes\":\"Knows Neiman, VIP status.\",\"skipSMSNotifications\":false,\"metadata\":[]}],\"destination\":{\"id\":\"zrVXZi5aDzOZlAghZaLfGAfA\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667220,\"location\":[-122.4438337,37.7940329],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Vallejo Street\",\"number\":\"2829\"},\"notes\":\"Small green door by garage door has pin pad, enter *4821*\",\"metadata\":[]}}]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		TaskListQueryParams params = new TaskListQueryParams.Builder(10000)
				.setTo(1100L)
				.setLastId("lastId")
				.setStates(Arrays.asList(TaskState.ACTIVE, TaskState.ASSIGNED, TaskState.UNASSIGNED, TaskState.COMPLETED))
				.setWorker("workerId")
				.setCompleteAfterAfter(10000L)
				.setCompleteBeforeBefore(20000L)
				.setTaskDependencies(Arrays.asList("task1", "task2"))
				.build();
		TasksPaginated tasks = taskApi.listTasks(params);

		Assertions.assertThat(tasks).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, TasksPaginated.class));
	}

	@Test
	void getSingleTask() throws Exception {
		String json = "{\"id\":\"qNMz6CKwQ*26FOslywsiQxhY\",\"timeCreated\":1455072004000,\"timeLastModified\":1455152824153,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"5f8b5c65\",\"trackingURL\":\"https://onf.lt/5f8b5c65f9\",\"worker\":\"h*wSb*apKlDkUFnuLTtjPke7\",\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":3,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"\",\"completionDetails\":{\"events\":[{\"name\":\"start\",\"time\":1455072035445},{\"name\":\"arrival\",\"time\":1455152532564,\"location\":[-122.401521416785,37.7762999215933]},{\"name\":\"departure\",\"time\":1455072096121,\"location\":[-122.401357311869,37.776509919239]}],\"failureReason\":\"NONE\",\"time\":1455152532732,\"photoUploadId\":\"1cf9c8d5d00a763865729825\",\"notes\":\"All went great, customer loves us.\",\"success\":true,\"signatureUploadId\":\"a49846b937eeab3cea248301\",\"photoUploadIds\":[],\"firstLocation\":[-122.401520936125,37.7762955408506],\"lastLocation\":[-122.401521416785,37.7762999215933],\"distance\":7847.92014273528},\"feedback\":[],\"metadata\":[],\"overrides\":{},\"quantity\":0,\"serviceTime\":0,\"trackingViewed\":false,\"estimatedCompletionTime\":null,\"delayTime\":null,\"destination\":{\"id\":\"Nml*Tdh1EMIk1RE46maqOLEQ\",\"timeCreated\":1455072004000,\"timeLastModified\":1455072004352,\"location\":[-122.40522369999996,37.7718827],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94103\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Brannan Street\",\"number\":\"888\"},\"notes\":\"\",\"metadata\":[]},\"eta\":null,\"recipients\":[{\"id\":\"xX87G1gSkeLvGXlHn2tn0~iB\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455072004000,\"timeLastModified\":1455072025272,\"name\":\"Mikel\",\"phone\":\"+16502837547\",\"notes\":\"\",\"skipSMSNotifications\":false,\"metadata\":[]}]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Task task = taskApi.getSingleTask("taskId");

		Assertions.assertThat(task).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Task.class));
	}

	@Test
	void getSingleTaskShortId() throws Exception {
		String json = "{\"id\":\"Eyi36gfoJMdAMyK3QiC3iFLq\",\"timeCreated\":1455152029000,\"timeLastModified\":1455153428203,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"e5f0cc28\",\"trackingURL\":\"https://onf.lt/e5f0cc28\",\"worker\":null,\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"cBrUjKvQQgdRp~s1qvQNLpK*\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":0,\"completeAfter\":1455151071727,\"completeBefore\":null,\"pickupTask\":true,\"notes\":\"Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches\",\"completionDetails\":{\"events\":[],\"time\":null},\"feedback\":[],\"metadata\":[],\"overrides\":{\"recipientSkipSMSNotifications\":null,\"recipientNotes\":null,\"recipientName\":null},\"container\":{\"type\":\"ORGANIZATION\",\"organization\":\"cBrUjKvQQgdRp~s1qvQNLpK*\"},\"recipients\":[],\"destination\":{\"id\":\"d~jvinosyxbjVo5yt3wY8lJl\",\"timeCreated\":1455152029000,\"timeLastModified\":1455153428197,\"location\":[-122.4438337,37.7940329],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Vallejo Street\",\"number\":\"2829\"},\"notes\":\"Small green door by garage door has pin pad, enter *4821*\",\"metadata\":[]}}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Task task = taskApi.getTaskByShortId("shortId");

		Assertions.assertThat(task).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Task.class));
	}

	@Test
	void testUpdateTask() throws Exception {
		String json = "{\"id\":\"kc8SS1tzuZ~jqjlebKGrUmpe\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156668922,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"8f983639\",\"trackingURL\":\"https://onf.lt/8f98363993\",\"worker\":null,\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":0,\"completeAfter\":1455151071727,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"Patxi's deep dish meat lover special, 2 bottles of Basque cider\",\"completionDetails\":{\"events\":[],\"time\":null},\"feedback\":[],\"metadata\":[],\"overrides\":{\"recipientSkipSMSNotifications\":null,\"recipientNotes\":null,\"recipientName\":null},\"container\":{\"type\":\"TEAM\",\"team\":\"fwflFNVvrK~4t0m5hKFIxBUl\"},\"recipients\":[{\"id\":\"G7rcM2nqblmh8vj2do1FpaOQ\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667229,\"name\":\"Blas Silkovich\",\"phone\":\"+16505554481\",\"notes\":\"Knows Neiman, VIP status.\",\"skipSMSNotifications\":false,\"metadata\":[]}],\"destination\":{\"id\":\"zrVXZi5aDzOZlAghZaLfGAfA\",\"timeCreated\":1455156667000,\"timeLastModified\":1455156667220,\"location\":[-122.4438337,37.7940329],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Vallejo Street\",\"number\":\"2829\"},\"notes\":\"Small green door by garage door has pin pad, enter *4821*\",\"metadata\":[]}}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Task task = taskApi.updateTask("taskId", getTaskParams());
		Assertions.assertThat(task).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Task.class));
	}

	@Test
	void testCompleteTask() throws Exception {
		enqueueMockResponse(HttpURLConnection.HTTP_OK);
		TaskForceCompletionParams completionParams = new TaskForceCompletionParams(true);
		taskApi.completeTask("taskId", completionParams);
	}

	@Test
	void testCloneTask() throws Exception {
		String json = "{\"id\":\"fesYPEu2FWvubaq~2nof*lCA\",\"timeCreated\":1489010058000,\"timeLastModified\":1489010058477,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"shortId\":\"9b4zd53d\",\"trackingURL\":\"https://onf.lt/9b4zd53d\",\"worker\":null,\"merchant\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"executor\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"creator\":\"EJmsbJgHiRLPjNVE7GEIPs7*\",\"dependencies\":[],\"state\":0,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"\",\"completionDetails\":{\"events\":[],\"failureReason\":\"NONE\",\"time\":null},\"feedback\":[],\"metadata\":[],\"overrides\":{},\"quantity\":0,\"serviceTime\":0,\"delayTime\":null,\"sourceTaskId\":\"uO2vKr07h6zg7Fzf~2NC3KLg\",\"container\":{\"type\":\"ORGANIZATION\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\"},\"recipients\":[],\"destination\":{\"id\":\"Fa0Oxd21cL3T36qw5mGOvZw6\",\"timeCreated\":1485469374000,\"timeLastModified\":1485469374734,\"location\":[-122.43232727050781,37.79811961477822],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94123\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Buchanan Street\",\"number\":\"3020\"},\"notes\":\"\",\"metadata\":[]}}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		TaskCloneParams params = new TaskCloneParams.Builder().build();
		Task task = taskApi.cloneTask("taskId", params);

		Assertions.assertThat(task).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Task.class));
	}

	@Test
	void testDeleteTask() throws Exception {
		enqueueMockResponse(HttpURLConnection.HTTP_OK);
		taskApi.deleteTask("taskId");
	}

	@Test
	void testAutoAssignTasks() throws Exception {
		String json = "{\"assignedTasksCount\":3,\"assignedTasks\":{\"7z784Upb0cdm8GqPzKLVAHSI\":\"GPOQQjU84QPN~fP*pbunT2CW\",\"PDQyZQvaudBN7pEhLcIndjPh\":\"GPOQQjU84QPN~fP*pbunT2CW\",\"3flkKAFPUiQuLl5ZZ*04v41i\":\"GPOQQjU84QPN~fP*pbunT2CW\"}}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		TaskAutoAssignMultiParams params = new TaskAutoAssignMultiParams.Builder()
				.setTasks(Arrays.asList("11z1BbsQUZFHD1XAd~emDDeK", "kc8SS1tzuZ~jqjlebKGrUmpe"))
				.setOptions(new TaskAutoAssignOptions.Builder()
						.setMode(TaskAutoAssignMode.DISTANCE)
						.setTeams(Collections.singletonList("fwflFNVvrK~4t0m5hKFIxBUl"))
						.setConsiderDependencies(true)
						.build())
				.build();
		AutomaticallyAssignTaskResult result = taskApi.autoAssign(params);

		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, AutomaticallyAssignTaskResult.class));
	}

	private TaskParams getTaskParams() {
		return new TaskParams.Builder()
				.setRecipients(new String[]{"idRecipient1"})
				.setDestination("string")
				.setAppearance(new TaskAppearance("purple"))
				.setRequirements(null)
				.setAutoAssign(null)
				.setContainer(new TaskContainer.Builder().build())
				.setBarcodes(Collections.singletonList(new TaskBarcode("asdasdasd", false)))
				.build();
	}

	@Test
	void testQueryWithMetadata() throws Exception {
		String json = "[{\"id\":\"aCbtgPsM*w7lAf61t4YqQODO\",\"metadata\":[{\"name\":\"hasDog\",\"type\":\"boolean\",\"value\":true,\"visibility\":[\"api\"]}]},{\"id\":\"YI**76lT7nu053HRWHPVLhKW\",\"tasks\":[],\"metadata\":[{\"name\":\"hasDog\",\"type\":\"boolean\",\"value\":true,\"visibility\":[\"api\"]}]}]";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		List<Metadata> metadataList = Collections.singletonList(new Metadata.Builder().setName("isHighNetWorth")
				.setType("boolean")
				.setValue("false")
				.setMetadataVisibility(Collections.singletonList(MetadataVisibility.DASHBOARD))
				.build());

		List<Task> tasks = taskApi.queryWithMetadata(metadataList);

		assertThat(tasks).usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(json, new TypeToken<List<Task>>() {
				}.getType()));
	}

}