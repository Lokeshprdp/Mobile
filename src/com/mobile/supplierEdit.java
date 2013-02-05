package com.mobile;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;

/**
 * Servlet implementation class supplierEdit
 */
public class supplierEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> dataList = new HashMap<String, String>();
		//List dataList = new ArrayList();
		List payment = new ArrayList();
		String strQueryString;
		int lno=0,slno=0;
				
		 Connection con = DBConnection.getConnection();
		 String id=request.getParameter("supplierid");
		 
		 try
		 {
			 Statement s=con.createStatement();
			 strQueryString="select * from supplier_tbl"
				 +" where supplierid_i="+id;
			 ResultSet rs=s.executeQuery(strQueryString);
			 //System.out.println(strQueryString);
			 while(rs.next())
			 {
			 dataList.put("supplier",rs.getString("suppliername_v"));
			 dataList.put("CP Name", rs.getString("cp_name_v"));
			 dataList.put("CP No", rs.getString("cp_no_v"));
			 dataList.put("OutStanding", rs.getString("outstanding_amount_d"));
			 }
			 rs.close();
			 
			 strQueryString=" SELECT controlid_i,bill_no,DATE_FORMAT(bill_date,'%d-%m-%Y') AS billdate,total_amount, " 
			 		+" (total_amount - paid_amount) AS bal_amount FROM purchase_head_tbl "
			 		+" where supplierid_i="+id;
			 
			 ResultSet rsPayment =s.executeQuery(strQueryString);
			 while(rsPayment.next())
			 {
				 lno=lno+1;
				payment.add(lno);
				payment.add(rsPayment.getString("controlid_i"));
				payment.add(rsPayment.getString("bill_no"));
				payment.add(rsPayment.getString("billdate"));
				payment.add(rsPayment.getString("total_amount"));
				payment.add(rsPayment.getString("bal_amount"));
			 }
			 rsPayment.close();
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 request.setAttribute("data", dataList);
		 request.setAttribute("payment", payment);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("supplierEdit.jsp");
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
		
		System.out.println("test");
		String updateString;
		//int rowcnt = Integer.parseInt(request.getParameter("itemcount"));
		Connection con = DBConnection.getConnection();
		try{
			
			Statement stmt = con.createStatement();
			
			/* for(int i=1; i<=rowcnt; i++)
			 {
				 updateString="update purchase_tbl set "
					 +" paid_amount = paid_amount " 
					 + request.getParameter("payamount"+i)
					 +" where bill_no="+request.getParameter("payment");
				 
				 //stmt.executeUpdate(updateString);
				 System.out.println(updateString);
				 
				 
			 } */
		} 
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
		
		
	}

}
