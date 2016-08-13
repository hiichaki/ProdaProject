package com.proda.controller;

import com.proda.utils.FileUtil;
import com.proda.utils.HTMLUtil;

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
			FileUtil.endHTMLFile("E://1//1.html");
		}
	}

	private static boolean getStoryByURL(String url) {

		String content = HTMLUtil.getContent(url);
		int beginIndex = content.indexOf("<div class='storytext");
		int endIndex = content.indexOf("</div><div style='height:5px'></div><");
		if (beginIndex == endIndex) {
			System.out.println("failed to find template: " + url);
			return false;
		} else {
			System.out.println(beginIndex + " " + endIndex);
			String story = content.substring(beginIndex, endIndex);
			FileUtil.bufferWriter(story, "E://1//1.html");
			return true;
		}

	}

}
