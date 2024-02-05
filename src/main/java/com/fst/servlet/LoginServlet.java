package com.fst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//accept username and password from index.html
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//DataBase
		
		try {
			//open connection
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			 Statement stm=con.createStatement();
			 ResultSet rs =stm.executeQuery("select * from login where username='"+username+"' and password='"+password+"'   ");
			 if(rs.next()) {
				 //if username and password true than go to home.html file
				 response.sendRedirect("ListEmailView.jsp");
				 
			 }else {
				 //wrong username and password
				 
				 out.println("wrong username and password");
			 }
			 con.close();
			 
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		
	}

}
