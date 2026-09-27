
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String Msg="Unable to Read this problem...!!";
if(exception instanceof ArrayIndexOutOfBoundsException)
{
	Msg="The Given Index is Not found..!!";
}
if(exception instanceof NumberFormatException)
{
	Msg="The Given Value Is Not A integer..!!";
}
if(exception instanceof ArithmeticException)
{
	Msg="The Given INput is Missmatched..!!";
}
%>
 <%= Msg %> 
</font>
</body>
</html>