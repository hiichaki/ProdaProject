package com.proda.utils;

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
		return html.replaceAll("<font[^>]*>", "")
				.replaceAll("</font>", "");
	}

	

}
