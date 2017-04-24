package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This class describes figure of elephant at the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.04.2017
 */
public class Bishop extends Figure {

    /**
     * constructor of class Bishop.
     *
     * @param position is position of the figure
     * @param fraction is fraction
     */
    public Bishop(final Cell position, final Fraction fraction) {
        super(position, fraction);
    }

    /**
     * method look the way to destination cell.
     *
     * @param destination is cell as destination on the board.
     * @return array of cell as the way to destination
     * @throws ImpossibleMoveException if this figure can't move to destination cell
     */
    @Override
    public Cell[] way(final Cell destination) throws ImpossibleMoveException {

        if (Math.abs(position.getX() - destination.getX()) != Math.abs(position.getY() - destination.getY())
                                                                    || position.getX() == destination.getX()) {

            throw new ImpossibleMoveException();

        }

        Cell[] result = new Cell[Math.abs(position.getX() - destination.getX())];

        Cell source = position;

        for (int i = 0; i < result.length; i++) {
            source = new Cell(rule(source.getX(), destination.getX()), rule(source.getY(), destination.getY()));
            result[i] = source;
        }

        return result;

    }

}
