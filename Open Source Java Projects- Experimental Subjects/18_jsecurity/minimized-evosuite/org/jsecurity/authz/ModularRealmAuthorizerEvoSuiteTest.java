/*
 * This file was automatically generated by EvoSuite
 */

package org.jsecurity.authz;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import org.jsecurity.authz.AuthorizationException;
import org.jsecurity.authz.ModularRealmAuthorizer;
import org.jsecurity.authz.Permission;
import org.jsecurity.authz.permission.AllPermission;
import org.jsecurity.authz.permission.PermissionResolver;
import org.jsecurity.authz.permission.WildcardPermission;
import org.jsecurity.authz.permission.WildcardPermissionResolver;
import org.jsecurity.realm.Realm;
import org.jsecurity.realm.SimpleAccountRealm;
import org.jsecurity.subject.PrincipalCollection;
import org.jsecurity.subject.SimplePrincipalCollection;

public class ModularRealmAuthorizerEvoSuiteTest {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.assertRealmsConfigured()V: I11 Branch 2 IFLE L82 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.getRealms()Ljava/util/Collection;: root-Branch
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.setRealms(Ljava/util/Collection;)V: root-Branch
   * 4 org.jsecurity.authz.ModularRealmAuthorizer.<init>(Ljava/util/Collection;)V: root-Branch
   * 5 org.jsecurity.authz.ModularRealmAuthorizer.assertRealmsConfigured()V: I8 Branch 1 IFNULL L82 - false
   */
  @Test
  public void test0()  throws Throwable  {
      TreeSet<Realm> treeSet0 = new TreeSet<Realm>();
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer((Collection<Realm>) treeSet0);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      AllPermission allPermission0 = new AllPermission();
      // Undeclared exception!
      try {
        modularRealmAuthorizer0.checkPermission((PrincipalCollection) simplePrincipalCollection0, (Permission) allPermission0);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
        /*
         * Configuration error:  No realms have been configured!  One or more realms must be present to execute an authorization operation.
         */
      }
  }

