//package com.company;
//
//
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class ConnectToJdbc {
//
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/mini-projectdb";
//        String username = "root";
//        String password = "dev18052002";
//
//        try{
//            Connection connection = DriverManager.getConnection(url,username,password);
//            System.out.println("Inserting...");
//
//
//           // String sql = "SELECT * FROM customers";
//          //  Statement statement = connection.createStatement();
//        // ResultSet set =   statement.executeQuery(sql);
//       //  int count  =0;
//        //    while(set.next()){
////                String firstName = set.getString("FIRST_NAME");
////                String lastName = set.getString("LAST_NAME");
////                count++;
////                System.out.println("Customer : "+count+ ": "+ firstName+ "  " +lastName );
////                count++;
////            }
////            connection.close();
//
//
//
//          //  String sql = "INSERT INTO customers (FIRST_NAME,LAST_NAME) VALUES(?,?)";
//          //  PreparedStatement statement = connection.prepareStatement(sql);
//         //  statement.setString(1,"Dev-Datta");
//        //   statement.setString(2,"Bijoy");
//
//
//        //int rows =     statement.executeUpdate();
//         //   if(rows>0){
//         //       System.out.println("new row has been inserted to the database");
//       //     }
//      //  statement.close();
//      //      connection.close();
//        } catch (SQLException e) {
//            System.out.println("please attempt one more time...");
//            e.printStackTrace();
//        }
//    }
//}
