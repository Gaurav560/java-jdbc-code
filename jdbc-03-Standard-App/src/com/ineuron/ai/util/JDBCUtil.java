package com.ineuron.ai.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	// making constructor private so that no one can make a object of this .
	// we can call methods of this class by ClassName as methods sre static
	private JDBCUtil() {

	}

	public static Connection getConnection() throws SQLException, IOException {

		// take the data from properties file
		FileInputStream fileInputStream = new FileInputStream("E:\\jdbc\\jdbc-03-Standard-App\\application.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		System.out.println("connection object created");
		System.out.println(connection.getClass().getName());
		return connection;

	}

	public static void cleanUp(Connection connection, Statement statement, ResultSet rSet) throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();

		}
		if (rSet != null) {
			rSet.close();
		}

	}
}
