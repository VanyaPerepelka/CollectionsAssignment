package collections.entities;

import collections.engines.LinkEngine;

import java.util.NoSuchElementException;

public final class ImplementedQueue<E> extends LinkEngine<E> {

    /**
     * Simple getter for first element
     *
     * @return first element
     * @throws NoSuchElementException if list is empty
     */
    public E peek() {
        return super.getFirst();
    }

    /**
     * Method to delete first element of list with unlinking it from second element and declaring
     * second element as first.
     * As result none of elements in list contains link to element to delete and GC clearing it out of stack
     *
     * @return Deleted element
     * @throws NoSuchElementException if list is empty
     */
    public E poll() {
        return super.deleteFirst();
    }

    /**
     * Method to add object to tail of list
     * Example: {@code [0,1,2,3] (4)-> [0,1,2,3,4]}
     *
     * @param token object to add
     * @return added object
     */
    public E add(E token) {
        return super.addLast(token);
    }

    /**
     * Method to reset container to default empty value with setting all object-wrappers to null during
     * walk through every next element
     */
    @Override
    protected void clear() {
        super.clear();
    }

    /**
     * Search method iterating through every next element and catches equal object
     *
     * @param object object to find index of
     * @return index of handled element, -1 otherwise
     */
    @Override
    protected int indexOf(E object) {
        return super.indexOf(object);
    }

    /**
     * Search method to check if list contains an object using {@code indexOf(E object)}
     *
     * @param i@return true if list contains object
     */
    @Override
    protected boolean contains(E i) {
        return super.contains(i);
    }

    /**
     * Method to check if list does not contain any objects
     *
     * @return true if list is empty
     */
    @Override
    protected boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Simple getter for inner counter of adding and deleting methods
     *
     * @return number of elements in list
     */
    @Override
    protected int size() {
        return super.size();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}