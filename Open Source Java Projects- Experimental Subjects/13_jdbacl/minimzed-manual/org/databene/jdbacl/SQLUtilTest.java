/*
 * (c) Copyright 2010-2011 by Volker Bergmann. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, is permitted under the terms of the
 * GNU General Public License (GPL).
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * WITHOUT A WARRANTY OF ANY KIND. ALL EXPRESS OR IMPLIED CONDITIONS,
 * REPRESENTATIONS AND WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE
 * HEREBY EXCLUDED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.databene.jdbacl;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.databene.commons.ArrayFormat;
import org.junit.Test;

/**
 * Tests the {@link SQLUtil} class.<br/><br/>
 * Created: 28.11.2010 10:27:54
 * @since 0.6.4
 * @author Volker Bergmann
 */
public class SQLUtilTest {

	private static final String CALL = "call myprocedure";

	private static final String INSERT = "insert into users (id, name) values (1, 'Alice')";
	private static final String UPDATE = "UPDATE users set name='xxx' where name = 'Alice'";
	private static final String DELETE = "DELETE users where name = 'Alice'";
	private static final String TRUNCATE = "TRUNCATE users";
	
	private static final String ALTER_SESSION = "ALTER SESSION BLABLA";
	
	private static final String QUERY = "select * from users";
	
	private static final String ALTER_TABLE = "ALTER TABLE users";
	private static final String DROP_TABLE = "drop table users";
	private static final String CREATE_TABLE = "Create Table USERS";

	@Test
	public void testParseColumnTypeAndSize() {
		checkParsing("int", "int" );
		checkParsing("number(11)", "number", 11);
		checkParsing("number(8, 2)", "number", 8, 2);
	}
	
	@Test
	public void testMutatesDataOrStructure() {
		assertTrue(SQLUtil.mutatesDataOrStructure(CREATE_TABLE));
		assertTrue(SQLUtil.mutatesDataOrStructure(DROP_TABLE));
		assertTrue(SQLUtil.mutatesDataOrStructure(ALTER_TABLE));
		assertFalse(SQLUtil.mutatesDataOrStructure(QUERY));
		assertFalse(SQLUtil.mutatesDataOrStructure(ALTER_SESSION));
		assertTrue(SQLUtil.mutatesDataOrStructure(INSERT));
		assertTrue(SQLUtil.mutatesDataOrStructure(UPDATE));
		assertTrue(SQLUtil.mutatesDataOrStructure(DELETE));
		assertTrue(SQLUtil.mutatesDataOrStructure(TRUNCATE));
		assertNull(SQLUtil.mutatesDataOrStructure(CALL));
	}
	
	@Test
	public void testRemoveComments() {
		assertEquals("select a from b", SQLUtil.removeComments("select a from b"));
		assertEquals("select a from b", SQLUtil.removeComments("select a/*, x, y */ from b"));
		assertEquals("select a from b", SQLUtil.removeComments("select a /*, x, y */from b/* join c on ref=id*/"));
	}

	@Test
	public void testNormalize() {
		assertEquals("select x from t", SQLUtil.normalize("select x from t", false));
		assertEquals("select min (x) from t", SQLUtil.normalize("select min(x) from t", false));
		assertEquals("select min (x) - 2 from t", SQLUtil.normalize("select min(x)-2 from t", false));
		assertEquals("select 3.141 * 2 - 6.0 from t", SQLUtil.normalize("select 3.141*2-6.0 from t", false));
		assertEquals("select t_id from s.t", SQLUtil.normalize("select t_id from s.t", false));
		assertEquals("select 'id', id from \"x\".\"t\"", SQLUtil.normalize("select 'id',id from \"x\".\"t\"", false));
		assertEquals("select a /* x, y */ from b", SQLUtil.normalize("select a /*x,y*/ from b", false));
		assertEquals("select a from b", SQLUtil.normalize("select a /*x,y*/ from b", true));
		assertEquals("select a from b -- ignore this", SQLUtil.normalize("select a from b--ignore this", false));
		assertEquals("select a from b", SQLUtil.normalize("select a from b--ignore this", true));
	}
	
	@Test
	public void testRenderColumnListWithTableName() {
		assertEquals("t.x, t.y", SQLUtil.renderColumnListWithTableName("t", "x", "y"));
	}
	
	// helpers ---------------------------------------------------------------------------------------------------------

	public void checkParsing(String spec, Object... expected) {
		Object[] actual = SQLUtil.parseColumnTypeAndSize(spec);
		String message = "Expected: [" + ArrayFormat.format(expected) + "], " +
				"found: [" + ArrayFormat.format(actual) + "]";
		assertTrue(message, Arrays.deepEquals(expected, actual));
	}
	
}