package com.company;

import com.company.entities.CrawlerResults;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class search {
 final static    String url = "jdbc:mysql://localhost:3306/cleancodedb";
 final static    String username = "root";
 final static    String password="dev18052002";
 //  static CrawlerResults cr = new CrawlerResults();
static List<CrawlerResults> results = new ArrayList<>();


    public static Connection setConnection() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/cleancodedb";
//        String username = "root";
//        String password="dev18052002";
        Connection con = DriverManager.getConnection(url, username, password);
        if (con != null) {
            System.out.println("hey we are connected right now...");
            return con;
        } else {
            System.out.println("There's some error please check out for it...");
        }
        return null;
    }
    public static void closeConnection(Connection close) {
        try {
            assert  close !=null ;
            close.close();
        } finally {
            return;
        }

    }
    private static List<CrawlerResults> dbQuery(String str) throws SQLException {
        // perform set connection and database search
      //  setConnection();
//        String url = "jdbc:mysql://localhost:3306/cleancodedb";
//        String username = "root";
//        String password="dev18052002";
//
//        Scanner sc =  new Scanner(System.in);
//        System.out.println("Enter the titles around which you want to search : " );
//
//        String str = sc.nextLine();

//        String sql = "SELECT * FROM userdb WHERE  titles LIKE '%"+str+"%' ";
//
//        System.out.println("Returning all those titles with their corresponding links which has occurrence of : " + str + " : at any position.");

        Connection conn = null;
      //  CrawlerResults cr = new CrawlerResults();
        try{
            conn = setConnection();
            assert conn != null;
            String sql = "SELECT * FROM userdb WHERE  titles LIKE '%"+str+"%' ";

            System.out.println("Returning all those titles with their corresponding links which has occurrence of : " + str + " : at any position.");

            Statement statement = conn.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            while(resultSet.next()){
                CrawlerResults cr =  new CrawlerResults();
              //  System.out.println("The result set value is : "+resultSet.getString("titles")+"\n"+ resultSet.getString("links") );
                cr.setTitle(resultSet.getString("titles"));
                cr.setLink(resultSet.getString("links"));
                results.add(cr);
             //   System.out.println(resultSet.getString("titles")+"  "+ resultSet.getString("links"));
            }
        closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert conn != null;
            closeConnection(conn);
        }
        //
        return results;
    }
    public static List<CrawlerResults> searchInput(String userInput) throws SQLException {

     return    dbQuery(userInput);
    }



}
