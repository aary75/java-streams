package com.bridgelabz.fileStream;

import java.io.*;

public class PippedStreamExample {

    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);  // Connect the streams

            // Create and start the writer and reader threads
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

            // Join threads to ensure they finish execution
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// Writer class - Writes data to the PipedOutputStream
class Writer implements Runnable {
    private PipedOutputStream outputStream;

    public Writer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try (DataOutputStream dos = new DataOutputStream(outputStream)) {
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i;
                dos.writeUTF(message);
                System.out.println("Written: " + message);
                Thread.sleep(500);  // Simulate delay
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Writer Error: " + e.getMessage());
        }
    }
}

// Reader class - Reads data from the PipedInputStream
class Reader implements Runnable {
    private PipedInputStream inputStream;

    public Reader(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(inputStream)) {
            for (int i = 1; i <= 5; i++) {
                String message = dis.readUTF();
                System.out.println("Read: " + message);
                Thread.sleep(700);  // Simulate processing delay
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Reader Error: " + e.getMessage());
        }
    }
}


