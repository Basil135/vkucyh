package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This class describes the figure knight of the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class Knight extends Figure {

    /**
     * constructor of this figure.
     *
     * @param position is position on the board
     * @param fraction is the fraction
     */
    public Knight(Cell position, Fraction fraction) {
        super(position, fraction);
    }

    /**
     * method describes way of the figure from position to destination.
     *
     * @param destination is cell as destination on the board.
     * @return array of cell as way of the figure
     * @throws ImpossibleMoveException if this figure can not move from position to destination
     */
    @Override
    Cell[] way(Cell destination) throws ImpossibleMoveException {

        if ((Math.abs(position.getX() - destination.getX()) != 2 || Math.abs(position.getY() - destination.getY()) != 1)
         && (Math.abs(position.getX() - destination.getX()) != 1 || Math.abs(position.getY() - destination.getY()) != 2)) {
            throw new ImpossibleMoveException();
        }

        Cell[] result = new Cell[1];

        result[0] = destination;

        return result;

    }

}
