package com.bway.webdemo.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bway.webdemo.model.Student;

import dbConn.Dbconn;

public class UserServiceimpl implements UserService {
	List<Student> list = new ArrayList<>();
	List<Student> lis = new ArrayList<Student>();
	@Override
		public List<Student> getall() {
			
			Connection con = Dbconn.getconn();
			String sql = "select * from user";
			
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					Student s = new Student();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setEmail(rs.getString("email"));
					s.setPassword(rs.getString("password"));
					s.setGender(rs.getString("gender"));
					s.setDob(rs.getString("dob"));
					s.setTextarea(rs.getString("textarea"));
					s.setCity(rs.getString("city"));
					s.setState(rs.getString("state"));
					s.setCountry(rs.getString("country"));
					s.setPhone(rs.getString("phone"));
					list.add(s);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	@Override
	public boolean login(String name, String password) {
		Connection con = Dbconn.getconn();
	   String sql = "select * from user where name ='"+name+"' and password = '"+password+"'";
	  try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return false;
	   
	   
		
		
		
		
		
		
	}
	@Override
	public void aprovedUser(int id) {
		Connection con = Dbconn.getconn();
		String sql = "Select * from user where id ='"+id+"'";
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Student s = new Student();
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("Email"));
				s.setPassword(rs.getString("password"));
				s.setGender(rs.getString("gender"));
				s.setDob(rs.getString("dob"));
				s.setTextarea(rs.getString("textarea"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setPhone(rs.getString("phone"));
				lis.add(s);
				
			}
			
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Student> getAproveList() {
		
		return lis;
	}


}
