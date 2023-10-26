package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.models.webhook.Webhook;
import com.onfleet.models.webhook.WebhookCreateParams;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebhookApiTest extends BaseApiTest {

	private WebhookApi webhookApi;

	@BeforeEach
	void setUp() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/webhooks");
		webhookApi = new WebhookApi(okHttpClient);
		setBaseUrl(webhookApi, baseUrl.toString());
	}

	@Test
	void testListWebhooks() throws Exception {
		String mockResponseJson = "[{\"id\":\"ZnVRY8rdfUwNPjHQy2QthtxZ\",\"name\":\"Webhook 1 - Driver Nearby\",\"count\":7,\"url\":\"https://11ec4a02.ngrok.com/onfleet/driverNearby\",\"trigger\":2,\"isEnabled\":true},{\"id\":\"9zqMxI79mRcHpXE111nILiPn\",\"name\":\"Webhook 2 - TaskStarted\",\"count\":3,\"url\":\"https://11ec4a02.ngrok.com/onfleet/taskStart\",\"trigger\":0,\"isEnabled\":true},{\"id\":\"8KD3PcIMsG*bC0imJ~EjR9GX\",\"name\":\"Webhook 3 - TaskCompleted on Zapier\",\"count\":6,\"url\":\"https://hooks.zapier.com/hooks/catch/4212020/0z5pha/\",\"trigger\":3,\"isEnabled\":true}]";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		List<Webhook> webhooks = webhookApi.list();
		RecordedRequest recordedRequest = mockWebServer.takeRequest();

		assertEquals(3, webhooks.size());
		assertTrue(webhooks.get(2).getEnabled());
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/webhooks", recordedRequest.getPath());
		Assertions.assertThat(webhooks).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, new TypeToken<List<Webhook>>() {
		}.getType()));
	}

	@Test
	void testDeleteWebhook() throws Exception {
		enqueueMockResponse(HttpURLConnection.HTTP_OK);

		webhookApi.delete("webhookId");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.DELETE.name(), request.getMethod());
		assertEquals("/webhooks/webhookId", request.getPath());
	}

	@Test
	void testCreateWebhook() throws Exception {
		String mockResponseJson = "{\"id\":\"9zqMxI79mRcHpXE111nILiPn\",\"count\":0,\"url\":\"https://11ec4a02.ngrok.com/onfleet/taskStart\",\"trigger\":0}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Webhook webhook = webhookApi.create(new WebhookCreateParams("webhook", "https://11ec4a02.ngrok.com/onfleet/taskStart", 0, 0));
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/webhooks", request.getPath());
		Assertions.assertThat(webhook).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Webhook.class));
	}

	@Test
	void testCreateWebhookWithBuilder() throws Exception {
		String mockResponseJson = "{\"id\":\"9zqMxI79mRcHpXE111nILiPn\",\"count\":0,\"url\":\"https://11ec4a02.ngrok.com/onfleet/taskStart\",\"trigger\":0}";
		enqueueMockResponse(mockResponseJson, HttpURLConnection.HTTP_OK);

		Webhook webhook = webhookApi.create(
				new WebhookCreateParams.Builder()
						.setUrl("https://11ec4a02.ngrok.com/onfleet/taskStart")
						.setTrigger(3)
						.setThreshold(0)
						.setName("name")
						.build());
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals(HttpMethodType.POST.name(), request.getMethod());
		assertEquals("/webhooks", request.getPath());
		Assertions.assertThat(webhook).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Webhook.class));
	}

}
