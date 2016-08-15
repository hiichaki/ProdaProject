package com.proda.utils;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HTMLUtils {

	private String content;
	private Site site;
	private String[] findVar;
	private String author;

	public HTMLUtils(String url) {
		setContent(getContent(url));
		setSite(detectSite(url));
		findVar = StaticVars.getValues(site);
		int beginIndex = content.indexOf(findVar[2]);
		int endIndex = content.indexOf(findVar[3],beginIndex+1);
		author = ParseUtils.parseToText(content.substring(beginIndex, endIndex));
	}

	private String getContent(String url) {
		String content = null;
		URLConnection connection = null;
		try {
			connection = new URL(url).openConnection();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(connection.getInputStream(), "Windows-1251");
			scanner.useDelimiter("\\Z");
			content = scanner.next();
		} catch (Exception ex) {
			System.out.println("failed to connect: "+ url);
		}

		return content;
	}

	public String getHTMLStory() {
		int beginIndex = content.indexOf(findVar[0], 1000);
		int endIndex = content.indexOf(findVar[1], beginIndex + 1);

		System.out.println(beginIndex + " " + endIndex);
		if (beginIndex != endIndex) {
			return content.substring(beginIndex, endIndex);
		}
		return null;
	}

	private Site detectSite(String url) {
		if (url.contains("samlib.ru")) {
			return Site.samLib;
		}
		if (url.contains("fictionpress.com")) {
			return Site.fictionpress;
		}
		return null;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
