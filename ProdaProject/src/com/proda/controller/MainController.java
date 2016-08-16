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

	public static void getText(String url) {
		HTMLUtils htmlUtils = new HTMLUtils(url);
		String story = htmlUtils.getHTMLStory();
		String author = htmlUtils.getAuthor();
		String title = htmlUtils.getTitle();
		
		if (story == null) {
			System.out.println("failed to find template on: " + url);
			return;
		} else {
			System.out.println("author:" +author);
			System.out.println("title:" +title);
			String path = App.path + "//" + author + "//" + title;
			
			FileUtils.checkDirectory(App.path + "//" + author );
//			FileUtils.writeHTML(story,  path + ".html");
			FileUtils.writeText(story, path + ".txt");
		}

	}

}
