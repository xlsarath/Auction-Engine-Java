package com.hcl.jsh.model;

public class User 
{
	
	String login_name,login_pwd,user_name,repeat_Pwd,new_login_name;
	
	
	public String getNew_login_name() {
		return new_login_name;
	}
	public void setNew_login_name(String new_login_name) {
		this.new_login_name = new_login_name;
	}
	public String getLogin_name()
	{
		return login_name;
	}
	public void setLogin_name(String login_name) 
	{
		this.login_name = login_name;
	}
	public String getLogin_pwd()
	{
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) 
	{
		this.login_pwd = login_pwd;
	}
	public String getUser_name() 
	{
		return user_name;
	}
	public void setUser_name(String user_name)
    {
		this.user_name = user_name;
	}
	public void setRepeat_pwd(String repeat_pwd) 
	{
		
		this.repeat_Pwd=repeat_pwd;
	}
	
	
	

}
