/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.crypto.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.jsecurity.crypto.hash.Sha512Hash;

public class Sha512HashEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 org.jsecurity.crypto.hash.Sha512Hash.getAlgorithmName()Ljava/lang/String;: root-Branch
   * 2 org.jsecurity.crypto.hash.Sha512Hash.<init>(Ljava/lang/Object;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      Sha512Hash sha512Hash0 = new Sha512Hash((Object) "UTF-8");
      assertEquals("ce7ba9a82c602e57507185e7a749f9eb76bce2b0fb87e478e815ab868600be13199fbea902b996458e20ef3cf2d61219e5d1743a1d8a2deddc76bc90d1802ddf", sha512Hash0.toString());
  }

  //Test case number: 1
  /*
   * 2 covered goals:
   * 1 org.jsecurity.crypto.hash.Sha512Hash.fromHexString(Ljava/lang/String;)Lorg/jsecurity/crypto/hash/Sha512Hash;: root-Branch
   * 2 org.jsecurity.crypto.hash.Sha512Hash.<init>()V: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try {
        Sha512Hash.fromHexString(" implementation only supports conversion to ");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * Illegal hexadecimal charcter   at index 0
         */
      }
  }

  //Test case number: 2
  /*
   * 2 covered goals:
   * 1 org.jsecurity.crypto.hash.Sha512Hash.<init>(Ljava/lang/Object;Ljava/lang/Object;)V: root-Branch
   * 2 org.jsecurity.crypto.hash.Sha512Hash.getAlgorithmName()Ljava/lang/String;: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      Sha512Hash sha512Hash0 = new Sha512Hash((Object) "ce7ba9a82c602e57507185e7a749f9eb76bce2b0fb87e478e815ab868600be13199fbea902b996458e20ef3cf2d61219e5d1743a1d8a2deddc76bc90d1802ddf", (Object) "\u0000X\u0000\uFFFD\u0000\u0000\u0000");
      assertEquals("SHA-512", sha512Hash0.getAlgorithmName());
  }

  //Test case number: 3
  /*
   * 2 covered goals:
   * 1 org.jsecurity.crypto.hash.Sha512Hash.fromBase64String(Ljava/lang/String;)Lorg/jsecurity/crypto/hash/Sha512Hash;: root-Branch
   * 2 org.jsecurity.crypto.hash.Sha512Hash.<init>()V: root-Branch
   */
  @Test
  public void test3()  throws Throwable  {
      Sha512Hash sha512Hash0 = Sha512Hash.fromBase64String("82kRWw9s)u_nSDq<");
      assertEquals("f369115b0f6cba748300", sha512Hash0.toHex());
  }
}
