package com.proda.controller;

import com.proda.main.App;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

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

	public static void getText(String url, String path, int... chapterFromTo) {
		HTMLUtils htmlUtils = new HTMLUtils(url);
		String story = htmlUtils.getHTMLStory();
		String author = htmlUtils.getAuthor();
		String title = htmlUtils.getTitle();
		if (story == null) {
			System.out.println("failed to find template on: " + url);
			return;
		} else {
//TODO: create if !exist
			FileUtils.writeHTML(story, App.path + "//" + author + "//" + title + ".html");
			FileUtils.writeText(story, App.path + "//" + author + "//" + title + ".txt");
		}

	}

}
