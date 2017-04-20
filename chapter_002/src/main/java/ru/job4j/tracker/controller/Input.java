package ru.job4j.tracker.controller;

import ru.job4j.tracker.exceptions.IndexOutOfRangeException;

/**
 * This class is interface.
 */
public interface Input {

    /**
     * method ask a user what to do next.
     *
     * @param question is question
     * @return string
     */
    String ask(String question);

    /**
     * method ask a user what to do next and validate data in range.
     *
     * @param question is question
     * @param range is range of integer
     * @return integer
     * @throws IndexOutOfRangeException if users type invalid action
     */
    int ask(String question, int[] range) throws IndexOutOfRangeException;

}
