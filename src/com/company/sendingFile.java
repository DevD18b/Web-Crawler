package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class sendingFile {
    private static String topstring = "<!doctype html>" + "\n" + "<html>" +
            "\n" + "<head>" + "\n" +
            "<meta charset=\"utf-8\">" + "\n" +
            "<title>My Web Page</title>" + "\n" +
            "</head>" + "<body>";

    public static void main(String[] args) throws IOException {
        File input = new File("out.txt");
        Scanner sc = new Scanner(input);
        File output = new File("out.html.text");

        PrintStream print = new PrintStream(output);

        print.println(topstring);
    }
}
