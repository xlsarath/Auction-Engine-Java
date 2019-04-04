<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>login Screen</h1>
	<h2>Sign in</h2>
	<h3>Are you returning customer</h3>
	<form action="PetPeersLoginAction" method="post">
		<table border=1 cellSpacing=0>
			<tr>
				<td>
					<center>Yes</center>
					<br>
					<table>
						<tr>
							<th>UserName :</th>
							<td><input type="text" name="user"></td>
						</tr>
						<tr>
							<th>Password :</th>
							<td><input type="password" name="pass"></td>
						</tr>
					</table>
					<center>
						<input type="submit" value="signin">
					
					</center>
				</td>
					</form>
				<td>
					<form action="PetPeersLoginAction" method="get">
						<center>No,I would like to sign up for an account</center>
						<br>
						<table>
							<tr>
								<th>UserName :</th>
								<td><input type="text" name="user1"></td>
							</tr>
							<tr>
								<th>Password :</th>
								<td><input type="password" name="pass"></td>
							</tr>
							<tr>
								<th>Password (repeat) :</th>
								<td><input type="password" name="pass1"></td>
							</tr>
							<tr>
								<th>Name :</th>
								<td><input type="text" name="name"></td>
							</tr>
						</table>
						<center>
							<input type="submit" value="create new account">
						</center>
				</td>
			</tr>
			</form>
		</table>
</body>
</html>