package com.proda.main;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.proda.controller.MainController;
import com.proda.serializing.Saves;

public class App {

	public static String path = System.getProperty("user.home") + "/books";

	public static Saves saves = Saves.getSAVES();;

	public static void main(String[] args) {

		// MainController.getFromSamLib("http://samlib.ru/p/postulans/uingukage25.shtml");
		File[] file = new File[6];
		file[0] = new File("E://1//nick.txt");
		file[1] = new File("E://1//nick.html");
		file[2] = new File("E://1//manor.txt");
		file[3] = new File("E://1//manor.html");
		file[4] = new File("E://1//fic.txt");
		file[5] = new File("E://1//fic.html");

		for (File f : file) {
			if (f.exists())
				f.delete();
		}
		try {
			InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
			  for (InetAddress address : addresses) {
			        if (address.isReachable(10000)){
			        	MainController.getText("http://samlib.ru/p/pupkin_wasja_ibragimowich/niktxt.shtml", "E://1//nick.txt");
						MainController.getText("http://samlib.ru/u/ushakow_wladimir_sergeewich/mano-ratha_1.shtml", "E://1//manor.txt");
						MainController.getText("https://www.fictionpress.com/s/2961893/50/Mother-of-Learning", "E://1//fic.txt");
			        }
			        else {
			        	System.out.println("Internet connection fail!");
			        }
			  }
			
		} catch (IOException e) {
			System.out.println("Internet connection fail!");
		}

	}

}
