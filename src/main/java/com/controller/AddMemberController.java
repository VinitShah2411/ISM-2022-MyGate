package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MemberBean;
import com.dao.MemberDao;

public class AddMemberController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String firstname = request.getParameter("firstname");
		int contact_number = Integer.parseInt(request.getParameter("contact_number"));
		int age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender");
		int userid = (Integer) session.getAttribute("userId");
		System.out.println(userid);
		MemberDao memberDao = new MemberDao();
		MemberBean member = new MemberBean();
		
		member.setFirstname(firstname);
		member.setContact_number(contact_number);
		member.setAge(age);
		member.setGender(gender);
		member.setUserid(userid);
		memberDao.insertMember(member);
		response.sendRedirect("Home.jsp");
	}
}
		

