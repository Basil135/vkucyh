package ru.job4j.chess.exceptions;

/**
 * This exception throws if the figure on the board can not move to destination cell.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class ImpossibleMoveException extends Exception {

    /**
     * constructor with the message.
     */
    public ImpossibleMoveException() {
        super("Impossible move for this figure.");
    }

}
