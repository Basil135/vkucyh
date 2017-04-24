package ru.job4j.chess.exceptions;

/**
 * This exception throws if there is a figure on the way of this figure's move.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class OccupiedWayException extends Exception {

    /**
     * constructor with the message.
     */
    public OccupiedWayException() {
        super("There is figure in this way.");
    }

}
