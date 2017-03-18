/*
 * Copyright 2006-2011 Sam Adams <sea36 at users.sourceforge.net>
 *
 * This file is part of JNI-InChI.
 *
 * JNI-InChI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JNI-InChI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JNI-InChI.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jniinchi;

import org.junit.Assert;
import org.junit.Test;

public class TestJniInchiOutput {

    /*
     * Test method for 'net.sf.jniinchi.JniInchiOutput.getAuxInfo()'
     */
    @Test
    public void testGetAuxInfo() {
        JniInchiOutput output = new JniInchiOutput(null, null, "AuxInfo=1/0/N:1,2,6,3,5,4/E:(1,2,3,4,5,6)/rA:6nCCCCCC/rB:d1;s2;d3;s4;s1d5;/rC:-.7145,.4125,0;-.7145,-.4125,0;0,-.825,0;.7145,-.4125,0;.7145,.4125,0;0,.825,0;", null, null);
        Assert.assertEquals("AuxInfo=1/0/N:1,2,6,3,5,4/E:(1,2,3,4,5,6)/rA:6nCCCCCC/rB:d1;s2;d3;s4;s1d5;/rC:-.7145,.4125,0;-.7145,-.4125,0;0,-.825,0;.7145,-.4125,0;.7145,.4125,0;0,.825,0;", output.getAuxInfo());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiOutput.getLog()'
     */
    @Test
    public void testGetLog() {
        JniInchiOutput output = new JniInchiOutput(null, null, null, null, "Test log");
        Assert.assertEquals("Test log", output.getLog());
    }
}
