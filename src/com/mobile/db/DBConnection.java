package com.mobile.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBConnection {
	public final static DBConnection DBConn = new DBConnection();
	private static Connection con;

	private DBConnection() {
		String url = "";
		try {
			// Read properties file.
			Properties properties = new Properties();
			try {
				
				properties.load(this.getClass().getResourceAsStream("db.properties"));
			} catch (IOException e) {
				System.out.println("Exception when Loading properties : "
						+ e.getMessage());
			}
			//set the MYSQL Driver
			setDBDriver();
			//Constructs the URL for the MySQL DB and establishes the connection
			url = "jdbc:mysql://" + properties.getProperty("host") + ":"
					+ properties.getProperty("port") + "/"
					+ properties.getProperty("database");
			con = DriverManager.getConnection(url, properties
					.getProperty("username"), properties
					.getProperty("password"));
			System.out.println("Connection established to " + url + "...");
		} catch (java.sql.SQLException e) {
			System.out.println("Connection couldn't be established to " + url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

	private void setDBDriver() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("MySQL Driver Found");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found ... ");
			throw (e);
		}
	}
	
	public static void main(String[] args) {
		
	}

}
