/* 
 * This test is an example of GET request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 */

package localMockApi;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Test_GET {
	
	@Test
	public void test_1() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.get(baseURI)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_2() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.param("name", "Automation")
			.get("subjects")
		.then()
			.statusCode(200)
			.log().all();
	}
}
