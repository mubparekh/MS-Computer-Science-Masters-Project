/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.authc.credential;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.jsecurity.authc.AuthenticationInfo;
import org.jsecurity.authc.AuthenticationToken;
import org.jsecurity.authc.SimpleAccount;
import org.jsecurity.authc.UsernamePasswordToken;
import org.jsecurity.authc.credential.Md5CredentialsMatcher;
import org.jsecurity.authc.credential.Sha1CredentialsMatcher;
import org.jsecurity.authc.credential.Sha384CredentialsMatcher;
import org.jsecurity.subject.PrincipalCollection;
import org.jsecurity.subject.SimplePrincipalCollection;

public class HashedCredentialsMatcherEvoSuiteTest {


  //Test case number: 0
  /*
   * 6 covered goals:
   * 1 org.jsecurity.authc.credential.HashedCredentialsMatcher.getSalt(Lorg/jsecurity/authc/AuthenticationToken;)Ljava/lang/Object;: root-Branch
   * 2 org.jsecurity.authc.credential.HashedCredentialsMatcher.getHashIterations()I: root-Branch
   * 3 org.jsecurity.authc.credential.HashedCredentialsMatcher.isHashSalted()Z: root-Branch
   * 4 org.jsecurity.authc.credential.HashedCredentialsMatcher.<init>()V: root-Branch
   * 5 org.jsecurity.authc.credential.HashedCredentialsMatcher.setHashSalted(Z)V: root-Branch
   * 6 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationToken;)Ljava/lang/Object;: I9 Branch 2 IFEQ L209 - false
   */
  @Test
  public void test0()  throws Throwable  {
      Md5CredentialsMatcher md5CredentialsMatcher0 = new Md5CredentialsMatcher();
      assertEquals(false, md5CredentialsMatcher0.isHashSalted());
      
      md5CredentialsMatcher0.setHashSalted(true);
      Inet4Address inet4Address0 = (Inet4Address)InetAddress.getByName("");
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("", "", true, (InetAddress) inet4Address0);
      md5CredentialsMatcher0.getCredentials((AuthenticationToken) usernamePasswordToken0);
      assertEquals(true, md5CredentialsMatcher0.isHashSalted());
  }

  //Test case number: 1
  /*
   * 4 covered goals:
   * 1 org.jsecurity.authc.credential.HashedCredentialsMatcher.isStoredCredentialsHexEncoded()Z: root-Branch
   * 2 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationToken;)Ljava/lang/Object;: I9 Branch 2 IFEQ L209 - true
   * 3 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationInfo;)Ljava/lang/Object;: I15 Branch 3 IFNE L238 - true
   * 4 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationInfo;)Ljava/lang/Object;: I23 Branch 5 IFEQ L241 - false
   */
  @Test
  public void test1()  throws Throwable  {
      Md5CredentialsMatcher md5CredentialsMatcher0 = new Md5CredentialsMatcher();
      char[] charArray0 = new char[2];
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("kC", charArray0);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) "UTF-8", "kC");
      SimpleAccount simpleAccount0 = new SimpleAccount((PrincipalCollection) simplePrincipalCollection0, (Object) "UTF-8");
      // Undeclared exception!
      try {
        md5CredentialsMatcher0.doCredentialsMatch((AuthenticationToken) usernamePasswordToken0, (AuthenticationInfo) simpleAccount0);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * Odd number of characters.
         */
      }
  }

  //Test case number: 2
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authc.credential.HashedCredentialsMatcher.setHashIterations(I)V: I4 Branch 1 IF_ICMPGE L175 - true
   */
  @Test
  public void test2()  throws Throwable  {
      Sha1CredentialsMatcher sha1CredentialsMatcher0 = new Sha1CredentialsMatcher();
      sha1CredentialsMatcher0.setHashIterations(1);
      assertEquals(false, sha1CredentialsMatcher0.isHashSalted());
      assertEquals(1, sha1CredentialsMatcher0.getHashIterations());
      assertEquals(true, sha1CredentialsMatcher0.isStoredCredentialsHexEncoded());
  }

  //Test case number: 3
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authc.credential.HashedCredentialsMatcher.setHashIterations(I)V: I4 Branch 1 IF_ICMPGE L175 - false
   */
  @Test
  public void test3()  throws Throwable  {
      Sha384CredentialsMatcher sha384CredentialsMatcher0 = new Sha384CredentialsMatcher();
      sha384CredentialsMatcher0.setHashIterations((-1054));
      assertEquals(false, sha384CredentialsMatcher0.isHashSalted());
      assertEquals(true, sha384CredentialsMatcher0.isStoredCredentialsHexEncoded());
      assertEquals(1, sha384CredentialsMatcher0.getHashIterations());
  }

  //Test case number: 4
  /*
   * 8 covered goals:
   * 1 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationInfo;)Ljava/lang/Object;: I23 Branch 5 IFEQ L241 - true
   * 2 org.jsecurity.authc.credential.HashedCredentialsMatcher.getHashIterations()I: root-Branch
   * 3 org.jsecurity.authc.credential.HashedCredentialsMatcher.isHashSalted()Z: root-Branch
   * 4 org.jsecurity.authc.credential.HashedCredentialsMatcher.<init>()V: root-Branch
   * 5 org.jsecurity.authc.credential.HashedCredentialsMatcher.setStoredCredentialsHexEncoded(Z)V: root-Branch
   * 6 org.jsecurity.authc.credential.HashedCredentialsMatcher.isStoredCredentialsHexEncoded()Z: root-Branch
   * 7 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationToken;)Ljava/lang/Object;: I9 Branch 2 IFEQ L209 - true
   * 8 org.jsecurity.authc.credential.HashedCredentialsMatcher.getCredentials(Lorg/jsecurity/authc/AuthenticationInfo;)Ljava/lang/Object;: I15 Branch 3 IFNE L238 - true
   */
  @Test
  public void test4()  throws Throwable  {
      Md5CredentialsMatcher md5CredentialsMatcher0 = new Md5CredentialsMatcher();
      assertEquals(true, md5CredentialsMatcher0.isStoredCredentialsHexEncoded());
      
      char[] charArray0 = new char[2];
      md5CredentialsMatcher0.setStoredCredentialsHexEncoded(false);
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("kC", charArray0);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) "UTF-8", "kC");
      SimpleAccount simpleAccount0 = new SimpleAccount((PrincipalCollection) simplePrincipalCollection0, (Object) "UTF-8");
      md5CredentialsMatcher0.doCredentialsMatch((AuthenticationToken) usernamePasswordToken0, (AuthenticationInfo) simpleAccount0);
      assertEquals(false, md5CredentialsMatcher0.isStoredCredentialsHexEncoded());
      assertEquals(false, md5CredentialsMatcher0.isHashSalted());
  }
}