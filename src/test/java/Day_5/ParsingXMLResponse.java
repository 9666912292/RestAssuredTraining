package Day_5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {

	@Test
	void testXMLResponse()
	{
		//Approach1
		
		given()
		
		.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Books")
		.then()
			.statusCode(200);
//			.header("Content-Type","application/json; charset=utf-8; v=1.0")
//			.body("TravelerinformationResponse.page", equalTo("1"))
//			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Vijay Bharath Reddy"));
		
		
		//Approach2
//		
//		Response res=
//		given()
//		
//		.when()
//			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
//		
//		Assert.assertEquals(res.getStatusCode(), 200);
//		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
//		
//		String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
//		Assert.assertEquals(pageNo, "1");
//		
//		String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
//		Assert.assertEquals(travelName, "Vijay Bharath Reddy");
//	
	}

}
