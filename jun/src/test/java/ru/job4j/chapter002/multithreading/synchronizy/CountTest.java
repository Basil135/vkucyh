package ru.job4j.chapter002.multithreading.synchronizy;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * This class tests Count class.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.02.2018
 */
public class CountTest {

    /**
     * inner class extends Thread override method run to interact with class Count by many Threads.
     */
    private class ThreadCount extends Thread {
        /**
         * parameter count is instance of class Count.
         */
        private final Count count;

        /**
         * constructor of inner class - ThreadCount.
         *
         * @param count instance of class Count
         */
        ThreadCount(final Count count) {
            this.count = count;
        }

        /**
         * method override run method of class Thread.
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }

    /**
     * method tests two Threads with one instance of Count class.
     *
     * @throws InterruptedException throws if threads will be interrupted
     */
    @Test
    public void whenExec2ThreadThen2() throws InterruptedException {

        final Count count = new Count();

        ThreadCount first = new ThreadCount(count);
        ThreadCount second = new ThreadCount(count);

        first.start();
        second.start();

        first.join();
        second.join();

        int expected = 2;
        int actual = count.get();

        Assert.assertThat(actual, is(expected));

    }
}