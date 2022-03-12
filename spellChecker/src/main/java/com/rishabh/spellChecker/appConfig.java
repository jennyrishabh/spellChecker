package com.rishabh.spellChecker;

public class appConfig {
	
	private final static  String __DIRNAME = "${PATH}";
	private final static String __COLLECTIONFILE = "${PATH}";
	
	public static String getDirname() {
		return __DIRNAME;
	}
	public static String getCollectionfile() {
		return __COLLECTIONFILE;
	}
	
	public static String newString() {
		return "values fetched -> "+getDirname()+" : "+getCollectionfile();
	}
	
}
