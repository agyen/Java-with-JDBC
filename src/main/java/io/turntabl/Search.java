package io.turntabl;

import java.sql.*;

public class Search {
    public static void getContactName(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        String querry = "select * from customers where contact_name like  ?";

        try(Connection db = DriverManager.getConnection(url, "isaac-agyen", "turntabl")){
            PreparedStatement s  = db.prepareStatement(querry);
            s.clearParameters();
            s.setString(1, name + '%');
            // Statement s = db.createStatement();
            ResultSet rs = s.executeQuery();
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
    public  static void searchByCategory(String category) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        String querry = "select * from categories where category_name like ?";
        try (Connection db = DriverManager.getConnection(url,"isaac-agyen","turntabl")){
            PreparedStatement s = db.prepareStatement(querry);
            s.clearParameters();
            s.setString(1, "%"+category + "%");
            ResultSet rs = s.executeQuery();

            System.out.println("Database Connected");
            System.out.println("---------------------------------------------------");
            System.out.printf("%30s", "Category_name");
            System.out.println();
            System.out.println("---------------------------------------------------");

            while (rs.next()){
                System.out.format("%30s",rs.getString("category_name"));
            }

        }catch (SQLException sqle){
            System.err.println("Connection err" + sqle);
        }

    }
}
