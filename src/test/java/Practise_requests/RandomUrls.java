package Practise_requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RandomUrls {
	
	int id;
	String name;
	String location;
	String phone;
	String courses[]; 
	
	@Test(priority=1)
	void createUser()
	{
		RandomUrls data = new RandomUrls();
		data.setId(4);
		data.setPhone("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		
		String courseArr[]= {"C","C++"};
		data.setCourses(courseArr);
		
		RestAssured.baseURI = "https://random-data-api.com";
		 
		        Response response = given()
		                	.header("Content-Type", "application/json")
		                	.header("X-Project-Id", "63ed8a3b-5d90-436b-86b6-04ae4e260e20")
		                	.header("X-Api-Key", "FwPv9ftaodeYOPcO1sgSLA")
		                	.body(data)
		                
		                .when()
		                	.post("/api/v3/post_requests")
		                
		                .then()
		                	.assertThat()
		                	.statusCode(201)  // Validate status code is 201 Created
		                	.extract().response();
		 
		        System.out.println("Response Code: " + response.getStatusCode());
		        System.out.println("Response Body: " + response.getBody().asString());
		    }

	private void setId(int i) {
		this.id =id;
				
		
	}

	private void setPhone(String string) {
		this.phone =phone;
		
	}

	private void setLocation(String string) {
		this.location=location;
		
		
	}

	private void setCourses(String[] courseArr) {
		this.courses=courses;
		
	}	
}
