package com.proda.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {
	
	public static void bufferWriter(String story, String path) {
		try {

			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
//				begin of the file
				bw.write(
						"<html><head><title></title></head><body style = \'background-color:#0B162C; font-family: cursive;  font-size:35; color:#C5FFBB;\'><div align=justify style=\'padding:0 320;  \'>");
				bw.close();
			} 

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			out.println(story);

			bw.close();
			System.out.println("Writing done!");
		} catch (IOException e) {
			
		}
	}
	
	public static void endHTMLFile(String path) {
		bufferWriter("</div></body></html>", path);
	}
	
}
