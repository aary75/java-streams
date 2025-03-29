package com.bridgelabz.fileStream;
import java.io.*;

public class ReadAndWrite {
    public static void main(String[] args){

     try {

         FileInputStream fis = new FileInputStream("C:\\Users\\aarya\\Downloads\\Aaryan Resume.txt");
         FileOutputStream fos = new FileOutputStream("output.txt");

         int byteCode;
         while((byteCode = fis.read()) != -1){
             fos.write((char) byteCode);
         }

         System.out.println("File imported Successfully");
     }
     catch(IOException e){
         e.printStackTrace();
     }

    }
}