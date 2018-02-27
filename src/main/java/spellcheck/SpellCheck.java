package spellcheck;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * This class represents a spell-checker.
 * @author Dimitra Koitsanou, Konstantinos Marinakos
 */
public class SpellCheck {

  /**
  * This uses various classes to build a spell checking program.
  * @param args code page to be used
  * @exception ArrayIndexOutOfBoundsException if no code page given ends the program
  */
  public static void main(String[] args) {

    String codepage = "";
    try {
      codepage = args[0];
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("No codepage given. Ending program...");
      System.exit(1);
    }

    GreekOutput.setCodepage(codepage);
    GreekInput.setCodepage(codepage);
    final String DICTIONARY_FILE = "GreekDictionaryFinal.txt";
    Dictionary d = new Dictionary(DICTIONARY_FILE);
    d.putDictionaryToList();
    HashSet<String> dictionary = d.returnDictionaryList();
    Menu menu = new Menu();
    String userText = menu.getMenu1();

    if (userText == null || userText.isEmpty()) {

      GreekOutput.printLine("Δεν δώσατε καθόλου κείμενο.");

    } else {

      SplitWords sw = new SplitWords(userText);
      LinkedList<String> splittedWords = sw.getSplittedWordsList();
      CheckWord cw = new CheckWord(dictionary, splittedWords);
      LinkedList<String> NonExistingWords = cw.printNotExistedWords();
    
      if (! NonExistingWords.isEmpty()) {

        String choice = menu.getMenu2();

        if (choice.equals("1")) {

          Suggestion s = new Suggestion(dictionary);

          for (String temp : NonExistingWords) {
            LinkedList<String> suggestions = s.suggest(temp);
            GreekOutput.printLine("Προτάσεις για '" + temp + "': ");
            for (String temp2 : suggestions) {
              GreekOutput.printLine(temp2);
            }
          }
        }
      } else {
        GreekOutput.printLine("Ο διορθωτής δεν εντόπισε ορθογραφικά λάθη.");
      }
    }
    menu.getMenu3();
  }
}