package com.mayur.test;
import java.util.*;
import java.sql.*;
public class DBCon8 implements DBInfo{
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection(url,user,pword);
			// Add books
			PreparedStatement ps1 = con.prepareStatement("insert into book01 values (?,?,?,?)");
			
			while(true) {
				System.out.println("===========Choice==========");
				System.out.println("1. Add Book\n2. View All Books\n3. View Books By Books Code\n4. Update Books By Code\n5. Delete Book Code\n6. Exit ");
				System.out.println("Enter Choice :");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					System.out.println("Enter Book Code :");
					String bCode = sc.nextLine();
					System.out.println("Enter Book Name :");
					String bName = sc.nextLine();
					System.out.println("Enter Book Price :");
					float bPrice = sc.nextFloat(); 
					System.out.println("Enter Book Quantity :");
					int bQty = sc.nextInt();
					
					
					ps1.setString(1, bCode);
					ps1.setString(2, bName);
					ps1.setFloat(3, bPrice);
					ps1.setInt(4, bQty);
					
					int k = ps1.executeUpdate();
					if(k>0) {
						System.out.println("Book Added Successfully......");
					}
			
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					System.out.println("Program Terminated");
					System.exit(0);
				default :
					System.out.println("Invalid Choice..");
				}
			}
		}catch(Exception e) {e.printStackTrace();}
	}

}
