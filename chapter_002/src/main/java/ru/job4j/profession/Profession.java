package ru.job4j.profession;

/**
 * This class is main class in profession.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class Profession {

    /**
     * This param is name.
     */
    private String name;

    /**
     * This param is diploma.
     */
    private String diploma;

    /**
     * This param is speciality.
     */
    private String speciality;

    /**
     * This param is work experience.
     */
    private int workExp;

    /**
     * This is the constructor of the class Profession.
     *
     * @param name is name
     * @param diploma is diploma
     * @param speciality is speciality
     * @param workExp is work experience
     */
    public Profession(String name, String diploma, String speciality, int workExp) {
        this.name = name;
        this.diploma = diploma;
        this.speciality = speciality;
        this.workExp = workExp;
    }

    /**
     * This method returns name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns diploma.
     *
     * @return diploma
     */
    public String getDiploma() {
        return diploma;
    }

    /**
     * This method returns speciality.
     *
     * @return speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * This method returns work experience.
     *
     * @return work experience
     */
    public int getWorkExp() {
        return workExp;
    }
}