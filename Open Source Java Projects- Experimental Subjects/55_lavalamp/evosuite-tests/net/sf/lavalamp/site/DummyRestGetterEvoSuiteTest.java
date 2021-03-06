/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.site;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.io.IOException;
import net.sf.lavalamp.site.DummyRestGetter;
import net.sf.lavalamp.site.LoginRequiredException;

public class DummyRestGetterEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 net.sf.lavalamp.site.DummyRestGetter.get(Ljava/lang/String;[C)Ljava/lang/String;: root-Branch
   * 2 net.sf.lavalamp.site.DummyRestGetter.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      DummyRestGetter dummyRestGetter0 = new DummyRestGetter();
      char[] charArray0 = new char[10];
      dummyRestGetter0.get("", charArray0);
  }

  //Test case number: 1
  /*
   * 1 covered goal:
   * 1 net.sf.lavalamp.site.DummyRestGetter.get(Ljava/lang/String;)Ljava/lang/String;: I5 Branch 1 IFEQ L9 - true
   */
  @Test
  public void test1()  throws Throwable  {
      DummyRestGetter dummyRestGetter0 = new DummyRestGetter();
      try {
        dummyRestGetter0.get("+c $ENo_W%ZZN\"");
        fail("Expecting exception: LoginRequiredException");
      } catch(LoginRequiredException e) {
      }
  }

  //Test case number: 2
  /*
   * 2 covered goals:
   * 1 net.sf.lavalamp.site.DummyRestGetter.get(Ljava/lang/String;)Ljava/lang/String;: I5 Branch 1 IFEQ L9 - false
   * 2 net.sf.lavalamp.site.DummyRestGetter.<init>()V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      DummyRestGetter dummyRestGetter0 = new DummyRestGetter();
      dummyRestGetter0.get("os_authType=basic");
  }
}
