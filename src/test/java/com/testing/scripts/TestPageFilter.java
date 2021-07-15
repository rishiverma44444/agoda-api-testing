package com.testing.scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testing.Commons.BaseAPI;
import com.testing.Commons.CommonUtils;
import com.testing.Commons.CustomReporter;
import com.testing.Commons.GlobalConstants;
import com.testing.Commons.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(CustomReporter.class)
public class TestPageFilter extends BaseAPI {
	
	@BeforeClass
	public void startup(){
		RestAssured.baseURI = CommonUtils.getValue(GlobalConstants.API_AGODA_URI);
		RestAssured.basePath = CommonUtils.getValue(GlobalConstants.QUOTES_VALIDATION);;
	}
	
	//Not including "Null" Case as API response is same as page number 1 (Same mentioned in API contract as well that default value of page is 1)
	@Test(enabled = true , priority = 1 , description = "Positive : Fetch records with valid page number 1")
	public void getValidPageStart(){
		Response response = getRequest(CommonUtils.param(GlobalConstants.PAGE, GlobalConstants.PAGE_START));
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.PAGE), GlobalConstants.PAGE_START);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.COUNT), GlobalConstants.COUNT_VALID);
		Assert.assertEquals(JsonUtils.getArraySize(response, GlobalConstants.RESULTS), GlobalConstants.COUNT_VALID);
	}

	//Using boundary value technique to test valid input with max available page number
	@Test(enabled = true ,priority = 2 , description = "Positive : Fetch records with max valid page number 95")
	public void getValidPageEnd(){
		Response response = getRequest(CommonUtils.param(GlobalConstants.PAGE, GlobalConstants.PAGE_END));
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.PAGE), GlobalConstants.PAGE_END);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.COUNT), GlobalConstants.COUNT_END);
		Assert.assertEquals(JsonUtils.getArraySize(response, GlobalConstants.RESULTS), GlobalConstants.COUNT_END);
	}
	
	//Using boundary value technique to test input with unavailable pages
	@Test(enabled = true ,priority = 3 , description = "Negative : Fetch records with Invalid page number 96")
	public void getValidPageInvalid(){
		Response response = getRequest(CommonUtils.param(GlobalConstants.PAGE, GlobalConstants.PAGE_UNAVAILABLE));
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.PAGE), GlobalConstants.PAGE_UNAVAILABLE);
		Assert.assertEquals(JsonUtils.getParameterFromResponse(response, GlobalConstants.COUNT), GlobalConstants.COUNT_INVALID);
		Assert.assertEquals(JsonUtils.getArraySize(response, GlobalConstants.RESULTS), GlobalConstants.COUNT_INVALID);
	}
}
