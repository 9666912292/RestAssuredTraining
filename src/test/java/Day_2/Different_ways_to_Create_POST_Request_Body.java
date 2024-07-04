package Day_2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Different_ways_to_Create_POST_Request_Body {
	int id;
	//Post request body using HasMap
	//@Test(priority=1)
	void testPostUsingHasMap() 
	{
		
		HashMap data =new HashMap();
		data.put("id", "4");
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("id", equalTo("4"))
			.body("name", equalTo("Scott"))
			.body("location", equalTo("France"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();	
	}
	//Post request body using org.json library
	//@Test(priority=1)
	void testPostUsingjsonlibrary() 
	{
		JSONObject data = new JSONObject();
		data.put("id", "4");
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("Phone", "123456");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("id", equalTo("4"))
			.body("name", equalTo("Scott"))
			.body("location", equalTo("France"))
			.body("Phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();	
	}
	//Post request body using POJO class
	//@Test(priority=1)
	void testPostUsingPOJO() 
	{
		POJO_postRequest data = new POJO_postRequest();
		data.setId(4);
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		
		String courseArr[]= {"C","C++"};
		data.setCourses(courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("id", equalTo(4))
			.body("name", equalTo("Scott"))
			.body("location", equalTo("France"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();	
	}
	//Post request body using External Json File
		//@Test(priority=1)
		void testPostUsingExternalJsonFile() throws FileNotFoundException 
		{
			File f=new File(".\\body.json");
			FileReader fr= new FileReader(f);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data =new JSONObject(jt);
			
			given()
				.contentType("application/json")
				.body(data.toString())
				
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("id", equalTo(4))
				.body("name", equalTo("Scott"))
				.body("location", equalTo("France"))
				.body("phone", equalTo("123456"))
				.body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++"))
				.header("Content-Type", "application/json")
				.log().all();	
		}
	//Deleting Student request
	@Test(priority=1)
	void TestDeleteUser()
	{
		given()
			
		.when()
			.delete("http://localhost:3000/students/4")
		
		.then()
			.statusCode(200);		
	}
}
