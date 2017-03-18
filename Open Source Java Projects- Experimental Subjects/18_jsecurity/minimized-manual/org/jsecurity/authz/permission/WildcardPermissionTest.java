/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jsecurity.authz.permission;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Jeremy Haile
 * @since 0.9
 */
public class WildcardPermissionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        new WildcardPermission(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOnlyDelimiters() {
        new WildcardPermission("::,,::,:");
    }

    @Test
    public void testLists() {
        WildcardPermission p1, p2, p3;

        p1 = new WildcardPermission("one,two");
        p2 = new WildcardPermission("one");
        assertTrue(p1.implies(p2));
        assertFalse(p2.implies(p1));

        p1 = new WildcardPermission("one,two,three");
        p2 = new WildcardPermission("one,three");
        assertTrue(p1.implies(p2));
        assertFalse(p2.implies(p1));

        p1 = new WildcardPermission("one,two:one,two,three");
        p2 = new WildcardPermission("one:three");
        p3 = new WildcardPermission("one:two,three");
        assertTrue(p1.implies(p2));
        assertFalse(p2.implies(p1));
        assertTrue(p1.implies(p3));
        assertFalse(p2.implies(p3));
        assertTrue(p3.implies(p2));

        p1 = new WildcardPermission("one,two,three:one,two,three:one,two");
        p2 = new WildcardPermission("one:three:two");
        assertTrue(p1.implies(p2));
        assertFalse(p2.implies(p1));

        p1 = new WildcardPermission("one");
        p2 = new WildcardPermission("one:two,three,four");
        p3 = new WildcardPermission("one:two,three,four:five:six:seven");
        assertTrue(p1.implies(p2));
        assertTrue(p1.implies(p3));
        assertFalse(p2.implies(p1));
        assertFalse(p3.implies(p1));
        assertTrue(p2.implies(p3));

    }


}
