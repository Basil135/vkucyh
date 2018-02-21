package ru.job4j.chapter002.multithreading.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class describes tests of my list simple implementation.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 21.02.2018
 */
public class MyArrayListTest {

    /**
     * method tests MyArrayList class.
     */
    @Test
    public void whenTwoThreadsIterateThenArrayListIterate() {
        MyList<String> list = new MyArrayList<>();
        list.add("1");

        list.delete(0);

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertThat(list.size(), is(5));

        boolean del = list.delete(6);

        assertThat(del, is(false));

        del = list.delete("6");

        assertThat(del, is(false));

        del = list.delete("1");

        assertThat(del, is(true));
        assertThat(list.size(), is(4));

        del = list.delete(3);

        assertThat(del, is(true));
        assertThat(list.size(), is(3));

        list.add(0, "7");

        String[] expectedArray = {"7", "2", "3", "4"};

        Object[] actualArray = list.toArray();

        assertThat(actualArray, is(expectedArray));

        Iterator<String> iterator = list.iterator();
        List<String> actualList = new CopyOnWriteArrayList<>();
        while (iterator.hasNext()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (iterator.hasNext()) {
                        actualList.add(iterator.next());
                    }
                }
            }).start();
        }
        actualArray = actualList.toArray();

        assertThat(actualArray, is(expectedArray));
    }

    /**
     * method tests MyLinkedList class.
     */
    @Test
    public void whenTwoThreadsIterateThenLinkedListIterate() {
        MyList<String> list = new MyLinkedList<>();
        list.add("1");

        list.delete(0);

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertThat(list.size(), is(5));

        boolean del = list.delete(6);

        assertThat(del, is(false));

        del = list.delete("6");

        assertThat(del, is(false));

        del = list.delete("1");

        assertThat(del, is(true));
        assertThat(list.size(), is(4));

        del = list.delete(3);

        assertThat(del, is(true));
        assertThat(list.size(), is(3));

        list.add(0, "7");

        String[] expectedArray = {"7", "2", "3", "4"};

        Object[] actualArray = list.toArray();

        assertThat(actualArray, is(expectedArray));

        Iterator<String> iterator = list.iterator();
        List<String> actualList = new CopyOnWriteArrayList<>();
        while (iterator.hasNext()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (iterator.hasNext()) {
                        actualList.add(iterator.next());
                    }
                }
            }).start();
        }
        actualArray = actualList.toArray();

        assertThat(actualArray, is(expectedArray));
    }
}
