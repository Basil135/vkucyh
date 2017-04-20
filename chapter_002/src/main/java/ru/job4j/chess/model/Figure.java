package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This abstract class describes the any figure of chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.04.2017
 */
public abstract class Figure {

    /**
     * parameter position describes the position of the figure.
     */
    final Cell position;

    /**
     * constructor of class Figure set figure to a position.
     *
     * @param position is position on the board
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * This method return array of cells as way of a figure to he destination cell.
     *
     * @param destination is cell as destination on the board.
     * @return array of cells as way to destination
     */
    abstract Cell[] way(Cell destination) throws ImpossibleMoveException;

}