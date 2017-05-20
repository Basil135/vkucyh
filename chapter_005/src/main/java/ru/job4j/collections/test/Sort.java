package ru.job4j.collections.test;

import java.util.*;

/**
 * This class refactor and sort specialize array of strings.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 17.05.2017
 */
public class Sort {

    /**
     * parameter departmentSet is Set of departments.
     */
    private Set<Department> departmentSet = new TreeSet<>();

    /**
     * method refactor and sort specialize array.
     *
     * @param input is input string array
     * @param order is order to sort the array
     * @return refactored and sorted string array
     */
    public String[] sortArray(final String[] input, final Order order) {

        for (String str : input) {
            refactorSet(str, departmentSet);
        }

        makeOrder(departmentSet, order);

        return listToStringArray(departmentSet);

    }

    /**
     * method converts list of department to string array.
     *
     * @param set is input set of department
     * @return string array
     */
    private String[] listToStringArray(Set<Department> set) {

        String[] result = new String[set.size()];

        int index = 0;

        for (Department dep : set) {
            result[index++] = dep.getName();
        }

        return result;

    }

    /**
     * method add missing departments to list of department.
     *
     * @param input is input string
     * @param set is input set
     */
    private void refactorSet(String input, Set<Department> set) {

        StringBuilder department = new StringBuilder();

        for (String sub : input.split("\\\\")) {

            department.append(sub);

            if (!set.contains(new Department(department.toString()))) {
                set.add(new Department(department.toString()));
            }

            department.append("\\");

        }

    }

    /**
     * method sorts input list by input order.
     *
     * @param set is input set
     * @param order is input order
     */
    private void makeOrder(Set<Department> set, Order order) {

        if (order == Order.desc) {

            Set<Department> newSet = new TreeSet<>(cmpDesc());
            newSet.addAll(set);
            this.departmentSet = newSet;

        } else {

            Set<Department> newSet = new TreeSet<>(cmpAsc());
            newSet.addAll(set);
            this.departmentSet = newSet;

        }

    }

    /**
     * method return comparator to sorting by ascending order.
     *
     * @return comparator to asc order
     */
    private Comparator<Department> cmpAsc() {
        return new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    /**
     * method return comparator to sorting by descending order.
     *
     * @return comparator to desc order
     */
    private Comparator<Department> cmpDesc() {
        return new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                int len1 = o1.getName().length();
                int len2 = o2.getName().length();
                int lim = Math.min(len1, len2);

                char[] v1 = o1.getName().toCharArray();
                char[] v2 = o2.getName().toCharArray();

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
    }

    /**
     * nested class Order describes order to sort.
     */
    public enum Order {
        /**
         * parameters describes order to sort.
         */
        asc, desc;
    }

}
