package com.tca;
/*
 * 
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudent 
{
  public static void main(String[] args) 
  {
 final 	String  DB_DRIVER=("org.postgresql.Driver");
 final String DB_URL="jdbc:postgresql://localhost:5432/ajdb21";
 final String DB_USERNAME="root";
 final String DB_PASSWORD="root@123";
 Connection con=null;
 PreparedStatement ps=null;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try
{
	Class.forName(DB_DRIVER);
    con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
    System.out.println("Enter the roll number to update..!!!");
    int rollnum=Integer.parseInt(br.readLine()); 
    System.out.println("Enter The name to update..!!");
    String name=br.readLine();
    ps=con.prepareStatement("update student  set name=(?)   where rno=(?)");
    ps.setString(1, name);
    ps.setInt(2, rollnum);
    int n=ps.executeUpdate();
    if(n==0)
    {
    	System.out.println("The record is not found ");
    }
    else
    {
    	System.out.println("The record is updated successfully..!!"+n);
    }
   
}
	
catch(Exception e)
{
	System.out.println("problem..!! while closing the resources..!!");
	e.printStackTrace();
}
finally
{
	try
	{
	br.close();
	ps.close();
	con.close();
     }
	catch(Exception e)
	{
		System.out.println("problem..!! closing resources time..!!");
	}
 
 
  }
}
}
