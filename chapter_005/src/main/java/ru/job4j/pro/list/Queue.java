package ru.job4j.pro.list;

/**
 * This class describes collection queue.
 *
 * @param <E> is generic type
 */
public class Queue<E> {

    /**
     * parameter first is link to first element of the queue.
     */
    private Node<E> first;
    /**
     * parameter last is link to last element of the queue.
     */
    private Node<E> last;

    /**
     * method add element to the and of collection.
     *
     * @param element is input element
     * @return true
     */
    public boolean push(E element) {

        Node<E> newNode = new Node<>();

        newNode.value = element;

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        return true;

    }

    /**
     * method delete last element and return value.
     *
     * @return value of last element
     */
    public E pop() {

        E result = first.value;

        first = first.next;

        return result;

    }

    /**
     * method return true if collection have no elements.
     *
     * @return true if collection is empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * inner class describes node of collection queue.
     *
     * @param <E> is generic type
     */
    private class Node<E> {

        /**
         * parameter next is link to next element of list.
         */
        private Node<E> next;
        /**
         * parameter value is value of node.
         */
        private E value;

    }

}
