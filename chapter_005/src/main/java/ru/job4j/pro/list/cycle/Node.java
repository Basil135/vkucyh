package ru.job4j.pro.list.cycle;

/**
 * This class describes simple node.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.06.2017
 *
 * @param <T> is generic type
 */
public class Node<T> {

    /**
     * parameter value is value of the node.
     */
    private T value;
    /**
     * parameter next keep link for next node.
     */
    private Node<T> next;

    /**
     * method return value of this node.
     *
     * @return value
     */
    public T getValue() {
        return value;
    }

    /**
     * method set value to this node.
     *
     * @param value is value of the node
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * method return next.
     *
     * @return next as link to the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * method set link to parameter next.
     *
     * @param next is link to the next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

}
