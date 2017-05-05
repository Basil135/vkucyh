package ru.job4j.exam;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class is test class Geometry.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 04.05.2017
 */
public class ExamTest {

    /**
     * method test figure if figure is square.
     */
    @Test
    public void whenIsSquareIsTrueThenTrue() {

        Geometry test = new Geometry();

        boolean actual = test.isSquare(new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1));

        assertTrue(actual);

    }

    /**
     * method test figure if figure is not square.
     */
    @Test
    public void whenIsSquareIsFalseThenFalse() {

        Geometry test = new Geometry();

        boolean actual = test.isSquare(new Point(1, 1), new Point(5, 3), new Point(3, 7), new Point(1, 5));

        assertFalse(actual);

    }

    /**
     * method test figure if figure is not square.
     */
    @Test
    public void whenPointsAreWrongOrderThenFalse() {

        Geometry test = new Geometry();

        boolean actual = test.isSquare(new Point(1, 1), new Point(3, 3), new Point(1, 3), new Point(3, 1));

        assertFalse(actual);

    }

}
