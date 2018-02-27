package spellcheck;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/**
 * Represents a Dictionary containing many words.
 * @author Aggeliki Kouroupaki
 */

public class Dictionary {

  private HashSet<String> dictionary  = new HashSet<String>();
  private String fileName;

  /**
   * This constructs a Dictionary with a specified file name.
   * @param fileName the name of the file that contains the dictionary
   */
  public Dictionary(String fileName) {
    this.fileName = fileName;
  }

  /**
   * This returns a HashSet containing the words of the dictionary.
   * @return the dictionary's words
   */
  public HashSet<String> returnDictionaryList() {
    return dictionary;
  }

  /**
   * This reads a file line by line and adds each line (word) to a HashSet.
   * @exception FileNotFoundException if fileName does not exist, ends the program
   * @exception IOException if fileName cannot be read, ends the program
   */
  public void putDictionaryToList() {

    BufferedReader br = null;

    try {

      FileInputStream fis = new FileInputStream(fileName);
      br = new  BufferedReader(new InputStreamReader(fis,"UTF-8"));
      String line = null;
      br.readLine();
      while ((line = br.readLine()) != null) {
        dictionary.add(line); 
      }

    } catch (FileNotFoundException ex) {
      System.out.println(ex.toString());
      GreekOutput.printLine("Δεν βρέθηκε το αρχείο που περιέχει το λεξικό.");
      GreekOutput.printLine("Τερματισμός Προγράμματος.");
      System.exit(0);
    } catch (IOException ex) {
      System.out.println(ex.toString());
      GreekOutput.printLine("Τερματισμός Προγράμματος.");
      System.exit(0);
    } finally {
      try {

        if (br != null) {
          br.close();
        }

      } catch (IOException ex) {
        System.out.println(ex.toString());
      }
    }
  }
}
