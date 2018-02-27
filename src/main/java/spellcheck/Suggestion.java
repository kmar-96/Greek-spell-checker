package spellcheck;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * This class is used to make suggestions for
 * incorrectly spelt words using a given dictionary
 * as reference. Suggestions are made based
 * on the levenshtein distance algorithm.
 * @author Maria Slamari
 */
public class Suggestion {

  private HashSet<String> dictionary;

  /**
   * This constructs a Suggestion using a specified
   * dictionary for reference.
   * @param dictionary to be used as reference
   */
  public Suggestion(HashSet<String> dictionary) {
    this.dictionary = dictionary;
  }

  /**
   * This sets the dictionary to be used as reference.
   * @param dictionary to be used as reference
   */
  public void setDictionary(HashSet<String> dictionary) {
    this.dictionary = dictionary;
  }

  /**
   * This returns the dictionary used as reference.
   * @return the dictionary used as reference
   */
  public HashSet<String> getDictionary() {
    return dictionary;
  }

  /**
   * This uses the levenshtein distance between
   * a wrong word and dictionary words to make
   * spelling suggestions.
   * @param wrongWord an incorrectly spelt word
   * @return a list of words having the least levenshtein distance
   */
  public LinkedList<String> suggest(String wrongWord) {

    LinkedList<String> suggestions = new LinkedList<String>();
    
    if (wrongWord.length() <= 2) {
      suggestions.add("Η λέξη είναι πολύ μικρή για να γίνουν προτάσεις");
      return suggestions;
    }

    int counter = 0;
    String suggestion = "";

    int minDistance = Integer.MAX_VALUE;

    for (String dictionaryWord : dictionary) {

      int distance = 0;

      if (Math.abs(wrongWord.length() - dictionaryWord.length()) <= 2) {

        distance = minimumEditDistance(dictionaryWord,wrongWord);

        if (distance == 1 && counter <= 4 && dictionaryWord.length() >= 3) {
          suggestions.add(dictionaryWord);
          counter++;
          if (counter == 4) {
            break;
          }
        }

        if (distance < minDistance) {

          minDistance = distance;
          suggestion = dictionaryWord;
        }
      }
    }
    
    if (! suggestions.contains(suggestion)) {
      suggestions.add(suggestion);
    }
    return suggestions;
  }

  /**
   * Levenshtein Distance algorithm.
   * @param firstWord first word
   * @param secondWord second word
   * @return the levenshtein distance between the two words
   */
  public int minimumEditDistance(String firstWord, String secondWord) {

    int i = 0;
    int j = 0;
    int a = firstWord.length();
    int b = secondWord.length();

    int [][] array = new int[a + 1][b + 1];

    for (i = 0 ; i <= a ; i++) {

      for (j = 0 ; j <= b ; j++) {

        if (i == 0) {
          array[i][j] = j;
        } else if (j == 0) {
          array[i][j] = i;
        } else if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1)) {
          array[i][j] = array[i - 1][j - 1];
        } else {
          array[i][j] = 1 + minimum(array[i][j - 1], array[i - 1][j - 1], array[i - 1][j]);
        }
      }
    }
    return array[a][b];
  }

  /**
   * This returns the smallest number
   * between three numbers.
   * @param num1 number one
   * @param num2 number two
   * @param num3 three
   * @return the smallest of the three
   */
  public int minimum(int num1, int num2, int num3) {

    int min1 = (num1 <= num2) ? num1 : num2 ;

    return ((min1 <= num3) ? min1 : num3);
  }
}