package ru.job4j.list;

/**
 * Created by Дмитрий on 06.08.2018.
 */
public class SimpleQueue<T extends Number> extends SimpleArrayList<T> {
    public T poll() {
        T result = get(getSize() - 1).data;
        get(getSize() - 2).next = null;
        size--;
        return result;
    }

    public void push(T value) {
        add(value);
    }
}