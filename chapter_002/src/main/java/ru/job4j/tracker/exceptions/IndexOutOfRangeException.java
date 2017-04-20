package ru.job4j.tracker.exceptions;

/**
 * class exception throws when user type number out of menu.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 19.04.2017
 */
public class IndexOutOfRangeException extends Exception {

    /**
     * constructor set message to exception.
     *
     * @param msg info message
     */
    public IndexOutOfRangeException(String msg) {
        super(msg);
    }

}