package com.proda.controller;

import org.jsoup.Jsoup;

import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

public class MainController {

	public static void getFromFictionPress(int fromChapter, int... toChapter) {
		boolean finded = false;
		if (toChapter.length != 0) {
			for (int i = fromChapter; i < toChapter[0]; ++i) {
				finded = getStoryByURL("https://www.fictionpress.com/s/2961893/" + i + "/Mother-of-Learning");
			}
		} else {
			finded = getStoryByURL("https://www.fictionpress.com/s/2961893/" + fromChapter + "/Mother-of-Learning");
		}
		if (finded) {
			FileUtils.endHTMLFile("E://1//1.html");
		}
	}

	private static boolean getStoryByURL(String url) {

		String story = null;

		if (url.contains("samlib.ru")) {
			story = HTMLUtils.getHTMLStorySamLib(url);
		} else if (url.contains("fictionpress.com")) {
			story = HTMLUtils.getHTMLStoryFictionPress(url);
		}
		if (story == null) {
			System.out.println("failed to find template on: " + url);
		} else {
			FileUtils.bufferWriter(story, "E://1//1.html");
		}

		return story != null;
	}

	public static void get(String url) {

	}

	public static void getFromSamLib(String url) {
		String story = HTMLUtils.getHTMLStorySamLib(url);
		story = Jsoup.parse(story).text();
		if (story != null) {
			FileUtils.bufferWriter(story, "E://1//samLib.txt");
		} else {
			System.out.println("epic fail");
		}
	}

}
