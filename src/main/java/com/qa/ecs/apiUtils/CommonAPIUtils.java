package com.qa.ecs.apiUtils;

import io.restassured.response.Response;

import static com.qa.ecs.apiUtils.SpecBuilder.getRequestSpecification;
import static com.qa.ecs.apiUtils.SpecBuilder.getResponseSpecification;
import static io.restassured.RestAssured.given;

import java.util.Map;

public class CommonAPIUtils {

	public static Response post(String baseUrl, String path, Map<String, Object> header, Object requestPayload) {
		return given(getRequestSpecification(baseUrl))
				.body(requestPayload)
				.headers(header)
				.when().post(path)
				.then().spec(getResponseSpecification())
				.extract().response();
	}

}
