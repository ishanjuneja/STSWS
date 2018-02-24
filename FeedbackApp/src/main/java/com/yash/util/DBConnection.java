package com.yash.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private Properties properties;
	private Connection dbconnection;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * this method is used to setup a connection to the database
	 * @return the connection or null if there is a problem connecting the database
	 */
	public Connection connect(){
		
		try {
			
			String driverclassname=properties.getProperty("driver");
			String url=properties.getProperty("url");
			String username=properties.getProperty("username");
			String password=properties.getProperty("password");
			Class<?> driverclass= Class.forName(driverclassname);
			dbconnection = DriverManager.getConnection(url,username,password);
			System.out.println("connected");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found : "+properties.getProperty("MYSQLJDBC.driver"));
			
		} catch (SQLException e) {
			System.out.println("invalid username/password/URL");
		}
		
		
		return dbconnection;
	}
}
