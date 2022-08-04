package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;


public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email,password);
		RequestDispatcher rd  = null;
		if(user == null)
		{
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("Login.jsp");
		}
		else if(user.getStatus().equalsIgnoreCase("disable")) {
			request.setAttribute("errorMsg1", "Please Talk With chairman Account is Disable");
			rd = request.getRequestDispatcher("Login.jsp");
		}
		else 
		{
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			System.out.println(user.getUserId());
			if(user.getRole().equals("user"))
			{
				rd = request.getRequestDispatcher("Home.jsp");
			}
			else if(user.getRole().equalsIgnoreCase("admin")){
				rd = request.getRequestDispatcher("Admin.jsp");
			}
			else if(user.getRole().equalsIgnoreCase("security")){
				rd = request.getRequestDispatcher("Security.jsp");
			}
			else 
			{
				rd = request.getRequestDispatcher("404.jsp");
			}
				
		}
		rd.forward(request, response);				
	}
}
		
				


