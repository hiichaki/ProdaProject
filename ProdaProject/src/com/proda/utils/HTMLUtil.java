package com.proda.utils;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HTMLUtil {
	
	public static String getContent(String url) {
		String content = null;
		URLConnection connection = null;
		try {
			connection = new URL(url).openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			content = scanner.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return content;
	}
	
	
}
