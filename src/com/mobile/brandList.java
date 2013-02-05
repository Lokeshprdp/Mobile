package com.mobile;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;

/**
 * Servlet implementation class brandList
 */
public class brandList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public brandList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList();
		int lno=0;
		
		 Connection con = DBConnection.getConnection();
		 try
		 {
			 Statement s = con.createStatement();
			 ResultSet rs=s.executeQuery("select * from brand_tbl");
			 System.out.println(rs);
			 lno=1;
			 while(rs.next())
			 {
				 dataList.add(lno);
				 dataList.add(rs.getInt("brandid_i"));
				 dataList.add(rs.getString("brand_name_v"));
				 
				 lno=lno+1;
			 }
			 rs.close();
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace(); 
		 }
		 
		 request.setAttribute("data",dataList);
		 
		 //Dispatching request
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("brandList.jsp");
		 
		 if(dispatcher!= null)
		 {
			 dispatcher.forward(request, response);
		 }
	}

}
