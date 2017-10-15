package ru.job4j.pro.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This class tests Tree class.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id
 * @since 3.10.2017
 */
public class TreeTest {

    /**
     * method tests Tree of integer.
     */
    @Test
    public void whenFillTreeThenIteratorGetRightElements() {

        Tree<Integer> tree = new Tree<>();

        tree.add(1, 2);
        tree.add(1, 17);
        tree.add(1, 22);
        tree.add(2, 53);
        tree.add(2, 77);
        tree.add(77, 81);

        Integer[] expected = {1, 2, 17, 22, 53, 77, 81};

        Integer[] actual = new Integer[7];

        Iterator<Integer> iter = tree.iterator();

        int count = 0;

        while (iter.hasNext()) {
            actual[count++] = iter.next();
        }

        assertThat(expected, is(actual));

    }

    /**
     * method test isBinary method of class Tree by positive scenario.
     */
    @Test
    public void whenIsBinaryPositiveScenarioThenTrue() {

        Tree<Integer> tree = new Tree<>();

        tree.add(1, 2);
        tree.add(1, 17);
        tree.add(2, 53);
        tree.add(2, 77);
        tree.add(77, 81);
        tree.add(77, 82);
        tree.add(53, 89);

        boolean expected = true;

        boolean actual = tree.isBinary();

        assertThat(expected, is(actual));

    }

    /**
     * method test isBinary method of class Tree by negative scenario.
     */
    @Test
    public void whenIsBinaryNegativeScenarioThenFalse() {

        Tree<Integer> tree = new Tree<>();

        tree.add(1, 2);
        tree.add(1, 17);
        tree.add(2, 53);
        tree.add(2, 77);
        tree.add(77, 81);
        tree.add(77, 82);
        tree.add(53, 89);
        tree.add(53, 143);
        tree.add(53, 73);

        boolean expected = false;

        boolean actual = tree.isBinary();

        assertThat(expected, is(actual));

    }

    /**
     * method tests search binary tree.
     */
    @Test
    public void whenAddFifteenNumbersToSearchBinaryTreeThenIteratorsReturnWriteOrder() {

        SearchBinaryTree<Integer> sbt = new SearchBinaryTree<>();

        Integer[] toAdd = {9, 1, 5, 13, 10, 4, 7, 14, 15, 12, 3, 2, 11, 6, 8, 0};

        for (Integer in: toAdd) {
            sbt.add(in);
        }

        Integer[] expected = {9, 1, 13, 0, 5, 10, 14, 4, 7, 12, 15, 3, 6, 8, 11, 2};

        Integer[] actual = new Integer[16];

        Iterator<Integer> iter = sbt.iterator();

        int i = 0;

        while (iter.hasNext()) {
            actual[i++] = iter.next();
        }

        assertThat(actual, is(expected));

    }

}
