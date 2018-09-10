package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 31.08.2018.
 */

/**
 * @author Petr Arsentev (mailto:parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
    
    @Test
    public void checkIteratorForeach() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        List<Integer> result = new ArrayList<>();
        for (Integer integer : tree) {
        	result.add(integer);
		}
        assertThat(result.get(0), is(1));
        assertThat(result.get(1), is(2));
        assertThat(result.get(2), is(3));
        assertThat(result.get(3), is(4));
        assertThat(result.get(4), is(5));
        assertThat(result.get(5), is(6));
    }
}
