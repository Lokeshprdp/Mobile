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
 * Servlet implementation class salesList
 */
public class salesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public salesList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList();
		int lno = 0;
		Connection con = DBConnection.getConnection();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(" SELECT controlid_i AS id,controlid_i AS sales_no,DATE_FORMAT(created_date,'%d-%m-%Y') AS sales_date, "
					+" IF(ISNULL(customername_v),retailer_name_v,customername_v) AS customer, "
					+" bill_no,DATE_FORMAT(bill_date,'%d-%m-%Y') AS bill_date " 
					+" FROM sales_head_tbl s "
					+" LEFT OUTER JOIN customer_tbl c ON c.customerid_i=s.customerid_i");
			lno=1;
			while(rs.next())
			{
				dataList.add(lno);
				dataList.add(rs.getInt("id"));
				dataList.add(rs.getString("sales_no"));
				dataList.add(rs.getString("sales_date"));
				dataList.add(rs.getString("customer"));
				dataList.add(rs.getString("bill_no"));
				dataList.add(rs.getString("bill_date"));
				lno=lno+1;
			}
			rs.close();
			request.setAttribute("data",dataList);
			 
			 //Dispatching request
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("salesList.jsp");
			 
			 if(dispatcher!= null)
			 {
				 dispatcher.forward(request, response);
			 }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
