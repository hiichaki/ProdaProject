package com.proda.controller;

import java.io.File;

import com.proda.main.App;

public class Special {
 
	public static void getSpecials() {
		try {
			nobody103(58);
			dworzova(42);
		} catch (NullPointerException ex) {
			System.out.println("wrong url. failed!");
		}
	}

	private static void dworzova(int n) throws NullPointerException {
		File file = new File(App.path + "/Дворцова/Записки целителя Максимилиана Харта.txt");

		for (int i = 1; i < n; ++i) {
			if (i < 11) {
				if (i == 2) {
					Controller.getThatShit("http://samlib.ru/d/dworcowa_i/a0" + i + "-1.shtml", file);
				} else {
					Controller.getThatShit("http://samlib.ru/d/dworcowa_i/a0" + i + ".shtml", file);
				}

			} else {
				Controller.getThatShit("http://samlib.ru/d/dworcowa_i/a" + i + ".shtml", file);
			}
			show(file.getParentFile().getName(), i, n);
		}
	}

	private static void nobody103(int n) throws NullPointerException {
		File file = new File(App.path + "/nobody103/Mother of Learning.txt");
		for (int i = 1; i < n; ++i) {
			Controller.getThatHTMLShit("https://www.fictionpress.com/s/2961893/" + i + "/Mother-of-Learning", file);
			show(file.getParentFile().getName(), i, n);
		}

	}

	private static void show(String name, int i, int n) {
		System.out.println(name + ": " + i + "/" + (n - 1));
	}

}
