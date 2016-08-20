package com.proda.model;

import com.proda.main.App;
import com.proda.utils.HTMLUtils;
import com.proda.utils.ParseUtils;
import com.proda.utils.Site;
import com.proda.utils.StaticVars;

public class Book {

	private transient String content;
	private transient String HTMLStory;
	private transient String TextStory;

	private Site site;
	private String author;
	private String title;
	private String url;
	private String path;

	public Book(String url) {
		setUrl(url);
		setSite(HTMLUtils.detectSite(url));
		if (getSite().equals(Site.ficbook)) {
			url = url.replace("readfic", "printfic");
		}

		System.out.println("------------------------------");

		System.out.print("getting content: ");
		setContent(HTMLUtils.getContent(url));
		System.out.println("done");

		System.out.print("getting site: ");
		String[] findVar = StaticVars.getValues(site);
		System.out.println(getSite());

		int beginIndex = content.indexOf(findVar[0], 1000);
		int endIndex = content.indexOf(findVar[1], beginIndex + 1);

		System.out.println(beginIndex + " " + endIndex);
		if (beginIndex != endIndex) {
			System.out.print("gettin HTMLStory: ");
			setHTMLStory(content.substring(beginIndex, endIndex));
			System.out.println("done");
		} else {
			System.out.println("failed to find template on: " + getUrl());
			setHTMLStory(null);
		}

		System.out.print("gettin TextStory: ");
		setTextStory(ParseUtils.parseToText(getHTMLStory()));
		System.out.println("done");

		beginIndex = content.indexOf(findVar[2]);
		endIndex = content.indexOf(findVar[3], beginIndex + 1);

		System.out.print("getting author: ");
		setAuthor(ParseUtils.parseToText(content.substring(beginIndex, endIndex)).trim());
		System.out.println(getAuthor());

		beginIndex = content.indexOf(findVar[4]);
		endIndex = content.indexOf(findVar[5], beginIndex + 1);

		System.out.print("getting title: ");
		setTitle(ParseUtils.getProperFileName(
				ParseUtils.parseToText(content.substring(beginIndex, endIndex).replace(".", "")).trim()));
		System.out.println(getTitle());

		setPath(App.path + "//" + getAuthor() + "//" + getTitle());

	}

	public String getHTMLStory() {
		return HTMLStory;
	}

	public void setHTMLStory(String hTMLStory) {
		HTMLStory = hTMLStory;
	}

	public String getTextStory() {
		return TextStory;
	}

	public void setTextStory(String textStory) {
		TextStory = textStory;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
