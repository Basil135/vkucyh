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

        if ((getPosition().getY() != destination.getY())
            || (getFraction() == Fraction.black && getPosition().getX() > destination.getX())
            || (getFraction() == Fraction.white && getPosition().getX() < destination.getX())
            || (Math.abs(getPosition().getX() - destination.getX()) > 1 && getPosition().getX() != 1 && getFraction() == Fraction.black)
            || (Math.abs(getPosition().getX() - destination.getX()) > 1 && getPosition().getX() != 6 && getFraction() == Fraction.white)
            || (Math.abs(getPosition().getX() - destination.getX()) > 2 && getPosition().getX() == 6 && getFraction() == Fraction.white)
            || (Math.abs(getPosition().getX() - destination.getX()) > 2 && getPosition().getX() == 1 && getFraction() == Fraction.black)) {

            throw new ImpossibleMoveException();

        }

        Cell[] result;

        if (getPosition().getX() == 1 && destination.getX() == 3 && getFraction() == Fraction.black
         || getPosition().getX() == 6 && destination.getX() == 4 && getFraction() == Fraction.white) {

            result = new Cell[2];
            result[0] = new Cell(rule(getPosition().getX(), destination.getX()), getPosition().getY());
            result[1] = destination;

        } else {

            result = new Cell[1];

            result[0] = destination;

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
        return new Pawn(destination, this.getFraction());
    }

}