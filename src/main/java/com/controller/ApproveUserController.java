package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

public class ApproveUserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userid"));
//		System.out.println(taskId);
		UserDao userDao = new UserDao();
		if (userDao.enableUser(userId)) {
			request.setAttribute("msg", "Task Deleted Successfully");
		} else {
			request.setAttribute("msg", "Some error Occured in Dao");
		}
		request.getRequestDispatcher("ListUserController").forward(request, response);
	}
}
