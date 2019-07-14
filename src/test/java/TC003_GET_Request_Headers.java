import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request_Headers {
	
	@Test
	void googleMapTest() {
		
		//specify base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Respone object and request type 
		Response response = httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print response on window console
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is : " +responseBody);
		
		//Validating headers
		String contentType = response.header("Content-Type");//capture details of Content-type header
		System.out.println("Content Type is : " +contentType);
		Assert.assertEquals(contentType,"application/xml; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding");//capture details of Content-Encoding header
		System.out.println("Content-Encoding is : " +contentEncoding);
		Assert.assertEquals(contentEncoding,"gzip");
		
		
	}

}
