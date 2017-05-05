package ru.job4j.exam;

/**
 * This class describes point of coordinate system.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 04.05.2017
 */
public class Point {

    /**
     * parameter x is point of coordinate.
     */
    private final int x;
    /**
     * parameter y is point of coordinate.
     */
    private final int y;

    /**
     * constructor of class Point.
     *
     * @param x is point of coordinate
     * @param y is point of coordinate
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * method return value of parameter x.
     *
     * @return value of parameter x
     */
    public int getX() {
        return this.x;
    }

    /**
     * method return value of parameter y.
     *
     * @return value of parameter y
     */
    public int getY() {
        return this.y;
    }

}
