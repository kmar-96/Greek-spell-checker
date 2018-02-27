package spellcheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * Represents a file containing some Greek text.
 * @author Konstantinos Marinakos
 */
public class GreekFile {

  public final String utf8bom = "\uFEFF";
  private String path;

  /**
   * This constructs a GreekFile containing some text.
   * @param path contains the path of the file to be read
   */
  public GreekFile(String path) {
    this.path = path;
  }

  /**
   * This sets the path of the file to be read.
   * @param path contains the path where the file is located
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * This returns the path of the file to be read.
   * @return the path of the file to be read
   */
  public String getPath() {
    return path;
  }

  /**
   * This creates a string containing all the text located in the file.
   * @exception IOException if the file cannot be read
   * @exception InvalidPathException if the string cannot be converted to a Path
   * @return the content of the file as a string
   */
  public String readGreekFile() {

    try {

      String text;
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      text = new String(encoded,"UTF-8");
      text = removeUtf8Bom(text);
      return text;

    } catch (IOException e) {
      GreekOutput.printLine("Πρόβλημα εισόδου/εξόδου.");
      return "-1";
    } catch (InvalidPathException ex) {
      System.out.println(ex.toString());
      GreekOutput.printLine("Μη έγκυρος χαρακτήρας.");
      return "-1";
    }
  }

  /**
   * This removes UTF-8 BOM characters located at the beginning of a string.
   * @param s string from which to remove the characters
   * @return the string after unwanted characters have been removed
   */
  public String removeUtf8Bom(String s) {

    if (s.startsWith(utf8bom)) {
      s = s.substring(1);
    }
    return s;
  }
}