package ru.job4j.collections.bank.exceptions;

public class UnknownUserException extends Exception {

    public UnknownUserException() {
        super("There is no that user in this map");
    }

}
