package com.onfleet.api;


import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.ErrorResponse;
import com.onfleet.models.Metadata;
import com.onfleet.models.MetadataVisibility;
import com.onfleet.models.VehicleType;
import com.onfleet.models.worker.Worker;
import com.onfleet.models.worker.WorkerAddresses;
import com.onfleet.models.worker.WorkerCreateParams;
import com.onfleet.models.worker.WorkerFilterFields;
import com.onfleet.models.worker.WorkerListQueryParams;
import com.onfleet.models.worker.WorkerQueryParams;
import com.onfleet.models.worker.WorkerRouting;
import com.onfleet.models.worker.WorkerScheduleEntries;
import com.onfleet.models.worker.WorkerScheduleEntry;
import com.onfleet.models.worker.WorkerStates;
import com.onfleet.models.worker.WorkerTasks;
import com.onfleet.models.worker.WorkerTasksQueryParams;
import com.onfleet.models.worker.WorkerUpdateParams;
import com.onfleet.models.worker.WorkerVehicle;
import com.onfleet.models.worker.Workers;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WorkerApiTest extends BaseApiTest {
	private WorkerApi workerApi;

	@BeforeEach
	void setUp() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/workers");
		workerApi = new WorkerApi(okHttpClient);
		setBaseUrl(workerApi, baseUrl.toString());
	}

	@Test
	void testCreateWorker() throws Exception {
		String mockResponseJson = "{\"id\":\"sFtvhYK2l26zS0imptJJdC2q\",\"timeCreated\":1455156653000,\"timeLastModified\":1455156653214,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"A Swartz\",\"displayName\":\"AS\",\"phone\":\"+16173428853\",\"activeTask\":null,\"tasks\":[],\"onDuty\":false,\"timeLastSeen\":null,\"capacity\":0,\"userData\":{\"appVersion\":\"1.2.0\",\"batteryLevel\":0.99,\"deviceDescription\":\"iPhone XS\",\"platform\":\"IOS\"},\"accountStatus\":\"ACCEPTED\",\"metadata\":[],\"imageUrl\":null,\"teams\":[\"nz1nG1Hpx9EHjQCJsT2VAs~o\"],\"delayTime\":null,\"vehicle\":{\"id\":\"tN1HjcvygQWvz5FRR1JAxwL8\",\"type\":\"CAR\",\"description\":\"Tesla Model 3\",\"licensePlate\":\"FKNS9A\",\"color\":\"purple\",\"timeLastModified\":154086815176}}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		WorkerVehicle vehicle = new WorkerVehicle.Builder(VehicleType.CAR)
				.setColor("purple")
				.setLicensePlate("FKNS9A")
				.setDescription("Tesla Model 3")
				.build();
		WorkerCreateParams params = new WorkerCreateParams
				.Builder("A Swartz", "617-342-8853", Collections.singletonList("nz1nG1Hpx9EHjQCJsT2VAs~o"))
				.setWorkerVehicle(vehicle)
				.setCapacity(15.0)
				.setDisplayName("displayName")
				.setAddresses(new WorkerAddresses(
						new WorkerRouting.Builder()
								.setId("workerRoutingId")
								.setCreatedByLocation(true)
								.setNotes("notes")
								.setGooglePlaceId("googlePlaceId")
								.setWasGeocoded(false)
								.setTimeCreated(10000L)
								.setOrganization("orgId")
								.build()
				))
				.build();
		Worker createdWorker = workerApi.createWorker(params);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/workers", request.getPath());
		assertEquals("sFtvhYK2l26zS0imptJJdC2q", createdWorker.getId());
		Assertions.assertThat(createdWorker).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Worker.class));
	}

	@Test
	void testCreateWorkerWithErrorMissingArgument() throws Exception {
		String mockResponse = "{\"code\":\"InvalidArgument\",\"message\":{\"error\":1900,\"message\":\"One or more parameters required for this request are either missing or have an invalid format.\",\"cause\":\"Team IDs array missing\",\"request\":\"bc41a8eb-a604-4a1c-aa5a-e86a975c141b\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_BAD_REQUEST);

		WorkerCreateParams params = new WorkerCreateParams.Builder("John Doe", "123-456-7890", null)
				.build();
		ApiException exception = assertThrows(ApiException.class, () -> workerApi.createWorker(params));
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/workers", request.getPath());
		assertEquals(HttpURLConnection.HTTP_BAD_REQUEST, exception.getStatusCode());
		assertEquals("InvalidArgument", exception.getErrorResponse().getCode());
		assertEquals(1900, exception.getErrorResponse().getMessage().getError());
		assertEquals("One or more parameters required for this request are either missing or have an invalid format.", exception.getErrorResponse().getMessage().getMessage());
		assertEquals("Team IDs array missing", exception.getErrorResponse().getMessage().getCause());
		assertEquals("bc41a8eb-a604-4a1c-aa5a-e86a975c141b", exception.getErrorResponse().getMessage().getRequest());

		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, ErrorResponse.class));
	}

	@Test
	void testCreateWorkerErrorInvalidFormat() throws Exception {
		String mockResponse = "{\"code\":\"InvalidContent\",\"message\":{\"error\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"cause\":\"Invalid phone number format\",\"request\":\"fff8ed50-4ca0-4ff9-9230-b73096eb8502\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_BAD_REQUEST);

		WorkerCreateParams params = new WorkerCreateParams.Builder("John Doe", "123-456-7890", null)
				.build();
		ApiException exception = assertThrows(ApiException.class, () -> workerApi.createWorker(params));
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/workers", request.getPath());
		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, ErrorResponse.class));
	}

	@Test
	void testCreateWorkerErrorDuplicatedPhone() throws Exception {
		String mockResponseJson = "{\"code\":\"InvalidContent\",\"message\":{\"error\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"cause\":\"Invalid phone number format\",\"request\":\"fff8ed50-4ca0-4ff9-9230-b73096eb8502\"}}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_BAD_REQUEST);

		WorkerCreateParams params = new WorkerCreateParams.Builder("John Doe", "123-456-7890", null)
				.build();
		ApiException exception = assertThrows(ApiException.class, () -> workerApi.createWorker(params));
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/workers", request.getPath());
		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, ErrorResponse.class));
	}

	@Test
	void testListWorkers() throws Exception {
		String mockResponseJson = "[{\"id\":\"h*wSb*apKlDkUFnuLTtjPke7\",\"timeCreated\":1455049674000,\"timeLastModified\":1455156646529,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Andoni\",\"displayName\":\"Andoni\",\"phone\":\"+14155558442\",\"activeTask\":null,\"tasks\":[\"11z1BbsQUZFHD1XAd~emDDeK\"],\"onDuty\":true,\"timeLastSeen\":1455156644323,\"capacity\":0,\"userData\":{\"appVersion\":\"1.2.0\",\"batteryLevel\":0.99,\"deviceDescription\":\"Simulator (iOS 12.1.0)\",\"platform\":\"IOS\"},\"accountStatus\":\"ACCEPTED\",\"metadata\":[{\"name\":\"nickname\",\"type\":\"string\",\"value\":\"Puffy\",\"visibility\":[\"api\"]},{\"name\":\"otherDetails\",\"type\":\"object\",\"value\":{\"availability\":{\"mon\":\"10:00\",\"sat\":\"16:20\",\"wed\":\"13:30\"},\"premiumInsurance\":false,\"trunkSize\":9.5},\"visibility\":[\"api\"]}],\"imageUrl\":null,\"teams\":[\"R4P7jhuzaIZ4cHHZE1ghmTtB\"],\"delayTime\":null,\"location\":[-122.4015496466794,37.77629837661284],\"vehicle\":null},{\"id\":\"1LjhGUWdxFbvdsTAAXs0TFos\",\"timeCreated\":1455049755000,\"timeLastModified\":1455072352267,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Yevgeny\",\"displayName\":\"YV\",\"phone\":\"+14155552299\",\"activeTask\":null,\"tasks\":[\"*0tnJcly~vSI~9uHz*ICHXTw\",\"PauBfRH8gQCjtMLaPe97G8Jf\"],\"onDuty\":true,\"timeLastSeen\":1455156649007,\"capacity\":0,\"userData\":{\"appVersion\":\"1.2.0\",\"batteryLevel\":0.97,\"deviceDescription\":\"Galaxy S8\",\"platform\":\"Android\"},\"accountStatus\":\"ACCEPTED\",\"metadata\":[],\"location\":[-122.4016366,37.7764098],\"imageUrl\":null,\"teams\":[\"9dyuPqHt6kDK5JKHFhE0xihh\",\"yKpCnWprM1Rvp3NGGlVa5TMa\",\"fwflFNVvrK~4t0m5hKFIxBUl\"],\"delayTime\":null,\"vehicle\":{\"id\":\"ArBoHNxS4B76AiBKoIawY9OS\",\"type\":\"CAR\",\"description\":\"Lada Niva\",\"licensePlate\":\"23KJ129\",\"color\":\"Red\",\"timeLastModified\":1545086815176}}]";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		WorkerListQueryParams queryParams = new WorkerListQueryParams.Builder()
				.fields(Arrays.asList(WorkerFilterFields.NAME, WorkerFilterFields.PHONE))
				.teamIds(Arrays.asList("team1", "team2"))
				.workerStates(Collections.singletonList(WorkerStates.ACTIVE))
				.phoneNumbers(Arrays.asList("123-456-7890", "987-654-3210"))
				.includePasswordDetails(true)
				.build();
		List<Worker> workers = workerApi.listWorkers(queryParams);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assert request.getPath() != null;
		assertEquals("/workers?fields=name,phone&teamsIds=team1,team2&states=2&phoneNumbers=123-456-7890,987-654-3210&includePasswordDetails=true",
				URLDecoder.decode(request.getPath(), StandardCharsets.UTF_8.name()));
		assertEquals(2, workers.size());
		assertEquals("h*wSb*apKlDkUFnuLTtjPke7", workers.get(0).getId());
		assertEquals("1LjhGUWdxFbvdsTAAXs0TFos", workers.get(1).getId());
		Assertions.assertThat(workers).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, new TypeToken<List<Worker>>() {
		}.getType()));
	}

	@Test
	void testListWorkersAssignedTasks() throws Exception {
		String mockResponse = "{\"tasks\":[{\"id\":\"3VtEMGudjwjjM60j7deSIY3j\",\"timeCreated\":1643317843000,\"timeLastModified\":1643319602671,\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"shortId\":\"c77ff497\",\"trackingURL\":\"https://onf.lt/c77ff497\",\"worker\":\"ZxcnkJi~79nonYaMTQ960Mg2\",\"merchant\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"executor\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"creator\":\"vjw*RDMKDljKVDve1Vtcplgu\",\"dependencies\":[],\"state\":1,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"\",\"completionDetails\":{\"failureNotes\":\"\",\"failureReason\":\"NONE\",\"events\":[],\"actions\":[],\"time\":null,\"firstLocation\":[],\"lastLocation\":[],\"unavailableAttachments\":[]},\"feedback\":[],\"metadata\":[],\"overrides\":{},\"quantity\":0,\"additionalQuantities\":{\"quantityA\":0,\"quantityB\":0,\"quantityC\":0},\"serviceTime\":0,\"identity\":{\"failedScanCount\":0,\"checksum\":null},\"appearance\":{\"triangleColor\":null},\"scanOnlyRequiredBarcodes\":false,\"container\":{\"type\":\"WORKER\",\"worker\":\"ZxcnkJi~79nonYaMTQ960Mg2\"},\"trackingViewed\":false,\"recipients\":[],\"eta\":null,\"delayTime\":null,\"estimatedCompletionTime\":null,\"estimatedArrivalTime\":null,\"destination\":{\"id\":\"nk5xGuf1eQguYXg1*mIVl0Ut\",\"timeCreated\":1643317843000,\"timeLastModified\":1643317843121,\"location\":[-117.8764687,33.8078476],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"92806\",\"number\":\"2695\",\"street\":\"East Katella Avenue\",\"city\":\"Anaheim\",\"country\":\"United States\",\"name\":\"Honda Center\"},\"notes\":\"\",\"metadata\":[],\"googlePlaceId\":\"ChIJXyczhHXX3IARFVUqyhMqiqg\",\"warnings\":[]}}]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		WorkerTasks workersTasks = workerApi.getWorkersTasks("3VtEMGudjwjjM60j7deSIY3j");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assertEquals("/workers/3VtEMGudjwjjM60j7deSIY3j/tasks", request.getPath());
		Assertions.assertThat(workersTasks).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, WorkerTasks.class));
	}


	@Test
	void testListWorkersAssignedTasksWithAllQueryParameters() throws Exception {
		String mockResponse = "{\"tasks\":[{\"id\":\"3VtEMGudjwjjM60j7deSIY3j\",\"timeCreated\":1643317843000,\"timeLastModified\":1643319602671,\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"shortId\":\"c77ff497\",\"trackingURL\":\"https://onf.lt/c77ff497\",\"worker\":\"ZxcnkJi~79nonYaMTQ960Mg2\",\"merchant\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"executor\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"creator\":\"vjw*RDMKDljKVDve1Vtcplgu\",\"dependencies\":[],\"state\":1,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"\",\"completionDetails\":{\"failureNotes\":\"\",\"failureReason\":\"NONE\",\"events\":[],\"actions\":[],\"time\":null,\"firstLocation\":[],\"lastLocation\":[],\"unavailableAttachments\":[]},\"feedback\":[],\"metadata\":[],\"overrides\":{},\"quantity\":0,\"additionalQuantities\":{\"quantityA\":0,\"quantityB\":0,\"quantityC\":0},\"serviceTime\":0,\"identity\":{\"failedScanCount\":0,\"checksum\":null},\"appearance\":{\"triangleColor\":null},\"scanOnlyRequiredBarcodes\":false,\"container\":{\"type\":\"WORKER\",\"worker\":\"ZxcnkJi~79nonYaMTQ960Mg2\"},\"trackingViewed\":false,\"recipients\":[],\"eta\":null,\"delayTime\":null,\"estimatedCompletionTime\":null,\"estimatedArrivalTime\":null,\"destination\":{\"id\":\"nk5xGuf1eQguYXg1*mIVl0Ut\",\"timeCreated\":1643317843000,\"timeLastModified\":1643317843121,\"location\":[-117.8764687,33.8078476],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"92806\",\"number\":\"2695\",\"street\":\"East Katella Avenue\",\"city\":\"Anaheim\",\"country\":\"United States\",\"name\":\"Honda Center\"},\"notes\":\"\",\"metadata\":[],\"googlePlaceId\":\"ChIJXyczhHXX3IARFVUqyhMqiqg\",\"warnings\":[]}}]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		WorkerTasksQueryParams queryParams = new WorkerTasksQueryParams.Builder()
				.setFrom(1000L)
				.setTo(1000L)
				.setLastId("123")
				.setIsPickUpTask(true)
				.build();
		workerApi.getWorkersTasks("3VtEMGudjwjjM60j7deSIY3j", queryParams);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("/workers/3VtEMGudjwjjM60j7deSIY3j/tasks?from=1000&to=1000&lastId=123&isPickUpTask=true", request.getPath());
	}

	@Test
	void testGetWorkersByLocation() throws Exception {
		String mockResponse = "{\"workers\":[{\"id\":\"h*wSb*apKlDkUFnuLTtjPke7\",\"timeCreated\":1458416497000,\"timeLastModified\":1478383350446,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Andoni\",\"displayName\":\"Andoni\",\"phone\":\"+14155558442\",\"activeTask\":\"kc8SS1tzuZ~jqjlebKGrUmpe\",\"tasks\":[\"11z1BbsQUZFHD1XAd~emDDeK\",\"kc8SS1tzuZ~jqjlebKGrUmpe\"],\"onDuty\":true,\"isResponding\":true,\"timeLastSeen\":1480385504517,\"capacity\":0,\"userData\":{},\"accountStatus\":\"ACCEPTED\",\"metadata\":[],\"imageUrl\":null,\"location\":[-122.4088934,37.7593079],\"delayTime\":1650,\"vehicle\":{\"id\":\"ArBoHNxS4B76AiBKoIawY9OS\",\"type\":\"CAR\",\"description\":\"Tesla Roadster\",\"licensePlate\":\"ELON4PREZ\",\"color\":\"black\",\"timeLastModified\":1478383350431}},{\"id\":\"sFtvhYK2l26zS0imptJJdC2q\",\"timeCreated\":1473361545000,\"timeLastModified\":1480384608044,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Hitachino\",\"displayName\":\"HT\",\"phone\":\"+16175552820\",\"activeTask\":null,\"tasks\":[],\"onDuty\":true,\"isResponding\":true,\"timeLastSeen\":1480385496759,\"capacity\":0,\"userData\":{\"deviceDescription\":\"iPhone 6S (iOS 9.3.2)\",\"batteryLevel\":0.43,\"appVersion\":\"0.9.65\",\"platform\":\"IOS\"},\"accountStatus\":\"ACCEPTED\",\"metadata\":[],\"imageUrl\":null,\"location\":[-122.4431349803903,37.75080475959717],\"delayTime\":null,\"vehicle\":{\"id\":\"tN1HjcvygQWvz5FRR1JAxwL8\",\"type\":\"CAR\",\"description\":null,\"licensePlate\":null,\"color\":null,\"timeLastModified\":1473361545335}}]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		Workers workers = workerApi.getWorkersByLocation(-122.41275787353516, 37.78998061344339, 6000);
		RecordedRequest request = mockWebServer.takeRequest();

		assert request.getPath() != null;
		assertEquals("/workers/location?longitude=-122.41275787353516&latitude=37.78998061344339&radius=6000",
				URLDecoder.decode(request.getPath(), StandardCharsets.UTF_8.name()));
		assertEquals(2, workers.getWorkers().size());
		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		Assertions.assertThat(workers).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, Workers.class));
	}

	@Test
	void testGetSingleWorker() throws Exception {
		String mockResponse = "{\"id\":\"1LjhGUWdxFbvdsTAAXs0TFos\",\"timeCreated\":1455049755000,\"timeLastModified\":1455072352267,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Yevgeny\",\"phone\":\"+14155552299\",\"activeTask\":null,\"tasks\":[\"*0tnJcly~vSI~9uHz*ICHXTw\",\"PauBfRH8gQCjtMLaPe97G8Jf\"],\"onDuty\":true,\"timeLastSeen\":1455156649007,\"delayTime\":null,\"teams\":[\"9dyuPqHt6kDK5JKHFhE0xihh\",\"yKpCnWprM1Rvp3NGGlVa5TMa\",\"fwflFNVvrK~4t0m5hKFIxBUl\"],\"metadata\":[],\"location\":[-122.4016366,37.7764098],\"vehicle\":{\"id\":\"ArBoHNxS4B76AiBKoIawY9OS\",\"type\":\"CAR\",\"description\":\"Lada Niva\",\"licensePlate\":\"23KJ129\",\"color\":\"Red\"},\"analytics\":{\"events\":[{\"action\":\"onduty\",\"time\":1455072352164},{\"action\":\"offduty\",\"time\":1455072485603}],\"distances\":{\"enroute\":0,\"idle\":0},\"times\":{\"enroute\":0,\"idle\":132.18},\"taskCounts\":{\"succeeded\":0,\"failed\":0}}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		WorkerQueryParams queryParams = new WorkerQueryParams.Builder()
				.setFilterFields(Arrays.asList(WorkerFilterFields.NAME, WorkerFilterFields.PHONE))
				.setPhones(Arrays.asList("123-456-7890", "987-654-3210"))
				.setStates(Arrays.asList(1, 2, 3))
				.setTeams(Arrays.asList("Team1", "Team2"))
				.setEnableAnalytics(true)
				.build();
		Worker worker = workerApi.getSingleWorker("1LjhGUWdxFbvdsTAAXs0TFos", queryParams);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assert request.getPath() != null;
		assertEquals("/workers/1LjhGUWdxFbvdsTAAXs0TFos?filter=name,phone&phones=123-456-7890,987-654-3210&states=1,2,3&teams=Team1,Team2&analytics=true",
				URLDecoder.decode(request.getPath(), StandardCharsets.UTF_8.name()));
		Assertions.assertThat(worker).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, Worker.class));
	}

	@Test
	void testUpdateWorker() throws Exception {
		String mockResponse = "{\"id\":\"sFtvhYK2l26zS0imptJJdC2q\",\"timeCreated\":1455156653000,\"timeLastModified\":1455156654558,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"new name\",\"phone\":\"+16173428853\",\"activeTask\":null,\"tasks\":[],\"onDuty\":false,\"timeLastSeen\":null,\"delayTime\":null,\"teams\":[\"lHCUJFvh6v0YDURKjokZbvau\"],\"metadata\":[],\"vehicle\":{\"id\":\"tN1HjcvygQWvz5FRR1JAxwL8\",\"type\":\"CAR\",\"description\":\"Tesla Model 3\",\"licensePlate\":\"FKNS9A\",\"color\":\"purple\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		WorkerUpdateParams workerUpdateParams = new WorkerUpdateParams.Builder()
				.setName("John Doe")
				.setTeams(Arrays.asList("Team1", "Team2"))
				.setCapacity(100.0)
				.setDisplayName("Worker Display Name")
				.build();
		Worker workerResponse = workerApi.updateWorker("sFtvhYK2l26zS0imptJJdC2q", workerUpdateParams);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.PUT.name(), request.getMethod());
		assertEquals("/workers/sFtvhYK2l26zS0imptJJdC2q", request.getPath());
		Assertions.assertThat(workerResponse).usingRecursiveComparison().isEqualTo(
				GsonSingleton.getInstance().fromJson(mockResponse, Worker.class)
		);
	}

	@Test
	void testDeleteWorker() throws Exception {
		enqueueMockResponse(HttpURLConnection.HTTP_OK);

		workerApi.deleteWorker("sFtvhYK2l26zS0imptJJdC2q");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.DELETE.name(), request.getMethod());
		assertEquals("/workers/sFtvhYK2l26zS0imptJJdC2q", request.getPath());
	}

	@Test
	void testGetWorkersSchedule() throws Exception {
		String mockJsonResponse = "{\"entries\":[{\"date\":\"2017-07-20\",\"shifts\":[[1500591600000,1500613200000]],\"timezone\":\"America/Los_Angeles\"},{\"date\":\"2017-07-17\",\"shifts\":[[1500307200000,1500314400000],[1500323100000,1500336000000]],\"timezone\":\"America/Los_Angeles\"}]}";
		enqueueMockResponse(mockJsonResponse, HttpURLConnection.HTTP_OK);

		WorkerScheduleEntries entries = workerApi.getWorkerSchedule("GPOQQjU84QPN~fP*pbunT2CW");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assertEquals("/workers/GPOQQjU84QPN~fP*pbunT2CW/schedule", request.getPath());
		Assertions.assertThat(entries).usingRecursiveComparison().isEqualTo(
				GsonSingleton.getInstance().fromJson(mockJsonResponse, WorkerScheduleEntries.class)
		);
	}

	@Test
	void testSetWorkersSchedule() throws Exception {
		String mockResponse = "{\"entries\":[{\"date\":\"2017-07-20\",\"shifts\":[[1500591600000,1500613200000]],\"timezone\":\"America/Los_Angeles\"},{\"date\":\"2017-07-17\",\"shifts\":[[1500307200000,1500314400000],[1500323100000,1500336000000]],\"timezone\":\"America/Los_Angeles\"}]}";
		String mockRequest = "{\"entries\":[{\"date\":\"2017-07-16\",\"timezone\":\"America/Los_Angeles\",\"shifts\":[[1500213600000,1500249600000]]},{\"date\":\"2017-07-20\",\"timezone\":\"America/Los_Angeles\",\"shifts\":[[1500591600000,1500613200000]]},{\"date\":\"2017-07-17\",\"timezone\":\"America/Los_Angeles\",\"shifts\":[[1500307200000,1500314400000],[1500323100000,1500336000000]]},{\"date\":\"2016-07-17\",\"timezone\":\"America/Los_Angeles\",\"shifts\":[[1500307200000,1500314400000],[1500323100000,1500336000000]]}]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		List<WorkerScheduleEntry> scheduleEntries = getWorkerScheduleEntries();

		WorkerScheduleEntries entries = workerApi.setWorkerSchedule("GPOQQjU84QPN~fP*pbunT2CW", scheduleEntries);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(mockRequest, request.getBody().readUtf8());
		assertEquals("/workers/GPOQQjU84QPN~fP*pbunT2CW/schedule", request.getPath());
		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		Assertions.assertThat(entries).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, WorkerScheduleEntries.class));
	}

	@NotNull
	private static List<WorkerScheduleEntry> getWorkerScheduleEntries() {
		List<WorkerScheduleEntry> scheduleEntries = new ArrayList<>();
		WorkerScheduleEntry entry = new WorkerScheduleEntry("2017-07-16", "America/Los_Angeles");
		entry.addShift(1500213600000L, 1500249600000L);
		scheduleEntries.add(entry);
		entry = new WorkerScheduleEntry("2017-07-20", "America/Los_Angeles");
		entry.addShift(1500591600000L, 1500613200000L);
		scheduleEntries.add(entry);
		entry = new WorkerScheduleEntry("2017-07-17", "America/Los_Angeles");
		entry.addShift(1500307200000L, 1500314400000L);
		entry.addShift(1500323100000L, 1500336000000L);
		scheduleEntries.add(entry);
		entry = new WorkerScheduleEntry("2016-07-17", "America/Los_Angeles");
		entry.addShift(1500307200000L, 1500314400000L);
		entry.addShift(1500323100000L, 1500336000000L);
		scheduleEntries.add(entry);
		return scheduleEntries;
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

		List<Worker> workers = workerApi.queryWithMetadata(metadataList);

		assertThat(workers).usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(json, new TypeToken<List<Worker>>() {
				}.getType()));
	}

}
