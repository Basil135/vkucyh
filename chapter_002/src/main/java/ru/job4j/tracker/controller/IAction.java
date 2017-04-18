package ru.job4j.tracker.controller;

/**
 * interface for user's action.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.tu)
 * @version $Id$
 * @since 18.04.2017
 */
public interface IAction {

    /**
     * method execute the action.
     *
     * @param input object of interface Input
     * @param tracker object of class Tracker
     * @return item as String
     */
    String execute(Input input, Tracker tracker);

    /**
     * method return number as key of action.
     *
     * @return number as key of action
     */
    int key();

    /**
     * method return info of action.
     *
     * @return String info
     */
    String info();

}
