package com.hcl.jsh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class DBConnection 
{

	Connection con=null;
	String url="jdbc:mysql://localhost:3306/petpeersdb";
	String uid="root",pass="root";
		
		
		public Connection dbConnect(){
			
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url,uid,pass);
			} 
			catch (ClassNotFoundException e)
			{
				
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return con; 
		}
}
