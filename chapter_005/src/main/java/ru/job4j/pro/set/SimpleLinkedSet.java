package ru.job4j.pro.set;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * This class describes set using linked list.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 17.06.2017
 *
 * @param <E> is generic tyoe
 */
public class SimpleLinkedSet<E> implements Iterable<E> {

    /**
     * parameter describes count of elements of the set.
     */
    private int size = 0;
    /**
     * parameter first is link to the first element of the set.
     */
    private Node<E> first;
    /**
     * parameter last is the link to the last element of the set.
     */
    private Node<E> last;

    /**
     * method add element to the set if element not exist.
     *
     * @param element is element we need to add
     * @return true if element successfully added
     */
    public boolean add(E element) {

        boolean result = false;

        if (first == null) {

            first = new Node<>();

            first.value = element;

            last = first;

            size++;

            result = true;

        } else {

            Node<E> currentNode = first;

            for (int count = 0; count < size; count++) {

                if (element.equals(currentNode.value)) {
                    result = false;
                    break;
                }

                if (element.hashCode() < currentNode.value.hashCode()) {

                    if (count == 0) {

                        addFirst(element);

                        result = true;

                        break;

                    } else {

                        addMiddle(currentNode, element);

                        result = true;

                        break;

                    }

                } else if (count == size - 1) {

                    addLast(element);

                    result = true;

                    break;

                } else {

                    currentNode = currentNode.next;

                }

            }


        }

        return result;

    }

    /**
     * method add element to the beginning of the set.
     *
     * @param element is input element
     * @return true
     */
    private boolean addFirst(E element) {

        Node<E> newNode = new Node<>();

        newNode.value = element;

        newNode.next = first;

        first.prev = newNode;

        first = newNode;

        size++;

        return true;

    }

    /**
     * method add element to the end of the set.
     *
     * @param element is input element
     * @return true
     */
    private boolean addLast(E element) {

        Node<E> newNode = new Node<>();

        newNode.value = element;

        newNode.prev = last;

        last.next = newNode;

        last = newNode;

        size++;

        return true;

    }

    /**
     * method add element to the middle of the set.
     *
     * @param nextNode is node before that we need to add element
     * @param element is input element
     * @return true
     */
    private boolean addMiddle(Node<E> nextNode, E element) {

        Node<E> newNode = new Node<>();

        newNode.value = element;

        Node<E> prevNode = nextNode.prev;

        prevNode.next = newNode;

        newNode.prev = prevNode;

        newNode.next = nextNode;

        nextNode.prev = newNode;

        size++;

        return true;

    }

    /**
     * method return iterator of the set.
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedSetIterator();
    }

    /**
     * this inner class describes node of the set.
     *
     * @param <E> is generic type
     */
    private class Node<E> {

        /**
         * parameter value is value of the node.
         */
        private E value;
        /**
         * parameter prev is link to the previous node.
         */
        private Node<E> prev;
        /**
         * parameter next is link to the next node.
         */
        private Node<E> next;

    }

    /**
     * This inner class describes set iterator.
     */
    private class LinkedSetIterator implements Iterator<E> {

        /**
         * parameter index is index of the set.
         */
        private int index = 0;
        /**
         * parameter currentNode is link to current node.
         */
        private Node<E> currentNode = first;

        /**
         * method return true if iterator can move on the set.
         *
         * @return true if set have more elements
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * method return current element and move pointer to the next element of the set.
         *
         * @return current element
         */
        @Override
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (index > 0) {
                currentNode = currentNode.next;
            }

            index++;

            return currentNode.value;

        }

    }

}
