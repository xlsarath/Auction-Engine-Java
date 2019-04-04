package com.hcl.jsh.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.jsh.dao.TransactionDAO;
import com.hcl.jsh.model.AddPet;



/**
 * Servlet implementation class Transcation
 */
@WebServlet("/PetPeersTranscation")
public class PetPeersTranscation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int available_quantity;
       PreparedStatement ps1;
   	
   	boolean temp;
   
   	RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetPeersTranscation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		AddPet a =new AddPet();
		
		int petId = Integer.parseInt(request.getParameter("petID"));
		System.out.println("pet id " + petId);
		
	
		try {
			TransactionDAO t= new TransactionDAO();
		int i=t.decrement_quantity(petId);
		t.updateTransaction(i,petId);
		a.setPetId(petId);
		System.out.println("transactions servlet"+a.getPetId());
			HttpSession ses=request.getSession();
			ses.setAttribute("PETDATA", a);
			rd=request.getRequestDispatcher("Transaction.jsp");
			rd.forward(request, response);
			
		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
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
