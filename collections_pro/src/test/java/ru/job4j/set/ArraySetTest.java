package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Дмитрий on 07.08.2018.
 */
public class ArraySetTest {
    private ArraySet<Integer> set = new ArraySet<>();

    @Test
    public void checkAllValuesIsUnique() {
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);
        assertThat(set.get(0), is(1));
        assertThat(set.get(1), is(2));
        assertThat(set.getSize(), is(5));
    }
}