<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int i=0; //Instance Variable..!!
%>
<%
//int i=0; Local variable..!!
      i++;
out.println("<h1> Visited Count:-"+i+"..!!");
%>
</body>
</html>