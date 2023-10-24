package com.onfleet;

import com.onfleet.api.AdministratorApi;
import com.onfleet.api.ContainerApi;
import com.onfleet.api.DestinationApi;
import com.onfleet.api.HubApi;
import com.onfleet.api.OrganizationApi;
import com.onfleet.api.RecipientApi;
import com.onfleet.api.TaskApi;
import com.onfleet.api.TeamApi;
import com.onfleet.api.WebhookApi;
import com.onfleet.api.WorkerApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class OnFleetTest {
	private OnFleet onFleet;

	@BeforeEach
	void setUp() {
		onFleet = new OnFleet("mocked_api_key");
	}

	@Test
	void testOrganizationApi() {
		OrganizationApi organizationApi = onFleet.getOrganizationApi();
		assertBaseUrlEndsWith(organizationApi, "organization");
	}

	@Test
	void testAdministratorApi() {
		AdministratorApi administratorApi = onFleet.getAdministratorApi();
		assertBaseUrlEndsWith(administratorApi, "admins");
	}

	@Test
	void testWorkerApi() {
		WorkerApi workerApi = onFleet.getWorkerApi();
		assertBaseUrlEndsWith(workerApi, "workers");
	}

	@Test
	void testHubApi() {
		HubApi hubApi = onFleet.getHubApi();
		assertBaseUrlEndsWith(hubApi, "hubs");
	}

	@Test
	void testTeamApi() {
		TeamApi teamApi = onFleet.getTeamApi();
		assertBaseUrlEndsWith(teamApi, "teams");
	}

	@Test
	void testDestinationApi() {
		DestinationApi destinationApi = onFleet.getDestinationApi();
		assertBaseUrlEndsWith(destinationApi, "destinations");
	}

	@Test
	void testRecipientApi() {
		RecipientApi recipientApi = onFleet.getRecipientApi();
		assertBaseUrlEndsWith(recipientApi, "recipients");
	}

	@Test
	void testTaskApi() {
		TaskApi taskApi = onFleet.getTaskApi();
		assertBaseUrlEndsWith(taskApi, "tasks");
	}

	@Test
	void testContainerApi() {
		ContainerApi containerApi = onFleet.getContainerApi();
		assertBaseUrlEndsWith(containerApi, "containers");
	}

	@Test
	void testWebhookApi() {
		WebhookApi webhookApi = onFleet.getWebhookApi();
		assertBaseUrlEndsWith(webhookApi, "webhooks");
	}

	private void assertBaseUrlEndsWith(Object apiObject, String expectedSuffix) {
		try {
			Field baseUrlField = apiObject.getClass().getSuperclass().getDeclaredField("baseUrl");
			baseUrlField.setAccessible(true);
			String baseUrl = (String) baseUrlField.get(apiObject);

			assertTrue(baseUrl.endsWith(expectedSuffix));
		} catch (Exception e) {
			fail("Failed to access the baseUrl property: " + e.getMessage());
		}
	}
}