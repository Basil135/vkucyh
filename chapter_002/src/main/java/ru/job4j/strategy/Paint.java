package ru.job4j.strategy;

/**
 * This class print string to console.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.04.2017
 */
public class Paint {

    /**
     * method print string to console.
     *
     * @param shape is string as a figure
     */
    public void draw(IShape shape) {

        System.out.println(shape.pic());

    }

}
