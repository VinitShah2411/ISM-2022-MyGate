package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.InstructionBean;
import com.util.DbConnection;

public class InstructionDao {

	public void insertInstruction(InstructionBean instruction) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into instructions (name,description,permission,approx_time) values (?,?,?,?)");) {
				pstmt.setString(1, instruction.getName());
				pstmt.setString(2, instruction.getDescription());
				pstmt.setString(3, instruction.getPermission());
				pstmt.setString(4, instruction.getApprox_time());
//				pstmt.setInt(5, instruction.getUserid());
//				pstmt.setInt(6, member.getHouseid());
				int records = pstmt.executeUpdate();
				System.out.println(records + "Data insterted");
			} catch (Exception e) {
				System.out.println("SWR in insertinstruction()");
				e.printStackTrace();
			}
		}
		
	public ArrayList<InstructionBean> getUserInstructions(int userid) {
		ArrayList<InstructionBean> instructions = new ArrayList<InstructionBean>();
		InstructionBean instruction  = null;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from instructions where userid=?");) {
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				instruction = new InstructionBean();
				instruction.setName(rs.getString("name"));
				instruction.setDescription(rs.getString("description"));
				instruction.setPermission((rs.getString("permission")));
				instruction.setApprox_time((rs.getString("approx_time")));
//				instruction.setHouseId(rs.getInt("houseId"));
				instruction.setUserid(rs.getInt("userid"));
				instructions.add(instruction);
			}
			System.out.println("hello");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SMW in InstructionDao::getUserInstructions()");
		}
		return instructions;
	}
				
	public ArrayList<InstructionBean> getAllInstructions()	{
		ArrayList<InstructionBean> instructions = new ArrayList<InstructionBean>();
		InstructionBean instruction = null;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt  = con.prepareStatement("select * from instructions");) {
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("vinit");
				instruction = new InstructionBean();
				instruction.setName(rs.getString("name"));
				instruction.setDescription(rs.getString("description"));
				instruction.setPermission((rs.getString("permission")));
				instruction.setApprox_time((rs.getString("approx_time")));
//				instruction.setHouseid(rs.getInt(""));
				instruction.setUserid(rs.getInt("userid"));
				instructions.add(instruction);
				System.out.println(instructions+"vin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SMW in InstructionDao::getAllInstructions()");
		}
		
		return instructions;
	}		
}
		
			
