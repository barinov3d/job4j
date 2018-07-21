package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for two-dimensional array
 */
public class MatrixIterator implements Iterator {
    int[][] array;
    int lineIndex;
    int rowIndex;
    int lineIndexMax;
    int rowIndexMax;

    public MatrixIterator(int[][] array) {
        this.array = array;
        lineIndex = 0;
        rowIndex = 0;
        lineIndexMax = array.length;
        try {
            rowIndexMax = array[lineIndex].length;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is empty");
            rowIndexMax = -1;
        }
    }

    public boolean hasNext() {
        if (!(lineIndex == lineIndexMax - 1)) {
            return rowIndex <= rowIndexMax;
        } else {
            return rowIndex < rowIndexMax;
        }
    }

    public Object next() {
        if (rowIndexMax == -1) {
            throw new NoSuchElementException("No such element");
        }
        if (rowIndex < rowIndexMax) {
            return array[lineIndex][rowIndex++];
        } else {
            rowIndex = 0;
            rowIndexMax = array[++lineIndex].length;
            return array[lineIndex][rowIndex++];
        }
    }

}