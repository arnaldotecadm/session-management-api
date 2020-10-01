package br.com.emerion.util;

import org.json.simple.JSONObject;

public class BooleanUtil {

	private BooleanUtil() {
		/**
		 * Just to hide the public one
		 */
	}
	
	public static boolean getFromJsonProp(JSONObject obj, String prop) {
		if(obj.containsKey(prop)) {
			return (Long) obj.get("FFlgDeletado") == 1 ;
		} else {
			return true;
		}
	}
}
