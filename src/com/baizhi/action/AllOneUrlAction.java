package com.baizhi.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.jdbc.SaveMongoDAO;
import com.baizhi.jdbc.SaveMongoImpl;
import com.mongodb.DBObject;

public class AllOneUrlAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SaveMongoDAO saveMongoDAO = new SaveMongoImpl();
		String page = request.getParameter("page");
		if(page==null) page="0";
		Integer valueOf = Integer.valueOf(page);
		List<DBObject> findAll = saveMongoDAO.findAll(valueOf*20);
		// TODO Auto-generated method stub
		request.setAttribute("allUrl",findAll);
		request.setAttribute("page",page);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
}
