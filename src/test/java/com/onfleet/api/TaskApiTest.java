package com.onfleet.api;

import com.onfleet.models.Address;
import com.onfleet.models.Destination;
import com.onfleet.models.Recipient;
import com.onfleet.models.Task;
import com.onfleet.utils.GsonSingleton;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
		mockWebServer.enqueue(new MockResponse()
				.setBody(json)
				.setResponseCode(HttpURLConnection.HTTP_OK));
		Task task = new Task();
		Destination destination = new Destination();
		destination.setNotes("Small green door by garage door has pin pad, enter *4821*");
		destination.setAddress(new Address.Builder().setUnparsed("2829 Vallejo St, SF, CA, USA").build());
		task.setDestination(destination);

		List<Recipient> recipientList = new ArrayList<>();
		Recipient recipient = new Recipient("Blas Silkovich", "650-555-4481", "Knows Neiman, VIP status.", null, null, null);
		recipientList.add(recipient);
		task.setRecipients(recipientList);
		task.setCompleteAfter(1455151071727L);
		task.setNotes("Order 332: 24oz Stumptown Finca El Puente, 10 x Aji de Gallina Empanadas, 13-inch Lelenitas Tres Leches");
		Task response = taskApi.createTask(task);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Task.class));
	}

}