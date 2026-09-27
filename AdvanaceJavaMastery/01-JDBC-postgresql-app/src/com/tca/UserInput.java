package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInput
{
	public static final String DB_DRIVER="org.postgresql.Driver";
	public static final String DB_URL="jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="root@123";
 public static void main(String[] args) 
 {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	try
	{
		Class.forName(DB_DRIVER);
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		System.out.println("Enter the roll number");
		int n=Integer.parseInt(br.readLine());
		ps=con.prepareStatement("select * from student where rno=(?)");
		ps.setInt(1, n);
		rs=ps.executeQuery();
	if(rs.next())
		{
		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));

			System.out.println("Record is found successfully...!!!!!!!!!");
		}
	else
		
	{
		System.out.println("Record is not  found ...!!!!!!!!!");
	
	}
	rs.close();
	con.close();
	ps.close();
	}
	catch(Exception e)
	{
	  System.out.println("problem..while closing resources..!!");
	  e.printStackTrace();
	}
			
}
}
