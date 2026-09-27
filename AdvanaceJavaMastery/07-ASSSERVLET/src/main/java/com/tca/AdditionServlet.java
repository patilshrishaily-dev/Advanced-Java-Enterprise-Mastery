package com.tca;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
@WebServlet({"/AdditionServlet","/Add"})
public class AdditionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	      String first = request.getParameter("first");
	      String second=request.getParameter("second");
	      if(first.length()==0 || second.length()==0)
	      {
	    	 out.println("<h2> NO INPUT FOUND..!!<h2>"); 
	      }
	      else 
	      {
	      int x=Integer.parseInt(request.getParameter("first"));
	      int y=Integer.parseInt(request.getParameter("second"));
	      int z=x+y;
	      out.println("Addition is:-"+z);
	}
	}

}
