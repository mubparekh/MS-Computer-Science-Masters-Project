/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.factories;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import net.sf.lavalamp.device.DeviceProperties;
import net.sf.lavalamp.factories.DeviceBuildsFactory;

public class DeviceBuildsFactoryEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 net.sf.lavalamp.factories.DeviceBuildsFactory.make(Lnet/sf/lavalamp/device/DeviceProperties;)Lnet/sf/lavalamp/device/Device;: root-Branch
   * 2 net.sf.lavalamp.factories.DeviceBuildsFactory.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      DeviceBuildsFactory deviceBuildsFactory0 = new DeviceBuildsFactory();
      DeviceProperties deviceProperties0 = new DeviceProperties();
      // Undeclared exception!
      try {
        deviceBuildsFactory0.make(deviceProperties0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
