package com.mayur.test;

// Fetching Data / Retrieve Data from DB By using PCODE
import java.util.*;
import java.sql.*;
public class DBCon3 implements DBInfo{

	public static void main(String[] args) {
	try {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the pCode :");
		String pCode = sc.nextLine();
		
		Connection con = DriverManager.getConnection(url,user,pword); 
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from product01 where pcode = '"+pCode+"'");
		
		if(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+
                    rs.getString(2)+"\t"+
					 rs.getFloat(3)+"\t"+
                    rs.getInt(4)
                     );
		}else {
			System.out.println("Invalid product code");
		}
		con.close();
		sc.close();
	}catch(Exception e) {e.printStackTrace();}
		
	}

}
