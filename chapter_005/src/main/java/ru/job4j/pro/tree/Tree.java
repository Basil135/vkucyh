package ru.job4j.pro.tree;

import ru.job4j.pro.list.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class implements SimpleTree interface and realize treelike simple collection.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.08.2017
 *
 * @param <E> is generic type as value of every node of SimpleTree implementation
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * This parameter is root nodeof the tree.
     */
    private Node<E> root;

    /**
     * method return link to node with known value.
     *
     * @param value is value we need to find
     * @return link to the node
     */
    private Node<E> getNode(E value) {

        Queue<Node<E>> queue = new Queue<>();
        queue.push(root);

        Node<E> result = null;

        Node<E> temp;

        while (!queue.isEmpty()) {

            temp = queue.pop();

            for (Node<E> node: temp.children) {
                queue.push(node);
            }

            if (temp.value.equals(value)) {
                result = temp;
                break;
            }

        }

        return result;

    }

    /**
     * method check this tree to binary tree.
     *
     * @return true if this tree is binary
     */
    public boolean isBinary() {

        boolean result = true;

        Node<E> current;

        Queue<Node<E>> queue = new Queue<>();
        queue.push(root);

        while (!queue.isEmpty()) {

            current = queue.pop();

            if (current.children.size() > 2) {
                result = false;
                break;
            }

            for (Node<E> node: current.children) {
                queue.push(node);
            }

        }

        return result;

    }

    /**
     * method add elements to the tree.
     *
     * @param parent is entity of tree collection
     * @param child is entity of tree collection
     * @return true if successfully added
     */
    @Override
    public boolean add(E parent, E child) {

        boolean result = false;

        if (root == null) {

            root = new Node<>(parent);
            root.children.add(new Node<>(child));
            result = true;

        } else {

            Node<E> toAdd = getNode(parent);
            if (toAdd != null) {
                toAdd.children.add(new Node<>(child));
                result = true;
            }

        }

        return result;

    }

    /**
     * method return iterator of SimpleTree.
     *
     * @return new instance of MyTreeIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new MyTreeIterator<>();
    }

    /**
     * This class describes node of the SimpleTree implementaion.
     *
     * @param <E> is generic type as value of node
     */
    private static class Node<E> {

        /**
         * parameter value is value of generic type.
         */
        private E value;
        /**
         * parameter children is list of pointer to the next elements (nodes) of current node.
         */
        private List<Node<E>> children = new ArrayList<>();

        /**
         * constructor of node.
         *
         * @param value is value will be added to the node
         */
        Node(E value) {
            this.value = value;
        }

    }

    /**
     * This class describes Iterator of SimpleTree.
     *
     * @param <E> is generic type of elements
     */
    private class MyTreeIterator<E> implements Iterator<E> {

        /**
         * parameter queue is queue of open node.
         */
        private Queue<Node<E>> queue = new Queue<>();
        /**
         * parameter current is current node of the SimpleTree.
         */
        private Node<E> current = (Node<E>) root;

        /**
         * constructor of MyTreeIterator.
         * root node of SimpleTree adds to queue of open node
         */
        MyTreeIterator() {
            queue.push((Node<E>) root);
        }

        /**
         * method return true if SimpleTree have more elements.
         *
         * @return true if collection have next element
         */
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        /**
         * method return value of node of SimpleTree and move pointer to the next node.
         *
         * @return value of node
         */
        @Override
        public E next() {
            current = queue.pop();
            for (Node<E> node : current.children) {
                queue.push(node);
            }
            return current.value;
        }

    }

}