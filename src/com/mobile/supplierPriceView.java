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
 * Servlet implementation class supplierPriceView
 */
public class supplierPriceView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierPriceView() {
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
		List model = new ArrayList();
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
			 dataList.put("Id",id);
			 dataList.put("supplier",rs.getString("suppliername_v"));
			 dataList.put("CP Name", rs.getString("cp_name_v"));
			 dataList.put("CP No", rs.getString("cp_no_v"));
			 dataList.put("OutStanding", rs.getString("outstanding_amount_d"));
			 }
			 rs.close();
			 
			 strQueryString="SELECT brand_name_v,model_no_v,model_name_v FROM brand_tbl b "
				 +" JOIN model_tbl m ON m.brandid_i=b.brandid_i ";
			 
			 ResultSet rsmodel = s.executeQuery(strQueryString);
			 while(rsmodel.next())
			 {
				 lno=lno+1;
				 model.add(lno);
				 model.add(rsmodel.getString("brand_name_v"));
				 model.add(rsmodel.getString("model_no_v"));
				 model.add(rsmodel.getString("model_name_v"));
			 }
			 
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 request.setAttribute("data", dataList);
		 request.setAttribute("model",model);
		 //request.setAttribute("payment", payment);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("supplierPriceView.jsp");
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
