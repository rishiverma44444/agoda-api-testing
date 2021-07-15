package com.testing.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommonUtils {

	/** This method will fetch values from property file.
	 * 
	 * @param Key the key<String> against which value need to get fetched
	 * @return value<String> against Key
	 */
	public static String getValue(String Key) {
		File file = new File(GlobalConstants.CONFIG);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(Key);
	}
	
	/** This method will return map 
	 * 
	 * @param key  Parameter Key<String>
	 * @param value Parameter Value<String>
	 * @return Key,Value Map
	 */
	public static Map<String, String> param(String key, String value){
		Map<String, String> map = new HashMap<String, String>();
		map.put(key, value);
		return map;
	}
}
