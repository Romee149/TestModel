package com.qa.ecs.api;

import static com.qa.ecs.apiUtils.APIHeaderManager.getHeader;

import org.testng.Assert;

import com.qa.ecs.apiUtils.CommonAPIUtils;
import com.qa.ecs.pojo.request.CreateLoan;

import io.restassured.response.Response;

public class CreateLoanAPI {

	public static Response post(String baseUrl, CreateLoan createLoanRequest) {	
		Response response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/linkAccount", getHeader(baseUrl), createLoanRequest);
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201) {
			try {
				Thread.sleep(10 * 1000);
				response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/linkAccount", getHeader(baseUrl), createLoanRequest);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201)
			Assert.fail("Create Loan API is down. Hence Returning response code "+ response.getStatusCode());
		return response;
	}

}
