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
 * Servlet implementation class purchaseView
 */
public class purchaseView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String>dataList = new HashMap<String, String>();
		List part = new ArrayList();
		String strQueryString;
		int lno,slno;
		
		Connection con = DBConnection.getConnection();
		String id=request.getParameter("controlid");
		
		try
		{
			Statement s = con.createStatement();
			strQueryString=" SELECT controlid_i,DATE_FORMAT(created_date,'%d-%m-%Y')AS purchase_date,bill_no, "
				+" DATE_FORMAT(bill_date,'%d-%m-%Y') AS bill_date,suppliername_v,total_amount FROM purchase_head_tbl p "
				+" JOIN supplier_tbl s ON s.supplierid_i=p.supplierid_i "
				+" WHERE controlid_i="+id;
			
			ResultSet rs=s.executeQuery(strQueryString);
			while(rs.next())
			{
				dataList.put("purchase no",rs.getString("controlid_i"));
				dataList.put("purchase date",rs.getString("purchase_date"));
				dataList.put("bill no",rs.getString("bill_no"));
				dataList.put("bill date",rs.getString("bill_date"));
				dataList.put("supplier",rs.getString("suppliername_v"));
				dataList.put("total amount",rs.getString("total_amount"));
				
			}
			rs.close();
			
			strQueryString=" SELECT model_no_v,quantity_i,p.rate_d,tax_value_d,(value_d + tax_value_d) AS total_value "
				+" FROM purchase_detail_tbl p "
				+" JOIN model_tbl m ON m.modelid_i=p.modelid_i "
				+" where controlid_i="+id;
			
			ResultSet rspart = s.executeQuery(strQueryString);
			lno=1;
			while(rspart.next())
			{
				part.add(lno);
				part.add(rspart.getString("model_no_v"));
				part.add(rspart.getString("quantity_i"));
				part.add(rspart.getDouble("rate_d"));
				part.add(rspart.getDouble("tax_value_d"));
				part.add(rspart.getDouble("total_value"));
				lno++;
			}
			request.setAttribute("data",dataList);
			request.setAttribute("part",part);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseView.jsp");
			if(dispatcher!= null)
			{
				dispatcher.forward(request, response);
			}  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
