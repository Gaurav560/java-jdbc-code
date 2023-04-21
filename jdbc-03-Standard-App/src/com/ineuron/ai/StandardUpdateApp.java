package com.ineuron.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ineuron.ai.util.JDBCUtil;

public class StandardUpdateApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmtStatement = null;
		Integer rowCount = null;

		try {

			connection = JDBCUtil.getConnection();
			if (connection != null) {
				stmtStatement = connection.createStatement();
			}
			if (stmtStatement != null) {
				String sqlString = "update players set pname='RohitRaghunathSharma' where pid=5";
				rowCount = stmtStatement.executeUpdate(sqlString);
				System.out.println(stmtStatement.getClass().getName());

			}
			if (rowCount == 1) {
				System.out.println("object updated successfully.");
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleanUp(connection, stmtStatement, null);
				System.out.println("closing the resources.");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
