package com.qa.ecs.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.qa.ecs.apiUtils.JsonDataManager;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.JacksonUtils;

import io.restassured.response.Response;

public class ecsAPIs {

	public static JsonDataManager jsonReader = new JsonDataManager();

	public static com.qa.ecs.pojo.response.CreateConsumer createConsumerAPI(String baseUrl) {
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateConsumer createConsumerRequestPayload = jsonReader.getConsumerData();
		createConsumerRequestPayload.getPartyPerson().setTin(tinNumber);
		return createConsumerAPI(baseUrl, createConsumerRequestPayload);
	}

	public static com.qa.ecs.pojo.response.CreateConsumer createConsumerAPI(String baseUrl,
			com.qa.ecs.pojo.request.CreateConsumer createConsumerRequestPayload) {
		String dateTime = new CommonUtil().getCurrentDateTime("yyyy-MM-dd hh:mm:ss").replace(" ", "T") + "Z";
		createConsumerRequestPayload.getAddresses().get(0).setVerifyDtm(dateTime);
		createConsumerRequestPayload.getCustomer().setStartDtm(dateTime);
		createConsumerRequestPayload.getPartyPerson().getEmails().get(0).setVerifyDtm(dateTime);
		createConsumerRequestPayload.getPartyPerson().getPhones().get(0).setVerifyDtm(dateTime);
		Response response = CreateConsumerAPI.post(baseUrl, createConsumerRequestPayload);
		assertThat(response.statusCode(), equalTo(200));
		com.qa.ecs.pojo.response.CreateConsumer createConsumerResponsePayload = response
				.as(com.qa.ecs.pojo.response.CreateConsumer.class);
		// ***** Setting Notification ******//
		setNotificationPreference(baseUrl, createConsumerResponsePayload);
		return createConsumerResponsePayload;
	}

	public static com.qa.ecs.pojo.response.CreateOrganization createOrganizationAPI(String baseUrl) {
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateOrganization createOrganizationRequestPayload = jsonReader.getOrganizationData();
		createOrganizationRequestPayload.getPartyOrg().setTin(tinNumber);
		return createOrganizationAPI(baseUrl, createOrganizationRequestPayload);
	}
	
	
	public static com.qa.ecs.pojo.response.CreateOrganization createOrganizationAPI(String baseUrl, String organizationName) {
		String tinNumber = new CommonUtil().getSSN();
		com.qa.ecs.pojo.request.CreateOrganization createOrganizationRequestPayload = jsonReader.getOrganizationData();
		createOrganizationRequestPayload.getPartyOrg().setName(organizationName);
		createOrganizationRequestPayload.getPartyOrg().setTin(tinNumber);
		return createOrganizationAPI(baseUrl, createOrganizationRequestPayload);
	}

	public static com.qa.ecs.pojo.response.CreateOrganization createOrganizationAPI(String baseUrl,
			com.qa.ecs.pojo.request.CreateOrganization createOrganizationRequestPayload) {
		String dateTime = new CommonUtil().getCurrentDateTime("yyyy-MM-dd hh:mm:ss").replace(" ", "T") + "Z";
		createOrganizationRequestPayload.getAddresses().get(0).setValidFromDtm(dateTime);
		createOrganizationRequestPayload.getCustomer().setStartDtm(dateTime);
		createOrganizationRequestPayload.getPartyOrg().getEmails().get(0).setVerifyDtm(dateTime);
		createOrganizationRequestPayload.getPartyOrg().getPhones().get(0).setVerifyDtm(dateTime);
		Response response = CreateOrganizationAPI.post(baseUrl, createOrganizationRequestPayload);
		assertThat(response.statusCode(), equalTo(200));
		com.qa.ecs.pojo.response.CreateOrganization createOrganizationResponsePayload = response
				.as(com.qa.ecs.pojo.response.CreateOrganization.class);
		// ***** Setting Notification ******//
		setNotificationPreference(baseUrl, createOrganizationResponsePayload);
		return createOrganizationResponsePayload;
	}

	private static void setNotificationPreference(String baseUrl,
			com.qa.ecs.pojo.response.CreateConsumer createConsumerResponsePayload) {
		com.qa.ecs.pojo.request.NotificationPreference notificationPreferenceRequestPayload = jsonReader
				.getNotificationPreferenceData();
		notificationPreferenceRequestPayload.setMemberId(createConsumerResponsePayload.getCustomer().getCustomerId());
		notificationPreferenceRequestPayload.setPartyId(createConsumerResponsePayload.getPartyPerson().getId());
		NotificationPreferenceChannelAPI.post(baseUrl, notificationPreferenceRequestPayload);
	}

