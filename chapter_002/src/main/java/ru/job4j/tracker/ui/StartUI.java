package ru.job4j.tracker.ui;

import ru.job4j.tracker.controller.IAction;
import ru.job4j.tracker.controller.Input;
import ru.job4j.tracker.controller.Tracker;
import ru.job4j.tracker.controller.UserAction;
import ru.job4j.tracker.controller.ValidateInput;
import ru.job4j.tracker.exceptions.IndexOutOfRangeException;

/**
 * This class contain main method.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 18.04.2017
 */
public class StartUI {

    /**
     * user's selection of menu.
     */
    private int key;
    /**
     * object of interface Input.
     */
    private Input input;
    /**
     * object of class Tracker.
     */
    private Tracker tracker;

    /**
     * method main.
     *
     * @param args input arguments
     * @throws IndexOutOfRangeException if users type invalid action
     */
    public static void main(String[] args) throws IndexOutOfRangeException {


        Input input = new ValidateInput();
        Tracker tracker = new Tracker();

        StartUI startUI = new StartUI(input, tracker);

        startUI.init();

    }

    /**
     * constructor.
     *
     * @param input is object of interface Input
     * @param tracker is object of class Tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method initializes class.
     *
     * @throws IndexOutOfRangeException if users type invalid action
     */
    public void init() throws IndexOutOfRangeException {

        UserAction userAction = new UserAction(this.input, this.tracker);
        userAction.fillActions();

        do {

            System.out.println(userAction.actionsToString());

            key = Integer.valueOf(input.ask("\nplease type your key:\n", userAction.getRangeOfActions()));

            IAction action = userAction.select(key);
            System.out.println(action.execute(input, tracker));

        } while (key != 6);

    }

}
