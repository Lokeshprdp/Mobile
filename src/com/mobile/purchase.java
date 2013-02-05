package com.mobile;

import java.io.IOException;
import java.sql.*;
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
 * Servlet implementation class purchase
 */
public class purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList();
		List dataList1 = new ArrayList();
		List supplier = new ArrayList();
		
		String QueryString;
		Connection con = DBConnection.getConnection();
		try
		{
			Statement stmt=con.createStatement();
			
			QueryString=" select supplierid_i,suppliername_v from supplier_tbl ";
			ResultSet rssupplier=stmt.executeQuery(QueryString);
			while(rssupplier.next())
			{
				supplier.add(rssupplier.getString("supplierid_i"));
				supplier.add(rssupplier.getString("suppliername_v"));
			}	
			rssupplier.close();
			
			QueryString=" SELECT brandid_i,brand_name_v from brand_tbl ";
			ResultSet rs=stmt.executeQuery(QueryString);
			while(rs.next())
			{
				dataList.add(rs.getString("brandid_i"));
				dataList.add(rs.getString("brand_name_v"));
			}
			rs.close();
			
			QueryString=" select modelid_i, model_no_v from model_tbl";
			ResultSet rsmodel = stmt.executeQuery(QueryString);
			while(rsmodel.next())
			{
			   dataList1.add(rsmodel.getString("modelid_i"));
			   dataList1.add(rsmodel.getString("model_no_v"));
			}
			rsmodel.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("data",dataList);
		request.setAttribute("data1",dataList1);
		request.setAttribute("supplier",supplier);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase.jsp");
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
		
		String strInsertString,strUpdateString;
		double totalval=0;
		double tax_value;
		int rowscnt = Integer.parseInt(request.getParameter("itemCount"));
		
		 Connection con = DBConnection.getConnection();
		 String rows=request.getParameter("itemCount");
		 
		 System.out.println(rows);
		 try
		 {
			 Statement s = con.createStatement();
			 String QueryString="select max(controlid_i) from purchase_head_tbl";
		     ResultSet rs = s.executeQuery(QueryString);

		        rs.first();
		    	int controlid=rs.getInt(1)+1;
		   
		    if(rowscnt>0)
		    {
			 strInsertString="insert into purchase_detail_tbl (controlid_i,slno,brandid_i,"
				 +"modelid_i,quantity_i,rate_d,value_d,tax_percentage_d,tax_value_d) values ";
		 
		 for(int i=1; i<=rowscnt; i++)
		 {
			 tax_value=0.00;
			 
			 tax_value=(Float.parseFloat(request.getParameter("total"+i))* Float.parseFloat(request.getParameter("tax"+i))/100);
			 totalval=totalval+Float.parseFloat(request.getParameter("total"+i))+tax_value;
			 
			 strInsertString=strInsertString +"("
			 +" "+ controlid +", "+i+", '"+request.getParameter("brand"+i)+"', '"+ request.getParameter("model"+i) +"',"
			 +" '"+request.getParameter("qty"+i) +"', '"+ request.getParameter("rate"+i) +"', '"+request.getParameter("total"+i)+"', "
			 +" '"+request.getParameter("tax"+i) +"', '"+ tax_value +"' ) ";
			 
			 if(i != rowscnt)
			 {
				 strInsertString = strInsertString+",";
			 }
			 
			 strUpdateString="update stock_tbl set quantity_i="
				 +" quantity_i + "	 
				 +"	 '"+request.getParameter("qty"+i)+"'"
				 +" where stockid_i= "+request.getParameter("model"+i);
			 	 //System.out.println(strUpdateString);
			 	 s.executeUpdate(strUpdateString);
			 
			 strUpdateString="update supplier_tbl set outstanding_amount_d="
				 +" outstanding_amount_d + "
				 +" '"+request.getParameter("total"+i)+"'"
				 +" where supplierid_i= "+request.getParameter("supplier");
				 //System.out.println(strUpdateString);
				 s.executeUpdate(strUpdateString);
		 }
	
		 
		//System.out.println("<br>Delivery Tbl:"+strInsertString);
		s.executeUpdate(strInsertString);
		//System.out.println("Completed");
		
		strInsertString="insert into purchase_head_tbl (controlid_i,supplierid_i,bill_no,"
			+"bill_date,total_amount,created_by_i,created_date) values ("
			+" "+controlid+", '"+request.getParameter("supplier")+"', '"+request.getParameter("billno")+"', "
			+" '"+dtFormatyyyymmdd(request.getParameter("billdate"))+"', "+totalval+", 1, now())";
			
		//System.out.println("<br>Delivery Tbl:"+strInsertString);
		s.executeUpdate(strInsertString);
		//System.out.println("Completed");
		 
		// System.out.println(rows);
		    }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 response.sendRedirect("/Mobile/purchaseList");
	}
	private String dtFormatyyyymmdd(String strDate) {

		if(strDate == "" || strDate == null || strDate.equals(""))
		{
			strDate="NIL";
			return strDate;
		}
		strDate=strDate.substring(6,10)+"-"+strDate.substring(3,5)+"-"+strDate.substring(0,2);
		return strDate;
	}
}
