/* 
 * This test is an example of PATCH request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 * 
 * This call will update the user with ID of 4 to the following:
 */

package localMockApi;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PATCH {
	
	@Test
	public void test_1() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();						//Creating the object and adding the data - the ID is auto generated
		request.put("lastName", "Blue");
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)	//Will accept only type of JSON
			.body(request.toJSONString())
		.when()
			.patch("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}

}
