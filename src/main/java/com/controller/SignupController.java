package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;


public class SignupController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String role = request.getParameter("role");
		String contact_no = request.getParameter("contact_no");
		UserDao userDao = new UserDao();
		UserBean user = new UserBean();
		
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		user.setRole(role);
		user.setContact_no(contact_no);
		userDao.insertuser(user);
		response.sendRedirect("Login.jsp");
	}

}
