package com.hx.eplate.trafficdata.query.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Map存取工具
 * Version: 1.0<br>
 * Date: 2017年8月30日
 */
public class MapUtils {
	private static Map<String, String> map=new HashMap<String, String>();
	
	/**
	 * 存Map
	 * Date: 2017年8月30日<br>
	 * @return String
	 */
	public static void setMap(String key, String value) {
		map.put(key, value);
	}
	
	/**
	 * 取Map
	 * Date: 2017年8月30日<br>
	 * @return String
	 */
	public static String getMap(String key) {
		return map.get(key);
	}


}