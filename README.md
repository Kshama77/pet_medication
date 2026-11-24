# PetMedication - Pet Medication Tracker

A beginner-friendly Java console application to keep track of pet medications and schedules.

## Features
- Add a medication for a pet
- View all saved medication entries
- Search medication entries by pet name
- Mark a dose as given
- Remove a medication entry

## Concepts Used
- Classes and objects
- Variables and data types
- ArrayList
- Loops and conditional statements
- Methods
- Scanner for user input
- Getters and `toString()`

## Requirements
- Java JDK 8 or later

## How to Run

1. Download and extract `PetMedication.zip`.
2. Open Terminal or Command Prompt.
3. Go into the extracted project folder.
4. Compile the Java files:

```bash
javac -d out src/com/petmedication/*.java
```

5. Run the application:

```bash
java -cp out com.petmedication.Main
```

## Important Note
This is a simple learning project. Medication schedules and dose status are stored in memory only, so entries are cleared when the program closes. It is not a medical reminder system and does not provide veterinary dosing advice. Always follow your veterinarian's instructions.

## GitHub Upload
Create a new repository named `PetMedication`, then upload the extracted project files. Keep the `src` folder and `README.md` in the repository.
