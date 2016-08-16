package com.proda.main;

import java.util.ArrayList;

import com.proda.controller.MainController;
import com.proda.serializing.Saves;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

public class App {

	public static String path = System.getProperty("user.home") + "/books";

	public static Saves saves = Saves.getSAVES();;

	public static void main(String[] args) {

		FileUtils.checkDirectory(App.path);
		System.out.println("\n");

		if (HTMLUtils.hasInternetConnection()) {
			download();
		}

	}

	private static void download() {
		ArrayList<String> urls = FileUtils.getURLs();
		int total = urls.size();
		int i = 0;
		for (String url : urls) {
			MainController.getText(url);
			++i;
			System.out.println("Downloaded: " + i + "/" + total + "\n");
		}
	}

}
