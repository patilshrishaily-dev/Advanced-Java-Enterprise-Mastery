package com.tca;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
@WebServlet("/RequestMetaData")
public class RequestMetaData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1> METADATA ABOUT REQUEST OBJECT..!!</h1>");
		out.println("<br>REQUEST METHOD  :"+request.getMethod());
		out.println("<br>REQUEST  URL:"+request.getRequestURI());
		out.println("<br>REQUEST  IP ADDRESS:"+request.getRemoteAddr());
		out.println("<br>REQUEST  PORT NUMBER:"+request.getServerPort());
		out.println("<br>REQUEST  PROTOCOL:"+request.getProtocol());
		ServletContext sc=getServletContext();
		out.println("<br> Servelet S/w:"+sc.getServerInfo());
		out.close();
		
	}

	
}
