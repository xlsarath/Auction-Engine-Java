<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"  %>
     <%@ page import="com.hcl.jsh.model.User" %>  
    <%  User u=(User)session.getAttribute("USERDATA"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome <%= u.getLogin_name() %></h2>
<h1><font  face="Italic Bold" size="4" color="blue"> Pet Add Screen</font></h1>
<h2>Pet Peers</h2>


<a href="pet_Welcome.jsp">Home</a><form action="PetPeersAddAction" method="get">
<table border=1 cellspacing=0>
<h3>Pet Information</h3>
<tr><td>Name :<input type=txt name=pname>
<%
 Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petpeersdb","root","root");
 Statement st=con.createStatement();
 ResultSet rs=st.executeQuery("select pet_type from pettype");
 out.println("Pet Type: <select name=type>");
 String type;
 while(rs.next())
 {
	 type = rs.getString(1);
%>
 
<option value ='<%=type%>'><%=type %>
</option>
<%
 }
out.println("</select>");

%>
</td></tr><br>

<tr><td>Age :<input type="text" name=age>
Quantity Avl :<input type="text" name=qty>
</td></tr><br>

<tr><td>Place:<input type="text" name=place>
Sex:<input type="text" name=sex>
</td></tr><br>

<tr><td><input type="submit" value=save><input type="reset" value=cancel>
Size :<input type="radio" name=size value=large>Large
<input type="radio" name=size value=medium>Medium
<input type="radio" name=size value=short>Short
</td></tr>
</table>
</form>
</body>
</html>