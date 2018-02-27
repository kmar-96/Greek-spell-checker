package spellcheck;

import static org.junit.Assert.*;
import org.junit.Test;

public class GreekFileTest {

  @Test
  public void test() {

    GreekFile gf = new GreekFile("GreekFileJunitText.txt");
    String text = gf.readGreekFile();
    System.out.println(gf.readGreekFile());
    assertEquals(text,"Η Ευρωζώνη απολαμβάνει ευρεία οικονομική ανάκαμψη, "
        + "με όλες τις χώρες και όλους τους τομείς "
        + "να συνεισφέρουν στην ανάπτυξη και στη ζήτηση.");
  }
}