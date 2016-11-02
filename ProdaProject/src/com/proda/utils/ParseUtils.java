package com.proda.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ParseUtils {

	public static String parseToText(String html) {
		return html.replaceAll("<p[^>]*>","\r\n")
				.replaceAll("<br />", "\r\n")
				.replaceAll("&#8212;", "—")
				.replaceAll("&#8211;", "–")
				.replaceAll("&#8230;", "…")
				.replaceAll("&#171;", "«")
				.replaceAll("&#187;", "»")
				.replaceAll("&#8217;", "’")
				.replaceAll("\\<[^>]*>", "")
				.replaceAll("&nbsp;", "");

	}
	
	public static String deleteFail(String html) {
		return remove(html, new String[]{"<font[^>]*>","</font>"});
		
	}
	
	public static String getProperFileName(String title) {
		return remove(title, new String[]{"?","<",">","|","\\","/","*",":","\""});
		
	}

	private static String remove(String str, String[] fails) {
		for(String fail: fails) {
			str = str.replace(fail, "");
		}
		return str;
		
	}
	
	public static ArrayList<String> toList(String story) {
		return new ArrayList<String>(Arrays.asList(story.split("\n")));
		
	}
	

}
