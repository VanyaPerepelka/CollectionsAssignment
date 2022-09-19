package collections.engines;

import java.util.NoSuchElementException;

/**
 * Class is presenting dynamic data-structure object that uses link system to store elements
 * Every element object contains link to previous and next element in structure.
 * */
public class LinkEngine<E> {

    /**
     * Counter of elements number
     * */
    protected int numOfElements = 0;

    /**
     * First element of container
     */
    protected Token<E> first;

    /**
     * Last element of container
     * */
    protected Token<E> last;

    /**
     * Simple getter for first element
     *
     * @return first element
     * @throws NoSuchElementException if list is empty
     * */
    protected E getFirst(){
        if (first != null){
            return first.innerData;
        } else throw new NoSuchElementException("U trying to get element from empty list");
    }

    /**
     * Simple getter for last element
     *
     * @return last element
     * @throws NoSuchElementException if list is empty
     * */
    protected E getLast(){
        if (last != null){
            return last.innerData;
        } else throw new NoSuchElementException("U trying to get element from empty list");
    }

    /**
     * Method to delete first element of list with unlinking it from second element and declaring
     * second element as first.
     * As result none of elements in list contains link to element to delete and GC clearing it out of stack
     *
     * @return Deleted element
     * @throws NoSuchElementException if list is empty
     * */
    protected E deleteFirst(){
        E result = first.innerData;
        if (result == null){
            throw new NoSuchElementException("U trying to delete element out of empty list");
        } else {
            first = first.next;
            numOfElements --;
            return result;
        }
    }

    /**
     * Method to delete last element of list with unlinking it from previous element and declaring
     * previous element as last.
     * As result none of elements in list contains link to element to delete and GC clearing it out of stack
     *
     * @return Deleted element
     * @throws NoSuchElementException if list is empty
     * */
    protected E deleteLast(){
        E result = last.innerData;
        if (result == null){
            throw new NoSuchElementException("U truing to delete element out of empty list");

        } else {
            last = last.previous;
            last.next = null;
            numOfElements --;
            return result;
        }
    }

    /**
     * Method to add element to head of list
     * Example: {@code [2,3,4,5] (1)-> [1,2,3,4,5]}
     * @param token object to add
     * @return object if token added
     */
    protected E addFirst(E token){
        Token<E> newToken = new Token<>(null, token, first);
        if (first == null){
            first = newToken;
            last = newToken;
        } else {
            first.previous = first;
            first = newToken;
        }
        numOfElements++;
        return newToken.innerData;
    }

    /**
     * Method to add object to tail of list
     * Example: {@code [0,1,2,3] (4)-> [0,1,2,3,4]}
     *
     * @param token object to add
     * @return added object
     * */
    protected E addLast(E token){
        Token<E> newToken = new Token<>(last, token, null);
        if (last == null){
            last = newToken;
            first = newToken;
        } else{
            last.next = newToken;
            last = newToken;

        }
        numOfElements++;
        return token;
    }

    /**
     * Method to reset container to default empty value with setting all object-wrappers to null during
     * walk through every next element
     * */
    protected void clear(){
        for(var i = first; i != null;){ //walk-through every next element link
            var next = i.next;
            i.previous = null;
            i.innerData = null;
            i.next = null;
            i = next;
        }
        first = null;
        last = null;
    }

    /**
     * Search method iterating through every next element and catches equal object
     *
     * @param object object to find index of
     * @return index of handled element, -1 otherwise
     * */
    protected int indexOf(E object){
        int index = 0;
        for (var i = first; i != null; i = i.next){
            if (i.innerData.equals(object)){
                return index;
            }
            index ++;
        }
        return -1;
    }

    /**
     * Search method to check if list contains an object using {@code indexOf(E object)}
     *
     * @param object to find
     * @return true if list contains object
     * */
    protected boolean contains(E i) {
        return indexOf(i) >= 0;
    }

    /**
     * Method to check if list does not contain any objects
     *
     * @return true if list is empty
     * */
    protected boolean isEmpty(){
        return first == null && last == null;
    }

    /**
     * Simple getter for inner counter of adding and deleting methods
     *
     * @return number of elements in list
     * */
    protected int size(){
        return numOfElements;
    }

//-------------------------SERVICE--------------------------------//

    /**
     * Service method to unlink simple element out of list
     * @param token element to delete
     * */
    protected final void clear(Token<E> token){
        if (token.equals(last)){
            deleteLast();
        } else if(token.equals(first)){
            deleteFirst();
        }  else {
            token.previous.next = token.next;
        }
    }

    /**
     * Simple index validator to handle some objects in list by index
     * @param index index to validate
     * @return object with last index or with first index if present
     * @throws IndexOutOfBoundsException if index less than zero or bigger than number of element in list
     * */
    protected final E checkIndexToHandleInnerData(int index) {
        if (index < 0 || index > numOfElements) throw new IndexOutOfBoundsException(
                "Index [" + index + "] out of range for ImplementedArrayList of " + numOfElements + " element");

        else if (index == 0){
            return first.innerData;

        } else if(index == numOfElements-1){
            return last.innerData;

        } else return null;
    }

    /**
     * Simple index validator to get some object out of list
     *
     * @param index index to validate
     * @throws IndexOutOfBoundsException if index less than zero
     * */
    protected final void checkIndex(int index){
        if (index < 0) throw new IndexOutOfBoundsException(
                "Index ["  + index + "] out of range for ImplementedArrayList of " + numOfElements + " element"
        );
    }

    /**
     * Object wrapper to store object by linking
     * Every object stored in list has links to previous and next elements
     * besides first element (does not contain link to previous) and last element (does not contain link to next)
     * */
    protected final static class Token <E>{

        /*** link to previous object */
        public Token<E> previous;

        /*** link to next object */
        public Token<E> next;

        /**object to store in list */
        public E innerData;

        /**
         * Constructor to create wrapper.
         * @param previous link to previous object in list
         * @param next link to next object in list
         * @param current object to store in list
         */
        public Token(Token<E> previous, E current, Token<E> next){
            this.previous = previous;
            this.innerData = current;
            this.next = next;
        }
    }

    @Override
    public String toString(){
        if (isEmpty()){
            return "[]";
        } else {
            StringBuilder res = new StringBuilder("[");
            for (var i = first; i != null; i = i.next) {
                res.append(i.innerData.toString()).append(", ");
            }
            res.delete(res.length() - 2, res.length());
            res.append("]");
            return String.valueOf(res);
        }
    }
}
