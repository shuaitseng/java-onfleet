package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Administrator;
import com.onfleet.models.ErrorResponse;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AdministratorApiTest extends BaseApiTest {
	private AdministratorApi administratorApi;

	@BeforeEach
	void setUp() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/admins");
		administratorApi = new AdministratorApi(okHttpClient);
		setBaseUrl(administratorApi, baseUrl.toString());
	}

	@Test
	void testCreateAdmin() throws Exception {
		String mockResponseJson = "{\"id\": \"8AxaiKwMd~np7I*YP2NfukBE\", \"timeCreated\": 1455156651000, \"timeLastModified\": 1455156651779, \"organization\": \"yAM*fDkztrT3gUcz9mNDgNOL\", \"email\": \"cm@onf.lt\", \"type\": \"standard\", \"name\": \"Chelsea M\", \"isActive\": false, \"metadata\": [],\"isAccountOwner\": false, \"teams\": []}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_OK)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		Administrator administrator = new Administrator("name", "cm@onf.lt", "8885551234", true, Administrator.Type.SUPER);
		Administrator admin = administratorApi.createAdministrator(administrator);
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.POST.name(), recordedRequest.getMethod());
		assertEquals("/admins", recordedRequest.getPath());
		assertEquals("8AxaiKwMd~np7I*YP2NfukBE", admin.getId());
	}

	@Test
	void testCreateAdminDuplicatedEmail() throws Exception {
		String mockResponseJson = "{\"code\":\"InvalidContent\",\"message\":{\"error\":1004,\"message\":\"The values of one or more parameters break a uniqueness constraint.\",\"cause\":{\"type\":\"duplicateKey\",\"key\":\"unknown\",\"value\":\"unknown\"},\"request\":\"fbf5580f-d4bd-458b-950d-f7dd057afcc8\"}}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		Administrator administrator = new Administrator("name", "cm@onf.lt", "8885551234", true, Administrator.Type.SUPER);
		ApiException apiException = assertThrows(ApiException.class, () -> administratorApi.createAdministrator(administrator));
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.POST.name(), recordedRequest.getMethod());
		assertEquals("/admins", recordedRequest.getPath());
		Assertions.assertThat(apiException.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, ErrorResponse.class));
	}

	@Test
	void testListAdmins() throws Exception {
		String mockResponseJson = "[{\"id\":\"tbVmEoNQwN9K92bsITQNUtWY\",\"timeCreated\":1455048957000,\"timeLastModified\":1455048957461,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"email\":\"st@onfleet.com\",\"type\":\"super\",\"name\":\"Sergey Tupolev\",\"isActive\":true,\"isReadOnly\":false,\"phone\":\"+16505557710\",\"teams\":[\"Q4Ay4XaJ77rvYtrxQ2WJmqh~\"],\"metadata\":[]},{\"id\":\"jBOlwJTkN0JzfE9Rj5vEL~UT\",\"timeCreated\":1455048990000,\"timeLastModified\":1455048990578,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"email\":\"is@onfleet.com\",\"type\":\"standard\",\"name\":\"Iñaki Smith\",\"isActive\":false,\"isReadOnly\":false,\"phone\":\"+14155556327\",\"teams\":[],\"metadata\":[]},{\"id\":\"8AxaiKwMd~np7I*YP2NfukBE\",\"timeCreated\":1455156651000,\"timeLastModified\":1455156651779,\"organization\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"email\":\"cm@onf.lt\",\"type\":\"standard\",\"name\":\"Chelsea M\",\"isActive\":false,\"isReadOnly\":true,\"teams\":[\"Q4Ay4XaJ77rvYtrxQ2WJmqh~\",\"JDu~fDkztr*6fUcz9mNDgNOL\"],\"metadata\":[]}]";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_OK)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		List<Administrator> admins = administratorApi.listAdministrators();
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/admins", recordedRequest.getPath());
		Assertions.assertThat(admins)
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, new TypeToken<List<Administrator>>() {
				}.getType()));
	}

	@Test
	void testUpdateAdmin() {
		String mockResponseJson = "{\"id\": \"8AxaiKwMd~np7I*YP2NfukBE\", \"timeCreated\": 1455156651000, \"timeLastModified\": 1455156651779, \"organization\": \"yAM*fDkztrT3gUcz9mNDgNOL\", \"email\": \"cm@onf.lt\", \"type\": \"standard\", \"name\": \"Chelsea M\", \"isActive\": false, \"metadata\": [],\"isAccountOwner\": false, \"teams\": []}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_OK)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);

	}

	@Test
	void testUpdateInvalidAdminId() {

	}

	@Test
	void testUpdateAdminIdNonExistent() {

	}

	@Test
	void testDeleteAdmin() {

	}

	@Test
	void testInvalidApiKey() throws Exception {
		String mockResponseJson = "{\"code\":\"InvalidCredentials\",\"message\":{\"error\":1102,\"message\":\"The API key provided is invalid.\",\"cause\":\"The API key provided is not valid. Please contact support@onfleet.com for further assistance.\",\"request\":\"be5bd42f-6c60-4d0b-85aa-97a611f945f2\"}}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		ApiException apiException = assertThrows(ApiException.class, () -> administratorApi.listAdministrators());
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/admins", recordedRequest.getPath());
		Assertions.assertThat(apiException.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, ErrorResponse.class));
	}

}