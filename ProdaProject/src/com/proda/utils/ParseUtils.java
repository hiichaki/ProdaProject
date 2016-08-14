package com.proda.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ParseUtils {

	public static String parseToText(String html) {
		return html.replaceAll("\\<[^>]*>", "").replaceAll("&nbsp;", "");

	}

	public static void convert(String infile, String outfile, String from, String to)
			throws IOException, UnsupportedEncodingException {
		InputStream in;
		if (infile != null)
			in = new FileInputStream(infile);
		else
			in = System.in;
		OutputStream out;
		if (outfile != null)
			out = new FileOutputStream(outfile);
		else
			out = System.out;

		// Use default encoding if no encoding is specified.
		if (from == null)
			from = System.getProperty("file.encoding");
		if (to == null)
			to = System.getProperty("file.encoding");

		// Set up character stream
		Reader r = new BufferedReader(new InputStreamReader(in, from));
		Writer w = new BufferedWriter(new OutputStreamWriter(out, to));

		// Copy characters from input to output. The InputStreamReader
		// converts from the input encoding to Unicode,, and the
		// OutputStreamWriter
		// converts from Unicode to the output encoding. Characters that cannot
		// be
		// represented in the output encoding are output as '?'
		char[] buffer = new char[4096];
		int len;
		while ((len = r.read(buffer)) != -1) {
			w.write(buffer, 0, len);
			System.out.println(buffer);
		}
		r.close();
		w.flush();
		w.close();
	}
	
	public static String test(String text) {
		Charset cset = Charset.forName("UTF-8");
		ByteBuffer buf = cset.encode(text);
		byte[] b = buf.array();
		return new String(b);
	}

}
