package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.container.Container;
import com.onfleet.models.ErrorResponse;
import com.onfleet.models.container.ContainerType;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContainerApiTest extends BaseApiTest {
	private ContainerApi containerApi;

	@BeforeEach
	public void setup() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/containers");
		containerApi = new ContainerApi(okHttpClient);
		setBaseUrl(containerApi, baseUrl.toString());
	}

	@Test
	void testGetContainer() throws Exception {
		String mockResponseJson = "{\"id\":\"123\",\"name\":\"Container1\"}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Container container = containerApi.getContainer("123", ContainerType.WORKER);
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/containers/workers/123", recordedRequest.getPath());
		assertEquals("123", container.getId());
	}

	@Test
	void testGetContainerNotFoundId() {
		String mockResponseJson = "{\"code\":\"ResourceNotFound\",\"message\":{\"error\":1402,\"message\":\"The requested resource does not exist.\",\"cause\":\"Container does not exist.\",\"request\":\"baa7d4b6-fac5-424c-bb19-3a8216ed018e\",\"remoteAddress\":\"190.122.54.70\"}}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_NOT_FOUND);

		ApiException apiException = assertThrows(ApiException.class, () ->
				containerApi.getContainer("NonExistentId", ContainerType.WORKER));
		assertEquals(HttpURLConnection.HTTP_NOT_FOUND, apiException.getStatusCode());
		ErrorResponse expectedError = GsonSingleton.getInstance().fromJson(mockResponseJson, ErrorResponse.class);
		assertThat(apiException.getErrorResponse()).usingRecursiveComparison().isEqualTo(expectedError);
	}

	@Test
	void testGetContainerInvalidId() {
		String mockResponseJson = "{\"code\":\"InvalidContent\",\"message\":{\"error\":1000,\"message\":\"The values of one or more parameters are invalid.\",\"cause\":\"Invalid container identifier.\",\"request\":\"c2042f90-80b0-4404-81ea-9de20296846a\"}}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_BAD_REQUEST);

		ApiException apiException = assertThrows(ApiException.class, () ->
				containerApi.getContainer("InvalidId", ContainerType.WORKER));
		assertEquals(HttpURLConnection.HTTP_BAD_REQUEST, apiException.getStatusCode());
		ErrorResponse expectedError = GsonSingleton.getInstance().fromJson(mockResponseJson, ErrorResponse.class);
		assertThat(apiException.getErrorResponse()).usingRecursiveComparison().isEqualTo(expectedError);
	}

	@Test
	void testInsertTasks() throws Exception {
		String mockResponseJson = "{\"id\":\"123\",\"timeCreated\":1518563775000,\"timeLastModified\":1518563775468,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"type\":\"WORKER\",\"activeTask\":null,\"tasks\":[\"b3F~z2sU7H*auNKkM6LoiXzP\",\"1ry863mrjoQaqMNxnrD5YvxH\",\"VVLx5OdKvw0dRSjT2rGOc6Y*\",\"l33lg5WLrja3Tft*MO383Gub\",\"tsc4jFSETlXBIvi8XotH28Wt\"],\"worker\":\"2Fwp6wS5wLNjDn36r1LJPscA\"}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Container container = containerApi.insertTasks("123", 3, ContainerType.WORKER, Arrays.asList("id1", "id2", "id3"));
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.PUT.name(), recordedRequest.getMethod());
		assertEquals("{\"tasks\":[3,\"id1\",\"id2\",\"id3\"]}", recordedRequest.getBody().readUtf8());
		assertEquals("/containers/workers/123", recordedRequest.getPath());
		assertEquals("123", container.getId());
		assertThat(container).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Container.class));
	}

	@Test
	void testUpdateTasks() throws Exception {
		String mockResponseJson = "{\"id\":\"NngUFbKT95Hly0PkFwPui*kg\",\"timeCreated\":1518563775000,\"timeLastModified\":1518563775468,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"type\":\"WORKER\",\"activeTask\":null,\"tasks\":[\"b3F~z2sU7H*auNKkM6LoiXzP\",\"1ry863mrjoQaqMNxnrD5YvxH\",\"l33lg5WLrja3Tft*MO383Gub\"],\"worker\":\"2Fwp6wS5wLNjDn36r1LJPscA\"}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		List<String> taskIds = Arrays.asList("b3F~z2sU7H*auNKkM6LoiXzP", "1ry863mrjoQaqMNxnrD5YvxH", "l33lg5WLrja3Tft*MO383Gub");
		Container container = containerApi.updateTasks("123", taskIds, true);
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.PUT.name(), recordedRequest.getMethod());
		assertEquals("/containers/workers/123", recordedRequest.getPath());
		assertEquals("NngUFbKT95Hly0PkFwPui*kg", container.getId());
		assertThat(container).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Container.class));
	}

}
