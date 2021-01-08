package com.suhas.practice.jdbc;

import oracle.jdbc.driver.OracleDriver;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	
	private static Connection connection;
	
	private static final String driverName = "jdbc:oracle:thin";
	private static final String hostName = "@DESKTOP-BAP0FUR";
	private static final String portNumber = "1521";
	private static final String databaseName = "XE";
	
	private static final String URL = driverName + ":" + hostName + ":" + portNumber + ":" + databaseName; 
	private static final String USERNAME = "Suhas";
	private static final String PASSWORD = "Suhas";
	
	private static final String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private static final OracleDriver driver = new OracleDriver();
			
	public static Connection getConnection() {
		
		try {
			
			Class.forName(driverClassName);
			DriverManager.registerDriver (driver);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return connection;
		
	}
	

}
