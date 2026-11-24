package com.petmedication;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Medication> medications = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=================================");
        System.out.println("       PET MEDICATION TRACKER");
        System.out.println("=================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1: addMedication(); break;
                case 2: viewMedications(); break;
                case 3: searchByPet(); break;
                case 4: markDoseGiven(); break;
                case 5: removeMedication(); break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using PetMedication!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-6.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--------------- MENU ---------------");
        System.out.println("1. Add medication");
        System.out.println("2. View all medications");
        System.out.println("3. Search medications by pet");
        System.out.println("4. Mark dose as given");
        System.out.println("5. Remove medication");
        System.out.println("6. Exit");
        System.out.println("------------------------------------");
    }

    private static void addMedication() {
        System.out.println("\n--- Add Medication ---");
        System.out.print("Pet name: ");
        String petName = scanner.nextLine().trim();
        System.out.print("Medication name: ");
        String medicationName = scanner.nextLine().trim();
        System.out.print("Dosage (example: 1 tablet): ");
        String dosage = scanner.nextLine().trim();
        System.out.print("Schedule (example: Every morning): ");
        String schedule = scanner.nextLine().trim();
        System.out.print("Start date (example: 2026-11-24): ");
        String startDate = scanner.nextLine().trim();
        System.out.print("Notes (or leave blank): ");
        String notes = scanner.nextLine().trim();

        if (petName.isEmpty() || medicationName.isEmpty() || dosage.isEmpty()
                || schedule.isEmpty() || startDate.isEmpty()) {
            System.out.println("Pet, medication, dosage, schedule, and start date are required.");
            return;
        }

        medications.add(new Medication(petName, medicationName, dosage, schedule, startDate, notes));
        System.out.println("Medication added successfully!");
    }

    private static void viewMedications() {
        System.out.println("\n--- All Medications ---");
        if (medications.isEmpty()) {
            System.out.println("No medications have been added yet.");
            return;
        }
        for (int i = 0; i < medications.size(); i++) {
            System.out.println("\nMedication ID: " + (i + 1));
            System.out.println(medications.get(i));
        }
    }

    private static void searchByPet() {
        System.out.print("\nEnter pet name: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < medications.size(); i++) {
            Medication medication = medications.get(i);
            if (medication.getPetName().equalsIgnoreCase(searchName)) {
                System.out.println("\nMedication ID: " + (i + 1));
                System.out.println(medication);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medications found for " + searchName + ".");
        }
    }

    private static void markDoseGiven() {
        viewMedications();
        if (medications.isEmpty()) return;

        int id = readInt("\nEnter medication ID to mark as given: ");
        if (id < 1 || id > medications.size()) {
            System.out.println("Invalid medication ID.");
            return;
        }
        medications.get(id - 1).markDoseGiven();
        System.out.println("Dose marked as given for " + medications.get(id - 1).getPetName() + ".");
    }

    private static void removeMedication() {
        viewMedications();
        if (medications.isEmpty()) return;

        int id = readInt("\nEnter medication ID to remove: ");
        if (id < 1 || id > medications.size()) {
            System.out.println("Invalid medication ID.");
            return;
        }
        Medication removed = medications.remove(id - 1);
        System.out.println(removed.getMedicationName() + " was removed.");
    }

    private static int readInt(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }
}
