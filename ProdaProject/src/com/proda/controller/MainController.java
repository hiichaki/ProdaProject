package com.proda.controller;

import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

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


	public static void getText(String url, String path, int... chapterFromTo) {
		HTMLUtils htmlUtils = new HTMLUtils(url);
		String story = htmlUtils.getHTMLStory();
		System.out.println("author:"+htmlUtils.getAuthor());
		if (story == null) {
			System.out.println("failed to find template on: " + url);
			return;
		} else {
			
			FileUtils.writeHTML(story, path);
			FileUtils.writeText(story, path);
		}
		
	}

}














