package com.proda.main;

import com.proda.controller.Controller;
import com.proda.controller.Special;
import com.proda.serializing.Saves;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

public class App {

	public static String path = System.getProperty("user.home") + "/books";

	public static String pathProda = System.getProperty("user.home") + "/books/proda";

	public static Saves saves = Saves.getSAVES();;

	public static void main(String[] args) {

		FileUtils.checkDirectory(App.path);
		FileUtils.checkDirectory(App.pathProda);
		System.out.println("\n");

		System.out.print("Connection to Internet: ");

		if (HTMLUtils.hasInternetConnection()) {

			System.out.println("OK");

			Controller.download();
			Special.getSpecials();

			System.out.println("\n");

			Controller.showUpdated();

		}

	}

}
