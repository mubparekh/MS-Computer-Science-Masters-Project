/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.session.mgt;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.jsecurity.session.ExpiredSessionException;
import org.jsecurity.session.InvalidSessionException;
import org.jsecurity.session.StoppedSessionException;
import org.jsecurity.session.mgt.SimpleSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class SimpleSessionEvoSuiteTest {

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
   * 3 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.getAttributes()Ljava/util/Map;: root-Branch
   * 2 org.jsecurity.session.mgt.SimpleSession.<init>(Ljava/net/InetAddress;)V: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.getAttributeKeys()Ljava/util/Collection;: I8 Branch 14 IFNONNULL L282 - false
   */
  @Test
  public void test0()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          Collection<Object> collection0 = simpleSession0.getAttributeKeys();
          assertNotNull(collection0);
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(false, simpleSession0.isExpired());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 1
  /*
   * 4 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.setStartTimestamp(Ljava/util/Date;)V: root-Branch
   * 2 org.jsecurity.session.mgt.SimpleSession.getLastAccessTime()Ljava/util/Date;: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.getLocalHost()Ljava/net/InetAddress;: root-Branch
   * 4 org.jsecurity.session.mgt.SimpleSession.<init>()V: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          Date date0 = simpleSession0.getLastAccessTime();
          assertNotNull(date0);
          
          simpleSession0.setStartTimestamp(date0);
          assertEquals(1433848166151L, date0.getTime());
          assertEquals(1800000L, simpleSession0.getTimeout());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 2
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.touch()V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          simpleSession0.touch();
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(false, simpleSession0.isTimedOut());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 3
  /*
   * 2 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.setStopTimestamp(Ljava/util/Date;)V: root-Branch
   * 2 org.jsecurity.session.mgt.SimpleSession.getStartTimestamp()Ljava/util/Date;: root-Branch
   */
  @Test
  public void test3()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          Date date0 = simpleSession0.getStartTimestamp();
          simpleSession0.setStopTimestamp(date0);
          assertEquals(true, simpleSession0.isStopped());
          assertEquals(1433848166212L, date0.getTime());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 4
  /*
   * 6 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.getId()Ljava/io/Serializable;: root-Branch
   * 2 org.jsecurity.session.mgt.SimpleSession.getStopTimestamp()Ljava/util/Date;: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.stop()V: I4 Branch 1 IFNONNULL L171 - false
   * 4 org.jsecurity.session.mgt.SimpleSession.isStopped()Z: I4 Branch 2 IFNULL L177 - false
   * 5 org.jsecurity.session.mgt.SimpleSession.expire()V: I8 Branch 3 IFNE L182 - false
   * 6 org.jsecurity.session.mgt.SimpleSession.validate()V: I4 Branch 10 IFEQ L240 - false
   */
  @Test
  public void test4()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          simpleSession0.expire();
          try {
            simpleSession0.validate();
            fail("Expecting exception: StoppedSessionException");
          } catch(StoppedSessionException e) {
            /*
             * Session with id [null] has been explicitly stopped.  No further interaction under this session is allowed.
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.isValid()Z: I7 Branch 5 IFNE L191 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.isValid()Z: I4 Branch 4 IFNE L191 - false
   * 3 org.jsecurity.session.mgt.SimpleSession.setExpired(Z)V: root-Branch
   */
  @Test
  public void test6()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          assertEquals(false, simpleSession0.isExpired());
          
          simpleSession0.setExpired(true);
          boolean boolean0 = simpleSession0.isValid();
          assertEquals(true, simpleSession0.isExpired());
          assertEquals(false, boolean0);
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 7
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.setHostAddress(Ljava/net/InetAddress;)V: root-Branch
   */
  @Test
  public void test7()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.setHostAddress((InetAddress) null);
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(false, simpleSession0.isExpired());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 8
  /*
   * 5 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I19 Branch 7 IFLT L207 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I83 Branch 9 IFEQ L229 - true
   * 3 org.jsecurity.session.mgt.SimpleSession.setTimeout(J)V: root-Branch
   * 4 org.jsecurity.session.mgt.SimpleSession.getTimeout()J: root-Branch
   * 5 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I4 Branch 6 IFEQ L201 - true
   */
  @Test
  public void test8()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          assertEquals(1800000L, simpleSession0.getTimeout());
          
          simpleSession0.setTimeout((-1L));
          boolean boolean0 = simpleSession0.isTimedOut();
          assertEquals(false, boolean0);
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 9
  /*
   * 4 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I28 Branch 8 IFNONNULL L211 - false
   * 2 org.jsecurity.session.mgt.SimpleSession.setLastAccessTime(Ljava/util/Date;)V: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.validate()V: I4 Branch 10 IFEQ L240 - true
   * 4 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I19 Branch 7 IFLT L207 - false
   */
  @Test
  public void test9()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.setLastAccessTime((Date) null);
          // Undeclared exception!
          try {
            simpleSession0.validate();
            fail("Expecting exception: IllegalStateException");
          } catch(IllegalStateException e) {
            /*
             * session.lastAccessTime for session with id [null] is null.  This value must be set at least once, preferably at least upon instantiation.  Please check the org.jsecurity.session.mgt.SimpleSession implementation and ensure this value will be set (perhaps in the constructor?)
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 10
  /*
   * 4 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.getAttributesLazy()Ljava/util/Map;: I8 Branch 13 IFNONNULL L273 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.setAttributes(Ljava/util/Map;)V: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.getAttributesLazy()Ljava/util/Map;: I8 Branch 13 IFNONNULL L273 - false
   * 4 org.jsecurity.session.mgt.SimpleSession.setAttribute(Ljava/lang/Object;Ljava/lang/Object;)V: I3 Branch 16 IFNONNULL L298 - true
   */
  @Test
  public void test10()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          simpleSession0.setAttribute((Object) simpleSession0, (Object) "lo");
          Object object0 = new Object();
          simpleSession0.setAttribute(object0, object0);
          assertEquals(true, simpleSession0.isValid());
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(false, simpleSession0.isTimedOut());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 11
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.getHostAddress()Ljava/net/InetAddress;: root-Branch
   */
  @Test
  public void test11()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          Inet4Address inet4Address1 = (Inet4Address)simpleSession0.getHostAddress();
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(true, simpleSession0.isValid());
          assertNotNull(inet4Address1);
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 12
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.setId(Ljava/io/Serializable;)V: root-Branch
   */
  @Test
  public void test12()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLoopbackAddress();
          simpleSession0.setId((Serializable) inet4Address0);
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(false, simpleSession0.isTimedOut());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 13
  /*
   * 2 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.stop()V: I4 Branch 1 IFNONNULL L171 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.expire()V: I8 Branch 3 IFNE L182 - true
   */
  @Test
  public void test13()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.expire();
          simpleSession0.expire();
          assertEquals(true, simpleSession0.isStopped());
          assertEquals(1800000L, simpleSession0.getTimeout());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 14
  /*
   * 3 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.isValid()Z: I4 Branch 4 IFNE L191 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.isStopped()Z: I4 Branch 2 IFNULL L177 - false
   * 3 org.jsecurity.session.mgt.SimpleSession.expire()V: I8 Branch 3 IFNE L182 - false
   */
  @Test
  public void test14()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.expire();
          boolean boolean0 = simpleSession0.isValid();
          assertEquals(true, simpleSession0.isStopped());
          assertEquals(false, boolean0);
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 15
  /*
   * 8 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I4 Branch 6 IFEQ L201 - false
   * 2 org.jsecurity.session.mgt.SimpleSession.validate()V: I4 Branch 10 IFEQ L240 - true
   * 3 org.jsecurity.session.mgt.SimpleSession.validate()V: I36 Branch 11 IFEQ L249 - false
   * 4 org.jsecurity.session.mgt.SimpleSession.validate()V: I105 Branch 12 IFEQ L264 - true
   * 5 org.jsecurity.session.mgt.SimpleSession.getId()Ljava/io/Serializable;: root-Branch
   * 6 org.jsecurity.session.mgt.SimpleSession.setExpired(Z)V: root-Branch
   * 7 org.jsecurity.session.mgt.SimpleSession.stop()V: I4 Branch 1 IFNONNULL L171 - false
   * 8 org.jsecurity.session.mgt.SimpleSession.expire()V: I8 Branch 3 IFNE L182 - true
   */
  @Test
  public void test15()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.setExpired(true);
          try {
            simpleSession0.validate();
            fail("Expecting exception: ExpiredSessionException");
          } catch(ExpiredSessionException e) {
            /*
             * Session with id [null] has expired. Last access time: 6/9/15 5:09 AM.  Current time: 6/9/15 5:09 AM.  Session timeout is set to 1800 seconds (30 minutes)
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 16
  /*
   * 10 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.validate()V: I36 Branch 11 IFEQ L249 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.isExpired()Z: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.getStopTimestamp()Ljava/util/Date;: root-Branch
   * 4 org.jsecurity.session.mgt.SimpleSession.getTimeout()J: root-Branch
   * 5 org.jsecurity.session.mgt.SimpleSession.getLastAccessTime()Ljava/util/Date;: root-Branch
   * 6 org.jsecurity.session.mgt.SimpleSession.validate()V: I4 Branch 10 IFEQ L240 - true
   * 7 org.jsecurity.session.mgt.SimpleSession.isStopped()Z: I4 Branch 2 IFNULL L177 - true
   * 8 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I4 Branch 6 IFEQ L201 - true
   * 9 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I19 Branch 7 IFLT L207 - false
   * 10 org.jsecurity.session.mgt.SimpleSession.isTimedOut()Z: I28 Branch 8 IFNONNULL L211 - true
   */
  @Test
  public void test16()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.validate();
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(false, simpleSession0.isStopped());
          assertEquals(true, simpleSession0.isValid());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 17
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.getAttributeKeys()Ljava/util/Collection;: I8 Branch 14 IFNONNULL L282 - true
   */
  @Test
  public void test17()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.setAttribute((Object) simpleSession0, (Object) "");
          Collection<Object> collection0 = simpleSession0.getAttributeKeys();
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertNotNull(collection0);
          assertEquals(1, collection0.size());
          assertEquals(false, simpleSession0.isExpired());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 18
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.getAttribute(Ljava/lang/Object;)Ljava/lang/Object;: I8 Branch 15 IFNONNULL L291 - true
   */
  @Test
  public void test18()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.setAttribute((Object) "127.0.0.1", (Object) simpleSession0);
          SimpleSession simpleSession1 = (SimpleSession)simpleSession0.getAttribute((Object) "127.0.0.1");
          assertEquals(false, simpleSession0.isExpired());
          assertNotNull(simpleSession1);
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(1800000L, simpleSession1.getTimeout());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 19
  /*
   * 1 covered goal:
   * 1 org.jsecurity.session.mgt.SimpleSession.getAttribute(Ljava/lang/Object;)Ljava/lang/Object;: I8 Branch 15 IFNONNULL L291 - false
   */
  @Test
  public void test19()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          Object object0 = new Object();
          simpleSession0.getAttribute(object0);
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(true, simpleSession0.isValid());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 20
  /*
   * 2 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.setAttribute(Ljava/lang/Object;Ljava/lang/Object;)V: I3 Branch 16 IFNONNULL L298 - false
   * 2 org.jsecurity.session.mgt.SimpleSession.removeAttribute(Ljava/lang/Object;)Ljava/lang/Object;: I8 Branch 17 IFNONNULL L307 - false
   */
  @Test
  public void test20()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          Inet4Address inet4Address0 = (Inet4Address)InetAddress.getLocalHost();
          SimpleSession simpleSession0 = new SimpleSession((InetAddress) inet4Address0);
          simpleSession0.setAttribute((Object) null, (Object) null);
          assertEquals(false, simpleSession0.isTimedOut());
          assertEquals(1800000L, simpleSession0.getTimeout());
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 21
  /*
   * 8 covered goals:
   * 1 org.jsecurity.session.mgt.SimpleSession.removeAttribute(Ljava/lang/Object;)Ljava/lang/Object;: I8 Branch 17 IFNONNULL L307 - true
   * 2 org.jsecurity.session.mgt.SimpleSession.getAttributes()Ljava/util/Map;: root-Branch
   * 3 org.jsecurity.session.mgt.SimpleSession.getLocalHost()Ljava/net/InetAddress;: root-Branch
   * 4 org.jsecurity.session.mgt.SimpleSession.<init>()V: root-Branch
   * 5 org.jsecurity.session.mgt.SimpleSession.<init>(Ljava/net/InetAddress;)V: root-Branch
   * 6 org.jsecurity.session.mgt.SimpleSession.setAttributes(Ljava/util/Map;)V: root-Branch
   * 7 org.jsecurity.session.mgt.SimpleSession.getAttributesLazy()Ljava/util/Map;: I8 Branch 13 IFNONNULL L273 - false
   * 8 org.jsecurity.session.mgt.SimpleSession.setAttribute(Ljava/lang/Object;Ljava/lang/Object;)V: I3 Branch 16 IFNONNULL L298 - true
   */
  @Test
  public void test21()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          SimpleSession simpleSession0 = new SimpleSession();
          simpleSession0.setAttribute((Object) simpleSession0, (Object) "");
          simpleSession0.removeAttribute((Object) "localhost/127.0.0.1");
          assertEquals(1800000L, simpleSession0.getTimeout());
          assertEquals(true, simpleSession0.isValid());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }
}
