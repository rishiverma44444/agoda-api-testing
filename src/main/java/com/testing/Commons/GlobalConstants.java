package com.testing.Commons;

public class GlobalConstants {

	public static final String TEST_RESOURCES = System.getProperty("user.dir")+ "\\src\\main\\java\\com\\testing\\Resources";
	public static final String CONFIG = TEST_RESOURCES + "\\Config.properties";
	public static final String API_AGODA_URI = "API_HOST_AGODA";
	public static final String QUOTES_VALIDATION = "ENDPOINT";
	public static final String QUERY_TAG_AUTHOR = "?tags=famous-quotes|wisdom&author=Confucius";
	public static final String QUERY_TAG_INVALID_AUTHOR = "?tags=famous-quotes|wisdom&author=test";
	public static final String QUERY_VALID_AUTHOR = "&tags=famous-quotes";
	
	
	public static final String PAGE_START = "1";
	public static final String PAGE_SECOND = "2";
	public static final String PAGE_END = "95";
	public static final String PAGE_UNAVAILABLE = "96";
	public static final String PAGE = "page";
	public static final String COUNT = "count";
	public static final String TOTAL_COUNT = "totalCount";
	public static final String TOTAL_COUNT_VALID = "40";
	public static final String TOTAL_COUNT_INVALID = "0";
	public static final String RESULTS = "results";
	public static final String COUNT_INVALID = "0";
	public static final String COUNT_VALID = "20";
	public static final String COUNT_END = "5";
}