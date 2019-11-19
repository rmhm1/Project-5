// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all
// times. I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Emily Swanson (emiswan)

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test the LinkedList class.
 * 
 * @author Emily Swanson (emiswan)
 * @version 2019.11.17
 */
public class LinkedListTest extends TestCase {
    // --------------------------------FIELDS-------------------------------
    private LinkedList<String> empty;
    private LinkedList<String> fourEntries;
    private Exception e;
    private String nullString;
    Iterator<String> iter;


    // -------------------------------METHODS-------------------------------
    // -----------------------------------------------------------
    /**
     * Set's up.
     */
    public void setUp() {
        empty = new LinkedList<String>();
        fourEntries = new LinkedList<String>();
        for (int i = 1; i < 5; i++) {
            fourEntries.add("test" + i);
        }
        e = null;
        nullString = null;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test the constructor correctly initiates size.
     */
    public void testConstructor() {
        assertEquals(0, empty.getLength());
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test getLength().
     */
    public void testGetLength() {
        assertEquals(0, empty.getLength());
        assertEquals(4, fourEntries.getLength());
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test isEmpty().
     */
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(fourEntries.isEmpty());
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test clear().
     */
    public void testClear() {
        // clear fourEntries:
        fourEntries.clear();
        // confirm it's empty:
        assertTrue(fourEntries.isEmpty());
        // add an entry to empty, then clear:
        empty.add("test");
        empty.clear();
        // confirm it's empty:
        assertTrue(empty.isEmpty());
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test contains().
     */
    public void testContains() {
        assertFalse(empty.contains("test1"));
        assertTrue(fourEntries.contains("test1"));
        assertFalse(fourEntries.contains("test5"));
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test equals().
     */
    public void testEquals() {
        // fourEntries should not be equal to empty, a null object,
        // or an object of different class:
        Object o = null;
        assertFalse(fourEntries.equals(o));
        assertFalse(fourEntries.equals(empty));
        assertFalse(fourEntries.equals(new Object()));
        // add three of the same entries to empty:
        for (int i = 1; i < 4; i++) {
            empty.add("test" + i);
        }
        // empty and four entries should not be equal:
        assertFalse(fourEntries.equals(empty));
        // add the last entry to empty:
        empty.add("test4");
        // empty and four entries should now be equal:
        assertEquals(empty, fourEntries);
        // add another last entry to empty:
        empty.add("test4");
        // empty and fourEntries should not be equal:
        assertFalse(fourEntries.equals(empty));
        // remove the last 2 entries from empty and add a different entry:
        empty.remove(5);
        empty.remove(4);
        empty.add("different");
        // empty and fourEntries should not be equal:
        assertFalse(fourEntries.equals(empty));
        // fourEntries should be equal to itself:
        assertEquals(fourEntries, fourEntries);
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test toArray().
     */
    public void testToArray() {
        // get an array from fourEntries:
        Object[] array = fourEntries.toArray();
        // ensure the size and entries are correct:
        assertEquals(4, array.length);
        for (int i = 1; i < 5; i++) {
            assertEquals("test" + i, array[i - 1]);
        }
        // get an array from empty:
        array = empty.toArray();
        // ensure size = 0
        assertEquals(0, array.length);
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test getEntry().
     */
    public void testgetEntry() {
        // try an index larger than length, ensure an
        // IndexOutOfBounds exception is thrown
        try {
            fourEntries.getEntry(8);
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            empty.getEntry(1);
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);

        // try an index smaller than length, ensure an
        // IndexOutOfBounds exception is thrown
        e = null;
        try {
            fourEntries.getEntry(0);
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        // ensure the correct entries are returned for each
        // index in fourEntries:
        for (int i = 1; i < 5; i++) {
            assertEquals("test" + i, fourEntries.getEntry(i));
        }
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test replace()
     */
    public void testReplace() {
        // attempt to replace out of bounds entries; ensure
        // IndexOutOfBoundsException is thrown:
        try {
            fourEntries.replace(6, "replacement");
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        try {
            fourEntries.replace(-1, "replacement");
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        // replace all entries:
        for (int i = 1; i < 5; i++) {
            assertEquals("test" + i, fourEntries.replace(i, String.valueOf(i)));
        }

        // ensure they were replaced correctly:
        assertEquals(4, fourEntries.getLength());
        for (int i = 1; i < 5; i++) {
            assertEquals(String.valueOf(i), fourEntries.getEntry(i));
        }
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test add() with one parameter.
     */
    public void testAdd1() {
        // add an entry:
        fourEntries.add("test5");
        // ensure length eas incremented:
        assertEquals(5, fourEntries.getLength());
        // ensure the enries are in the correct order:
        for (int i = 1; i < 6; i++) {
            assertEquals("test" + i, fourEntries.getEntry(i));
        }
        // test add on empty:
        empty.add("test");
        assertEquals(1, empty.getLength());
        assertEquals("test", empty.getEntry(1));
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test add() with two parameters.
     */
    public void testAdd2() {
        // add at index 3:
        fourEntries.add(3, "random");
        // ensure length was incremented, and "random" is at index 3:
        assertEquals(5, fourEntries.getLength());
        assertEquals("random", fourEntries.getEntry(3));
        // add at the end:
        fourEntries.add(6, "last");
        assertEquals(6, fourEntries.getLength());
        assertEquals("last", fourEntries.getEntry(6));
        // add out of bounds:
        try {
            fourEntries.add(8, "outOfBounds");
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            fourEntries.add(0, "outOfBounds");
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        // attempt to add a null string:
        fourEntries.add(nullString);
        assertEquals(6, fourEntries.getLength());
        assertEquals("last", fourEntries.getEntry(6));
        // add at index 1:
        empty.add(1, "test");
        assertEquals(1, empty.getLength());
        assertEquals("test", empty.getEntry(1));
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test remove() with one parameter.
     */
    public void testRemove() {
        // attempt remove out of bounds:
        try {
            fourEntries.remove(5);
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            fourEntries.remove(0);
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        // ensure items are removed correctly:
        for (int i = 4; i > 0; i--) {
            assertEquals("test" + i, fourEntries.remove(i));
        }
        e = null;
        // attempt remove on empty:
        try {
            empty.remove(1);
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test the iterator on an the list with four entries.
     */
    public void testIterator1() {
        iter = fourEntries.iterator();
        // test hasNext and next with the first three entries:
        for (int i = 1; i < 4; i++) {
            assertTrue(iter.hasNext());
            assertEquals("test" + i, iter.next());
        }
        // remove the third entry:
        iter.remove();
        // make sure the element was removed:
        assertEquals(3, fourEntries.getLength());
        assertFalse(fourEntries.contains("test3"));
        // ensure hasNext is still true
        assertTrue(iter.hasNext());
        // attempt to remove without calling next, ensure
        // an IllegalStateException is thrown
        try {
            iter.remove();
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);
        // Final next call:
        assertEquals("test4", iter.next());
        // Ensure hasNext is false:
        assertFalse(iter.hasNext());
        // Attempt to call next, this should throw a
        // NoSuchElementException:
        try {
            iter.next();
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof NoSuchElementException);
        // Add an entry to the end:
        fourEntries.add("addition1");
        // Ensure hasNext is now true:
        assertTrue(iter.hasNext());
        // Ensure next returns the added entry:
        assertEquals("addition1", iter.next());
        // Add an element in the middle of the list:
        fourEntries.add(3, "addition2");
        // Ensure hasNext returns false:
        assertFalse(iter.hasNext());
        // Add an element onto the end:
        fourEntries.add("addition3");
        // Ensure hasNext is true:
        assertTrue(iter.hasNext());
        // Remove the end element:
        fourEntries.remove(6);
        // Ensure hasNext is now false
        assertFalse(iter.hasNext());
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Test the iterator on the empty list.
     */
    public void testIterator2() {
        iter = empty.iterator();
        // ensure hasNext is false
        assertFalse(iter.hasNext());
        // Attempt to call next, this should throw a
        // NoSuchElementException:
        try {
            iter.next();
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof NoSuchElementException);
        // attempt to remove without calling next, ensure
        // an IllegalStateException is thrown
        try {
            iter.remove();
        }
        catch (Exception caught) {
            e = caught;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);
        // add an element to the list:
        empty.add("addition3");
        // ensure hasNext is true
        assertTrue(iter.hasNext());
        // add two more elements to the list:
        empty.add(1, "addition1");
        empty.add(2, "addition2");
        // Ensure hasNext returns true and elements are returned in
        // correct order:
        for (int i = 1; i < 4; i++) {
            assertTrue(iter.hasNext());
            assertEquals("addition" + i, iter.next());
        }
    }
    // =======================end of method=======================

}
