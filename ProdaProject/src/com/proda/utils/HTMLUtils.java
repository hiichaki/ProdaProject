package com.proda.utils;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HTMLUtils {

	public static String getContent(String url) {
		String content = null;
		URLConnection connection = null;
		try {
			connection = new URL(url).openConnection();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(connection.getInputStream(), "Windows-1251");
			scanner.useDelimiter("\\Z");
			content = scanner.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return content;
	}

	public static String getHTMLStorySamLib(String url) {
		String content = getContent(url);
		int beginIndex = content.indexOf("<!----------- Собственно произведение --------------->", 1000);
		int endIndex = content.indexOf("<!--------------------------------------------------->", beginIndex + 1);
		System.out.println(beginIndex + " " + endIndex);
		if (beginIndex != endIndex) {
			return content.substring(beginIndex, endIndex);
		}
		return null;
	}

	public static String getHTMLStoryFictionPress(String url) {
		String content = getContent(url);
		int beginIndex = content.indexOf("<div class='storytext");
		int endIndex = content.indexOf("</div><div style='height:5px'></div><");
		System.out.println(beginIndex + " " + endIndex);
		if (beginIndex != endIndex) {
			return content.substring(beginIndex, endIndex);
		}
		return null;
	}

}