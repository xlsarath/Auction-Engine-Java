<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.hcl.jsh.model.User" %>  
    <%  User u=(User)session.getAttribute("USERDATA"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
</head>
<body>
<h2>Welcome <%= u.getLogin_name() %></h2>
<h1><font  face="Italic Bold" size="4" color="blue"> Pet search Screen</font></h1>
<h2>Pet Peers</h2>

<form action="PetPeersSearchAct" method="post">
<table border=1 cellspacing=0>
<tr><td>

<% 
Connection con=null;
String url="jdbc:mysql://localhost:3306/petpeersdb";
String uid="root",pass="root";
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection(url,uid,pass);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select pet_type from pettype");
out.println("Pet Type <select name=type>");
String type;
while(rs.next())
{
	type=rs.getString(1);
%>
<option value=<%=type%>><%=type%>
</option>
<% 
}
out.println("</select>");
%>
</td></tr>
<tr><td>
Size :<input type="radio" name=size value=large>Large
<input type="radio" name=size value=medium>Medium
<input type="radio" name=size value=short>Short
</td></tr>

<tr><td>
Name :<input type=text name=name>
</td></tr>

<tr><td>Age :<input type="text" name=age value=0>
</td></tr>


<tr><td>Place:<input type="text" name=place>

</td></tr>

<tr><td>
<input type="submit" value=" search"><br/>
<input type="reset" value="clear fields">
</table>
</form>

</body>
</html>