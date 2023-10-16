/*
    Name: Aman Velani
    SUID: 982212915
*/
package edu.syr.hw5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackAdapter<E> implements Stack<E> {
    private List<E> adaptee;

    public StackAdapter() {
        this.adaptee = new ArrayList<>();
    }

    @Override
    public void push(E e) {
        this.adaptee.add(e);
    }

    @Override
    public E pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return adaptee.remove(size() - 1);
    }

    @Override
    public E peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return adaptee.get(size() - 1);
    }

    @Override
    public int size() {
        return this.adaptee.size();
    }

    @Override
    public List<E> getData() {
        List<E> copy = new ArrayList<>();
        copy.addAll(adaptee);
        return copy;
    }
}