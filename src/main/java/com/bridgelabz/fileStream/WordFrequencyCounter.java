package com.bridgelabz.fileStream;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\aarya\\Downloads\\Aaryan Resume.txt";  // Replace with the actual file path

        // Count words and display the top 5 most frequent
        countWords(filePath);
    }

    // Method to count word occurrences and display the top 5 frequent words
    public static void countWords(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Read the file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split into words using regex to remove punctuation
                String[] words = line.toLowerCase().split("[\\W_]+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort the map by frequency
            List<Map.Entry<String, Integer>> sortedWords = wordCount.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .collect(Collectors.toList());

            // Display the top 5 frequent words
            System.out.println("\nTop 5 Most Frequent Words:");
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
//
//Top 5 Most Frequent Words:
//and → 8 times
//to → 6 times
//css → 5 times
//skills → 5 times
//in → 5 times


