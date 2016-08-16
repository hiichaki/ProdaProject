package com.proda.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import com.proda.controller.MainController;

public class HTMLUtils {

	private String content;
	private Site site;
	private String[] findVar;
	private String author;
	private String title;

	public HTMLUtils(String url) {
		setSite(detectSite(url));
		if (getSite().equals(Site.ficbook)) {
			url = url.replace("readfic", "printfic");
		}
		System.out.println("------------------------------");
		System.out.println("getting content");
		setContent(getContent(url));
		System.out.println("getting site");
		findVar = StaticVars.getValues(site);

		int beginIndex = content.indexOf(findVar[2]);
		int endIndex = content.indexOf(findVar[3], beginIndex + 1);
		System.out.println("getting author");
		setAuthor(ParseUtils.parseToText(content.substring(beginIndex, endIndex)).trim());

		beginIndex = content.indexOf(findVar[4]);
		endIndex = content.indexOf(findVar[5], beginIndex + 1);
		System.out.println("getting title");
		setTitle(ParseUtils.parseToText(content.substring(beginIndex, endIndex).replace(".", "")).trim());
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
			System.out.println("failed to connect: " + url);
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
				} else {
					System.out.println("Internet connection fail!");
					return false;
				}
			}

		} catch (IOException e) {
			System.out.println("Internet connection fail!");
			return false;
		}
		return false;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
