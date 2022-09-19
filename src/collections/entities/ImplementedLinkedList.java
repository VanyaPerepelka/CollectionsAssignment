package collections.entities;


import collections.engines.LinkEngine;

import java.rmi.UnexpectedException;
import java.util.NoSuchElementException;

public final class ImplementedLinkedList<E> extends LinkEngine<E> {

    /**
     * Default constructor
     * */
    public ImplementedLinkedList(){

    }

    /**
     * Simple getter for first element
     *
     * @return first element
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E getFirst() {
        return super.getFirst();
    }

    /**
     * Simple getter for last element
     *
     * @return last element
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E getLast() {
        return super.getLast();
    }

    /**
     * Method to delete first element of list with unlinking it from second element and declaring
     * second element as first.
     * As result none of elements in list contains link to element to delete and GC clearing it out of stack
     *
     * @return Deleted element
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E deleteFirst() {
        return super.deleteFirst();
    }

    /**
     * Method to delete last element of list with unlinking it from previous element and declaring
     * previous element as last.
     * As result none of elements in list contains link to element to delete and GC clearing it out of stack
     *
     * @return Deleted element
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E deleteLast() {
        return super.deleteLast();
    }

    /**
     * Method to add element to head of list
     * Example: {@code [2,3,4,5] (1)-> [1,2,3,4,5]}
     *
     * @param token object to add
     * @return object if token added
     */
    @Override
    public E addFirst(E token) {
        return super.addFirst(token);
    }

    /**
     * Method to add object to tail of list
     * Example: {@code [0,1,2,3] (4)-> [0,1,2,3,4]}
     *
     * @param token object to add
     * @return added object
     */
    @Override
    public E addLast(E token) {
        return super.addLast(token);
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
     * @return number of elements in list
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * Method to get object by special index using iteration through next-link of every object in list
     * @return index of special object
     * */
    public E get(int index){
        var result = checkIndexToHandleInnerData(index);
        if (result == null) {
            int iteration = 0; //counter of iteration

            for (var i = first; i != null; i = i.next) {
                if (iteration == index) {
                    return i.innerData;
                }
                iteration++;
            }
        }
        return result;
    }

    /**
     * Method to set object by index to new value using iteration through next-link of every object in list
     * @param index index of element to set with new value
     * @param element new value
     *
     * */
    public boolean set(E element, int index){
        int iteration = 0;
        checkIndexToHandleInnerData(index);

        for (var i = first; i != null; i = i.next) {
            if (iteration == index){
                i.innerData = element;
                return true;
            }
            iteration++;
        }
        return false;
    }

    /***
     * Method to delete object by special index
     * @param index index of element to delete
     * @return deleted object
     * @throws NoSuchElementException if element with proposed index does not exist
     */
    public E delete(int index){
        Token<E> toDelete = null;
        checkIndexToHandleInnerData(index);
        int i = 0;
        for (var token = first; token != null; token = token.next) {
            if (i == index) {
                toDelete = token;
                clear(token);
            }
            i++;
        }
        if (toDelete == null) {
            throw new NoSuchElementException("element with index [" + index + "] does not exist");
        } else {
            numOfElements--;
            return toDelete.innerData;
        }
    }

    /**
     * Method to delete object out of list
     * @param toDelete object to dleete
     * @return deleted object
     * @throws NoSuchElementException if list does not contain proposed element
     * */
    public E delete(Object toDelete){
        Token<E> res = null;
        if (toDelete == null){
            for (var i = first; i != null; i = i.next){
                if (i.innerData == null){
                    res = i;
                    clear(i);
                }
            }
        } else {
            for(var i = first; i != null; i = i.next){
                if (i.innerData.equals(toDelete)){
                    res = i;
                    clear(i);
                }
            }
        }
        if (res != null){
            numOfElements--;
            return res.innerData;

        } else throw new NoSuchElementException("Can't find element [" + toDelete + "] to delete it");

    }

    /**
     * Method to add object in list by special index
     * @param object object to add
     * @param index index of object
     * */
    public void add(E object, int index) {
       var objWithTargetIndex = first;
       checkIndex(index);
        int i = 0;
        while (i != index) {
            if (i >= numOfElements) {
                addLast(null);
            }
            objWithTargetIndex = objWithTargetIndex.next;
            i++;
        }
        objWithTargetIndex.previous = objWithTargetIndex;
        objWithTargetIndex.innerData = object;
        numOfElements++;
    }
}
