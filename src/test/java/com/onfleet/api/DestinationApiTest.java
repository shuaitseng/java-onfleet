package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.models.Metadata;
import com.onfleet.models.MetadataVisibility;
import com.onfleet.models.destination.Address;
import com.onfleet.models.destination.Destination;
import com.onfleet.models.destination.DestinationCreateParams;
import com.onfleet.models.destination.DestinationOptions;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

		Address address = new Address.Builder()
				.setCountry("Argentina")
				.setNumber("123")
				.setState("Cordoba")
				.setCity("Cordoba")
				.setName("Address 1")
				.setStreet("Olmos")
				.setPostalCode("5000")
				.build();
		DestinationCreateParams destination = new DestinationCreateParams.Builder(address)
				.setNotes("notes")
				.setLocation(Arrays.asList(1.0,2.0))
				.setMetadata(Collections.singletonList(new Metadata.Builder().build()))
				.setOptions(new DestinationOptions("english"))
				.build();
		Destination createdDestination = destinationApi.createDestination(destination);

		RecordedRequest request = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/destinations", request.getPath());
		Assertions.assertThat(createdDestination).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Destination.class));
	}

	@Test
	void testGetDestination() throws Exception {
		String mockResponseJson = "{\"id\":\"RR0SUIculbRFsIse6MENg\",\"timeCreated\":1455156664000,\"timeLastModified\":1455156664697,\"location\":[-122.4052935,37.7721234],\"address\":{\"apartment\":\"\",\"state\":\"California\",\"postalCode\":\"94103\",\"country\":\"United States\",\"city\":\"San Francisco\",\"street\":\"Brannan Street\",\"number\":\"888\"},\"notes\":\"\",\"metadata\":[]}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Destination destination = destinationApi.getDestination("RR0SUIculbRFsIse6MENg");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), request.getMethod());
		assertEquals("/destinations/RR0SUIculbRFsIse6MENg", request.getPath());
		assertEquals("RR0SUIculbRFsIse6MENg", destination.getId());
		Assertions.assertThat(destination)
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Destination.class));
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

		List<Destination> destinations = destinationApi.queryWithMetadata(metadataList);

		assertThat(destinations).usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(json, new TypeToken<List<Destination>>() {
				}.getType()));
	}
}