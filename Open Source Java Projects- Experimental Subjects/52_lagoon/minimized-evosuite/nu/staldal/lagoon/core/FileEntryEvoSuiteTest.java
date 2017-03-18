/*
 * This file was automatically generated by EvoSuite
 */

package nu.staldal.lagoon.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import nu.staldal.lagoon.core.FileEntry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class FileEntryEvoSuiteTest {

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
   * 2 covered goals:
   * 1 nu.staldal.lagoon.core.FileEntry$TempOutputHandler.commit()V: root-Branch
   * 2 nu.staldal.lagoon.core.FileEntry$TempOutputHandler.<init>(Ljava/io/File;Ljava/io/OutputStream;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      File file0 = new File((File) null, "(");
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
      FileEntry.TempOutputHandler fileEntry_TempOutputHandler0 = new FileEntry.TempOutputHandler(file0, (OutputStream) pipedOutputStream0);
      fileEntry_TempOutputHandler0.commit();
  }

  //Test case number: 1
  /*
   * 1 covered goal:
   * 1 nu.staldal.lagoon.core.FileEntry$TempOutputHandler.discard()V: I10 Branch 1 IFNE L618 - true
   */
  @Test
  public void test1()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          File file0 = new File((File) null, "");
          File file1 = file0.getAbsoluteFile();
          PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
          FileEntry.TempOutputHandler fileEntry_TempOutputHandler0 = new FileEntry.TempOutputHandler(file1, (OutputStream) pipedOutputStream0);
          // Undeclared exception!
          try {
            fileEntry_TempOutputHandler0.discard();
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (\"java.io.FilePermission\" \"/home/jeshkracht\" \"delete\")
             * java.lang.Thread.getStackTrace(Thread.java:1589)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkDelete(SecurityManager.java:1007)
             * java.io.File.delete(File.java:1030)
             * nu.staldal.lagoon.core.FileEntry$TempOutputHandler.discard(FileEntry.java:619)
             * sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
             * sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
             * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
             * java.lang.reflect.Method.invoke(Method.java:606)
             * org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:262)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:217)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask.run(FutureTask.java:262)
             * java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
             * java.lang.Thread.run(Thread.java:745)
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
   * 1 nu.staldal.lagoon.core.FileEntry$TempOutputHandler.discard()V: I10 Branch 1 IFNE L618 - false
   * 2 nu.staldal.lagoon.core.FileEntry$TempOutputHandler.<init>(Ljava/io/File;Ljava/io/OutputStream;)V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      File file0 = new File((File) null, "(");
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
      FileEntry.TempOutputHandler fileEntry_TempOutputHandler0 = new FileEntry.TempOutputHandler(file0, (OutputStream) pipedOutputStream0);
      fileEntry_TempOutputHandler0.discard();
  }
}