 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.hcl.jsh.model.User" %>  
<%@ page import="com.hcl.jsh.model.AddPet" %>
 <%@ page import="java.sql.*" %>  
 <%@ page import="java.text.SimpleDateFormat" %>
 <%@page import="java.util.Date" %>   
 
 <%  User u=(User)session.getAttribute("USERDATA"); %>
 <%  AddPet a=(AddPet)session.getAttribute("PETDATA"); %>
 
 	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
<h2>Welcome <%= u.getLogin_name() %></h2>
<h2>Here's the pet id <%=a.getPetId() %></h2>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petpeersdb","root","root");
PreparedStatement ps;
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select pet_type from pets where id="+a.getPetId()+"");
String pet_type=null;
int user_id=0;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String date = sdf.format(new Date());
System.out.println(date);
  while(rs.next())
  {
     
      pet_type=rs.getString("pet_type");
      System.out.println("transaction : "+pet_type);
    }
  ResultSet rs1=stmt.executeQuery("select user_id from user where login_name='"+u.getLogin_name()+"' ");
  while(rs1.next())
  {
	   user_id=rs1.getInt("user_id");
  }
      ps=con.prepareStatement("insert into pet_transactions (pet_type,owner_id,pur_date) values(?,?,?)");
     
     // ps.setInt(1, 100);
      ps.setString(1,pet_type);
      ps.setInt(2, user_id);
    //  ps.setInt(3,1);
      ps.setString(3,date);
      ps.executeUpdate();
 %>
 <h1>TRANSACTION DONE</h1>
 <h3>Transaction particulars</h3>
 <table border="1" >
  <tr><th><font color='Red'>TRN_ID</font></th>
  <th><font color='Red'>pet_type</font></th>
  <th><font color='Red'>pet_owner</font></th>
  <th><font color='Red'>pur_qty</font></th>
  <th><font color='Red'>pur_date</font></th>
  </tr>
   <%
   ResultSet rs3=stmt.executeQuery("select * from pet_transactions where owner_id="+user_id+"");
   while(rs3.next())
   {
 	  int i=rs3.getInt("TRN_ID");
 	  String type=rs3.getString("PET_TYPE");
 	  int custId=rs3.getInt("OWNER_ID");
 	  int qty=rs3.getInt("PUR_QTY");
		String dt=rs3.getString("PUR_DATE");
	%>	
		<tr>
		<td><b><font color='#663300'><%=i%></font></b></td>
		<td><b><font color='#663300'><%=type%></font></b></td>
		<td><b><font color='#663300'><%=custId%></font></b></td>
		<td><b><font color='#663300'><%=qty%></font></b></td>
		<td><b><font color='#663300'><%=dt%></font></b></td>
		
		</tr>
		
		
		<% 
   }
   
   
   %>


</body>
</html>