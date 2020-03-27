/* 
 * This test is an example of DELETE request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 * 
 * This call will DELETE the user with ID of 4
 * Can run this only after Test_POST to create user with ID=4
 */

package localMockApi;


import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


public class Test_DELETE {
	
	@Test
	public void test_1() {
		
		baseURI = "http://localhost:3000/";
		
		when()
			.delete("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}

}
