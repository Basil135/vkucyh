package ru.job4j.collections.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * This class convert list of integers to double array and double array to list of integers.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 07.05.2017
 */
public class Convert {

    /**
     * method convert double array to list of integers.
     *
     * @param array is input double array
     * @return List of integers
     */
    public List<Integer> toList(int[][] array) {

        int size = array.length * array[0].length;

        List<Integer> result = new ArrayList<>(size);

        for (int[] row : array) {
            for (int num : row) {
                result.add(num);
            }
        }

        return result;

    }

    /**
     * method convert list of integers to double array with rows number of rows and fill of zeroes free spaces at cols.
     *
     * @param list is input list of integers
     * @param rows is input rows of double array
     * @return double array
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int index = 0;

        int cols = list.size() / rows + 1;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (index < list.size()) {

                    result[i][j] = list.get(index++);

                } else {

                    result[i][j] = 0;

                }

            }

        }

        return  result;

    }

    /**
     * method convert list of array of integers to list of integers.
     *
     * @param list is input list of array of integers
     * @return list of integers
     */
    public List<Integer> convert(List<int[]> list) {

        List<Integer> result = new ArrayList<>();

        for (int[] array : list) {

            for (int number : array) {

                result.add(number);

            }

        }

        return result;

    }

}
