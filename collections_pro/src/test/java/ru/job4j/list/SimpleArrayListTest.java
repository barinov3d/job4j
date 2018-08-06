package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(0).data, is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteElementsGetCorrectResult() {
        System.out.println("Delete node with value: " + list.delete());
        assertThat(list.get(0).data, is(2));
        assertThat(list.getSize(), is(2));
        System.out.println("Delete node with value: " + list.delete());
        assertThat(list.get(0).data, is(1));
        assertThat(list.getSize(), is(1));
    }
}