package com.proda.controller;

import java.io.File;

import com.proda.main.App;

public class Special {

	public static void getSpecials() {
		nobody103(5);
//		dworzova(42);
	}

	private static void dworzova(int n) {
		File file = new File(App.path + "/Дворцова/Записки целителя Максимилиана Харта.txt");

		for (int i = 1; i < n; ++i) {
			if (i < 11) {
				if (i == 2) {
					App.getThatShit("http://samlib.ru/d/dworcowa_i/a0" + i + "-1.shtml", file);
				} else {
					App.getThatShit("http://samlib.ru/d/dworcowa_i/a0" + i + ".shtml", file);
				}

			} else {
				App.getThatShit("http://samlib.ru/d/dworcowa_i/a" + i + ".shtml", file);
			}
			show(file.getParentFile().getName(),i,n);
		}
	}

	private static void nobody103(int n) {
		File file = new File(App.path + "/nobody103/Mother of Learning.txt");
		for (int i = 1; i < n; ++i) {
			App.getThatHTMLShit("https://www.fictionpress.com/s/2961893/" + i + "/Mother-of-Learning", file);
			App.getThatShit("https://www.fictionpress.com/s/2961893/" + i + "/Mother-of-Learning", file);
			show(file.getParentFile().getName(),i,n);
		}

	}

	private static void show(String name, int i, int n) {
		System.out.println(name + ": " + i + "/" + (n-1));
	}

}
