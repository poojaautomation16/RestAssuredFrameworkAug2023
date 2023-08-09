package com.qa.gorest.tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.pojo.User;
import com.qa.gorest.utils.StringUtils;

public class CreateUserTest extends BaseTest{
	
	RestClient restClient;
	@Test
	public void getAllUserTest() {
		User user = new User("naveen", StringUtils.getRandomEmailId(), "male", "active");
		//restClient = new RestClient();
		Integer userId= restClient.post("/public/v2/users", "json", user, true)
		.then().log().all()
		.assertThat().statusCode(201)
		.extract().path("id");
		System.out.println("User id: " + userId);
		
		//2.GET:
		restClient.get("/public/v2/users/"+userId, true)
		.then().log().all()
		.assertThat().statusCode(200)
		.assertThat().body("id", equalTo(userId));
		
	}

}
