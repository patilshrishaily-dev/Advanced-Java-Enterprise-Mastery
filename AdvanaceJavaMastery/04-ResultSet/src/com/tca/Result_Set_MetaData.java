package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Result_Set_MetaData
{
public static final String DB_DRIVER = ("org.postgresql.Driver");
public static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb21";
public static final String DB_USERNAME = "root";
public static final String DB_PASSWORD = "root@123";
  public static void main(String[] args)
  {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd=null;
	try
	{
		Class.forName(DB_DRIVER);
		con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		stmt = con.createStatement();
		rs=stmt.executeQuery("select * from student");
		rsmd=rs.getMetaData();
		int n=rsmd.getColumnCount();
		System.out.println("No of columns..!!"+n);
		for(int i=1;i<=n;i++)
		{
			System.out.println("Name of column :"+rsmd.getColumnName(i));
			System.out.println("Name of column type..:"+rsmd.getColumnTypeName(i));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }
}
