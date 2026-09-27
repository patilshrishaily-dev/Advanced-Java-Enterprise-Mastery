package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*
 * 
 */

public class CalleableStatement
{
	public static final String DB_DRIVER="org.postgresql.Driver";
	public static final String DB_URL="jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="root@123";
 public static void main(String[] args)
{
	Connection con=null;
	ResultSet rs=null;
	CallableStatement cst=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	try
	{
		Class.forName(DB_DRIVER);
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		int r=333333;
		String k="krishna";
		double p=97.55;
		cst=con.prepareCall("select add_info(?,?,?)");
		cst.setInt(1, r);
		cst.setString(2, k);
		cst.setDouble(3, p);
		//cst=con.prepareCall("select add(2,5)");
		//cst=con.prepareCall("select msg()");
		/*
		int x=25;
		int y=30;
	  cst=con.prepareCall("select add(?,?)");
		cst.setInt(1,x);
		cst.setInt(2,y);
		*/
		rs=cst.executeQuery();
		if(rs.next())
		{
			System.out.println("Response  ..||:-"+rs.getString(1));
		}
		else
		{
			System.out.println("No record is not found..!!");
		}
	}
	catch(Exception e)
	{
		System.out.println("Problem .!! while closing resources..");
		e.printStackTrace();
	}
	finally
	{
		try {
		
		con.close();
		rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Problem .!! while closing resources..");
			e.printStackTrace();
		}
	}
	
}
}
