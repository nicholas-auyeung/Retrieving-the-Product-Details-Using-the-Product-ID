package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QueryServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean found = false;
		boolean invalid = false;
		int productId = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		try {
			 productId = Integer.parseInt(request.getParameter("productId"));
		}catch(NumberFormatException e){
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			invalid = true;
			out.print("Invalid product ID" + "<br/>");
		}
		String productName = "";
		String sql = "select * from product";
	
		try {
			Class.forName("org.h2.Driver"); 			
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int rsProductId = Integer.parseInt(rs.getString(1));
				if(rsProductId == productId) {
					productName = rs.getString(2);
					found = true;
				}
				
			}
			if(found) {
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.print("Product Found!" + "<br/>");
				out.print("ProductID:" + productId + "<br/>" + "Product Name: " + productName + "<br/>");
			}else if(invalid == false){
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.print("ProductID:" + productId + " is not found" + "<br/>");
			}
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			
		}
	}

}
