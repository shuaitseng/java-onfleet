package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.models.Address;
import com.onfleet.models.Hub;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HubApiTest extends BaseApiTest {
	private HubApi hubApi;

	@BeforeEach
	public void setup() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/hubs");
		hubApi = new HubApi(okHttpClient);
		setBaseUrl(hubApi, baseUrl.toString());
	}

	@Test
	void testCreateHub() throws Exception {
		String mockResponseJson = "{\"id\":\"i4FoP*dTVrdnGqvIVvvA69aB\",\"name\":\"VIP customer\",\"location\":[-117.8767457,33.8079071],\"address\":{\"number\":\"2695\",\"street\":\"East Katella Avenue\",\"city\":\"Anaheim\",\"county\":\"Orange County\",\"state\":\"California\",\"country\":\"United States\",\"postalCode\":\"92806\",\"apartment\":\"\",\"name\":\"VIP customer\"},\"teams\":[\"kq5MFBzYNWhp1rumJEfGUTqS\"]}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Hub hub = getHub();
		Hub hubResponse = hubApi.createHub(hub);
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), recordedRequest.getMethod());
		assertEquals("/hubs", recordedRequest.getPath());
		Assertions.assertThat(hubResponse).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Hub.class));
	}

	@Test
	void testUpdateHub() throws Exception {
		String mockResponseJson = "{\"id\":\"i4FoP*dTVrdnGqvIVvvA69aB\",\"name\":\"VIP customer Hub\",\"location\":[-118.2673597,34.0430058],\"address\":{\"number\":\"1111\",\"street\":\"South Figueroa Street\",\"city\":\"Los Angeles\",\"county\":\"Los Angeles County\",\"state\":\"California\",\"country\":\"United States\",\"postalCode\":\"90015\",\"name\":\"VIP customer\",\"apartment\":\"\"},\"teams\":[\"kq5MFBzYNWhp1rumJEfGUTqS\"]}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Hub hub = getHub();
		hub.setId("i4FoP*dTVrdnGqvIVvvA69aB");
		Hub hubResponse = hubApi.updateHub(hub);
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.PUT.name(), recordedRequest.getMethod());
		assertEquals("/hubs/i4FoP*dTVrdnGqvIVvvA69aB", recordedRequest.getPath());
		Assertions.assertThat(hubResponse).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Hub.class));
	}

	@Test
	void testListHubs() throws Exception {
		String mockResponseJson = "[{\"id\":\"E4s6bwGpOZp6pSU3Hz*2ngFA\",\"name\":\"SF North\",\"location\":[-122.44002499999999,37.801826],\"address\":{\"number\":\"3415\",\"street\":\"Pierce Street\",\"city\":\"San Francisco\",\"state\":\"California\",\"country\":\"United States\",\"postalCode\":\"94123\",\"apartment\":\"\"},\"teams\":[\"W*8bF5jY11Rk05E0bXBHiGg2\"]},{\"id\":\"tKxSfU7psqDQEBVn5e2VQ~*O\",\"name\":\"SF South\",\"location\":[-122.44337999999999,37.70883],\"address\":{\"number\":\"335\",\"street\":\"Hanover Street\",\"city\":\"San Francisco\",\"state\":\"California\",\"country\":\"United States\",\"postalCode\":\"94112\",\"apartment\":\"\"},\"teams\":[\"W*8bF5jY11Rk05E0bXBHiGg2\"]}]";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		List<Hub> hubs = hubApi.listHubs();
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/hubs", recordedRequest.getPath());
		Assertions.assertThat(hubs).usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, new TypeToken<List<Hub>>() {
				}.getType()));
	}

	private Address getAddress() {
		return new Address.Builder()
				.setNumber("1315")
				.setStreet("Obispo Trejo")
				.setCity("Cordoba")
				.setCountry("Argentina")
				.build();
	}

	private Hub getHub() {
		return new Hub("VIP customer", getAddress(), Collections.singletonList("kq5MFBzYNWhp1rumJEfGUTqS"));
	}
}
