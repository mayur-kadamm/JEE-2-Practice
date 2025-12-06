package com.mayur.test;

public class TestConn {
    public static void main(String[] args) {
        try {
            // load driver class explicitly
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded OK");

            // try to open (but you can remove getConnection if not needed)
            java.sql.Connection c = java.sql.DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
            System.out.println("Connection OK: " + (c != null));
            if (c != null) c.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
