/* 
 * This test is an example of PUT request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way we need to create an object of RestAssured										
 * Add one of the following to POM.xml
 * json.simple - this is the one i selected
 * gson
 * jackson-core
 * json
 */

package test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PUT {
	
	@Test
	public void test_1_put() {											//Using JSONObject

		JSONObject request = new JSONObject();							//We can use JSONObject after we added json.simple to the POM.xml

		request.put("name", "Larry");
		request.put("Job", "Cleaner");

		System.out.println(request);									//This will print the data in a json formation
		System.out.println(request.toJSONString());						//Can also use toJSONString to set the json format

		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)		//Will accept only type of JSON
			.body(request.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.log().all()
			.statusCode(200);											//The status of OK is 200
	}
}
