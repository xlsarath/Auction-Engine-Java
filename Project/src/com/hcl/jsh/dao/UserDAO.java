package com.hcl.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hcl.jsh.model.DBConnection;
import com.hcl.jsh.model.User;

public class UserDAO 
{
	PreparedStatement ps;
	DBConnection db=new DBConnection();
	ResultSet rs;
	Connection con=null;
	//User u =new User();
	
	
	public boolean CheckUser(User u) throws SQLException
	{
		
		con = db.dbConnect();
		String sql="select * from user where LOGIN_NAME='"+u.getNew_login_name()+"'";
		ps= con.prepareStatement(sql);
	    rs=ps.executeQuery();
	    System.out.println(u.getNew_login_name());
		while (rs.next()) 
		{
			return true;
		}
		return false;
		
	}
	public boolean SaveUser(User u) throws SQLException
	{
		con=db.dbConnect();
		
		
		ps=con.prepareStatement("insert into user (login_name,login_pwd,user_name) values(?,?,?)");
		ps.setString(1,u.getNew_login_name());
		ps.setString(2,u.getLogin_pwd());
		ps.setString(3,u.getUser_name());
	    
		int i=ps.executeUpdate();
		System.out.println(i);
		if(i>=0)
		{
			return true;
			
		}
		
		return false;
		
	}
	public boolean ValidateUser(User u) throws SQLException
	{
		con=db.dbConnect();
		Statement s=con.createStatement();
		//System.out.println(u.getLogin_name()+" "+u.getLogin_pwd());
		//System.out.println("select * from user where login_name='"+u.getLogin_name()+"' and login_pwd='"+u.getLogin_pwd()+"'");
		rs=s.executeQuery("select * from user where login_name='"+u.getLogin_name()+"' and login_pwd='"+u.getLogin_pwd()+"'");
		while(rs.next())
			return true;
		return false;
		
		
	}
}
