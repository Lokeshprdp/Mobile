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
 * Servlet implementation class purchaseList
 */
public class purchaseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseList() {
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
			Statement s =con.createStatement();
			ResultSet rs=s.executeQuery("SELECT controlid_i as id,controlid_i as purchase_no,DATE_FORMAT(created_date,'%d/%m/%Y') AS purchase_date, "
				+" suppliername_v,bill_no,DATE_FORMAT(bill_date,'%d/%m/%Y') AS bill_date "
				+" FROM purchase_head_tbl p "
				+" JOIN supplier_tbl s ON s.supplierid_i=p.supplierid_i");
			lno=1;
			while(rs.next())
			{
				dataList.add(lno);
				dataList.add(rs.getInt("id"));
				dataList.add(rs.getInt("purchase_no"));
				dataList.add(rs.getString("purchase_date"));
				dataList.add(rs.getString("suppliername_v"));
				dataList.add(rs.getString("bill_no"));
				dataList.add(rs.getString("bill_date"));
				
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
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseList.jsp");
		 
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
