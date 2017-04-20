package ru.job4j.chess.exceptions;

public class FigureNotFoundException extends Exception {

    public FigureNotFoundException() {
        super("There is no figure in the cell.");
    }

}
