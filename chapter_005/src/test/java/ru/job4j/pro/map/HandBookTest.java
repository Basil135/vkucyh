package ru.job4j.pro.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class describes test of handBook class.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 05.08.2017
 */
public class HandBookTest {

    /**
     * method test HandBook collection.
     */
    @Test
    public void whenAddTwentyElementsThenIteratorReturnRightValues() {

        HandBook<String, String> handBook = new HandBook<>();

        handBook.insert("1", "first");
        handBook.insert("2", "second");
        handBook.insert("3", "third");
        handBook.insert("4", "fourth");
        handBook.insert("5", "fifth");
        handBook.insert("6", "sixth");
        handBook.insert("7", "seventh");
        handBook.insert("8", "eighth");
        handBook.insert("9", "ninth");
        handBook.insert("10", "tenth");
        handBook.insert("11", "eleventh");
        handBook.insert("12", "twelfth");
        handBook.insert("13", "thirteenth");
        handBook.insert("14", "fourteenth");
        handBook.insert("15", "fifteenth");
        handBook.insert("16", "sixteenth");
        handBook.insert("16", "seventeenth");
        handBook.insert("18", "eighteenth");
        handBook.insert("19", "nineteenth");
        handBook.insert("0", "zeroth");

        assertThat(handBook.get("16"), is("seventeenth"));

        handBook.delete("16");

        String[] expectedArray = {
                "eleventh",
                "twelfth",
                "thirteenth",
                "fourteenth",
                "fifteenth",
                "eighteenth",
                "nineteenth",
                "zeroth",
                "first",
                "second",
                "third",
                "fourth",
                "fifth",
                "sixth",
                "seventh",
                "eighth",
                "ninth",
                "tenth"
        };

        String[] actualArray = new String[18];

        Iterator iterator = handBook.iterator();

        int index = 0;

        while (iterator.hasNext()) {
            actualArray[index++] = (String) iterator.next();
        }

        assertThat(actualArray, is(expectedArray));

        assertThat(actualArray.length, is(handBook.getSize()));

    }

}
