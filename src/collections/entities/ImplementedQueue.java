package collections.entities;

import collections.engines.LinkEngine;

public final class ImplementedQueue<E> extends LinkEngine<E> {

    public E examine() {
        return super.getLast();
    }

    @Override
    public int indexOf(E object) {
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

    public E poll() {
        return super.deleteLast();
    }

    @Override
    public boolean contains(E i) {
        return super.contains(i);
    }


    public E offer(E token) {
        return super.addFirst(token);
    }
}
