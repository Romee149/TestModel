package com.qa.ecs.api;

import static com.qa.ecs.apiUtils.APIHeaderManager.getHeader;

import org.testng.Assert;

import com.qa.ecs.apiUtils.CommonAPIUtils;
import com.qa.ecs.pojo.request.AddBalanceOnLoan;
import com.qa.ecs.pojo.request.AddDDAAccount;
import com.qa.ecs.pojo.request.MultiPositionAccount;

import io.restassured.response.Response;

public class MultiPositionAccountAPI {

//	public static Response post(String baseUrl, MultiPositionAccount multiPositionAccountRequest) {
//		Response response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/linkAccount", getHeader(baseUrl), multiPositionAccountRequest);
//		if(response.getStatusCode() != 200 && response.getStatusCode() != 201) {
//			try {
//				Thread.sleep(10 * 1000);
//				response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/linkAccount", getHeader(baseUrl), multiPositionAccountRequest);				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			
//		}
//		if(response.getStatusCode() != 200 && response.getStatusCode() != 201)
//			Assert.fail("MultiPosition Account API is down. Hence Returning response code "+ response.getStatusCode());
//		return response;
//	}
	
	public static Response post(String baseUrl, MultiPositionAccount multiPositionAccountRequest) {
		Response response=null;
		int count = 0;
		while (count < 3) {
			response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/linkAccount", getHeader(baseUrl), multiPositionAccountRequest);
			if(response.getStatusCode() == 200 || response.getStatusCode() == 201) 
				break;
			try {
				Thread.sleep(10 * 1000);
				response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/linkAccount", getHeader(baseUrl), multiPositionAccountRequest);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
		if(count == 3)
			Assert.fail("MultiPosition Account API is down. Hence Returning response code "+ response.getStatusCode());
		return response;
	}
}
