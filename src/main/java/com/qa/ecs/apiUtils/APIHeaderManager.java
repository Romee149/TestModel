package com.qa.ecs.apiUtils;

import static com.qa.ecs.apiUtils.SpecBuilder.getResponseSpecification;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class APIHeaderManager {
	
	
	public static Map<String, Object> getHeader(String baseUrl) {
		if (baseUrl.contains("203210"))
			return getQAHeader();
		else
			return getSav3Header();
	}

	public static Map<String, Object> getQAHeader() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", "daea260b2272d7b8d32a71941043ae288ac84ddb5d7c65e1188d55331b1c7035fb83df6f3c");
		map.put("secret", "b4965f009f94296d6e88c5f1");
		map.put("Fnx-Header",
				"{\"Identity\":{\"userRoles\":[\"developer\",\"system\",\"MANAGER\"],\"userId\":\"asanchez@savanainc.com\"}}");
		return map;
	}
	
	
	public static Map<String, Object> getSav3Header() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", "93af0662e75a3a8c6d956b760a2c91a5bf4db5669136ae129d9b9186b736c8713ac48193582c");
		map.put("secret", "866f198b04cb2dfe004c4285");
		map.put("Fnx-Header",
				"{\"Identity\":{\"userRoles\":[\"developer\",\"system\",\"MANAGER\"],\"userId\":\"rafroz@sav3.qa\"}}");
		return map;
	}
	
	public static String getToken() {
		String basicAuthToken = "SXZNR2VwamliV3J6OGRYOW9UN3ZZUThFQ1pudGxkVDNzUUdLeXIrT3FGOTFvZE4vRlo4NDY5VXBud2RvZDFhaUEvNGdtYXM3V2pmS1FkMFdaV2h5ZjY2TENaUnBlQjhlUW9OQzl0elllWWEvWVVveVErdnpuWWQybjBHOVp0bnc6NW1QWTdsak1wUlc3RUhTYm5IR0YrUWN3eDR2UXhNWDlWbHcyVkhBaEcrUkRYbFp1WjNmTlFFMk1xY0pCM2thMXN3K0FveHVtdGFvUmVMSE1VVHQ0UWpPUUhYY3ZTcjFEUVc5UzBkazZ5TGhUb01mZnBBWk5pamJkbVpDeFgyRzZtY3MvU2JLMjI4YVcwRFdzbWZxb2g5YXZoZHR4MGxZZ3k1aWdpNWQ3RWc3Tyt2WnZCUCtkNGFkeDI3c1dheWsz";
		Response response = given().body("{\n" + "    \"grantType\": \"client_credentials\"\n" + "}")
				.headers("Authorization", "Basic " + basicAuthToken).headers("Content-Type", "application/json")
				.post("https://qa-smt.savanainc.com/bankingServices/rest/oauth2/token").then()
				.spec(getResponseSpecification()).extract().response();

		if (response.statusCode() != 201) {
			throw new RuntimeException("Token Creation Failed!!!");
		}
		return response.path("accessToken");
	}

}
