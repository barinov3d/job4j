package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

/**
 * Created by Дмитрий on 07.08.2018.
 */
public class ArraySet<E extends Number> implements Iterable<E> {
    private DynamicList dynamicList = new DynamicList();

    void add(E e) {
        boolean alreadyInCollection = false;
        for (int i = 0; i < dynamicList.getSize() - 1; i++) {
            if (dynamicList.get(i) == e) {
                alreadyInCollection = true;
            }
        }
        if (!alreadyInCollection) {
            dynamicList.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return dynamicList.iterator();
    }

    public E get(int index) {
        return (E) dynamicList.get(index);
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return dynamicList.getSize();
    }

}
