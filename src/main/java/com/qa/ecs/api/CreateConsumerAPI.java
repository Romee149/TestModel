package com.qa.ecs.api;

import static com.qa.ecs.apiUtils.APIHeaderManager.getHeader;

import org.testng.Assert;

import com.qa.ecs.apiUtils.CommonAPIUtils;
import com.qa.ecs.pojo.request.CreateConsumer;
import io.restassured.response.Response;

public class CreateConsumerAPI {

	public static Response post(String baseUrl, CreateConsumer consumerCreationRequest) {		
		Response response = CommonAPIUtils.post(baseUrl, "/core/v1/customer", getHeader(baseUrl), consumerCreationRequest);
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201) {
			try {
				Thread.sleep(10 * 1000);
				response = CommonAPIUtils.post(baseUrl, "/core/v1/customer", getHeader(baseUrl), consumerCreationRequest);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201)
			Assert.fail("Create Consumer API is down. Hence Returning response code "+ response.getStatusCode());
		return response;
	}
	
}
