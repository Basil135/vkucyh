package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * This class describes board of chess.
 *
 * @author Kuvykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.04.2017
 */
public class Board {

    /**
     * parameter size is size of a square bord of chess.
     */
    private int size = 8;
    /**
     * parameter figure is a figure of chess that shoud be move.
     */
    private Figure figure;
    /**
     * parameter figures is double array of figures as board of chess.
     */
    private Figure[][] figures = new Figure[size][size];

    /**
     * method take a figure from figures array at position cell and return it.
     *
     * @param cell is position of figure at figures array
     * @return return a figure at position cell
     */
    public Figure getFigure(final Cell cell) {
        return this.figures[cell.getX()][cell.getY()];
    }

    /**
     * method set a figure to array figures to position cell.
     *
     * @param cell is position at array figures
     */
    public void setFigure(final Cell cell) {
        this.figure = figures[cell.getX()][cell.getY()];
    }

    /**
     * method tests figure to move from source position to destination position.
     *
     * @param source is a source position at array figures
     * @param dest is destination position at array figures
     * @return true if figure set at destination position and remove from source position
     * @throws ImpossibleMoveException if figure can't be moved like that
     * @throws OccupiedWayException if way of figure is occupied by other figures
     * @throws FigureNotFoundException if figure is not found at source position
     */
    public boolean move(final Cell source, final Cell dest) throws ImpossibleMoveException,
                                                                    OccupiedWayException, FigureNotFoundException {

        figure = getFigure(source);

        if (figure == null) {
            throw new FigureNotFoundException();
        }

        Cell[] way = figure.way(dest);

        for (Cell cell : way) {
            if (getFigure(cell) != null) {
                throw new OccupiedWayException();
            }
        }

        setFigure(dest);
        figure = null;
        setFigure(source);

        return true;

    }

}
