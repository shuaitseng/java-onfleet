package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.ErrorResponse;
import com.onfleet.models.task.Task;
import com.onfleet.models.task.Tasks;
import com.onfleet.models.Team;
import com.onfleet.models.VehicleType;
import com.onfleet.models.WorkerRoute;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TeamApiTest extends BaseApiTest {

	private TeamApi teamApi;

	@BeforeEach
	void setUp() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/teams");
		teamApi = new TeamApi(okHttpClient);
		setBaseUrl(teamApi, baseUrl.toString());
	}

	@Test
	void testCreateTeam() throws Exception {
		String mockResponse = "{\"id\":\"FFqPs1KHayxorfA~~xIj0us4\",\"timeCreated\":1455156655000,\"timeLastModified\":1455156655647,\"name\":\"Sunset\",\"workers\":[\"1LjhGUWdxFbvdsTAAXs0TFos\",\"F8WPCqGmQYWpCkQ2c8zJTCpW\"],\"managers\":[\"Mrq7aKqzPFKX22pmjdLx*ohM\"],\"hub\":\"tKxSfU7psqDQEBVn5e2VQ~*O\",\"enableSelfAssignment\":false}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		Team team = new Team();
		team.setName("Sunset");
		team.setWorkers(Arrays.asList("1LjhGUWdxFbvdsTAAXs0TFos", "F8WPCqGmQYWpCkQ2c8zJTCpW"));
		team.setManagers(Collections.singletonList("Mrq7aKqzPFKX22pmjdLx*ohM"));
		team.setHubId("tKxSfU7psqDQEBVn5e2VQ~*O");
		Team createdTeam = teamApi.createTeam(team);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("/teams", request.getPath());
		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("FFqPs1KHayxorfA~~xIj0us4", createdTeam.getId());
		assertEquals("Sunset", createdTeam.getName());
		Assertions.assertThat(createdTeam)
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, Team.class));
	}

	@Test
	void testCreateTeamDuplicatedName() {
		String mockResponse = "{\"code\":\"InvalidArgument\",\"message\":{\"error\":1901,\"message\":\"One or more parameters required for this request must be unique but are not unique.\",\"cause\":\"Name is not unique within org\",\"request\":\"1adcce4a-e172-4868-a53f-2741a9157caf\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_BAD_REQUEST);

		ApiException exception = assertThrows(ApiException.class, () -> teamApi.createTeam(new Team()));
		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, ErrorResponse.class));
	}

	@Test
	void testCreateTeamInvalidContent() {
		String mockResponse = "{\"code\":\"InvalidContent\",\"message\":{\"error\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"request\":\"0283a417-e7c0-47f7-90c7-86036e47afa6\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_BAD_REQUEST);

		ApiException exception = assertThrows(ApiException.class, () -> teamApi.createTeam(new Team()));
		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, ErrorResponse.class));
	}

	@Test
	void testUpdateTeam() throws Exception {
		String mockResponse = "{\"id\":\"FFqPs1KHayxorfA~~xIj0us4\",\"timeCreated\":1455156655000,\"timeLastModified\":1455156656399,\"name\":\"Sunset\",\"workers\":[\"1LjhGUWdxFbvdsTAAXs0TFos\",\"F8WPCqGmQYWpCkQ2c8zJTCpW\",\"3joS0Jh19VpJZgSTxFOK9fTf\"],\"managers\":[\"Mrq7aKqzPFKX22pmjdLx*ohM\"],\"hub\":\"tKxSfU7psqDQEBVn5e2VQ~*O\"}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		Team team = new Team();
		team.setId("FFqPs1KHayxorfA~~xIj0us4");
		team.setWorkers(Arrays.asList("1LjhGUWdxFbvdsTAAXs0TFos", "F8WPCqGmQYWpCkQ2c8zJTCpW", "3joS0Jh19VpJZgSTxFOK9fTf"));

		Team updatedTeam = teamApi.updateTeam(team);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("/teams/FFqPs1KHayxorfA~~xIj0us4", request.getPath());
		assertEquals(HttpMethodType.PUT.name(), request.getMethod());
		Assertions.assertThat(updatedTeam).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, Team.class));
	}

	@Test
	void testUpdateTeamNotFound() {
		String mockResponse = "{\"code\":\"ResourceNotFound\",\"message\":{\"error\":1402,\"message\":\"The requested resource does not exist.\",\"request\":\"517e4611-44f0-40de-a0f9-c306884de7e0\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_BAD_REQUEST);

		ApiException exception = assertThrows(ApiException.class, () -> teamApi.createTeam(new Team()));
		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, ErrorResponse.class));
	}

	@Test
	void testUpdateTeamInvalidContents() {
		String mockResponse = "{\"code\":\"InvalidContent\",\"message\":{\"error\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"cause\":\"Invalid managers or workers for team\",\"request\":\"9e2a8dd7-9513-4a5c-b7f7-994796b3615b\"}}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_BAD_REQUEST);

		ApiException exception = assertThrows(ApiException.class, () -> teamApi.createTeam(new Team()));
		Assertions.assertThat(exception.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, ErrorResponse.class));
	}

	@Test
	void testListTeams() throws Exception {
		String mockResponse = "[{\"id\":\"yKpCnWprM1Rvp3NGGlVa5TMa\",\"timeCreated\":1455048584000,\"timeLastModified\":1455049756016,\"name\":\"FiDi\",\"workers\":[\"1LjhGUWdxFbvdsTAAXs0TFos\"],\"managers\":[\"Mrq7aKqzPFKX22pmjdLx*ohM\"],\"hub\":null,\"tasks\":[\"bKD0XoVZNFyBlE1rB~xvAdvp\"]},{\"id\":\"R4P7jhuzaIZ4cHHZE1ghmTtB\",\"timeCreated\":1455048567000,\"timeLastModified\":1455073711646,\"name\":\"Tenderloin\",\"workers\":[\"h*wSb*apKlDkUFnuLTtjPke7\",\"3joS0Jh19VpJZgSTxFOK9fTf\"],\"managers\":[\"9ZGGl3R~T7lXxZOuOkZwuaPf\"],\"hub\":\"E4s6bwGpOZp6pSU3Hz*2ngFA\",\"tasks\":[\"fYevkkuxafYOGNI0hGRwNm2t\"]}]";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		List<Team> teams = teamApi.listTeams();
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assertEquals(2, teams.size());
		assertEquals("yKpCnWprM1Rvp3NGGlVa5TMa", teams.get(0).getId());
		assertEquals("FiDi", teams.get(0).getName());
		assertEquals("R4P7jhuzaIZ4cHHZE1ghmTtB", teams.get(1).getId());
		assertEquals("Tenderloin", teams.get(1).getName());
	}

	@Test
	void testGetTeam() throws Exception {
		String mockResponse = "{\"id\":\"9dyuPqHt6kDK5JKHFhE0xihh\",\"timeCreated\":1455048578000,\"timeLastModified\":1455049756002,\"name\":\"Nob Hill\",\"workers\":[\"C**JneR4Jgd49ujNp7WsDE9Z\",\"1LjhGUWdxFbvdsTAAXs0TFos\"],\"managers\":[\"9ZGGl3R~T7lXxZOuOkZwuaPf\"],\"hub\":null,\"tasks\":[]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		Team team = teamApi.getTeam("9dyuPqHt6kDK5JKHFhE0xihh");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("/teams/9dyuPqHt6kDK5JKHFhE0xihh", request.getPath());
		Assertions.assertThat(team).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, Team.class));
	}

	@Test
	void testGetNonExistentTeam() {
		String mockJson = "{\"code\":\"ResourceNotFound\",\"message\":{\"error\":1402,\"message\":\"The requested resource does not exist.\",\"request\":\"3e9a508b-58dd-47ed-a821-7334edb2d243\"}}";
		enqueueMockResponse(mockJson, HttpURLConnection.HTTP_NOT_FOUND);

		ApiException exception = assertThrows(ApiException.class, () -> teamApi.getTeam("nonexistent"));

		assertEquals(HttpURLConnection.HTTP_NOT_FOUND, exception.getStatusCode());
		Assertions.assertThat(exception.getErrorResponse()).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockJson, ErrorResponse.class));
	}

	@Test
	void testDeleteTeam() throws Exception {
		enqueueMockResponse(HttpURLConnection.HTTP_OK);

		teamApi.deleteTeam("FFqPs1KHayxorfA~~xIj0us4");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.DELETE.name(), request.getMethod());
		assertEquals("/teams/FFqPs1KHayxorfA~~xIj0us4", request.getPath());
	}

	@Test
	void testGetDriverTimeEstimate() throws Exception {
		String mockResponse = "{\"workerId\":\"TNTOVPKcxDjX02MOCScKl2M5\",\"vehicle\":\"CAR\",\"steps\":[{\"location\":[-122.2514556,37.7577242],\"travelTime\":682,\"distance\":11117,\"serviceTime\":300,\"arrivalTime\":1614896529,\"completionTime\":1614896829},{\"location\":[-122.2442512,37.8097414],\"travelTime\":1144,\"distance\":7079,\"serviceTime\":300,\"arrivalTime\":1614897972,\"completionTime\":1614898272}]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		WorkerRoute driverTimeEstimate = teamApi.getDriverTimeEstimate("123",
				"dropoff", "122.2514556,37.7577242", 1600000000L,
				new VehicleType[]{VehicleType.CAR}, 600L);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assert request.getPath() != null;
		assertEquals("/teams/123/estimate?dropoffLocation=dropoff&pickupLocation=122.2514556,37.7577242&pickupTime=1600000000&restrictedVehiclesTypes=CAR&serviceTime=600",
				URLDecoder.decode(request.getPath(), StandardCharsets.UTF_8.name()));
		Assertions.assertThat(driverTimeEstimate).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, WorkerRoute.class));
	}

	@Test
	void testGetDriverTimeEstimateErrorMissingArgument() {
		assertThrows(IllegalArgumentException.class,
				() -> teamApi.getDriverTimeEstimate("123", "", "", null, null, null));
		assertThrows(IllegalArgumentException.class,
				() -> teamApi.getDriverTimeEstimate("123", null, null, null, null, null));
	}

	@Test
	void testGetUnassignedTasks() throws Exception {
		String mockResponse = "{\"tasks\":[{\"id\":\"3VtEMGudjwjjM60j7deSIY3j\",\"timeCreated\":1643317843000,\"timeLastModified\":1643413337768,\"organization\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"shortId\":\"c77ff497\",\"trackingURL\":\"https://onf.lt/c77ff497\",\"worker\":null,\"merchant\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"executor\":\"nYrkNP6jZMSKgBwG9qG7ci3J\",\"creator\":\"vjw*RDMKDljKVDve1Vtcplgu\",\"dependencies\":[],\"state\":0,\"completeAfter\":null,\"completeBefore\":null,\"pickupTask\":false,\"notes\":\"\",\"completionDetails\":{\"failureNotes\":\"\",\"failureReason\":\"NONE\",\"events\":[],\"actions\":[],\"time\":null,\"firstLocation\":[],\"lastLocation\":[],\"unavailableAttachments\":[]},\"feedback\":[],\"metadata\":[],\"overrides\":{},\"quantity\":0,\"additionalQuantities\":{\"quantityA\":0,\"quantityB\":0,\"quantityC\":0},\"serviceTime\":0,\"identity\":{\"failedScanCount\":0,\"checksum\":null},\"appearance\":{\"triangleColor\":null},\"scanOnlyRequiredBarcodes\":false,\"container\":{\"type\":\"TEAM\",\"team\":\"K3FXFtJj2FtaO2~H60evRrDc\"},\"trackingViewed\":false,\"recipients\":[],\"delayTime\":null,\"estimatedCompletionTime\":null,\"estimatedArrivalTime\":null,\"eta\":null,\"destination\":{\"id\":\"nk5xGuf1eQguYXg1*mIVl0Ut\",\"timeCreated\":1643317843000,\"timeLastModified\":1643317843121,\"location\":[-117.8764687,33.8078476],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"92806\",\"number\":\"2695\",\"street\":\"East Katella Avenue\",\"city\":\"Anaheim\",\"country\":\"United States\",\"name\":\"Honda Center\"},\"notes\":\"\",\"metadata\":[],\"googlePlaceId\":\"ChIJXyczhHXX3IARFVUqyhMqiqg\",\"warnings\":[]}}]}";
		enqueueMockResponse(mockResponse, HttpURLConnection.HTTP_OK);

		Tasks tasks = teamApi.getUnassignedTasks("teamId",
				true, 1600000000L, 1700000000L, "lastTask");
		List<Task> taskList = tasks.getTasks();

		assertEquals(1, taskList.size());
		RecordedRequest request = mockWebServer.takeRequest();
		assertEquals("/teams/teamId/tasks?isPickupTask=true&from=1600000000&to=1700000000&lastId=lastTask", request.getPath());
		Assertions.assertThat(tasks).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponse, Tasks.class));
	}
}
