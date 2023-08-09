package com.qa.gorest.client;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Properties;
import java.util.Properties;

import com.qa.gorest.frameworkexception.APIFrameworkException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
//	private static final String BASE_URI ="https://gorest.co.in";
//	private static final String BEARER_TOKEN ="350aa5a8b46bec41bbda8773cc9799a4ebdb51408342146837f9e8408a6ed6f8";
	private static RequestSpecBuilder specBuilder;
	private boolean isAuthorizationHeaderAdded = false;
	private Properties prop;
	private String  baseURI;
	
//	static {
//		specBuilder = new 	RequestSpecBuilder();
//	}
	
	public RestClient(Properties prop, String baseURI) {
		specBuilder = new 	RequestSpecBuilder();
		this.baseURI = baseURI;
		this.prop = prop;
	}
	
	public void addAuthorizationHeader() {
		if (!isAuthorizationHeaderAdded) {
		specBuilder.addHeader("Authorization", "Bearer " + prop.getProperty("tokenId"));
		isAuthorizationHeaderAdded = true;
		}
	}
	
	private void setRequestContentType(String contentType) {
		switch (contentType.toLowerCase()) {
		case "json":
			specBuilder.setContentType(ContentType.JSON);
			break;
        case "xml":
        	specBuilder.setContentType(ContentType.XML);
			break;
        case "text":
        	specBuilder.setContentType(ContentType.TEXT);
	         break;
        case "html":
        	specBuilder.setContentType(ContentType.HTML);
	         break;
        case "multipart":
        	specBuilder.setContentType(ContentType.MULTIPART);
	         break;
		default:
			System.out.println("Please pass the right content type....");
			throw new APIFrameworkException("INVALIDCONTENTTYPE");
		}
	}
	
	private RequestSpecification createRequestSpec() {
		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		return specBuilder.build();	
	}
	
	private RequestSpecification createRequestSpec(Map<String, String>headerMap) {
		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		if(headerMap!=null) {
			specBuilder.addHeaders(headerMap);
		}
		return specBuilder.build();	
	}
	
	private RequestSpecification createRequestSpec(Map<String, String>headerMap, Map<String, String>queryParams) {
		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		if(headerMap!=null) {
			specBuilder.addHeaders(headerMap);
		}
		if(queryParams!=null) {
			specBuilder.addQueryParams(queryParams);
		}
		return specBuilder.build();	
	}
	
	private RequestSpecification createRequestSpec(Object requestBody, String contentType) {
		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		setRequestContentType(contentType);
		if (requestBody!=null) {
			specBuilder.setBody(requestBody);	
		}
		return specBuilder.build();	
	}
	
	private RequestSpecification createRequestSpec(Object requestBody, String contentType, Map<String, String>headerMap) {
		specBuilder.setBaseUri(baseURI);
		addAuthorizationHeader();
		setRequestContentType(contentType);
		if (headerMap!=null) {
			specBuilder.setBody(headerMap);	
		}
		if (requestBody!=null) {
			specBuilder.setBody(requestBody);	
		}
		return specBuilder.build();	
	}
	
	//http methods utils:
	public Response get(String serviceUrl, boolean log) {
		if (log) {
	return  RestAssured.given(createRequestSpec()).log().all()
	           .when()
	           .get(serviceUrl);
		}
		return RestAssured.given(createRequestSpec()).when().get(serviceUrl);   
	}
	
	public Response get(String serviceUrl,Map<String, String>headersMap,Map<String, String>queryParams, boolean log) {
		if (log) {
	return  RestAssured.given(createRequestSpec(headersMap, queryParams)).log().all()
	           .when()
	           .get(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(headersMap, queryParams)).when().get(serviceUrl);   
	}
	
	public Response get(String serviceUrl,Map<String, String>headersMap, boolean log) {
		if (log) {
	return  RestAssured.given(createRequestSpec(headersMap)).log().all()
	           .when()
	           .get(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(headersMap)).when().get(serviceUrl);   
	}
	
	public Response post (String serviceUrl, String contentType, Object requestBody, Map<String, String>headerMap, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headerMap)).log().all()
			.when()
			.post(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(requestBody, contentType, headerMap))
		.when()
		.post(serviceUrl);
	}
	
	public Response post (String serviceUrl, String contentType, Object requestBody, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).log().all()
			.when()
			.post(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(requestBody, contentType))
		.when()
		.post(serviceUrl);
	}
	
	public Response put (String serviceUrl, String contentType, Object requestBody, Map<String, String>headerMap, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headerMap)).log().all()
			.when()
			.put(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(requestBody, contentType, headerMap))
		.when()
		.put(serviceUrl);
	}
	
	public Response put (String serviceUrl, String contentType, Object requestBody, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).log().all()
			.when()
			.put(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(requestBody, contentType))
		.when()
		.put(serviceUrl);
	}
	
	public Response patch (String serviceUrl, String contentType, Object requestBody, Map<String, String>headerMap, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headerMap)).log().all()
			.when()
			.patch(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(requestBody, contentType, headerMap))
		.when()
		.patch(serviceUrl);
	}
	
	public Response patch (String serviceUrl, String contentType, Object requestBody, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).log().all()
			.when()
			.patch(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(requestBody, contentType))
		.when()
		.patch(serviceUrl);
	}
	
	public Response delete (String serviceUrl, boolean log) {
		if (log) {
			return RestAssured.given(createRequestSpec()).log().all()
			.when()
			.delete(serviceUrl);
		}
		return RestAssured.given(createRequestSpec())
		.when()
		.delete(serviceUrl);
	}
	

	public String getAccessToken(String serviceURL, String grantType, String clientId, String clientSecret) {
		//1. POST - get the access token
				RestAssured.baseURI = "https://test.api.amadeus.com";
				
				 String accessToken = given()
					//.header("Content-Type", "application/x-www-form-urlencoded")
					.contentType(ContentType.URLENC)
					.formParam("grant_type",grantType)
					.formParam("client_id", clientId)
					.formParam("client_secret", clientSecret)
				.when()
					.post(serviceURL)
				.then()
					.assertThat()
						.statusCode(200)
						.extract().path("access_token");
					
				System.out.println("access_token: " + accessToken);
		return 	accessToken;	
	}
	
	
}
