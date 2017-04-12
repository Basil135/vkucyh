package ru.job4j.profession;

/**
 * This class is class of a profession engineer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class Engineer extends Profession {

    /**
     * This is the constructor of Engineer class.
     *
     * @param name is the name
     * @param diploma is the diploma
     * @param speciality is the speciality
     * @param workExp is the work experience
     */
    public Engineer(String name, String diploma, String speciality, int workExp) {
        super(name, diploma, speciality, workExp);
    }

    /**
     * This is method construct, it returns just a string.
     *
     * @param object is the string name of object
     * @return just a string
     */
    public String construct(Building object) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" construct the ");
        builder.append(object.getName());

        result = builder.toString();

        return result;

    }

    /**
     * This is method destruct, it returns just a string.
     *
     * @param object is the name of a object
     * @return just a string
     */
    public String destruct(Building object) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" destruct the ");
        builder.append(object.getName());

        result = builder.toString();

        return result;

    }

    /**
     * This is the method analysis, it analise an object.
     *
     * @param object is the name of an object
     * @return just a string
     */
    public String analysis(Building object) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" analise the ");
        builder.append(object.getName());

        result = builder.toString();

        return result;

    }

}
