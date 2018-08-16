package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Дмитрий on 04.08.2018.
 */
public class DynamicListTest {

    private DynamicList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    public void checksAllValuesInArray() {
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));
    }

    @Test
    public void whenAddValueBiggerThenSizeItShouldBeIncreased() {
        list.add(6);
        assertThat(list.size(), is(10));
        assertThat(list.get(5), is(6));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void checkForComodification() {
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        list.add(7);
        iterator.next();
    }

}