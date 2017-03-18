/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.jsecurity.io.IniResource;
import org.jsecurity.io.ResourceException;

public class TextResourceEvoSuiteTest {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 org.jsecurity.io.TextResource.<init>()V: root-Branch
   * 2 org.jsecurity.io.TextResource.load(Ljava/lang/String;)V: I3 Branch 1 IFNONNULL L71 - true
   */
  @Test
  public void test0()  throws Throwable  {
      IniResource iniResource0 = null;
      try {
        iniResource0 = new IniResource("specifying the standard LogFactory from the command line. ");
        fail("Expecting exception: ResourceException");
      } catch(ResourceException e) {
        /*
         * Unable to load text resource from the resource path [specifying the standard LogFactory from the command line. ]
         */
      }
  }

  //Test case number: 1
  /*
   * 4 covered goals:
   * 1 org.jsecurity.io.TextResource.doLoad(Ljava/io/InputStream;)V: I8 Branch 2 IFNULL L85 - true
   * 2 org.jsecurity.io.TextResource.getCharsetName()Ljava/lang/String;: root-Branch
   * 3 org.jsecurity.io.TextResource.doLoad(Ljava/io/BufferedReader;)V: root-Branch
   * 4 org.jsecurity.io.TextResource.load(Ljava/io/Reader;)V: I4 Branch 3 IFEQ L95 - true
   */
  @Test
  public void test1()  throws Throwable  {
      StringReader stringReader0 = new StringReader("");
      IniResource iniResource0 = new IniResource((Reader) stringReader0);
      byte[] byteArray0 = new byte[6];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0, 1422, (-1234));
      iniResource0.load((InputStream) byteArrayInputStream0);
      assertEquals(-1416, byteArrayInputStream0.available());
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 org.jsecurity.io.TextResource.load(Ljava/lang/String;)V: I3 Branch 1 IFNONNULL L71 - false
   * 2 org.jsecurity.io.TextResource.<init>()V: root-Branch
   * 3 org.jsecurity.io.TextResource.setCharsetName(Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      IniResource iniResource0 = null;
      try {
        iniResource0 = new IniResource((String) null, (String) null);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * 'resourcePath' argument cannot be null.
         */
      }
  }
}