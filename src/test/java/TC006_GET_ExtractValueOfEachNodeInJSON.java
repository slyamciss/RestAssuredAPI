import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractValueOfEachNodeInJSON {
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
//		System.out.println("responseBody is : " + responseBody);
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
		
		Assert.assertEquals(jsonpath.get("Temperature"),"24 Degree celsius");
	}

}
