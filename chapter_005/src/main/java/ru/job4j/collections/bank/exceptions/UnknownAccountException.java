package ru.job4j.collections.bank.exceptions;

public class UnknownAccountException extends Exception {

    public UnknownAccountException() {
        super("There is no that account if this user.");
    }

}
