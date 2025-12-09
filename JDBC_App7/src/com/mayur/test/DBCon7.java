package com.mayur.test;
import java.util.*;
import java.sql.*;

// To delete by using product code from product01 table 
public class DBCon7 implements DBInfo {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Product code :");
			String pCode = sc.nextLine();
			Connection con  = DriverManager.getConnection(url,user,pword);
			// Product code checking purpose
			PreparedStatement ps1 = con.prepareStatement("select * from product01 where pCode = ?");
			// price and quantity updating purpose
			PreparedStatement ps2 = con.prepareStatement("delete from product01 where pcode=?");
			
			
			ps1.setNString(1, pCode);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				ps2.setString(1, pCode);
				int k = ps2.executeUpdate();
				if(k>0) {
					System.out.println("Product Details delete......");
				}
			}else {
				System.out.println("Invalid produc code");
			}
			sc.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}

}
