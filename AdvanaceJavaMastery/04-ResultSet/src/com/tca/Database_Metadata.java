package com.tca;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Database_Metadata

{
	public static final String DB_DRIVER = ("org.postgresql.Driver");
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root@123";
	 public static void main(String[] args)
	  {
		Connection con=null;
		ResultSet rs=null;
		DatabaseMetaData dbmd=null;
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			
			dbmd=con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getUserName());
			
			rs=dbmd.getTables(null, null, null,new  String[] {"TABLE"});
			System.out.println("TABLE NAMES");
			while(rs.next())
			{
				System.out.println(rs.getString("table_name"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }


}
