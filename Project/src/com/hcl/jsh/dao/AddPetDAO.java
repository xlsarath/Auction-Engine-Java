package com.hcl.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.jsh.model.AddPet;
import com.hcl.jsh.model.DBConnection;

public class AddPetDAO 
{

	PreparedStatement ps;
	DBConnection db=new DBConnection();
	ResultSet rs;
	Connection con=null;
	
	public boolean SavePet(AddPet ap) throws SQLException
	{
		con=db.dbConnect();
		String sql="insert into pets ( PET_NAME, PET_AGE, PET_PLACE, PET_TYPE, PET_SEX,"
				+ " PET_SIZE, AVL_QTY) values(?,?,?,?,?,?,?)";
		
		ps=con.prepareStatement(sql);
		
	//	System.out.println(ap.getAge()+"   "+ap.getPlace()+"  "+ap.getPname()+" ");
		
		ps.setString(1,ap.getPname());
		ps.setInt(2,ap.getAge());
		ps.setString(3,ap.getPlace());
		ps.setString(4,ap.getType());
		ps.setString(5,ap.getSex());
		ps.setString(6,ap.getSize());
		ps.setInt(7,ap.getQty());

		int j=ps.executeUpdate();
		
		System.out.println(j);
		if(j>0)
		{
			return true;
			
		}
		
		
		return false;
		
	}

}
