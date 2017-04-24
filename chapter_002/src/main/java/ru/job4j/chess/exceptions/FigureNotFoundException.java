package ru.job4j.chess.exceptions;

/**
 * This exception throws if there is no figure on source cell of board.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class FigureNotFoundException extends Exception {

    /**
     * constructor with the message.
     */
    public FigureNotFoundException() {
        super("There is no figure in the cell.");
    }

}
