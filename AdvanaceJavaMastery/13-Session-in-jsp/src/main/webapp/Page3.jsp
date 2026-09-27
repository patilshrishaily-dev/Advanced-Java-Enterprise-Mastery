<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String per=request.getParameter("per");
String grade=request.getParameter("grade");
String fname=session.getAttribute("fn").toString();
String  lname=(String)session.getAttribute("ln");
session.invalidate();
%>

<h2> MARKSHEET </h2>
First Name :<%=fname %><br>
Last Name  :<%=lname %><br>
Percentage :<%=per %><br>
Grade      :<%=grade %><br>
</body>
</html>