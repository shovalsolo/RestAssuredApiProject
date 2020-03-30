/* 
 * This test is an example of Data Driven test that is using TestNG @DataProvider annotation  
 */

package mockAPIDataDriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenPOSTExampleStatic1 {
	
	@DataProvider(name="DataForPost")										//Using TestNG @DataProvider with name of DataForPost that we will pass to the function to use
	public Object [][] dataForPost() {										//This function is returning a 2 dimensional object 
		
		Object[][] data = new Object[2][3];									//Creating the object
		
		data[0][0]= "Alont";												//Populating it
		data[0][1]= "Sok";
		data[0][2]= 2;
		
		data[1][0]= "Tal";
		data[1][1]= "De";
		data[1][2]= 1;
		
		return data;														//Returning in the end
	}
	
	
	@Test(dataProvider = "DataForPost")										//Passing the data provider to the function
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
