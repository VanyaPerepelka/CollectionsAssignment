package collections.entities;

import collections.engines.ArrayEngine;

/**
 * Custom implementation of ArrayList
 * Object representing dynamic array, that resizes automatically if needed
 * @see collections.engines.ArrayEngine
 * @see java.util.ArrayList
 *
 * @author Vinya
 * */
public final class ImplementedArrayList<E> extends ArrayEngine<E> {

    /**
     * Default constructor with setting starting list capacity as 10
     * */
    public ImplementedArrayList() {
        elements = new Object[capacity];
    }

    /**
     * Constructor to create list with custom capacity
     * */
    public ImplementedArrayList(int capacity){
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    /**
     * Method to add object in tail of list
     * @param element object to add
     * */
    public void add(E element){
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
     * Simple getter to get object by index
     * @param index index of element to get
     * @return element by index in list
     * */
    public Object get(int index){
        checkIndex(index);
        return elements[index];
    }

    /**
     * Method to set object by index with new value
     *
     * @param newValue new value to set list element with
     * @param index index of object in list
     * */
    public void set(E newValue, int index){
        checkIndex(index);
        elements[index] = newValue;
    }

    /**
     * Method to remove object out of list by index
     * @param index index of object to remove
     * */
    public void remove(int index){
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, numOfElements - index);
        numOfElements--;
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
