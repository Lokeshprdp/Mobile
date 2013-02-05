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
 * Servlet implementation class supplierPriceList
 */
public class supplierPriceList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierPriceList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList(); 
		String strQueryString;
		int lno=0;
		int id=0;
		
		 Connection con = DBConnection.getConnection();
		 
		 try
		 {
			 Statement s = con.createStatement();
			 strQueryString="select supplierid_i,suppliername_v from supplier_tbl";
			 ResultSet rs=s.executeQuery(strQueryString);
			 
			 lno=1;
			 while(rs.next())
			 {
				 dataList.add(lno);
				 dataList.add(rs.getInt("supplierid_i"));
				 dataList.add(rs.getString("suppliername_v"));
				 
				 lno=lno+1;
				 
				 //request.setAttribute("id", id);
			 }
			 rs.close();
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace(); 
		 }
		 
		 request.setAttribute("data",dataList);
		 
		 //Dispatching request
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("supplierPriceList.jsp");
		 
		 if(dispatcher!= null)
		 {
			 dispatcher.forward(request, response);
		 }
	
	}

}
