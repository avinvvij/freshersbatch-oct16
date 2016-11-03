package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet(urlPatterns = "/hello" , initParams = {@WebInitParam(name = "hello" ,value = "hello abc world"),@WebInitParam(name = "yo",value="home")})

public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String globalname = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		globalname = getInitParameter("yo");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		if(uname.equals(pass)){
			pr.println("<html><body><h1>Authentication success "+globalname+" </h1></body></html>");
		}else{
			pr.println("<html><body><h1>Authentication Failed</h1></body></html>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
