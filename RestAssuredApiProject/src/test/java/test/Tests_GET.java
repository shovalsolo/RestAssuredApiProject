/* 
 * This test is an example of get request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 * import static io.restassured.matcher.RestAssuredMatchers.*;				//Need to include
 * import static org.hamcrest.Matchers.*;									//Need to include
 * import io.restassured.response.Response;
 */

package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way we need to create an object of RestAssured


public class Tests_GET {
	
	@Test
	public void test_1() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200);
	}
}
