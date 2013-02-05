package com.mobile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;

/**
 * Servlet implementation class brandEdit
 */
public class brandEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public brandEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList();
		String QueryString;
		int lno;
		
		Connection con = DBConnection.getConnection();
		String id =request.getParameter("brandid");
		try
		{
			Statement stmt=con.createStatement();
			
				QueryString=" SELECT brand_name_v,model_no_v,rate_d,wholesale_rate1_d,wholesale_rate2_d, "
				+" customer_rate_d FROM model_tbl m "
				+" JOIN brand_tbl b ON b.brandid_i=m.brandid_i "
				+" where b.brandid_i="+id;
			
			ResultSet rs= stmt.executeQuery(QueryString);
			
			lno=1;
			while(rs.next())
			{
				dataList.add(lno);
				dataList.add(rs.getString("model_no_v"));
				dataList.add(rs.getString("rate_d"));
				dataList.add(rs.getString("wholesale_rate1_d"));
				dataList.add(rs.getString("wholesale_rate2_d"));
				dataList.add(rs.getString("customer_rate_d"));
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("brandEdit.jsp");
		 
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
