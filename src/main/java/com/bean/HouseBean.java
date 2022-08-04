package com.bean;

public class HouseBean {
	
	int houseid;
	String owner_name;
	int house_number; 
	String block;
	int userid;
	int floor;
	String house_details;
	public String getOwnner_name() {
		return owner_name;
	}
	public void setOwnner_name(String ownner_name) {
		this.owner_name = ownner_name;
	}
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public int getHouse_number() {
		return house_number;
	}
	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getHouse_details() {
		return house_details;
	}
	public void setHouse_details(String house_details) {
		this.house_details = house_details;
	}
}
