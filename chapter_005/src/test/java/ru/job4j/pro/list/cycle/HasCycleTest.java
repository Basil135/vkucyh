package ru.job4j.pro.list.cycle;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests HasCycle class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.06.2017
 */
public class HasCycleTest {

    /**
     * method tests positive end of method hasCycle.
     */
    @Test
    public void whenHasCycleThenTrue() {

        Node<Integer> first = new Node<>();
        Node<Integer> second = new Node<>();
        Node<Integer> third = new Node<>();
        Node<Integer> fourth = new Node<>();

        first.setValue(1);
        first.setNext(second);

        second.setValue(2);
        second.setNext(third);

        third.setValue(3);
        third.setNext(fourth);

        fourth.setValue(4);
        fourth.setNext(first);

        HasCycle hasCycle = new HasCycle();

        boolean expectedValue = true;
        boolean actualValue = hasCycle.hasCycle(first);

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests negative end of method hasCycle.
     */
    @Test
    public void whenHasNoCycleThenFalse() {

        Node<Integer> first = new Node<>();
        Node<Integer> second = new Node<>();
        Node<Integer> third = new Node<>();
        Node<Integer> fourth = new Node<>();

        first.setValue(1);
        first.setNext(second);

        second.setValue(2);
        second.setNext(third);

        third.setValue(3);
        third.setNext(fourth);

        fourth.setValue(4);

        HasCycle hasCycle = new HasCycle();

        boolean expectedValue = false;
        boolean actualValue = hasCycle.hasCycle(first);

        assertThat(actualValue, is(expectedValue));

    }

}
