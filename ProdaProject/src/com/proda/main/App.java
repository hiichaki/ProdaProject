package com.proda.main;

import java.util.ArrayList;

import com.proda.controller.MainController;
import com.proda.serializing.Saves;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

public class App {

	public static String path = System.getProperty("user.home") + "/books";
	public static String pathProda = System.getProperty("user.home") + "/books/proda";

	public static Saves saves = Saves.getSAVES();;

	public static ArrayList<String> updated = new ArrayList<String>();

	public static void main(String[] args) {

		FileUtils.checkDirectory(App.path);
		FileUtils.checkDirectory(App.pathProda);
		System.out.println("\n");

		System.out.print("Connection to Internet: ");
		if (HTMLUtils.hasInternetConnection()) {
			System.out.println("OK");
			download();
			showUpdated();
			// download();
		} else {
			System.out.println("fail");
		}

	}

	private static void showUpdated() {
		if (updated.isEmpty()) {
			System.out.println("----------nothing new T_T--------------");
		} else {
			System.out.println("New Updates:");
			for (String proda : updated) {
				System.out.println(proda);
			}
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
