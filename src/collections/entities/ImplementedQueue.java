package collections.entities;

import collections.engines.LinkEngine;

import java.util.NoSuchElementException;

/**
 * Custom implementation of Queue interface using same memory-containerizing pattern that LinkedList
 * Representing ordered list of object by operating rate
 * First In First Out - pattern of container functional: objects, added earlier have higher operation priority
 * */
public final class ImplementedQueue<E> extends LinkEngine<E> {

    /**
     * Capacity of queue
     * */
    private int capacity;

    /**
     * Service pointer to handle queue overflow
     * */
    private boolean isCustomCapacity = false;

    public ImplementedQueue(){

    }

    /**
     * Constructor to set queue capacity
     * */
    public ImplementedQueue(int capacity){
        this.capacity = capacity;
        isCustomCapacity = true;
    }

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
     * @throws IllegalArgumentException if queue is full
     */
    public E add(E token) {
        catchOverflow();
        return super.addLast(token);
    }

    /**
     * Method works similar as {@code add(E token)}, but doesn't throw any Exception if queue is full, adds element
     * otherwise
     * @param token Object to offer to add
     * @return false if adding was failed and queue is full
     * */
    public boolean offer(E token){
        if (numOfElements == capacity){
            return false;
        } else {
            add(token);
            return true;
        }
    }

    /**
     * Method to reset container to default empty value with setting all object-wrappers to null during
     * walk through every next element
     */
    @Override
    public void clear() {
        super.clear();
    }

    /**
     * Search method iterating through every next element and catches equal object
     *
     * @param object object to find index of
     * @return index of handled element, -1 otherwise
     */
    @Override
    public int indexOf(E object) {
        return super.indexOf(object);
    }

    /**
     * Search method to check if list contains an object using {@code indexOf(E object)}
     *
     * @param i@return true if list contains object
     */
    @Override
    public boolean contains(E i) {
        return super.contains(i);
    }

    /**
     * Method to check if list does not contain any objects
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Simple getter for inner counter of adding and deleting methods
     *
     * @return number of elements in queue
     */
    @Override
    public int size() {
        return super.size();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Service method to handle queue overflow and throw exception if it is
     * @throws IllegalArgumentException if {@code add(E token)} method was called from full Queue
     * */
    private void catchOverflow(){
        if (numOfElements == capacity && isCustomCapacity){
            throw new IllegalArgumentException("Queue is full!");
        }
    }
}