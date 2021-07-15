package com.testing.Commons;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonUtils {

	/** This method will  return value from JSON Object for the provided key
	 * 
	 * @param response  Input<Response>
	 * @param key Field<String>
	 * @return Value<String> w.r.t Key
	 */
	public static String getParameterFromResponse(Response response, String key) {

		JsonPath jsonPathEvaluator = response.jsonPath();
		String value = jsonPathEvaluator.get(key).toString();
		return value;
	}

	/** This method will return size from JSON Array for the provided Key
	 * 
	 * @param response  Input<Response>
	 * @param key Field<String>
	 * @return Size<String> w.r.t Key
	 */
	public static String getArraySize(Response response, String key) {
		JSONObject obj = new JSONObject(response.getBody().asString());
		JSONArray jarr = obj.getJSONArray(key);
		return Integer.toString(jarr.length());
	}




}