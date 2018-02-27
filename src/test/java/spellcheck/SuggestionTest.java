package spellcheck;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import org.junit.Test;

public class SuggestionTest {

  @Test
  public void test() {

    Dictionary d = new Dictionary("GreekDictionaryFinal.txt");
    d.putDictionaryToList();
    HashSet<String> dictionary = d.returnDictionaryList();
    Suggestion test = new Suggestion(dictionary) ;
    LinkedList<String> suggestions = test.suggest("σπίιτι") ;
    String output = suggestions.get(0);
    assertEquals("σπίτι",output);

    int med = test.minimumEditDistance("ελλαδα", "Ελλάδα");
    assertEquals(med,2);

  }
}