  //Test case number: 1
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.setPermissionResolver(Lorg/jsecurity/authz/permission/PermissionResolver;)V: I8 Branch 3 IFNULL L98 - true
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.<init>()V: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      WildcardPermissionResolver wildcardPermissionResolver0 = new WildcardPermissionResolver();
      modularRealmAuthorizer0.setPermissionResolver((PermissionResolver) wildcardPermissionResolver0);
  }

  //Test case number: 3
  /*
   * 4 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.setPermissionResolver(Lorg/jsecurity/authz/permission/PermissionResolver;)V: I11 Branch 4 IFGT L98 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.setPermissionResolver(Lorg/jsecurity/authz/permission/PermissionResolver;)V: I20 Branch 5 IFEQ L99 - true
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.setPermissionResolver(Lorg/jsecurity/authz/permission/PermissionResolver;)V: I20 Branch 5 IFEQ L99 - false
   * 4 org.jsecurity.authz.ModularRealmAuthorizer.setPermissionResolver(Lorg/jsecurity/authz/permission/PermissionResolver;)V: I29 Branch 6 IFEQ L100 - false
   */
  @Test
  public void test3()  throws Throwable  {
      LinkedHashSet<Realm> linkedHashSet0 = new LinkedHashSet<Realm>();
      SimpleAccountRealm simpleAccountRealm0 = new SimpleAccountRealm("V73/;i");
      linkedHashSet0.add((Realm) simpleAccountRealm0);
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer((Collection<Realm>) linkedHashSet0);
      WildcardPermissionResolver wildcardPermissionResolver0 = new WildcardPermissionResolver();
      modularRealmAuthorizer0.setPermissionResolver((PermissionResolver) wildcardPermissionResolver0);
  }

  //Test case number: 6
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;Lorg/jsecurity/authz/Permission;)Z: I13 Branch 9 IFEQ L129 - false
   */
  @Test
  public void test6()  throws Throwable  {
      LinkedHashSet<Realm> linkedHashSet0 = new LinkedHashSet<Realm>();
      SimpleAccountRealm simpleAccountRealm0 = new SimpleAccountRealm("");
      linkedHashSet0.add((Realm) simpleAccountRealm0);
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer((Collection<Realm>) linkedHashSet0);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      WildcardPermission wildcardPermission0 = new WildcardPermission("jZTH{4`");
      // Undeclared exception!
      try {
        modularRealmAuthorizer0.checkPermission((PrincipalCollection) simplePrincipalCollection0, (Permission) wildcardPermission0);
        fail("Expecting exception: NoSuchElementException");
      } catch(NoSuchElementException e) {
      }
  }

  //Test case number: 7
  /*
   * 4 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;[Ljava/lang/String;)[Z: I3 Branch 11 IFNULL L143 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;[Ljava/lang/String;)[Z: I6 Branch 12 IFLE L143 - false
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;[Ljava/lang/String;)[Z: I21 Branch 13 IF_ICMPGE L145 - false
   * 4 org.jsecurity.authz.ModularRealmAuthorizer.assertRealmsConfigured()V: I8 Branch 1 IFNULL L82 - true
   */
  @Test
  public void test7()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      String[] stringArray0 = new String[2];
      // Undeclared exception!
      try {
        modularRealmAuthorizer0.isPermitted((PrincipalCollection) null, stringArray0);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
        /*
         * Configuration error:  No realms have been configured!  One or more realms must be present to execute an authorization operation.
         */
      }
  }

  //Test case number: 8
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/List;)[Z: I3 Branch 14 IFNULL L159 - true
   */
  @Test
  public void test8()  throws Throwable  {
      LinkedHashSet<Realm> linkedHashSet0 = new LinkedHashSet<Realm>();
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer((Collection<Realm>) linkedHashSet0);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      boolean[] booleanArray0 = modularRealmAuthorizer0.isPermitted((PrincipalCollection) simplePrincipalCollection0, (List<Permission>) null);
      assertNotNull(booleanArray0);
  }

  //Test case number: 9
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/List;)[Z: I3 Branch 14 IFNULL L159 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.isPermitted(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/List;)[Z: I6 Branch 15 IFGT L159 - true
   */
  @Test
  public void test9()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      LinkedList<Permission> linkedList0 = new LinkedList<Permission>();
      boolean[] booleanArray0 = modularRealmAuthorizer0.isPermitted((PrincipalCollection) null, (List<Permission>) linkedList0);
      assertNotNull(booleanArray0);
  }

  //Test case number: 10
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermittedAll(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I3 Branch 21 IFNULL L193 - true
   */
  @Test
  public void test10()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      WildcardPermission wildcardPermission0 = new WildcardPermission("{Nm?d~mF+4QSz[ZhFcH", false);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) wildcardPermission0, "{Nm?d~mF+4QSz[ZhFcH");
      boolean boolean0 = modularRealmAuthorizer0.isPermittedAll((PrincipalCollection) simplePrincipalCollection0, (Collection<Permission>) null);
      assertEquals(true, boolean0);
  }

  //Test case number: 11
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermittedAll(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I3 Branch 21 IFNULL L193 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.isPermittedAll(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I6 Branch 22 IFGT L193 - true
   */
  @Test
  public void test11()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      LinkedHashSet<Permission> linkedHashSet0 = new LinkedHashSet<Permission>();
      boolean boolean0 = modularRealmAuthorizer0.isPermittedAll((PrincipalCollection) simplePrincipalCollection0, (Collection<Permission>) linkedHashSet0);
      assertEquals(true, boolean0);
  }

  //Test case number: 12
  /*
   * 3 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.isPermittedAll(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I6 Branch 22 IFGT L193 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.isPermittedAll(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I15 Branch 23 IFEQ L194 - false
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.isPermittedAll(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I3 Branch 21 IFNULL L193 - false
   */
  @Test
  public void test12()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      LinkedHashSet<Permission> linkedHashSet0 = new LinkedHashSet<Permission>();
      WildcardPermissionResolver wildcardPermissionResolver0 = new WildcardPermissionResolver();
      WildcardPermission wildcardPermission0 = (WildcardPermission)wildcardPermissionResolver0.resolvePermission("C3L\"azEm}");
      linkedHashSet0.add((Permission) wildcardPermission0);
      // Undeclared exception!
      try {
        modularRealmAuthorizer0.isPermittedAll((PrincipalCollection) simplePrincipalCollection0, (Collection<Permission>) linkedHashSet0);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
        /*
         * Configuration error:  No realms have been configured!  One or more realms must be present to execute an authorization operation.
         */
      }
  }

  //Test case number: 13
  /*
   * 3 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.checkPermissions(Lorg/jsecurity/subject/PrincipalCollection;[Ljava/lang/String;)V: I3 Branch 27 IFNULL L228 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.checkPermissions(Lorg/jsecurity/subject/PrincipalCollection;[Ljava/lang/String;)V: I6 Branch 28 IFLE L228 - false
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.checkPermissions(Lorg/jsecurity/subject/PrincipalCollection;[Ljava/lang/String;)V: I21 Branch 29 IF_ICMPGE L229 - false
   */
  @Test
  public void test13()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      WildcardPermission wildcardPermission0 = new WildcardPermission("UTF-8");
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) wildcardPermission0, "UTF-8");
      String[] stringArray0 = new String[8];
      // Undeclared exception!
      try {
        modularRealmAuthorizer0.checkPermissions((PrincipalCollection) simplePrincipalCollection0, stringArray0);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
        /*
         * Configuration error:  No realms have been configured!  One or more realms must be present to execute an authorization operation.
         */
      }
  }

  //Test case number: 14
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.checkPermissions(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I3 Branch 30 IFNULL L241 - true
   */
  @Test
  public void test14()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      WildcardPermission wildcardPermission0 = new WildcardPermission("{Nm?d~mF+4QSz[ZhFcH", false);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) wildcardPermission0, "{Nm?d~mF+4QSz[ZhFcH");
      modularRealmAuthorizer0.checkPermissions((PrincipalCollection) simplePrincipalCollection0, (Collection<Permission>) null);
      assertEquals(false, simplePrincipalCollection0.isEmpty());
  }

  //Test case number: 15
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.checkPermissions(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I3 Branch 30 IFNULL L241 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.checkPermissions(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I12 Branch 31 IFEQ L242 - true
   */
  @Test
  public void test15()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      LinkedHashSet<Permission> linkedHashSet0 = new LinkedHashSet<Permission>();
      modularRealmAuthorizer0.checkPermissions((PrincipalCollection) simplePrincipalCollection0, (Collection<Permission>) linkedHashSet0);
      assertEquals(true, linkedHashSet0.isEmpty());
  }

  //Test case number: 16
  /*
   * 5 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.hasRole(Lorg/jsecurity/subject/PrincipalCollection;Ljava/lang/String;)Z: I24 Branch 33 IFEQ L256 - true
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.hasRole(Lorg/jsecurity/subject/PrincipalCollection;Ljava/lang/String;)Z: I13 Branch 32 IFEQ L255 - true
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.hasRole(Lorg/jsecurity/subject/PrincipalCollection;Ljava/lang/String;)Z: I13 Branch 32 IFEQ L255 - false
   * 4 org.jsecurity.authz.ModularRealmAuthorizer.assertRealmsConfigured()V: I8 Branch 1 IFNULL L82 - false
   * 5 org.jsecurity.authz.ModularRealmAuthorizer.assertRealmsConfigured()V: I11 Branch 2 IFLE L82 - true
   */
  @Test
  public void test16()  throws Throwable  {
      LinkedHashSet<Realm> linkedHashSet0 = new LinkedHashSet<Realm>();
      SimpleAccountRealm simpleAccountRealm0 = new SimpleAccountRealm("V73/;i");
      linkedHashSet0.add((Realm) simpleAccountRealm0);
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer((Collection<Realm>) linkedHashSet0);
      boolean boolean0 = modularRealmAuthorizer0.hasRole((PrincipalCollection) null, (String) null);
      assertEquals(false, boolean0);
  }

  //Test case number: 17
  /*
   * 3 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.hasRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/List;)[Z: I3 Branch 34 IFNULL L268 - true
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.setRealms(Ljava/util/Collection;)V: root-Branch
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.<init>(Ljava/util/Collection;)V: root-Branch
   */
  @Test
  public void test17()  throws Throwable  {
      TreeSet<Realm> treeSet0 = new TreeSet<Realm>();
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer((Collection<Realm>) treeSet0);
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      boolean[] booleanArray0 = modularRealmAuthorizer0.hasRoles((PrincipalCollection) simplePrincipalCollection0, (List<String>) null);
      assertNotNull(booleanArray0);
  }

  //Test case number: 18
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.hasRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/List;)[Z: I3 Branch 34 IFNULL L268 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.hasRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/List;)[Z: I6 Branch 35 IFGT L268 - true
   */
  @Test
  public void test18()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      LinkedList<String> linkedList0 = new LinkedList<String>();
      boolean[] booleanArray0 = modularRealmAuthorizer0.hasRoles((PrincipalCollection) null, (List<String>) linkedList0);
      assertNotNull(booleanArray0);
  }

  //Test case number: 19
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.hasAllRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)Z: I8 Branch 37 IFEQ L286 - true
   */
  @Test
  public void test19()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) "\uFFFD\uFFFD\uFFFD\u000F\u000F\u0000\u0000\u0000\u0000", "\uFFFD\uFFFD\uFFFD\u000F\u000F\u0000\u0000\u0000\u0000");
      TreeSet<String> treeSet0 = new TreeSet<String>();
      boolean boolean0 = modularRealmAuthorizer0.hasAllRoles((PrincipalCollection) simplePrincipalCollection0, (Collection<String>) treeSet0);
      assertEquals(true, boolean0);
  }

  //Test case number: 20
  /*
   * 1 covered goal:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.checkRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I3 Branch 40 IFNULL L308 - true
   */
  @Test
  public void test20()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection();
      modularRealmAuthorizer0.checkRoles((PrincipalCollection) simplePrincipalCollection0, (Collection<String>) null);
      assertEquals(true, simplePrincipalCollection0.isEmpty());
  }

  //Test case number: 21
  /*
   * 2 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.checkRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I3 Branch 40 IFNULL L308 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.checkRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I12 Branch 41 IFEQ L309 - true
   */
  @Test
  public void test21()  throws Throwable  {
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      HashSet<String> hashSet0 = new HashSet<String>();
      modularRealmAuthorizer0.checkRoles((PrincipalCollection) null, (Collection<String>) hashSet0);
      assertEquals(true, hashSet0.isEmpty());
  }

  //Test case number: 22
  /*
   * 5 covered goals:
   * 1 org.jsecurity.authz.ModularRealmAuthorizer.checkRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I12 Branch 41 IFEQ L309 - false
   * 2 org.jsecurity.authz.ModularRealmAuthorizer.getRealms()Ljava/util/Collection;: root-Branch
   * 3 org.jsecurity.authz.ModularRealmAuthorizer.<init>()V: root-Branch
   * 4 org.jsecurity.authz.ModularRealmAuthorizer.assertRealmsConfigured()V: I8 Branch 1 IFNULL L82 - true
   * 5 org.jsecurity.authz.ModularRealmAuthorizer.checkRoles(Lorg/jsecurity/subject/PrincipalCollection;Ljava/util/Collection;)V: I3 Branch 40 IFNULL L308 - false
   */
  @Test
  public void test22()  throws Throwable  {
      SimplePrincipalCollection simplePrincipalCollection0 = new SimplePrincipalCollection((Object) "UTF-8", "UTF-8");
      ModularRealmAuthorizer modularRealmAuthorizer0 = new ModularRealmAuthorizer();
      Set<String> set0 = simplePrincipalCollection0.getRealmNames();
      // Undeclared exception!
      try {
        modularRealmAuthorizer0.checkRoles((PrincipalCollection) simplePrincipalCollection0, (Collection<String>) set0);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
        /*
         * Configuration error:  No realms have been configured!  One or more realms must be present to execute an authorization operation.
         */
      }
  }
}
