package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class howToParseUrl {
    public static void main(String[] args) {
        String fileContent = "Welcome to gfg";
        FileOutputStream outputStream = null;
        try{

            outputStream = new FileOutputStream("file.txt");
            byte[] strToBytes =  fileContent.getBytes(StandardCharsets.UTF_8);
            outputStream.write(strToBytes);

            System.out.println("File  is created successfully...");



        }
        catch (IOException e) {
            System.out.println(e.getMessage()+" ");
        }
        finally {
            if(outputStream!=null){
                try{
                    outputStream.close();
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    }

