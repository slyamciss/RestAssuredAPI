/*
 * soul the man in the house
 */


package dataDrivenTest;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Ddtest_AddNewEmployee {

	@Test(dataProvider = "empdataprovider" )
	void postNewEmployees(String ename, String esalary, String eage) {
		// specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Created data to be send with the post request

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", ename);
		requestParams.put("salary", esalary);
		requestParams.put("age", eage);

		// Add a header stating the request body is JSON
		httprequest.header("Content-Type", "application/json");

		// Add the JSON to the body of the request
		httprequest.body(requestParams.toString());

		// POST REQUEST
		Response response = httprequest.request(Method.POST, "/create");

		// Capture response body to perform validations
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody is :" +responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esalary), true);
		Assert.assertEquals(responseBody.contains(eage), true);

		int StatusCode = response.getStatusCode();
		Assert.assertEquals(StatusCode, 200);
	}

	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() {
		String empdata[][] = { { "drame", "5000", "31" }, { "drogfba", "100000", "45" }, { "kolo", "400000", "40" } };
		return (empdata);
	}
}
