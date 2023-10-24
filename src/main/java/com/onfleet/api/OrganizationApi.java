package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.organization.Delegatee;
import com.onfleet.models.organization.Organization;
import com.onfleet.utils.HttpMethodType;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class OrganizationApi extends BaseApi {

	public OrganizationApi(OkHttpClient client) {
		super(client, "/organization");
	}

	/**
	 * Retrieve details about the organization. This method allows you to obtain information about your organization.
	 * <a href="https://docs.onfleet.com/reference/get-details">Api Docs</a>
	 * @return An Organization object representing the details of your organization.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Organization getOrgDetails() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, Organization.class);
	}

	/**
	 * Retrieve details about a specific organization's delegatee by their ID.
	 * <a href="https://docs.onfleet.com/reference/get-delegatee-details">Api Docs</a>
	 * @param id The ID of the delegatee to retrieve.
	 * @return A Delegatee object representing the details of the delegatee.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Delegatee getDelegateeDetails(String id) throws ApiException {
		String url = String.format("%s/%s", baseUrl + "s", id);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Delegatee.class);
	}
}
