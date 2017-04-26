package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This class describes figure queen of the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class Queen extends Figure {

    /**
     * constructor of this figure.
     *
     * @param position is the position of this figure on the board
     * @param fraction is the fraction
     */
    public Queen(Cell position, Fraction fraction) {
        super(position, fraction);
    }

    /**
     * method describes a way of this figure from position to destination.
     *
     * @param destination is cell as destination on the board.
     * @return array of cell as way from position to destination
     * @throws ImpossibleMoveException if this figure can not move from position to destination
     */
    @Override
    Cell[] way(Cell destination) throws ImpossibleMoveException {

        if ((position.getX() != destination.getX() && position.getY() != destination.getY())
            && (Math.abs(position.getX() - destination.getX()) != Math.abs(position.getY() - destination.getY()))
            || position.getX() == destination.getX() && position.getY() == destination.getY()) {

            throw new ImpossibleMoveException();

        }

        int size = position.getX() == destination.getX() ? Math.abs(position.getY() - destination.getY())
                                                         : Math.abs(position.getX() - destination.getX());

        Cell[] result = new Cell[size];

        Cell source = position;

        for (int count = 0; count < result.length; count++) {

            source = new Cell(rule(source.getX(), destination.getX()), rule(source.getY(), destination.getY()));
            result[count] = source;

        }

        return result;

    }

    /**
     * method clone figure and return new figure.
     *
     * @param destination is cell as position of new figure
     * @return clone figure
     */
    @Override
    public Figure clone(Cell destination) {
        return new Queen(destination, this.fraction);
    }

}
