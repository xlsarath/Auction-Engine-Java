
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.hcl.jsh.model.User" %>  
 <%  User u=(User)session.getAttribute("USERDATA"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><center>WELCOME</center></h1>
<h2>Welcome <%= u.getLogin_name() %></h2>
<a href="AddPet.jsp">ADD</a><br>
<a href="Buy.jsp">BUY</a><br>
<a href="Search.jsp">SEARCH</a><br>
</body>
</html>