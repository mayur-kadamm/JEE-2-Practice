package com.mayur.test;

public class TestConn2 {
	  public static void main(String[] args) {
	    try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      System.out.println("Driver class loaded OK");
	      System.out.println("CLASSPATH: " + System.getProperty("java.class.path"));
	      java.sql.Connection c = java.sql.DriverManager.getConnection(
	          "jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
	      System.out.println("Connection OK");
	      if (c != null) c.close();
	    } catch (Throwable t) {
	      t.printStackTrace();
	    }
	  }
	}
