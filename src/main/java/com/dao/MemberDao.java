package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.MemberBean;
import com.util.DbConnection;

public class MemberDao {

	public void insertMember(MemberBean member) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into members (firstname,contact_number,age,gender,userid,houseid) values (?,?,?,?,?,?)");) {
			pstmt.setString(1, member.getFirstname());
			pstmt.setInt(2, member.getContact_number());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getUserid());
			pstmt.setInt(6, member.getHouseid());
			int records = pstmt.executeUpdate();
			System.out.println(records + "Data insterted");
		} catch (Exception e) {
			System.out.println("SWR in insertHouse()");
			e.printStackTrace();
		}
	}

	public ArrayList<MemberBean> getAllMemberByUserId(int userid) {
		ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		MemberBean member = null;
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from houses where userid=?");
				)
		{
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberid(rs.getInt("memberid"));
				member.setFirstname(rs.getString("firstname"));
				member.setGender(rs.getString("gender"));
				member.setContact_number(rs.getInt("contact_number"));
				member.setAge(rs.getInt("age"));
				member.setHouseid(rs.getInt("houseid"));
				members.add(member);
			}
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		return members;
	}
	
	public ArrayList<MemberBean> getAllMemberByMemberId(int userid) {
	ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from members where userid=?");) {
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberBean member = new MemberBean();
				member.setUserid(rs.getInt("userid"));
				member.setFirstname(rs.getString("firstname"));
				member.setContact_number(rs.getInt("contact_number"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
//			member.setHouseId(rs.getInt("houseId"));
				member.setMemberid(rs.getInt("memberid"));
				members.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SMW in MemberDao::getMemberByMemberId()");
		}
		return members;
	}
	
	


}

