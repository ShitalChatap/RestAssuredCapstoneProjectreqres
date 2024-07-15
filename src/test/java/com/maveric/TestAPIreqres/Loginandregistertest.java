package com.maveric.TestAPIreqres;

import static org.hamcrest.CoreMatchers.equalToObject;

import java.io.FileInputStream;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.TestApi.UserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Loginandregistertest 
{
	@BeforeClass
	public static void setUpEnv() 
	{
		RestAssured.baseURI = "https://reqres.in/api/";
	}
	@Test(testName ="register user details ")
	public  void testregister() throws Exception {
		
		ObjectMapper mapper=new ObjectMapper();
		FileInputStream stream=new FileInputStream("./TestData/RegistrationsuccessfulData.json");
		UserPojo  payload=mapper.readValue(stream, UserPojo.class);
 
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(payload)
			.post("/register")
			.then()
			.statusCode(200);
	}
	
	@Test(testName ="login user details ")
	public  void testlogin() throws Exception {
		
		ObjectMapper mapper=new ObjectMapper();
		FileInputStream stream=new FileInputStream("./TestData/loginsuccessfulData.json");
		UserPojo  payload=mapper.readValue(stream, UserPojo.class);
 
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(payload)
			.post("/login")
			.then()
			.statusCode(200);
	}
	
	
	@Test(testName ="register user with invalid details ")
	public  void testinvalidregister() throws Exception {
		
		ObjectMapper mapper=new ObjectMapper();
		FileInputStream stream=new FileInputStream("./TestData/RegUnsuccessfulData.json");
		//UserPojo  payload=mapper.readValue(stream, UserPojo.class);
		UserPojo payload =mapper.readValue("stream", UserPojo.class);
 
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(payload)
			.post("/register")
			.then()
			.statusCode(400)
			. assertThat()
			.body("error",equalToObject("Missing password"));
	}
	
	@Test(testName ="login user with invalid details ")
	public  void testinvalidlogin() throws Exception {
		
		ObjectMapper mapper=new ObjectMapper();
		FileInputStream stream=new FileInputStream("./TestData/loginUnsuccessfulData.json");
		UserPojo  payload=mapper.readValue(stream, UserPojo.class);
 
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(payload)
			.post("/login")
			.then()
			.statusCode(400)
			.assertThat()
			.body("error",equalToObject("Missing password"));
	}
	@AfterClass
	public static void tearDownEnv() 
	{
		RestAssured.reset();
	}

}
