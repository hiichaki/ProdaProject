package com.proda.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.proda.main.App;
import com.proda.model.Book;

public class FileUtils {

	public static void writeHTML(String story, String path) {
		try {
			path = path.replace(".txt", ".html");
			story = ParseUtils.deleteFail(story);
			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				// begin of the file
				bw.write(
						"<html><head><title></title><meta charset=\"utf-8\"></head><body style = \'background-color:#0B162C; font-family: cursive;  font-size:35; color:#C5FFBB;\'><div align=justify style=\'padding:0 320;  \'>");
				bw.close();
			} else {
				deleteLastLine(path);
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			out.println(story);
			out.println("</div></body></html>");

			bw.close();
			System.out.println("Writing html done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeText(String story, String path) {

		File file = new File(path);

		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			out.println(new String(story.getBytes(), "UTF-8"));

			bw.close();
			System.out.println("Writing text done!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void deleteLastLine(String path) {
		RandomAccessFile f;
		try {
			f = new RandomAccessFile(path, "rw");
			f.setLength(f.length() - 21);
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void checkDirectory(String path) {
		File file = new File(path);

		if (!file.exists()) {
			file.mkdir();
			System.out.println("Created: " + file.getPath());
		}
	}

//	TODO: redo
	public static void checkFile(Book book, String extension) {
		String story = book.getTextStory();
		File file = new File(book.getPath() + extension);
		String title = book.getTitle();
		try {
			String fileStory = readFile(file.getPath());
			if (story.length() > fileStory.length()) {
				String proda = story.substring(fileStory.length() - 1);

				writeText(proda, file.getPath());
				writeText(proda, App.pathProda + "//" + title + extension);
				App.updated.add(title + " | " + book.getAuthor() + " | " + proda.length() + " symbols");
				System.out.println("Updated: " + file.getPath() );
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
	}

	public static ArrayList<String> getURLs() {
		// ArrayList<String> lines = Files.readAllLines(Paths.get(path),
		// StandardCharsets.UTF_8);
		try {
			Scanner s = new Scanner(new File(System.getProperty("user.home") + "//urls.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()) {
				list.add(s.next());
			}
			s.close();
			return list;
		} catch (FileNotFoundException e) {
			System.out.println("fail to read URLs from file");
			return null;
		}

	}

}
