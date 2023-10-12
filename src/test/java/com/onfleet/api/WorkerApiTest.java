package com.onfleet.api;


import com.google.gson.reflect.TypeToken;
import com.onfleet.models.Vehicle;
import com.onfleet.models.VehicleType;
import com.onfleet.models.Worker;
import com.onfleet.utils.GsonSingleton;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		mockWebServer.enqueue(new MockResponse()
				.setResponseCode(200)
				.setBody(mockResponseJson));

		Worker worker = new Worker.Builder()
				.setId("sFtvhYK2l26zS0imptJJdC2q")
				.setName("A Swartz")
				.setPhone("617-342-8853")
				.setTeams(new String[]{"nz1nG1Hpx9EHjQCJsT2VAs~o"})
				.setVehicle(new Vehicle(VehicleType.CAR, "Tesla Model 3", "FKNS9A", "purple"))
				.build();
		Worker createdWorker = workerApi.createWorker(worker);
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("POST", request.getMethod());
		assertEquals("/workers", request.getPath());
		assertEquals("sFtvhYK2l26zS0imptJJdC2q", createdWorker.getId());
		Assertions.assertThat(createdWorker).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Worker.class));
	}

	@Test
	void testCreateWorkerWithErrorMissingArgument() {
		/*{
			"code": "InvalidArgument",
				"message": {
			"error": 1900,
					"message": "One or more parameters required for this request are either missing or have an invalid format.",
					"cause": "Team IDs array missing",
					"request": "bc41a8eb-a604-4a1c-aa5a-e86a975c141b"
		}
		}*/
	}

	@Test
	void testInvalidFormat() {
		/*{
			"code": "InvalidContent",
				"message": {
			"error": 1000,
					"message": "The values of one or more parameters are invalid.",
					"cause": "Invalid phone number format",
					"request": "fff8ed50-4ca0-4ff9-9230-b73096eb8502"
		}
		}*/
	}

	@Test
	void testDuplicatedPhone() {
		/*{
			"code": "InvalidContent",
				"message": {
			"error": 1000,
					"message": "The values of one or more parameters are invalid.",
					"cause": "Invalid phone number format",
					"request": "fff8ed50-4ca0-4ff9-9230-b73096eb8502"
		}
		}*/
	}

	private final String listWorkersJson = "[{\"id\":\"h*wSb*apKlDkUFnuLTtjPke7\",\"timeCreated\":1455049674000,\"timeLastModified\":1455156646529,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Andoni\",\"displayName\":\"Andoni\",\"phone\":\"+14155558442\",\"activeTask\":null,\"tasks\":[\"11z1BbsQUZFHD1XAd~emDDeK\"],\"onDuty\":true,\"timeLastSeen\":1455156644323,\"capacity\":0,\"userData\":{\"appVersion\":\"1.2.0\",\"batteryLevel\":0.99,\"deviceDescription\":\"Simulator (iOS 12.1.0)\",\"platform\":\"IOS\"},\"accountStatus\":\"ACCEPTED\",\"metadata\":[{\"name\":\"nickname\",\"type\":\"string\",\"value\":\"Puffy\",\"visibility\":[\"api\"]},{\"name\":\"otherDetails\",\"type\":\"object\",\"value\":{\"availability\":{\"mon\":\"10:00\",\"sat\":\"16:20\",\"wed\":\"13:30\"},\"premiumInsurance\":false,\"trunkSize\":9.5},\"visibility\":[\"api\"]}],\"imageUrl\":null,\"teams\":[\"R4P7jhuzaIZ4cHHZE1ghmTtB\"],\"delayTime\":null,\"location\":[-122.4015496466794,37.77629837661284],\"vehicle\":null},{\"id\":\"1LjhGUWdxFbvdsTAAXs0TFos\",\"timeCreated\":1455049755000,\"timeLastModified\":1455072352267,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"name\":\"Yevgeny\",\"displayName\":\"YV\",\"phone\":\"+14155552299\",\"activeTask\":null,\"tasks\":[\"*0tnJcly~vSI~9uHz*ICHXTw\",\"PauBfRH8gQCjtMLaPe97G8Jf\"],\"onDuty\":true,\"timeLastSeen\":1455156649007,\"capacity\":0,\"userData\":{\"appVersion\":\"1.2.0\",\"batteryLevel\":0.97,\"deviceDescription\":\"Galaxy S8\",\"platform\":\"Android\"},\"accountStatus\":\"ACCEPTED\",\"metadata\":[],\"location\":[-122.4016366,37.7764098],\"imageUrl\":null,\"teams\":[\"9dyuPqHt6kDK5JKHFhE0xihh\",\"yKpCnWprM1Rvp3NGGlVa5TMa\",\"fwflFNVvrK~4t0m5hKFIxBUl\"],\"delayTime\":null,\"vehicle\":{\"id\":\"ArBoHNxS4B76AiBKoIawY9OS\",\"type\":\"CAR\",\"description\":\"Lada Niva\",\"licensePlate\":\"23KJ129\",\"color\":\"Red\",\"timeLastModified\":1545086815176}}]";

	@Test
	void testListWorkers() throws Exception {
		// Set up a mock response
		String mockResponseJson = listWorkersJson;
		mockWebServer.enqueue(new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_OK)
				.setBody(mockResponseJson));

		// Call the method to be tested
		List<Worker> workers = workerApi.listWorkers(
				Arrays.asList("name", "phone"),
				Arrays.asList("team1", "team2"),
				Arrays.asList(1, 2, 3),
				Arrays.asList("1234567890", "9876543210"),
				true
		);

		// Verify the request and response
		RecordedRequest request = mockWebServer.takeRequest();
		assertEquals("GET", request.getMethod());
		assertEquals("/workers?fields=name,phone&teamsIds=team1,team2&states=1,2,3&phoneNumbers=1234567890,9876543210&includePasswordDetails=true",
				URLDecoder.decode(request.getPath(), StandardCharsets.UTF_8.name()));
		assertEquals(2, workers.size());
		assertEquals("h*wSb*apKlDkUFnuLTtjPke7", workers.get(0).getId());
		assertEquals("1LjhGUWdxFbvdsTAAXs0TFos", workers.get(1).getId());
		Assertions.assertThat(workers).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, new TypeToken<List<Worker>>() {
		}.getType()));
	}

}