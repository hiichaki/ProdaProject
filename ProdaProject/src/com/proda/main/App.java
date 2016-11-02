package com.proda.main;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.proda.controller.Controller;
import com.proda.serializing.Saves;
import com.proda.utils.FileUtils;
import com.proda.utils.HTMLUtils;

public class App {

	public static String path = System.getProperty("user.home") + "/books";

	public static String pathProda = path+ "/proda";

	public static Saves saves = Saves.getSAVES();
	
	private static void removeWarnings() {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
	}
	

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		removeWarnings();

		FileUtils.checkDirectory(App.path);
		FileUtils.checkDirectory(App.pathProda);
		
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
	    webClient.getOptions().setUseInsecureSSL(true); //ignore ssl certificate
	    webClient.getOptions().setThrowExceptionOnScriptError(false);
	    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	    String url = "https://ficbook.net/readfic/4446840";
	    HtmlPage myPage = webClient.getPage(url);
	    webClient.waitForBackgroundJavaScriptStartingBefore(200);
//	    webClient.waitForBackgroundJavaScript(20000);
	    //do stuff on page ex: myPage.getElementById("main")
	    //myPage.asXml() <- tags and elements
	    System.out.println(myPage.asText());
		
//		System.out.println("\n");
//
//		System.out.print("Connection to Internet: ");
//
//		if (HTMLUtils.hasInternetConnection()) {
//
//			System.out.println("OK");
//
//			Controller.download();
//
//			System.out.println("\n");
//
//			Controller.showUpdated();
//
//		}
//		Book book = new Book("http://samlib.ru/p/postulans/uingukage01.shtml");
//		Controller.write(book);
//		FileUtils.checkFile(book);

	}

}
