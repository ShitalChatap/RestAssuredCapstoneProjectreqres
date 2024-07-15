package com.maveric.TestAPIreqres;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.apache.http.HttpStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchApiTestreqrs 
{
	@BeforeClass
	public static void setUpEnv() 
	{
		RestAssured.baseURI = "https://reqres.in/api/";
	}
	
	@Test(testName="Patch user details")
	public void test() 
	{
		HashMap <String,String> payload=new HashMap<>();
		payload.put("name", "shital");
		payload.put("job", "testassociate");
		
		
		RestAssured.given().contentType(ContentType.JSON)
		.body(payload)
		.patch("users/2")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.body("name", equalTo("shital"))
		.body("job",equalTo("testassociate"));
		
	}
	
	
	
	@AfterClass
	public static void tearDownEnv() 
	{
		RestAssured.reset();
	}
	

}
