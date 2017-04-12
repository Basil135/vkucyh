package ru.job4j.profession;

/**
 * This class contains methods to heal the people.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class Doctor extends Profession {

    /**
     * This is constructor of the Doctor class.
     *
     * @param name is Name of the doctor
     * @param diploma is diploma of the doctor
     * @param speciality is a speciality of the doctor
     * @param workExp is the work experience of the doctor
     */
    public Doctor(String name, String diploma, String speciality, int workExp) {
        super(name, diploma, speciality, workExp);
    }

    /**
     * This method heal the patient by a medical preparations.
     *
     * @param patient is the patient of the doctor
     * @return string doctor heal patient by medical preparations
     */
    public String medication(Patient patient) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" heal ");
        builder.append(patient.getName());
        builder.append(" by medical preparations");

        result = builder.toString();

        return result;

    }

    /**
     * This method surgery operation with the patient.
     *
     * @param patient is the patient of the doctor
     * @return string doctor surgery operation with patient
     */
    public String surgeryOperation(Patient patient) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" surgery operation with ");
        builder.append(patient.getName());

        result = builder.toString();

        return result;

    }

    /**
     * This method resuscitation of the patient.
     *
     * @param patient is the patient of the doctor
     * @return string doctor resuscitation patient
     */
    public String resuscitation(Patient patient) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" resuscitation ");
        builder.append(patient.getName());

        result = builder.toString();

        return result;

    }

    /**
     * This method inspect the patient.
     *
     * @param patient is the patient of the doctor
     * @return string doctor inspect patient
     */
    public String inspectionPatient(Patient patient) {

        String result;
        StringBuilder builder = new StringBuilder();

        builder.append(this.getName());
        builder.append(" inspect patient ");
        builder.append(patient.getName());

        result = builder.toString();

        return result;

    }

}
