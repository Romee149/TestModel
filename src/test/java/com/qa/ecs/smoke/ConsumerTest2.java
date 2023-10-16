package com.qa.ecs.smoke;

import org.testng.annotations.Test;

import com.qa.ecs.api.ecsAPIs;
import com.qa.ecs.apiUtils.APIDataManager;
import com.qa.ecs.apiUtils.JsonDataManager;
import com.qa.ecs.base.BaseTest;
import com.qa.ecs.utils.AssertionUtil;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ImageUtil;
import com.qa.ecs.utils.JacksonUtils;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.Test;

public class ConsumerTest2 extends BaseTest {

	String currentDate = new CommonUtil().getCurrentDateTime("MM/dd/yyyy");

	@Test(description = "Verify Newly created Consumer in Search Consumer Page with flow verification")
	public void ECS001_ECS007_ECS008_ECS009_validateNewlyCreatedConsumerOnSearchPage() {

		String expectedMessage1 = "Would you like to add documents for this customer?";
		String expectedMessage2 = "Would you like to add an account for this customer?";

		// ******** Consumer Creation Data **********//
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateConsumer consumerData = JacksonUtils.deserializeJson("ConsumerCreation.json",
				com.qa.ecs.pojo.request.CreateConsumer.class);
		String firstName = "Auto" + tinNumber;
		String lastName = "Test";
		consumerData.getPartyPerson().setFirstName(firstName);
		consumerData.getPartyPerson().setLastName(lastName);
		consumerData.getPartyPerson().setTin(tinNumber);

		// ******** Consumer Creation Action **********//

		customerInformation = loginPage.doLogin().clickOnTaskButton().clickOnAddNewConsumerLink()
				.enterDataOnBasicInformationPage(consumerData).clickOnNextButton()
				.enterDataOnLocationInformationPage(consumerData).enterDataOnContactInformationPage(consumerData)
				.clickOnNextButton(consumerData).clickOnNextButton().clickOnCreateButton();

		String noDocForCustomerMessage1 = customerInformation.getAddDocumentsForCustomerMessageOnPopup();

		String noDocForCustomerMessage2 = customerInformation.clickOnNoButtonOnPopup().wait(4)
				.getAddDocumentsForCustomerMessageOnPopup();

		// ******** Consumer Message Validation **********//
		AssertionUtil.verifyEqual(noDocForCustomerMessage1, expectedMessage1,
				"ECS008 : Verification of PopUp Message \'" + expectedMessage1 + "\'");
		AssertionUtil.verifyEqual(noDocForCustomerMessage2, expectedMessage2,
				"ECS008 : Verification of PopUp Message \'" + expectedMessage2 + "\'");

		customerDetail = customerInformation.clickOnNoPleaseTakeMeToCustomerProfilePageLinkOnPopup();

		String activeTabName = customerDetail.getActivateTabName();

		AssertionUtil.verifyEqual(activeTabName, "Customer Overview",
				"ECS009 : Verification of Overview Tab as default selected Tab on Customer Detail Page");

		customerSearchPage = customerDetail.getCommonWidget().clickOnSearchIcon().enterFirstName(firstName).wait(2)
				.clickOnSearchButton().wait(2);

		String searchedFirstName = customerSearchPage.getValueFromSearchResultTable("First Name", "1");
		String searchedLastName = customerSearchPage.getValueFromSearchResultTable("Last Name", "1");

		// ******** Consumer Creation Validation **********//
		AssertionUtil.verifyEqual(searchedFirstName, firstName,
				"ECS001 & ECS007 : Verification of Newly created Consumer By First Name in Search Consumer Page");
		AssertionUtil.verifyEqual(searchedLastName, lastName,
				"ECS001 & ECS007 : Verification of Newly created Consumer By Last Name in Search Consumer Page");

	}

	@Test(description = "Verify Search Functionality for Invalid Consumer")
	public void ECS002_validateSearchFunctionalityForInvalidConsumer() {

		String firstName = "Test" + new CommonUtil().getCurrentDateTime();

		String expectedSearchMessage = "No results found.";

		String actualSearchMessage = loginPage.doLogin().enterFirstName(firstName).clickOnSearchButton()
				.getSearchMessage();

		AssertionUtil.verifyEqual(actualSearchMessage, expectedSearchMessage,
				"ECS002 : Verification Invalid Consumer should not be display on Search Consumer Page");

	}

	@Test(description = "Verify Newly created Organization in Search Consumer Page")
	public void ECS003_validateNewlyCreatedOrganization() {

		// ******** Organization Creation Data **********//
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateOrganization orgData = JacksonUtils.deserializeJson("OrganizationCreation.json",
				com.qa.ecs.pojo.request.CreateOrganization.class);
		String orgName = "Org" + tinNumber;
		orgData.getPartyOrg().setName(orgName);
		orgData.getPartyOrg().setTin(tinNumber);

		// ******** Organization Creation Action **********//
		customerSearchPage = loginPage.doLogin().clickOnTaskButton().createOrganization(orgData).getCommonWidget()
				.clickOnSearchIcon().wait(10).clickOnConsumerSearch().clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(orgName).wait(2).clickOnSearchButton();

		String searchedOrgName = customerSearchPage.getValueFromSearchResultTable("Name", "1");

		// ******** Organization Creation Validation **********//
		AssertionUtil.verifyEqual(searchedOrgName, orgName,
				"ECS003 : Verification of Newly created Organization in Search Consumer Page");

	}

	@Test(description = "Verify Search Functionality for Invalid Organization")
	public void ECS004_validateSearchFunctionalityForInvalidOrganization() {

		String orgName = "TestOrg" + new CommonUtil().getCurrentDateTime();

		String expectedSearchMessage = "No results found.";

		String actualSearchMessage = loginPage.doLogin().clickOnConsumerSearch()
				.clickOnConsumerSearchOption("Organization").enterOrganizationName(orgName).clickOnSearchButton()
				.getSearchMessage();

		AssertionUtil.verifyEqual(actualSearchMessage, expectedSearchMessage,
				"ECS004 : Verification Invalid Organization should not be display on Search Organization Page");

	}

	@Test(description = "Verify Newly created Banking Acount Number, created date for Consumer in Account detail Page")
	public void ECS005_ECS014_ECS015_validateNewlyCreatedBankingAccountAndNotification() {

		String firstName = "FirstNameECS051415";
		String lastName = "LastNameECS";

		String expectedType = "accountCreate";

		if (ecsAPIs.getCustomerIDByFindCustomerAPI(baseUrl, firstName, lastName) == null) {
			expectedType = "welcomeOnlineP-DDA";
		}

		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);

		String expectedAccountOpenDate = new CommonUtil().getCurrentDateTime("MM/dd/yyyy");

		String expectedGenerationStatus = "Inprocess";

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");

		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount().clickOnNextButton()
				.selectAccountRelationshipType("Primary").enterDescription("Test for automation").clickOnNextButton()
				.selectAccountGroup("Banking").selectProductType("Interest Checking (C2001 - DDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		customerDetail = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().enterAgreementCode("01", 1).enterVersion("1", 1).wait(1).clickOnSubmitButton()
				.wait(1);

		accountDetailTabScreen = customerDetail.clickOnSearchMagnifierIcon().clickOnConsumerSearch()
				.clickOnConsumerSearchOption("Account").wait(1).enterAccountNumberForSearch(accountNumber)
				.clickOnAccountSearchButton();

		String actualAccountNumber = accountDetailTabScreen.getAccountNumber();
		String actualOpenDate = accountDetailTabScreen.getAccountOpenDate();

		AssertionUtil.verifyEqual(actualAccountNumber, accountNumber,
				"ECS005 and ECS014: Verification of newly created account number : " + accountNumber
						+ " on Account Detail Page is successful.");
		AssertionUtil.verifyEqual(actualOpenDate, expectedAccountOpenDate,
				"ECS015: Verification of newly created account open date: " + actualOpenDate
						+ " on Account Detail Page is successful.");
		customerSearchPage = accountDetailTabScreen.clickOnSearchMagnifierIcon();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");
		customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Notifications");
		String actualDate = customerDetail.getValueFromResultTable("DATE", 1);
		String actualType = customerDetail.getValueFromResultTable("TYPE", 1);
		System.out.println(actualType);
		String actualGenerationStatus = customerDetail.getValueFromResultTable("GENERATION STATUS", 1);
		AssertionUtil.verifyEqual(actualDate, expectedAccountOpenDate,
				"ECS015: Verification of date of creation account under notifications " + expectedAccountOpenDate
						+ " is successful");
		AssertionUtil.verifyEqual(actualType.trim(), expectedType,
				"ECS015: Verification of type under notifications " + expectedType + " is successful");
		// *********Showing Error or Success in Sav3*******//
		AssertionUtil.verifyEqual(actualGenerationStatus, expectedGenerationStatus,
				"ECS015: Verification of Generation Status under notifications " + expectedGenerationStatus
						+ " is successful");

	}

	@Test(description = "Verify message for account search that doesn't exist")
	public void ECS006_verifyMessageForInvalidAccountSearch() {

		String accountNumber = new CommonUtil().getCurrentDateTime("ddMMyyHHmmss");

		String expectedMessage = "No matching account record found.";
		customerSearchPage = loginPage.doLogin().clickOnConsumerSearch().clickOnConsumerSearchOption("Account")
				.enterAccountNumberForSearch(accountNumber).clickOnSearchButton();
		String actualMessage = customerSearchPage.getSearchMessage();
		AssertionUtil.verifyEqual(actualMessage, expectedMessage,
				"ECS006: Verification of message for invalid account: " + accountNumber
						+ " in Search Consumer Page is succesful");

	}

	@Test(description = "Verify Newly created multi position Acount Number, ProductType And Popup Success Message for Consumer having last name 'Test' in Customer Detail Page")
	public void ECS010_ECS011_ECS012_ECS013_validateNewlyCreatedMultipositionAccountNumberProductTypeAndPopupSuccessMsg() {
		String tinNumber = new CommonUtil().getSSN();
		String firstName = "ECS"+tinNumber;
		String lastName = "AutoLN10111213";

		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);

		String firstProductType = "Personal Savings (P2011 - SDA)";
		String secondProductType = "Interest Checking (C2001 - DDA)";
		String thirdProductType = "6 Month Compounding-Personal (P3006 - CDA)";

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");

		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount().clickOnNextButton()
				.selectAccountRelationshipType("Primary").enterDescription("Test for automation").clickOnNextButton()
				.selectAccountGroup("Multi-Position").selectProductType(firstProductType, 1);

		String accountNumber = positionDetails.getAccountNumber();
		System.out.println(accountNumber);

		String postionInfo1 = positionDetails.getPositionInfo(1);
		AssertionUtil.verifyEqual(postionInfo1, "Position 1",
				"ECS010: Verification of First position info: " + postionInfo1 + " is successful.");

		positionDetails.selectDepartmentId("350 - Deposits", 1).selectVertical("Vertical 01", 1);

		positionDetails.clickOnAddAdditionalPositionLink();

		String postionInfo2 = positionDetails.getPositionInfo(2);
		AssertionUtil.verifyEqual(postionInfo2, "Position 2",
				"ECS010: Verification of Second position info: " + postionInfo2 + " is successful.");

		positionDetails.selectProductType(secondProductType, 2).selectDepartmentId("350 - Deposits", 2)
				.selectVertical("Vertical 01", 2);

		positionDetails.clickOnAddAdditionalPositionLink();
		String postionInfo3 = positionDetails.getPositionInfo(3);

		AssertionUtil.verifyEqual(postionInfo3, "Position 3",
				"ECS011: Verification of third position info: " + postionInfo3 + " is successful.");

		positionDetails.selectProductType(thirdProductType, 3).selectDepartmentId("350 - Deposits", 3)
				.selectVertical("Vertical 01", 3);

		electAcceptanceDoc = positionDetails.clickOnNextButton().wait(5);
		int numberOfAgreementCodeText = electAcceptanceDoc.getCountForText("Agreement Code");
		for (int i = 1; i <= numberOfAgreementCodeText; i++) {
			/// *****For Sav3 there are no input textbox for Agreement Code and Version
			/// Code********//
			if (electAcceptanceDoc.isAgreementCodeAndVersionCodeInputTextBoxExist(i) == true) {
				electAcceptanceDoc.enterAgreementCode("EC01" + i + "", i).enterVersion("01", i);
			}
		}

		int numberOfDocumentType = electAcceptanceDoc.getCountForText("Document Type");

		int numberOfSelectAgreementCodeVersionDropDown = electAcceptanceDoc.countOfSelectAgreementCodeVersionDropDown();

		if (numberOfSelectAgreementCodeVersionDropDown >= 1) {
			for (int j = 1; j <= numberOfSelectAgreementCodeVersionDropDown; j++) {
				electAcceptanceDoc.selectAgreementCodePlusVersionType("EC01-1", j);
			}
		}

		electAcceptanceDoc.clickOnAddAdditionalDocumentLink(3).wait(4);
		int numberOfDocumentTypeAfterAddDoc = electAcceptanceDoc.getCountForText("Document Type");
		// **********for Sav3 has only two option for
		// selectAgreementCodePlusVersionType: 'EC01-1' and 'T001-1'*******/
		//****for QA has only one option 'EC001-1' then change to '1-1' now '1234-2'
		electAcceptanceDoc.selectAgreementCodePlusVersionType(1, numberOfSelectAgreementCodeVersionDropDown + 1);
		electAcceptanceDoc.enterSignedByCode("AT", numberOfDocumentTypeAfterAddDoc);
		AssertionUtil.verifyGreaterThan(numberOfDocumentTypeAfterAddDoc, numberOfDocumentType,
				"ECS012: Verification of Add Additional Document section is displayed successfully");
		electAcceptanceDoc.clickOnSubmitButton().wait(5);

		customerDetail.clickOnAccountsLink();
		String actualAccountNumber = customerDetail.getAccountNumberFromCustomerDetailPage();

		AssertionUtil.verifyEqual(actualAccountNumber, accountNumber, "ECS013: Verification of account number: "
				+ actualAccountNumber + " from Customer detail page after multiposition account created is successful");

		String expectedFirstMultiPositionAccountNumber = actualAccountNumber + "01";
		String expectedSecondMultiPositionAccountNumber = actualAccountNumber + "02";
		String expectedThirdMultiPositionAccountNumber = actualAccountNumber + "03";

		customerDetail.clickOnLastDoubleDownIcon();
		String actualFirstMultiPositionAccountNumber = customerDetail.getMultiPositionAccountNumber(1);

		String actualSecondMultiPositionAccountNumber = customerDetail.getMultiPositionAccountNumber(2);

		String actualThirdMultiPositionAccountNumber = customerDetail.getMultiPositionAccountNumber(3);

		String actualFirstProductType = customerDetail.getMultiPositionProductType(1);
		String actualSeconfProductType = customerDetail.getMultiPositionProductType(2);
		String actualThirdProductType = customerDetail.getMultiPositionProductType(3);

		AssertionUtil.verifyEqual(actualFirstMultiPositionAccountNumber, expectedFirstMultiPositionAccountNumber,
				"ECS013: Verification of First Account number" + actualFirstMultiPositionAccountNumber
						+ " for Multi Position Account is successful");
		AssertionUtil.verifyEqual(actualSecondMultiPositionAccountNumber, expectedSecondMultiPositionAccountNumber,
				"ECS013: Verification of Second Account number" + actualSecondMultiPositionAccountNumber
						+ " for Multi Position Account is successful");
		AssertionUtil.verifyEqual(actualThirdMultiPositionAccountNumber, expectedThirdMultiPositionAccountNumber,
				"ECS013: Verification of Third Account number " + actualThirdMultiPositionAccountNumber
						+ " for Multi Position Account is successful");

