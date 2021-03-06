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
			PreparedStatement ps = con.prepareStatement("delete from user where userid = ?");
			ps.setString(1, id);
			x = ps.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public int registerUser(UserBean user) {
		int x = 0;
		try{
			PreparedStatement ps = con.prepareStatement("insert into user(uname, pword) values(?, ?)");
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
					"<td class=\"name\">" + rs.getString(2) + "</td>" +
					"<td class=\"pwd\">" + rs.getString(3) + "</td>" +
					"<td>" +
						"<img src=\"images/edit.png\" class=\"editButton\" />" +
						"<img id =\"" + rs.getInt(1) + "\" style=\"display:none\" src=\"images/save.png\" class=\"saveButton\" />" +
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
	
	public void updateUser(int id, String username, String pwd) {		
		
		try{
			con.createStatement().executeUpdate("update user " + 
												"set uname=\"" + username + "\" ," +
												" pword=\"" + pwd +
												"\" where userid= " + id);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public int addUser(String username, String pwd) {
		int x = 0;
		try{
			PreparedStatement ps = con.prepareStatement("insert into user(uname, pword) values(?, ?)");
			ps.setString(1, username);
			ps.setString(2, pwd);
			x = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
}
