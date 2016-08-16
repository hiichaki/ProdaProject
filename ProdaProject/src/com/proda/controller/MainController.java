package com.proda.controller;

import java.io.File;

import com.proda.main.App;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;
import com.proda.utils.ParseUtils;

public class MainController {

	// public static void getFromFictionPress(int fromChapter, int... toChapter)
	// {
	// if (toChapter.length != 0) {
	// for (int i = fromChapter; i < toChapter[0]; ++i) {
	// finded = getStoryByURL("https://www.fictionpress.com/s/2961893/" + i +
	// "/Mother-of-Learning");
	// }
	// } else {
	// finded = getStoryByURL("https://www.fictionpress.com/s/2961893/" +
	// fromChapter + "/Mother-of-Learning");
	// }
	// }

	// TODO: checking by URL if exists

	private static HTMLUtils init(String url) {
		HTMLUtils htmlUtil = new HTMLUtils(url);
		String story = htmlUtil.getHTMLStory();
		String author = htmlUtil.getAuthor();
		String title = htmlUtil.getTitle();

		if (story == null) {
			System.out.println("failed to find template on: " + url);
			return null;
		} else {
			System.out.println("author: " + author);
			System.out.println("title: " + title);
			FileUtils.checkDirectory(App.path + "//" + author);

			String path = App.path + "//" + author + "//" + title;
			htmlUtil.setPath(path);

			return htmlUtil;
		}

	}

	public static void getText(String url) {
		HTMLUtils htmlUtil = init(url);
		String story = ParseUtils.parseToText(htmlUtil.getHTMLStory());
		htmlUtil.setContent(story);
		String path = htmlUtil.getPath() + ".txt";
		htmlUtil.setPath(path);
		File file = new File(path);
		if (file.exists()) {
			FileUtils.checkFile(htmlUtil);
		} else {
			FileUtils.writeText(story, path);
		}
	}

	public static void getHTML(String url) {
		HTMLUtils htmlUtil = init(url);
		String story = htmlUtil.getHTMLStory();
		String path = htmlUtil.getPath() + ".html";
		htmlUtil.setPath(path);
		File file = new File(path);
		if (file.exists()) {
			FileUtils.checkFile(htmlUtil);
		} else {
			FileUtils.writeHTML(story, path);
		}
	}

}
