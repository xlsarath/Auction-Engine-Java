package com.hcl.jsh.actions;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.jsh.dao.UserDAO;
import com.hcl.jsh.model.User;

/**
 * Servlet implementation class PetPeersLoginAction
 */
@WebServlet("/PetPeersLoginAction")
public class PetPeersLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String user,user1;
	String pwd,pwd1,name;
	RequestDispatcher rd;
	//UserDAO dao=new UserDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetPeersLoginAction()
    {
        super();


    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		user=request.getParameter("user");
	    pwd=request.getParameter("pass");
	    pwd1=request.getParameter("pass1");
	    user1=request.getParameter("user1");
		name=request.getParameter("name");
		User u=new User();
		u.setLogin_name(user);
		u.setLogin_pwd(pwd);
		u.setUser_name(name);
		u.setRepeat_pwd(pwd1);
		u.setNew_login_name(user1);
	
		UserDAO dao=new UserDAO();
 
		boolean r;
		try
		{
			r = dao.CheckUser(u);
			if(!r)
			{
			if(pwd.equalsIgnoreCase(pwd1))
				{
					dao.SaveUser(u);
					rd=request.getRequestDispatcher("pet_login.jsp");
					rd.forward(request, response);
					
				}
				else
				{
					out.println("Password Mismatch");
				}
			}
			else
			{
				out.println("User already Exists");
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}		
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		User u=new User();
		user=request.getParameter("user");
	    pwd=request.getParameter("pass");
		u.setLogin_name(user);
		u.setLogin_pwd(pwd);
		
		UserDAO dao=new UserDAO();
		
	
		boolean v;
		try 
		{
			v = dao.ValidateUser(u);
			if (v)
			{
				HttpSession ses=request.getSession();
				
				ses.setAttribute("USERDATA", u);
				out.println("welcome user");
				rd=request.getRequestDispatcher("pet_Welcome.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.println("User & Password doesnt exists");
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	            
		
		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		boolean v;
//		try 
//		{
//			v = dao.ValidateUser(user, pwd);
//			if (v)
//			{
//				out.println("welcome user");
//				rd=request.getRequestDispatcher("Welcome.jsp");
//				rd.forward(request, response);
//			}
//		} 
//		catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}

}
