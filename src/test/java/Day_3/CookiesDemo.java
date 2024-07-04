package Day_3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo 
{
	//@Test
	void TestCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
			
		.then()
			.cookie("AEC")
			.log().all();
	}
	
	@Test(priority=2)
	void GetCookiesInfo()
	{
		Response  res =given()
		
		.when()
			.get("https://www.google.com/");
		
	//get single cookie info
//		 String cookie_value=res.getCookie("AEC");
//		 System.out.println("Value of cookie is :"+cookie_value);

	//Get all cookies info
		Map<String,String>cookies_value =res.getCookies();
//		System.out.println("Value of cookies are :"+cookies_value.keySet());
		for(String k: cookies_value.keySet())
		{
			String cookies_values =res.getCookie(k);
			System.out.println(k+"    "+cookies_values);
		}
	}

}
