package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Дмитрий on 04.08.2018.
 */
public class DynamicList<E> implements Iterable<E> {
    private int size = 5;
    private int index = 0;
    private int modCount = 0;
    private Object[] container = new Object[size];

    public void add(E value) {
        if (index > size - 1) {
            doubleContainerSize();
        }
        container[index++] = value;
        modCount++;
    }

    private void doubleContainerSize() {
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
        return new Iterator<E>() {
            private int expectedModCount = 0;

            @Override
            public boolean hasNext() {
                checkForComodification();
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }

            final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

}
