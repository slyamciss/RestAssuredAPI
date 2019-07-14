import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request_ValidatingJSONResponse {
	
	@Test
	void getWeatherDetails() {

		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Respone object and request type
		Response response = httprequest.request(Method.GET,"/Abidjan");

		// Print response on window console
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is : " + responseBody);
		Assert.assertEquals(responseBody.contains("Abidjan"), true);
	}
}
