package ru.job4j.pro.generic;

/**
 * This abstract class have teo abstract methods getId and setId.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @version 22.05.2017
 */
public abstract class Base {

    /**
     * abstract method getId return id as A String.
     *
     * @return String Id
     */
    abstract String getId();

    /**
     * abstract method setId is setting id.
     *
     * @param id is identification string
     */
    abstract void setId(String id);

}
