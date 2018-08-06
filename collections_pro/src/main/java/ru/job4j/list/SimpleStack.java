package ru.job4j.list;

/**
 * Created by Дмитрий on 06.08.2018.
 */
public class SimpleStack<T extends Number> extends SimpleArrayList<T> {
    public T poll() {
        return delete();
    }

    public void push(T value) {
        add(value);
    }
}
