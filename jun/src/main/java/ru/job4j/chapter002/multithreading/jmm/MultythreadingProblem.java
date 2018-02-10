package ru.job4j.chapter002.multithreading.jmm;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes problems with multithreading.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.02.2018
 */
public class MultythreadingProblem {
    /**
     * parameter number, just number.
     */
    private int number = 1;
    /**
     * parameter list of numbers.
     */
    private List<Integer> numbers = new ArrayList<>();

    /**
     * methods demonstrate that is bad when threads too much.
     */
    public void tooManyThreads() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * method demonstrate that modification variable is unsafe.
     *
     * @throws InterruptedException when thread interrupt
     */
    public void incorrectData() throws InterruptedException {

        //int number = 1;

        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    numbers.add(number++);
                }
            }
        });

        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    numbers.add(number++);
                }
            }
        });

        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(numbers);

    }

    /**
     * method start the program.
     *
     * @param args is input arguments
     * @throws InterruptedException when thread interrupt
     */
    public static void main(String[] args) throws InterruptedException {
        MultythreadingProblem problems = new MultythreadingProblem();
        problems.incorrectData();
    }

}
