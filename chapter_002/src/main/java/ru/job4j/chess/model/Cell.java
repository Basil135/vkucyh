package ru.job4j.chess.model;

/**
 * This class describes a cell of board of chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.04.2017
 */
public class Cell {

    /**
     * parameter describes row of board of chess.
     */
    private final int x;
    /**
     * parameter describes column of board of chess.
     */
    private final int y;

    /**
     * constructor of Cell class.
     *
     * @param x is set point at row on the board
     * @param y is set point at column on the board
     */
    public Cell(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * method return row on the board.
     *
     * @return x as row on the board of chess
     */
    public int getX() {
        return this.x;
    }

    /**
     * method return column on the board of chess.
     *
     * @return y as column on the board of chess
     */
    public int getY() {
        return this.y;
    }

}