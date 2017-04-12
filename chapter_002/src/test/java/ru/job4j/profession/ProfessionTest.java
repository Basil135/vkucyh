package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests class Profession.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class ProfessionTest {

    /**
     * This method tests method getName.
     */
    @Test
    public void whenNameJohnThenGetNameJohn() {

        Profession man = new Profession("John", "MSU", "doctor", 30);

        String expectedValue = "John";
        String actualValue = man.getName();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This metho tests method getDiploma.
     */
    @Test
    public void whenDiplomaMSUThenGetDiplomaMSU() {

        Profession man = new Profession("John", "MSU", "doctor", 30);

        String expectedValue = "MSU";
        String actualValue = man.getDiploma();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method getSpeciality.
     */
    @Test
    public void whenSpecialityDoctorThenGetSpecialityDoctor() {

        Profession man = new Profession("John", "MSU", "doctor", 30);

        String expectedValue = "doctor";
        String actualValue = man.getSpeciality();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method getWorkExp.
     */
    @Test
    public void whenWorkExpThirtyThenGetWorkExpThirty() {

        Profession man = new Profession("John", "MSU", "doctor", 30);

        int expectedValue = 30;
        int actualValue = man.getWorkExp();

        assertThat(actualValue, is(expectedValue));

    }

}