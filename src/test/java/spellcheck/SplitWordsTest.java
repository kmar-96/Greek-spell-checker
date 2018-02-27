package spellcheck;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SplitWordsTest {

  @Test
  public void test() {

    SplitWords sw = new SplitWords(" γεια  σου . Τι κάνεις; ; ;");
    LinkedList<String> result = sw.getSplittedWordsList();

    assertEquals("γεια",result.get(0));
    assertEquals("σου",result.get(1));
    assertEquals("τι",result.get(2));
    assertEquals("κάνεις",result.get(3));

  }
}