package com.onfleet.api;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Field;

public class BaseApiTest {
	protected MockWebServer mockWebServer;
	protected OkHttpClient okHttpClient;

	@BeforeEach
	public void setUpBase() throws Exception {
		okHttpClient = new OkHttpClient();
		mockWebServer = new MockWebServer();
		mockWebServer.start();
	}

	@AfterEach
	public void tearDownBase() throws Exception {
		mockWebServer.shutdown();
	}

	protected void setBaseUrl(BaseApi api, String baseUrl) throws Exception {
		Field baseUrlField = api.getClass().getSuperclass().getDeclaredField("baseUrl");
		baseUrlField.setAccessible(true);
		baseUrlField.set(api, baseUrl);
	}

	protected void enqueueMockResponse(String jsonResponse, int responseCode) {
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(responseCode)
				.setBody(jsonResponse);
		mockWebServer.enqueue(mockResponse);
	}

	protected void enqueueMockResponse(int responseCode) {
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(responseCode);
		mockWebServer.enqueue(mockResponse);
	}


}
