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

import com.hcl.jsh.dao.AddPetDAO;
import com.hcl.jsh.model.AddPet;

/**
 * Servlet implementation class PetPeersAddAction
 */
@WebServlet("/PetPeersAddAction")
public class PetPeersAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pname,place,sex,size,type,page,pqty;
	int qty,age;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetPeersAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		pname=request.getParameter("pname");
		page=request.getParameter("age");
		place=request.getParameter("place");
		pqty=request.getParameter("qty");
		sex=request.getParameter("sex");
		size=request.getParameter("size");
		type=request.getParameter("type");
		
		int age=Integer.parseInt(page);
		int qty=Integer.parseInt(pqty);
		
		
		AddPet ap=new AddPet();
		ap.setPname(pname);
		ap.setAge(age);
		ap.setPlace(place);
		ap.setQty(qty);
		ap.setSex(sex);
		ap.setSize(size);
		ap.setType(type);
		
		AddPetDAO apd=new AddPetDAO();
		boolean s;
			try
			{
				s=apd.SavePet(ap);
				if(s)
				{
					out.println("Succesfully Added");
					rd=request.getRequestDispatcher("pet_Welcome.jsp");
					rd.forward(request, response);
					
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
