package com.tca;
/*
 */
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String uname=request.getParameter("un");
	    if(uname.isEmpty() || uname.isBlank())
	    {
	    	out.println("<h2> No Input Received..!!</h2>");
	    }
	    else
	    {
	    out.println("Hello  ..."+uname+"  Welcome to Techno Comp Acadamy..!!<br>");
	    out.println("  METHOD NAME :-"+request.getMethod());
	    }
		out.close();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String uname=request.getParameter("un");
	   /* if(uname.isEmpty())
	    {
	    	out.println("<h2> No Input Received..!!</h2>");
	    }
	    else
	    {
	    out.println("Hello  ..."+uname+"  Welcome to Techno Comp Acadamy..!!");
	    out.println("  METHOD NAME :-"+request.getMethod());
	
	}
	*/
	    out.println("Hello  ..."+uname+"  Welcome to Techno Comp Acadamy..!!<br>");
	    out.println("  METHOD NAME :-"+request.getMethod());
	
		out.close();
}
}
