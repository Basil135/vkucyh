package ru.job4j.exam;

/**
 * This class exam four points they are square.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 04.05.2017
 */
public class Geometry {

    /**
     * method exam four points they are square.
     *
     * @param a is first point of figure
     * @param b is second point of figure
     * @param c is third point of figure
     * @param d is fourth point of figure
     * @return true if figure is square
     */
    public boolean isSquare(final Point a, final Point b, final Point c, final Point d) {

        boolean result = true;

        double ab = lenLine(a, b);
        double bc = lenLine(b, c);
        double cd = lenLine(c, d);
        double da = lenLine(d, a);

        double diagAC = lenLine(a, c);
        double diagBD = lenLine(b, d);

        if (ab != bc || ab != cd || ab != da || bc != cd || bc != da || cd != da || diagAC != diagBD) {
            result = false;
        }

        return result;

    }

    /**
     * method return length of line from point a to point b.
     *
     * @param a is first point of line
     * @param b is second point of line
     * @return length of the line
     */
    private double lenLine(final Point a, final Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow((b.getY() - a.getY()), 2));
    }

}
