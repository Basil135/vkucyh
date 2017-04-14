package ru.job4j.strategy;

/**
 * This class generate string as a figure square.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.04.2017
 */
public class Square implements IShape {

    /**
     * method generate string as a figure square.
     *
     * @return generated string
     */
    @Override
    public String pic() {

        StringBuilder sb = new StringBuilder();

        sb.append("**********\n");
        sb.append("*        *\n");
        sb.append("*        *\n");
        sb.append("*        *\n");
        sb.append("*        *\n");
        sb.append("**********\n");

        return sb.toString();
    }

}
