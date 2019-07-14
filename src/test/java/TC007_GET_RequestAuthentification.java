import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_RequestAuthentification {

	@Test
	void authorizationTest() {

		// specify base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		RestAssured.authentication = authScheme;

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Respone object and request type
		Response response = httprequest.request(Method.GET,"/");

		// Print response on window console
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is : " + responseBody);

		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

}
