package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Created by Дмитрий on 31.08.2018.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    Node<E> root;

    public Tree(E value) {
        root = new Node<E>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        if (!findBy(child).isPresent()) {
            Optional<Node<E>> parentNode = findBy(parent);
            Node<E> newNode = new Node<>(child);
            parentNode.ifPresent(x -> x.add(newNode));
            return true;
        }
        return false;
    }
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
