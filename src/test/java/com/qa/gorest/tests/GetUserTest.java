package com.qa.gorest.tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;


public class GetUserTest extends BaseTest {
	//RestClient restclient;
	
//	@BeforeMethod
//	public void getUserSetup() {
//	//	restclient = new RestClient();
//	}

    @Test
    public void getAllUsers() {
    	restClient.get("/public/v2/users", true)
    	.then().log().all()
    	.assertThat().statusCode(200);
    }

    @Test
    public void getUserTest() {
    	restClient.get("/public/v2/users/4269208", true)
    	.then().log().all()
    	.assertThat().statusCode(200)
    	.and().body("id", equalTo(4269208));
    }
    
    @Test
    public void getUserWithQueryParamsTest() {
    	Map<String, String> queryParams = new HashMap<String, String>();
    	queryParams.put("name", "Naveen");
    	queryParams.put("status", "active");
    	restClient.get("/public/v2/users/", queryParams, null, true)
    	.then().log().all()
    	.assertThat().statusCode(200);
    }
    

}
