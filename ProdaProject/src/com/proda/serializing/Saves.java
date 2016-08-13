package com.proda.serializing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.proda.main.App;
import com.proda.model.Book;

public class Saves {

	private Map<String, Book> map;
	
	private static Saves SAVES;
	
	private Saves() {
		map = new HashMap<String, Book>();
	}
	
	static {
		setSAVES(new Saves());
	}
	
	public static void setSAVES(Saves SAVES) {
		Saves.SAVES = SAVES;
	}
	
	public static Saves getSAVES() {
		return SAVES;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Book> getSaves() throws ClassNotFoundException, IOException {
		return  (HashMap<String, Book>) Serializer.convertFromBytes(Serializer.getBytesFromFile(App.path));
	}
	
	public void addSave(Book book, String key) throws IOException {
		map.put(key, book);
		Serializer.setBytesIntoFile(Serializer.convertToBytes(map), App.path + "/books.txt");
	}
	
	public void delSave(String key) throws IOException {
		map.remove(key);
		Serializer.setBytesIntoFile(Serializer.convertToBytes(map), App.path + "/books.txt");
	}
	
}
