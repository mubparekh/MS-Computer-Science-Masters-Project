/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.jsecurity.authc.AuthenticationException;
import org.jsecurity.authc.AuthenticationInfo;
import org.jsecurity.authc.AuthenticationToken;
import org.jsecurity.authc.SimpleAccount;
import org.jsecurity.authc.SimpleAuthenticationInfo;
import org.jsecurity.authc.UsernamePasswordToken;
import org.jsecurity.crypto.Cipher;
import org.jsecurity.io.DefaultSerializer;
import org.jsecurity.io.SerializationException;
import org.jsecurity.io.Serializer;
import org.jsecurity.subject.PrincipalCollection;
import org.jsecurity.subject.SimplePrincipalCollection;
import org.jsecurity.web.WebRememberMeManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class AbstractRememberMeManagerEvoSuiteTest {

  private static ExecutorService executor; 

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    executor = Executors.newCachedThreadPool(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    executor.shutdownNow(); 
  } 

  @Before 
  public void initTestCase(){ 
  } 

  @After 
  public void doneWithTestCase(){ 
  } 


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.forgetIdentity(Lorg/jsecurity/authc/AuthenticationToken;Lorg/jsecurity/authc/AuthenticationException;)V: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.<init>()V: root-Branch
   * 3 org.jsecurity.subject.AbstractRememberMeManager.forgetIdentity(Lorg/jsecurity/authc/AuthenticationToken;)V: root-Branch
   * 4 org.jsecurity.subject.AbstractRememberMeManager.onFailedLogin(Lorg/jsecurity/authc/AuthenticationToken;Lorg/jsecurity/authc/AuthenticationException;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("0fE&9)ZIh8[d", "0fE&9)ZIh8[d", true);
      // Undeclared exception!
      try {
        webRememberMeManager0.onFailedLogin((AuthenticationToken) usernamePasswordToken0, (AuthenticationException) null);
        fail("Expecting exception: NoClassDefFoundError");
      } catch(NoClassDefFoundError e) {
        /*
         * Could not initialize class org.jsecurity.web.WebUtils
         */
      }
  }

  //Test case number: 1
  /*
   * 9 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.rememberIdentity(Lorg/jsecurity/authc/AuthenticationToken;Lorg/jsecurity/authc/AuthenticationInfo;)V: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.getEncryptionCipherKey()[B: root-Branch
   * 3 org.jsecurity.subject.AbstractRememberMeManager.serialize(Lorg/jsecurity/subject/PrincipalCollection;)[B: root-Branch
   * 4 org.jsecurity.subject.AbstractRememberMeManager.rememberIdentity(Lorg/jsecurity/authc/AuthenticationInfo;)V: root-Branch
   * 5 org.jsecurity.subject.AbstractRememberMeManager.getSerializer()Lorg/jsecurity/io/Serializer;: root-Branch
   * 6 org.jsecurity.subject.AbstractRememberMeManager.getCipher()Lorg/jsecurity/crypto/Cipher;: root-Branch
   * 7 org.jsecurity.subject.AbstractRememberMeManager.getIdentityToRemember(Lorg/jsecurity/authc/AuthenticationInfo;)Lorg/jsecurity/subject/PrincipalCollection;: root-Branch
   * 8 org.jsecurity.subject.AbstractRememberMeManager.rememberIdentity(Lorg/jsecurity/subject/PrincipalCollection;)V: I10 Branch 6 IFNULL L174 - false
   * 9 org.jsecurity.subject.AbstractRememberMeManager.encrypt([B)[B: I12 Branch 12 IFNULL L236 - false
   */
  @Test
  public void test1()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("", "", (InetAddress) inet4Address0);
          SimpleAccount simpleAccount0 = new SimpleAccount((Object) "[]", (Object) "name", "[]");
          // Undeclared exception!
          try {
            webRememberMeManager0.rememberIdentity((AuthenticationToken) usernamePasswordToken0, (AuthenticationInfo) simpleAccount0);
            fail("Expecting exception: NoClassDefFoundError");
          } catch(NoClassDefFoundError e) {
            /*
             * Could not initialize class org.jsecurity.web.WebUtils
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 2
  /*
   * 2 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setEncryptionCipherKeyBase64(Ljava/lang/String;)V: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.setEncryptionCipherKey([B)V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      webRememberMeManager0.setEncryptionCipherKeyBase64("0fE&9)ZIh8[d");
      assertEquals(94608000, webRememberMeManager0.getCookieMaxAge());
  }

  //Test case number: 3
  /*
   * 3 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setCipherKey([B)V: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.setCipherKeyBase64(Ljava/lang/String;)V: root-Branch
   * 3 org.jsecurity.subject.AbstractRememberMeManager.setDecryptionCipherKey([B)V: root-Branch
   */
  @Test
  public void test3()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      webRememberMeManager0.setCipherKeyBase64("BOOTSTRAP COMPLETED");
      assertNull(webRememberMeManager0.getCookiePath());
  }

  //Test case number: 4
  /*
   * 2 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.getCipherKey()[B: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.getEncryptionCipherKey()[B: root-Branch
   */
  @Test
  public void test4()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      byte[] byteArray0 = webRememberMeManager0.getCipherKey();
      assertNull(byteArray0);
  }

  //Test case number: 5
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setDecryptionCipherKeyBase64(Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test5()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      // Undeclared exception!
      try {
        webRememberMeManager0.setDecryptionCipherKeyBase64((String) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 6
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setEncryptionCipherKeyHex(Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test6()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      // Undeclared exception!
      try {
        webRememberMeManager0.setEncryptionCipherKeyHex((String) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 7
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.deserialize([B)Lorg/jsecurity/subject/PrincipalCollection;: root-Branch
   */
  @Test
  public void test7()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      byte[] byteArray0 = new byte[9];
      // Undeclared exception!
      try {
        webRememberMeManager0.deserialize(byteArray0);
        fail("Expecting exception: SerializationException");
      } catch(SerializationException e) {
        /*
         * Unable to deserialze argument byte array.
         */
      }
  }

  //Test case number: 8
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setDecryptionCipherKeyHex(Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test8()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      webRememberMeManager0.setDecryptionCipherKeyHex("");
      assertNull(webRememberMeManager0.getCookiePath());
  }

  //Test case number: 9
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.onLogout(Lorg/jsecurity/subject/PrincipalCollection;)V: root-Branch
   */
  @Test
  public void test9()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) "name", "name");
      // Undeclared exception!
      try {
        webRememberMeManager0.onLogout((PrincipalCollection) simplePrincipalCollection0);
        fail("Expecting exception: NoClassDefFoundError");
      } catch(NoClassDefFoundError e) {
        /*
         * Could not initialize class org.jsecurity.web.WebUtils
         */
      }
  }

  //Test case number: 10
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setSerializer(Lorg/jsecurity/io/Serializer;)V: root-Branch
   */
  @Test
  public void test10()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      DefaultSerializer defaultSerializer0 = (DefaultSerializer)webRememberMeManager0.getSerializer();
      webRememberMeManager0.setSerializer((Serializer) defaultSerializer0);
      assertNull(webRememberMeManager0.getCookiePath());
  }

  //Test case number: 11
  /*
   * 4 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.setCipherKeyHex(Ljava/lang/String;)V: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.setCipherKey([B)V: root-Branch
   * 3 org.jsecurity.subject.AbstractRememberMeManager.setDecryptionCipherKey([B)V: root-Branch
   * 4 org.jsecurity.subject.AbstractRememberMeManager.setEncryptionCipherKey([B)V: root-Branch
   */
  @Test
  public void test11()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      webRememberMeManager0.setCipherKeyHex("");
      assertEquals(false, webRememberMeManager0.isCookieSecure());
  }

  //Test case number: 12
  /*
   * 2 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.getDecryptionCipherKey()[B: root-Branch
   * 2 org.jsecurity.subject.AbstractRememberMeManager.decrypt([B)[B: I12 Branch 13 IFNULL L245 - false
   */
  @Test
  public void test12()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      byte[] byteArray0 = new byte[2];
      // Undeclared exception!
      try {
        webRememberMeManager0.decrypt(byteArray0);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
        /*
         * Unable to crypt bytes with cipher [javax.crypto.Cipher@1c579c57].
         */
      }
  }

  //Test case number: 13
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I3 Branch 1 IFNULL L139 - true
   */
  @Test
  public void test13()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      boolean boolean0 = webRememberMeManager0.isRememberMe((AuthenticationToken) null);
      assertEquals(false, boolean0);
  }

  //Test case number: 14
  /*
   * 3 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I3 Branch 1 IFNULL L139 - false
   * 2 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I6 Branch 2 IFEQ L139 - false
   * 3 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I10 Branch 3 IFEQ L139 - true
   */
  @Test
  public void test14()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      char[] charArray0 = new char[4];
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("ayUAxYw\"", charArray0, false);
      boolean boolean0 = webRememberMeManager0.isRememberMe((AuthenticationToken) usernamePasswordToken0);
      assertEquals(false, boolean0);
  }

  //Test case number: 15
  /*
   * 3 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I10 Branch 3 IFEQ L139 - false
   * 2 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I3 Branch 1 IFNULL L139 - false
   * 3 org.jsecurity.subject.AbstractRememberMeManager.isRememberMe(Lorg/jsecurity/authc/AuthenticationToken;)Z: I6 Branch 2 IFEQ L139 - false
   */
  @Test
  public void test15()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      char[] charArray0 = new char[9];
      Inet4Address inet4Address0 = (Inet4Address)InetAddress.getByName((String) null);
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken((String) null, charArray0, true, (InetAddress) inet4Address0);
      boolean boolean0 = webRememberMeManager0.isRememberMe((AuthenticationToken) usernamePasswordToken0);
      assertEquals(true, boolean0);
  }

  //Test case number: 16
  /*
   * 6 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.rememberIdentity(Lorg/jsecurity/subject/PrincipalCollection;)V: I32 Branch 7 IFEQ L179 - false
   * 2 org.jsecurity.subject.AbstractRememberMeManager.rememberIdentity(Lorg/jsecurity/authc/AuthenticationToken;Lorg/jsecurity/authc/AuthenticationInfo;)V: root-Branch
   * 3 org.jsecurity.subject.AbstractRememberMeManager.serialize(Lorg/jsecurity/subject/PrincipalCollection;)[B: root-Branch
   * 4 org.jsecurity.subject.AbstractRememberMeManager.rememberIdentity(Lorg/jsecurity/authc/AuthenticationInfo;)V: root-Branch
   * 5 org.jsecurity.subject.AbstractRememberMeManager.getSerializer()Lorg/jsecurity/io/Serializer;: root-Branch
   * 6 org.jsecurity.subject.AbstractRememberMeManager.getIdentityToRemember(Lorg/jsecurity/authc/AuthenticationInfo;)Lorg/jsecurity/subject/PrincipalCollection;: root-Branch
   */
  @Test
  public void test16()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      char[] charArray0 = new char[8];
      UsernamePasswordToken usernamePasswordToken0 = new UsernamePasswordToken("G^6=2Ee9I l", charArray0, true);
      SimpleAuthenticationInfo simpleAuthenticationInfo0 = new SimpleAuthenticationInfo((Object) webRememberMeManager0, (Object) usernamePasswordToken0, "G^6=2Ee9I l");
      webRememberMeManager0.rememberIdentity((AuthenticationToken) usernamePasswordToken0, (AuthenticationInfo) simpleAuthenticationInfo0);
      assertNull(webRememberMeManager0.getCookiePath());
  }

  //Test case number: 17
  /*
   * 1 covered goal:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.onRememberedPrincipalFailure(Ljava/lang/Exception;)Lorg/jsecurity/subject/PrincipalCollection;: I4 Branch 11 IFEQ L223 - false
   */
  @Test
  public void test17()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      // Undeclared exception!
      try {
        webRememberMeManager0.onRememberedPrincipalFailure((Exception) null);
        fail("Expecting exception: NoClassDefFoundError");
      } catch(NoClassDefFoundError e) {
        /*
         * Could not initialize class org.jsecurity.web.WebUtils
         */
      }
  }

  //Test case number: 18
  /*
   * 4 covered goals:
   * 1 org.jsecurity.subject.AbstractRememberMeManager.decrypt([B)[B: I12 Branch 13 IFNULL L245 - true
   * 2 org.jsecurity.subject.AbstractRememberMeManager.setCipher(Lorg/jsecurity/crypto/Cipher;)V: root-Branch
   * 3 org.jsecurity.subject.AbstractRememberMeManager.getCipher()Lorg/jsecurity/crypto/Cipher;: root-Branch
   * 4 org.jsecurity.subject.AbstractRememberMeManager.<init>()V: root-Branch
   */
  @Test
  public void test18()  throws Throwable  {
      WebRememberMeManager webRememberMeManager0 = new WebRememberMeManager();
      webRememberMeManager0.setCipher((Cipher) null);
      byte[] byteArray0 = new byte[8];
      byte[] byteArray1 = webRememberMeManager0.decrypt(byteArray0);
      assertSame(byteArray1, byteArray0);
  }
}