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

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestJniInchiAtom {

    protected static JniInchiAtom getNewTestAtom() {
        return new JniInchiAtom(1, 2, 3, "C");
    }


    /**
     * Test JniInchiAtom constructor.
     *
     */
    @Test
    public void testJniInchiAtomConstructor() {
        JniInchiAtom atom = getNewTestAtom();
        // Check configured parameters
        assertEquals(1.0, atom.getX(), 1E-6);
        assertEquals(2.0, atom.getY(), 1E-6);
        assertEquals(3.0, atom.getZ(), 1E-6);
        assertEquals("C", atom.getElementType());

        // Check default values set correctly
        assertEquals(0, atom.getCharge());
        assertEquals(-1, atom.getImplicitH());
        assertEquals(0, atom.getImplicitProtium());
        assertEquals(0, atom.getImplicitDeuterium());
        assertEquals(0, atom.getImplicitTritium());
        assertEquals(0, atom.getIsotopicMass());
        assertEquals(INCHI_RADICAL.NONE, atom.getRadical());
    }

    /**
     * Test setIsotopicMass.
     *
     */
    @Test
    public void testSetIsotopicMass() {
        JniInchiAtom atom = getNewTestAtom();
        atom.setIsotopicMass(13);
        assertEquals(13, atom.getIsotopicMass());
    }

    /**
     * Test setImplicitDeuterium.
     *
     */
    @Test
    public void testSetImplictDeuterium() {
        JniInchiAtom atom = getNewTestAtom();
        atom.setImplicitDeuterium(2);
        assertEquals(2, atom.getImplicitDeuterium());
    }

    /**
     * Test getRadical.
     *
     */
    @Test
    public void testGetRadical() {
        JniInchiAtom atom = getNewTestAtom();
        atom.setRadical(INCHI_RADICAL.TRIPLET);
        assertEquals(INCHI_RADICAL.TRIPLET, atom.getRadical());
    }

    @Test
    public void testNullElementSymbol() {
        try {
            new JniInchiAtom(0, 0, 0, null);
            fail("Null element symbol");
        } catch (NullPointerException e) {
            // pass
        }
    }

}
