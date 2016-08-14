package com.proda.utils;

public class ParseUtils {

	public static String parseToText(String html) {
		return html.replaceAll("\\<[^>]*>", "").replaceAll("&nbsp;", "");

	}

	
}
