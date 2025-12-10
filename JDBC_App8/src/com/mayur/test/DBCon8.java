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
			// Fetch All Books Details
			PreparedStatement ps2 = con.prepareStatement("Select * from book01");
			// Fetch Book details by using BCode
			PreparedStatement ps3 = con.prepareStatement("Select * from book01 where BCode = ?");
			// Update Book price and Quantity By BCode use ps3 object for BCode
			PreparedStatement ps4 = con.prepareStatement("update book01 set BPrice = ? , BQty = BQty + ? where BCode = ?");
			//Deleting book by BCode ps3 use in BCode
			PreparedStatement ps5 = con.prepareStatement("delete from book01 where bcode =?");

			
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
					ResultSet rs = ps2.executeQuery();
					System.out.println("========== All Books Records =========");
					while(rs.next()) {
						System.out.println(rs.getString(1)+"\t"
													    +rs.getString(2)+"\t"
													    +rs.getFloat(3)+"\t"
													    +rs.getInt(4));
					}
					break;
				case 3:
					System.out.println("Enter Book Code :");
					String bCode1 = sc.nextLine();
					
					ps3.setString(1, bCode1);
					ResultSet rs1 = ps3.executeQuery();
					
					while(rs1.next()) {
						System.out.println(rs1.getString(1)+"\t"
													    +rs1.getString(2)+"\t"
													    +rs1.getFloat(3)+"\t"
													    +rs1.getInt(4));
					}		
					break;
				case 4:
					System.out.println("Enter Book Code :");
					String bCode2 = sc.nextLine();
					
					ps3.setString(1, bCode2); //using ps3 for this for BCode verification
					ResultSet rs2 = ps3.executeQuery();
					if(rs2.next()) {
						System.out.println("Old Price :"+rs2.getFloat(3));
						System.out.println("Enter new Price :");
						float newPrice = sc.nextFloat();
						System.out.println("Available Quantity :"+rs2.getInt(4));
						System.out.println("Enter new Quantity");
						int newqty = sc.nextInt();
						
						
						// update value 
						ps4.setFloat(1, newPrice);
						ps4.setInt(2, newqty);
						ps4.setString(3, bCode2);
						
						int k1 = ps4.executeUpdate();
						if(k1>0) {
							System.out.println("Product Details Updated Successfully...");
						}
					}else {
						System.out.println("Invalid produc code");
					}
								
					break;
				case 5:
					
					System.out.println("Enter Book Code");
					String bCode3 = sc.nextLine();
					
					ps3.setString(1, bCode3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3.next()) {
						ps5.setString(1, bCode3);
						int k2 = ps5.executeUpdate();
						if(k2>0) {
							System.out.println("Book Deleted successfully....");
						}else {
							System.out.println("Invalid book code");
						}
					}
					
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
