package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 * 
 */
@WebServlet({ "/ShowServlet", "/show" })
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Cookie c[]=request.getCookies();
			for(Cookie ck:c)
			{
				String name=ck.getName();
				String value=ck.getValue();
				out.println("Name-->"+name+" value--->"+value+"<br>");
				
			}
			
			
			out.close();
	}

}
