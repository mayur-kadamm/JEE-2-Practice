package com.mayur.test;
// Making connection to oracle 
import java.sql.*;

public class DBCon1 implements DBInfo{

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(url,user,pword); //"jdbc:oracle:thin:@localhost:1521:orcl","system","tiger"
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from product01");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+
						                         rs.getString(2)+"\t"+
												 rs.getFloat(3)+"\t"+
						                         rs.getInt(4)
						                          );
			} // end of while 
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
