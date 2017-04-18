package ru.job4j.tracker.controller;

/**
 * This class uses for test.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.04.2017
 */
public class StubInput implements Input {

    /**
     * parameter answers uses to implement users input.
     */
    private String[] answers;
    /**
     * parameter index find need String from array of answers.
     */
    private int index = 0;

    /**
     * constructor of StubInput class.
     *
     * @param answers is array of answer
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * method return answer.
     *
     * @param question is question
     * @return answer
     */
    @Override
    public String ask(String question) {
        return answers[index++];
    }

}
