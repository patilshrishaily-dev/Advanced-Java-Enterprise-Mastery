package com.tca;
/*
 */
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet({ "/HelloServlet", "/first","/enroll","/hello" })
public class HelloServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1> Hello World</h1>");
		out.println("<script> alert('Welcome to Tca')</script>");
		out.println("Method Name---->"+request.getMethod());
		out.close();
		
	}

	
}
