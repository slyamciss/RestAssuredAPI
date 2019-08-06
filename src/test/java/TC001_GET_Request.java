// This is made by souleymane

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	
	@Test
	void getWeatherDetails() {
		
		//specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Respone object and request type 
		Response response = httprequest.request(Method.GET,"/Abidjan");
		
		//Print response on window console
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is : " +responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line validation
		String statusLine = response.getStatusLine();
		System.out.println("status line is : " +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}

}
