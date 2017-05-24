package ru.job4j.pro.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * This class tests all list classes.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class ListTest {

    /**
     * method tests ArrayList class.
     */
    @Test
    public void whenAddToArrayListTwentyElementsThenGetRightElements() {

        ArrayList<String> arrayList = new ArrayList<>();

        Iterator<String> iterator = arrayList.iterator();

        for (int count = 0; count < 20; count++) {
            arrayList.add(Integer.toString(count));
        }

        String[] expectedArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
        String[] actualArray = new String[20];

        int index = 0;

        while (iterator.hasNext()) {
            actualArray[index++] = iterator.next();
        }

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests LinkedList class.
     */
    @Test
    public void whenAddToLinkedListTwentyElementsThenGetRightElements() {

        LinkedList<String> linkedList = new LinkedList<>();

        Iterator<String> iterator = linkedList.iterator();

        for (int count = 0; count < 20; count++) {
            linkedList.add(Integer.toString(count));
        }

        String[] expectedArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
        String[] actualArray = new String[20];

        int index = 0;

        while (iterator.hasNext()) {
            actualArray[index++] = iterator.next();
        }

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests Stack class.
     */
    @Test
    public void whenPushToStackFiveElementsThenPopFiveElementsAndStackIsEmpty() {

        Stack<String> stack = new Stack<>();

        assertTrue(stack.isEmpty());

        for (int count = 0; count < 5; count++) {
            stack.push(Integer.toString(count));
        }

        String[] expectedArray = {"4", "3", "2", "1", "0"};
        String[] actualArray = new String[5];

        int index = 0;

        while (!stack.isEmpty()) {
            actualArray[index++] = stack.pop();
        }

        assertTrue(stack.isEmpty());

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests Queue class.
     */
    @Test
    public void whenPushToQueueFiveElementsThenPopFiveElementsAndQueueIsEmpty() {

        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());

        for (int count = 0; count < 5; count++) {
            queue.push(Integer.toString(count));
        }

        String[] expectedArray = {"0", "1", "2", "3", "4"};
        String[] actualArray = new String[5];

        int index = 0;

        while (!queue.isEmpty()) {
            actualArray[index++] = queue.pop();
        }

        assertTrue(queue.isEmpty());

        assertThat(actualArray, is(expectedArray));

    }

}
