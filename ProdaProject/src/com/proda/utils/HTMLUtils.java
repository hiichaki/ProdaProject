package com.proda.utils;

import java.io.IOException;
import java.net.InetAddress;
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
			System.out.println("failed to connect: " + url);
		}

		return content;
	}

	public static String getHTMLStory(String url, String[] findVar) {
		String content = getContent(url);
		int beginIndex = content.indexOf(findVar[0], 1000);
		int endIndex = content.indexOf(findVar[1], beginIndex + 1);

		System.out.println(beginIndex + " " + endIndex);
		if (beginIndex != endIndex) {
			return content.substring(beginIndex, endIndex);
		}
		return null;
	}

	public static Site detectSite(String url) {
		if (url.contains("samlib.ru")) {
			return Site.samLib;
		}
		if (url.contains("fictionpress.com")) {
			return Site.fictionpress;
		}
		if (url.contains("ficbook.net")) {
			return Site.ficbook;
		}
		return null;
	}

	public static boolean hasInternetConnection() {
		try {
			InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
			for (InetAddress address : addresses) {
				if (address.isReachable(10000)) {
					return true;
				} 
			}
		} catch (IOException e) {
			System.out.println("connection failed!");
			return false;
		}
		return false;
	}

}
