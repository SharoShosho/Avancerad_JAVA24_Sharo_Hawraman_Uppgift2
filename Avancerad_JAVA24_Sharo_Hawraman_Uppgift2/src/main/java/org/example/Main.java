package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManigingSystem system = StudentManigingSystem.getInstance(); //Hämtar singleton
        Scanner scanner = new Scanner(System.in);//För användningsinmatning
        String filename = "students.txt"; //filen för lagring


        //Meny loop
        while (true){
            //Visa menyn
            System.out.println("\n--- Student Manegment System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Save Students to file");
            System.out.println("3. Load Students from file");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");


            int choice = scanner.nextInt();//Läs användarens val
            scanner.nextLine();//Rensa inmatningsbufferten

            try {
                switch (choice){
                    case 1:
                        //Lägg till ny student
                        System.out.println("Enter students ID: ");
                        String studentId = scanner.nextLine();
                        System.out.println("Enter students name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter students grade: ");
                        double grade = scanner.nextDouble();
                        system.addStudent(studentId,name,grade);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        //Spara student till fil
                        system.saveToFile(filename);
                        System.out.println("Student saved to file.");
                        break;

                    case 3:
                        //Läs studenter från fil
                        system.loadFromFile(filename);
                        System.out.println("Students loaded from file.");
                        break;

                    case 4:
                        //Söker studenter med ID
                        System.out.println("Enter students ID to search: ");
                        studentId = scanner.nextLine();
                        Student student = system.searchByID(studentId);
                        if (student != null){
                            System.out.println("Student found: " + student);

                        }else{
                            System.out.println("Student not found!");
                        }
                        break;

                    case 5:
                        //Visa alla studenter i konsolen
                        system.displayAllStudents();
                        break;

                    case 6:
                        //Avsluta programmet
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        //Hanterar ogiltigt val
                        System.out.println("Invalid choice! Please try again.");

                }

            }catch (Exception e){
                System.out.println("Error: " + e.getMessage()); //Fel hantering
            }
        }
    }
}