package com.maveric.TestAPIreqres;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteApiTestreqrs
{
	@BeforeClass
	public static void setUpEnv() 
	{
		RestAssured.baseURI = "https://reqres.in/api";
	}
	@Test(testName = "Delete user ")
	public void test()
	{
		
		
		 RestAssured
		 .given()
		 .delete("/users/2")
				.then()
				.assertThat()
				.statusCode(204);
			
 
		
	}
	@AfterClass
	public static void tearDownEnv() 
	{
		RestAssured.reset();
	}

}
