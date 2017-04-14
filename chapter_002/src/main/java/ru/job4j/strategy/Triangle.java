package ru.job4j.strategy;

/**
 * This class generate string as figure triangle.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.04.2017
 */
public class Triangle implements IShape {

    /**
     * method generate string as figure triangle.
     *
     * @return generated string
     */
    @Override
    public String pic() {

        StringBuilder sb = new StringBuilder();

        sb.append("     *     \n");
        sb.append("    ***    \n");
        sb.append("   *****   \n");
        sb.append("  *******  \n");
        sb.append(" ********* \n");
        sb.append("***********\n");

        return sb.toString();

    }

}
