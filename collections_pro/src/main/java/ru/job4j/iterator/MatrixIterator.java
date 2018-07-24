package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for two-dimensional array
 */
public class MatrixIterator implements Iterator {
    private int[][] data;
    private int row;
    private int cell;

    public MatrixIterator(int[][] data) {
        this.data = data;
        row = 0;
        cell = 0;
    }

    public boolean hasNext() {
        boolean result;
        if (!(row == data.length - 1)) {
            result = cell <= data[row].length;
        } else {
            result = cell < data[row].length;
        }
        return result;
    }

    public Object next() {
        if (data.length == 0) {
            /*это не соответствует замечанию "никаких эксепшенов в коде быть не должно", но как по-дугому - не знаю!
            у меня вылетает ArrayIndexOutOfBoundsException, а не NoSuchElementException */
            throw new NoSuchElementException("No such element");
        }
        if (cell >= data[row].length) {
            cell = 0;
            row++;
        }
        return data[row][cell++];
    }
}