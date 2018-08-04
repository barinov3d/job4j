package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for two-dimensional array
 */
public class EvenNumbersIterator implements Iterator {
    private int[] data;
    private int index;
    private boolean indexExist;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        index = 0;
    }

    public boolean hasNext() {
        return getIndex();
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    private boolean getIndex() {
        boolean result = false;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }
}
