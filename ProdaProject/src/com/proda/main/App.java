package com.proda.main;

import com.proda.controller.MainController;
import com.proda.serializing.Saves;

public class App {

	public static String path = System.getProperty("user.home")+"/books";
	
	public static Saves saves = Saves.getSAVES();;
	
	public static void main(String[] args) {
		
		MainController.getFromFictionPress(59);
		
		
	}

}
