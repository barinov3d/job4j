package ru.job4j.generic;

/**
 * Created by Дмитрий on 03.08.2018.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    int size;
    SimpleArray<T> data;

    public AbstractStore(int size) {
        this.size = size;
        this.data = new SimpleArray<T>(size);
    }

    @Override
    public void add(T model) {
        data.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        if (!(getIndexById(id) == -1)) {
            result = true;
            data.set(getIndexById(id), model);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (!(getIndexById(id) == -1)) {
            result = true;
            data.delete(getIndexById(id));
        }
        return result;
    }

    @Override
    public T findById(String id) {
        return data.get(getIndexById(id));
    }

    private int getIndexById(String id) {
        int index = -1;
        for (int i = 0; i < data.size; i++) {
            if (data.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
