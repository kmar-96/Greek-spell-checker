package spellcheck;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class CheckWordTest {

  @Test
  public void test() {

    GreekOutput.setCodepage("UTF-8");
    Dictionary d = new Dictionary("GreekDictionaryFinal.txt");
    d.putDictionaryToList();
    HashSet<String> dictionary = d.returnDictionaryList();

    LinkedList<String> testList = new LinkedList<String>();
    testList.add("καλημέερα");
    testList.add("σπίτι");

    CheckWord cw = new CheckWord(dictionary, testList);
    LinkedList<String> output = cw.printNotExistedWords();
    String expected = "καλημέερα";
    assertEquals(expected, output.get(0));

  }
}