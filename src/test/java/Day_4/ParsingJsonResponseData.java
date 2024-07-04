package Day_4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData 
{
	//APPROACH 1
	//@Test
	void testJSONResponse1()
	{
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("book[3].title", equalTo("The Lord of the Rings")); //jsonfinder.com for path
		
	}
	//APPROACH 2
	//@Test
	void testJSONResponse2()
	{
		Response res =given()
			.contentType(ContentType.JSON) 
			
		.when()
			.get("http://localhost:3000/store");
			Assert.assertEquals(res.getStatusCode(), 200);	//validation 1
			Assert.assertEquals(res.header("Content-Type"), "application/json");
			
			String bookname =res.jsonPath().get("book[3].title").toString();
			Assert.assertEquals(bookname, "The Lord of the Rings");
	}
	
	@Test
	void testJSONResponseBodyData()
	{
		Response res =given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/store");
//			Assert.assertEquals(res.getStatusCode(), 200);	//validation 1
//			Assert.assertEquals(res.header("Content-Type"), "application/json");
//			
//			String bookname =res.jsonPath().get("book[3].title").toString();
//			Assert.assertEquals(bookname, "The Lord of the Rings");
		
			JSONObject jo =new JSONObject(res.asString());	//converting resposonse to json obj type
			
			
			/*for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				System.out.println(booktitle);
			}*/
			
			//search or title of book in json validation -1
			boolean status =false;
			
			for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				if(booktitle.equals("The Lord of the Rings"))
				{
					status = true;
					break;
				}
			}
			Assert.assertEquals(status, true);
			
			//validate total price of books  -validation 2
			double totalprice =0;
			for(int i=0;i<jo.getJSONArray("book").length();i++)
				{
					String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
					totalprice =totalprice +Double.parseDouble(price);
				}
			System.out.println("Total price of book is : "+totalprice);
			Assert.assertEquals(totalprice, 53.92);
			
	}
	
	

}
