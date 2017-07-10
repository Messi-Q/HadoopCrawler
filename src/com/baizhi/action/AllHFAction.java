package com.baizhi.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.jdbc.SaveDetailsMongo;
import com.baizhi.jdbc.SaveMongoDAO;
import com.baizhi.jdbc.SaveMongoImpl;
import com.baizhi.pc.RunA;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AllHFAction extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DBObject> find = SaveDetailsMongo.find();
		request.setAttribute("list", find);
		request.getRequestDispatcher("allPhone.jsp").forward(request, response);
	}
}
