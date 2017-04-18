package ru.job4j.tracker.controller;

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

}
