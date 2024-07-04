package Day_3;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo 
{
	//@Test
	void TestHeaders()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
			
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server", "gws")
			.log().all();
	}
	@Test
	void getHeaders()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		//get single header info 
//	String header_value = res.getHeader("Content-Type");
//	System.out.println("the value of content type header is : "+header_value);
		Headers myheaders =res.getHeaders();
		for(Header hd: myheaders)
		{
			
			System.out.println(hd.getName()+"    "+hd.getValue());
		}

	}
}
