package ru.job4j.chapter002.multithreading.synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * This class describes simple class Count, it can increment private value by one and return this value.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.02.2018
 */
@ThreadSafe
public class Count {
    /**
     * parameter value is just integer number.
     */
    @GuardedBy("this")
    private int value;

    /**
     * method increment value by one.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * method return this value.
     *
     * @return this value
     */
    public synchronized int get() {
        return this.value;
    }
}
