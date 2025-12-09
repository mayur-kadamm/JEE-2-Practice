package com.mayur.test;

import java.sql.*;
import java.util.*;
public class DBCon5 implements DBInfo{
	public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection(url,user,pword);
		
		// for registration
		PreparedStatement ps1 = con.prepareStatement("insert into UserReg01 values(?,?,?,?,?,?,?)");
		
		// for login 
		PreparedStatement ps2 = con.prepareStatement("select * from UserReg01 where UName = ? and Pass = ?");
		
		while(true) {
			System.out.println("=======Choice======");
			System.out.println("1. Register\n2. Login\n3. Exit");
			System.out.println("Enter Choice :");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1: 
				// For Registration 
					System.out.println("Enter User Name : ");
					String uName = sc.nextLine();
					System.out.println("Enter Password : ");
					String pword = sc.nextLine();
					System.out.println("Enter First  Name : ");
					String fName = sc.nextLine();
					System.out.println("Enter Last Name : ");
					String lName = sc.nextLine();
					System.out.println("Enter User Address : ");
					String addr = sc.nextLine();
					System.out.println("Enter User Email : ");
					String mId = sc.nextLine();
					System.out.println("Enter Phone No : ");
					long phNo = Long.parseLong(sc.nextLine());  // parse is method used to convert a String into a numeric or boolean value.
					
					
					// set the data 
					ps1.setString(1, uName);
					ps1.setString(2, pword);
					ps1.setString(3, fName);
					ps1.setString(4, lName);
					ps1.setString(5, addr);
					ps1.setString(6, mId);
					ps1.setLong(7, phNo);
					
					int k = ps1.executeUpdate(); 
					if(k>0) {
						System.out.println("Program terminated successfully.... ");
					}
					
				break;
			case 2:
				// For Login to user 
				System.out.println("Enter User Name :");
				String userName = sc.nextLine();
				System.out.println("Enter Pass :");
				String userPass = sc.nextLine();
				
				ps2.setString(1, userName);
				ps2.setString(2, userPass);
				
				ResultSet rs = ps2.executeQuery();
				if(rs.next()) {
					System.out.println("Login Successfully....");
					System.out.println("Welcome user :"+rs.getString(3));
				}else {
					System.out.println("Invalid Login Process");
				}
				
				break;
			case 3:
				System.out.println("Program Terminated..");
				System.exit(0);
			default: 
				System.out.println("Invalid choice ");
			}
		
			
		}
	//	sc.close();
	}catch(Exception e) {e.printStackTrace();}

	}

}
