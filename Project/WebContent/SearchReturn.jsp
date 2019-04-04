<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.hcl.jsh.model.Search" %>    
<%@ page import="com.hcl.jsh.model.User" %>  
    <%  User u=(User)session.getAttribute("USERDATA"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<h2>Welcome <%= u.getLogin_name() %></h2>
<p id="demo"></p>

<script>
document.getElementById("demo").innerHTML = Date();
</script>

</body>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="PetPeersTransaction" method="get"></form>
<pre>

<b>PetPeers</b><b>	<a href="pet_Welcome.jsp">Home</a></b>  <b><a href="AddPet.jsp">Add Pet</a></b>
</pre>

<table align="left">
<tr>
<th  colspan="9" align="left">Pet List</th>
</tr>
<tr>
<th># &nbsp&nbsp</th>
<th>Pet Name &nbsp&nbsp</th>
<th>Place &nbsp&nbsp</th>
<th>Age &nbsp&nbsp</th>
<th>Pet_Type &nbsp&nbsp</th>
<th>Sex &nbsp&nbsp</th>
<th>Size &nbsp&nbsp</th>
<th>Quantity AVL &nbsp&nbsp</th>
<th></th>
</tr>
<% 
Object obj=session.getAttribute("petList");
List<Search> petList=(List<Search>)obj;
for(Search pet:petList){
%>
<tr>
<%--<td><%=pet.getAvmQty() %>--%>
<td><%=pet.getId()%> </td>
<td><%=pet.getName()%> </td>
<td><%=pet.getPlace()%> </td>
<td><%=pet.getAge()%> </td>
<td><%=pet.getType()%> </td>
<td><%=pet.getSex()%> </td>
<td><%=pet.getSize()%> </td>
<%-- <td><%=pet.getAvmQty() %> --%>
<td>&nbsp&nbsp&nbsp&nbsp<%=pet.getAvmQty()%> </td> 
<td><font color="blue" size="3"><a href="PetPeersTranscation?petID=<%=pet.getId() %>">Buy</a></font></td>
</tr>

<%} %>

</table>
</body>
</html>