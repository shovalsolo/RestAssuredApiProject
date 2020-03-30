/* 
 * This test is an example of Data Driven test that is using TestNG @DataProvider annotation  
 * Returning an array with the data
 * This class is using DataForTests To create the data
 */

package mockAPIDataDriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenPOSTExampleFromClass4 extends DataForTests {
		
	
	@Test(dataProvider = "DataForPostFromClass")										//Passing the data provider to the function
	public void test_1(String firstName, String lastName, int subjectID) {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();								//Creating the object and adding the data - the ID is auto generated
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectID);
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)			//Will accept only type of JSON
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}

}
