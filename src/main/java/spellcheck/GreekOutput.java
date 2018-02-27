package spellcheck;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * This class is used to display text on the screen according to a given code page.
 * @author Dimitra Koitsanou
 */
public class GreekOutput {

  private static String codepage;

  /**
   * This sets the code page to be used.
   * @param cdpage the code page to be used
   */
  public static void setCodepage(String cdpage) {
    codepage = cdpage;
  }

  /**
   * This displays text on the screen according to a specified code page. 
   * @param text is the text be printed on the screen
   * @exception UnsupportedEncodingException if the code page does not exist ends the program
   */
  public static void printLine(String text) {

    try {

      PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out,codepage),true);
      p.println(text);

    } catch (UnsupportedEncodingException e) {
      System.out.println(e.toString());
      System.out.println(codepage + " not supported.");
      System.out.println("Ending program...");
      System.exit(0);
    }
  }
}