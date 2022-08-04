package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;


public class UserDao {
	
	public void insertuser(UserBean user) {
		
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into users (firstname,lastname,email,password,gender,contact_no,role,status) values (?,?,?,?,?,?,'user','disable')");) {
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getContact_no());
			int records = pstmt.executeUpdate();
			System.out.println(records + "Data insterted");
		} catch (Exception e) {
			System.out.println("SWR in insertUser()");
			e.printStackTrace();
		}
	}
	
	public UserBean login(String email, String password) {
		
		UserBean user = null;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where email=? and password=?")) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
//			System.out.println(email+password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) 
			{
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
			} 
		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<UserBean> getAllUsers(int userId) {
		ArrayList<UserBean> users = new ArrayList<>();
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users"); )
		{
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setStatus(rs.getString("status"));
				user.setUserId(rs.getInt("userid"));
				users.add(user);  
			}
		} catch (Exception e) {
			System.out.println("SMW :: userDao::getAllUsers()");
			e.printStackTrace();
		}
		return users;
	}

	public boolean deleteUser(int userId) {
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where userid=?");){
			pstmt.setInt(1, userId);
			
			int deleteRow = pstmt.executeUpdate();
			if(deleteRow==1)
			{
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public boolean enableUser(int userId) {
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set status=? where userid=?");){
			pstmt.setString(1, "enable");
			pstmt.setInt(2, userId);
			
			int updateStatus = pstmt.executeUpdate();
			if(updateStatus==1)
			{
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean disableUser(int userId) {
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set status=? where userid=?");){
			pstmt.setString(1, "disable");
			pstmt.setInt(2, userId);
			
			int updateStatus = pstmt.executeUpdate();
			if(updateStatus==1)
			{
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}



		
		
		

	