	private static void setNotificationPreference(String baseUrl,
			com.qa.ecs.pojo.response.CreateOrganization createOrganizationResponsePayload) {
		com.qa.ecs.pojo.request.NotificationPreference notificationPreferenceRequestPayload = jsonReader
				.getNotificationPreferenceData();
		notificationPreferenceRequestPayload
				.setMemberId(createOrganizationResponsePayload.getCustomer().getCustomerId());
		notificationPreferenceRequestPayload.setPartyId(createOrganizationResponsePayload.getPartyOrg().getId());
		NotificationPreferenceChannelAPI.post(baseUrl, notificationPreferenceRequestPayload);
	}

	public static com.qa.ecs.pojo.response.FindCustomer findConsumer(String baseUrl,
			com.qa.ecs.pojo.request.FindCustomer findConsumerRequestPayload) {
		Response response = null;
		try {
			response = FindConsumerAPI.post(baseUrl, findConsumerRequestPayload);
		} catch (Exception ssle) {
			try {
				Thread.sleep(15000);
				response = FindConsumerAPI.post(baseUrl, findConsumerRequestPayload);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			com.qa.ecs.pojo.response.FindCustomer findConsumerResponsePayload = response
					.as(com.qa.ecs.pojo.response.FindCustomer.class);
			return findConsumerResponsePayload;
		} catch (Exception e) {
			return null;
		}
	}

	public static com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountToConsumer(String baseUrl,
			com.qa.ecs.pojo.request.AddDDAAccount addDDAAccountRequestPayload) {
		Response response = AddDDAAccountAPI.post(baseUrl, addDDAAccountRequestPayload);
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponsePayload = response
				.as(com.qa.ecs.pojo.response.AddDDAAccount.class);
		return addDDAAccountResponsePayload;
	}

	public static com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountToConsumer(String baseUrl,
			com.qa.ecs.pojo.request.MultiPositionAccount multiPositionAccountRequestPayload) {
		Response response = MultiPositionAccountAPI.post(baseUrl, multiPositionAccountRequestPayload);
		com.qa.ecs.pojo.response.MultiPositionAccount multiPositionAccountResponsePayload = response
				.as(com.qa.ecs.pojo.response.MultiPositionAccount.class);
		return multiPositionAccountResponsePayload;
	}

	public static com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountToConsumerAPI(String baseUrl, String firstName,
			String lastName) {
		String customerID = getCustomerID(baseUrl, firstName, lastName);
		com.qa.ecs.pojo.request.AddDDAAccount addDDAAccountRequestPayload = jsonReader.getDDAAccountData();
		addDDAAccountRequestPayload.getCustomer().setCustomerId(customerID);
		return addDDAAccountToConsumer(baseUrl, addDDAAccountRequestPayload);
	}
	
	
	public static com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountToConsumerAPI(String baseUrl, 
			String firstName, String lastName, com.qa.ecs.pojo.request.AddDDAAccount addDDAAccountRequestPayload) {
		String customerID = getCustomerID(baseUrl, firstName, lastName);
		addDDAAccountRequestPayload.getCustomer().setCustomerId(customerID);
		return addDDAAccountToConsumer(baseUrl, addDDAAccountRequestPayload);
	}

	public static com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountToConsumerAPI(String baseUrl,
			String firstName, String lastName) {
		String customerID = getCustomerID(baseUrl, firstName, lastName);
		com.qa.ecs.pojo.request.MultiPositionAccount multiPositionAccountRequestPayload = jsonReader
				.getMultiPositionAccountData();
		multiPositionAccountRequestPayload.getCustomer().setCustomerId(customerID);
		multiPositionAccountRequestPayload.getNewAccounts().get(0).getAcct().getAcctBk()
				.setAcctNbr(new CommonUtil().getAccountNumber());
		return addMultiPositionAccountToConsumer(baseUrl, multiPositionAccountRequestPayload);
	}

	public static String getCustomerID(String baseUrl, String firstName, String lastName) {
		com.qa.ecs.pojo.response.CreateConsumer createConsumerResponsePayload = createConsumerIfNotExists(baseUrl,
				firstName, lastName);
		String customerID;
		if(createConsumerResponsePayload != null)
			customerID = createConsumerResponsePayload.getCustomer().getCustomerId();
		else
			customerID = getCustomerIDByFindCustomerAPI(baseUrl, firstName, lastName);
		return customerID;
	}

	public static com.qa.ecs.pojo.response.CreateConsumer createConsumerIfNotExists(String baseUrl, String firstName,
			String lastName) {
		com.qa.ecs.pojo.response.CreateConsumer createConsumerResponsePayload= null;
		String customerID = getCustomerIDByFindCustomerAPI(baseUrl, firstName, lastName);
		if (customerID == null) {
			String tinNumber = new CommonUtil().getSSN();
			com.qa.ecs.pojo.request.CreateConsumer createConsumerRequestPayload = jsonReader.getConsumerData();
			createConsumerRequestPayload.getPartyPerson().setTin(tinNumber);
			createConsumerRequestPayload.getPartyPerson().setFirstName(firstName);
			createConsumerRequestPayload.getPartyPerson().setLastName(lastName);
			createConsumerResponsePayload = createConsumerAPI(baseUrl, createConsumerRequestPayload);
			setNotificationPreference(baseUrl, createConsumerResponsePayload);
			customerID = createConsumerResponsePayload.getCustomer().getCustomerId();
		}
		return createConsumerResponsePayload;
	}

	public static String getCustomerIDByFindCustomerAPI(String baseUrl, String firstName, String lastName) {
		String customerID = null;
		com.qa.ecs.pojo.request.FindCustomer findConsumerRequestPayload = jsonReader.getFindCustomerData();
		findConsumerRequestPayload.getPeople().get(0).setFirstName(firstName);
		findConsumerRequestPayload.getPeople().get(0).setLastName(lastName);
		com.qa.ecs.pojo.response.FindCustomer findConsumerResponsePayload = findConsumer(baseUrl,
				findConsumerRequestPayload);
		customerID = findConsumerResponsePayload.getCustomers() == null ? null
				: findConsumerResponsePayload.getCustomers().get(0).getPartyGroupMembers().get(0).getMemberId();
		return customerID;
	}

	
	public static com.qa.ecs.pojo.response.AddFundToAccount addFundToAccountAPI(String baseUrl, com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse, int funds) {
		com.qa.ecs.pojo.request.AddFundToAccount addFundToAccountRequestPayload = jsonReader.getAddFundToAccountData();
		int accountGroup = addDDAAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getAcctGroup();
		addFundToAccountRequestPayload.getEntries().get(0).setAcctGroup(accountGroup);
		String accountNumber = addDDAAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getAcctNbr();
		addFundToAccountRequestPayload.getEntries().get(0).setAcctNbr(accountNumber);
		String posnID = addDDAAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getId();
		addFundToAccountRequestPayload.getEntries().get(0).setPosnId(posnID);
		String posnAccountNumber = addDDAAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getPosnAcctNbr();
		addFundToAccountRequestPayload.getEntries().get(0).setPosnAcctNbr(posnAccountNumber);
		addFundToAccountRequestPayload.getEntries().get(0).setTrnAmt(funds);
		addFundToAccountRequestPayload.getEntries().get(1).setTrnAmt(funds);
		Response response = AddFundToAccountAPI.post(baseUrl, addFundToAccountRequestPayload);
		com.qa.ecs.pojo.response.AddFundToAccount addFundToAccountResponsePayload = response
				.as(com.qa.ecs.pojo.response.AddFundToAccount.class);
		return addFundToAccountResponsePayload;
	}
	
	
	public static com.qa.ecs.pojo.response.AddFundToAccount addFundToAccountAPI(String baseUrl, com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse, int funds) {
		com.qa.ecs.pojo.request.AddFundToAccount addFundToAccountRequestPayload = jsonReader.getAddFundToAccountData();
		int accountGroup = addMultiPositionAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getAcctGroup();
		addFundToAccountRequestPayload.getEntries().get(0).setAcctGroup(accountGroup);
		String accountNumber = addMultiPositionAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getAcctNbr();
		addFundToAccountRequestPayload.getEntries().get(0).setAcctNbr(accountNumber);
		String posnID = addMultiPositionAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getId();
		addFundToAccountRequestPayload.getEntries().get(0).setPosnId(posnID);
		String posnAccountNumber = addMultiPositionAccountResponse.getCreatedAccounts().get(0).getPosnDepDtl().get(0).getPosnDep().getPosnAcctNbr();
		addFundToAccountRequestPayload.getEntries().get(0).setPosnAcctNbr(posnAccountNumber);
		addFundToAccountRequestPayload.getEntries().get(0).setTrnAmt(funds);
		addFundToAccountRequestPayload.getEntries().get(1).setTrnAmt(funds);
		Response response = AddFundToAccountAPI.post(baseUrl, addFundToAccountRequestPayload);
		com.qa.ecs.pojo.response.AddFundToAccount addFundToAccountResponsePayload = response
				.as(com.qa.ecs.pojo.response.AddFundToAccount.class);
		return addFundToAccountResponsePayload;
	}
	
	
	
	public static com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountToConsumerAPI(String baseUrl, 
			String firstName, String lastName, int funds) {
		com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse = addDDAAccountToConsumerAPI(baseUrl,firstName,lastName);	
		addFundToAccountAPI(baseUrl, addDDAAccountResponse,funds); 
		return addDDAAccountResponse;
	}
	
	
	public static com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountToConsumerAPI(String baseUrl,
			String firstName, String lastName, int funds) {
		com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse = addMultiPositionAccountToConsumerAPI(baseUrl,firstName,lastName);	
		addFundToAccountAPI(baseUrl, addMultiPositionAccountResponse,funds); 
		return addMultiPositionAccountResponse;
	}
	
	
	public static com.qa.ecs.pojo.response.CreateLoan createLoanToConsumer(String baseUrl,
			com.qa.ecs.pojo.request.CreateLoan createLoanRequestPayload) {
		Response response = CreateLoanAPI.post(baseUrl, createLoanRequestPayload);
		com.qa.ecs.pojo.response.CreateLoan createLoanResponsePayload = response
				.as(com.qa.ecs.pojo.response.CreateLoan.class);
		return createLoanResponsePayload;
	}
	
	
	public static com.qa.ecs.pojo.response.CreateLoan addLoanAccountToConsumerAPI(String baseUrl, String firstName,
			String lastName) {
		String customerID = getCustomerID(baseUrl, firstName, lastName);
		com.qa.ecs.pojo.request.CreateLoan createLoanRequestPayload = jsonReader.getCreateLoanData();
		createLoanRequestPayload.getCustomer().setCustomerId(customerID);
		createLoanRequestPayload.getNewAccounts().get(0).getAcct().getAcctBk().setAcctNbr(new CommonUtil().getAccountNumber());
		return createLoanToConsumer(baseUrl, createLoanRequestPayload);		
	}
	
	
	public static com.qa.ecs.pojo.response.CreateLoan addLoanAccountToConsumerAPI(String baseUrl, String firstName,
			String lastName, int amount) {
		com.qa.ecs.pojo.response.CreateLoan addLoanAccountResponsePayload= addLoanAccountToConsumerAPI(baseUrl, firstName, lastName);		
		String accountNumber = addLoanAccountResponsePayload.getAcctPartyRels().get(0).getAcctNbr();
		com.qa.ecs.pojo.request.AddBalanceOnLoan addBalanceOnLoanRequestPayload = jsonReader.getAddBalanceOnLoanData();
		addBalanceOnLoanRequestPayload.getEntries().get(0).setAcctNbr(accountNumber);
		addBalanceOnLoanRequestPayload.getEntries().get(0).setPosnAcctNbr(accountNumber);
		addBalanceOnLoanRequestPayload.getEntries().get(1).setAcctNbr(accountNumber);
		addBalanceOnLoanRequestPayload.getEntries().get(0).setTrnAmt(amount);
		addBalanceOnLoanRequestPayload.getEntries().get(1).setTrnAmt(amount);
		addBalanceToLoanAPI(baseUrl, addBalanceOnLoanRequestPayload);
		return addLoanAccountResponsePayload;		
	}
	
	
	public static com.qa.ecs.pojo.response.AddBalanceOnLoan addBalanceToLoanAPI(String baseUrl, com.qa.ecs.pojo.request.AddBalanceOnLoan addBalanceOnLoanRequestPayload) {
	Response response = AddBalanceOnLoanAPI.post(baseUrl, addBalanceOnLoanRequestPayload);
	com.qa.ecs.pojo.response.AddBalanceOnLoan addBalanceOnLoanResponsePayload = response
			.as(com.qa.ecs.pojo.response.AddBalanceOnLoan.class);
	return addBalanceOnLoanResponsePayload;
	}
	
}
