package ru.job4j.pro.list.cycle;

/**
 * This class describes action to find cycle in linked list.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.06.2017
 */
public class HasCycle {

    /**
     * method return true if list contains cycle.
     *
     * @param first is first node of list
     * @return true if list contains cycle
     */
    public boolean hasCycle(Node first) {

        Node turtle = first;
        Node hare = first.getNext();

        while (turtle != null || hare != null) {

            if (turtle == hare) {
                return true;
            }

            turtle = turtle.getNext();

            hare = hare.getNext();

            if (hare == null) {
                break;
            }

            hare = hare.getNext();

        }

        return false;

    }

}
