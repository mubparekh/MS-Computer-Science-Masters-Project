/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.device;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import net.sf.lavalamp.device.Action;
import net.sf.lavalamp.device.Actions;

public class ActionsEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 net.sf.lavalamp.device.Actions.getSuccessAction()Lnet/sf/lavalamp/device/Action;: root-Branch
   * 2 net.sf.lavalamp.device.Actions.<init>(Lnet/sf/lavalamp/device/Action;Lnet/sf/lavalamp/device/Action;Lnet/sf/lavalamp/device/Action;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      Actions actions0 = new Actions((Action) null, (Action) null, (Action) null);
      Action action0 = actions0.getSuccessAction();
      assertNull(action0);
  }

  //Test case number: 1
  /*
   * 1 covered goal:
   * 1 net.sf.lavalamp.device.Actions.getErrorAction()Lnet/sf/lavalamp/device/Action;: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      Actions actions0 = new Actions((Action) null, (Action) null, (Action) null);
      Action action0 = actions0.getErrorAction();
      assertNull(action0);
  }

  //Test case number: 2
  /*
   * 2 covered goals:
   * 1 net.sf.lavalamp.device.Actions.getFailureAction()Lnet/sf/lavalamp/device/Action;: root-Branch
   * 2 net.sf.lavalamp.device.Actions.<init>(Lnet/sf/lavalamp/device/Action;Lnet/sf/lavalamp/device/Action;Lnet/sf/lavalamp/device/Action;)V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      Actions actions0 = new Actions((Action) null, (Action) null, (Action) null);
      Action action0 = actions0.getFailureAction();
      assertNull(action0);
  }
}
