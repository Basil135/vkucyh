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

}
