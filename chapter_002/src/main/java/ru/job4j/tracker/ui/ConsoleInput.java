package ru.job4j.tracker.ui;

import ru.job4j.tracker.controller.Input;

import java.util.Scanner;

/**
 * This class is implementation of interface input.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.04.2017
 */
public class ConsoleInput implements Input {

    /**
     * this scanner is is scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * method ask a user about what to do next.
     *
     * @param question is question about what to do next
     * @return String that we input
     */
    @Override
    public String ask(String question) {

        System.out.println(question);

        return scanner.nextLine();

    }

}
