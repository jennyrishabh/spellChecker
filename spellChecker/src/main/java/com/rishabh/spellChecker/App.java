package com.rishabh.spellChecker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.apache.lucene.search.spell.NGramDistance;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.search.spell.StringDistance;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/*

org.apache.lucene.search.spell	->  Suggest alternate spellings for words.

https://www.javacodegeeks.com/2010/05/did-you-mean-feature-lucene-spell.html

*/
public class App 
{
	final static String __DIRNAME ;
	final static String __COLLECTIONFILE;
			
	static {
		// initialization part is done here before the further depth of the project ...
		__DIRNAME = appConfig.getDirname();
		__COLLECTIONFILE = appConfig.getCollectionfile();
		System.out.println(appConfig.newString());
	}
	
    public static void main( String[] args ) throws IOException
    {
    	
    		 final int suggestionsNumber = 25;
    		
	    	 Scanner sc = new Scanner(System.in);
	    	 SpellChecker spellChecker = null ;
	    	 File dir = new File(__DIRNAME);
	    	 try {
	         Directory directory = FSDirectory.open(dir);
	         
	         spellChecker = new SpellChecker(directory);
	         
	         
	         
	         //spellChecker.setStringDistance(new JaroWinklerDistance());
	         spellChecker.setStringDistance(new NGramDistance(1));
	         spellChecker.setAccuracy(0);
	         
	        
	         spellChecker.indexDictionary(  new PlainTextDictionary(new File(__COLLECTIONFILE)));
	         
	         System.out.println("enter your word");
	        // String wordForSuggestions = "hollo";
	         String wordForSuggestions = sc.nextLine();
	
	         String[] suggestions = spellChecker.suggestSimilar(wordForSuggestions, suggestionsNumber);
	         System.out.println("-- - - -- -- - -- -- --");
	         if (suggestions!=null && suggestions.length>0) {
	             for (String word : suggestions) {
	                 System.out.println("You mean -> " + word);
	             }
	         }
	         else {
	             System.out.println("Sry -> No suggestions found : "+wordForSuggestions);
	         }
    	}
    	catch(Exception e)  {
    		System.out.println("Exception handled !! "+e);
    	}
    	finally {
    		sc.close();
    		spellChecker.close();
    		System.out.println("\nEnd  ... ");
    		System.exit(0);
    	}
	    	
	    
	    //	 System.out.println("newtest".compareTo("test"));
	    	 
    	
    }
}





/*  
 
 ORIGINAL CODE  :  



package com.rishabh.spellChecker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class App 
{
	final static String __DIRNAME;
	final static String __COLLECTIONFILE;
			
	static {
		__DIRNAME = "/Users/jerry/Documents/CSE/datata/Spring_projects/spellChecker/src/main/java/com/rishabh/spellChecker";
		__COLLECTIONFILE = "/Users/jerry/Documents/CSE/datata/Spring_projects/spellChecker/src/main/java/com/rishabh/spellChecker/correctWords.txt";
	}
	
    public static void main( String[] args ) throws IOException
    {
    		 final int suggestionsNumber = 50;
    		
	    	 Scanner sc = new Scanner(System.in);
	    	 SpellChecker spellChecker = null ;
	    	 File dir = new File(__DIRNAME);
	    	 try {
	         Directory directory = FSDirectory.open(dir);
	         spellChecker = new SpellChecker(directory);
	         spellChecker.indexDictionary(  new PlainTextDictionary(new File(__COLLECTIONFILE)));
	         
	         System.out.println("enter your word");
	         String wordForSuggestions = sc.nextLine();
	         String[] suggestions = spellChecker.
	             suggestSimilar(wordForSuggestions, suggestionsNumber);
	         if (suggestions!=null && suggestions.length>0) {
	             for (String word : suggestions) {
	                 System.out.println("You mean -> " + word);
	             }
	         }
	         else {
	             System.out.println("Sry -> No suggestions found : "+wordForSuggestions);
	         }
    	}
    	catch(Exception e)  {
    		System.out.println("Exception handled !! ");
    	}
    }
}

*/
 