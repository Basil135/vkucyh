package ru.job4j.profession;

/**
 * This class is class of profession teacher.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class Teacher extends Profession {

    /**
     * This is constructor of teacher.
     *
     * @param name is the name of the teacher
     * @param diploma is the diploma of the teacher
     * @param speciality is the speciality of the teacher
     * @param workExp is the work experience of the teacher
     */
    public Teacher(String name, String diploma, String speciality, int workExp) {
        super(name, diploma, speciality, workExp);
    }

    /**
     * This method teach a student.
     *
     * @param student is the name of a student
     * @return just a string
     */
    public String teach(Student student) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" teach ");
        builder.append(student.getName());

        result = builder.toString();

        return result;

    }

    /**
     * This method exam a student.
     *
     * @param student is the name of a student
     * @return just a string
     */
    public String exam(Student student) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" examinate ");
        builder.append(student.getName());

        result = builder.toString();

        return result;

    }

}
