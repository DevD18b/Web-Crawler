package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClearCutImplementation {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        String str = "https://";
        System.out.println("Enter the hyper links.");
        String var = sc.nextLine();

      str =  str.concat(var);


        Document page = Jsoup.connect(str).get();
        // this will fetch the links from the database.
        Elements pageLinks = page.select("a[href]");
        ArrayList<String>hyperlinks =  new ArrayList<>();

// this is connectivity code to mysql database.
        String url = "jdbc:mysql://localhost:3306/cleancodedb";
        String username = "root";
        String password="dev18052002";


        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            if(connection!=null){
                System.out.println("Okay we are ready to proceed now...");
            }
            for(Element element : pageLinks){
          // this is code to insert the links with their corresponding titles into database.
                String sql = "INSERT INTO userdb (titles,links)  VALUES(?,?)";
                assert connection != null;
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,element.text());
                preparedStatement.setString(2,element.attr("href"));
                int rows = preparedStatement.executeUpdate();
                if(rows>0){
                    System.out.println("Hurrah new rows has been inserted into my database...");
                }
                preparedStatement.close();
            }

            assert connection != null;
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
