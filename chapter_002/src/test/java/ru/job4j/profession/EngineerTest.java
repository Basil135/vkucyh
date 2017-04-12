package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests engineer class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class EngineerTest {

    /**
     * This method tests method construct.
     */
    @Test
    public void whenBobConstructTheBuildingThenConstructReturnBobConstructTheBuilding() {

        Engineer bob = new Engineer("Bob", "MSU", "engineer", 10);

        String expectedValue = "Bob construct the home";
        String actualValue = bob.construct(new Building("home"));

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method destruct.
     */
    @Test
    public void whenBobDestructTheBuildingThenDestructReturnBobDestructTheBuilding() {

        Engineer bob = new Engineer("Bob", "MSU", "engineer", 10);

        String expectedValue = "Bob destruct the home";
        String actualValue = bob.destruct(new Building("home"));

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method analysis.
     */
    @Test
    public void whenBobAnaliseTheBuildingThenAnalisysReturnBobAnaliseTheBuilding() {

        Engineer bob = new Engineer("Bob", "MSU", "engineer", 10);

        String expectedValue = "Bob analise the home";
        String actualValue = bob.analysis(new Building("home"));

        assertThat(actualValue, is(expectedValue));

    }

}
