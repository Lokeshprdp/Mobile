package com.mobile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class salesView
 */
public class salesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public salesView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> dataList = new HashMap<String, String>();
		List part = new ArrayList();
		String strQueryString;
		int lno,slno;
		
		Connection con =DBConnection.getConnection();
		String id = request.getParameter("controlid");
		try
		{
			Statement st = con.createStatement();
			strQueryString=" SELECT controlid_i,DATE_FORMAT(created_date,'%d-%m-%Y') AS sales_date,bill_no, "
				+" DATE_FORMAT(bill_date,'%d-%m-%Y') AS bill_date,IF(ISNULL(customername_v),retailer_name_v,customername_v) AS customer, "
				+" total_amount FROM sales_head_tbl s "
				+" LEFT OUTER JOIN customer_tbl c ON c.customerid_i=s.customerid_i "
				+" where controlid_i="+id;
			
			ResultSet rs = st.executeQuery(strQueryString);
			while(rs.next())
			{
				dataList.put("sales no",rs.getString("controlid_i"));
				dataList.put("sales date",rs.getString("sales_date"));
				dataList.put("bill no",rs.getString("bill_no"));
				dataList.put("bill date",rs.getString("bill_date"));
				dataList.put("customer",rs.getString("customer"));
				dataList.put("total amount",rs.getString("total_amount"));
			}
			rs.close();
			
			strQueryString=" SELECT model_no_v,imei_no,quantity_i,discount_value_d,s.rate_d,tax_value_d,(value_d + tax_value_d) AS total_value "
				+" FROM sales_detail_tbl s "
				+" JOIN model_tbl m ON m.modelid_i=s.modelid_i "
				+" WHERE controlid_i="+id;
			
			ResultSet rspart = st.executeQuery(strQueryString);
			lno=1;
			while(rspart.next())
			{
				part.add(lno);
				part.add(rspart.getString("model_no_v"));
				part.add(rspart.getString("imei_no"));
				part.add(rspart.getString("quantity_i"));
				part.add(rspart.getDouble("rate_d"));
				part.add(rspart.getDouble("discount_value_d"));
				part.add(rspart.getDouble("tax_value_d"));
				part.add(rspart.getDouble("total_value"));
				lno++;
			}
			rspart.close();
			request.setAttribute("data",dataList);
			request.setAttribute("part",part);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("salesView.jsp");
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
