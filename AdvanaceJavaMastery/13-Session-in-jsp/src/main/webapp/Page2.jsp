<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String fname=request.getParameter("fn");
  String lname=request.getParameter("pwd");
  out.println(fname +" "+ lname);
  
  session.setAttribute("fn", fname);
  session.setAttribute("ln",lname);
%>
<form method="post" action="./Page3.jsp">
   
   Percentage :-<input type="text" name="per" required><br>
   Grade      :-<input type="text" name="grade" required><br>
  <input type="submit" value="send"> 
   </form>
</body>
</html>