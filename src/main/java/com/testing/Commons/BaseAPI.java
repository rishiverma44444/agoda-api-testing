package com.testing.Commons;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author Rishi Verma
 *
 */
public class BaseAPI {
	
	/**This method will return Get response
	 * 
	 * @param uri  The API<String>
	 * @param param The Query Parameter
	 * @return Response
	 */
	public static Response getRequest(Map<String, String> param,String...uri) {
			
		if(param.size() > 0){
			Response response = RestAssured.given().contentType(ContentType.JSON).queryParams(param).accept("application/json").when().relaxedHTTPSValidation().log().all().get();
			response.getBody().prettyPrint();
			return response;
		} else {
			Response response = RestAssured.given().contentType(ContentType.JSON).accept("application/json").when().relaxedHTTPSValidation().log().all().get(uri[0]);
			response.getBody().prettyPrint();
			return response;			
		}
	}

	/**This method will return Post response
	 * 
	 * @param uri  The API<String>
	 * @param requestBody The Body
	 * @return Response
	 */
	public static Response postRequest(String uri, Object requestBody) {

			Response response = RestAssured.given().contentType(ContentType.JSON).accept("application/json").body(requestBody).log().all().post(uri);
			response.getBody().prettyPrint();
			return response;
	}

	/**This method will return Put response
	 * 
	 * @param uri  The API<String>
	 * @param requestBody The Body
	 * @return Response
	 */
	public static Response putRequest(String uri, Object requestBody) {

			Response response = RestAssured.given().contentType(ContentType.JSON).accept("application/json").body(requestBody).log().all().put(uri);
			response.getBody().prettyPrint();
			return response;
		
	}

	/**This method will return Delete response
	 * 
	 * @param uri  The API<String>
	 * @param param The Query Parameter
	 * @return Response
	 */
	public static Response deleteAPIRequest( Map<String, String> param ,String...uri) {

		if(param != null){
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").queryParams(param).when().relaxedHTTPSValidation().log().all().delete();
			response.getBody().prettyPrint();
			return response;
		} else {
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").when().relaxedHTTPSValidation().log().all().delete(uri[0]);
			response.getBody().prettyPrint();
			return response;
			
		}
	}
}
