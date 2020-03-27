/* 
 * This test is an example of POST request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way ne need to create an object of RestAssured
 * import static io.restassured.matcher.RestAssuredMatchers.*;				
 * import static org.hamcrest.Matchers.*;									
 * import io.restassured.response.Response;
 * Add one of the following to POM.xml
 * json.simple - this is the one i selected
 * gson
 * jackson-core
 * json
 */

package test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_POST {
	
	@Test
	public void test_1_post() {
		
		Map<String, Object > map = new HashMap<String, Object>();
		
		map.put("name", "James");
		map.put("Job", "Teacher");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject();						//We can use JSONObject after we added json.simple to the POM.xml
	}

}
