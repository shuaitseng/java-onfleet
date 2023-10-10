package com.onfleet.api;

import com.onfleet.models.Container;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ContainerApiTest {
	private MockWebServer mockWebServer;
	private ContainerApi containerApi;

	@BeforeEach
	public void setup() throws Exception {
		mockWebServer = new MockWebServer();
		mockWebServer.start();
		HttpUrl baseUrl = mockWebServer.url("/containers/workers");
		OkHttpClient okHttpClient = new OkHttpClient();
		containerApi = new ContainerApi(okHttpClient);
		Field baseUrlField = BaseApi.class.getDeclaredField("baseUrl");
		baseUrlField.setAccessible(true);
		baseUrlField.set(containerApi, baseUrl.toString());
	}

	@Test
	void testGetContainer() throws Exception {
		String mockResponseJson = "{\"id\":\"123\",\"name\":\"Container1\"}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(200)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		Container container = containerApi.getContainer("123");
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/containers/workers/123", recordedRequest.getPath());
		assertEquals("123", container.getId());
	}

	@Test
	void testUpdateTasks() throws Exception {
		String mockResponseJson = "{\"id\":\"123\",\"name\":\"UpdatedContainer\"}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(200)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);

		String[] taskIds = new String[]{"task1", "task2"};
		Container container = containerApi.updateTasks("123", taskIds);

		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.PUT.name(), recordedRequest.getMethod());
		assertEquals("/containers/workers/123", recordedRequest.getPath());
		assertEquals("123", container.getId());
	}

	@AfterEach
	void tearDown() throws Exception {
		mockWebServer.shutdown();
	}
}