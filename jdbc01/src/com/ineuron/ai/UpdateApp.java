package com.ineuron.ai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmtStatement = null;

		try {

//			step1: load and register the driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("loading the driver class and static block automatically registers it .");

			// establishing the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oct_batch", "root", "Lumia@540");
			System.out.println(connection.getClass().getName());

			stmtStatement = connection.createStatement();
			String sqlString = "update players set pname='Rohit' where pid=5";
			int rowCount = stmtStatement.executeUpdate(sqlString);
			System.out.println(stmtStatement.getClass().getName());

			System.out.println(rowCount);}
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
			catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
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
