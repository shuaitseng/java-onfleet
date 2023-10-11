package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.ErrorResponse;
import com.onfleet.models.Organization;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class OrganizationApiTest extends BaseApiTest {
	private OrganizationApi organizationApi;

	@BeforeEach
	public void setup() throws Exception {
		HttpUrl baseUrl = mockWebServer.url("/organization");
		organizationApi = new OrganizationApi(okHttpClient);
		setBaseUrl(organizationApi, baseUrl.toString());
	}

	@Test
	void testGetDetails() throws Exception {
		String mockResponseJson = "{\"id\":\"yAM*fDkztrT3gUcz9mNDgNOL\",\"timeCreated\":1454634415000,\"timeLastModified\":1455048510514,\"name\":\"Onfleet Fine Eateries\",\"email\":\"fe@onfleet.com\",\"image\":\"5cc28fc91d7bc5846c6ce9c1\",\"timezone\":\"America/Los_Angeles\",\"country\":\"US\",\"delegatees\":[\"cBrUjKvQQgdRp~s1qvQNLpK*\"]}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_OK)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		Organization organization = organizationApi.getDetails();
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/organization", recordedRequest.getPath());
		assertEquals("yAM*fDkztrT3gUcz9mNDgNOL", organization.getId());
		Assertions.assertThat(organization).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Organization.class));
	}


	@Test
	void testGetDelegateeDetails() throws Exception {
		String mockResponseJson = "{\"id\":\"cBrUjKvQQgdRp~s1qvQNLpK*\",\"name\":\"Onfleet Engineering\",\"email\":\"dev@onfleet.com\",\"timezone\":\"America/Los_Angeles\",\"country\":\"US\"}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_OK)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		Organization organization = organizationApi.getDelegateeDetails("cBrUjKvQQgdRp~s1qvQNLpK*");
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/organizations/cBrUjKvQQgdRp~s1qvQNLpK*", recordedRequest.getPath());
		assertEquals("cBrUjKvQQgdRp~s1qvQNLpK*", organization.getId());
		Assertions.assertThat(organization).usingRecursiveComparison().isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, Organization.class));
	}

	@Test
	void testInvalidApiCredentials() throws Exception {
		String mockResponseJson = "{\"code\":\"InvalidCredentials\",\"message\":{\"error\":1103,\"message\":\"The resource requested is outside of the authenticated user's permissions scope.\",\"request\":\"5f045a51-4376-4296-8c78-8c450d9963f5\",\"remoteAddress\":\"190.122.54.70\"}}";
		MockResponse mockResponse = new MockResponse()
				.setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
				.setBody(mockResponseJson);
		mockWebServer.enqueue(mockResponse);
		ApiException apiException = assertThrows(ApiException.class, () -> organizationApi.getDelegateeDetails("cBrUjKvQQgdRp~s1qvQNLpK*"));
		RecordedRequest recordedRequest = mockWebServer.takeRequest();
		assertEquals(HttpMethodType.GET.name(), recordedRequest.getMethod());
		assertEquals("/organizations/cBrUjKvQQgdRp~s1qvQNLpK*", recordedRequest.getPath());
		Assertions.assertThat(apiException.getErrorResponse())
				.usingRecursiveComparison()
				.isEqualTo(GsonSingleton.getInstance().fromJson(mockResponseJson, ErrorResponse.class));
	}

	@AfterEach
	void tearDown() throws Exception {
		mockWebServer.shutdown();
	}
}