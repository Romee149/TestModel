package com.qa.ecs.apiUtils;

import com.qa.ecs.utils.JacksonUtils;

public class JsonDataManager {

	public com.qa.ecs.pojo.request.CreateConsumer getConsumerData() {
		com.qa.ecs.pojo.request.CreateConsumer createConsumerRequestPayload = JacksonUtils
				.deserializeJson("ConsumerCreation.json", com.qa.ecs.pojo.request.CreateConsumer.class);
		return createConsumerRequestPayload;
	}

	public com.qa.ecs.pojo.request.CreateConsumer getConsumerData(String fileName) {
		com.qa.ecs.pojo.request.CreateConsumer createConsumerRequestPayload = JacksonUtils.deserializeJson(fileName,
				com.qa.ecs.pojo.request.CreateConsumer.class);
		return createConsumerRequestPayload;
	}

	public com.qa.ecs.pojo.request.CreateOrganization getOrganizationData() {
		com.qa.ecs.pojo.request.CreateOrganization createOrganizationRequestPayload = null;
		createOrganizationRequestPayload = JacksonUtils.deserializeJson("OrganizationCreation.json",
				com.qa.ecs.pojo.request.CreateOrganization.class);
		return createOrganizationRequestPayload;
	}

	public com.qa.ecs.pojo.request.CreateOrganization getOrganizationData(String fileName) {
		com.qa.ecs.pojo.request.CreateOrganization createOrganizationRequestPayload = JacksonUtils
				.deserializeJson(fileName, com.qa.ecs.pojo.request.CreateOrganization.class);
		return createOrganizationRequestPayload;
	}

	public com.qa.ecs.pojo.request.MultiPositionAccount getMultiPositionAccountData() {
		com.qa.ecs.pojo.request.MultiPositionAccount multiPositionAccountRequestPayload = JacksonUtils
				.deserializeJson("MultiPositionAccount.json", com.qa.ecs.pojo.request.MultiPositionAccount.class);
		return multiPositionAccountRequestPayload;
	}

	public com.qa.ecs.pojo.request.MultiPositionAccount getMultiPositionAccountData(String fileName) {
		com.qa.ecs.pojo.request.MultiPositionAccount multiPositionAccountRequestPayload = JacksonUtils
				.deserializeJson(fileName, com.qa.ecs.pojo.request.MultiPositionAccount.class);
		return multiPositionAccountRequestPayload;
	}

	public com.qa.ecs.pojo.request.AddDDAAccount getDDAAccountData() {
		com.qa.ecs.pojo.request.AddDDAAccount addDDAAccountRequestPayload = JacksonUtils
				.deserializeJson("AddDDAAccount.json", com.qa.ecs.pojo.request.AddDDAAccount.class);
		return addDDAAccountRequestPayload;
	}

	public com.qa.ecs.pojo.request.AddDDAAccount getDDAAccountData(String fileName) {
		com.qa.ecs.pojo.request.AddDDAAccount addDDAAccountRequestPayload = JacksonUtils.deserializeJson(fileName,
				com.qa.ecs.pojo.request.AddDDAAccount.class);
		return addDDAAccountRequestPayload;
	}

	public com.qa.ecs.pojo.request.NotificationPreference getNotificationPreferenceData() {
		com.qa.ecs.pojo.request.NotificationPreference notificationPreferenceRequestPayload = JacksonUtils
				.deserializeJson("NotificationPreference.json", com.qa.ecs.pojo.request.NotificationPreference.class);
		return notificationPreferenceRequestPayload;
	}

	public com.qa.ecs.pojo.request.NotificationPreference getNotificationPreferenceData(String fileName) {
		com.qa.ecs.pojo.request.NotificationPreference notificationPreferenceRequestPayload = JacksonUtils
				.deserializeJson("NotificationPreference.json", com.qa.ecs.pojo.request.NotificationPreference.class);
		return notificationPreferenceRequestPayload;
	}

	public com.qa.ecs.pojo.request.FindCustomer getFindCustomerData() {
		com.qa.ecs.pojo.request.FindCustomer findConsumerRequestPayload = JacksonUtils
				.deserializeJson("FindCustomer.json", com.qa.ecs.pojo.request.FindCustomer.class);
		return findConsumerRequestPayload;
	}

	public com.qa.ecs.pojo.request.FindCustomer getFindCustomerData(String fileName) {
		com.qa.ecs.pojo.request.FindCustomer findConsumerRequestPayload = JacksonUtils.deserializeJson(fileName,
				com.qa.ecs.pojo.request.FindCustomer.class);
		return findConsumerRequestPayload;
	}

	
	public com.qa.ecs.pojo.request.AddFundToAccount getAddFundToAccountData() {
		return getAddFundToAccountData("AddFundToAccount.json");
	}
	
	public com.qa.ecs.pojo.request.AddFundToAccount getAddFundToAccountData(String fileName) {
		com.qa.ecs.pojo.request.AddFundToAccount addFundToAccountRequestPayload = JacksonUtils.deserializeJson(fileName,
				com.qa.ecs.pojo.request.AddFundToAccount.class);
		return addFundToAccountRequestPayload;
	}
	
	
	public com.qa.ecs.pojo.request.CreateLoan getCreateLoanData() {
		return getCreateLoanData("CreateLoan.json");
	}
	
	public com.qa.ecs.pojo.request.CreateLoan getCreateLoanData(String fileName) {
		com.qa.ecs.pojo.request.CreateLoan createLoanRequestPayload = JacksonUtils.deserializeJson(fileName,
				com.qa.ecs.pojo.request.CreateLoan.class);
		return createLoanRequestPayload;
	}
	
	
	public com.qa.ecs.pojo.request.AddBalanceOnLoan getAddBalanceOnLoanData() {
		return getAddBalanceOnLoanData("AddBalanceOnLoan.json");
	}
	
	public com.qa.ecs.pojo.request.AddBalanceOnLoan getAddBalanceOnLoanData(String fileName) {
		com.qa.ecs.pojo.request.AddBalanceOnLoan addBalanceOnLoanRequestPayload = JacksonUtils.deserializeJson(fileName,
				com.qa.ecs.pojo.request.AddBalanceOnLoan.class);
		return addBalanceOnLoanRequestPayload;
	}
	
}
