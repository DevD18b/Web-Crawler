package com.company;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class basicSearchCode {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/cleancodedb";
//        String username = "root";
//        String password="dev18052002";
//
//        Connection conn = DriverManager.getConnection(url,username,password);
//        if(conn!=null){
//            System.out.println("so we are connected...");
//        }
//        else{
//            System.out.println("check it out");
//        }
//        Scanner sc =  new Scanner(System.in);
//        System.out.println("Enter the string around which you want to search...");
//
//        String str = sc.nextLine();
//
//          try{
//              String sql =  "SELECT * FROM userdb WHERE  titles LIKE '%"+str+"%' ";
//
//              System.out.println(" returning results...");
//              assert conn != null;
//              Statement statement = conn.createStatement();
//              ResultSet resultSet =  statement.executeQuery(sql);
//              while(resultSet.next()){
//                  System.out.println(resultSet.getString("titles")+" "+resultSet.getString("links"));
//              }
//              statement.close();
//              conn.close();
//
//
//
//
//
//          } catch (SQLException e) {
//              e.printStackTrace();
//          }
//          finally {
//              assert conn!=null;
//              conn.close();
//          }


    }
    public static Set<String> SearchResults(String searchInput) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cleancodedb";
        String username = "root";
        String password="dev18052002";
   Set<String> ansSet =  new HashSet<>();
        Connection conn = DriverManager.getConnection(url,username,password);
        if(conn!=null){
            System.out.println("so we are connected...");
        }
        else{
            System.out.println("check it out");
        }
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the string around which you want to search...");

        String str = sc.nextLine();

        try{
            String sql =  "SELECT * FROM userdb WHERE  titles LIKE '%"+str+"%' ";

            System.out.println(" returning results...");
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            while(resultSet.next()){
                ansSet.add(resultSet.getString("titles")+"\n"+resultSet.getString("links"));
            }
            statement.close();
            conn.close();





        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            assert conn!=null;
            conn.close();
        }
        return ansSet;
    }

}
