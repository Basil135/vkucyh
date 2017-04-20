package ru.job4j.chess.exceptions;

public class OccupiedWayException extends Exception {

    public OccupiedWayException() {
        super("There is figure in this way.");
    }

}
