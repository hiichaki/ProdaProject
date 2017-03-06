package com.proda.controller;

import java.io.File;
import java.util.ArrayList;

import com.proda.main.App;
import com.proda.model.Book;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;
import com.proda.utils.ParseUtils;
import com.proda.utils.Site;
import com.proda.utils.StaticVars;

public class Controller {

	public static ArrayList<String> updated = new ArrayList<String>();

	// TODO: checking by URL if exists
 
	public static void write(Book book) {
		String extension = StaticVars.getExtensions()[0];
		File file = new File(book.getPath() + extension);
		if (file.exists()) {
			FileUtils.checkFile(book, extension);
		} else {
			FileUtils.checkDirectory(App.path + "//" + book.getAuthor());
			FileUtils.writeText(book.getTextStory(), file.getPath());
		}
	}

	public static void download() {
		ArrayList<String> urls = FileUtils.getURLs();
		int total = urls.size();
		int i = 0;
		for (String url : urls) {
			Book book = new Book(url);
			Controller.write(book);
			++i;
			System.out.println("Downloaded: " + i + "/" + total + "\n");
		}
	}

	public static void getThatShit(String url, File file) {
		Site site = HTMLUtils.detectSite(url);
		String story = HTMLUtils.getHTMLStory(url, StaticVars.getValues(site));
		FileUtils.checkDirectory(file.getParent());
		FileUtils.writeText(ParseUtils.parseToText(story), file.getPath());

	}

	public static void getThatHTMLShit(String url, File file) {
		Site site = HTMLUtils.detectSite(url);
		String story = HTMLUtils.getHTMLStory(url, StaticVars.getValues(site));
		FileUtils.checkDirectory(file.getParent());
		FileUtils.writeHTML(story, file.getPath());
	}

	public static void showUpdated() {
		if (updated.isEmpty()) {
			System.out.println("----------nothing new T_T--------------");
		} else {
			System.out.println("New Updates:");
			for (String proda : updated) {
				System.out.println(proda);
			}
		}
	}

}
