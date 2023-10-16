package com.qa.ecs.apiUtils;

public class APIDataManager {

	public static String getAccountNumber(com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse) {
		return addDDAAccountResponse.getAcctPartyRels().get(0).getAcctNbr();
	}

	public static String getAccountNumber(com.qa.ecs.pojo.response.AddDDAAccount addDDAAccountResponse, int index) {
		return addDDAAccountResponse.getAcctPartyRels().get(index).getAcctNbr();
	}

	public static String getAccountNumber(
			com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse) {
		return addMultiPositionAccountResponse.getAcctPartyRels().get(0).getAcctNbr();
	}

	public static String getAccountNumber(com.qa.ecs.pojo.response.MultiPositionAccount addMultiPositionAccountResponse,
			int index) {
		return addMultiPositionAccountResponse.getAcctPartyRels().get(index).getAcctNbr();
	}

	public static String getAccountNumber(com.qa.ecs.pojo.response.CreateLoan addLoanAccountResponsePayload) {
		return getAccountNumber(addLoanAccountResponsePayload, 0);
	}

	public static String getAccountNumber(com.qa.ecs.pojo.response.CreateLoan addLoanAccountResponsePayload,
			int index) {
		return addLoanAccountResponsePayload.getAcctPartyRels().get(index).getAcctNbr();
	}

}
