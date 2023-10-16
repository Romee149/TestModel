package com.qa.ecs.api;

import static com.qa.ecs.apiUtils.APIHeaderManager.getHeader;

import org.testng.Assert;

import com.qa.ecs.apiUtils.CommonAPIUtils;
import com.qa.ecs.pojo.request.AddBalanceOnLoan;

import io.restassured.response.Response;

public class AddBalanceOnLoanAPI {
	
	public static Response post(String baseUrl, AddBalanceOnLoan AddBalanceOnLoanRequest) {
		return post(baseUrl,AddBalanceOnLoanRequest,3);
	}
	
	public static Response post(String baseUrl, AddBalanceOnLoan AddBalanceOnLoanRequest, int retry) {
		Response response=null;
		int count = 0;
		while (count < retry) {			
			response = CommonAPIUtils.post(baseUrl, "/core/v1/trn", getHeader(baseUrl), AddBalanceOnLoanRequest);
			if(response.getStatusCode() == 200 || response.getStatusCode() == 201) 
				break;
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
		}
		
		if(count == retry)
			Assert.fail("Add Balance On Loan API is down. Hence Returning response code "+ response.getStatusCode());
		return response;
	}
	
}