		AssertionUtil.verifyEqual(actualFirstProductType, "Personal Savings",
				"ECS013: Verification of first product type " + actualFirstProductType + "is successful");
		AssertionUtil.verifyEqual(actualSeconfProductType, "Interest Checking",
				"ECS013: Verification of second product type " + actualSeconfProductType + "is successful");
		AssertionUtil.verifyEqual(actualThirdProductType, "6 Month Compounding-Personal",
				"ECS013: Verification of third product type " + actualThirdProductType + "is successful");
	}

	@Test(description = "Verify add account related party text IsDisplayed, case number, case type, case status"
			+ "and Add Account Related Party name, Relationship Type and Added Date")
	public void ECS016_ECS017_ECS018_validateAddRelatedPartyCaseClosed() {

		String firstName = "FNTest18";
		String lastName = "LNTest18";
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);

		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateOrganization orgData = JacksonUtils.deserializeJson("OrganizationCreation.json",
				com.qa.ecs.pojo.request.CreateOrganization.class);

		String organizationName = "TestOrg";

		customerSearchPage = loginPage.doLogin();
		customerSearchPage.clickOnSearchTypeDownArrow("Search Consumer").clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(organizationName).clickOnSearchButton();

		if (customerSearchPage.getSearchMessage().contains("No results")) {
			orgData.getPartyOrg().setName(organizationName);
			orgData.getPartyOrg().setTin(tinNumber);
			ecsAPIs.createOrganizationAPI(baseUrl, orgData);
		}
		com.qa.ecs.pojo.response.AddDDAAccount accountData = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl, firstName,
				lastName);

		String accountNumber = accountData.getAcctPartyRels().get(0).getAcctNbr();

		accountDetailTabScreen = customerSearchPage.clickOnSearchTypeDownArrow("Search Organization")
				.clickOnConsumerSearchOption("Account").wait(1).enterAccountNumberForSearch(accountNumber)
				.clickOnAccountSearchButton();

		customerDetail = accountDetailTabScreen.switchToCustomerDetailPage();
		commonWidget = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink().wait(10);

		AssertionUtil.verifyEqual(commonWidget.isDisplayedTaskList("Add Account Related Party"), true,
				"ECS016: Verification of 'Add Account Related Party Link' is displayed successfully");

		commonWidget.clickOnTaskLinkText("Add Account Related Party");

		boolean result = customerDetail.isDisplayedPanelTitle("Add Account Related Party");
		AssertionUtil.verifyEqual(result, true,
				"ECS016: Verification of 'Add Account Related Party Title' is displayed successfully");
		customerDetail.selectAccountRelationshipType("Power of Attorney").clickOnOrganizationRadioBtn()
				.enterOrganizationNameForSearchForAddAccountsRelatedParty(organizationName).clickOnOrgSearchButton();
		String actualResult = customerDetail.getTextFromSearchResultDropDown(organizationName);
		AssertionUtil.verifyContainsText(actualResult, organizationName, "ECS017: Verification of " + organizationName
				+ " is displayed in search result for add organization for add account related party is successful");

		customerDetail.selectSearchResultDropDown(organizationName).clickOnButton("Add").clickOnButton("Submit");
		String popUpMessage = customerDetail.getPopUpMessage(10);
		String expectedCaseNumber = popUpMessage.split(":")[1].trim();
		String expectedCaseType = "Add Account Related Party";
		String expectedStatus = "Closed";

		accountDetailTabScreen = customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
				.switchToAccountDetailTabScreen();

		String textFromCaseOpenTab = accountDetailTabScreen.getTextFromCaseOpenTab();
		if (textFromCaseOpenTab.contains("1")) {
			accountDetailTabScreen.clickOnLink(expectedCaseNumber).wait(10).switchToWindow(1).wait(1);
			accountDetailTabScreen.selectClosingDispositionOption("Completed").wait(1)
					// .mouseHoverStandardActionsAndClickOnSave() // was present this option on
					// 08/14/2023
					// .wait(10)
					.clickOnCloseWindow().wait(1).switchToWindow(0);
		}
		accountDetailTabScreen.clickOnRefreshIcon().wait(5).clickOnOverViewDisplayedTextLink("Closed Cases").wait(2);
		String actualCaseNumber = accountDetailTabScreen.getValueFromResultTable("CASE NUMBER", 1);
		String actualCaseType = accountDetailTabScreen.getValueFromResultTable("CASE TYPE", 1);
		String actualStatus = accountDetailTabScreen.getValueFromResultTable("STATUS", 1);

		AssertionUtil.verifyEqual(actualCaseNumber, expectedCaseNumber,
				"ECS018: Verification of case number " + actualCaseNumber + " is successful");
		AssertionUtil.verifyEqual(actualCaseType, expectedCaseType,
				"ECS018: Verification of case type " + actualCaseType + " is successful");
		AssertionUtil.verifyEqual(actualStatus, expectedStatus,
				"ECS018: Verification of status " + actualStatus + " is successful");
		customerDetail = accountDetailTabScreen.switchToCustomerDetailPage();
		customerDetail.clickOnOverViewDisplayedTextLink("Details");
		String expectedPartyName = organizationName;
		String expectedRelationshipType = "Power of attorney";
		String expectedDateAdded = new CommonUtil().getCurrentDateTime("MM/dd/yyyy");

		customerDetail.scrollPageDown().wait(4).scrollPageDown().wait(5);

		String actualPartyName = customerDetail.getValueFromResultTableWithExpandableRows("PARTY NAME", 3);
		String actualRelationshipType = customerDetail.getValueFromResultTableWithExpandableRows("RELATIONSHIP TYPE",
				3);
		String actualDateAdded = customerDetail.getValueFromResultTableWithExpandableRows("DATE ADDED", 3);
		AssertionUtil.verifyEqual(actualPartyName, expectedPartyName,
				"ECS018: Verification of Add Acount Related Party Name " + actualPartyName + " is successful");
		AssertionUtil.verifyEqual(actualRelationshipType, expectedRelationshipType,
				"ECS018: Verification of Relationship type " + actualRelationshipType + " is successful");
		AssertionUtil.verifyEqual(actualDateAdded, expectedDateAdded,
				"ECS018: Verification of added date for add account related party: " + actualDateAdded
						+ " is successful");
	}

	@Test(description = "Verification Beneficiary block after create an account with ownership Revocable Trust")
	public void ECS019_ECS020_ECS021_ECS022_validateBeneficiary() {

		String firstName = "FirstNameECS";
		String lastName = "LastNameECS";

		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");

		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount().clickOnNextButton()
				.selectAccountOwnership("20 - Revocable Trust").selectAccountRelationshipType("Primary")
				.enterDescription("Test for automation").clickOnNextButton().selectAccountGroup("Banking")
				.selectProductType("Personal Savings (P2001 - SDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		electAcceptanceDoc = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().wait(5);

		if (electAcceptanceDoc.isAgreementCodeAndVersionCodeInputTextBoxExist(1) == true) {
			electAcceptanceDoc.enterAgreementCode("ECS10" + 1 + "", 1).enterVersion("01", 1);
		}
		if (electAcceptanceDoc.isSelectAgreementCodeVersionDropDownExist() == true) {

			electAcceptanceDoc.selectAgreementCodePlusVersionType("EC01-1", 1);
		}

		customerDetail = electAcceptanceDoc.clickOnSubmitButton().wait(5).refreshPage();

		customerDetail.clickOnOverViewTabDisplayedAccountNumberLink(accountNumber)
				.clickOnOverViewDisplayedTextLink("Details").wait(2);
		accountDetailTabScreen = customerDetail.switchToAccountDetailTabScreen().scrollPageDown().wait(4)
				.scrollPageDown().wait(4).clickOnPlusIconForAddBeneficiary().wait(10);

		boolean result1 = accountDetailTabScreen.isDisplayedPanelTitle("Add Beneficiary");
		AssertionUtil.verifyEqual(result1, true,
				"ECS019: Verification of 'Add Beneficiary Title' is displayed successfully");

		accountDetailTabScreen.enterBeneficiaryFirstName("Auto").enterBeneficiaryLastName("Test").clickOnButton("Add");
		boolean result2 = accountDetailTabScreen.isDisplayedPanelTitle("Modify Beneficiaries");
		AssertionUtil.verifyEqual(result2, true,
				"ECS020: Verification of 'Modify Beneficiaries Title' is displayed successfully");

		accountDetailTabScreen.enterBeneficiaryPercentage("100").clickOnButton("Submit");
		String expectedPopupMessageForBeneficiary = "Account beneficiaries successfully modified.";
		String actualPopUpMessageForBeneficiary = accountDetailTabScreen.getPopUpMessage(20);

		AssertionUtil.verifyEqual(actualPopUpMessageForBeneficiary, expectedPopupMessageForBeneficiary,
				"ECS021: Verification of Popup Success Message: " + actualPopUpMessageForBeneficiary
						+ " is displayed successfully.");

		String partyName = accountDetailTabScreen.getValueFromBeneficiariesTable("PARTY NAME", 1);
		String relationshipType = accountDetailTabScreen.getValueFromBeneficiariesTable("RELATIONSHIP TYPE", 1);
		String percentage = accountDetailTabScreen.getValueFromBeneficiariesTable("PERCENTAGE", 1);
		String dateAdded = accountDetailTabScreen.getValueFromBeneficiariesTable("DATE ADDED", 1);

		AssertionUtil.verifyEqual(partyName, "Auto Test",
				"ECS022: Verification of Beneficiary Party Name " + partyName + " is successful");
		AssertionUtil.verifyEqual(relationshipType, "Beneficiary",
				"ECS022: Verification of Relationship type " + relationshipType + " is successful");
		AssertionUtil.verifyEqual(dateAdded, currentDate,
				"ECS022: Verification of added date for add account related party: " + dateAdded + " is successful");
		AssertionUtil.verifyEqual(percentage, "100.00%",
				"ECS022: Verification of added date for add account related party: " + percentage + " is successful");
	}

	@Test(description = "Verify of Post Transaction for Personal Saving Account With Credited Amount")
	public void ECS023_validateCreditPostTransactionForPersonalSavingAccount() {

		int timeout = 10;
		String consumerFirstName = "Test023";
		String consumerLastName = "AutoLN";
		String amount = "500.00";
		String transactionCode = "Savings Deposit Cash";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().postTransaction(transactionCode, amount, timeout).wait(timeout);

		AssertionUtil.verifyEqual(accountDetailTabScreen.getAvailableAccountBalance(), amount,
				"ECS023 : Verification of Account Balance when Post Transaction with Savings Deposit Cash for Personal Saving Account ");

		AssertionUtil.verifyEqual(accountDetailTabScreen.getValueFromTransactionsTable("Credit", 1), amount,
				"ECS023 : Verification of Credit Transaction when Post Transaction with Savings Deposit Cash for Personal Saving Account ");

		AssertionUtil.verifyEqual(accountDetailTabScreen.getValueFromTransactionsTable("ending balance", 1), amount,
				"ECS023 : Verification of Ending Balance Transaction when Post Transaction with Savings Deposit Cash for Personal Saving Account ");

	}

	
	
			
	
	
	
	
	
	
	
	
	
	
	@Test(description = "Verify of Post Transaction for Personal Saving Account With Debited Amount")
	public void ECS024_validateDebitPostTransactionForPersonalSavingAccount() {

		int timeout = 20;
		int initialAccountBalance = 1200;
		String consumerFirstName = "Test024";
		String consumerLastName = "AutoLN";
		String debitAmount = "400.00";
		String expectedEndingBalance = "800.00";
		String transactionCode = "Savings Miscellaneous Debit";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().postTransaction(transactionCode, debitAmount, timeout).wait(10);

		AssertionUtil.verifyEqual(accountDetailTabScreen.getAvailableAccountBalance(), expectedEndingBalance,
				"ECS024 : Verification of Account Balance when Post Transaction with Savings Miscellaneous Debit for Single Account");

		AssertionUtil.verifyEqual(accountDetailTabScreen.getValueFromTransactionsTable("Debit", 1), debitAmount,
				"ECS024 : Verification of Debit Transaction when Post Transaction with Savings Miscellaneous Debit for Single Account ");

		String actualEndingBalance = accountDetailTabScreen.getValueFromTransactionsTable("ending balance", 1);

		AssertionUtil.verifyEqual(actualEndingBalance, expectedEndingBalance,
				"ECS024 : Verification of Ending Balance Transaction when Post Transaction with Savings Miscellaneous Debit for Single Account ");

	}

	@Test(description = "Verify of Post Transaction for Multi Position Account With Credited Amount")
	public void ECS025_validateCreditPostTransactionForMultiPositionAccount() {

		int timeout = 20;
		String tinNumber = new CommonUtil().getSSN();
		String consumerFirstName = "Test"+tinNumber;
		String consumerLastName = "AutoLN025";
		String amount = "2,200.00";
		String transactionCode = "Savings Deposit Cash";

		com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse = ecsAPIs
				.addMultiPositionAccountToConsumerAPI(baseUrl, consumerFirstName, consumerLastName);

		String accountNumber = APIDataManager.getAccountNumber(addMultiPositionAccountResponse) + "01";

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().postTransaction(transactionCode, amount, timeout).wait(10);

		AssertionUtil.verifyEqual(accountDetailTabScreen.getAvailableAccountBalance(), amount,
				"ECS025 : Verification of Account Balance when Post Transaction with Savings Deposit Cash for MultiPosition Account ");

		AssertionUtil.verifyEqual(accountDetailTabScreen.getValueFromTransactionsTable("Credit", 1), amount,
				"ECS025 : Verification of Credit Transaction when Post Transaction with Savings Deposit Cash for MultiPosition Account ");

		AssertionUtil.verifyEqual(accountDetailTabScreen.getValueFromTransactionsTable("ending balance", 1), amount,
				"ECS025 : Verification of Ending Balance Transaction when Post Transaction with Savings Deposit Cash for MultiPosition Account ");

	}

	@Test(description = "Verify of Post Transaction for Multi Position Account With Debited Amount")
	public void ECS026_validateDebitPostTransactionForMultiPositionAccount() {

		int timeout = 20;
		int initialAccountBalance = 2400;
		String tinNumber = new CommonUtil().getSSN();
		String consumerFirstName = "Test"+tinNumber;
		String consumerLastName = "AutoLN026";
		String debitAmount = "1,000.00";
		String expectedEndingBalance = "1,400.00";
		String transactionCode = "Savings Miscellaneous Debit";

		com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse = ecsAPIs
				.addMultiPositionAccountToConsumerAPI(baseUrl, consumerFirstName, consumerLastName,
						initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addMultiPositionAccountResponse) + "01";

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().postTransaction(transactionCode, debitAmount, timeout).wait(10);

		AssertionUtil.verifyEqual(accountDetailTabScreen.getAvailableAccountBalance(), expectedEndingBalance,
				"ECS026 : Verification of Account Balance when Post Transaction with Savings Miscellaneous Debit for MultiPosition Account");

		AssertionUtil.verifyEqual(accountDetailTabScreen.getValueFromTransactionsTable("Debit", 1), debitAmount,
				"ECS026 : Verification of Debit Transaction when Post Transaction with Savings Miscellaneous Debit for MultiPosition Account ");

		String actualEndingBalance = accountDetailTabScreen.getValueFromTransactionsTable("ending balance", 1);

		AssertionUtil.verifyEqual(actualEndingBalance, expectedEndingBalance,
				"ECS026 : Verification of Ending Balance Transaction when Post Transaction with Savings Miscellaneous Debit for MultiPosition Account ");

	}

	@Test(description = "Verify of T-Account for Personal Saving Account With Credited Amount")
	public void ECS027_validateT_Account() {

		int timeout = 8;
		int accountBalance = 1000;
		String expectedCreditBalance = "1,000.00";
		String consumerFirstName = "ECS027";
		String consumerLastName = "AutoLN027";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, accountBalance);

		String accountNumber = addDDAAccountResponse.getAcctPartyRels().get(0).getAcctNbr();

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", consumerFirstName)
				.enterSearchTextForSearch("LastName", consumerLastName).clickOnSearchButton();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");

		accountDetailTabScreen = customerDetail.clickOnText(accountNumber).switchToCustomerDetailPage()
				.switchToAccountDetailTabScreen();

		accountDetailTabScreen.clickOnDoubleDownArrowIcon().wait(timeout).clickOnSingleDownArrowIcon("T-Account")
				.wait(timeout);
		String tAccountTableText = accountDetailTabScreen.getValueFromTable("TAC", 1, 2);
		String actualCreditAmountFromTAC = accountDetailTabScreen.getValueFromTable("TAC", 1, 4);
		AssertionUtil.verifyEqual(tAccountTableText, "Credit",
				"ECS027 : Verification of T-Account table Text: 'Credit' for Single Account with credit balance "
						+ accountBalance + " is successful.");
		AssertionUtil.verifyEqual(actualCreditAmountFromTAC, expectedCreditBalance,
				"ECS027 : Verification of T-Account table for Credit amount:" + actualCreditAmountFromTAC
						+ " for Single Account with credit balance " + accountBalance + " is successful.");

	}

	@Test(description = "Verify Add Holds Transaction for Personal Saving Account")
	public void ECS028_ECS029_validateAddHoldsTransactionForPersonalSavingAccount() {

		int timeout = 20;
		int initialAccountBalance = 2000;
		String consumerFirstName = "Test2829";
		String consumerLastName = "AutoLN";
		String expectedAvailableBalance = "1,980.00";
		String holdAmount = "20.00";
		String expectedDuration = "Five Business Days";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().addHold(expectedDuration, holdAmount, timeout).wait(10);

		String actualHoldTypeValue = accountDetailTabScreen.getValueFromTable("Holds", "hold Type", 1);
		String actualInitialDurationValue = accountDetailTabScreen.getValueFromTable("Holds", "Initial duration", 1);
		String actualAmountValue = accountDetailTabScreen.getValueFromTable("Holds", "Amount", 1);
		String actualAccountBalance = accountDetailTabScreen.getAvailableAccountBalance();
		String actualCurrentHoldsAmount = accountDetailTabScreen.getCurrentHoldsAmount();
		String actualClearingAmount = accountDetailTabScreen.clickOnCurrentHoldsExpandButton().wait(timeout)
				.getCurrentHoldsClearingAmount();

		AssertionUtil.verifyEqual(actualAccountBalance, expectedAvailableBalance,
				"ECS028 : Verification of Ending Account Balance After Add Hold Transaction");

		AssertionUtil.verifyEqual(actualCurrentHoldsAmount, holdAmount,
				"ECS028 : Verification of Current Hold Amount After Add Hold Transaction");

		AssertionUtil.verifyEqual(actualClearingAmount, holdAmount,
				"ECS028 : Verification of Current Hold Clearing Amount After Add Hold Transaction");

		AssertionUtil.verifyEqual(actualHoldTypeValue, "Clearing",
				"ECS029 : Verification of Hold Type value available under Holds table");

		AssertionUtil.verifyEqual(actualInitialDurationValue, expectedDuration,
				"ECS029 : Verification of Initial Duration value available under Holds table");

		AssertionUtil.verifyEqual(actualAmountValue, holdAmount,
				"ECS029 : Verification of Amount value available under Holds table");

	}

	@Test(description = "Verify of Add hold for Personal Saving Account With Credited Amount")
	public void ECS030_ECS031_validateAddHoldInOverViewTabAndHoldTab() {

		String startDate = new CommonUtil().getDateTime(1, "MM/dd/yyyy hh:mm:ss a");
		int timeout = 10;
		int accountBalance = 1000;
		String holdAmount = "200.00";
		String consumerFirstName = "ECS03031";
		String consumerLastName = "AutoLN";

		String expectedAvailableBalance = "1,000.00";
		String expectedHoldType = "PreAuth";
		String expectedDuration = "Three Business Days";
		String expectedStartDate = new CommonUtil().getDateTime(1, "MM/dd/yyyy");
		String expectedEndDate = new CommonUtil().getDateTime(5, "MM/dd/yyyy");
		String expectedCurrentHolds = "0.00";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, accountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().addHold(expectedHoldType, startDate, expectedDuration, holdAmount, timeout);

		String holdCreatedMessage = accountDetailTabScreen.getPopUpMessage(timeout);
		AssertionUtil.verifyContainsText(holdCreatedMessage, "Hold created.",
				"ECS030 : Verification of Hold created popup message: '" + holdCreatedMessage + "' is successful.");
		accountDetailTabScreen.wait(timeout);

		// ******From Hold Table in Overview section after hold created
		String actualHoldTypeValue = accountDetailTabScreen.getValueFromTable("Holds", "Hold Type", 1);
		String actualStartDate = accountDetailTabScreen.getValueFromTable("Holds", "Start Date", 1);
		String actualEndDate = accountDetailTabScreen.getValueFromTable("Holds", "End Date", 1);
		String actualInitialDurationValue = accountDetailTabScreen.getValueFromTable("Holds", "Initial Duration", 1);
		String actualAmountValue = accountDetailTabScreen.getValueFromTable("Holds", "Amount", 1);

		AssertionUtil.verifyEqual(actualHoldTypeValue, expectedHoldType,
				"ECS030 : Verification of Hold Type value available under Holds table in Overview tab section");
		AssertionUtil.verifyEqual(actualInitialDurationValue, expectedDuration,
				"ECS030 : Verification of Initial Duration value available under Holds table in Overview tab section");
		AssertionUtil.verifyEqual(actualAmountValue, holdAmount,
				"ECS030 : Verification of Amount value available under Holds table in Overview tab section");
		AssertionUtil.verifyEqual(actualStartDate, expectedStartDate, "ECS030 : Verification of Start date: "
				+ actualStartDate + " under Holds table in Overview tab section");
		AssertionUtil.verifyEqual(actualEndDate, expectedEndDate,
				"ECS030 : Verification of End date: " + actualEndDate + " under Holds table in Overview tab section");

		// ***From Balance Summary Section after hold created

		String actualLedgerBalance = accountDetailTabScreen.getLedgerBalance();
		String actualCurrentHoldsAmount = accountDetailTabScreen.getCurrentHoldsAmount();
		String actualFutureHoldsAmount = accountDetailTabScreen.getFutureHoldsAmount();
		String actualAccountBalance = accountDetailTabScreen.getAvailableAccountBalance();
		String actualFutreHoldsPreAuthAmount = accountDetailTabScreen
				.clickOnExpandBtnFromBalanceSummarySection("FutureHold").wait(timeout).getFutreHoldsPreAuthAmount();

		AssertionUtil.verifyEqual(actualCurrentHoldsAmount, expectedCurrentHolds,
				"ECS031 : Verification of Current Hold Amount: " + expectedCurrentHolds
						+ " After Add Hold Transaction is successful");
		AssertionUtil.verifyEqual(actualLedgerBalance, expectedAvailableBalance,
				"ECS031 : Verification of actual Ledger Balance: " + actualLedgerBalance
						+ " After Add Hold Transaction");
		AssertionUtil.verifyEqual(actualFutureHoldsAmount, holdAmount,
				"ECS031 : Verification of actual Ledger Balance: " + actualFutureHoldsAmount
						+ " After Add Hold Transaction");
		AssertionUtil.verifyEqual(actualAccountBalance, expectedAvailableBalance,
				"ECS031 : Verification of Ending Account Balance After Add Hold Transaction " + actualAccountBalance
						+ "  not changed is successful.");
		AssertionUtil.verifyEqual(actualFutreHoldsPreAuthAmount, holdAmount,
				"ECS031 : Verification of FutreHolds PreAuth Amount: " + actualFutreHoldsPreAuthAmount
						+ " After Add Hold Transaction");
		// *******From Holds Tab section after hold created**********
		accountDetailTabScreen.clickOnTab("Holds");
		String actualHoldTypeFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "Hold Type", 1);
		String actualStartDateFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "Start Date", 1);
		String actualEndDateFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "End Date", 1);
		String actualInitialDurationFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "Initial Duration",
				1);
		String actualAmountFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "Amount", 1);

		AssertionUtil.verifyEqual(actualHoldTypeFromHoldsTab, expectedHoldType,
				"ECS030 : Verification of Hold Type in Holds tab section");
		AssertionUtil.verifyEqual(actualInitialDurationFromHoldsTab, expectedDuration,
				"ECS030 : Verification of Initial Duration value: " + actualInitialDurationFromHoldsTab
						+ " in Holds tab section");
		AssertionUtil.verifyEqual(actualAmountFromHoldsTab, holdAmount, "ECS030 : Verification of Amount value: "
				+ actualAmountFromHoldsTab + " available in Holds tab section");
		AssertionUtil.verifyEqual(actualStartDateFromHoldsTab, expectedStartDate,
				"ECS030 : Verification of Start date: " + actualStartDateFromHoldsTab + " in Holds tab section");
		AssertionUtil.verifyEqual(actualEndDateFromHoldsTab, expectedEndDate,
				"ECS030 : Verification of End date: " + actualEndDateFromHoldsTab + " in Holds tab section");

	}

	@Test(description = "Verify Modify Holds in Overview, Holds table and in Balance Summary after add holds Transaction for Personal Saving Account")
	public void ECS032_ECS033_validateModifylHoldsTransactionForPersonalSavingAccount() {

		int timeout = 10;
		int initialAccountBalance = 1000;
		String initialBalance = "1,000.00";
		String holdAmount = "100.00";
		String expectedFutureHolds = "0.00";
		String expectedAvailableBalance = "900.00";
		String consumerFirstName = "ECS03233";
		String consumerLastName = "AutoLN";
		String expectedDuration = "One Business Day";
		String modifiedHoldAmount = "300.00";
		String expectedModifiedBalance = "700.00";

		String modifiedEndDate = new CommonUtil().getDateTime(2, "MM/dd/yyyy hh:mm:ss a");
		String expectedModifiedEndDate = new CommonUtil().getDateTime(2, "MM/dd/yyyy");
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().addHold(expectedDuration, holdAmount, timeout);
		accountDetailTabScreen.wait(10);
		String actualLedgerBalanceAfterHold = accountDetailTabScreen.getLedgerBalance();
		String actualCurrentHoldsAmount = accountDetailTabScreen.getCurrentHoldsAmount();
		String actualFutureHoldsAmount = accountDetailTabScreen.getFutureHoldsAmount();
		String actualAccountBalanceAfterHold = accountDetailTabScreen.getAvailableAccountBalance();

		AssertionUtil.verifyEqual(actualLedgerBalanceAfterHold, initialBalance,
				"ECS032 : Verification of actual Ledger Balance: " + actualLedgerBalanceAfterHold
						+ " After Add Hold Transaction");
		AssertionUtil.verifyEqual(actualCurrentHoldsAmount, holdAmount, "ECS032 : Verification of Current Hold Amount: "
				+ actualCurrentHoldsAmount + " After Add Hold Transaction is successful");
		AssertionUtil.verifyEqual(actualFutureHoldsAmount, expectedFutureHolds,
				"ECS032 : Verification of actual Ledger Balance: " + actualFutureHoldsAmount
						+ " After Add Hold Transaction");
		AssertionUtil.verifyEqual(actualAccountBalanceAfterHold, expectedAvailableBalance,
				"ECS032 : Verification of Ending Account Balance After Add Hold Transaction "
						+ actualAccountBalanceAfterHold + " is successful.");
		accountDetailTabScreen.wait(5);
		String actualAmountFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "AMOUNT", 1);

		AssertionUtil.verifyEqual(actualAmountFromHoldsTab, holdAmount, "ECS032 : Verification of Amount value: "
				+ actualAmountFromHoldsTab + " available in Holds tab section");

		// **********Modify Hold *******
		accountDetailTabScreen.refreshPage().clickOnThreeDotIconInTable("Holds").clickOnLinkByJS("Modify Hold")
				.getCommonWidget().getAddHoldScreen().enterEndDate(modifiedEndDate).enterHoldAmount(modifiedHoldAmount)
				.clickOnSubmitButton();
		String holdModifiedMessage = accountDetailTabScreen.getPopUpMessage(timeout);
		AssertionUtil.verifyContainsText(holdModifiedMessage, "Hold updated.",
				"ECS032 : Verification of Hold created popup message: '" + holdModifiedMessage + "' is successful.");
		accountDetailTabScreen.wait(timeout);

		// ******From Hold Table in Overview section after modified hold
		String actualModifiedEndDate = accountDetailTabScreen.getValueFromTable("Holds", "End Date", 1);
		String actualModifiedHoldAmountValue = accountDetailTabScreen.getValueFromTable("Holds", "Amount", 1);
		AssertionUtil.verifyEqual(actualModifiedEndDate, expectedModifiedEndDate,
				"ECS032 : Verification of updated End date: " + actualModifiedEndDate
						+ " under Holds table in Overview tab section");
		AssertionUtil.verifyEqual(actualModifiedHoldAmountValue, modifiedHoldAmount,
				"ECS032 : Verification of updated Amount value: " + actualModifiedHoldAmountValue
						+ " available under Holds table in Overview tab section");

		// * //**From Balance Summary Section after hold modified

		String actualLedgerBalanceAfterHoldUpdated = accountDetailTabScreen.getLedgerBalance();
		String actualCurrentHoldsAmountAfterHoldUpdated = accountDetailTabScreen.getCurrentHoldsAmount();
		String actualFutureHoldsAmountAfterHoldUpdated = accountDetailTabScreen.getFutureHoldsAmount();
		String actualAccountBalanceAfterHoldUpdated = accountDetailTabScreen.getAvailableAccountBalance();

		AssertionUtil.verifyEqual(actualLedgerBalanceAfterHoldUpdated, initialBalance,
				"ECS033 : Verification of Ledger Balance After hold update: " + actualLedgerBalanceAfterHoldUpdated
						+ " After updated Hold Transaction");
		AssertionUtil.verifyEqual(actualCurrentHoldsAmountAfterHoldUpdated, modifiedHoldAmount,
				"ECS033 : Verification of Current Hold Amount: " + actualCurrentHoldsAmountAfterHoldUpdated
						+ " After updated Hold Transaction is successful");
		AssertionUtil.verifyEqual(actualFutureHoldsAmountAfterHoldUpdated, expectedFutureHolds,
				"ECS033 : Verification of Future Hold Amount: " + actualFutureHoldsAmountAfterHoldUpdated
						+ " After updated Hold Transaction");
		AssertionUtil.verifyEqual(actualAccountBalanceAfterHoldUpdated, expectedModifiedBalance,
				"ECS033 : Verification of Ending Account Balance After updated Hold Transaction "
						+ actualAccountBalanceAfterHoldUpdated + "  not changed is successful.");
	}

	@Test(description = "Verify Cancel Holds in Overview, Holds table and in Balance Summary after add holds Transaction for Personal Saving Account")
	public void ECS034_validateCancelHoldsTransactionForPersonalSavingAccount() {

		int timeout = 10;
		int initialAccountBalance = 1000;
		String initialBalance = "1,000.00";
		String holdAmount = "100.00";
		String expectedFutureHolds = "0.00";
		String expectedAvailableBalance = "900.00";
		String consumerFirstName = "ECS34";
		String consumerLastName = "AutoLN34";
		String expectedDuration = "One Business Day";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().addHold(expectedDuration, holdAmount, timeout);
		accountDetailTabScreen.wait(10);
		String actualLedgerBalanceAfterHold = accountDetailTabScreen.getLedgerBalance();
		String actualCurrentHoldsAmount = accountDetailTabScreen.getCurrentHoldsAmount();
		String actualFutureHoldsAmount = accountDetailTabScreen.getFutureHoldsAmount();
		String actualAccountBalanceAfterHold = accountDetailTabScreen.getAvailableAccountBalance();

		AssertionUtil.verifyEqual(actualLedgerBalanceAfterHold, initialBalance,
				"ECS034 : Verification of actual Ledger Balance: " + actualLedgerBalanceAfterHold
						+ " After Add Hold Transaction");
		AssertionUtil.verifyEqual(actualCurrentHoldsAmount, holdAmount, "ECS034 : Verification of Current Hold Amount: "
				+ actualCurrentHoldsAmount + " After Add Hold Transaction is successful");
		AssertionUtil.verifyEqual(actualFutureHoldsAmount, expectedFutureHolds,
				"ECS034 : Verification of actual Ledger Balance: " + actualFutureHoldsAmount
						+ " After Add Hold Transaction");
		AssertionUtil.verifyEqual(actualAccountBalanceAfterHold, expectedAvailableBalance,
				"ECS034 : Verification of Ending Account Balance After Add Hold Transaction "
						+ actualAccountBalanceAfterHold + " is successful.");
		accountDetailTabScreen.wait(5);
		String actualAmountFromHoldsTab = accountDetailTabScreen.getValueFromTable("Holds", "AMOUNT", 1);

		AssertionUtil.verifyEqual(actualAmountFromHoldsTab, holdAmount, "ECS034 : Verification of Amount value: "
				+ actualAmountFromHoldsTab + " available in Holds tab section");

		accountDetailTabScreen.refreshPage().clickOnThreeDotIconInTable("Holds").clickOnLinkByJS("Cancel Hold").wait(3)
				.getCommonWidget().getAddHoldScreen().clickOnSubmitButton().wait(1);
		String holdCancelMessage = accountDetailTabScreen.getPopUpMessage(timeout);
		if (!holdCancelMessage.equalsIgnoreCase("Hold canceled.")) {
			accountDetailTabScreen.closeUnExpectedErrorPopUp(10);
			accountDetailTabScreen.getCommonWidget().getAddHoldScreen().clickOnSubmitButton().wait(1);
			holdCancelMessage = accountDetailTabScreen.getPopUpMessage(timeout);
		}
		AssertionUtil.verifyContainsText(holdCancelMessage, "Hold canceled.",
				"ECS034 : Verification of Hold created popup message: '" + holdCancelMessage + "' is successful.");

		accountDetailTabScreen.wait(timeout);
		String textFromHoldTable = accountDetailTabScreen.getValueFromTable("Holds", 1, 1);
		AssertionUtil.verifyEqual(textFromHoldTable, "No items to show...", "ECS034 : Verification of text: "
				+ textFromHoldTable + " in Hold table in overview section is successful.");

		// ***From Balance Summary Section after hold canceled

		String actualLedgerBalanceAfterHoldCancel = accountDetailTabScreen.getLedgerBalance();
		String actualCurrentHoldsAmountAfterHoldCancel = accountDetailTabScreen.getCurrentHoldsAmount();
		String actualFutureHoldsAmountAfterHoldCancel = accountDetailTabScreen.getFutureHoldsAmount();
		String actualAccountBalanceAfterHoldCancel = accountDetailTabScreen.getAvailableAccountBalance();

		AssertionUtil.verifyEqual(actualLedgerBalanceAfterHoldCancel, initialBalance,
				"ECS034 : Verification of actual Ledger Balance: " + actualLedgerBalanceAfterHoldCancel
						+ " after cancel Hold Transaction");
		AssertionUtil.verifyEqual(actualCurrentHoldsAmountAfterHoldCancel, "0.00",
				"ECS034 : Verification of Current Hold Amount: " + actualCurrentHoldsAmountAfterHoldCancel
						+ " after cancel Hold Transaction is successful");
		AssertionUtil.verifyEqual(actualFutureHoldsAmountAfterHoldCancel, "0.00",
				"ECS034 : Verification of actual Ledger Balance: " + actualFutureHoldsAmountAfterHoldCancel
						+ " after cancel Hold Transaction");
		AssertionUtil.verifyEqual(actualAccountBalanceAfterHoldCancel, initialBalance,
				"ECS034 : Verification of Ending Account Balance After cancel Hold Transaction "
						+ actualAccountBalanceAfterHoldCancel + " is successful.");
	}

	@Test(description = "Verify Add Order Transaction for Multi Position Account with Book Transfer Order Type")
	public void ECS035_validateAddOrderTransactionForMultiPositionAccountForBookTransferOrderType() {

		int initialAccountBalance = 1600;
		String consumerFirstName = "ECS"+ new CommonUtil().getSSN();
		String consumerLastName = "AutoLN035";
		String orderType = "Book transfer";
		String transferAmount = "500.00";

		com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse = ecsAPIs
				.addMultiPositionAccountToConsumerAPI(baseUrl, consumerFirstName, consumerLastName,
						initialAccountBalance);

		String multiPositionAccountNumber = APIDataManager.getAccountNumber(addMultiPositionAccountResponse);

		String businessSavingAccountNumber = multiPositionAccountNumber + "01";
		String savingsAccountNumber = "Savings Account - " + multiPositionAccountNumber;
		String interestCheckingAccountNumber = multiPositionAccountNumber + "03 - Interest Checking";

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName,
						businessSavingAccountNumber)
				.getCommonWidget()
				.addOrder(orderType, savingsAccountNumber, interestCheckingAccountNumber, transferAmount);

		String feedbackMessage = accountDetailTabScreen.getFeedbackMessage();

		accountDetailTabScreen.clickOnTab("Orders").wait(10);

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType,
				"ECS035 : Verification of Order Type Value in Orders Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, transferAmount,
				"ECS035 : Verification of Order Amount Value in Orders Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(orderTableStatusValue, "Completed",
				"ECS035 : Verification of Status Value in Orders Table for Add Order Transaction in MultiPosition Account");

		accountDetailTabScreen.clickOnTab("Transactions");

		String transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 1);
		String transactionsTableDebitValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Debit", 1);
		String transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 1);

		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, "Funds Transfer",
				"ECS035 : Verification of Order Type Value in Transactions Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(transactionsTableDebitValue, transferAmount,
				"ECS035 : Verification of Order Amount Value in Transactions Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, "1,100.00",
				"ECS035 : Verification of Status Value in Transactions Table for Add Order Transaction in MultiPosition Account");

		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
				.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseNumberValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Number",
				1);
		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyContainsText(feedbackMessage, closedCasesTableCaseNumberValue,
				"ECS035 : Verification of Case Number Value in Closed Cases Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Funds Transfer Internal",
				"ECS035 : Verification of Case Type Value in Closed Cases Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS035 : Verification of Status Value in Closed Cases  Table for Add Order Transaction in MultiPosition Account");

	}

	@Test(description = "Verify Add Payment Order transaction for Personal Savings Account")
	public void ECS036_validateAddPaymentOrderTransactionForPersonalSavingsAccount() {

		int initialAccountBalance = 2000;
		String consumerFirstName = "ECS036";
		String consumerLastName = "AutoLN";
		String orderType = "Payment order";
		String transferAmount = "500.00";
		String routingNumber = "122105155";
		String accountType = "Savings deposit account";
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget()
				.addOrder(orderType, routingNumber, "Test", "0000000123456", accountType, transferAmount);

		String feedbackMessage = accountDetailTabScreen.getFeedbackMessage();

		accountDetailTabScreen.refreshPage().wait(5).clickOnTab("Orders").wait(10);

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType, "ECS036 : Verification of Order Type : "
				+ orderType + " in Orders Table for Add Order Transaction in personal savings Account");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, transferAmount, "ECS036 : Verification of Order Amount: "
				+ transferAmount + " in Orders Table for Add Order Transaction in personal savings Account");
		//was status: "Entered" 
		AssertionUtil.verifyEqual(orderTableStatusValue, "In Process", "ECS036 : Verification of Status " 
				+ orderTableStatusValue + " in Orders Table for Add Order Transaction in Personal Savings Account");

		accountDetailTabScreen.clickOnTab("Transactions");

		String transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 1);
		String transactionsTableDebitValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Debit", 1);
		String transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 1);

		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, "Transfer Out",
				"ECS036 : Verification of Order Type Value in Transactions Table for Add Order Transaction in Savings Account");

		AssertionUtil.verifyEqual(transactionsTableDebitValue, transferAmount,
				"ECS036 : Verification of Order Amount Value in Transactions Table for Add Order Transaction in Savings Account");

		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, "1,500.00",
				"ECS036 : Verification of Status Value in Transactions Table for Add Order Transaction in Savings Account");

		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
				.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseNumberValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Number",
				1);
		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyContainsText(feedbackMessage, closedCasesTableCaseNumberValue,
				"ECS036 : Verification of Case Number: " + closedCasesTableCaseNumberValue
						+ " in Closed Cases Table for Add Order Transaction in Savings Account");

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Outbound Funds Transfer ACH",
				"ECS036 : Verification of Case Type: " + closedCasesTableCaseTypeValue
						+ " in Closed Cases Table for Add Order Transaction in Savings Account");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS036 : Verification of Status: 'Closed' in Closed Cases Table for Add Order Transaction in Savings Account");

	}

	@Test(description = "Verify Order Approval for Multi Position Account with Book Transfer Order Type")
	public void ECS037_ECS038_ECS039_ECS040_ECS041_validateOrderApprovalForMultiPositionAccountForBookTransferOrderType() {

		int initialAccountBalance = 20000;
		String tinNumber = new CommonUtil().getSSN();
		String consumerFirstName = "ECS"+tinNumber;
		String consumerLastName = "AutoLN3738394041";
		String orderType = "Book transfer";
		String transferAmount = "3,500.00";

		com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse = ecsAPIs
				.addMultiPositionAccountToConsumerAPI(baseUrl, consumerFirstName, consumerLastName,
						initialAccountBalance);

		String multiPositionAccountNumber = APIDataManager.getAccountNumber(addMultiPositionAccountResponse);

		String businessSavingAccountNumber = multiPositionAccountNumber + "01";
		String savingsAccountNumber = "Savings Account - " + multiPositionAccountNumber;
		String interestCheckingAccountNumber = multiPositionAccountNumber + "03 - Interest Checking";

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName,
						businessSavingAccountNumber)
				.getCommonWidget()
				.addOrder(orderType, savingsAccountNumber, interestCheckingAccountNumber, transferAmount);

		String caseNumber = accountDetailTabScreen.getFeedbackMessage().split(" ")[3].trim();

		accountDetailTabScreen.clickOnTab("Orders");

		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableStatusValue, "In Process",
				"ECS037 : Verification of Status Value in Orders Table for Add Order Transaction in MultiPosition Account");      wmiScreen = 
		accountDetailTabScreen.getCommonWidget().logout().doLogin("autobolead@savee.qa", "Savana1#")
				.getCommonWidget().clickOnWorkflowIcon().clickOnSelectProcessDropdown()
				.clickOnSelectProcessValue("Account Servicing").clickOnActivity("Approval")
				.clickOnCaseNumberColumnHeader().wait(5).clickOnCaseNumberColumnHeader().clickOnCaseNumber(caseNumber);

		AssertionUtil.verifyEqual(wmiScreen.getCaseNumberUnderGeneralCaseInformationValue(), caseNumber,
				"ECS038 : Verification of Case Number Value available under General Case Information");

		AssertionUtil.verifyEqual(wmiScreen.getCaseStatusUnderGeneralCaseInformationValue(), "Open",
				"ECS038 : Verification of Case Status Value available under General Case Information");

		AssertionUtil.verifyEqual(wmiScreen.getCurrentQueueUnderGeneralCaseInformationValue(), "Approval",
				"ECS038 : Verification of Current Queue Value available under General Case Information");

		AssertionUtil.verifyContainsText(wmiScreen.getCreatedDateUnderGeneralCaseInformationValue(),
				new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS038 : Verification of Created Date Value available under General Case Information");

		accountDetailTabScreen= wmiScreen.selectWorkFlowActionsOption("First Approval Complete") //.selectFirstApprovalCompleteOption()
				.getCommonWidget().clickOnSearchIcon()
				.clickOnConsumerSearch().clickOnConsumerSearchOption("Account").selectBankingGroup("Multi-Position")
				.enterAccountNumberForSearch(businessSavingAccountNumber).clickOnAccountSearchButton();

		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
				.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseNumberValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Number",
				1);
		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseNumberValue, caseNumber,
				"ECS039 : Verification of Case Number Value in Closed Cases Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Funds Transfer Internal",
				"ECS039 : Verification of Case Type Value in Closed Cases Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS039 : Verification of Status Value in Closed Cases  Table for Add Order Transaction in MultiPosition Account");

		accountDetailTabScreen.clickOnTab("Orders");

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType,
				"ECS040 : Verification of Order Type Value in Orders Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, transferAmount,
				"ECS040 : Verification of Order Amount Value in Orders Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(orderTableStatusValue, "Completed",
				"ECS040 : Verification of Status Value in Orders Table for Add Order Transaction in MultiPosition Account");

		accountDetailTabScreen.clickOnTab("Transactions");

		String transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 1);
		String transactionsTableDebitValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Debit", 1);
		String transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 1);

		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, "Funds Transfer",
				"ECS041 : Verification of Order Type Value in Transactions Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(transactionsTableDebitValue, transferAmount,
				"ECS041 : Verification of Order Amount Value in Transactions Table for Add Order Transaction in MultiPosition Account");

		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, "16,500.00",
				"ECS041 : Verification of Status Value in Transactions Table for Add Order Transaction in MultiPosition Account");

	}

	@Test(description = "Verify Order Cancel after add payment order for banking account")
	public void ECS042_validateCancelOrderForAddPaymentOrderTransactionForBankingAccount() {

		int initialAccountBalance = 1500;
		String consumerFirstName = "ECS42";
		String consumerLastName = "AutoLN";
		String orderType = "Payment order";
		String transferAmount = "1,200.00";
		String routingNumber = "122105155";
		String accountType = "Savings deposit account";
		String transferDate = new CommonUtil().getDateTime(5, "MM/dd/yyyy");
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().addOrder(orderType, routingNumber, "Test", "000000012345959", accountType,
						transferDate, transferAmount);

		accountDetailTabScreen.refreshPage().wait(10)
				.clickOnTab("Orders").wait(10)
				.clickOnThreeDotIconInTable("Orders")
				.clickOnLinkByJS("Cancel Order").wait(5).getCommonWidget().getAddHoldScreen()
				.clickOnCancelOrderSubmitBtn().wait(2);
		String orderCancelMessage = accountDetailTabScreen.getPopUpMessage(20);

		AssertionUtil.verifyEqual(orderCancelMessage, "Order canceled.",
				"Verification of cancel order pop up message contains '" + orderCancelMessage + " is successful  ");
		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType, "ECS042 : Verification of Order Type : "
				+ orderType + " in Orders Table for cancel Payment Order in personal savings account");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, transferAmount, "ECS042 : Verification of Order Amount: "
				+ transferAmount + " in Orders Table for cancel Payment Order in personal savings Account");

		AssertionUtil.verifyEqual(orderTableStatusValue, "Canceled", "ECS042 : Verification of Status "
				+ orderTableStatusValue + " in Orders Table for cancel Payment Order in Personal Savings Account");

		accountDetailTabScreen.clickOnTab("Overview");
		String scheduledTransactionStatus = accountDetailTabScreen.getValueFromTable("scheduledTrans", "STATUS", 1);
		AssertionUtil.verifyEqual(scheduledTransactionStatus, "Canceled", "ECS042 : Verification of Status "
				+ scheduledTransactionStatus
				+ " in scheduled Transaction Table for cancel Payment Order Transaction in Personal Savings Account");
	}
	@Test(description = "Verify of Post Transaction for Loan Account With Loan Disbursement Transaction")
	public void ECS043_validateLoanDisbursementTransactionForLoanAccount() {

		int timeout = 10;
		String consumerFirstName = "Test043";
		String consumerLastName = "AutoLN";
		String amount = "500.00";
		String transactionCode = "Loan Disbursement";
		String targetAccountNumber = "000000002503";

		com.qa.ecs.pojo.response.CreateLoan createLoanResponse = ecsAPIs.addLoanAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, 200);

		String accountNumber = APIDataManager.getAccountNumber(createLoanResponse);

		accountDetailTabScreen = loginPage.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName,
				accountNumber);

		String availableAccountBalance = accountDetailTabScreen.getAvailableAccountBalance();

		AssertionUtil.verifyEqual(availableAccountBalance, "4,800.00",
				"ECS043 : Verification of Available Balance for Loan Account before Post Transaction");

		accountDetailTabScreen.getCommonWidget().postTransaction(transactionCode, targetAccountNumber, amount, timeout);

		String feedbackMessage = accountDetailTabScreen.getFeedbackMessage();

		AssertionUtil.verifyEqual(feedbackMessage, "Transaction added successfully.",
				"ECS043 : Verification of Feedback Message");

		availableAccountBalance = accountDetailTabScreen.getAvailableAccountBalance();

		AssertionUtil.verifyEqual(availableAccountBalance, "4,300.00",
				"ECS043 : Verification of Available Balance for Loan Account after Post Transaction");

		accountDetailTabScreen.clickOnTab("Transactions");

		String transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 1);
		String transactionsTableDebitValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Debit", 1);
		String transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 1);

		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, transactionCode,
				"ECS043 : Verification of Transaction Type Value in Transactions Table for Loan Disbursement Transaction");

		AssertionUtil.verifyEqual(transactionsTableDebitValue, amount,
				"ECS043 : Verification of Debit Value in Transactions Table for Loan Disbursement Transaction");

		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, amount,
				"ECS043 : Verification of Ending Balance Value in Transactions Table for Loan Disbursement Transaction");

		accountDetailTabScreen = accountDetailTabScreen.getCommonWidget().clickOnSearchIcon().clickOnConsumerSearch()
				.clickOnConsumerSearchOption("Account").wait(1).enterAccountNumberForSearch(targetAccountNumber)
				.clickOnAccountSearchButton();

		accountDetailTabScreen.clickOnTab("Transactions").wait(3);

		transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 1);
		String transactionsTableCreditValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Credit",
				1);
		transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 1);

		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, transactionCode,
				"ECS043 : Verification of Transaction Type Value in Transactions Table for Loan Disbursement Transaction");

		AssertionUtil.verifyEqual(transactionsTableCreditValue, amount,
				"ECS043 : Verification of Credit Value in Transactions Table for Loan Disbursement Transaction");

	}

	@Test(description = "Verify of Add Order Transaction for Loan Account With order type: Collection Order more than $2000")
	public void ECS044_validateCollectionOrderTransactionForLoanAccount() {

		String consumerFirstName = "Test044";
		String consumerLastName = "AutoLN";
		String orderType = "Collection order";
		String transferAmount = "2,200.00";
		String routingNumber = "043000096";
		String accTitle = "Test";
		String accNumber = "000000002503";
		String accType = "Credit card account";

		com.qa.ecs.pojo.response.CreateLoan createLoanResponse = ecsAPIs.addLoanAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, 200);

		String accountNumber = APIDataManager.getAccountNumber(createLoanResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().addOrder(orderType, routingNumber, accTitle, accNumber, accType, transferAmount);

		String caseNumber = accountDetailTabScreen.getFeedbackMessage().split(" ")[3].trim();

		accountDetailTabScreen.refreshPage().clickOnTab("Orders").wait(10);

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType,
				"ECS044 : Verification of Order Type Value in Orders Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, transferAmount,
				"ECS044 : Verification of Order Amount Value in Orders Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(orderTableStatusValue, "Entered",
				"ECS044 : Verification of Status Value in Orders Table for Add Order Transaction in Loan Account");

		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases").wait(10);

		String closedCasesTableCaseNumberValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Case Number",
				1);
		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Case Type", 1);
		String closedCasesTableCreatedDateValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Created Date",
				1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseNumberValue, caseNumber,
				"ECS044 : Verification of Case Number Value in Open Cases Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Inbound ACH Collection Order",
				"ECS044 : Verification of Case Type Value in Open Cases Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(closedCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS044 : Verification of Created Date Value in Open Cases Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "New",
				"ECS044 : Verification of Status Value in Open Cases  Table for Add Order Transaction in Loan Account");

	}
	
	@Test(description = "Verify WMI window open and displayed currect customer information for Add Customer Service Case")
	public void ECS045_ValidateCustomerInfoForAddCustomerServiceCaseInWMI() {
		String firstName = "ECS45";
		String lastName = "AutoLN";
		String serviceCaseType = "Online Banking Issue";
		String createdBy = "admin_SavEE_QA_Automation";
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");
		wmiScreen = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Service Case").getCustomerDetailPage()
				.selectServiceCase(serviceCaseType).getCommonWidget().clickOnSubmitBtn();
		String actualCaseType = wmiScreen.getCaseTypeText();
		AssertionUtil.verifyEqual(actualCaseType, serviceCaseType,
				"ECS045 : Verification of service case type " + actualCaseType + " is successful");
		String createdDateText = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(2).split(":")[1].trim();
		String actualCreatedDate = createdDateText.split(" ")[0];
		String actualCreatedBy = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(2).split("by")[1].trim();
		String actualCaseStatus = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(5).split(":")[1].trim();
		AssertionUtil.verifyContainsText(actualCreatedDate, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS045 : Verification of Created Date: " + actualCreatedDate
						+ " available under General Case Information");
		AssertionUtil.verifyEqual(actualCreatedBy, createdBy, "ECS045 : Verification of Created By: " + actualCreatedBy
				+ " available under General Case Information");
		AssertionUtil.verifyEqual(actualCaseStatus, "New", "ECS045 : Verification of Case Status Value: "
				+ actualCaseStatus + " available under General Case Information");
	}

	@Test(description = "Verify of Invalid Address Flow and updated Zip Code Flow")
	public void ECS046_ECS047_ECS048_ECS049_ECS050_verifyInvalidAddressAndUpdatedZipCode() {

		String consumerFirstName = "AutoTest4647484950";
		String zipCode = "100015";
		String consumerLastName = new CommonUtil().getSSN();

		ecsAPIs.createConsumerIfNotExists(baseUrl, consumerFirstName, consumerLastName);

		customerDetail = loginPage.loginAndNavigateToConsumerDetails(consumerFirstName, consumerLastName)
				.clickOnTab("Contact Details").clickOnThreeDot("Consumer Address", 1).clickOnModifyAddressOption()
				.enterZipCode(zipCode).clickOnSubmitButton();

		String feedbackMessage = customerDetail.getFeedbackMessage();

		AssertionUtil.verifyEqual(feedbackMessage, "Address update smart case has been created.",
				"ECS046 : Verification of Feedback Message for Modify Address");

		customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Cases").wait(10);

		String openCasesTableCaseTypeValue = customerDetail.getValueFromTable("OpenCases", "Case Type", 1);
		String openCasesTableCreatedDateValue = customerDetail.getValueFromTable("OpenCases", "Created Date", 1);
		String openCasesTableStatusValue = customerDetail.getValueFromTable("OpenCases", "Status", 1);

		AssertionUtil.verifyEqual(openCasesTableCaseTypeValue, "Address Update",
				"ECS046 : Verification of Case Type Value in Open Cases Table for Modify Address");

		AssertionUtil.verifyEqual(openCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS046 : Verification of Created Date Value in Open Cases Table for Modify Address");

		AssertionUtil.verifyEqual(openCasesTableStatusValue, "New",
				"ECS046 : Verification of Status Value in Open Cases Table for Modify Address");

		wmiScreen = customerDetail.clickOnValueLinkInTable("OpenCases", "Case Number", 1).wait(5).getWMISCreen();

		AssertionUtil.verifyContainsText(wmiScreen.getGeneralCaseInformationValue(), "Case Status: New",
				"ECS047 : Verification of Case Status Value available under General Case Information");

		AssertionUtil.verifyContainsText(wmiScreen.getGeneralCaseInformationValue(), "Current Queue: Back Office",
				"ECS047 : Verification of Current Queue Value available under General Case Information");

		wmiScreen.selectAddressType("Billing");

		customerDetail = wmiScreen.selectWorkFlowActionsOption("Execute Address Update").getCommonWidget()
				.getCustomerDetailPage().clickOnTab("Closed Cases");

		String closedCasesTableCaseTypeValue = customerDetail.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableCreatedDateValue = customerDetail.getValueFromTable("ClosedCases", "Created Date", 1);
		String closedCasesTableStatusValue = customerDetail.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Address Update",
				"ECS048 : Verification of Case Type Value in Closed Cases Table for Modify Address");
		AssertionUtil.verifyEqual(closedCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS048 : Verification of Created Date Value in Closed Cases Table for Modify Address");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS049 : Verification of Status Value in Closed Cases Table for Modify Address");
		
		
		customerDetail.clickOnTab("Contact Details");
		
		String actualZipCode = customerDetail.getValueFromTable("AddressTable", "Zip/Postal Code", 1);
		
		AssertionUtil.verifyEqual(actualZipCode, zipCode,
				"ECS050 : Verification of Updated Zip Code in Consumer Address Table under Contact Details tab is successful");

	}

	@Test(description = "Verify of Update Address Flow")
	public void ECS051_ECS052_ECS053_ECS054_verifyUpdatedAddress() {

		String consumerFirstName = "AutoTest02";
		String addressLine1 = "50 Valley Stream Pkwy";
		String city="Malvern";
		String state = "Pennsylvania";
		String zipCode = "19355";
		String consumerLastName = new CommonUtil().getSSN();

		ecsAPIs.createConsumerIfNotExists(baseUrl, consumerFirstName, consumerLastName);

		customerDetail = loginPage.loginAndNavigateToConsumerDetails(consumerFirstName, consumerLastName)
				.clickOnTab("Contact Details").clickOnAddButton("Consumer Address")
				.enterAddressLine1(addressLine1)
				.enterCity(city)
				.selectState(state)
				.enterZipCode(zipCode)
				.clickOnSubmitButton();

		String feedbackMessage = customerDetail.getFeedbackMessage();

		AssertionUtil.verifyEqual(feedbackMessage, "Address update smart case has been created.",
				"ECS051 : Verification of Feedback Message for Add Address");
		
		customerDetail.wait(5);
		customerDetail.refreshPage().wait(5);
		
		String expectedAlertMessage = "Address Update case created on "+new CommonUtil().getCurrentDateTime("MM/dd/yyyy")+" for "+consumerFirstName+" "+consumerLastName ;
		
		AssertionUtil.verifyEqual(customerDetail.getAlertMessage(), expectedAlertMessage ,
				"ECS054 : Verification of Alert Message successfully");
		
		customerDetail.closeAlertMessagePopup();
		
		customerDetail.clickOnTab("Contact Details");	
						
		String actualAddressLine1 = customerDetail.getValueFromTable("AddressTable", "Address Line 1", 3);
		String actualCity = customerDetail.getValueFromTable("AddressTable", "City", 3);
		String actualState = customerDetail.getValueFromTable("AddressTable", "State/Region", 3);
		String actualZipCode = customerDetail.getValueFromTable("AddressTable", "Zip/Postal Code", 3);
		String actualCountry = customerDetail.getValueFromTable("AddressTable", "Country", 3);
		String actualVerifiedDate = customerDetail.getValueFromTable("AddressTable", "Verified Date", 3);
		AssertionUtil.verifyEqual(actualAddressLine1, addressLine1,
				"ECS052 : Verification of Updated Address Line 1 in Consumer Address Table under Contact Details tab is successful");
		AssertionUtil.verifyEqual(actualCity, city,
				"ECS052 : Verification of Updated City in Consumer Address Table under Contact Details tab is successful");
		AssertionUtil.verifyEqual(actualState, state,
				"ECS052 : Verification of Updated State in Consumer Address Table under Contact Details tab is successful");
		AssertionUtil.verifyEqual(actualZipCode, "19355-1483",
				"ECS052 : Verification of Updated Zip Code in Consumer Address Table under Contact Details tab is successful");
		AssertionUtil.verifyEqual(actualCountry, "United States of America",
				"ECS052 : Verification of Updated Country in Consumer Address Table under Contact Details tab is successful");
		AssertionUtil.verifyEqual(actualVerifiedDate, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS052 : Verification of Verified Date in Consumer Address Table under Contact Details tab is successful");
				
		customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Notifications");
		
		String actualType = customerDetail.getValueFromTable("notificationRecord", "Type", 1);
		String description = customerDetail.getValueFromTable("notificationRecord", "Description", 1);
		String generationStatus = customerDetail.getValueFromTable("notificationRecord", "Generation Status", 1);
		
		AssertionUtil.verifyEqual(actualType, "persInfoUpdate",
				"ECS053 : Verification of Type in Notification Table under More >> Notification successfully");
		AssertionUtil.verifyEqual(description, "Personal Information Update",
				"ECS053 : Verification of Description in Notification Table under More >> Notification successfully");
		AssertionUtil.verifyEqual(generationStatus, "Inprocess",
				"ECS053 : Verification of Inprocess in Notification Table under More >> Notification successfully");
				
	
	}

	
	
	@Test(description = "Profile Update case change is made and approval is needed. ")
	public void ECS055_ECS056_profileUpdateCaseChange() {

		String consumerFirstName = "AutoTest03";		
		String consumerLastName = new CommonUtil().getSSN();

		ecsAPIs.createConsumerIfNotExists(baseUrl, consumerFirstName, consumerLastName);

		customerDetail = loginPage.loginAndNavigateToConsumerDetails(consumerFirstName, consumerLastName)
				.clickOnTab("Profile").clickOnDetailPanelEditButton("Consumer Information & Preferences")
				.getCommonWidget().clickOnCustomerTaskLinkText("Modify Consumer Tax Information")
				.getProfileUpdateTaxIDScreen().selectTaxType("SSN").enterTaxID(new CommonUtil().getSSN())
				.selectUpdateReason("Data Entry Error").clickOnSubmitButton();

		String feedbackMessage = customerDetail.getFeedbackMessage();

		AssertionUtil.verifyEqual(feedbackMessage, "Profile update case has been created.",
				"ECS055 : Verification of Feedback Message for Profile Update");

		customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Cases").wait(10);

		String openCasesTableCaseTypeValue = customerDetail.getValueFromTable("OpenCases", "Case Type", 1);
		String openCasesTableCreatedDateValue = customerDetail.getValueFromTable("OpenCases", "Created Date", 1);
		String openCasesTableStatusValue = customerDetail.getValueFromTable("OpenCases", "Status", 1);

		AssertionUtil.verifyEqual(openCasesTableCaseTypeValue, "Tax ID Update Consumer",
				"ECS055 : Verification of Case Type Value in Open Cases Table");

		AssertionUtil.verifyEqual(openCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS055 : Verification of Created Date Value in Open Cases Table");

		AssertionUtil.verifyEqual(openCasesTableStatusValue, "New",
				"ECS055 : Verification of Status Value in Open Cases Table");

		wmiScreen = customerDetail.clickOnValueLinkInTable("OpenCases", "Case Number", 1).wait(5).getWMISCreen();

		AssertionUtil.verifyContainsText(wmiScreen.getCaseClassValue(), "Customer Maintenance",
				"ECS055 : Verification of Case Status Value available under Case Class");

	}
	@Test(description = "Verify customer complain added")
	public void ECS057_ValidateAddCustomerComplain() {

		String firstName = "ECS57";
		String lastName = "AutoLN";

		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");
		addComplaintScreen = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Complaint").getAddComplaintScreen();
		addComplaintScreen.selectComplaintOptions("ComplaintSource", "Consumer")
				.selectComplaintOptions("OriginInput", "Back Office")
				.selectComplaintOptions("ProductLine", "Money transfer")
				.selectComplaintOptions("ProductType", "International money transfer")
				.selectComplaintOptions("IssueType", "Transaction issue")
				.selectComplaintOptions("Company", "Demo Company.").enterTransferAmount("Automation Test");
		customerDetail = addComplaintScreen.clickOnSubmitButton();
		String popupMessage = customerDetail.getPopUpMessage(10);
		String caseNumber = popupMessage.split(" ")[6];
		wmiScreen = customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Cases").clickOnOpenCaseDocId(caseNumber);
		String actualSelectedProductType = wmiScreen.getSelectedOptionDisplayedFromDropDown("Product Type");
		AssertionUtil.verifyEqual(actualSelectedProductType, "International money transfer",
				"ECS057 : Verification of product type " + actualSelectedProductType
						+ " in WMI screen is selected successfuly");
		String actualSelectedIssueType = wmiScreen.getSelectedOptionDisplayedFromDropDown("Issue Type");
		AssertionUtil.verifyEqual(actualSelectedIssueType, "Transaction issue", "ECS057 : Verification of Issue type "
				+ actualSelectedIssueType + " in WMI screen is selected successfuly");
		String actualSelectedOrigin = wmiScreen.getSelectedOptionDisplayedFromDropDown("Origin");
		AssertionUtil.verifyEqual(actualSelectedOrigin, "Back Office", "ECS057 : Verification of selected origin "
				+ actualSelectedOrigin + " in WMI screen is selected successfuly");
	}

	@Test(description = "Verify add and lunch a new customer Document, modify document and verify from recent document table")
	public void ECS058_ECS059_ECS060_validateAddedCustomerDocumentModifiedDocTypeAndRecentDocTable()
			throws AWTException {

		String firstName = "ECS585960";
		String lastName = "AutoLN";

		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);

		String expectedDocClass = "Customer Due Diligence Documents";
		String expectedDocType = "Lease Copy";
		String modifiedDocType = "Bank Reference Letter";

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");
		addDocScreen = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Document").getDocumentScreen();
		addDocScreen.uploadFile("AB.pdf").selectDocumentOptions("Document Class", expectedDocClass)
				.selectDocumentOptions("Document Type", expectedDocType).enterDescriptionNote("Automation Test");
		customerDetail = addDocScreen.clickOnSubmitButton().getCustomerDetailPage();
		String expectedSuccessMessage = "Document uploaded successfully.";
		String actualSuccessMessage = customerDetail.getPopUpMessage(10);
		AssertionUtil.verifyEqual(actualSuccessMessage, expectedSuccessMessage,
				"ECS058 : Verification of document uploaded popup message is successful");
		customerDetail.clickOnOverViewDisplayedTextLink("Documents").clickOnOverViewDisplayedTextLink("Recent Documents")
				.clickOnValueFromTable("Documents", "Document Type", 1);
		addDocScreen = customerDetail.switchToNewDocWindow(1);
		String docTypeBeforeModify = addDocScreen.getDocType();
		addDocScreen.wait(10);
		AssertionUtil.verifyEqual(docTypeBeforeModify, expectedDocType,
				"ECS058 : Verification of Document Type is successful");

		addDocScreen.clickOnDocEditIcon().selectDocumentType(modifiedDocType).clickOnSubmitButton();
		String expectedPopupMessage = "Document updated successfully.";
		String actualPopupMessage = customerDetail.getPopUpMessage(10);
		AssertionUtil.verifyEqual(actualPopupMessage, expectedPopupMessage,
				"ECS059 : Verification of document updated popup message is successful");
		String docTypeAfterModify = addDocScreen.getDocType();
		
		AssertionUtil.verifyEqual(docTypeAfterModify, modifiedDocType,
				"ECS059 : Verification of Document Type after modify: " + docTypeAfterModify + " is successful");

		customerDetail = addDocScreen.switchToNewDocWindow(0).getCustomerDetailPage();
		customerDetail.clickOnOverViewDisplayedTextLink("Documents")
				.clickOnOverViewDisplayedTextLink("Recent Documents").clickOnRefreshIcon()
				.clickOnValueFromTable("Documents", "Document Type", 1).switchToNewDocWindow(1);
		String docType = addDocScreen.getDocType();
		AssertionUtil.verifyEqual(docType, modifiedDocType, "ECS060 : Verification of Document Type is successful");
	}

	@Test(description = "Verify add customer note- created by, created date of Notes table present in Note tab")
	public void ECS061_validateAddedCustomerNote() throws AWTException {
		String firstName = "ECS061";
		String lastName = "AutoLN";
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		String createdBy = "admin_SavEE_QA_Automation";
		String noteText = "Automation Test Note for ECS TC061";
		String createdDate = currentDate;
		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", firstName)
				.enterSearchTextForSearch("LastName", lastName).clickOnSearchButton();
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");
		customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Note").getCustomerDetailPage();
		customerDetail.enterNoteText(noteText).getCommonWidget().clickOnSubmitButton().getCustomerDetailPage();
		String expectedPopupMessage = "Note added successfully.";
		String actualPopupMessage = customerDetail.getPopUpMessage(10);
		AssertionUtil.verifyEqual(actualPopupMessage, expectedPopupMessage,
				"ECS061 : Verification of " + actualPopupMessage + " popup message is successful");
		customerDetail.clickOnOverViewDisplayedTextLink("Notes");
		String actualCreatedBy = customerDetail.getValueFromResultTable("notes", "CREATED BY", 1);
		AssertionUtil.verifyEqual(actualCreatedBy, createdBy,
				"ECS061 : Verification of Created Note By: " + actualCreatedBy + " is successful");
		String actualCreatedDate = customerDetail.getValueFromResultTable("notes", "CREATED DATE", 1);
		AssertionUtil.verifyEqual(actualCreatedDate, createdDate,
				"ECS061 : Verification of Created note on Date : " + actualCreatedDate + " is successful");
	}

	

	@Test(description = "Verify WMI window open and displayed currect customer information for Add Account Service Case")
	public void ECS062_ValidateCustomerInfoForAddAccountServiceCaseInWMI() {
		String firstName = "ECS062";
		String lastName = "AutoLN";
		String serviceCaseType = "Add Account Limit";
		String createdBy = "admin_SavEE_QA_Automation";
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				firstName, lastName, 1000);
		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);
		accountDetailTabScreen = loginPage.loginAndNavigateToConsumerAccountDetails(firstName, lastName, accountNumber)
				.getCommonWidget().clickOnThreeLineTasksIconLink().clickOnTaskLinkText("Add Account Service Case")
				.getAccountDetailTabScreen().selectServiceCase(serviceCaseType);
		wmiScreen = accountDetailTabScreen.getCommonWidget().clickOnSubmitBtn();
		String actualCaseType = wmiScreen.getCaseTypeText();
		AssertionUtil.verifyEqual(actualCaseType, serviceCaseType,
				"ECS062 : Verification of account service case type " + actualCaseType + " is successful");
		String createdDateText = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(2).split(":")[1].trim();
		String actualCreatedDate = createdDateText.split(" ")[0];
		String actualCreatedBy = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(2).split("by")[1].trim();
		String actualCaseStatus = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(5).split(":")[1].trim();
		AssertionUtil.verifyContainsText(actualCreatedDate, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS062 : Verification of Created Date: " + actualCreatedDate
						+ " available under General Case Information is successful");
		AssertionUtil.verifyEqual(actualCreatedBy, createdBy, "ECS062 : Verification of Created By: " + actualCreatedBy
				+ " available under General Case Information is successful");
		AssertionUtil.verifyEqual(actualCaseStatus, "New", "ECS062 : Verification of Case Status Value: "
				+ actualCaseStatus + " available under General Case Information is successful");
	}
	@Test(description = "Verify Account complain added and Open/See/Work Cases in Workflow module and verify in WMI screen")
	public void ECS063_ECS064_ValidateAddAccountComplainAndValidateWorkCaseInWorkFlowModulePlusWMIInfo() {
		int initialAccountBalance = 1200;
		String consumerFirstName = "ECS6364";
		String consumerLastName = "AutoLN";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		addComplaintScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().clickOnThreeLineTasksIconLink().clickOnTaskLinkText("Add Account Complaint")
				.getAddComplaintScreen();

		addComplaintScreen.selectComplaintOptions("ComplaintSource", "Consumer")
				.selectComplaintOptions("OriginInput", "Back Office")
				.selectComplaintOptions("ProductLine", "Money transfer")
				.selectComplaintOptions("ProductType", "International money transfer")
				.selectComplaintOptions("IssueType", "Transaction issue")
				.selectComplaintOptions("Company", "Demo Company.").enterTransferAmount("Automation Test");
		customerDetail = addComplaintScreen.clickOnSubmitButton();
		String popupMessage = customerDetail.getPopUpMessage(10);
		String caseNumber = popupMessage.split(" ")[6];
		wmiScreen = customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Cases").clickOnOpenCaseDocId(caseNumber);
		
		String caseNumberInWMIWindow = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(1).split(":")[1].trim();
		AssertionUtil.verifyEqual(caseNumberInWMIWindow, caseNumber, "ECS063 : Verification of Case Number: "+caseNumberInWMIWindow+" in WMI window under General Case Information is successful.");
		
		String actualSelectedProductType = wmiScreen.getSelectedOptionDisplayedFromDropDown("Product Type");
		AssertionUtil.verifyEqual(actualSelectedProductType, "International money transfer",
				"ECS063 : Verification of product type for account complaint " + actualSelectedProductType
						+ " in WMI screen is selected successfuly");
		String actualSelectedIssueType = wmiScreen.getSelectedOptionDisplayedFromDropDown("Issue Type");
		AssertionUtil.verifyEqual(actualSelectedIssueType, "Transaction issue",
				"ECS063 : Verification of Issue type for account complaint" + actualSelectedIssueType
						+ " in WMI screen is selected successfuly");
		String actualSelectedOrigin = wmiScreen.getSelectedOptionDisplayedFromDropDown("Origin");
		AssertionUtil.verifyEqual(actualSelectedOrigin, "Back Office",
				"ECS063 : Verification of selected origin for account complaint " + actualSelectedOrigin
						+ " in WMI screen is selected successfuly");
		
		commonWidget = wmiScreen.clickOnCloseWindowLink().getCommonWidgetPage();
		commonWidget.clickOnWorkflowIcon().clickOnSelectProcessDropdown()
					.clickOnSelectProcessValue("Complaint Management")
					.clickOnFilterIcon()
					.enterCaseNumber(caseNumber)
					.clickOnSearchButton();
		wmiScreen = commonWidget.getWorkflowPage().clickOnCaseNumber(caseNumber);
		String caseNoInWMIWForWorkFlowModule = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(1).split(":")[1].trim();
		AssertionUtil.verifyEqual(caseNoInWMIWForWorkFlowModule, caseNumber, "ECS064 : Verification of Case Number: "+caseNumberInWMIWindow+" for WorkFlow Module in WMI window under General Case Information is successful.");
		
		String selectedProductTypeInWMIWForWorkFlowModule = wmiScreen.getSelectedOptionDisplayedFromDropDown("Product Type");
		AssertionUtil.verifyEqual(selectedProductTypeInWMIWForWorkFlowModule, "International money transfer",
				"ECS064 : Verification of product type for account complaint " + selectedProductTypeInWMIWForWorkFlowModule	+ " for WorkFlow Module in WMI screen is selected successfuly");
	}


	
	@Test(description = "Verify Newly created Organization without account in Consumer Details page of Overview section"
			+ "and Account info in Account tab after add account for org")
	public void ECS068_ECS069_validateOrgnWithoutAccountInfoInCustomerOverViewPageAndThenAccountIInfoAfterCreateBankingAccount() {

		// ******** Organization Creation Data **********//
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateOrganization orgData = JacksonUtils.deserializeJson("OrganizationCreation.json",
				com.qa.ecs.pojo.request.CreateOrganization.class);
		String orgName = "Org" + tinNumber;
		orgData.getPartyOrg().setName(orgName);
		orgData.getPartyOrg().setTin(tinNumber);

		// ******** Organization Creation Action **********//
		customerDetail = loginPage.doLogin().clickOnTaskButton()
		.createOrganization(orgData);
		String actualOrgNameInCustomerDetailPage = customerDetail.getConsumerName();
		AssertionUtil.verifyEqual(actualOrgNameInCustomerDetailPage, orgName,
				"ECS068 : Verification of Newly created Organization name in Overview Page");
		
		String actualAccountInfo = customerDetail.getAccountPostionInfoInOverView();
		AssertionUtil.verifyEqual(actualAccountInfo, "No items to show...",
				"ECS068 : Verification of Organization created with no accounts in Overview Page");
		
		positionDetails = customerDetail.clickOnPlusIconForAddAccount().clickOnNextButton()
		.selectAccountRelationshipType("Primary").enterDescription("Test for automation").clickOnNextButton()
		.selectAccountGroup("Banking")
		.selectProductType("Interest Checking (C2001 - DDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		customerDetail = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().enterAgreementCode("01", 1).enterVersion("1", 1).wait(1).clickOnSubmitButton()
				.wait(1);
		customerDetail.clickOnTab("Accounts");
		
		String actualAccountNumber =customerDetail.getValueFromResultTable("SingleAccountsTable", "Account Number", 1);
		AssertionUtil.verifyEqual(actualAccountNumber, accountNumber,
				"ECS069: Verification of newly created account number : " + accountNumber
				+ " on Customer Detail Page under Accounts tab is successful.");
	}

	@Test(description = "Verify WMI window open and displayed currect customer information for Add Customer Service Case "
			+ "and Add Customer Complain for Organization")
	public void ECS070_ECS071_ValidateCustomerInfoForAddServiceCaseAndAddCustomerComplainForOrganizationInWMI() {
		String tinNumber = new CommonUtil().getSSN();
		String firstName = "ECS07071";
		String lastName = "AutoLN";
		
		String serviceCaseType = "Online Banking Issue";
		
		String createdBy = "admin_SavEE_QA_Automation";
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		String organizationName = "TestOrg"+tinNumber;
		customerSearchPage = loginPage.doLogin();
		customerSearchPage.clickOnSearchTypeDownArrow("Search Consumer").clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(organizationName).clickOnSearchButton();
		if (customerSearchPage.getSearchMessage().contains("No results")) {
			ecsAPIs.createOrganizationAPI(baseUrl, organizationName);
			customerSearchPage.enterOrganizationName(organizationName).clickOnAccountSearchButton();
			
		}
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Name", "1");
		
		addRelatedParties = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add & Modify Customer Related Party")
				.getAddRelatedPartiesPage()
				.selectRequestParty(1)
				.selectCustomerRelationshipTypeFromDropdown("Authorized Signer")
				.selectPartyRelationTypeDescription("Authorized Signer")
				.enterFirstNameForAddCustomerRelatedParty(firstName)
				.enterLastNameForAddCustomerRelatedParty(lastName)
				.clickOnSearch()
				.selectSearchParty(firstName)
				.clickOnSubmitBtn();
		customerDetail= addRelatedParties.getCustomerDetailPage().refreshPage();
				
		wmiScreen = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Service Case")
				.selectParty(firstName).getCustomerDetailPage()
				.selectServiceCase(serviceCaseType).getCommonWidget()
				.clickOnSubmitBtn();
		String actualCaseType = wmiScreen.getCaseTypeText();
		AssertionUtil.verifyEqual(actualCaseType, serviceCaseType,
				"ECS070 : Verification of service case type " + actualCaseType + " is successful");
		String createdDateText = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(2).split(":")[1].trim();
		String actualCreatedDate = createdDateText.split(" ")[0];
		String actualCreatedBy = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(2).split("by")[1].trim();
		String actualCaseStatus = wmiScreen.getSpecificLineTextUnderGeneralCaseInformationValue(5).split(":")[1].trim();
		AssertionUtil.verifyContainsText(actualCreatedDate, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS070 : Verification of Created Date: " + actualCreatedDate
						+ " available under General Case Information");
		AssertionUtil.verifyEqual(actualCreatedBy, createdBy, "ECS070 : Verification of Created By: " + actualCreatedBy
				+ " available under General Case Information");
		AssertionUtil.verifyEqual(actualCaseStatus, "New", "ECS070 : Verification of Case Status Value: "
				+ actualCaseStatus + " available under General Case Information");
		
		customerDetail = wmiScreen.clickOnCloseWindowLink().getCommonWidgetPage().getCustomerDetailPage();
		addComplaintScreen = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Complaint")
				.selectParty(firstName).getAddComplaintScreen();
		addComplaintScreen.selectComplaintOptions("ComplaintSource", "Consumer")
				.selectComplaintOptions("OriginInput", "Back Office")
				.selectComplaintOptions("ProductLine", "Money transfer")
				.selectComplaintOptions("ProductType", "International money transfer")
				.selectComplaintOptions("IssueType", "Transaction issue")
				.selectComplaintOptions("Company", "Demo Company.").enterTransferAmount("Automation Test");
		customerDetail = addComplaintScreen.clickOnSubmitButton();
		String popupMessageForComplaint = customerDetail.getPopUpMessage(10);
		String caseNumber = popupMessageForComplaint.split(" ")[6];
		customerDetail.clickOnMoreLink()
				.clickOnSubLinkOfMore("Cases");
				
		String closedCasesTableCaseTypeValue = customerDetail.getValueFromTable("OpenCases", "Case Type", 1);
		
		String closedCasesTableCreatedDateValue = customerDetail.getValueFromTable("OpenCases", "Created Date",
						1);
		String closedCasesTableStatusValue = customerDetail.getValueFromTable("OpenCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "CMS Complaint",
				"ECS071 : Verification of Case Type Value in Open Cases Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(closedCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS071 : Verification of Created Date Value in Open Cases Table for Add Order Transaction in Loan Account");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "New",
				"ECS071 : Verification of Status Value in Open Cases  Table for Add Order Transaction in Loan Account");		
		
		wmiScreen =	customerDetail.clickOnOpenCaseDocId(caseNumber);
		
		String actualSelectedProductType = wmiScreen.getSelectedOptionDisplayedFromDropDown("Product Type");
		AssertionUtil.verifyEqual(actualSelectedProductType, "International money transfer",
				"ECS071 : Verification of product type " + actualSelectedProductType
						+ " in WMI screen is selected successfuly");
		String actualSelectedIssueType = wmiScreen.getSelectedOptionDisplayedFromDropDown("Issue Type");
		AssertionUtil.verifyEqual(actualSelectedIssueType, "Transaction issue", "ECS071 : Verification of Issue type "
				+ actualSelectedIssueType + " in WMI screen is selected successfuly");
		String actualSelectedOrigin = wmiScreen.getSelectedOptionDisplayedFromDropDown("Origin");
		AssertionUtil.verifyEqual(actualSelectedOrigin, "Back Office", "ECS071 : Verification of selected origin "
				+ actualSelectedOrigin + " in WMI screen is selected successfuly");
		
	}
	
	@Test(description = "Verify Organization PaymentOrder under $1000 "
			+ "info under Order tab and Open cases info under More tab for Organization")
	public void ECS072_ValidateOrganizationPaymentOrder() {
		
		String firstName = "ECSTest072";
		String lastName = "AutoLN";
		String addRelatedConsumerFN = "TestConsumerFN";
		String routingNumber ="122105155";
		String tinNumber = new CommonUtil().getSSN();
		String amount = "10500.00";
		String transactionCode = "Savings Deposit Cash";
		String transferAmount ="800";
		String orderType = "Payment order";
		
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		com.qa.ecs.pojo.response.CreateConsumer consumerData1 = ecsAPIs.createConsumerIfNotExists(baseUrl, addRelatedConsumerFN,
				lastName);
		String organizationName = "TestOrg"+tinNumber;
		customerSearchPage = loginPage.doLogin();
		customerSearchPage.clickOnSearchTypeDownArrow("Search Consumer").clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(organizationName).clickOnSearchButton();
		if (customerSearchPage.getSearchMessage().contains("No results")) {
			ecsAPIs.createOrganizationAPI(baseUrl, organizationName);
			customerSearchPage.enterOrganizationName(organizationName).clickOnAccountSearchButton();
			
		}
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Name", "1");
		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount()
				.clickOnNextButton().selectAccountOwnership("23 - Corporation")
				.selectAccountRelationshipType("Corporation").clickOnAdditionalRelatedParty()
				.selectAccountRelationshipTypeForAddRelatedParty("Beneficial Owner")
				.enterFirstNameForAddAccountRelatedParty(addRelatedConsumerFN)
				.enterLastNameForAddAccountRelatedParty(lastName).clickOnSearch()
				.selectSearchResultForAddRelatedParty(1)
				.clickOnAddParty()
				.clickOnNextButton()
				.selectAccountGroup("Banking").selectProductType("Interest Checking (C2001 - DDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		customerDetail = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().wait(1).clickOnSubmitButton()
				.wait(1);
		
		accountDetailTabScreen= customerDetail.clickOnText(accountNumber);
		accountDetailTabScreen.getCommonWidget()
		.postTransaction(transactionCode, amount, 10).wait(10).getCommonWidget()
		.addOrderForSelectedParty(addRelatedConsumerFN, orderType, routingNumber, "Savings", "0000001256", "Savings deposit account", transferAmount);
		
		accountDetailTabScreen.refreshPage().wait(20).clickOnTab("Orders").wait(2);

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType, "ECS072 : Verification of Order Type : "
				+ orderType + " in Orders Table for Payment Order");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, "800.00", "ECS072 : Verification of Order Amount: "
				+ transferAmount + " in Orders Table for Payment Order");
		
		AssertionUtil.verifyEqual(orderTableStatusValue, "In Process", "ECS072 : Verification of Status " 
				+ orderTableStatusValue + " in Orders Table for Payment Order");
		
		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
		.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableCreatedDateValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Created Date",
				1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Outbound Funds Transfer ACH",
				"ECS072 : Verification of Case Type :"+closedCasesTableCaseTypeValue+" in Closed Cases Table for Payment Order is successful");

		AssertionUtil.verifyEqual(closedCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS072 : Verification of Created Date: "+closedCasesTableCreatedDateValue+" in Closed Cases Table for Payment Order is successful");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS072 : Verification of Status Value: 'Closed' in Closed Cases Table for Payment Order is successful");
			 
	}
	
	@Test(description = "Verify Organization Collection Order under $2000 "
			+ "info under Order tab and Open cases info under More tab for Organization")
	public void ECS073_ValidateOrganizationCollectionOrder() {
		
		String firstName = "ECSTest073";
		String lastName = "AutoLN";
		String addRelatedConsumerFN = "TestConsumerFN";
		String routingNumber ="043000096";
		String tinNumber = new CommonUtil().getSSN();
		String amount = "12500.00";
		String transactionCode = "Savings Deposit Cash";
		String transferAmount ="1200";
		String orderType = "Collection order";
				
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		com.qa.ecs.pojo.response.CreateConsumer consumerData1 = ecsAPIs.createConsumerIfNotExists(baseUrl, addRelatedConsumerFN,
				lastName);
		String organizationName = "TestOrg"+tinNumber;
		
		customerSearchPage = loginPage.doLogin();
		customerSearchPage.clickOnSearchTypeDownArrow("Search Consumer").clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(organizationName).clickOnSearchButton();
		if (customerSearchPage.getSearchMessage().contains("No results")) {
			ecsAPIs.createOrganizationAPI(baseUrl, organizationName);
			customerSearchPage.enterOrganizationName(organizationName).clickOnAccountSearchButton();
			
		}
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Name", "1");
		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount()
				.clickOnNextButton().selectAccountOwnership("23 - Corporation")
				.selectAccountRelationshipType("Corporation").clickOnAdditionalRelatedParty()
				.selectAccountRelationshipTypeForAddRelatedParty("Beneficial Owner")
				.enterFirstNameForAddAccountRelatedParty(addRelatedConsumerFN)
				.enterLastNameForAddAccountRelatedParty(lastName).clickOnSearch()
				.selectSearchResultForAddRelatedParty(1)
				.clickOnAddParty()
				.clickOnNextButton()
				.selectAccountGroup("Banking").selectProductType("Interest Checking (C2001 - DDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		customerDetail = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().wait(1).clickOnSubmitButton()
				.wait(1);
		
		accountDetailTabScreen= customerDetail.clickOnText(accountNumber);
		accountDetailTabScreen.getCommonWidget()
		.postTransaction(transactionCode, amount, 10).wait(10).getCommonWidget()
		.addOrderForSelectedParty(addRelatedConsumerFN, orderType, routingNumber, "Savings", "0000001256", "Savings deposit account", transferAmount);
		
		accountDetailTabScreen.refreshPage().wait(20).clickOnTab("Orders").wait(2);

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType, "ECS073 : Verification of Order Type : "
				+ orderType + " in Orders Table is successful");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, "1,200.00", "ECS073 : Verification of Order Amount: "
				+ transferAmount + " in Orders Table for Collection Order is successful.");
		
		AssertionUtil.verifyEqual(orderTableStatusValue, "In Process", "ECS073 : Verification of Status " 
				+ orderTableStatusValue + " in Orders Table for Collection Order is successful");
		
		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
		.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableCreatedDateValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Created Date",
				1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Inbound ACH Collection Order",
				"ECS073 : Verification of Case Type :"+closedCasesTableCaseTypeValue+" Closed Cases Table for add Collection Order is successful");

		AssertionUtil.verifyEqual(closedCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS073 : Verification of Created Date Value in Closed Cases Table for Collection Order is successful");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS073 : Verification of Status Value in Closed Cases Table for Collection Order is successful");
			 
	}
	
	@Test(description = "Verify info under Order tab and Open cases info under More tab for Organization"
			+ "after create Organization PaymentOrder under $1000 "
			+ "")
	public void ECS074_ValidateOrganizationPaymentOrderForFutureDate() {
		
		String firstName = "ECSTest074";
		String lastName = "AutoLN";
		String addRelatedConsumerFN = "TestConsumerFN";
		String routingNumber ="122105155";
		String tinNumber = new CommonUtil().getSSN();
		String amount = "12500.00";
		String transactionCode = "Savings Deposit Cash";
		String transferDate = new CommonUtil().getDateTime(3, "MM/dd/yyyy");
		String transferAmount ="500";
		String orderType = "Payment order";
			
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		com.qa.ecs.pojo.response.CreateConsumer consumerData1 = ecsAPIs.createConsumerIfNotExists(baseUrl, addRelatedConsumerFN,
				lastName);
		//String organizationName = "TestOrg"+tinNumber;
		String organizationName = "TestOrg408152720";
		System.out.println(organizationName);
		customerSearchPage = loginPage.doLogin();
		customerSearchPage.clickOnSearchTypeDownArrow("Search Consumer").clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(organizationName).clickOnSearchButton();
		if (customerSearchPage.getSearchMessage().contains("No results")) {
			ecsAPIs.createOrganizationAPI(baseUrl, organizationName);
			customerSearchPage.enterOrganizationName(organizationName).clickOnAccountSearchButton();
		}
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Name", "1");
		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount()
				.clickOnNextButton().selectAccountOwnership("23 - Corporation")
				.selectAccountRelationshipType("Corporation").clickOnAdditionalRelatedParty()
				.selectAccountRelationshipTypeForAddRelatedParty("Beneficial Owner")
				.enterFirstNameForAddAccountRelatedParty(addRelatedConsumerFN)
				.enterLastNameForAddAccountRelatedParty(lastName).clickOnSearch()
				.selectSearchResultForAddRelatedParty(1)
				.clickOnAddParty()
				.clickOnNextButton()
				.selectAccountGroup("Banking").selectProductType("Interest Checking (C2001 - DDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		customerDetail = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().wait(1).clickOnSubmitButton()
				.wait(1);
		
		accountDetailTabScreen= customerDetail.clickOnText(accountNumber);
		accountDetailTabScreen.getCommonWidget()
		.postTransaction(transactionCode, amount, 10).wait(10).getCommonWidget()
		.addOrderForSelectedParty(addRelatedConsumerFN, orderType, routingNumber, "Savings", "0000004253", "Savings deposit account", transferDate, transferAmount);
		
		accountDetailTabScreen.refreshPage().wait(20).clickOnTab("Orders").wait(2);

		String orderTableOrderTypeValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Type", 1);
		String orderTableOrderAmountValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatusValue = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderTypeValue, orderType, "ECS074 : Verification of Order Type : "
				+ orderType + " in Orders Table for Payment Order for future date is successful.");

		AssertionUtil.verifyEqual(orderTableOrderAmountValue, "500.00", "ECS074 : Verification of Order Amount: "
				+ transferAmount + " in Orders Table for Payment Order for future date is successful.");
		
		AssertionUtil.verifyEqual(orderTableStatusValue, "Verified", "ECS074 : Verification of Status " 
				+ orderTableStatusValue + " in Orders Table for Payment Order for future date is successful.");
		
		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
		.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		String closedCasesTableCreatedDateValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Created Date",
				1);
		String closedCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeValue, "Outbound Funds Transfer ACH",
				"ECS074 : Verification of Case Type :"+closedCasesTableCaseTypeValue+" in Closed Cases Table for Payment Order for future date is successful.");

		AssertionUtil.verifyEqual(closedCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"ECS074 : Verification of Created Date: "+closedCasesTableCreatedDateValue+" in Closed Cases Table for Payment Order for future date is successful.");

		AssertionUtil.verifyEqual(closedCasesTableStatusValue, "Closed",
				"ECS074 : Verification of Status Value: 'Closed' in Closed Cases Table for Payment Order for future date is successful.");
		
	}
	
	@Test(description = "Verify info under Order tab and Open cases info under More tab for Organization"
			+ "after create PaymentOrder greater than $1000 modify order amount and date and cancel Payment order")
	public void ECS075_ECS076_ValidateOrganizationModifiedPaymentOrderAndCancelOrder() {
		
		String firstName = "ECSTest075";
		String lastName = "AutoLN";
		String addRelatedConsumerFN = "TestConsumerFN";
		String routingNumber ="122105155";
		String tinNumber = new CommonUtil().getSSN();
		String amount = "12500.00";
		String transactionCode = "Savings Deposit Cash";
		String modifiedTransferDate = new CommonUtil().getDateTime(3, "MM/dd/yyyy");
		String orderAmount ="1200";
		String modifiedAmount ="3500";
		String orderType = "Payment order";
			
		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl, firstName,
				lastName);
		com.qa.ecs.pojo.response.CreateConsumer consumerData1 = ecsAPIs.createConsumerIfNotExists(baseUrl, addRelatedConsumerFN,
				lastName);
		String organizationName = "TestOrg75";
		System.out.println(organizationName);
		customerSearchPage = loginPage.doLogin();
		customerSearchPage.clickOnSearchTypeDownArrow("Search Consumer").clickOnConsumerSearchOption("Organization")
				.enterOrganizationName(organizationName).clickOnSearchButton();
		if (customerSearchPage.getSearchMessage().contains("No results")) {
			ecsAPIs.createOrganizationAPI(baseUrl, organizationName);
			customerSearchPage.enterOrganizationName(organizationName).clickOnAccountSearchButton();
		}
		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Name", "1");
		positionDetails = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount()
				.clickOnNextButton().selectAccountOwnership("23 - Corporation")
				.selectAccountRelationshipType("Corporation").clickOnAdditionalRelatedParty()
				.selectAccountRelationshipTypeForAddRelatedParty("Beneficial Owner")
				.enterFirstNameForAddAccountRelatedParty(addRelatedConsumerFN)
				.enterLastNameForAddAccountRelatedParty(lastName).clickOnSearch()
				.selectSearchResultForAddRelatedParty(1)
				.clickOnAddParty()
				.clickOnNextButton()
				.selectAccountGroup("Banking").selectProductType("Interest Checking (C2001 - DDA)", 2);

		String accountNumber = positionDetails.getAccountNumber();

		customerDetail = positionDetails.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton().wait(1).clickOnSubmitButton()
				.wait(1);
		
		accountDetailTabScreen= customerDetail.clickOnText(accountNumber);
		accountDetailTabScreen.getCommonWidget()
		.postTransaction(transactionCode, amount, 10).wait(10).getCommonWidget()
		.addOrderForSelectedParty(addRelatedConsumerFN, orderType, routingNumber, "Savings", "0000004253", "Savings deposit account", orderAmount);
		
		accountDetailTabScreen.refreshPage().wait(10).clickOnTab("Orders").wait(2)
		                     .clickOnThreeDotIconInTable("Orders")
		                     .clickOnLinkByJS("Modify Order")
		                     .getCommonWidget().getAddOrderScreen()
		                     .enterTransferDate(modifiedTransferDate).wait(10)
		                     //.enterTransferAmount(modifiedAmount).wait(10)
		                     .clickOnSubmitButton().wait(2)
		                     .clickOnConfirmButton().wait(5);
		
		String OrderModifiedMessage = accountDetailTabScreen.getPopUpMessage(20);
		AssertionUtil.verifyContainsText(OrderModifiedMessage, "Order modified successfully.",
						"ECS075 : Verification of Hold created popup message: '" + OrderModifiedMessage + "' is successful.");
		accountDetailTabScreen.wait(10);

		String orderTableOrderDate = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Date", 1).trim();
		String orderTableOrderAmount = accountDetailTabScreen.getValueFromTable("OrdersTable", "Order Amount", 1);
		String orderTableStatus = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableOrderDate, modifiedTransferDate, "ECS075 : Verification of modified Order date: "
				+ orderType + " in Orders Table for Payment Order is successful.");

		//AssertionUtil.verifyEqual(orderTableOrderAmount, "2,000.00", "ECS075 : Verification of Order Amount after modify : "
				//+ orderAmount + " in Orders Table for Payment Order is successful.");
		
		AssertionUtil.verifyEqual(orderTableStatus, "Entered", "ECS075 : Verification of Status " 
				+ orderTableStatus + " in Orders Table for Payment Order after modify order is successful.");
		
		//****************Cancel order********************************/
		accountDetailTabScreen.refreshPage().wait(10).clickOnTab("Orders").wait(10)
		.clickOnThreeDotIconInTable("Orders").clickOnLinkByJS("Cancel Order").wait(3)
		.getCommonWidget().getAddOrderScreen().clickOnSubmitButton().wait(1);
		
		String orderCancelMessage = accountDetailTabScreen.getPopUpMessage(20);
		
		AssertionUtil.verifyContainsText(orderCancelMessage, "Order canceled.",
				"ECS076 : Verification of order cancel popup message: '" + orderCancelMessage + "' is successful.");		
				
		String orderTableStatusAfterCancel = accountDetailTabScreen.getValueFromTable("OrdersTable", "Status", 1);

		AssertionUtil.verifyEqual(orderTableStatusAfterCancel, "Canceled", "ECS076 : Verification of Status " 
				+ orderTableStatusAfterCancel + " in Orders Table for Payment Order after cancel order is successful.");
		
		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases")
		.clickOnOverViewDisplayedTextLink("Closed Cases");

		String closedCasesTableCaseTypeAfterCancel = accountDetailTabScreen.getValueFromTable("ClosedCases", "Case Type", 1);
		
		String closedCasesTableStatusAfterCancel = accountDetailTabScreen.getValueFromTable("ClosedCases", "Status", 1);

		AssertionUtil.verifyEqual(closedCasesTableCaseTypeAfterCancel, "Outbound Funds Transfer ACH",
				"ECS076 : Verification of Case Type : "+closedCasesTableCaseTypeAfterCancel+" in Closed Cases Table for Payment Order for future date is successful.");

		AssertionUtil.verifyEqual(closedCasesTableStatusAfterCancel, "Closed",
				"ECS076 : Verification of Status Value: 'Closed' in Closed Cases Table for Payment Order for future date is successful.");
	
	}
	
	@Test(description = "Verify customer contact even added")
	public void ECS077_ECS078_ValidateAddCustomerContactEvent() throws AWTException {

		String consumerFirstName = "AutoTest04";
		String consumerLastName = new CommonUtil().getSSN();

		ecsAPIs.createConsumerIfNotExists(baseUrl, consumerFirstName, consumerLastName);

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", consumerFirstName)
				.enterSearchTextForSearch("LastName", consumerLastName).clickOnSearchButton();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");

		addCustomerContactEventScreen = customerDetail.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnCustomerTaskLinkText("Add Customer Contact Event").getAddCustomerContactEventScreen();

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getOriginDropdownLabel(), "Origin",
				"ECS077 : Verification of Origin dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getTopicDropdownLabel(), "Topic",
				"ECS077 : Verification of Topic dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getSubTopicDropdownLabel(), "Subtopic",
				"ECS077 : Verification of SubTopic dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getCustomerIDTextfieldLabel(), "Customer ID",
				"ECS077 : Verification of CustomerID textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPartyIDTextfieldLabel(), "Party ID",
				"ECS077 : Verification of PartyID textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPartyGroupIDTextfieldLabel(), "Party Group ID",
				"ECS077 : Verification of PartyGroupID textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getAccountNumberDropdownLabel(), "Account Number",
				"ECS077 : Verification of AccountNumber dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPositionAccountNumberDropdownLabel(),
				"Position Account Number",
				"ECS077 : Verification of PositionAccountNumber dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPlatformDropdownLabel(), "Platform",
				"ECS077 : Verification of Platform dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getMessageTextfieldLabel(), "Message",
				"ECS077 : Verification of Message textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.isCancelButtonExists(), true,
				"ECS077 : Verification of existence of Cancel button is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.isSubmitButtonExists(), true,
				"ECS077 : Verification of existence of Submit button is successful");

		customerDetail = addCustomerContactEventScreen.selectOrigin("Back Office").selectTopic("Customer Services")
				.selectSubTopic("Add Related Party").enterMessage("Customer", "Add Customer Contact Event automation test").clickOnSubmitButton();

		String feedbackMessage = customerDetail.getFeedbackMessage();

		AssertionUtil.verifyEqual(feedbackMessage.split(":")[0].trim(), "Message sent successfully. Contact Event ID",
				"ECS077 : Verification of Feedback Message");

		customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Contact Events");

		String topicValue = customerDetail.getValueFromResultTable("Active Message Events", "Topic", 0);
		String subtopicValue = customerDetail.getValueFromResultTable("Active Message Events", "SubTopic", 0);
		String statusValue = customerDetail.getValueFromResultTable("Active Message Events", "Status", 0);
		String createdByValue = customerDetail.getValueFromResultTable("Active Message Events", "Created By", 0);
		String originValue = customerDetail.getValueFromResultTable("Active Message Events", "Origin", 0);

		AssertionUtil.verifyEqual(topicValue, "Customer Services",
				"ECS078 : Verification of Topic value for Active Message Events table");

		AssertionUtil.verifyEqual(subtopicValue, "Add Related Party",
				"ECS078 : Verification of Sub Topic value for Active Message Events table");

		AssertionUtil.verifyEqual(statusValue, "New",
				"ECS078 : Verification of Status value for Active Message Events table");

		AssertionUtil.verifyEqual(createdByValue, "admin_SavEE_QA_Automation",
				"ECS078 : Verification of Created By value for Active Message Events table");

		AssertionUtil.verifyEqual(originValue, "Back Office",
				"ECS078 : Verification of Origin value for Active Message Events table");

	}
	
	@Test(description = "Verify customer account contact even added")
	public void ECS079_ECS080_ECS081_ECS082_ValidateAddCustomerAccountContactEvent() throws AWTException {

		String consumerFirstName = "ECS081";
		String consumerLastName = "AutoLN";
		int initialAccountBalance = 4000;

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber);
				
		addCustomerContactEventScreen = accountDetailTabScreen.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnTaskLinkText("Add Account Contact Event").getAddCustomerContactEventScreen();

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getOriginDropdownLabel(), "Origin",
				"ECS081 : Verification of Origin dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getTopicDropdownLabel(), "Topic",
				"ECS081 : Verification of Topic dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getSubTopicDropdownLabel(), "Subtopic",
				"ECS081 : Verification of SubTopic dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getCustomerIDTextfieldLabel(), "Customer ID",
				"ECS081 : Verification of CustomerID textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPartyIDTextfieldLabel(), "Party ID",
				"ECS081 : Verification of PartyID textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPartyGroupIDTextfieldLabel(), "Party Group ID",
				"ECS081 : Verification of PartyGroupID textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getAccountNumberDropdownLabel(), "Account Number",
				"ECS081 : Verification of AccountNumber dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPositionAccountNumberDropdownLabel(),
				"Position Account Number",
				"ECS081 : Verification of PositionAccountNumber dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getPlatformDropdownLabel(), "Platform",
				"ECS081 : Verification of Platform dropdown label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.getMessageTextfieldLabel(), "Message",
				"ECS081 : Verification of Message textfield label is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.isCancelButtonExists(), true,
				"ECS081 : Verification of existence of Cancel button is successful");

		AssertionUtil.verifyEqual(addCustomerContactEventScreen.isSubmitButtonExists(), true,
				"ECS081 : Verification of existence of Submit button is successful");

		customerDetail = addCustomerContactEventScreen.selectOrigin("Back Office").selectTopic("Deposit Accounts Services")
				.selectSubTopic("Checking & Savings").enterMessage("Account","Automation Test").clickOnSubmitButton();

		String feedbackMessage = customerDetail.getFeedbackMessage();

		AssertionUtil.verifyEqual(feedbackMessage.split(":")[0].trim(), "Message sent successfully. Contact Event ID",
				"ECS082 : Verification of Feedback Message");

		customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Contact Events");

		String topicValue = customerDetail.getValueFromResultTable("Active Message Events", "Topic", 0);
		String subtopicValue = customerDetail.getValueFromResultTable("Active Message Events", "SubTopic", 0);
		String statusValue = customerDetail.getValueFromResultTable("Active Message Events", "Status", 0);
		String createdByValue = customerDetail.getValueFromResultTable("Active Message Events", "Created By", 0);
		String originValue = customerDetail.getValueFromResultTable("Active Message Events", "Origin", 0);
		String contactEventID = customerDetail.getValueFromResultTable("Active Message Events", "Contact Event ID", 0);

		AssertionUtil.verifyEqual(topicValue, "Deposit Accounts Services",
				"ECS082 : Verification of Topic value for Active Message Events table");

		AssertionUtil.verifyEqual(subtopicValue, "Checking & Savings",
				"ECS082 : Verification of Sub Topic value for Active Message Events table");

		AssertionUtil.verifyEqual(statusValue, "New",
				"ECS082 : Verification of Status value for Active Message Events table");

		AssertionUtil.verifyEqual(createdByValue, "admin_SavEE_QA_Automation",
				"ECS082 : Verification of Created By value for Active Message Events table");

		AssertionUtil.verifyEqual(originValue, "Back Office",
				"ECS082 : Verification of Origin value for Active Message Events table");

		String expectedContactEventID = feedbackMessage.split(":")[1].trim();
		AssertionUtil.verifyEqual(contactEventID, expectedContactEventID,
				"ECS082 : Verification of contact event Id : "+contactEventID+" for Active Message Events table is successful");
	}
	@Test(description = "Verify of Work Flow Search filter by adding case number and verify case info")
	public void ECS086_ECS087_ECS088_verifyWorkflowSearch() {

		workflowPage = loginPage.doLogin()
		.getCommonWidget().clickOnWorkflowIcon().clickOnSelectProcessDropdown()
		.clickOnSelectProcessValue("Account Servicing").clickOnActivity("Approval");
		
		String expectedCaseNumber = workflowPage.getCaseNumber(2);
		
		workflowPage.clickOnFilterIcon().wait(15);
		
		AssertionUtil.verifyEqual(workflowPage.isLabelOfEnterSearchCriteriaPopupExist("Created Date"), true,
				"ECS086 : Verification of Created Date label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(workflowPage.isLabelOfEnterSearchCriteriaPopupExist("Customer ID"), true,
				"ECS086 : Verification of Customer ID label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(workflowPage.isLabelOfEnterSearchCriteriaPopupExist("Account Number"), true,
				"ECS086 : Verification of Account Number label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(workflowPage.isLabelOfEnterSearchCriteriaPopupExist("Case Type"), true,
				"ECS086 : Verification of Case Type label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(workflowPage.isLabelOfEnterSearchCriteriaPopupExist("Case Number"), true,
				"ECS086 : Verification of Case Number label in Enter Search Criteria Popup");
		
		workflowPage.enterCaseNumberInEnterSearchCriteriaPopup(expectedCaseNumber).clickOnSearchButtonInEnterSearchCriteriaPopup();
		
		String actualCaseNumber = workflowPage.getCaseNumber(1);
		
		AssertionUtil.verifyEqual(expectedCaseNumber, actualCaseNumber,
				"ECS088 : Verification of Filter Case Number");		

	}
	@Test(description = "Verify of Vault Search popup window and filter by status and verify info in search result table")
	public void ECS089_ECS090_verifyVaultSearch() {

		vaultPage = loginPage.doLogin()
					.getCommonWidget().clickOnVaultIcon().clickOnSelectDropdown("Select Repository")
					.clickOnDropdownOption("Account Servicing").wait(5)
					.clickOnSelectDropdown("Select Search Class")
					.clickOnDropdownOption("All Account Servicing Cases").wait(5);
		commonWidget = vaultPage.getCommonWidget();
		String expectedStatus = "New";
		String enterSearchHeadLabel= commonWidget.getEnterSearchCriteriaHeadLabel();
		AssertionUtil.verifyEqual(enterSearchHeadLabel, "Enter Search Criteria", 
				"ECS089: Verification of Search criteria window HeadLabel: '"+enterSearchHeadLabel+"' is successful");
		
		AssertionUtil.verifyEqual(commonWidget.isLabelOfEnterSearchCriteriaPopupExist("Created Date"), true,
				"ECS090 : Verification of Created Date label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(commonWidget.isLabelOfEnterSearchCriteriaPopupExist("Customer ID"), true,
				"ECS090 : Verification of Customer ID label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(commonWidget.isLabelOfEnterSearchCriteriaPopupExist("Account Number"), true,
				"ECS090 : Verification of Account Number label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(commonWidget.isLabelOfEnterSearchCriteriaPopupExist("Case Type"), true,
				"ECS090 : Verification of Case Type label in Enter Search Criteria Popup");
		
		AssertionUtil.verifyEqual(commonWidget.isLabelOfEnterSearchCriteriaPopupExist("Case Number"), true,
				"ECS090 : Verification of Case Number label in Enter Search Criteria Popup");
		
		commonWidget.selectSatus("New").clickOnSearchButtonInEnterSearchCriteriaPopup().wait(5);
		
		String actualStatus = commonWidget.getSeachResultColumnValueByRow("status", 1);
		AssertionUtil.verifyEqual(actualStatus, expectedStatus,
				"ECS090 : Verification of search result status value: "+actualStatus+" is successful");
		
		}
	
	@Test(description = "Verify customer complain added")
	public void ECS090_ECS091_ECS092_ECS093_ValidateAddCustomerComplain() throws AWTException {

		String consumerFirstName = "AutoTest03";
		String consumerLastName = new CommonUtil().getSSN();

		com.qa.ecs.pojo.response.CreateConsumer consumerData = ecsAPIs.createConsumerIfNotExists(baseUrl,
				consumerFirstName, consumerLastName);

		customerSearchPage = loginPage.doLogin().enterSearchTextForSearch("FirstName", consumerFirstName)
				.enterSearchTextForSearch("LastName", consumerLastName).clickOnSearchButton();

		customerDetail = customerSearchPage.clickOnValueFromSearchResultTable("Last Name", "1");

		AssertionUtil.verifyEqual(customerDetail.isAddIconDisplayed("Primary Identification"), true,
				"ECS091 : Verification of existence of Add Icon for Primary Identification label is successful");

		AssertionUtil.verifyEqual(customerDetail.isEyeIconDisplayed("Primary Identification"), false,
				"ECS091 : Verification of existence of Eye Icon for Primary Identification label is successful");

		AssertionUtil.verifyEqual(customerDetail.isAddIconDisplayed("Signature Card"), true,
				"ECS091 : Verification of existence of Add Icon for Signature Card label is successful");

		AssertionUtil.verifyEqual(customerDetail.isEyeIconDisplayed("Signature Card"), false,
				"ECS091 : Verification of existence of Eye Icon for Signature Card label is successful");

		customerDetail.clickOnAddIconForLabel("Primary Identification").wait(10).uploadFile("downloaded.jpg")
				.selectDocumentOptions("Document Class", "Identification").wait(10)
				.selectDocumentOptions("Document Type", "Identity Card").clickOnSubmitButton();

		String expectedSuccessMessage = "Document uploaded successfully.";
		String actualSuccessMessage = customerDetail.getPopUpMessage(10);
		AssertionUtil.verifyEqual(actualSuccessMessage, expectedSuccessMessage,
				"ECS092 : Verification of document uploaded popup message is successful");

		customerDetail.wait(10);

		AssertionUtil.verifyEqual(customerDetail.isAddIconDisplayed("Primary Identification"), false,
				"ECS093: Verification of existence of Add Icon for Primary Identification label is successful");

		AssertionUtil.verifyEqual(customerDetail.isEyeIconDisplayed("Primary Identification"), true,
				"ECS093 : Verification of existence of Eye Icon for Primary Identification label is successful");

		customerDetail.clickOnAddIconForLabel("Signature Card").wait(10).uploadFile("downloaded.jpg")
				.clickOnSubmitButton();

		actualSuccessMessage = customerDetail.getPopUpMessage(10);
		AssertionUtil.verifyEqual(actualSuccessMessage, expectedSuccessMessage,
				"ECS093 : Verification of document uploaded popup message is successful");
		customerDetail.wait(10);

		AssertionUtil.verifyEqual(customerDetail.isAddIconDisplayed("Signature Card"), false,
				"ECS094 : Verification of existence of Add Icon for Signature Card label is successful");

		AssertionUtil.verifyEqual(customerDetail.isEyeIconDisplayed("Signature Card"), true,
				"ECS094 : Verification of existence of Eye Icon for Signature Card label is successful");

	}
	@Test(description = "Verify Collateral Description in Linked Collateral Details table")
	public void ECS095_ECS112_ValidateCollateralDescription() {

		String firstName = "FirstNameECS010";
		String lastName =  new CommonUtil().getSSN();
		String collateralDescription = "AutoTest";
		
		String expectedOriginalValue = "50,000.00";
		String expectedCurrentValue = "30,000.00";
		String expectedAddressLine1 = "Park Avenue";
		String expectedCity = "Hudson";
		String expectedPostalCode = "10001";
		String expectedModel = "Model 200";
		String expectedColor = "White";
		String expectedVehicleType = "Regular four door";
		String expectedPolicyNumber = "123123456";
		String expectedPolicyDescription = "Test Desc";
		String expectedCoverageAmount = "200.00";
		String expectedPremiumAmount = "500.00";
		String expectedInsuranceCompany = "Tata";
		String expectedLienPosition = "1";
		String expectedFinancialInstitution = "TD bank";
		String expectedAccountNumber = "2039423300";
		String expectedCreditLimit = "25,000.00";
		String expectedMonthlyPaymentAmount = "560.00";
		String updatedOriginalValue = "40,000.00";
		String updatedPostalCode = "10002";
		String updatedModel = "Model 500";
		String updatedCoverageAmount = "300.00";
		
		ecsAPIs.createConsumerIfNotExists(baseUrl, firstName, lastName);
		
		customerDetail = loginPage.doLogin()
							 .enterSearchTextForSearch("FirstName", firstName)
							 .enterSearchTextForSearch("LastName", lastName)
							 .clickOnSearchButton()
							 .clickOnValueFromSearchResultTable("Last Name", "1");

		accountDetailTabScreen = customerDetail.clickOnAccountsLink().clickOnPlusIconForAddAccount().clickOnNextButton()
				.selectAccountRelationshipType("Primary").enterDescription("Test for automation").clickOnNextButton()
				.selectAccountGroup("Banking").selectProductType("Installment Personal Loan (LN - ILA)", 2)
				.enterCreditLimit("25000").clickOnAddCollateralCheckbox()				
				.selectDepartmentId("350 - Deposits", 2).selectVertical("Vertical 01", 2)
				.clickOnNextButton()
				.getCollateralDescriptionScreen()
				.enterCollateralRecordDescription(collateralDescription).clickOnNextButton()				
				.enterLienPosition(expectedLienPosition).enterFinancialInstitution(expectedFinancialInstitution)
				.enterAccountNumber(expectedAccountNumber)
				.enterCreditLimit(expectedCreditLimit).enterMonthlyPaymentAmount(expectedMonthlyPaymentAmount)
				.clickOnNextButton()
				.selectCollateralType("Vehicle").wait(5)
				.enterCollateralDescription("Ford")
				.enterOriginalValue(expectedOriginalValue)
				.enterCurrentValue(expectedCurrentValue)
				.enterModel(expectedModel)
				.enterColor(expectedColor).selectVehicleType(expectedVehicleType)
				.enterPolicyNumber(expectedPolicyNumber).enterPolicyDescription(expectedPolicyDescription)
				.enterPremiumAmount(expectedPremiumAmount).enterCoverageAmount(expectedCoverageAmount)
				.enterInsuranceCompany(expectedInsuranceCompany)
				.clickOnCollateralAddressLink()
				.enterAddressLine1(expectedAddressLine1)
				.enterCity(expectedCity)
				.selectStateOrRegion("Alabama")
				.enterZipOrPostalCode(expectedPostalCode)
				.clickOnNextButton()
				.clickOnSubmitButton().clickOnFirstAvailableAccount()
				.clickOnMoreLink().clickOnSubLinkOfMore("Collateral");				
				
				String actualCollateralDescription = accountDetailTabScreen.getValueFromResultTable("Collateral", "Collateral Description", 1);

				AssertionUtil.verifyEqual(actualCollateralDescription, collateralDescription,
						"ECS095_ ECS101: Verification of Collateral Description in Linked Collateral Details table");
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableFirstRow();
				
				accountDetailTabScreen.wait(10).expandLinkedCollateralDetailsTableCategory("Collateral Details");
				
				String actualOriginalValue = accountDetailTabScreen.getExpandedCategoryLabelValue("Original Value");
				String actualCurrentValue = accountDetailTabScreen.getExpandedCategoryLabelValue("Current Value");

				AssertionUtil.verifyEqual(actualOriginalValue, expectedOriginalValue,
						"ECS102 : Verification of Original Value Label Value  under expanded Collateral Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualCurrentValue, expectedCurrentValue,
						"ECS102 : Verification of Current Value Label Value under expanded Collateral Details in Linked Collateral Details table");
				
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableCategory("Address");
				
				String actualAddressLine1 = accountDetailTabScreen.getExpandedCategoryLabelValue("Address Line 1");
				String actualCity = accountDetailTabScreen.getExpandedCategoryLabelValue("City");
				String actualPostalCode = accountDetailTabScreen.getExpandedCategoryLabelValue("Zip/Postal Code");

				AssertionUtil.verifyEqual(actualAddressLine1, expectedAddressLine1,
						"ECS103 : Verification of Address Line 1 Label Value under expanded Address in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualCity, expectedCity,
						"ECS094 : Verification of City Label Value under expanded Address in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualPostalCode, expectedPostalCode,
						"ECS0103 : Verification of Postal Code Label Value under expanded Address in Linked Collateral Details table");
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableCategory("Vehicle Details");
				
				String actualModel = accountDetailTabScreen.getExpandedCategoryLabelValue("Model");
				String actualColor = accountDetailTabScreen.getExpandedCategoryLabelValue("Color");
				String actualVehicleType = accountDetailTabScreen.getExpandedCategoryLabelValue("Vehicle Type");

				AssertionUtil.verifyEqual(actualModel, expectedModel,
						"ECS104 : Verification of Model Value under expanded Vehicle Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualColor, expectedColor,
						"ECS104 : Verification of Color Label Value under expanded Vehicle Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualVehicleType, expectedVehicleType,
						"ECS104 : Verification of Vehicle Type Label Value under expanded Vehicle Details in Linked Collateral Details table");
				
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableCategory("Insurance Details");
				
				String actualPolicyNumber = accountDetailTabScreen.getExpandedCategoryLabelValue("Policy Number");
				String actualPolicyDescription = accountDetailTabScreen.getExpandedCategoryLabelValue("Policy Description");
				String actualCoverageAmount = accountDetailTabScreen.getExpandedCategoryLabelValue("Coverage Amount");
				String actualPremiumAmount = accountDetailTabScreen.getExpandedCategoryLabelValue("Premium Amount");
				String actualInsuranceCompany = accountDetailTabScreen.getExpandedCategoryLabelValue("Insurance Company");
				
				AssertionUtil.verifyEqual(actualPolicyNumber, expectedPolicyNumber,
						"ECS094 : Verification of Policy Number Value under expanded Insurance Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualPolicyDescription, expectedPolicyDescription,
						"ECS105 : Verification of Policy Description Label Value under expanded Insurance Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualCoverageAmount, expectedCoverageAmount,
						"ECS105 : Verification of Coverage Amount Label Value under expanded Insurance Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualPremiumAmount, expectedPremiumAmount,
						"ECS105 : Verification of Premium Amount Label Value under expanded Insurance Details in Linked Collateral Details table");
				
				AssertionUtil.verifyEqual(actualInsuranceCompany, expectedInsuranceCompany,
						"ECS105 : Verification of Insurance Company Label Value under expanded Insurance Details in Linked Collateral Details table");
				
				
				String actualLienPosition = accountDetailTabScreen.getValueFromResultTable("ExtLien", "Lien Position", 1);
				String actualFinancialInstitution = accountDetailTabScreen.getValueFromResultTable("ExtLien", "Financial Institution", 1);
				String actualAccountNumber = accountDetailTabScreen.getValueFromResultTable("ExtLien", "Account Number", 1);
				String actualCreditLimit = accountDetailTabScreen.getValueFromResultTable("ExtLien", "Credit Limit", 1);			
				String actualMonthlyPaymentAmount = accountDetailTabScreen.getValueFromResultTable("ExtLien", "Monthly Payment Amount", 1);
				
				AssertionUtil.verifyEqual(actualLienPosition, expectedLienPosition,
						"ECS106 : Verification of Lien Position in External Lien table");
				
				AssertionUtil.verifyEqual(actualFinancialInstitution, expectedFinancialInstitution,
						"ECS106 : Verification of Financial Institution in External Lien table");
				
				AssertionUtil.verifyEqual(actualAccountNumber, expectedAccountNumber,
						"ECS106 : Verification of Account Number in External Lien table");
				
				AssertionUtil.verifyEqual(actualCreditLimit, expectedCreditLimit,
						"ECS094 : Verification of Credit Limit in External Lien table");
				
				AssertionUtil.verifyEqual(actualMonthlyPaymentAmount, expectedMonthlyPaymentAmount,
						"ECS106 : Verification of Monthly Payment Amount in External Lien table");
				
				accountDetailTabScreen
				.clickOnThreeDotForCollateralEntriesVehicle().wait(5)
				.clickOnLink("Modify Collateral Details").switchToModifyCollateralDetailsScreen()
				.enterOriginalValue(updatedOriginalValue).clickOnSubmitButton().wait(5);
											
				accountDetailTabScreen				
				.expandLinkedCollateralDetailsTableFirstRow()
				.wait(5).expandLinkedCollateralDetailsTableCategory("Collateral Details")
				.clickOnThreeDotForCollateralEntriesVehicle().wait(5)
				.clickOnLink("Modify Address").switchToModifyAddressScreen()
				.enterZipCode(updatedPostalCode).clickOnSubmitButton().wait(10);
				
				accountDetailTabScreen				
				.expandLinkedCollateralDetailsTableFirstRow()
				.wait(15)  
				.clickOnThreeDotForCollateralEntriesVehicle().wait(5)
				.clickOnTab("Modify Vehicle Details").switchToModifyVehicleDetailsScreen()
				.enterModel(updatedModel).clickOnSubmitButton().wait(10);
				
				accountDetailTabScreen				
				.expandLinkedCollateralDetailsTableFirstRow()
				.wait(5)  
				.clickOnThreeDotForCollateralEntriesVehicle()
				.clickOnLink("Modify Insurance Details").switchToModifyInsuranceDetailsScreen()
				.enterCoverageAmount(updatedCoverageAmount).clickOnSubmitButton();
				
				System.out.println("hello");
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableFirstRow();
				
				accountDetailTabScreen.wait(10).expandLinkedCollateralDetailsTableCategory("Collateral Details");
				
				actualOriginalValue = accountDetailTabScreen.getExpandedCategoryLabelValue("Original Value");

				AssertionUtil.verifyEqual(actualOriginalValue, updatedOriginalValue,
						"ECS102 : Verification of Updated Original Value Label Value  under expanded Collateral Details in Linked Collateral Details table");
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableCategory("Address");
				
				actualPostalCode = accountDetailTabScreen.getExpandedCategoryLabelValue("Zip/Postal Code");

				AssertionUtil.verifyEqual(actualPostalCode, updatedPostalCode,
						"ECS0103 : Verification of Updated Postal Code Label Value under expanded Address in Linked Collateral Details table");
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableCategory("Vehicle Details");
				
				actualModel = accountDetailTabScreen.getExpandedCategoryLabelValue("Model");

				AssertionUtil.verifyEqual(actualModel, updatedModel,
						"ECS104 : Verification of Updated Model Value under expanded Vehicle Details in Linked Collateral Details table");
				
				
				accountDetailTabScreen.expandLinkedCollateralDetailsTableCategory("Insurance Details");
				
				actualCoverageAmount = accountDetailTabScreen.getExpandedCategoryLabelValue("Coverage Amount");

				AssertionUtil.verifyEqual(actualCoverageAmount, updatedCoverageAmount,
						"ECS105 : Verification of Updated Coverage Amount Label Value under expanded Insurance Details in Linked Collateral Details table");
				
				
				
	}
	
	
	
	@Test(description = "Verify Dispute Transaction with and Without Provitional Credit")
	public void ECS133_ValidateDisputeTransaction() {
		int initialAccountBalance = 500;
		String consumerFirstName = "ECS133";
		String consumerLastName = new CommonUtil().getSSN();
		String amount = "200.00";
		String transactionCode = "Savings Withdrawal";
		int timeout = 20;
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName, initialAccountBalance);
		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);
		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().postTransaction(transactionCode, amount, timeout).wait(10);
				
	
		accountDetailTabScreen.wait(10).clickOnTab("Transactions");
		
		accountDetailTabScreen.wait(10)
		.clickOnThreeDotIconInTable("Transactions").clickOnLinkByJS("Dispute Transaction")
		.wait(10).getCommonWidget().getDisputeTransactionScreen()
		.selectOrigin("Back Office")
		.selectDisputeType("ACH")
		.wait(15)
		.selectDisputeReason("Bank processing error")
		.enterDisputedAmount("120.00")
		.clickOnSubmitButton();
		
		String feedbackMessage = accountDetailTabScreen.getFeedbackMessage();
		String actualFeedbackMessage = feedbackMessage.split(":")[0].trim();
		String caseNumber = feedbackMessage.split(":")[1].trim();
		String expectedFeedbackMessage = "Dispute submitted successfully. Dispute No";
		
		AssertionUtil.verifyEqual(actualFeedbackMessage, expectedFeedbackMessage, "Verification of Feedback Message for Dispute Transaction");
		
		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Cases").wait(10);
		String openCasesTableCaseNumberValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Case Number", 1);
		String openCasesTableCaseTypeValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Case Type", 1);
		String openCasesTableCreatedDateValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Created Date", 1);
		String openCasesTableStatusValue = accountDetailTabScreen.getValueFromTable("OpenCases", "Status", 1);
		AssertionUtil.verifyEqual(openCasesTableCaseNumberValue, caseNumber, "Verification of Case Number Value in Open Cases Table for Dispute Transaction");
		AssertionUtil.verifyEqual(openCasesTableCaseTypeValue, "Disputed Transaction", "Verification of Case Type Value in Open Cases Table for Dispute Transaction");
		AssertionUtil.verifyEqual(openCasesTableCreatedDateValue, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"), "Verification of Created Date Value in Open Cases Table for Dispute Transaction");
		AssertionUtil.verifyEqual(openCasesTableStatusValue, "New", "Verification of Status Value in Open Cases Table for Dispute Transaction");
				
		System.out.println("hello");
		customerDetail = accountDetailTabScreen.clickOnText("Customer Overview")
		.switchToCustomerDetailPage()
		.clickOnMoreLink().clickOnSubLinkOfMore("Notifications");		
		
		String actualType = customerDetail.getValueFromResultTable("TYPE", 1);
		String actualDescription = customerDetail.getValueFromResultTable("DESCRIPTION", 1);
		String actualGenerationStatus = customerDetail.getValueFromResultTable("GENERATION STATUS", 1);
		
		AssertionUtil.verifyEqual(actualType, "disputeInitiated",
				"Verification of Type value available under Notification table");
		AssertionUtil.verifyEqual(actualDescription, "Dispute Initiated",
				"Verification of Description value available under Notification table");
		AssertionUtil.verifyEqual(actualGenerationStatus, "Inprocess",
				"Verification of Generation Status value available under Notification table");
		
		
		wmiScreen = customerDetail.clickOnMoreLink().clickOnSubLinkOfMore("Cases").clickOnOpenCaseDocId(caseNumber);
		
		wmiScreen.clickOnTabLink("Resolution").getWMIResolutionScreen()
		.selectFinalResolution("Closed - In Favor of Customer")
		.selectWorkFlowActionsOption(" Close Case")
		.clickOkButtonOnClaimClosureNotificationPopup()
		.wait(5).clickOnOverViewDisplayedTextLink("Closed Cases").wait(2);
		String actualCaseNumber = accountDetailTabScreen.getValueFromResultTable("CASE NUMBER", 1);
		String actualCaseType = accountDetailTabScreen.getValueFromResultTable("CASE TYPE", 1);
		String actualCreatedDate = accountDetailTabScreen.getValueFromResultTable("CREATED DATE", 1);
		String actualStatus = accountDetailTabScreen.getValueFromResultTable("STATUS", 1);
		AssertionUtil.verifyEqual(actualCaseNumber, caseNumber,
				"Verification of Case Number for Closed Cases");
		AssertionUtil.verifyEqual(actualCaseType, "Disputed Transaction",
				"Verification of Case Type for Closed Cases");
		AssertionUtil.verifyEqual(actualCreatedDate, new CommonUtil().getCurrentDateTime("MM/dd/yyyy"),
				"Verification of Status for Closed Cases");
		AssertionUtil.verifyEqual(actualStatus, "Closed",
				"Verification of Status for Closed Cases");
		
		
		System.out.println("hello");
		
		accountDetailTabScreen.clickOnMoreLink().clickOnSubLinkOfMore("Notifications").wait(10);		
		
		actualType = accountDetailTabScreen.getValueFromResultTable("TYPE", 1);
		actualDescription = accountDetailTabScreen.getValueFromResultTable("DESCRIPTION", 1);
		actualGenerationStatus = accountDetailTabScreen.getValueFromResultTable("GENERATION STATUS", 1);
		
		AssertionUtil.verifyEqual(actualType, "disputeApprProvCredPerm",
				"Verification of Type value available under Notification table");
		AssertionUtil.verifyEqual(actualDescription, "Dispute Approved Provisional Credit Made Permanent",
				"Verification of Description value available under Notification table");
		AssertionUtil.verifyEqual(actualGenerationStatus, "Inprocess",
				"Verification of Generation Status value available under Notification table");
		
		actualType = accountDetailTabScreen.getValueFromResultTable("TYPE", 3);
		actualDescription = accountDetailTabScreen.getValueFromResultTable("DESCRIPTION", 3);
		actualGenerationStatus = accountDetailTabScreen.getValueFromResultTable("GENERATION STATUS", 3);
		
		AssertionUtil.verifyEqual(actualType, "disputeInProcessProvCredit",
				"Verification of Type value available under Notification table");
		AssertionUtil.verifyEqual(actualDescription, "Dispute In Process Provisional Credit Issued",
				"Verification of Description value available under Notification table");
		AssertionUtil.verifyEqual(actualGenerationStatus, "Inprocess",
				"Verification of Generation Status value available under Notification table");
		
		accountDetailTabScreen.clickOnTab("Customer Overview").wait(10).clickOnText(accountNumber).wait(10)
		.clickOnTab("Transactions");
		
		String transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 1);
		String transactionsTableCreditValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Credit", 1);
		String transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 1);
		String transactionsTableDescriptionValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Description", 1);
		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, "dispute-cr",
				"Verification of Transaction Type Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableCreditValue, "120.00",
				"Verification of Debit Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, "420.00",
				"Verification of Ending Balance Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableDescriptionValue, "Dispute Posn Cr",
				"Verification of Description Value in Transactions Table");
		transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 3);
		String transactionsTableDebitValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Debit", 3);
		transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 3);
		transactionsTableDescriptionValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Description", 3);
		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, "dispute-dr",
				"Verification of Transaction Type Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableDebitValue, "120.00",
				"Verification of Debit Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, "300.00",
				"Verification of Ending Balance Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableDescriptionValue, "Dispute Posn Dr",
				"Verification of Description Value in Transactions Table");
		
		transactionsTableTransactionTypeValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Transaction Type", 5);
		transactionsTableCreditValue = accountDetailTabScreen.getValueFromTable("TransactionsTable", "Credit", 5);
		transactionsTableEndingBalanceValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Ending Balance", 5);
		transactionsTableDescriptionValue = accountDetailTabScreen.getValueFromTable("TransactionsTable",
				"Description", 5);
		AssertionUtil.verifyEqual(transactionsTableTransactionTypeValue, "dispute-provCr",
				"Verification of Transaction Type Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableCreditValue, "120.00",
				"Verification of Debit Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableEndingBalanceValue, "420.00",
				"Verification of Ending Balance Value in Transactions Table");
		AssertionUtil.verifyEqual(transactionsTableDescriptionValue, "Dispute Posn ProvCr",
				"Verification of Description Value in Transactions Table");
	}
		
	@Test(description = "Verify Account closed info in Position Summary, Account details and Closed Account section")
	public void ECS147_ECS148_ECS149_ValidateCloseAccount() {
		
		String consumerFirstName = "ECS147148";
		String consumerLastName = "AutoLN";
		String expectedPopupMessage = "Account closed.";
		String accountCloseReason = "Closed by customer";

		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = ecsAPIs.addDDAAccountToConsumerAPI(baseUrl,
				consumerFirstName, consumerLastName);

		String accountNumber = APIDataManager.getAccountNumber(addDDAAccountResponse);

		accountDetailTabScreen = loginPage
				.loginAndNavigateToConsumerAccountDetails(consumerFirstName, consumerLastName, accountNumber)
				.getCommonWidget().clickOnThreeLineTasksIconLink()
				.clickOnTaskLinkText("Close Account").getAccountDetailTabScreen();
		accountDetailTabScreen.selectCloseAccountReason(accountCloseReason)
							.clickOnCheckBox()
							.clickOnCheckBox()
							.clickOnButton("Submit");
							
		String actualPopupMessage = accountDetailTabScreen.getFeedbackMessage();
		AssertionUtil.verifyEqual(actualPopupMessage, expectedPopupMessage, "ECS147: Verification of popup message: "+actualPopupMessage+" is successful.");
		accountDetailTabScreen.refreshPage().wait(5);
		
		String accountSubheadPanelText = accountDetailTabScreen.getTextFromAccountSubHeadPanel();
		AssertionUtil.verifyContainsText(accountSubheadPanelText, "closed", "ECS147: Verification of account subhead panel contains 'closed' is successful.");
		
		String postionSummaryStatus = accountDetailTabScreen.getTextForPositionSummaryStatus();
		AssertionUtil.verifyEqual(postionSummaryStatus, "Closed", "ECS147: Verification of account status in Position Summary :'Closed' is successful.");
		
		String postionSummaryCloseDate = accountDetailTabScreen.getTextFromAccountPositionSummaryLabelText("ClosedDate");
		AssertionUtil.verifyEqual(postionSummaryCloseDate, currentDate, "ECS147: Verification of account close date in Position Summary : "+currentDate+" is successful.");
		
		String postionSummaryCloseReason = accountDetailTabScreen.getTextFromAccountPositionSummaryLabelText("CloseReason");
		AssertionUtil.verifyEqual(postionSummaryCloseReason, accountCloseReason, "ECS147: Verification of account close reason in Position Summary :'"+postionSummaryCloseReason+"' is successful.");
		
		accountDetailTabScreen.scrollPageUp().clickOnTab("Details");
		
		String statusValueFromAccountDetails = accountDetailTabScreen.getRecordValueFromTablesUnderDetailsTab("accountDetails", "Status");
		String closedDateValueFromAccountDetails = accountDetailTabScreen.getRecordValueFromTablesUnderDetailsTab("accountDetails", "Closed Date");
		
		AssertionUtil.verifyEqual(statusValueFromAccountDetails, "Closed", "ECS148: Verification of status under Details tab :'"+statusValueFromAccountDetails+"' is successful.");
		AssertionUtil.verifyEqual(closedDateValueFromAccountDetails, currentDate, "ECS148: Verification of account close reason under Details tab :'"+closedDateValueFromAccountDetails+"' is successful.");
		
		accountDetailTabScreen.clickOnText("Customer Overview")
							  .clickOnTab("Accounts");
		int numberOfClosedAccount = accountDetailTabScreen.getClosedAccountNumberInClosedAccountSection();
		
		String accountCloserReasonUnderAccountsTab = accountDetailTabScreen.getValueFromTable("ClosedAccountsTable","Account Closure Reason",numberOfClosedAccount);
		String accountClosedDateUnderAccountsTab = accountDetailTabScreen.getValueFromTable("ClosedAccountsTable","Closed Date",numberOfClosedAccount);
		
		AssertionUtil.verifyEqual(accountCloserReasonUnderAccountsTab, accountCloseReason, "ECS149: Verification of account closer reason in Closed Account section under Accounts tab :'"+accountCloserReasonUnderAccountsTab+"' is successful.");
		AssertionUtil.verifyEqual(accountClosedDateUnderAccountsTab, currentDate, "ECS149: Verification of account close reason in Closed Account section under Accounts tab :'"+accountClosedDateUnderAccountsTab+"' is successful.");
}
	
}