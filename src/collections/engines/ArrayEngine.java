package collections.engines;

import java.util.Arrays;

/**
 * Class is presenting dynamic data-structure object that uses array as main parent structure.
 */
public class ArrayEngine<E> {

    /**
     * Default size of inner array to create with the Object
     * */
    protected int capacity = 10;

    /**
     * Representing number of elements in inner array
     * */
    protected int numOfElements = 0;

    /**
     * Container to store data
     * */
    protected Object[] elements;


    /**
     * Method to set inner array to new empty value
     * */
    protected void clear() {
        elements = new Object[capacity];
        numOfElements = 0;
    }

    /**
     * Method to find if object are stored in inner array using {@code IndexOf()} - another method of this object
     * @param object object to find in array
     * @return true if object is presented
     * */
    protected boolean contains(E object) {
        return indexOf(object) >= 0;
    }

    /**
     * Method to check index of presented object using for-loop to walk-trough an inner array
     * @param object object to check index of
     * @return index of object if resented, -1 otherwise
     * */
    protected int indexOf(E object) {
        for (int i = 0; i < numOfElements; i++) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to return String representation of inner data using JDK default methods
     * {@code Arrays.toString(obj[] array)} and {@code Arrays.copyOf(obj[] source)}
     * @return string representation of inner array
     * */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, numOfElements));
    }

    /**
     * Method to check if inner array has a data inside using 0 and service counter equality
     * @return true if array is empty
     * */
    protected boolean isEmpty() {
        return numOfElements == 0;
    }

    /**
     * Method to check number of elements stored in inner array
     *
     * @return number of elements
     * */
    protected int size() {
        return numOfElements;
    }
/*_________________________SERVICE________________________________*/
    /**
     * Service method to catch some invalid index-values
     * @param index index to validate
     * @throws IndexOutOfBoundsException if index less than 0 or bigger than number of elements in inner array
     * */
    protected void checkIndex(int index) {
        if (index < 0|| index >= numOfElements) {
            throw new IndexOutOfBoundsException(
                    "Index [" + index + "] out of bounds for ImplementedArrayList with " + numOfElements + " elements"
            );
        }
    }

    /**
     * Service method to validate data-handling operation element index and rise inner array length
     * if needed
     *
     * @param index index of element to handle
     * */
    protected void checkIndexToGrow(int index){
        if (index < 0){
            throw new IndexOutOfBoundsException("Invalid index [" + index + "]");
        } else {
            if (elements.length < index){
                elements = grow(index);
            }
        }
    }

    /**
     * Service method to add new empty data-containers to inner array to store new values using
     * {@code Arrays.copyOf(src[], newSize)}
     * Just copying data from inner array to new longer array
     *
     * @return inner data array with updated length
     * */
    private Object[] grow() {
        int oldSize = elements.length;
        return Arrays.copyOf(elements,
                (oldSize + (oldSize / 2)) + 1);//seems most optimal. +1 bc of custom capacity edge cases
    }

    /**
     * Service method to add new empty data-containers to inner array to store new values using
     * {@code Arrays.copyOf(src[], newSize)}
     * Just copying data from inner array to new longer array
     *
     * @return inner data array with updated length
     */
    private Object[] grow(int index){
        return Arrays.copyOf(elements, index + 1);
    }

    /**
     * Service counter-of-elements incrementer
     * */
    protected void updateSize() {
        numOfElements++;
    }

    /**
     * Service counter-of-elements incrementer to update size after handling data by index scenery
     * */
    protected void updateSize(int index) {
        numOfElements = index + 1;
    }

    /**
     * Service method to control inner array overflow
     * */
    protected void checkLength() {
        if (numOfElements >= elements.length) {
            elements = grow();
        }
    }

    /**
     * Service method to throw exception
     * @throws IllegalStateException if any of getters methods trying to return object from empty list
     * */
    protected void throwIfNothingToGet(){
        if (numOfElements == 0){
            throw new IllegalStateException("Nothing to get from empty list!");
        }
    }
}
