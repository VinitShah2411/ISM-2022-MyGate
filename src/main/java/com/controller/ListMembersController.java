package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MemberBean;
import com.dao.MemberDao;

public class ListMembersController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		System.out.println(userid+"vinit");
		MemberDao memberDao = new MemberDao();
	ArrayList<MemberBean> members = memberDao.getAllMemberByMemberId(userid);
		request.setAttribute("members", members);
		System.out.println(members);
		request.getRequestDispatcher("ListMembers.jsp").forward(request, response);
	}
}
		
		

