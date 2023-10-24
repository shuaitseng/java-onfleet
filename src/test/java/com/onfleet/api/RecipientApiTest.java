package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.models.Metadata;
import com.onfleet.models.MetadataVisibility;
import com.onfleet.models.recipient.Recipient;
import com.onfleet.models.recipient.RecipientCreateParams;
import com.onfleet.models.recipient.RecipientUpdateParams;
import com.onfleet.utils.GsonSingleton;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RecipientApiTest extends BaseApiTest {
	private RecipientApi recipientApi;

	@BeforeEach
	public void setup() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/recipients");
		recipientApi = new RecipientApi(okHttpClient);
		setBaseUrl(recipientApi, baseUrl.toString());
	}

	@Test
	void testGetSingleRecipient() throws Exception {
		String json = "{\"id\":\"VVLx5OdKvw0dRSjT2rGOc6Y*\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156665000,\"timeLastModified\":1455156665741,\"name\":\"Neiman Runtilly\",\"phone\":\"+16505551133\",\"notes\":\"Always orders our GSC special\",\"skipSMSNotifications\":false,\"metadata\":[]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Recipient recipient = recipientApi.getSingleRecipient("VVLx5OdKvw0dRSjT2rGOc6Y*");

		assertNotNull(recipient);
		assertThat(recipient).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Recipient.class));
	}

	@Test
	void testFindRecipientByName() throws Exception {
		String json = "{\"id\":\"VVLx5OdKvw0dRSjT2rGOc6Y*\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156665000,\"timeLastModified\":1455156665741,\"name\":\"Neiman Runtilly\",\"phone\":\"+16505551133\",\"notes\":\"Always orders our GSC special\",\"skipSMSNotifications\":false,\"metadata\":[]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Recipient recipient = recipientApi.findRecipientByName("neiman runtilly");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("/recipients/name/neiman%20runtilly", request.getPath());
		assertThat(recipient).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Recipient.class));
	}

	@Test
	void testFindRecipientByPhone() throws Exception {
		String json = "{\"id\":\"7tuqrtwo75UlcJFCzDk7Clfk\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455142309000,\"timeLastModified\":1455142309695,\"name\":\"Neiman Runtilly\",\"phone\":\"+16503201133\",\"notes\":\"Always orders our GSC special\",\"skipSMSNotifications\":false,\"metadata\":[]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		Recipient recipient = recipientApi.findRecipientByPhone("123-444-5555");
		RecordedRequest request = mockWebServer.takeRequest();

		assertEquals("/recipients/phone/123-444-5555", request.getPath());
		assertThat(recipient).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Recipient.class));
	}

	@Test
	void testCreateRecipient() throws Exception {
		String json = "{\"id\":\"VVLx5OdKvw0dRSjT2rGOc6Y*\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156665000,\"timeLastModified\":1455156665390,\"name\":\"Boris Foster\",\"phone\":\"+16505551133\",\"notes\":\"Always orders our GSC special\",\"skipSMSNotifications\":false,\"metadata\":[]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		RecipientCreateParams params = new RecipientCreateParams.Builder("name", "phone")
				.setNotes("notes")
				.setSkipPhoneNumberValidation(false)
				.setSkipSmsNotifications(false)
				.setUseLongCodeForText(false)
				.setMetadata(Collections.singletonList(new Metadata.Builder().setName("isHighNetWorth")
						.setType("boolean")
						.setValue("false")
						.setMetadataVisibility(Collections.singletonList(MetadataVisibility.DASHBOARD)).build()))
				.build();
		Recipient recipient = recipientApi.createRecipient(params);

		assertThat(recipient).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Recipient.class));
	}

	@Test
	void testUpdateRecipient() throws Exception {
		String json = "{\"id\":\"VVLx5OdKvw0dRSjT2rGOc6Y*\",\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1455156665000,\"timeLastModified\":1455156665741,\"name\":\"Neiman Runtilly\",\"phone\":\"+16505551133\",\"notes\":\"Always orders our GSC special\",\"skipSMSNotifications\":false,\"metadata\":[]}";
		enqueueMockResponse(json, HttpURLConnection.HTTP_OK);

		RecipientUpdateParams updateParams = new RecipientUpdateParams.Builder()
				.setName("new name").build();
		Recipient recipient = recipientApi.updateRecipient("recipientId", updateParams);

		assertThat(recipient).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(json, Recipient.class));
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

		List<Recipient> recipients = recipientApi.queryWithMetadata(metadataList);

		assertThat(recipients).usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(json, new TypeToken<List<Recipient>>() {
				}.getType()));
	}

}
