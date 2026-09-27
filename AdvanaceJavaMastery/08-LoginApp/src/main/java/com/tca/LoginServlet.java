package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/LoginServlet","/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out=null;
		try
		{
		response.setContentType("text/html");
		 out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		out.println("Data -->"+uname+" -->"+pass);
		if((uname.equals("shree")  )&&(pass.equals("1234") ))
		{
			//out.println("<h1> LogIn SuccessFull..!!</h1>");
			//response.sendRedirect("https://www.technocompacademy.com");
			response.sendRedirect("http://localhost:8080/10-LoginApp/HomeServlet");//Get
		}
		else
		{
			out.println("<h1> LogIn Failed..!!</h1>");
		}
		}
		catch(Exception e)
		{
			out.close();
			e.printStackTrace();
		}
		
	}

}
