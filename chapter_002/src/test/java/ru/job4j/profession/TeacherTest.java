package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests Teacher class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class TeacherTest {

    /**
     * This method tests method teach.
     */
    @Test
    public void whenJohnTeachLisaThenTeachReturnJohnTeachLisa() {

        Teacher john = new Teacher("John", "MSU", "mathematician", 25);

        String expectedValue = "John teach Lisa";
        String actualValue = john.teach(new Student("Lisa"));

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method exam.
     */
    @Test
    public void whenJohnExamLisaThenExamReturnJohnExamLisa() {

        Teacher john = new Teacher("John", "MSU", "mathematician", 25);

        String expectedValue = "John examinate Lisa";
        String actualValue = john.exam(new Student("Lisa"));

        assertThat(actualValue, is(expectedValue));

    }

}
