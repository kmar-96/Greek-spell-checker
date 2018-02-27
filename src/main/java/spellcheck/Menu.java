package spellcheck;

/**
 * This class is used to display Menus to the user
 * and get his choices.
 * @author Vasiliki Bili, Konstantinos Marinakos
 */
public class Menu {

  /**
   * This is the default constructor
   * has no variables to initialise
   */
  public Menu() {

  }

  /**
   * This menu asks the user whether to input text
   * from keyboard or a text file.
   * @exception Exception if the user does not give a valid option
   * @return the user's text
   */
  public String getMenu1() {

    String choice = "";

    while (true) {

      try {

        GreekOutput.printLine("=== ΔΙΟΡΘΩΤΗΣ ΕΛΛΗΝΙΚΟΥ ΚΕΙΜΕΝΟΥ ===");
        GreekOutput.printLine("Για να εισάγετε κείμενο:");
        GreekOutput.printLine("-από πληκτρολόγιο πατήστε '1'");
        GreekOutput.printLine("-από κάποιο αρχείο πατήστε '2'");
        choice = GreekInput.readLine();

        if (! (choice.equals("1") || choice.equals("2"))) {
          throw new Exception();
        }

        break;

      } catch (Exception ex) {
        GreekOutput.printLine("Δεν εισάγατε έγκυρη επιλογή. Ξαναπροσπαθήστε.");
        GreekOutput.printLine("");
      }
    }

    if (choice.equals("1")) {
      return getInputFromKeyboard();
    } else {
      return getInputFromFile();
    }
  }

  /**
   * This reads input from keyboard.
   * @return the input given
   */
  private String getInputFromKeyboard() {

    GreekOutput.printLine("Πληκτρολογήστε το κείμενό σας: ");
    GreekOutput.printLine("");
    String userText = GreekInput.readLine();
    return userText;
  }

  /**
   * This reads input from a file.
   * @return the input given
   */
  private String getInputFromFile() {

    String userText = "";

    while (true) {

      GreekOutput.printLine("Εισάγετε το path του αρχείου: ");
      String path = GreekInput.readLine();
      GreekFile gf = new GreekFile(path);
      userText = gf.readGreekFile();
      if (! userText.equals("-1")) {
        break;
      }
    }
    return userText;
  }

  /**
   * This menu asks the user whether he wants to see
   * suggestions for misspelled words.
   * @return his choice
   */
  public String getMenu2() {

    GreekOutput.printLine("");
    GreekOutput.printLine("-Αν θέλετε να σας γίνουν προτάσεις πατήστε '1'");
    GreekOutput.printLine("-Αν δεν θέλετε να σας γίνουν προτάσεις πατήστε οτιδήποτε άλλο:");
    String choice = GreekInput.readLine();
    return choice;

  }

  /**
   * This signals the end of the program.
   */
  public void getMenu3() {

    GreekOutput.printLine("");
    GreekOutput.printLine("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας.");
    GreekOutput.printLine("Ομάδα υλοποίησης: Javatoi " + "\u00a9");

  }
}