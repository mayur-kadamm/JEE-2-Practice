package com.mayur.test;
import java.sql.*;
// PS = PreparedStatement
// Inserting values by using PreparedStatement
import java.util.*;
public class DBCon4 implements DBInfo {
	public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id :");
		String eId= sc.nextLine();
		System.out.println("Enter Employee Name :");
		String eName = sc.nextLine();
		System.out.println("Enter Employee Designation :");
		String eDsg = sc.nextLine();
		System.out.println("Enter Employee  Basic Salary :");
		int bSal = sc.nextInt();
		float toSal = bSal + (0.93F*bSal)+ (0.63F*bSal);
		
		Connection con = DriverManager.getConnection(url,user,pword);
		PreparedStatement ps = con.prepareStatement("insert into emp01 values(?,?,?,?,?)"); // compilation
		
		ps.setString(1, eId);
		ps.setString(2, eName);
		ps.setString(3, eDsg);
		ps.setInt(4, bSal);
		ps.setFloat(5, toSal);
		
		int k = ps.executeUpdate();  // execution process Successfully
		
		if(k>0) {
			System.out.println("Employee Details Inserted Successfully...");
		} 
		
		
	con.close();    
	sc.close();
	  }catch(Exception e ) {e.printStackTrace();}

	}

}
