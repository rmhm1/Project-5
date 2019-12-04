// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all
// times. I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Emily Swanson (emiswan)

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly Linked List with an iterator.
 * Entries are added to the back using add(entry), or at a
 * specified index using add(index, entry) (index is not 0 based).
 * Entries are removed from specified index using remove(index).
 * getLength() returns the number of entries.
 * 
 * @author Emily Swanson (emiswan)
 *
 * @param <T>
 *            The type of data this linked list will hold.
 */
public class LinkedList<T> {
    // --------------------------------NODE CLASS-------------------------------
    /**
     * Internal node class for linked list.
     * 
     * @author Emily Swanson (emiswan)
     * @version 2019.11.17
     */
    private class Node {
        // --------------------------------FIELDS-------------------------------
        private T data;
        private Node next;


        // -------------------------------METHODS-------------------------------
        // -----------------------------------------------------------
        /**
         * Create a new Node with null data and next.
         */
        public Node(T data, Node next) {
            this.next = next;
            this.data = data;
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Create a new Node with specified data and null next.
         */
        public Node(T data) {
            this.data = data;
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Set the data for this node.
         */
        private void setData(T newData) {
            data = newData;
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Set this node's next.
         */
        private void setNext(Node newNext) {
            next = newNext;
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Get this node's next.
         */
        private Node getNext() {
            return next;
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Get this node's data.
         */
        private T getData() {
            return data;
        }
        // =======================end of method=======================

    }// =======================end of class=======================

    // -----------------------------FIELDS----------------------------
    private Node head;
    private int length;


    // -----------------------------METHODS----------------------------
    // -----------------------------------------------------------
    /**
     * Create a new LinkedList with no entries.
     */
    public LinkedList() {
        this.clear();
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the size of the list.
     * @ return
     * The number of entries as an int.
     */
    public int getLength() {
        return length;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Swap the location of two entries.
     * 
     * @param firstIndex
     *            Index of first entry.
     * @param secondIndex
     *            Index of second entry.
     */
    public void swap(int firstIndex, int secondIndex) {
        T secondData = replace(secondIndex, getNodeByIndex(firstIndex)
            .getData());
        replace(firstIndex, secondData);
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Determine if the list empty.
     * 
     * @return
     *         True if the list contains no entries.
     */
    public boolean isEmpty() {
        return length == 0;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the list as an array
     * 
     * @return
     *         The array
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[])new Object[length];

        int index = 0;
        Node current = head;
        while (index < length && current != null) {
            array[index] = current.getData();
            current = current.getNext();
            index++;
        } // end while
        return array;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Determine if the list contains an entry.
     * 
     * @return
     *         True if the list contains the entry.
     * @param anEntry
     *            Entry to be found.
     */
    public boolean contains(T anEntry) {
        if (!isEmpty()) {
            Node current = head;
            if (current.getData().equals(anEntry)) {
                return true;
            } // end if
            while (current.next != null) {
                current = current.next;
                if (current.getData().equals(anEntry)) {
                    return true;
                } // end if
            } // end while
        } // end if
        return false;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Determine if the list contains the given element,
     * and return the index, if so.
     * 
     * @param index
     *            The index.
     * 
     * @return
     *         The entry.
     * 
     * @precondition
     *               The index is in bounds (between 1 and size,
     *               inclusive), the list is not empty.
     */
    public T getEntry(int index) {
        Node result = getNodeByIndex(index);
        return result.getData();
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Replace the element at given index with the
     * specified entry.
     * 
     * @param index
     *            The index.
     * 
     * @param enEntry
     *            The entry to replace the old entry.
     * 
     * @return
     *         the old entry.
     * 
     * @precondition
     *               The index is in bounds (between 1 and size,
     *               inclusive), the list is not empty.
     */
    public T replace(int index, T anEntry) {
        Node toReplace = getNodeByIndex(index);
        T oldEntry = toReplace.getData();
        toReplace.setData(anEntry);
        return oldEntry;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Add an entry to the end of the list.
     * 
     * @param anEntry
     *            Entry to be added.
     * @precondition
     *               The entry is not null.
     */
    public void add(T anEntry) {
        if (anEntry != null) {
            Node newNode = new Node(anEntry);
            if (isEmpty()) {
                head = newNode;
            }
            else {
                Node lastNode = getNodeByIndex(length);
                lastNode.setNext(newNode);
            }
            length++;
        }
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Add an entry at the specified index.
     * 
     * @param anEntry
     *            Entry to be added.
     * @param index
     *            Index for new Entry.
     * @precondition
     *               The entry is not null, the specified index is
     *               in bounds (between 1 and size).
     */
    public void add(int index, T anEntry) {
        if (index > length + 1 || index < 1) {
            throw new IndexOutOfBoundsException();
        }
        if (anEntry != null) {
            Node newNode = new Node(anEntry);
            if (index == 1) {
                newNode.setNext(head);
                head = newNode;
            } // end if
            else {
                Node previous = getNodeByIndex(index - 1);
                Node after = previous.getNext();
                newNode.setNext(after);
                previous.setNext(newNode);
            }
            length++;
        }
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Get the entry at the specified index.
     * 
     * @precondition
     *               The list is not empty and the index
     *               is in bounds.
     *               IllegalStateException will be thrown.
     * @return
     *         The entry.
     * @param index
     *            Index to be used.
     */
    private Node getNodeByIndex(int index) {
        if (index > length || index < 1) {
            throw new IndexOutOfBoundsException("No entry exists at " + index);
        } // end if
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Remove the entry at the specified index.
     * 
     * @precondition
     *               The list is not empty and the index is in
     *               bounds, or an IndexOutOfBoundsException
     *               will be thrown.
     * @param index
     *            Index of the entry.
     * @return
     *         The entry at the index.
     * 
     */
    public T remove(int index) {
        T data = null;
        if (index == 1 && !isEmpty()) {
            data = head.getData();
            head = head.getNext();

        }
        else {
            Node result = getNodeByIndex(index);
            data = result.getData();
            Node previous = getNodeByIndex(index - 1);
            Node after = result.getNext();
            previous.setNext(after);
        }
        length--;
        return data;
    }

    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Clears the list.
     */
    public void clear() {
        head = new Node(null);
        length = 0;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Iterator method creates Iterator object
     *
     * @param other
     *            Object to be compared
     * @return
     *         True, if the objects are equal.
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != getClass()) {
            return false;
        }
        LinkedList<T> otherList = (LinkedList<T>)other;
        if (otherList.getLength() != getLength()) {
            return false;
        }
        Object[] otherArray = otherList.toArray();
        Object[] thisArray = toArray();
        for (int i = 0; i < length; i++) {
            if (!thisArray[i].equals(otherArray[i])) {
                return false;
            }
        }
        return true;
    }
    // =======================end of method=======================


    // -----------------------------------------------------------
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }
    // =======================end of method=======================


    // ------------------------------ITERATOR CLASS------------------------

    private class LinkedListIterator<A> implements Iterator<T> {
        // -----------------------------FIELDS-----------------------------
        private Node current;
        private boolean nextCalled;
        private int position;


        // -----------------------------METHODS----------------------------
        // -----------------------------------------------------------
        /**
         * Creates a new DLListIterator
         */
        public LinkedListIterator() {
            nextCalled = false;
            position = 0;
            current = new Node(null, head);
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            if (isEmpty())
            {
                return false;
            }
            if (position == length)
            {
                return false;
            }
            return true;
        }
                
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (hasNext()) {
            if (position == 0) {
                current = head;
            }
            else {
                current = current.getNext();
            }
            position++;
            nextCalled = true;
            return current.getData();
            }
            else
            {
                throw new NoSuchElementException();
            }
        }
        // =======================end of method=======================


        // -----------------------------------------------------------
        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        public void remove() {
            if (nextCalled) {
                LinkedList.this.remove(position);
                nextCalled = false;
            }
            else {
                throw new IllegalStateException("Next has not been called.");
            }
        }
        // =======================end of method=======================
    }
    // =======================end of class=======================

}
