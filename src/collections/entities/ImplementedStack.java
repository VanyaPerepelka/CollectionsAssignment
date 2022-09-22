package collections.entities;

import collections.engines.ArrayEngine;

/**
 * Own implementation of Stack using inner array to store objects
 * implements and follows the Last In, First Out (LIFO) principle.
 * It implies that the element that is inserted last comes out first.
 * */
public final class ImplementedStack<E> extends ArrayEngine<E> {

    /**
     * Default constructor with setting starting list capacity as 10
     * */
    public ImplementedStack() {
        elements = new Object[capacity];
    }

    /**
     * Constructor to create list with custom capacity
     * */
    public ImplementedStack(int capacity){
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    //___________DATA_HANDLING________________//
    /**
     * Method to add object in the top of stack
     * @param element object to add
     * */
    public void push(E element){
        checkLength();
        elements[numOfElements] = element;
        updateSize();
    }

    /**
     * Method to add object to list with special index using arrayCopy to move the affected indexes over 1
     * @param element object to add
     * @param index special index of object
     * @see System
     * */
    public void add(E element, int index){
        checkIndexToGrow(index);
        if (index > elements.length - 1) {
            System.arraycopy(elements, index, elements, index + 1, elements.length - index);
            //[a,c,d]("b", 1)->  [a,][ ][c,d]  ->  [a, ,c,d]  ->  [a,b,c,d]
        }
        elements[index] = element;
        updateSize(index);
    }

    /**
     * Method to remove object on the top of stack
     * */
    public Object pop(){
        throwIfNothingToGet();
        var result = elements[numOfElements - 1];
        elements[numOfElements - 1] = null;
        numOfElements--;
        return result;
    }

    /**
     * Simple getter for object at the top of stack
     * @return object on the top of stack
     * */
    public Object peek(){
        throwIfNothingToGet();
        return elements[numOfElements - 1];
    }
    /**
     * Method to set inner array to new empty value
     */
    @Override
    public void clear() {
        super.clear();
    }

    /**
     * Method to find if object are stored in inner array using {@code IndexOf()} - another method of this object
     *
     * @param object object to find in array
     * @return true if object is presented
     */
    @Override
    public boolean contains(E object) {
        return super.contains(object);
    }

    /**
     * Method to check index of presented object using for-loop to walk-trough an inner array
     *
     * @param object object to check index of
     * @return index of object if resented, -1 otherwise
     */
    @Override
    public int indexOf(E object) {
        return super.indexOf(object);
    }

    /**
     * Method to return String representation of inner data using JDK default methods
     * {@code Arrays.toString(obj[] array)} and {@code Arrays.copyOf(obj[] source)}
     *
     * @return string representation of inner array
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Method to check if inner array has a data inside using 0 and service counter equality
     *
     * @return true if array is empty
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Method to check number of elements stored in inner array
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return super.size();
    }

}
