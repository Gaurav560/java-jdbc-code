package com.ineuron.ai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testApp01 {
public static void main(String []args){
	Connection connection=null;
	Statement stmtStatement=null;
	ResultSet rSet=null;
	
	try {
		
//		step1: load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loading the driver class and static block automatically registers it .");
		
		
		//establishing the connection
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct_batch","root","Lumia@540");
		System.out.println(connection.getClass().getName());
		
		stmtStatement=connection.createStatement();
		String sqlString="select * from players";
		rSet=stmtStatement.executeQuery(sqlString);
		System.out.println(stmtStatement.getClass().getName());
		System.out.println(rSet.getClass().getName());
		System.out.println("pid\tpname\tpage\tpaddress");
		while (rSet.next()) {
			
			Integer pidInteger=rSet.getInt(1);
			String pNameString=rSet.getString(2);
			String pageString=rSet.getString(3);
			String pAddreString=rSet.getString(4);
			System.out.println(pidInteger+"\t"+pNameString+"\t"+pageString+"\t"+pAddreString);
		}
		
		
	} catch (ClassNotFoundException e) {
e.printStackTrace();
	}
	catch (SQLException e) {
	e.printStackTrace();
	}
	catch (Exception e) {
e.printStackTrace();
	}finally {
		if (connection!=null) {
			try {
				connection.close();
				System.out.println("connection closed...");
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	
}
}
