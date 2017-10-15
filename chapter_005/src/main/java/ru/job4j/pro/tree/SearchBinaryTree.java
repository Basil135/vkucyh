package ru.job4j.pro.tree;

import ru.job4j.pro.list.Queue;

import java.util.Iterator;

/**
 * This class describes implementation of SearchBinaryTree collection, duplicates are unavailable.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 15.10.2017
 *
 * @param <E> generic type of values, must implements comparable interface
 */
public class SearchBinaryTree<E extends Comparable<E>> {

    /**
     * parameter root of tree.
     */
    private Node<E> root;

    /**
     * inner class Node describes node of a tree.
     *
     * @param <E> generic type of values, must implements comparable interface
     */
    private class Node<E> {

        /**
         * parameter describes value of Node.
         */
        private E value;
        /**
         * parameter describes left subtree.
         */
        private Node<E> left;
        /**
         * parameter describes right subtree.
         */
        private Node<E> right;

        /**
         * constructor of Node class.
         *
         * @param value is value of Node class
         */
        Node(E value) {
            this.value = value;
        }

    }

    /**
     * method describes get Node of Tree before add new Node to it.
     *
     * @param node is node from we search
     * @param value is value to add
     * @return node to add new subtree
     */
    private Node<E> get(Node<E> node, E value) {

        Node<E> result;

        if (value.compareTo(node.value) <= 0) {

            if (node.left == null) {
                result = node;
            } else {
                result = get(node.left, value);
            }

        } else {

            if (node.right == null) {
                result = node;
            } else {
                result = get(node.right, value);
            }

        }

        return result;

    }

    /**
     * method add new subtree to the tree.
     *
     * @param value is value to add
     * @return true if subtree was added
     */
    public boolean add(E value) {

        boolean result = true;

        if (root == null) {

            root = new Node<>(value);

        } else {

            Node<E> nodeToAdd = get(root, value);

            if (value.compareTo(nodeToAdd.value) < 0) {
                nodeToAdd.left = new Node<>(value);
            } else if (value.compareTo(nodeToAdd.value) > 0) {
                nodeToAdd.right = new Node<>(value);
            } else {
                result = false;
            }

        }

        return result;

    }

    /**
     * method return iterator of the tree.
     *
     * @return new instance of TreeWidthIterator
     */
    public Iterator<E> iterator() {
        return new TreeWidthIterator<>();
    }

    /**
     * inner class describes iterator of the tree.
     *
     * @param <E> generic type of values, must implements comparable interface
     */
    public class TreeWidthIterator<E> implements Iterator<E> {

        /**
         * parameter queue is queue if nodes to be iterated.
         */
        private Queue<Node<E>> queue = new Queue();

        /**
         * constructor of TreeWidthIterator.
         */
        TreeWidthIterator() {
            queue.push((Node<E>) root);
        }

        /**
         * method return true if iterator have more elements.
         *
         * @return true if iterator have more elements
         */
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        /**
         * method return next element of the tree.
         *
         * @return next element
         */
        @Override
        public E next() {
            Node<E> result = queue.pop();
            if (result.left != null) {
                queue.push(result.left);
            }
            if (result.right != null) {
                queue.push(result.right);
            }
            return result.value;
        }

    }

}
