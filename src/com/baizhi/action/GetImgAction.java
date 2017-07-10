package com.baizhi.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.jdbc.SaveMongoDAO;
import com.baizhi.jdbc.SaveMongoImpl;
import com.baizhi.pc.RunA;
import com.baizhi.pc.SaveImg;
import com.mongodb.DBObject;

public class GetImgAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SaveMongoDAO saveMongoDAO = new SaveMongoImpl();
		RunA.allCount=saveMongoDAO.findAllUrl().size();
		String parameter = request.getParameter("count");
		if(parameter==null) parameter="0";
		Integer count = Integer.valueOf(parameter);
		RunA r = new RunA();
		for(int i=0;i<count;i++){
			new Thread(r).start();
		}
		response.sendRedirect("allHF");
	}
}
