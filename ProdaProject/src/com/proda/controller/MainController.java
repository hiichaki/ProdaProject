package com.proda.controller;

import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;
import com.proda.utils.ParseUtils;

public class MainController {


//	public static void getFromFictionPress(int fromChapter, int... toChapter) {
//		if (toChapter.length != 0) {
//			for (int i = fromChapter; i < toChapter[0]; ++i) {
//				finded = getStoryByURL("https://www.fictionpress.com/s/2961893/" + i + "/Mother-of-Learning");
//			}
//		} else {
//			finded = getStoryByURL("https://www.fictionpress.com/s/2961893/" + fromChapter + "/Mother-of-Learning");
//		}
//	}

	public static void getFromSamLib(String url) {
		String story = HTMLUtils.getHTMLStorySamLib(url);
		story = ParseUtils.parseToText(story);
		if (story != null) {
			FileUtils.writeHTML(story, "E://1//samLib.txt");
		} else {
			System.out.println("epic fail");
		}
	}

//	private static boolean getStoryByURL(String url) {
//
//		String story = null;
//
//		if (url.contains("samlib.ru")) {
//			story = HTMLUtils.getHTMLStorySamLib(url);
//		} else if (url.contains("fictionpress.com")) {
//			story = HTMLUtils.getHTMLStoryFictionPress(url);
//		}
//		if (story == null) {
//			System.out.println("failed to find template on: " + url);
//		} else {
//			FileUtils.writeHTML(story, "E://1//1.html");
//		}
//
//		return story != null;
//	}

	public static void getText(String url, String path, int... chapterFromTo) {
		String story = HTMLUtils.getHTMLStorySamLib(url);
		
		if (story == null) {
			System.out.println("failed to find template on: " + url);
			return;
		} else {
			
			FileUtils.writeHTML(story, path);
			FileUtils.writeText(story, path);
		}
		
	}

}














