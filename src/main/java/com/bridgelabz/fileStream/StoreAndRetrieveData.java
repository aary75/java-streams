package com.bridgelabz.fileStream;

import java.io.*;

class Student {
    private int rollNumber;
    private String name;
    private double gpa;

    // Constructor
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

public class StoreAndRetrieveData {

    private static final String FILE_NAME = "students.dat";

    // Method to write student data to binary file
    public static void writeStudents(Student[] students) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {

            for (Student student : students) {
                dos.writeInt(student.getRollNumber());
                dos.writeUTF(student.getName());
                dos.writeDouble(student.getGpa());
            }

            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error while writing data: " + e.getMessage());
        }
    }

    // Method to read student data from binary file
    public static void readStudents() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {

            System.out.println("\nRetrieved Student Data:");

            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.printf("Roll: %d, Name: %s, GPA: %.2f%n", rollNumber, name, gpa);
            }

        } catch (IOException e) {
            System.err.println("Error while reading data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create sample student data
        Student[] students = {
                new Student(101, "Alice", 3.9),
                new Student(102, "Bob", 3.7),
                new Student(103, "Charlie", 4.0)
        };

        // Write and read student data
        writeStudents(students);
        readStudents();
    }
}

//Retrieved Student Data:
//Roll: 101, Name: Alice, GPA: 3.90
//Roll: 102, Name: Bob, GPA: 3.70
//Roll: 103, Name: Charlie, GPA: 4.00