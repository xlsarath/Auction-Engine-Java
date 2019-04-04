package com.hcl.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.jsh.model.*;

public class SearchDAO {
	PreparedStatement ps;
	DBConnection db=new DBConnection();
	ResultSet rs;
	Connection con=null;
	Search s= new Search();
	
	public List<Search> searchPet(Search s) throws SQLException {
		
		List<Search> petlist= new ArrayList<Search>();
		
		con=db.dbConnect();

		
		String sql="SELECT * FROM PETS WHERE PET_TYPE LIKE '"+s.getType()+"'";
		
		if((s.getSize()).length()!=0 && (s.getSize()).length()>0)
			sql=sql+ "AND PET_SIZE LIKE'"+s.getSize()+"'";
		if((s.getName()).length()!=0 && (s.getName()).length()>0)
			sql=sql+"AND PET_NAME LIKE'"+s.getName()+"'";
		if((s.getAge())!=0 && (s.getAge())>0 )
			sql=sql+"AND PET_AGE LIKE "+s.getAge()+"";
		if((s.getPlace()).length()!=0 && (s.getPlace()).length()>0)
			sql=sql+"AND PET_PLACE LIKE '"+s.getPlace()+"'";
		
			
		//System.out.println(sql);
		
		ps= con.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
		
		s.setName(rs.getString("pet_name"));
		s.setAge(rs.getInt("pet_age"));
		s.setPlace(rs.getString("pet_place"));
		s.setSize(rs.getString("pet_size"));
		s.setType(rs.getString("pet_type"));
		s.setId(rs.getInt("ID"));;
		s.setSex(rs.getString("pet_sex"));
		s.setAvmQty(rs.getInt("avl_qty"));
		petlist.add(s);	
		
		}
		return petlist;
		
		
		
			
	}


		
		
		
	}

