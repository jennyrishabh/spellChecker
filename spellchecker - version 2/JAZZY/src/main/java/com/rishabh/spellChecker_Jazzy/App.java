package com.rishabh.spellChecker_Jazzy;

// test case : cdonig -> coding 


import com.swabunga.spell.event.*;
import com.swabunga.spell.engine.*;
import java.io.*;
import java.util.*;

public class App implements SpellCheckListener{
	
	
  private final String DICTIONARY_FILE = "/Users/jerry/Documents/CSE/datata/Spring_projects/spellChecker-Jazzy/src/main/java/dictionary/my_dictionary.txt";
  private static String string;
  
  private SpellChecker spellChecker;
  private ArrayList listOfMisspelledWords;

  public App()
  {
    createDictionary();
    spellChecker.addSpellCheckListener(this);
    
    // run the test on string1
    StringWordTokenizer texTok = new StringWordTokenizer(string);
    populateListOfMisspelledWords(texTok);
    printWordsInMisspelledList();
  }

  private void createDictionary()
  {
    File dict = new File(DICTIONARY_FILE);
    try
    {
      spellChecker = new SpellChecker(new SpellDictionaryHashMap(dict));
    }
    catch (FileNotFoundException e)
    {
      System.err.println("Dictionary File '" + dict + "' not found! Quitting. " + e);
      System.exit(1);
    }
    catch (IOException ex)
    {
      System.err.println("IOException occurred while trying to read the dictionary file: " + ex);
      System.exit(2);
    }
  }

  private void populateListOfMisspelledWords(StringWordTokenizer texTok)
  {
    listOfMisspelledWords = new ArrayList();
    spellChecker.checkSpelling(texTok);
  }

  private void printWordsInMisspelledList()
  {
    Iterator it = listOfMisspelledWords.iterator();
    while (it.hasNext())
    {
      System.out.println("listOfMisspelledWords: " + it.next());
    }
  }
  
  @Override
  public void spellingError(SpellCheckEvent event)
  {
	System.out.println("which thread : "+Thread.currentThread().toString());
	List obj = event.getSuggestions();
	System.out.println("obj found is : "+obj);
    event.ignoreWord(true);
    listOfMisspelledWords.add(event.getInvalidWord());
  }

  public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	  System.out.println("search for your word...");
	  string = sc.nextLine();
	  new App();
	  sc.close();
  }
}