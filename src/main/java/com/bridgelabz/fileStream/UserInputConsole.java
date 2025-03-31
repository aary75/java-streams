// Creating the UserInputConsole to write the user's input in file
package com.bridgelabz.fileStream;
import java.io.*;

public class UserInputConsole {
     public static void main(String[] args){
         // File name
         String fileName = "output.txt";

         try{
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             // Use true when you want to keep the existing data and add new data
             // Use false when you want to replace the old content entirely.

             FileWriter writer = new FileWriter(fileName, true);

             System.out.println("Enter your name: ");
             String name = reader.readLine();

             System.out.println("Enter your age: ");
             int age = Integer.parseInt(reader.readLine()); // Convert age into Integer

             System.out.println("Enter your favourite programming language: ");
             String language = reader.readLine();

             // Write this data into file
             writer.write("Name: " + name);
             writer.write("Age: " + age);
             writer.write("language: "+ language);

             System.out.println("Final file: " + fileName);
//             int byteCode;
//             FileInputStream file = new FileInputStream("output.txt");
//             while((byteCode = file.read()) != -1){
//                 System.out.println((char) byteCode);
//             }

         }
         catch(IOException e){
             System.out.println("An error occured during execution of file maybe file not found" + e.getMessage());
         }
         catch(NumberFormatException e){
             System.out.println("Invalid age format." + e.getMessage());
         }
     }
}
//
//Enter your name:
//Aaryan
//Enter your age:
//        23
//Enter your favourite programming language:
//Java
//Final file: output.txt