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
 * Servlet implementation class payment
 */
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList();
		String querystring;
		Connection con=DBConnection.getConnection();
		try
		{
			Statement stmt=con.createStatement();
			querystring="select supplierid_i,suppliername_v from supplier_tbl";
			ResultSet rs=stmt.executeQuery(querystring);
			while(rs.next())
			{
				dataList.add(rs.getInt("supplierid_i"));
				dataList.add(rs.getString("suppliername_v"));
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("data",dataList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("payment.jsp");
		if(dispatcher!= null)
		{
			 dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
