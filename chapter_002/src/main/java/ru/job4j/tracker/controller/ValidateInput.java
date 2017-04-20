package ru.job4j.tracker.controller;

import ru.job4j.tracker.exceptions.IndexOutOfRangeException;
import ru.job4j.tracker.ui.ConsoleInput;

/**
 * This class validate input data.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 19.04.2017
 */
public class ValidateInput extends ConsoleInput {

    /**
     * method override method ask from ConsoleInput class and validate data.
     *
     * @param question is question to user
     * @param range is array of valid actions as integer
     * @return integer as action
     * @throws IndexOutOfRangeException
     */
    @Override
    public int ask(String question, int[] range) throws IndexOutOfRangeException {

        int result = -1;
        boolean invalid = true;

        do {
            try {
                result = super.ask(question, range);
                invalid = false;
            } catch (IndexOutOfRangeException e) {
                System.out.println("Please type correct menu option!");
            } catch (NumberFormatException e) {
                System.out.println("Please type correct data!");
            }

        } while (invalid);

        return result;

    }

}
