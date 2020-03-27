/* 
 * This test is an example of get request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 * import static io.restassured.matcher.RestAssuredMatchers.*;				//Need to include
 * import static org.hamcrest.Matchers.*;									//Need to include
 * import io.restassured.response.Response;
 */

package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
import static io.restassured.matcher.RestAssuredMatchers.*;				//Need to include
import static org.hamcrest.Matchers.*;									//Need to include
import io.restassured.response.Response;

public class Test01_GET {
	
	@Test
	void test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2"); // saving the response into the response parameter
		
		
		System.out.println(response.asString());									//Will print the whole string
		System.out.println("\n");
		System.out.println(response.getBody().asString());							//Will print the 
		System.out.println("\n");
		System.out.println(response.getStatusCode());								//Will print theStatus code
		System.out.println("\n");
		System.out.println(response.getStatusLine());								//Will print the Status Line
		System.out.println("\n");
		System.out.println(response.getHeader("content-type"));						//Will print the Header ("content-type")
		System.out.println("\n");
		System.out.println(response.getTime());										//Will print the time
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200); 										//Checking if statusCode is not Equals to 200 will assert the test will fail
	}
	
	@Test
	void test_02() {
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)													//Checking the the status code from this get call is 200 
				.body("data.id[0]", equalTo(7));
	}
	
	@Test
	void test_03() {
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(201);													//Checking the the status code from this get call is 201 * this will fail
	}
	
	@Test
	void test_04() {
		given()
			.get("https://reqres.in/api/users")
			.then()
				.statusCode(200).log().all();										//Checking the the status code from this get call is 201 * this will fail
	}
}
