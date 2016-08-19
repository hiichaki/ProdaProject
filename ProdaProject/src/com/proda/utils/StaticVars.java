package com.proda.utils;

import java.util.HashMap;
import java.util.Map;

public class StaticVars {
	
	private static Map<Site,String[]> map = new HashMap<Site,String[]>();
	
	/*
	 * beginIndex text
	 * endIndex text
	 * beginIndex author
	 * endIndex author
	 * beginIndex title
	 * endIndex title
	 */
	static {
		map.put(Site.samLib, new String[]{"<!----------- Собственно произведение --------------->","<!--------------------------------------------------->","<div align=right><h3>",": <small><a href=/","<center><h2>","</h2>"});
		map.put(Site.fictionpress, new String[]{"<div class='storytext","</div><div style='height:5px'></div><","</span> <a class=\'xcontrast_txt\' href=\'","</a> <span class='icon-mail-1","</button><b class=\'xcontrast_txt\'>","</b>"});
		map.put(Site.ficbook, new String[]{"<body>","Не забудьте оставить свой отзыв: <b>https://ficbook.","<b>Автор:</b>","(https://ficbook.net/","<h1 style=\"margin-bottom: 0px;\">","</h1>"});
	}
	
	public static String[] getValues(Site site) {
		return map.get(site);
	}
	
	public static String[] getExtensions() {
		return new String[]{".txt",".html"};
	}
	
}
