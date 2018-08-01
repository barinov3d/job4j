package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    int size;
    int index;
    Object[] data;

    public SimpleArray(int size) {
        this.size = size;
        this.data = new Object[size];
        this.index = 0;
    }

    public void add(T model) {
        data[index++] = model;
    }

    public void set(int index, T model) {
        data[index] = model;
    }

    public void delete(int index) {
        data[index] = null;
    }

    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < data.length;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No such element");
                }
                return data[index++];
            }
        };
    }
}
