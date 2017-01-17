package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.model.UserBean;

public class UserDAO {
	
	Connection con;
	
	public UserDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dec2016","root","root");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int deleteUser(String id) {
		int x = 0;
		try{
			PreparedStatement ps = con.prepareStatement("delete from user where uname = ?");
			ps.setString(1, id);
			x = ps.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public int insertUser(UserBean user) {
		int x = 0;
		try{
			PreparedStatement ps = con.prepareStatement("insert into user values(?, ?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			x = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public String listUser() {
		String users = "";
		
		try{
			
			ResultSet rs = con.createStatement().executeQuery("select * from user");
			while(rs.next()) {
				users += "<tr>" +
					"<td>" + rs.getString(1) + "</td>" +
					"<td>" + rs.getString(2) + "</td>" +
					"<td>" +
						"<img src=\"images/edit.png\" />" +
					"</td>" +
					"<td>" +
						"<a href=\"delete.jsp?id=" + rs.getString(1) + "\" ><img src=\"images/delete.png\" />" +
					"</td>" +
				"</tr>";
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
