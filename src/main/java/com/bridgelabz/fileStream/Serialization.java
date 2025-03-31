package com.bridgelabz.fileStream;
import java.util.*;
import java.io.*;

class Employee implements  Serializable{
   private static final long serialVersionUID = 1L;

   private  int id;
   private String name;
   private String department;
   private double salary;

   public Employee(int id, String name, String department, double salary){
       this.id = id;
       this.name = name;
       this.department = department;
       this.salary = salary;
   }

   @Override
    public String toString(){
       return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", salary: " + salary;
   }
}

public class Serialization {
    private static final String fileName = "output.txt";

    public static void serializeEmployees(List<Employee> employees){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Serialization successfully");
        } catch (IOException e){
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployee() {
        List<Employee> employees = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            employees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Successfully");
        } catch (IOException e){
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println("Error during desrialization: " + e.getMessage());
        }

        return employees;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.println("Enter employee details: ");
        while (true) {
            System.out.println("Enter ID: ");
            int id = scanner.nextInt();
            if (id == 0) break;

            scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            employeeList.add(new Employee(id, name, dept, salary));

        }

        serializeEmployees(employeeList);

        List<Employee> deserializedEmployees = deserializeEmployee();
        System.out.println("\nDeserialized Employee List:");
        for (Employee emp : deserializedEmployees){
            System.out.println(emp);
        }

        scanner.close();
    }
}


//Enter employee details:
//Enter ID:
//        1
//Enter name: Aaryan
//Enter Department: CSE
//Enter Salary: 200000
//Enter ID:
//        2
//Enter name: Anshika
//Enter Department: CWSE
//Enter Salary: 2200000
//Enter ID:
//        0
//Serialization successfully
//Deserialized Successfully
//
//Deserialized Employee List:
//ID: 1, Name: Aaryan, Dept: CSE, salary: 200000.0
//ID: 2, Name: Anshika, Dept: CWSE, salary: 2200000.0