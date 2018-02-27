package spellcheck;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * This class is used to check whether certain words
 * exist in a specified dictionary, which is used as 
 * a reference for correct spelling.
 * @author Kallia Mandeleni
 */
public class CheckWord {

  private HashSet<String> dictionary;
  private LinkedList<String> wordsToCheck;

  /**
   * This constructs a CheckWord to check spelling of some words.
   * @param dictionary is the dictionary to be used as reference
   * @param wordsToCheck the words to be spell-checked
   */
  public CheckWord(HashSet<String> dictionary, LinkedList<String> wordsToCheck) {

    this.dictionary = dictionary;
    this.wordsToCheck = wordsToCheck;

  }

  /**
   * This sets the dictionary to be used as references.
   * @param dictionary the dictionary to be used as reference
   */
  public void setDictionary(HashSet<String> dictionary) {
    this.dictionary = dictionary;
  }

  /**
   * This sets the words to be spell-checked.
   * @param wordsToCheck the words to be spell-checked
   */
  public void setWordsToCheck(LinkedList<String> wordsToCheck) {
    this.wordsToCheck = wordsToCheck;
  }

  /**
   * Displays on the screen misspelled words.
   * @return a list of the misspelled words
   */
  public LinkedList<String> printNotExistedWords() {

    LinkedList<String> nonExistingWords = new LinkedList<String>();

    for (String temp: wordsToCheck) {
      if (! dictionary.contains(temp)) {
        GreekOutput.printLine("Η λέξη '" + temp + "' δεν υπάρχει στο λεξικό μου.");
        nonExistingWords.add(temp);
      }
    }
    return nonExistingWords;
  }
}