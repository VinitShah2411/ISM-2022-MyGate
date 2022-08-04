package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.bean.MemberBean;
import com.dao.InstructionDao;
import com.dao.MemberDao;

public class NoteforSecurityController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		System.out.println(userid);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String permission = request.getParameter("permission");
//		int houseid = Integer.parseInt(request.getParameter("houseid"));
		String approx_time = request.getParameter("approx_time");
		InstructionDao instructionDao = new InstructionDao();
		InstructionBean instruction = new InstructionBean();
		
		instruction.setName(name);
		instruction.setDescription(description);
		instruction.setPermission(permission);
//		instruction.setHouseid(houseid);
		instruction.setApprox_time(approx_time);
		instructionDao.insertInstruction(instruction);
		response.sendRedirect("Instruction.jsp");
	}
}
			
			


