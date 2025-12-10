package com.mayur.test;

import java.sql.*;
import java.util.*;
// Inserting Data Through java code
public class DBCon2 {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);

            System.out.print("Enter product code: ");
            String pCode = s.next();

            System.out.print("Enter product name: ");
            String pName = s.next();

            System.out.print("Enter product price: ");
            String pPrice = s.next();

            System.out.print("Enter product quantity: ");
            String pQty = s.next();

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "system",
                "tiger"
            );

            Statement st = con.createStatement();

            String sql = "INSERT INTO product01 VALUES ('" + 
                          pCode + "','" + 
                          pName + "'," + 
                          pPrice + "," + 
                          pQty + ")";

            int k = st.executeUpdate(sql);

            if(k > 0) {
                System.out.println("Product Inserted Successfully");
            }

            con.close();
            s.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
