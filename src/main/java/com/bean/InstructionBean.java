package com.bean;

public class InstructionBean {
	String name;
	String description;
	String permission;
	int houseid;
	int userid;
	int instructionid;

	public int getInstructionid() {
		return instructionid;
	}

	public void setInstructionid(int instructionid) {
		this.instructionid = instructionid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getApprox_time() {
		return approx_time;
	}

	public void setApprox_time(String approx_time) {
		this.approx_time = approx_time;
	}

	String approx_time;
}
