package com.qa.ecs.apiUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	public static RequestSpecification getRequestSpecification(String baseURL) {
		return new RequestSpecBuilder().setBaseUri(baseURL).setContentType(ContentType.JSON)
				.log(LogDetail.ALL).build();
	}

	public static ResponseSpecification getResponseSpecification() {
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();
	}

}
