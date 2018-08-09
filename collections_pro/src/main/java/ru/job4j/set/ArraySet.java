package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

/**
 * Created by Дмитрий on 07.08.2018.
 */
public class ArraySet<E extends Number> implements Iterable<E> {
    private DynamicList list = new DynamicList();

    void add(E e) {
        boolean alreadyInCollection = false;
        for (int i = 0; i < list.getSize() - 1; i++) {
            if (list.get(i) == e) {
                alreadyInCollection = true;
            }
        }
        if (!alreadyInCollection) {
            list.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    public E get(int index) {
        return (E) list.get(index);
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return list.getSize();
    }

}
