package com.testing.scripts;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.Commons.BaseAPI;
import com.testing.Commons.CommonUtils;
import com.testing.Commons.GlobalConstants;
import com.testing.Commons.JsonUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestTagAuthorPageFilter extends BaseAPI {
	
	@BeforeClass
	public void startup(){
		
		RestAssured.baseURI = CommonUtils.getValue(GlobalConstants.API_AGODA_URI);
		RestAssured.basePath = CommonUtils.getValue(GlobalConstants.QUOTES_VALIDATION);
	}
	
	@Test(enabled = true , priority = 4 , description = "Positive : Fetch records with Valid tag and Author")
	public void getValidTagAuthor() {
		Response response = getRequest(new HashMap<String, String>(),GlobalConstants.QUERY_TAG_AUTHOR);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.PAGE), GlobalConstants.PAGE_START);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.TOTAL_COUNT), GlobalConstants.TOTAL_COUNT_VALID);
		Assert.assertEquals(JsonUtils.getArraySize(response, GlobalConstants.RESULTS), GlobalConstants.COUNT_VALID);

	}
	
	@Test(enabled = true , priority = 5 , description = "Negative : Fetch records with Valid tag and Invalid Author")
	public void getValidTagInvalidAuthor() {
		
		Response response = getRequest(new HashMap<String, String>(),GlobalConstants.QUERY_TAG_INVALID_AUTHOR);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.PAGE), GlobalConstants.PAGE_START);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.TOTAL_COUNT), GlobalConstants.TOTAL_COUNT_INVALID);
		Assert.assertEquals(JsonUtils.getArraySize(response, GlobalConstants.RESULTS), GlobalConstants.COUNT_INVALID);

	}
	
	@Test(enabled = true , priority = 6 , description = "Positive : Fetch records with Valid tag and valid page number")
	public void getValidTagPage() {
		Response response = RestAssured.given().param("tags", "friendship").param(GlobalConstants.PAGE,GlobalConstants.PAGE_SECOND).log().all().get();
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.PAGE), GlobalConstants.PAGE_SECOND);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.COUNT), GlobalConstants.COUNT_VALID);
		Assert.assertEquals(JsonUtils.getArraySize(response, GlobalConstants.RESULTS), GlobalConstants.COUNT_VALID);

	}
}
