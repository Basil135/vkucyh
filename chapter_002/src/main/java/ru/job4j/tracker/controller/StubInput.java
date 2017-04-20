package ru.job4j.tracker.controller;

import ru.job4j.tracker.exceptions.IndexOutOfRangeException;

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

    /**
     * method ask data from user and validate this data to actions.
     *
     * @param question is question
     * @param range is range of integer
     * @return
     * @throws IndexOutOfRangeException
     */
    @Override
    public int ask(String question, int[] range) throws IndexOutOfRangeException {

        boolean exist = false;

        int key = Integer.valueOf(ask(question));

        for (int value : range) {

            if (value == key) {
                exist = true;
                break;
            }

        }

        if (exist) {
            return key;
        } else {
            throw new IndexOutOfRangeException("Incorrect menu action.");
        }

    }

}
