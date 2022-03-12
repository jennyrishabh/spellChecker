package com.rishabh.spellChecker;

public class appConfig {
	
	private final static  String __DIRNAME = "/Users/jerry/Documents/CSE/datata/Spring_projects/spellChecker/src/main/java/com/rishabh/spellChecker";
	private final static String __COLLECTIONFILE = "/Users/jerry/Documents/CSE/datata/Spring_projects/spellChecker/src/main/java/com/rishabh/spellChecker/correctWords.txt";
	
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
