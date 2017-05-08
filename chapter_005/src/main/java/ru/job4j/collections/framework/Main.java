package ru.job4j.collections.framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is tests by hand of TimeTestCollection class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 05.05.2017
 */
public class Main {

    /**
     * parameter amount is how many strings add to a collection.
     */
    private static int amount = 1_000_000;

    /**
     * method main is start of a program.
     *
     * @param args is input arguments
     */
    public static void main(String[] args) {

        List<String> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>();
        Set<String> treeSet = new TreeSet<>();

        TimeTestCollection test = new TimeTestCollection();

        long linkedListAddTest;
        long arrayListAddTest;
        long treeSetAddTest;
        long linkedListDeleteTest;
        long arrayListDeleteTest;
        long treeSetDeleteTest;

        String[] line = strGen(amount);

        linkedListAddTest = test.add(linkedList, line, amount);
        arrayListAddTest = test.add(arrayList, line, amount);
        treeSetAddTest = test.add(treeSet, line, amount);

        for (int count = 0; count < amount; count++) {
            treeSet.add(String.valueOf(count));
        }

        linkedListDeleteTest = test.delete(linkedList, amount);
        arrayListDeleteTest = test.delete(arrayList, amount);
        treeSetDeleteTest = test.delete(treeSet, amount);

        System.out.println(String.format("linked list : add - %s | delete - %s", linkedListAddTest, linkedListDeleteTest));
        System.out.println(String.format("array list : add - %s | delete - %s", arrayListAddTest, arrayListDeleteTest));
        System.out.println(String.format("tree set : add - %s | delete - %s", treeSetAddTest, treeSetDeleteTest));

    }

    /**
     * method generate array of strings as amount numbers.
     *
     * @param amount is number of strings
     * @return array of strings
     */
    private static String[] strGen(final int amount) {

        String[] result = new String[amount];

        for (int count = 0; count < amount; count++) {
            result[count] = String.valueOf(System.currentTimeMillis() + Math.random());
        }

        return result;

    }

}
