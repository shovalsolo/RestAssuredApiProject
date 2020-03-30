/* 
 * This test is an example of PUT request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 * 
 * This call will update the user with ID of 3 to the following:
 */

package localMockApi;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PUT {
	
	@Test
	public void test_1() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();						//Creating the object and adding the data - the ID is auto generated
		request.put("firstName", "Ronny");
		request.put("lastName", "Rock");
		request.put("subjectId", 1);
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)	//Will accept only type of JSON
			.body(request.toJSONString())
		.when()
			.put("/users/3")
		.then()
			.statusCode(200)
			.log().all();
	}

}
