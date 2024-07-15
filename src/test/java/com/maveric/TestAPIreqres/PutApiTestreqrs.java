package com.maveric.TestAPIreqres;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutApiTestreqrs 
{
	@BeforeClass
	public static void setUpEnv() 
	{
		RestAssured.baseURI = "https://reqres.in/api/";
	}
	
	@Test(testName="Add user by using hash map")
	public void test1() 
	{
		HashMap <String,String> payload=new HashMap<>();
		payload.put("name", "shital");
		payload.put("job", "Testengineer");
		
		
		RestAssured.given().contentType(ContentType.JSON)
		.body(payload)
		.put("users/2")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.body("name", equalTo("shital"))
		.body("job",equalTo("Testengineer"));
		
	}
	
	
	
	@AfterClass
	public static void tearDownEnv() 
	{
		RestAssured.reset();
	}


}
