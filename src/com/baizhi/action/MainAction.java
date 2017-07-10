package com.baizhi.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.baizhi.pc.Crawler;
import com.baizhi.pc.UtilCra;

public class MainAction extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getParameter("url");
		String type = request.getParameter("type");
		String tag1 = null;
		String tag2 = null;
		switch(type){
		case "one": tag1=UtilCra.gj_Tag1; tag2=UtilCra.gj_Tag2; break;
		case "two": tag1=UtilCra.hs_Tag1; tag2=UtilCra.hs_Tag2;  break;
		}
		Crawler.getURl(url,tag1,tag2,type);
		response.sendRedirect("ok.jsp");
	}
}
