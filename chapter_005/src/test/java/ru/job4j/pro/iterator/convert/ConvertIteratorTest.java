package ru.job4j.pro.iterator.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class tests ConvertIterator class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class ConvertIteratorTest {

    /**
     * method tests convert Iterator of Iterators of Integer to Iterator of Integer.
     */
    @Test
    public void whenIteratorOfIteratorsThenIterator() {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);

        Iterator<Integer> i1 = list1.iterator();
        Iterator<Integer> i2 = list2.iterator();
        Iterator<Integer> i3 = list3.iterator();

        Iterator<Iterator<Integer>> iteratorOfIterators = Arrays.asList(i1, i2, i3).iterator();

        IIterator iteratorConvert = new IteratorConvert();

        Iterator<Integer> iterator = iteratorConvert.convert(iteratorOfIterators);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
