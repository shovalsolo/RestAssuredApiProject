/* 
 * This test is an example of Data Driven test that is using TestNG @DataProvider annotation  to delete data
 * Returning an array with the data
 * For this test to run need to create ID=12 , ID=13 , ID=14
 */

package mockAPIDataDriven;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class DataDrivenDeleteExampleStatic3 {
	
	@DataProvider(name="DataToDelete")			//Setting an DataProvider with a name DataToDelete 
	public Object[]dataForDelete() {			
		
		return new Object[] {					//Returning an array of ID's to delete
			12,14,13							//The ID numbers to delete - this is static - need to add the numbers manually 
		};
	}

	
	@Test(dataProvider = "DataToDelete")		//Passing the DataProvider with a name DataToDelete
	public void test_1(int userId) {

		baseURI = "http://localhost:3000/";

		when()
		.delete("/users/"+userId)				//Concatenation of the array
		.then()
		.statusCode(200)
		.log().all();
	}

}
