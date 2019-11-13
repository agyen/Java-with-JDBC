package io.turntabl;
import java.util.Scanner;
import java.sql.*;

public class Main {
    Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws ClassNotFoundException {
        String url = "jdbc:postgresql:northwind";
        try (Connection db = DriverManager.getConnection(url, "isaac-agyen", "turntabl")) {
            // ...query the database
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select * from customers limit 5");
            System.out.println("Database Connected");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %30s %30s %20s %35s", "Customer ID", "Customer Name", "contact name", "contact title", "address");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                // System.out.println(rs.getString("contact_id"));

                System.out.format("%15s %40s %20s %30s %35s",
                        rs.getString("customer_id"),
                        rs.getString("company_name"),
                        rs.getString("contact_name"),
                        rs.getString("contact_title"),
                        rs.getString("address")
                );
                System.out.println();
//                System.out.println(rs.getString("city"));
//                System.out.println(rs.getString("postal_code"));
//                System.out.println(rs.getString("country"));
//                System.out.println(rs.getString("phone"));
//                System.out.println(rs.getString("fax"));

            }

        } catch (SQLException sqle) {
            System.err.println("Connection err" + sqle);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Search contact name! ");
        String name = input.nextLine();
        getContactName(name);

    }

    public static void getContactName(String name){
         String url = "jdbc:postgresql:northwind";
         String querry = "select * from customers where contact_name like '%" + name + "%'";
               try(Connection db = DriverManager.getConnection(url, "isaac-agyen", "turntabl")){
                   //
                   Statement s = db.createStatement();
                   ResultSet rs = s.executeQuery(querry);
                   System.out.println("Database Connected");
                   System.out.println("---------------------------------------------------");
                   System.out.printf("%30s", "Contact name");
                   System.out.println();
                   System.out.println("---------------------------------------------------");

                   while(rs.next()){
                       System.out.format("%30s", rs.getString("contact_name"));
                       System.out.println();
                   }

               }
                  catch (SQLException sqle){
                      System.err.println("connection err" + sqle);
                  }

    }
}
