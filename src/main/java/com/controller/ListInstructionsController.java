package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.dao.InstructionDao;

public class ListInstructionsController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
//		System.out.println(userid);
		InstructionDao instructionDao = new InstructionDao();
		ArrayList<InstructionBean> instructions = instructionDao.getUserInstructions(userid);
		request.setAttribute("instructions", instructions);
		System.out.println(instructions);
		request.getRequestDispatcher("ListInstructions.jsp").forward(request, response);
	}
}
