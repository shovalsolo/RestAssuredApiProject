/* 
 * This test is an example of get request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way we need to create an object of RestAssured
 * import static io.restassured.matcher.RestAssuredMatchers.*;				//Need to include
 * import static org.hamcrest.Matchers.*;									//Need to include
 * import io.restassured.response.Response;
 */

package basicTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way we need to create an object of RestAssured
import static org.hamcrest.Matchers.*;

public class Test_GET {
	
	@Test
	public void test_1() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]" ,equalTo(8))								//This will check the cell number 2 has ID of 8 in data array
			.log().all()												//This will print all the response
			.body("data.first_name", hasItems("Michael","Lindsay"));	//This will check that data.first_name will have this names
	}
}
