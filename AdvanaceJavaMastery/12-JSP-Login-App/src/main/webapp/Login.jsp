<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
     String un=request.getParameter("un");
	 String pwd=request.getParameter("pwd");
	 out.println("Uname:-"+un.toString()+"  password:-"+pwd.toString());
	 if(un.equals("shree") && pwd.equals("123"))
	 {
		 //out.println("<h1> Log In SuccessFull..!!</h1>");
		 //response.sendRedirect("https://www.technocompacademy.com");
		 //response.sendRedirect("./Home.jsp");
		 //response.sendRedirect("./HomeServlet");
		 RequestDispatcher rd=request.getRequestDispatcher("./HomeServlet");
		 rd.forward(request, response);
	 }
	 else
	 {
		 out.println("<h2> Log In Failed..!!</h2>");
	 }

%>
</body>
</html>