package spellcheck;

import java.util.LinkedList;

/**
 * This class is used to split text into individual words.
 * @author Vasiliki Bili, Konstantinos Marinakos
 *
 */
public class SplitWords {

  private String text;

  /**
   * This constructs a SplitWords that splits text into words.
   * @param text to be split
   */
  public SplitWords(String text) {
    this.text = text;
  }

  /**
   * This sets the text to be split.
   * @param text to be split
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * This returns the text to be split.
   * @return the text to be split
   */
  public String getText() {
    return text;
  }

  /**
   * This splits text into individual words having
   * removed all non-Greek characters and punctuation
   * except full stop.
   * @return individual words
   */
  public  LinkedList<String> getSplittedWordsList() {

    LinkedList<String> splittedWords = new LinkedList<String>();
    
    String [] splitted = text.trim().replaceAll("[^α-ωΑ-ΩςάέήίόύώΆΈΉΊΌΎΏϊΐϋΰΪΫ. ]","")
            .replaceAll("\\s{2,}", " ").split("\\s+");

    for (String temp : splitted) {
      splittedWords.add(temp);
    }
    
    if (splittedWords.isEmpty()) {
      return splittedWords;

    } else {

      return toLowerCaseAfterFullstop(splittedWords);
    }
  }

  /**
   * This removes full stops and converts
   * words' first letter to lowercase if they are 
   * preceded with a full stop.
   * @param list of words to be converted as stated above
   * @return converted list of words
   */
  public LinkedList<String> toLowerCaseAfterFullstop(LinkedList<String> list) {

    LinkedList<String> splittedWordsNoDots = new LinkedList<String>();

    boolean fullstop = true;

    for (String temp : list) {

      if (fullstop) {

        if (temp.length() > 0) {
          temp = Character.toLowerCase(temp.charAt(0)) + temp.substring(1);
        }
      }

      if (temp.contains(".")) {
        temp = temp.replace(".", "");
        fullstop = true;
      } else {
        fullstop = false;
      }

      if (! temp.equals("")) {
        splittedWordsNoDots.add(temp);
      }
    }
    return splittedWordsNoDots;
  }
}