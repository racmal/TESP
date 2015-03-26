<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jova.io.*,java.util.*,javax.servlet.*" %>>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	<h2>teste 03
	<%
		Date date = new Date();
		out.print( "<h2 align=\"center\">" +date.toString()+"</h2>");
	%></h2>

	</body>
</html>