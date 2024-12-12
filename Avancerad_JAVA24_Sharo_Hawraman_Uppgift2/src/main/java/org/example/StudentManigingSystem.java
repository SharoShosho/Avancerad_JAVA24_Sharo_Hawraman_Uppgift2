package org.example;

import java.io.*;
import java.util.HashMap;

public class StudentManigingSystem {
    private static StudentManigingSystem instance; //Singelton-Instance
    private HashMap<String,Student> students; //Datastruktur för att lagra studentposter (Hashmap)


    //Privat konstruktor
    private StudentManigingSystem(){
        students = new HashMap<>();
    }

    //Static metod för att hämta Singelton
    public static StudentManigingSystem getInstance() {
        if (instance == null); {
            instance = new StudentManigingSystem();
        }
        return instance;
    }

    //Lägger till en ny studentpost
    public void addStudent (String studentID, String name, double grade){
        students.put(studentID,new Student(studentID,name,grade)); //Lägger till student i hashmap
    }

//Sparar alla studentposter till en fil
    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (Student student : students.values()){
                writer.write(student.getStudentID() + "," + student.getName() + "," + student.getGrade());
                writer.newLine(); //Varje student sparas på en ny rad
            }
        }
    }

    //Läs studentposter från en fil och lägg till dem i systemet
    public void loadFromFile(String filename) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
         String line;
         while ((line = reader.readLine()) != null){
             String[] parts = line.split(","); //Delar raden Id,namn och betyg
             if (parts.length == 3 ){
                 addStudent(parts[0], parts[1], Double.parseDouble(parts[2])); //Lägger till i minne
             }
         }
        }
    }

    //Sök på en student baserat på ID
    public Student searchByID(String studentID){
        return students.get(studentID);
    }

    // Visar alla studenter i systemet
    public void displayAllStudents(){
        for (Student student : students.values()){
            System.out.println(student); //Skriver ut varje students detaljer
        }
    }
}
