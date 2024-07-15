package com.maveric.TestAPIreqres;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApireqresTest 
{
	@BeforeClass
	public static void setUpEnv() 
	{
		RestAssured.baseURI = "https://reqres.in/api/";
	}
	@Test(testName = "Get LIST of  USERS details  ")
	public void test1()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/users?page=2");
		Assert.assertEquals(response.getStatusCode(), 200);
 
		// validatable response
		String responseBody = RestAssured.get("/users?page=2")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	@Test(testName = "Get SINGLE USER details")
	public void test2()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/users/2");
		Assert.assertEquals(response.getStatusCode(), 200);
 
		// validatable response
		String responseBody = RestAssured.get("/users/2")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	@Test(testName = "Get SINGLE USER NOT FOUND ")
	public void test3()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/users/23");
		Assert.assertEquals(response.getStatusCode(), 404);
 
		// validatable response
		String responseBody = RestAssured.get("/users/23").then()
				.assertThat()
				.statusCode(404)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	@Test(testName = "Get LIST <RESOURCE> details")
	public void test4()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/unknown");
		Assert.assertEquals(response.getStatusCode(), 200);
 
		// validatable response
		String responseBody = RestAssured.get("/unknown").then()
				.assertThat()
				.statusCode(200)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	@Test(testName = "Get SINGLE <RESOURCE> details ")
	public void test5()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/unknown/2");
		Assert.assertEquals(response.getStatusCode(), 200);
 
		// validatable response
		String responseBody = RestAssured.get("/unknown/2")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	@Test(testName = "Get SINGLE <RESOURCE> NOT FOUND details ")
	public void test6()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/users?page=2");
		Assert.assertEquals(response.getStatusCode(), 200);
 
		// validatable response
		String responseBody = RestAssured.get("/users?page=2")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	@Test(testName = "Get DELAYED RESPONSE user details ")
	public void test7()
	{
		// normal response required Assertion to test (old way)
		Response response = RestAssured.get("/users?delay=3");
		Assert.assertEquals(response.getStatusCode(), 200);
 
		// validatable response
		String responseBody = RestAssured.get("/users?delay=3")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.log()
				.body()
				.toString();
		System.out.println(responseBody);
 
		
	}
	
	
	@AfterClass
	public static void tearDownEnv() 
	{
		RestAssured.reset();
	}

}
