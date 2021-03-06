/*
 * This file was automatically generated by EvoSuite
 */

package nu.staldal.xtree;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import nu.staldal.xtree.ProcessingInstruction;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProcessingInstructionEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 nu.staldal.xtree.ProcessingInstruction.toSAX(Lorg/xml/sax/ContentHandler;)V: root-Branch
   * 2 nu.staldal.xtree.ProcessingInstruction.<init>(Ljava/lang/String;Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      ProcessingInstruction processingInstruction0 = new ProcessingInstruction("0@-lmZ@H", "0@-lmZ@H");
      DefaultHandler defaultHandler0 = new DefaultHandler();
      processingInstruction0.toSAX((ContentHandler) defaultHandler0);
      assertEquals("0@-lmZ@H", processingInstruction0.getValue());
      assertEquals("0@-lmZ@H", processingInstruction0.getTarget());
  }

  //Test case number: 1
  /*
   * 1 covered goal:
   * 1 nu.staldal.xtree.ProcessingInstruction.getTarget()Ljava/lang/String;: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      ProcessingInstruction processingInstruction0 = new ProcessingInstruction("0@-lmZ@H", "0@-lmZ@H");
      String string0 = processingInstruction0.getTarget();
      assertEquals("0@-lmZ@H", processingInstruction0.getValue());
      assertEquals("0@-lmZ@H", string0);
      assertNotNull(string0);
  }

  //Test case number: 2
  /*
   * 2 covered goals:
   * 1 nu.staldal.xtree.ProcessingInstruction.getValue()Ljava/lang/String;: root-Branch
   * 2 nu.staldal.xtree.ProcessingInstruction.<init>(Ljava/lang/String;Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      ProcessingInstruction processingInstruction0 = new ProcessingInstruction("0@-lmZ@H", "0@-lmZ@H");
      String string0 = processingInstruction0.getValue();
      assertEquals("0@-lmZ@H", string0);
      assertNotNull(string0);
      assertEquals("0@-lmZ@H", processingInstruction0.getTarget());
  }
}
