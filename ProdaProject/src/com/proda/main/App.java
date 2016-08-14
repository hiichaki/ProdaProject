package com.proda.main;

import com.proda.controller.MainController;
import com.proda.serializing.Saves;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

public class App {

	public static String path = System.getProperty("user.home")+"/books";
	
	public static Saves saves = Saves.getSAVES();;
	
	public static void main(String[] args) {
		
//		MainController.getFromFictionPress(59);
//		String samLib = HTMLUtils.getContent("http://samlib.ru/b/bubela_o_n/4-04.shtml");
//		
//		FileUtils.bufferWriter(samLib, "E://1//qwe.txt");
//		System.out.println(samLib);
		MainController.getFromSamLib("http://samlib.ru/p/postulans/uingukage24.shtml");
		
		
		
	}

}
