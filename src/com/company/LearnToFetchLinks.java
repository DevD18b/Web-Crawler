package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class LearnToFetchLinks {
  static   ArrayList<String> hyperLinks = new ArrayList<>();
    public static void fetch() throws IOException {
        int count  =0;
        Document webPage = Jsoup.connect("https://www.geeksforgeeks.org/").get();
        Elements element = webPage.select("a[href]");

        // extracting the links from the page.
        for (Element e : element){

            hyperLinks.add("Titles of webpage : " +  e.text());
            hyperLinks.add("The links fetched : " + e.attr("href"));
        }

    }
    public static void main(String[] args) throws IOException {
        //  this below statement will  be going to fetch the https corresponding to that webpage...
        fetch();
for(String str: hyperLinks){
    System.out.println(str+" ");
}




    }
}
