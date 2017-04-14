package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests Paint class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.04.2017
 */
public class PaintTest {

    /**
     * method tests draw a triangle.
     */
    @Test
    public void whenPaintTriangleThenPaintTriangle() {

        IShape shape = new Triangle();

        Paint paint = new Paint();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));

        paint.draw(shape);

        assertThat(
                out.toString(),
                is(
                        String.format("     *     \n    ***    \n   *****   \n  *******  \n ********* \n***********\n\n")
                )
        );

    }

    /**
     * method tests draw a square.
     */
    @Test
    public void whenPaintSquareThenPaintSquare() {

        IShape shape = new Square();

        Paint paint = new Paint();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));

        paint.draw(shape);

        assertThat(
                out.toString(),
                is(
                        String.format("**********\n*        *\n*        *\n*        *\n*        *\n**********\n\n")
                )
        );

    }

}
