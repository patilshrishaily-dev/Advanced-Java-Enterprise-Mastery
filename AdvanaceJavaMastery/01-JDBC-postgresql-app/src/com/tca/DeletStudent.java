package com.tca;
/*
 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DeletStudent
{
	public static void main(String[] args) 	
	{
		Connection con=null;
		PreparedStatement ps=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		final String DB_DRIVER="org.postgresql.Driver";
		final String DB_URL="jdbc:postgresql://localhost:5432/ajdb21";
		final String DB_USERNAME="root";
		final String DB_PASSWORD="root@123";
		try
		{
			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		   System.out.print("Enter the roll number to delete record :");
		   int n=Integer.parseInt(br.readLine());
		   ps=con.prepareStatement("delete from student where rno=( ?)");
		   ps.setInt(1, n);
		   int ans=ps.executeUpdate();
		   if(ans==0)
		   {
			   System.out.println("NO RECORD FOUND THAT ROLLNUMBER..!!"+n);
		   }
		   else
		   {
			   System.out.println("RECORD IS DELETED SUCCESSFULLY..!!"+n);
		   }
			
			
		}
		catch(Exception e)
		{
			System.out.println("Failed to delete Student record..!!");
			e.printStackTrace();
		}
		finally
		{
			
			try 
			{
				con.close();
				ps.close();
				br.close();
			}
			catch (Exception e) 
			{
				System.out.println("Failed to connection resources..!!");
				e.printStackTrace();
			}
			
		}
		
	}

}
