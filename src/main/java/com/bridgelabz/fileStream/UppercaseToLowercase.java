// Creating the File UppercaseToLowerCase to convert from upper case to lower case
package com.bridgelabz.fileStream;
import java.io.*;

public class UppercaseToLowercase {

    // Method to convert uppercase to lowercase
    public static void convertToLowercase(String inputFile, String outputFile) {
        try (
                // Use InputStreamReader and OutputStreamWriter to handle encoding
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();  // Add newline for each line
            }

            System.out.println("Conversion successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "C:\\Users\\aarya\\Downloads\\Aaryan Resume.txt";
        String outputFile = "output.txt";

        // Perform conversion
        convertToLowercase(inputFile, outputFile);
    }
}

//Conversion successfully.


