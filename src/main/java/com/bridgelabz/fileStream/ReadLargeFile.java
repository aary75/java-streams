package com.bridgelabz.fileStream;

import java.io.*;

public class ReadLargeFile {

    public static void main(String[] args) {
        // Path to the large file
        String filePath = "C:\\Users\\aarya\\Downloads\\Aaryan Resume.txt";  // Replace with the actual file path

        // Word to search for (case-insensitive)
        String keyword = "error";

        // Read the large file line by line
        readLargeFile(filePath, keyword);
    }

    // Method to read the file line by line and display lines containing "error"
    public static void readLargeFile(String filePath, String keyword) {
        long lineCount = 0;         // Total lines read
        long errorCount = 0;        // Matching lines count

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;

                // Check if the line contains the keyword (case-insensitive)
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("Line " + lineCount + ": " + line);
                    errorCount++;
                }
            }

            System.out.println("\nTotal lines read: " + lineCount);
            System.out.println("Matching lines containing '" + keyword + "': " + errorCount);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
//
//Total lines read: 91
//Matching lines containing 'error': 0