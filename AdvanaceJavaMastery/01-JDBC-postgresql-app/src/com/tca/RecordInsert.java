package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecordInsert {

	public static final String DB_DRIVER="org.postgresql.Driver";
	public static final String DB_URL="jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="root@123";
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement ps=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			ps=con.prepareStatement("insert into student values(?,?,?)");
			while(true)
			{
			System.out.print("Enter the roll number :");
			int n=Integer.parseInt(br.readLine());
			System.out.print("Enter the name :");
			String name=(br.readLine());
			System.out.print("Enter the percentage:");
			double per=Double.parseDouble(br.readLine());
			ps.setInt(1, n);
			ps.setString(2, name);
			ps.setDouble(3, per);
		     ps.executeUpdate();
		     System.out.println("DO YOU WANT TO CONTINUE(YES/NO)..!!");
		     String option=br.readLine();
		     if(option.equalsIgnoreCase("yes"))		
		     {
		    	 continue;	
		     }
		   else
		   {
			   System.out.println("REcord is inserted successfully");
		    	 break;
			
		   }
		     }
				
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