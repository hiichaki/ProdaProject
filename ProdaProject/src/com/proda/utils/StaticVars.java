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
	 */
	static {
		map.put(Site.samLib, new String[]{"<!----------- Собственно произведение --------------->","<!--------------------------------------------------->","<title>",".",".","</title>"});
		map.put(Site.fictionpress, new String[]{"<div class='storytext","</div><div style='height:5px'></div><","</span> <a class=\'xcontrast_txt\' href=\'","</a> <span class='icon-mail-1","</button><b class=\'xcontrast_txt\'>","</b>"});
	}
	
	public static String[] getValues(Site site) {
		return map.get(site);
	}
	
}
