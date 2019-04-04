<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>  
     <%@ page import="com.hcl.jsh.model.User" %>  
    <%  User u=(User)session.getAttribute("USERDATA"); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>buy pet</title>

</head>
<body >
<h2>Welcome <%= u.getLogin_name() %></h2>
  <form action=./PetPeersTranscation method="post">
  <table border="1" >
  <tr><th><font color='Red'>ID</font></th>
  <th><font color='Red'>pet_name</font></th>
  <th><font color='Red'>pet_age</font></th>
  <th><font color='Red'>pet_place</font></th>
  <th><font color='Red'>pet_type</font></th>
  <th><font color='Red'>pet_sex</font></th>
  <th><font color='Red'>pet_size</font></th>
  <th><font color='Red'>avl_qty</font></th>
  <th></th>
  
  </tr>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petpeersdb","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from pets;");
  while(rs.next())
  {
      int petid=rs.getInt("id");
      String petName=rs.getString("pet_name");
      int pet_age=rs.getInt("pet_age");
      String pet_place=rs.getString("pet_place");
      String pet_type=rs.getString("pet_type");
      String pet_sex=rs.getString("pet_sex");
      String pet_size=rs.getString("pet_size");
      int avail_quan=rs.getInt("AVL_QTY");
  %>
<tr>
<td><b><font color='#663300'><%=petid%></font></b></td>
<td><b><font color='#663300'><%=petName%></font></b></td>
<td><b><font color='#663300'><%=pet_age%></font></b></td>
<td><b><font color='#663300'><%=pet_place%></font></b></td>
<td><b><font color='#663300'><%=pet_type%></font></b></td>
<td><b><font color='#663300'><%=pet_sex%></font></b></td>
<td><b><font color='#663300'><%=pet_size%></font></b></td>
<td><b><font color='#663300'><%=avail_quan%></font></b></td>
<td><a href="PetPeersTranscation?petID=<%=petid%>" >buy</a></td>

</tr>
<%
  }
 %>
 </table>
 </form>
     </body>
</html>