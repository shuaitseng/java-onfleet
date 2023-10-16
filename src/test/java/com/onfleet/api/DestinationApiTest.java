package com.onfleet.api;

import com.onfleet.models.Address;
import com.onfleet.models.Destination;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DestinationApiTest extends BaseApiTest {
	private DestinationApi destinationApi;

	@BeforeEach
	void setUp() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/destinations");
		destinationApi = new DestinationApi(okHttpClient);
		setBaseUrl(destinationApi, baseUrl.toString());
	}

	@Test
	void testCreateDestination() throws Exception {
		String mockResponseJson = "{\"id\":\"JLn6ZoYGZWn2wB2HaR9glsqB\",\"timeCreated\":1455156663000,\"timeLastModified\":1455156663896,\"location\":[-122.3965731,37.7875728],\"address\":{\"apartment\":\"5th Floor\",\"state\":\"California\",\"postalCode\":\"94105\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Howard Street\",\"number\":\"543\"},\"notes\":\"Don't forget to check out the epic rooftop.\",\"metadata\":[]}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Destination destination = new Destination.Builder()
				.setAddress(new Address.Builder()
						.setCity("city")
						.setCountry("country").build())
				.build();
		Destination createdDestination = destinationApi.createDestination(destination);

		RecordedRequest request = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/destinations", request.getPath());
		Assertions.assertThat(createdDestination).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Destination.class));
	}

	@Test
	void testGetDestination() throws Exception {
		String mockResponseJson = "{\"id\":\"456\",\"name\":\"Destination 2\"}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Destination destination = destinationApi.getDestination("456");

		RecordedRequest request = mockWebServer.takeRequest();
		assertEquals("GET", request.getMethod());
		assertEquals("/destinations/456", request.getPath());
		assertEquals("456", destination.getId());
	}
}