package com.qa.ecs.regression;

import com.qa.ecs.api.ecsAPIs;
import com.qa.ecs.base.BaseTest;
import com.qa.ecs.utils.AssertionUtil;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.JacksonUtils;

import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test(description = "Verify Search Functionality for Invalid Consumer")
	public void TC001_validateSearchFunctionalityForInvalidConsumer() {

		String firstName = "Test" + new CommonUtil().getCurrentDateTime();

		String expectedSearchMessage = "No results found.";

		String actualSearchMessage = loginPage.doLogin().enterFirstName(firstName).clickOnSearchButton()
				.getSearchMessage();

		AssertionUtil.verifyEqual(actualSearchMessage, expectedSearchMessage,
				"Verification Invalid Consumer should not be display on Search Consumer Page");

	}

	@Test
	public void createConsumerAPI() {
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateConsumer createConsumerRequestPayload = JacksonUtils
				.deserializeJson("ConsumerCreation.json", com.qa.ecs.pojo.request.CreateConsumer.class);
		createConsumerRequestPayload.getPartyPerson().setTin(tinNumber);
		createConsumerRequestPayload.getPartyPerson().setFirstName("RConsumer013");
		com.qa.ecs.pojo.response.CreateConsumer createConsumerResponsePayload = ecsAPIs.createConsumerAPI(baseUrl,createConsumerRequestPayload);

	}

	
	@Test
	public void createOrgAPI() {

		com.qa.ecs.pojo.response.CreateOrganization createOrganizationResponsePayload = ecsAPIs.createOrganizationAPI(baseUrl);

	}

	
	@Test
	public void createOrgAPIByName() {
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateOrganization createOrganizationRequestPayload = JacksonUtils
				.deserializeJson("OrganizationCreation.json", com.qa.ecs.pojo.request.CreateOrganization.class);
		createOrganizationRequestPayload.getPartyOrg().setTin(tinNumber);
		createOrganizationRequestPayload.getPartyOrg().setName("NOrg012");
		//createOrganizationRequestPayload.getAddresses().get(0)
		com.qa.ecs.pojo.response.CreateOrganization createOrganizationResponsePayload = ecsAPIs
				.createOrganizationAPI(baseUrl, createOrganizationRequestPayload);
	}
	
	
	@Test
	public void addAccount() {
		ecsAPIs.addDDAAccountToConsumerAPI(baseUrl, "NahianSav30808", "NahianSav3Lastt0808");
	}
	
	
	@Test
	public void addMPAccount() {
		ecsAPIs.addMultiPositionAccountToConsumerAPI(baseUrl, "Nahian1", "Test1");
	}
	
	@Test
	public void addAccounts() {
		ecsAPIs.addDDAAccountToConsumerAPI(baseUrl, "5NahianSav30808", "Test2");
		ecsAPIs.addMultiPositionAccountToConsumerAPI(baseUrl, "5NahianSav30808", "Test2");
	}
	
	@Test
	public void addAccountsWithFunds() {
		ecsAPIs.addDDAAccountToConsumerAPI(baseUrl, "7NahianSav30808", "Test7",2000);
	}
	
	@Test
	public void addMPAccountWithFunds() {
		ecsAPIs.addMultiPositionAccountToConsumerAPI(baseUrl, "8NahianSav30808", "Test8",3000);
	}
	
	
	@Test
	public void addLoanAccountToConsumerAPITest() {
		ecsAPIs.addLoanAccountToConsumerAPI(baseUrl, "14NahianSav30808", "Test11", 600);
	}
	
}
