package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This class describes figure queen of the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class Pawn extends Figure {

    /**
     * constructor of thi figure.
     *
     * @param position is the position of this figure on the board
     * @param fraction is the fraction
     */
    public Pawn(Cell position, Fraction fraction) {
        super(position, fraction);
    }

    /**
     * method describes a move of this figure from position to destination.
     *
     * @param destination is cell as destination on the board.
     * @return array of cell as way of this figure from position to destination
     * @throws ImpossibleMoveException if this figure can not move from position to destination
     */
    @Override
    Cell[] way(Cell destination) throws ImpossibleMoveException {

        if ((position.getY() != destination.getY())
            || (fraction == Fraction.black && position.getX() > destination.getX())
            || (fraction == Fraction.white && position.getX() < destination.getX())
            || (Math.abs(position.getX() - destination.getX()) > 1 && position.getX() != 1 && fraction == Fraction.black)
            || (Math.abs(position.getX() - destination.getX()) > 1 && position.getX() != 6 && fraction == Fraction.white)
            || (Math.abs(position.getX() - destination.getX()) > 2 && position.getX() == 6 && fraction == Fraction.white)
            || (Math.abs(position.getX() - destination.getX()) > 2 && position.getX() == 1 && fraction == Fraction.black)) {

            throw new ImpossibleMoveException();

        }

        Cell[] result;

        if (position.getX() == 1 && destination.getX() == 3 && fraction == Fraction.black
         || position.getX() == 6 && destination.getX() == 4 && fraction == Fraction.white) {

            result = new Cell[2];
            result[0] = new Cell(rule(position.getX(), destination.getX()), position.getY());
            result[1] = destination;

        } else {

            result = new Cell[1];

            result[0] = destination;

        }

        return result;

    }

}