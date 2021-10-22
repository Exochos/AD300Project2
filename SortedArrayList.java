package com.company;

import java.util.Iterator;

public abstract class SortedArrayList<E extends Comparable<E>> implements SortedArrayListInterface {
    ArrayList<E> arrayList;

    public SortedArrayList() {
        arrayList = new ArrayList<>();
    }

    public SortedArrayList(int intitialCapacity) {
        arrayList = new ArrayList<>(intitialCapacity);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object[] get(Object value, Object[] template) {
        return new Object[0];
    }

    @Override
    public void add(Object value) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] template) {
        return new Object[0];
    }
}
