package com.petmedication;

public class Medication {
    private String petName;
    private String medicationName;
    private String dosage;
    private String schedule;
    private String startDate;
    private String notes;
    private boolean doseGiven;

    public Medication(String petName, String medicationName, String dosage,
                      String schedule, String startDate, String notes) {
        this.petName = petName;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.schedule = schedule;
        this.startDate = startDate;
        this.notes = notes;
        this.doseGiven = false;
    }

    public String getPetName() {
        return petName;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void markDoseGiven() {
        doseGiven = true;
    }

    @Override
    public String toString() {
        return "Pet: " + petName
                + "\nMedication: " + medicationName
                + "\nDosage: " + dosage
                + "\nSchedule: " + schedule
                + "\nStart Date: " + startDate
                + "\nNotes: " + (notes.isEmpty() ? "None" : notes)
                + "\nDose Given: " + (doseGiven ? "Yes" : "No");
    }
}
