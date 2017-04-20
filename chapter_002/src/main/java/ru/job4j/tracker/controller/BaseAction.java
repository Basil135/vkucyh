package ru.job4j.tracker.controller;

/**
 * abstract class implement method info of interface IAction, other methods are abstract.
 */
abstract class BaseAction implements IAction {

    /**
     * parameter message that print info about action.
     */
    private final String msg;

    /**
     * constructor of abstract class.
     *
     * @param msg message that print about action
     */
    BaseAction(final String msg) {
        this.msg = msg;
    }

    /**
     * method execute the action.
     *
     * @param input object of interface Input
     * @param tracker object of class Tracker
     * @return item as String
     */
    @Override
    public abstract String execute(Input input, Tracker tracker);

    /**
     * method return number as key of action.
     *
     * @return number as key of action
     */
    @Override
    public abstract int key();

    /**
     * method return info of action.
     *
     * @return String info
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), msg);
    }

}
