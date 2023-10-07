package com.company;

import java.applet.Applet;
import java.awt.*;
import java.io.File;

public class Main extends Applet {
public void  paint(Graphics g ){
    g.drawString("Welcome in java Applet",40,20);
}

    public static void main(String[] args) {
     File file = new File("searchResults.html");
        System.out.println(file.toString()+" ");
    }


}
