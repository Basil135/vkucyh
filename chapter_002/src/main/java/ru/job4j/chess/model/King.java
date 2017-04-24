package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This class describes the figure King of the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class King extends Figure {

    /**
     * constructor of this figure.
     *
     * @param position is the figure's position on the chess board
     * @param fraction is the fraction
     */
    public King(Cell position, Fraction fraction) {
        super(position, fraction);
    }

    /**
     * method describes figure's move.
     *
     * @param destination is cell as destination on the board
     * @return array of Cells as a way from position to destination
     * @throws ImpossibleMoveException if this figure can not move from position to destination
     */
    @Override
    Cell[] way(Cell destination) throws ImpossibleMoveException {

        int conditionX = Math.abs(position.getX() - destination.getX());
        int conditionY = Math.abs(position.getY() - destination.getY());

        if (conditionX == 0 && conditionY == 0 || conditionX > 1 || conditionY > 1) {
            throw new ImpossibleMoveException();
        }

        Cell[] result = new Cell[1];

        result[0] = destination;

        return result;

    }

}
