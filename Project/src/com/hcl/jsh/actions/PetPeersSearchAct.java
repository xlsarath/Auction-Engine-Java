package com.hcl.jsh.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.jsh.dao.SearchDAO;
import com.hcl.jsh.model.Search;

/**
 * Servlet implementation class Search
 */
@WebServlet("/PetPeersSearchAct")
public class PetPeersSearchAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

        RequestDispatcher rd;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<Search> petList=new ArrayList<Search>();
		HttpSession session=request.getSession();
		Search s=new Search();
		s.setAge(Integer.parseInt(request.getParameter("age")));
		s.setName(request.getParameter("name"));
		s.setPlace(request.getParameter("place"));
		s.setSize(request.getParameter("size"));
		s.setType(request.getParameter("type"));
		
		SearchDAO dao=new SearchDAO();
		
		try {
			petList=dao.searchPet(s);
			session.setAttribute("petList", petList);
			rd=request.getRequestDispatcher("SearchReturn.jsp");
			rd.forward(request, response);
				
			}
				
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 















	public PetPeersSearchAct() {
	        super();
	      
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}

	
	
	
	
	

}
