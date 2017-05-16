package ru.job4j.collections.test;

import org.jetbrains.annotations.Contract;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class uses for sort and refactor input array of strings.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 16.05.2017
 */
public class SortArray {

    /**
     * method for hand test.
     *
     * @param args is input array of args
     */
    public static void main(String[] args) {

        Comparator<String> more = new Comparator<String>() {
            @Contract(pure = true)
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<String> less = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                int lim = Math.min(len1, len2);

                char[] v1 = o1.toCharArray();
                char[] v2 = o2.toCharArray();

                int k = 0;
                while (k < lim) {
                    char c1 = v1[k];
                    char c2 = v2[k];
                    if (c1 != c2) {
                        return c2 - c1;
                    }
                    k++;
                }
                return len1 - len2;
            }
        };

        SortArray sa = new SortArray();

        String[] array = {"K1\\S1\\SS1", "K1\\S1\\SS2", "K1\\S2\\SS1", "K2\\S1\\SS1", "K2\\S2\\SS1", "K2\\S2\\SS2"};

        for (String str : sa.sort(array, more)) {
            System.out.println(str);
        }

    }

    /**
     * method sort and refactor input array of strings by a collection TreeSet.
     *
     * @param inputArray is input array of strings
     * @param comparator is comparator to sort an array
     * @return sorted array of strings
     */
    public String[] sort(final String[] inputArray, Comparator comparator) {

        String[] result = new String[inputArray.length];

        Set<String> col = new TreeSet<>(comparator);

        for (String str : inputArray) {

            for (int count = 0; count <= countOfSeparate(str); count++) {
                col.add(subStr(str, count));
            }

        }

        result = col.toArray(result);

        return result;

    }

    /**
     * method count all separator.
     *
     * @param input is input string
     * @return integer as count of separator
     */
    private int countOfSeparate(String input) {
        int result = 0;
        for (char ch : input.toCharArray()) {
            if (ch == '\\') {
                result++;
            }
        }
        return result;
    }

    /**
     * method return substring of input string from began string before need separator.
     *
     * @param input is input string
     * @param countOfSeparator number of separator input in substring
     * @return substring of input string
     */
    private String subStr(String input, int countOfSeparator) {
        int sep = 0;
        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();

        for (int count = 0; count < array.length; count++) {
            if (array[count] == '\\') {
                sep++;
            }
            if (sep > countOfSeparator) {
                break;
            }
            sb.append(array[count]);
        }

        return sb.toString();
    }

}