package com.hcl.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hcl.jsh.model.AddPet;
import com.hcl.jsh.model.DBConnection;
import com.hcl.jsh.model.Search;

public class TransactionDAO
{
	PreparedStatement ps;
	DBConnection db=new DBConnection();
	ResultSet rs;
	Connection con=null;
	int available_quantity;
	
		public int decrement_quantity(int petId) throws SQLException {
			con=db.dbConnect();
			System.out.println("from transaction"+petId);
			
			String sql="select AVL_QTY from pets where ID="+petId+"";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
		while(rs.next())
		{
			 available_quantity = rs.getInt("AVL_QTY");
			System.out.println(available_quantity);
			if(available_quantity<1)
			{
			   String sql1="delete * from pets where avl_qty=0";
			   ps=con.prepareStatement(sql1);
			  // System.out.println(sql1);
			   ps.execute();
			}
			else{
			available_quantity=available_quantity-1;
		
			}
			
		
	}
		return available_quantity;
		}
		public void updateTransaction(int i,int petId) throws SQLException {
			// TODO Auto-generated method stub
		
			String sql="update pets set AVL_QTY="+i+" where ID="+petId+"";
			ps.executeUpdate(sql);
			//ps=con.prepareStatement("update pets set AVL_QTY="+i+" where ID="+petId+";");
			//ps.executeUpdate();
		}
}
		
