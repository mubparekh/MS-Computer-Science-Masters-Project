/*
 * This file was automatically generated by EvoSuite
 */

package br.com.jnfe.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import br.com.jnfe.base.FinNFe;

public class FinNFeEvoSuiteTest {


  //Test case number: 0
  /*
   * 1 covered goal:
   * 1 br.com.jnfe.base.FinNFe.getValue()C: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      FinNFe finNFe0 = FinNFe.AJUSTE;
      char char0 = finNFe0.getValue();
      assertEquals('3', char0);
  }
}
