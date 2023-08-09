package com.qa.gorest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.utils.JsonPathValidator;

import io.restassured.response.Response;

public class CircuitTest extends BaseTest {
	
	 @Test
	    public void getAllUsers() {
	    	Response circuitResponse = restClient.get("/api/f1/2017/circuits.json", false);
	    	int statuscode = circuitResponse.statusCode();
	    	Assert.assertEquals(statuscode, 200);
	    	
	    	JsonPathValidator js = new JsonPathValidator();
	    	List<String> countryList=	js.readList(circuitResponse, "$.MRData.CircuitTable.Circuits[?(@.circuitId == 'shanghai')].Location.country");
	    	System.out.println(countryList);
	    	Assert.assertTrue(countryList.contains("China"));	    	
//	    	.then().log().all()
//	    	.assertThat().statusCode(200);
	    }


}
