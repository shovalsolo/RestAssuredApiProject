/* 
 * This test is an example of POST request need to import the following:
 * import static io.restassured.RestAssured.*;								//When importing RestAssured in a static way we need to create an object of RestAssured										
 * Add one of the following to POM.xml
 * json.simple - this is the one i selected
 * gson
 * jackson-core
 * json
 */

package test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_POST {

	@Test
	public void test_1_post() {											//Using HashMap

		Map<String, Object > map = new HashMap<String, Object>();		//Crating HashMap and poulating with data

		map.put("name", "James");
		map.put("Job", "Teacher");

		System.out.println(map);

		JSONObject request = new JSONObject(map);						//We can use JSONObject after we added json.simple to the POM.xml

		System.out.println(request);									//This will print the data in a json formation
		System.out.println(request.toJSONString());						//Can also use toJSONString to set the json format

		given()
			.body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
				.log().all()
				.statusCode(201);										//The status of created is 201
	}

	@Test
	public void test_2_post() {											//Using JSONObject

		JSONObject request = new JSONObject();							//We can use JSONObject after we added json.simple to the POM.xml

		request.put("name", "Lion");
		request.put("Job", "driver");

		System.out.println(request);									//This will print the data in a json formation
		System.out.println(request.toJSONString());						//Can also use toJSONString to set the json format

		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)		//Will accept only type of JSON
			.body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.log().all()
			.statusCode(201);											//The status of created is 201
	}
}
