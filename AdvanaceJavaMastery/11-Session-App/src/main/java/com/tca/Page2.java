package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*
 * aapan ithe session  bghnar aahe..!!!
 *------------------------------------------
 *http is stateless protocol..!!
 *what is means by stateless?
 *-->it can not prefer a complete tracking of user ..!!
 *mhnje tyo only previous state cha reference thveto tyacha aadhich state cha reference store karata nahi..!!
 *mutiple page cha refernce store nasto only jya page new request jate pudlya page la only tya page chach
 *refernce http protocol madhi store aasto..!!
 *means http does not maintain state mens chalu request chich information tyata aaste previous request
 *information tyat naste ..!!
 *what is a session??
 *-->session is temporary memory mhnje aapan kontahi aaplication start kel ki login kelyapasun te logout 
 *kareparyant je aapn request  tayar karto tya session madhi store astat aani jas aapn applcation logout kel
 *ki te session end hoto automatically or bydefault..!!
 *multiple requst cha data aapan session vaprun preserve karu shakato tya behavior la session tracking 
 *mhntat..!!
 *session stores the data in the form of key value pair..!!
 *key must be unique value must be duplicate..!! 
 *getParameterValues():- mhnje aaplya html chya page vun kadhihi check box madhun same type chya multiple values
 *yetat mnun check kadhi value array chya form madhi pathvato mhnje array madhi store karun pathvato..!!
 *manun ya method cha return type string s[] ha ahe..!!!
 *mhnje aaplya checkbox madhun aalelya multiple values kadun ghenyasathi aapnla getParameterValues hi method
 *call karavi lagte ani tyacha return type ha String s[] aaray ha aahe ..!!
 *how to crete a session??
 *--->HttpSession hs=request.getSession(true);
		 hs.setAttribute("P1total",ltotal); 
  mhnje aapan ithe true arun sangtoy ki session tayar kar jar false lihl tar session create honar nahi..!!
  ithe aaapn session create kelele aahe getsession madhi true kel ahe b.coz that method know only a boolean value
  true kelyamule aapla ithe session create zalel aahe false kele tar aapla ithe session create tayar honar nahi..!
  hs.setAttribute("P1total",ltotal):-he method aapan session madhi value set karnyasathi vaprto aani always 
  session key and value chya pair madhi data store karto so key manun aapn kahihi devu shakato pn allover
  session madhi ti unique aasli pahije aani value duplicate are allowed ..!!
  here is P1total is key and ltotal is value..!!
  aapnala jar pahilya page cha data 3rd  page war kiva all over project madhi pahije aasel tar te session madhi
  save karav lagel..!!
  hi value aapn third page var send karnar aahe so http ha stateless protocol aahe manun aapanla session
  create karava lagto..!!
  
 */
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Page2")
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  String s[]=request.getParameterValues("lbook");
		  int ltotal=0;
		  for(int i=0;i<s.length;i++)
		  {
			  ltotal=ltotal+Integer.parseInt(s[i]);
		  }
		  HttpSession hs=request.getSession(true);
		  hs.setAttribute("P1total",ltotal);
		  out.println("<h1> Select Servlet and Jsp Books</h1>" );
		  out.println("<form method=Post  action='./Page3'>");
		  out.println("<b> Select Servlet and jsp Books:</b> <br>");
		  out.println("<input type=checkbox name=sjbook value=450> Name= HaedFirst Servlet and Jsp price Rs.450<br>");
		  out.println("<input type=checkbox name=sjbook value=300> Name=Java Servlet Programming Price Rs.300<br>");
		  out.println("<input type=checkbox name=sjbook value=250> Name= Inside Servlet price Rs.250<br>");
		  out.println("<input type=submit value=payment>");
		  out.println("</form>");
		  out.close();

	}

}
