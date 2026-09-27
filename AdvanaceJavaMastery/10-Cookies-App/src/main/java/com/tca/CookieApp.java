package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/CookieApp","/Cook"})
public class CookieApp extends HttpServlet
{
    private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
       	response.setContentType("text/html");
       	PrintWriter out=response.getWriter();
       	String subject=request.getParameter("sb");
       	out.println("You Have selected "+subject);
       	Cookie c[]=request.getCookies();
       int cnt;
       if(c==null)
       {
    	   cnt =1;
       }
       else
       {
    	  cnt=c.length+1;
       }
       String key="ID"+cnt;//ID+1-->
       Cookie ck=new Cookie(key,subject);
       ck.setPath("/");
       response.addCookie(ck);
       	out.close();
	}
	
}
