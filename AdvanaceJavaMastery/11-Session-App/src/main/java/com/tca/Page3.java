package com.tca;

import java.io.IOException;
/*
 * ithe aapan http protocol stateless ahe manun apanla only page2 cha data milnar aahe ..!!
 * so here is the one problem b.coz aapnala first page varla data ithe yenar nahi so tyo jar data
 * annaycha aaasel tar session madhi store kelela data kadun ghyava lagel b.coz http only
 * second page chach data ghevun yeto third page war so pahila page cha data jar pahije aasel tar aapnla
 * session madhun ghyava lagell..!!
 *  String sjbook[]=request.getParameterValues("sjbook"):- same ithepn aapla page 2 madhla data pn
 *  checkbox madhun multiple value ghevun yeto mnun aapla return type ha  String sjbook[] ha aahe..!!
 *   HttpSession hs=request.getSession(false):-mhnje aapn ithe false karun sangtoy ki ki new session
 *   create nako karu je existing mhnje jyo aadhich create aahe tyoch use kar manun aapn ithe false kel 
 *   aahe mhnje new session create nahi honar nahi jyo aadhicha aahe tyoch use honar..!!
 *   ---------------------------------------------------------------------------------------------------------
 *   ---------------------------------------------------------------------------------------------------------
 *     int ltotal=  Integer.parseInt(hs.getAttribute("P1total").toString()):-
 *     hs.getAttribute("P1total").toString():- mhnje ithe session madhi store keleli value kadun ghet ahe.!
 *     aapla data store hotana session madhi value hi kadhi Object chya form madhi store hoto..!!
 *    key and value hi ji tikde dileli aaste tech ikde dyavi lagte aani te case sensitive aaste ..!!
 *    value hi Object chya form madhi aaste manun toString() hi method call karun aapan tya object la 
 *    string chya format madhi convert karto aani mgh ti string Integer.parseInt() karun Integer
 *     Madhi convert karto..!! 
 */
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Page3")
public class Page3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    	{
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		   String sjbook[]=request.getParameterValues("sjbook");
		   int sjtotal=0;
		   for(String data: sjbook)
		   {
			   sjtotal=sjtotal+Integer.parseInt(data);
		   }
		 HttpSession hs=request.getSession(false);//dont create  new session ,Use Existing one
		 int ltotal=  Integer.parseInt(hs.getAttribute("P1total").toString());//700 Object -->toString-->
		 int bill=0;
		 bill=ltotal+sjtotal;
		 out.println("Page 1:Rs."+ltotal+"<br>");
		 out.println("Page 2:Rs."+sjtotal+"<br>");
		 out.println("total Bill:"+bill+"<br>");
		 hs.invalidate();
		 
		  out.close();
	    	
    	}

}
