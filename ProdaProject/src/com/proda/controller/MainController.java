package com.proda.controller;

import java.io.File;

import com.proda.main.App;
import com.proda.model.Book;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;
import com.proda.utils.ParseUtils;
import com.proda.utils.StaticVars;

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

	public static void write(Book book) {
		String extension = StaticVars.getExtensions()[0];
		File file = new File(book.getPath() + extension);
		if (file.exists()) {
			FileUtils.checkFile(book, extension);
		} else {
			FileUtils.checkDirectory(App.path +"//" +book.getAuthor());
			FileUtils.writeText(book.getTextStory(), file.getPath());
		}
	}

}
