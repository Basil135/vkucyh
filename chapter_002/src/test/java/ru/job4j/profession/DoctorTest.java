package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests class Doctor.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.04.2017
 */
public class DoctorTest {

    /**
     * This method tests method medication.
     */
    @Test
    public void whenDoctorMedicationPatientThenDoctorHealPatientByAMedicalPreparations() {

        Doctor lisa = new Doctor("Lisa", "MSU", "cardio", 23);

        String expectedValue = "Lisa heal John by medical preparations";
        String actualValue = lisa.medication("John");

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method inspectionPatient.
     */
    @Test
    public void whenDoctorInspectionPatientThenDoctorInspectPatient() {

        Doctor lisa = new Doctor("Lisa", "MSU", "cardio", 23);

        String expectedValue = "Lisa inspect patient John";
        String actualValue = lisa.inspectionPatient("John");

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method resuscitation.
     */
    @Test
    public void whenDoctorResuscitationPatientThenDoctorResuscitationPatient() {

        Doctor lisa = new Doctor("Lisa", "MSU", "cardio", 23);

        String expectedValue = "Lisa resuscitation John";
        String actualValue = lisa.resuscitation("John");

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * This method tests method surgeryOperation.
     */
    @Test
    public void whenDoctorSurgeryOperationPatientThenDoctorSurgeryOperationWithPatient() {

        Doctor lisa = new Doctor("Lisa", "MSU", "cardio", 23);

        String expectedValue = "Lisa surgery operation with John";
        String actualValue = lisa.surgeryOperation("John");

        assertThat(actualValue, is(expectedValue));

    }

}
