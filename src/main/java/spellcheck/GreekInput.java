package spellcheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * This class is used to get input from keyboard according to a specified code page.
 * @author Marialena Toli
 */
public class GreekInput {

  private static String codepage;

  /**
   * This sets the code page to be used.
   * @param cdpage the code page to be used
   */
  public static void setCodepage(String cdpage) {
    codepage = cdpage;
  }

  /**
   * This returns the code page to be used.
   * @return the code page to be used
   */
  public static String getCodePage() {
    return codepage;
  }

  /**
   * This reads input from the keyboard using the given code page.
   * @exception UnsupportedEncodingException if given code page does not exist returns nothing
   * @exception IOException if given input cannot be read returns nothing
   * @return the input given from keyboard
   */
  public static String readLine() {

    try {

      Reader reader = new InputStreamReader(System.in, codepage);
      BufferedReader br = new BufferedReader(reader);
      return br.readLine();

    } catch (UnsupportedEncodingException e) {
      System.out.println(e.toString());
      return "";
    } catch (IOException e) {
      System.out.println(e.toString());
      return "";
    }
  }
}