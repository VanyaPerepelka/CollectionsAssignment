package collections.entities;

import collections.engines.LinkEngine;

public final class ImplementedStack<E> extends LinkEngine<E> {

    @Override
    protected int indexOf(E object) {
        return super.indexOf(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public E push(E element){
        return super.addFirst(element);
    }

    public E pop() {
        return super.deleteFirst();
    }

    public E peek(){
        return super.getFirst();
    }

    @Override
    protected E deleteLast() {
        return super.deleteLast();
    }

    @Override
    protected boolean contains(E i) {
        return super.contains(i);
    }

}
