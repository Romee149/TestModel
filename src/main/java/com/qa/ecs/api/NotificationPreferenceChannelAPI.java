package com.qa.ecs.api;

import static com.qa.ecs.apiUtils.APIHeaderManager.getHeader;

import org.testng.Assert;

import com.qa.ecs.apiUtils.CommonAPIUtils;
import com.qa.ecs.pojo.request.NotificationPreference;

import io.restassured.response.Response;

public class NotificationPreferenceChannelAPI {

	public static Response post(String baseUrl, NotificationPreference notificationPreference) {
		Response response = CommonAPIUtils.post(baseUrl, "/model/v1/partyNotifPref", getHeader(baseUrl), notificationPreference);
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201) {
			try {
				Thread.sleep(10 * 1000);
				response = CommonAPIUtils.post(baseUrl, "/model/v1/partyNotifPref", getHeader(baseUrl), notificationPreference);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(response.getStatusCode() != 200 && response.getStatusCode() != 201)
			Assert.fail("Notification Preference Channel API is down. Hence Returning response code "+ response.getStatusCode());
		return response;
	}
	
}
