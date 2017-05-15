package ru.job4j.collections.bank.exceptions;

/**
 * This class throws if user do not contains to collection.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 15.05.2017
 */
public class UnknownUserException extends Exception {

    /**
     * constructor of class.
     */
    public UnknownUserException() {
        super("There is no that user in this map");
    }

}
