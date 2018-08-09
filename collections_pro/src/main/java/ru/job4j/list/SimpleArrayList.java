package ru.job4j.list;

/**
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<E extends Number> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        E value = this.first.data;
        this.first = this.first.next;
        this.size--;
        return value;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public Node<E> get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    public E dropFirst() {
        E result = get(getSize() - 1).data;
        get(getSize() - 2).next = null;
        size--;
        return result;
    }

    public E dropLast() {
        return delete();
    }
    /**
     * Класс предназначен для хранения данных.
     */
    public static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}