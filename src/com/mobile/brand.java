package com.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;
/**
 * Servlet implementation class brand
 */
public class brand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public brand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
 
	    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	         String brandName = request.getParameter("brandname");
	        // String transDate = request.getParameter("transdate");
	         Connection con = DBConnection.getConnection();

	        try {

	            Statement s = con.createStatement();

	         String QueryString="select max(brandid_i),now() as date from brand_tbl";
	        ResultSet rs = s.executeQuery(QueryString);

	        rs.first();
	    	int brandid=rs.getInt(1)+1;
	    	String transdate=rs.getString("date");


	        String strSQL = "Insert into brand_tbl(brandid_i,brand_name_v,created_date_dt) values (" + brandid + ",'" + brandName + "','" + transdate + "')";
	     		s.executeUpdate(strSQL);
	             
	     		con.commit();
	        }
	         catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        out.println("<head>");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("Register Success!");
	        
	        response.sendRedirect("/Mobile/brandList");
		
	}

}
