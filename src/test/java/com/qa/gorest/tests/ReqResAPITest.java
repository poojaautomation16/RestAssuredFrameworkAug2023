package com.qa.gorest.tests;

import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;

public class ReqResAPITest extends BaseTest {
	
	@Test
    public void getAllUsers() {
    	restClient.get("/api/user/2", true)
    	.then().log().all()
    	.assertThat().statusCode(200);
    }

}
