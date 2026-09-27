package com.tca;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
/*
 */
@WebServlet({ "/AddCokies", "/add" })
public class AddCokies extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
{
	     PrintWriter out=null;   
	try
	{
		response.setContentType("text/html");
	   out =response.getWriter();
	   Cookie ck1=new Cookie("shree","patil");
	    ck1.setPath("/");
	    //ck1.setMaxAge(0);
	    response.addCookie(ck1);
	    Cookie ck2=new Cookie("shiv","thakare");
	    ck2.setPath("/");
	    response.addCookie(ck1);
	    response.addCookie(ck2);
	    out.println("Cokkies are saved");
	    
	}  
	catch(Exception e)
	{
		out.close();
		e.printStackTrace();
	}        
}

}
