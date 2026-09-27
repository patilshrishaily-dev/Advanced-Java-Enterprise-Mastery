package com.tca;

import java.io.BufferedReader;
/*
 * 
 */
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent 
{

	public static void main(String[] args)
	{
	  Connection con=null;
	  PreparedStatement ps=null;
	  BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	  try
	  {
		  //Step-1:Load and Register Driver
		  Class.forName("org.postgresql.Driver");
		  
		  //Step-2:Form the connection between java and database server
		  //1=which database server('postgresql') and database name(ajdb21)
		  //2=user name(root)
		  //3=password (redhat@123)
		  //con=DriverManager.getConnection(1,2,3);
		  con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ajdb21","root","root@123");
		 
		  //step 3:-prepare sql/form sql query-->Insert into Student values(?,?,?)
		  System.out.println("Enter the roll number:");
		  int rno=Integer.parseInt(br.readLine());
		  System.out.println("Enter the name       :");
		  String name=br.readLine();
		  System.out.println("Enter the percentage");
		  double per=Double.parseDouble(br.readLine());
		  
		  ps=con.prepareStatement("insert into student values(?,?,?)");//I have prepare the sql
		  ps.setInt(1, rno);
		  ps.setString(2,name);
		  ps.setDouble(3, per);
		  
		  //step-4 :Execute/fire sql
		  ps.executeUpdate(); // Whatever Sql is stored in 'ps' will be execuated
		  System.out.println("Record is  saved successfully...!!!");
		  
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println("Problem..!! while Inserting Record.");
		  e.printStackTrace();
	  }
	  finally
	  {
		  try
		  {
			  ps.close();
			  con.close();
			  br.close();
		  
		  }
		  catch(Exception e)
		  {
			  System.out.println("Problem..!! while closing Exception.");
			  e.printStackTrace();
		  }
	  }  
	}

}
