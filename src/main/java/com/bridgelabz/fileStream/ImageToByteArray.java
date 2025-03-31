package com.bridgelabz.fileStream;
import  java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageToByteArray {
         public static byte[] imageToByteArray(String imagePath) throws IOException {
             File file = new File(imagePath);
             try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                 byte[] buffer = new byte[1024];
                 int bytesRead;

                 while((bytesRead = fis.read(buffer)) != -1) {
                     baos.write(buffer, 0, bytesRead);
                 }

                 System.out.println("Image Converted");
                 return baos.toByteArray();
             }
         }

         public static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException{

             try(ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

                 byte[] buffer = new byte[1024];
                 int bytesRead;

                 while((bytesRead = bais.read(buffer)) != -1) {
                     fos.write(buffer, 0, bytesRead);
                 }

                 System.out.println("Byte array written back to image successfully");
             }
         }

         public static boolean areImageIdentical(String path1, String path2) throws  IOException{
             byte[] file1 = Files.readAllBytes(new File(path1).toPath());
             byte[] file2 = Files.readAllBytes(new File(path2).toPath());
             return  Arrays.equals(file1,file2);
         }

         public static void main(String[] args){

             String inputImagePath = "C:\\Users\\aarya\\Downloads\\Aaryan Photo.pdf";
             String outputImagePath = "output.jpg";

             try {
                 byte[] imageBytes = imageToByteArray(inputImagePath);

                 byteArrayToImage(imageBytes, outputImagePath);

                 boolean identical = areImageIdentical(inputImagePath, outputImagePath);

                 System.out.println("\nVerification: Images are " + (identical ? "identical" :"different"));
             }
             catch (IOException e){
                 System.out.println("Error: " + e.getMessage());
             }
         }
}

//Image Converted
//Byte array written back to image successfully
//
//Verification: Images are identical