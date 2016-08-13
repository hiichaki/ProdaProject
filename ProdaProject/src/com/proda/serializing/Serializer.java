package com.proda.serializing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serializer {

	public static byte[] getBytesFromFile(String path) throws IOException {
		Path filePath = Paths.get(path);
		byte[] data = Files.readAllBytes(filePath);
		return data;

	}

	public static void setBytesIntoFile(byte[] byteArray, String path) throws IOException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
			fos.write(byteArray);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); ObjectInput in = new ObjectInputStream(bis)) {
			return in.readObject();
		}
	}

	public static byte[] convertToBytes(Object object) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
			out.writeObject(object);
			return bos.toByteArray();
		}
	}

	public static void clearFile(String path) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(path));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		writer.print("");
		writer.close();
	}

}
