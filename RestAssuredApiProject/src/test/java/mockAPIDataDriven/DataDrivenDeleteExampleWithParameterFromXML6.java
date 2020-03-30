/* 
 * This test is an example of Data Driven test that is using TestNG @DataProvider annotation  to delete data
 * Returning an array with the data
 * For this test to run need to create ID=12 , ID=13 , ID=14 need to run DataDrivenPOSTExampleFromClass4 before
 * This class is using DataForTests To delete the data
 * This file is running from XML file testngDeleteWithParameter.xml
 */

package mockAPIDataDriven;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class DataDrivenDeleteExampleWithParameterFromXML6 {

	@Parameters({"userId"})
	@Test
	public void test_1(int userId) {							//This parameter is coming from testngDeleteWithParameter.xml
		
		System.out.println("Value for userId is : " + userId);
		baseURI = "http://localhost:3000/";

		when()
		.delete("/users/"+userId)								//Concatenation of the parameter to delete
		.then()
		.statusCode(200)
		.log().all();
	}

}
