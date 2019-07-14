import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void registrationSuccessfull() {

		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Request payload sending along wkith post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "Black");
		requestParams.put("LastName", "soman");
		requestParams.put("UserName", "lhomme");
		requestParams.put("Password", "diamant225");
		requestParams.put("Email", "diamant225@gmail.com");

		httprequest.header("Content-Type", "application/json");

		httprequest.body(requestParams.toJSONString());  // attach above data to the request

		// Respone object and request type
		Response response = httprequest.request(Method.POST,"/register");

		// Print response on window console
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is : " + responseBody);

		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	
	}

}
