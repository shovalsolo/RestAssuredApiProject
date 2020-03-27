/* 
 * This test is an example of DELETE request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way we need to create an object of RestAssured										
 * Add one of the following to POM.xml
 * json.simple - this is the one i selected
 * gson
 * jackson-core
 * json
 */
package test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_DELETE {

	@Test
	public void test_1_delete() {											//Using JSONObject

		
		when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.log().all()
			.statusCode(204);											//The status of deleted is 204
	}
}
