package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This abstract class describes the any figure of chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.04.2017
 */
abstract class Figure {

    /**
     * parameter position describes the position of the figure.
     */
    private final Cell position;

    /**
     * parameter fraction describes the fraction of the figure.
     */
    private final Fraction fraction;

    /**
     * constructor of class Figure set figure to a position.
     *
     * @param position is position on the board
     * @param fraction is fraction of the chess application
     */
    Figure(final Cell position, final Fraction fraction) {
        this.position = position;
        this.fraction = fraction;
    }

    /**
     * This method return array of cells as way of a figure to he destination cell.
     *
     * @param destination is cell as destination on the board.
     * @return array of cells as way to destination
     * @throws ImpossibleMoveException if this figure can not move from position to destination
     */
    abstract Cell[] way(Cell destination) throws ImpossibleMoveException;

    /**
     * method clone a figure and return new figure.
     *
     * @param destination is cell as position of new figure
     * @return clone figure
     */
    abstract Figure clone(Cell destination);

    /**
     * method describes changes if coordinates when figure move.
     *
     * @param one is the source number of coordinates
     * @param two is the second number of coordinates
     * @return number that bigger or smaller from position
     */
    int rule(int one, int two) {
        if (one > two) {
            return --one;
        } else if (one < two) {
            return ++one;
        } else {
            return one;
        }
    }

    /**
     * method return position of figure.
     *
     * @return position of the figure
     */
    public Cell getPosition() {
        return this.position;
    }

    /**
     * method return fraction of the figure.
     *
     * @return fraction of the figure
     */
    public Fraction getFraction() {
        return this.fraction;
    }

}