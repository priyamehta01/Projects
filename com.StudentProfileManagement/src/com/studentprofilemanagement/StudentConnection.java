
package com.studentprofilemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
   
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                       // JDBC driver name and database URL
   static final String DB_URL = "jdbc:mysql://localhost:3307/student";

  
   static final String USER = "root";                                                //  Database credentials
   static final String PASS = "priyameet";
	
	private static Connection conn = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		if(conn != null)
			return conn;
		else
		{
			try{                                                                //Exception Handling
				 
				   Class.forName("com.mysql.jdbc.Driver");               // Registering JDBC driver

				  
				   System.out.println("Connecting to database...");              //Opening a connection
				   conn = DriverManager.getConnection(DB_URL,USER,PASS);
				   return conn;
                                   
			}
			finally
			{}
		}
	}
	
	public static void closeConnection() throws SQLException
	{
		try
		{
			if(conn != null)
				conn.close();
		}
		finally
		{}
	}
	
	
	
}

