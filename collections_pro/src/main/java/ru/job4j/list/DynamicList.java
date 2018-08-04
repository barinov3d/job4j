package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by Дмитрий on 04.08.2018.
 */
public class DynamicList<E> implements Iterable<E> {
    private int size = 5;
    private int index = 0;
    int modCount = 0;
    int expectedModCount = 0;
    Object[] container = new Object[size];

    public void add(E value) {
        if (index > size - 1) {
            doubleConteinerSize();
        }
        container[index++] = value;
        modCount++;
    }

    private void doubleConteinerSize() {
        Object[] doubleContainer = new Object[size * 2];
        System.arraycopy(container, 0, doubleContainer, 0, size);
        container = doubleContainer;
        size *= 2;
    }

    public E get(int index) {
        return (E) container[index];
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        checkForComodification();
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                modCount++;
                expectedModCount++;
                return (E) container[index++];
            }
        };
    }

    final void checkForComodification() {
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }
}
