package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Iterator for two-dimensional array
 */
public class EvenNumbersIterator implements Iterator {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        index = 0;
    }

    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i <= data.length - 1; i++) {
            if (data[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return (index <= data.length - 1) && result;
    }

    public Object next() {
        int result = index;
        for (int i = index; i < data.length - 1; i++) {
            if (data[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        index = result;
        return data[index++];
    }
    /*Не знаю как сделать так чтобы вылетал NoSuchElementException, 4 тест непроходит!!*/
}