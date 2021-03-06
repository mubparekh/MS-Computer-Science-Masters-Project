/*
 * This file was automatically generated by EvoSuite
 */

package nu.staldal.lagoon.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.io.IOException;
import nu.staldal.lagoon.producer.MyInputStream;

public class MyInputStreamEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 nu.staldal.lagoon.producer.MyInputStream.close()V: root-Branch
   * 2 nu.staldal.lagoon.producer.MyInputStream.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      MyInputStream myInputStream0 = new MyInputStream();
      myInputStream0.close();
  }

  //Test case number: 1
  /*
   * 3 covered goals:
   * 1 nu.staldal.lagoon.producer.MyInputStream.deliver(I)V: I4 Branch 7 IFEQ L241 - true
   * 2 nu.staldal.lagoon.producer.MyInputStream.deliver(I)V: I10 Branch 8 IFEQ L242 - true
   * 3 nu.staldal.lagoon.producer.MyInputStream.deliver(I)V: I21 Branch 9 IF_ICMPEQ L244 - true
   */
  @Test
  public void test1()  throws Throwable  {
      MyInputStream myInputStream0 = new MyInputStream();
      myInputStream0.deliver((-268));
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 nu.staldal.lagoon.producer.MyInputStream.deliver(I)V: I4 Branch 7 IFEQ L241 - false
   * 2 nu.staldal.lagoon.producer.MyInputStream.eof()V: root-Branch
   * 3 nu.staldal.lagoon.producer.MyInputStream.<init>()V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      MyInputStream myInputStream0 = new MyInputStream();
      myInputStream0.eof();
      myInputStream0.deliver((-1));
  }
}
