package Day_6_Auth;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication {
	@Test(priority=1)
	void testBasicAuthentication() {
		given()	
			.auth().basic("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	@Test(priority=2)
	void testdigestAuthentication() {
		given()	
			.auth().digest("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	@Test(priority=3)
	void testpreemptiveAuthentication() {
		given()	
			.auth().preemptive().basic("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}

}
