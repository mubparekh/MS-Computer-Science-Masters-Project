/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.authc.credential;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.jsecurity.authc.AuthenticationInfo;
import org.jsecurity.authc.AuthenticationToken;
import org.jsecurity.authc.SimpleAccount;
import org.jsecurity.authc.credential.AllowAllCredentialsMatcher;

public class AllowAllCredentialsMatcherEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authc.credential.AllowAllCredentialsMatcher.doCredentialsMatch(Lorg/jsecurity/authc/AuthenticationToken;Lorg/jsecurity/authc/AuthenticationInfo;)Z: root-Branch
   * 2 org.jsecurity.authc.credential.AllowAllCredentialsMatcher.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      AllowAllCredentialsMatcher allowAllCredentialsMatcher0 = new AllowAllCredentialsMatcher();
      SimpleAccount simpleAccount0 = new SimpleAccount();
      boolean boolean0 = allowAllCredentialsMatcher0.doCredentialsMatch((AuthenticationToken) null, (AuthenticationInfo) simpleAccount0);
      assertEquals(true, boolean0);
  }
}
