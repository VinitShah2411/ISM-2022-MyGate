package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.bean.MemberBean;
import com.util.DbConnection;

public class HouseDao {
	public void insertHouse(HouseBean house) {

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into houses (owner_name,house_number,block,userid,floor,house_details) values (?,?,?,?,?,?)");) {
			pstmt.setString(1, house.getOwnner_name());
//			pstmt.setInt(2, house.getHouseid());
			pstmt.setInt(2, house.getHouse_number());
			pstmt.setString(3, house.getBlock());
			pstmt.setInt(4, house.getUserid());
			pstmt.setInt(5, house.getFloor());
			pstmt.setString(6, house.getHouse_details());
			int records = pstmt.executeUpdate();
			System.out.println(records + "Data insterted");
		} catch (Exception e) {
			System.out.println("SWR in insertHouse()");
			e.printStackTrace();
		}
	}

	public ArrayList<HouseBean> getAllHouseDetailsByUserId(int userid) 
	{
	  ArrayList<HouseBean> houses = new ArrayList<HouseBean>(); 
	  HouseBean house = null; 
	  try ( Connection con = DbConnection.getConnection(); 
			  PreparedStatement pstmt = con.prepareStatement("select * from houses where userid=?"); ) {
	  pstmt.setInt(1, userid); ResultSet rs = pstmt.executeQuery();
	  
	  while(rs.next()) { house = new HouseBean();
	  house.setUserid(rs.getInt("userid"));
	  house.setHouseid(rs.getInt("houseid"));
	  house.setOwnner_name(rs.getString("ownner_name"));
	  house.setHouse_details(rs.getString("house_details"));
	  house.setHouse_number(rs.getInt("house_number")); 
	  house.setFloor(rs.getInt("floor"));
	  houses.add(house); 
	 } 
	} catch(Exception e)
	  { 
		e.printStackTrace(); 
	  }
	  return houses;
	  }
	  
	 
}
