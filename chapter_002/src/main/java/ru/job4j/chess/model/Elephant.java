package ru.job4j.chess.model;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * This class describes figure of elephant at the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.04.2017
 */
public class Elephant extends Figure {

    /**
     * constructor of class Elephant.
     *
     * @param position is position of the figure
     */
    public Elephant(Cell position) {
        super(position);
    }

    /**
     * method look the way to destination cell.
     *
     * @param destination is cell as destination on the board.
     * @return array of cell as the way to destination
     * @throws ImpossibleMoveException if this figure can't move to destination cell
     */
    @Override
    public Cell[] way(Cell destination) throws ImpossibleMoveException {

        int testX = destination.getX() - position.getX();
        int testY = destination.getY() - position.getY();

        if (testX != testY) {
            throw new ImpossibleMoveException();
        }

        int lengthOfResult = Math.abs(testX);

        Cell[] result = new Cell[lengthOfResult];

        if (position.getX() == destination.getX()) {
            result = new Cell[0];
        } else if (position.getX() < destination.getX()) {

            result[0] = position;

            for (int count = 1; count <= lengthOfResult; count++) {
                Cell newCell = new Cell(result[count - 1].getX() + 1, result[count - 1].getY() + 1);
                result[count] = newCell;
            }

        } else {

            result[0] = position;

            for (int count = 1; count <= lengthOfResult; count++) {
                Cell newCell = new Cell(result[count - 1].getX() - 1, result[count - 1].getY() - 1);
                result[count] = newCell;
            }

        }

        return result;

    }

}
