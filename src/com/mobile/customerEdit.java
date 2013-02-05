package com.mobile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;

/**
 * Servlet implementation class customerEdit
 */
public class customerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> dataList = new HashMap<String, String>();
		List receipt = new ArrayList();
		String strQueryString;
		int lno=0,slno=0;
				
		 Connection con = DBConnection.getConnection();
		 String id=request.getParameter("customerid");
		 
		 try
		 {
			 Statement s=con.createStatement();
			 strQueryString="select * from customer_tbl"
				 +" where customerid_i="+id;
			 ResultSet rs=s.executeQuery(strQueryString);
			 rs.first();
			 
			 dataList.put("Customer", rs.getString("customername_v"));
			 dataList.put("CP Name", rs.getString("cp_name_v"));
			 dataList.put("CP No", rs.getString("cp_no_v"));
			 dataList.put("OutStanding", rs.getString("outstanding_amount_d"));
			 
			 rs.close();
			 
			 strQueryString=" SELECT bill_no,DATE_FORMAT(bill_date,'%d-%m-%Y') AS billdate,total_amount, "  
				 	+" (total_amount - received_amount) AS bal_amount FROM sales_head_tbl " 
				 	+" WHERE customerid_i="+id;
			 
			 ResultSet rsReceipt =s.executeQuery(strQueryString);
			 while(rsReceipt.next())
			 {
				 lno=lno+1;
				receipt.add(lno);
				receipt.add(rsReceipt.getString("bill_no"));
				receipt.add(rsReceipt.getString("billdate"));
				receipt.add(rsReceipt.getString("total_amount"));
				receipt.add(rsReceipt.getString("bal_amount"));
			 }
			 rsReceipt.close();
			 
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 request.setAttribute("data", dataList);
		 request.setAttribute("receipt", receipt);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("customerEdit.jsp");
		 if(dispatcher!= null)
		 {
			 dispatcher.forward(request, response);
		 }
	}
}
