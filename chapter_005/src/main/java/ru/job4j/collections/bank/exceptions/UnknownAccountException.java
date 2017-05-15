package ru.job4j.collections.bank.exceptions;

/**
 * This class is exception, if user vahe not searching account then it is throws.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 15.05.2017
 */
public class UnknownAccountException extends Exception {

    /**
     * constructor of class.
     */
    public UnknownAccountException() {
        super("There is no that account if this user.");
    }

}
