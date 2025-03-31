// Creating BufferStream to compare BufferReader and FileReader
package com.bridgelabz.fileStream;
import  java.io.*;

public class BufferStream {
    // Finalize buffer array size
    private static final int bufferSize  = 4096;

    public static  void  main(String[] args){

        // Address of source and destination file
        String sourceFile = "C:\\Users\\aarya\\Downloads\\4114797-uhd_3840_2160_25fps.mp4";
        String destinationFile = "output.txt";

        long startTime = System.nanoTime();

        try{
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile));

            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            // Reading the file
            while ((bytesRead = bis.read(buffer)) != -1){
                bos.write(buffer, 0, bytesRead);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


        long endTime = System.nanoTime();
        double timeTaken  = (endTime - startTime);
        System.out.println("Buffered Copy Time:" + timeTaken + " ms");

        // Reading the file using FileReader
        long unBufferedStartTime = System.nanoTime();

        try{
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);

            int bytes;
            while((bytes = fis.read()) != -1){
                fos.write((char)bytes);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // Calculate the unBuffered TimeTaken
        long unBufferedEndTime = System.nanoTime();
        double unBufferedTimeTaken = (unBufferedEndTime - unBufferedStartTime);
        System.out.println("UnBuffered Copy Time:" + unBufferedTimeTaken);

        if(timeTaken > unBufferedTimeTaken){
            System.out.println("BufferReader is faster than fileReader");
        }
        else{
            System.out.println("FileReader is faster than BufferReader");
        }
    }
}
//
//Buffered Copy Time:1.521912E8 ms
//UnBuffered Copy Time:8.19550383E10
//BufferReader is faster than FileReader