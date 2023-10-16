package com.qa.ecs.api;

import static com.qa.ecs.apiUtils.APIHeaderManager.getHeader;

import org.testng.Assert;

import com.qa.ecs.apiUtils.CommonAPIUtils;

import io.restassured.response.Response;

public class CreateOrganizationAPI {

	public static Response post(String baseUrl,
			com.qa.ecs.pojo.request.CreateOrganization organizationCreationRequest) {
		Response response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/organization", getHeader(baseUrl), organizationCreationRequest);
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201) {
			try {
				Thread.sleep(10 * 1000);
				response = CommonAPIUtils.post(baseUrl, "/core/v1/customer/organization", getHeader(baseUrl), organizationCreationRequest);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201)
			Assert.fail("Create Organization API is down. Hence Returning response code "+ response.getStatusCode());
		return response;
	}

}
