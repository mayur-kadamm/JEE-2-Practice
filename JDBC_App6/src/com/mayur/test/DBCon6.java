package com.mayur.test;
import java.util.*;
import java.sql.*;
public class DBCon6 implements DBInfo{

	// update and price and quantity from product01
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Product code :");
			String pCode = sc.nextLine();
			Connection con  = DriverManager.getConnection(url,user,pword);
			// Product code checking purpose
			PreparedStatement ps1 = con.prepareStatement("select * from product01 where pCode = ?");
			// price and quantity updating purpose
			PreparedStatement ps2 = con.prepareStatement("update product01 set pprice=? ,pqty = pqty+? where pcode=?");
			
			
			ps1.setNString(1, pCode);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				System.out.println("Old Price :"+rs.getFloat(3));
				System.out.println("Enter new Price :");
				float newPrice = sc.nextFloat();
				System.out.println("Available Quantity :"+rs.getInt(4));
				System.out.println("Enter new Quantity");
				int newqty = sc.nextInt();
				
				
				// update value 
				ps2.setFloat(1, newPrice);
				ps2.setInt(2, newqty);
				ps2.setString(3, pCode);
				
				int k = ps2.executeUpdate();
				if(k>0) {
					System.out.println("Product Details Updated Successfully...");
				}
			}else {
				System.out.println("Invalid produc code");
			}
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
