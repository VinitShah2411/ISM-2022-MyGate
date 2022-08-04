package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HouseBean;
import com.dao.HouseDao;

public class AddHouseController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String owner_name = request.getParameter("owner_name");
		int house_number = Integer.parseInt(request.getParameter("house_number"));
		String block = request.getParameter("block");
		int floor = Integer.parseInt(request.getParameter("floor"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		String house_details = request.getParameter("house_details");

		HouseDao houseDao = new HouseDao();
		HouseBean house = new HouseBean();
		house.setOwnner_name(owner_name);
		house.setHouse_number(house_number);
		house.setBlock(block);
		house.setFloor(floor);
		house.setHouse_details(house_details);
		house.setUserid(userid);
		houseDao.insertHouse(house);
		response.sendRedirect("ListUserController");
	}
}

	
