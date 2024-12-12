package org.example;

public class Student {
    private String studentID; //Unik ID för varje student
    private String name; //Studentens namn
    private double grade; //Studentens betyg

    public Student(String studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    //Getters
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    //Override för att visa studenternas info.
    @Override
    public String toString(){
        return "ID: " + studentID + ", Name: " + name + ", grade " + grade;
    }
}
