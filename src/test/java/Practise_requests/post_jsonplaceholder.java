package Practise_requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class post_jsonplaceholder {
int id;	
private int UserId;
private String Title;
private String body;

public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}

	@Test(priority=1)
	void createUser()
	{
		post_jsonplaceholder data = new post_jsonplaceholder();
		data.setUserId(11);
		data.setTitle("Tale of the nine Tailed");
		data.setBody("Lee Yeon, a mythical creature, strives to protect humans from supernatural threats while searching for the reincarnation of his lost love. He soon crosses paths with a woman bent on exposing him.");
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		 Response res= given()
            	.header("Content-Type", "application/json; charset=utf-8")
            	.body(data)
            
            .when()
            	.post("/posts")
            	
            
            .then()
            	.assertThat()
            	.statusCode(201)  // Validate status code is 201 Created
            	.extract().response();

    System.out.println("Response Code: " + res.statusCode());
    System.out.println("Response Body: " + res.getBody().asString());
	}
	
	@Test(priority=1)
	void updateUser()
	{
		post_jsonplaceholder data = new post_jsonplaceholder();
		data.setUserId(11);
		data.setTitle("Tale of the nine Tailed");
		data.setBody("Lee Yeon, a mythical creature, strives to protect humans from supernatural threats while searching for the reincarnation of his lost love. He soon crosses paths with a woman bent on exposing him.");
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		 Response res= given()
            	.header("Content-Type", "application/json; charset=utf-8")
            	.body(data)
            
            .when()
            	.put("/posts")
            	
            
            .then()
            	.assertThat()
//            	.statusCode(201)  // Validate status code is 201 Created
            	.extract().response();

    System.out.println("Response Code: " + res.statusCode());
    System.out.println("Response Body: " + res.getBody().asString());
	}
}


