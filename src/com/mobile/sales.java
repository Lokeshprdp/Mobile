package com.mobile;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;
import com.mobile.functions.javaFunctions;

/**
 * Servlet implementation class sales
 */
public class sales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List customer = new ArrayList(); 
		List dataList = new ArrayList();
		List dataList1 = new ArrayList();
		
		String QueryString;
		Connection con = DBConnection.getConnection();
		
		try
		{
			Statement s=con.createStatement();
			QueryString=" select customerid_i,customername_v from customer_tbl ";
			ResultSet rscustomer=s.executeQuery(QueryString);
			while(rscustomer.next())
			{
				customer.add(rscustomer.getString("customerid_i"));
				customer.add(rscustomer.getString("customername_v"));
			}
			rscustomer.close();
			
			QueryString=" SELECT brandid_i,brand_name_v from brand_tbl ";
			ResultSet rs=s.executeQuery(QueryString);
			while(rs.next())
			{
				dataList.add(rs.getString("brandid_i"));
				dataList.add(rs.getString("brand_name_v"));
			}
			rs.close();
			
			QueryString=" select modelid_i, model_no_v from model_tbl";
			ResultSet rsmodel = s.executeQuery(QueryString);
			while(rsmodel.next())
			{
			   dataList1.add(rsmodel.getString("modelid_i"));
			   dataList1.add(rsmodel.getString("model_no_v"));
			}
			rsmodel.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("customer", customer);
		request.setAttribute("data", dataList);
		request.setAttribute("data1", dataList1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sales.jsp");
		if(dispatcher != null)
		{
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String InsertString,UpdateString,QueryString;
		double totalval=0;
		double tax_value;
		int rowscnt = Integer.parseInt(request.getParameter("itemCount"));
		
		 Connection con = DBConnection.getConnection();
		 String rows=request.getParameter("itemCount");
		 try
		 {
			 Statement stmt=con.createStatement();
			 QueryString="select max(controlid_i) from sales_head_tbl";
			 System.out.println(QueryString);
			 ResultSet rs=stmt.executeQuery(QueryString);
			 rs.first();
			 
			 int controlid=rs.getInt(1)+1;
			 
			 if(rowscnt>0)
			 {
				 InsertString="insert into sales_detail_tbl (controlid_i,slno,brandid_i,"
					 +"modelid_i,imei_no,quantity_i,rate_d,discount_d,discount_value_d,value_d,tax_value_d) values ";
				 
				 for(int i=1; i<=rowscnt; i++)
				 {
					 tax_value=0.00;
					 //totalval=totalval+Float.parseFloat(request.getParameter("total"+i));
					 //value=( Float.parseFloat(request.getParameter("rate"+i)) * Float.parseFloat(request.getParameter("qty"+i)));
					 
					 tax_value=(Float.parseFloat(request.getParameter("total"+i))*5/100);
					 totalval=totalval+Float.parseFloat(request.getParameter("total"+i))+tax_value;
					 
					 InsertString=InsertString +"("
					 +" "+controlid+", "+i+", '"+request.getParameter("brand"+i)+"', '"+request.getParameter("model"+i)+"','"+request.getParameter("imei"+i)+"',"
					 +" '"+request.getParameter("qty"+i)+"', '"+request.getParameter("rate"+i)+"','"+request.getParameter("disper"+i)+"',"
					 +" '"+request.getParameter("disvalue"+i)+"', '"+request.getParameter("total"+i)+"','"+tax_value+"') ";
					 
					 if(i != rowscnt)
					 {
						 InsertString = InsertString+",";
					 }
					 
					 UpdateString="update stock_tbl set quantity_i="
					 	 +" quantity_i - "	 
					 	 +"	 '"+request.getParameter("qty"+i)+"'"
					 	 +" where stockid_i= "+request.getParameter("model"+i);
					 	 //System.out.println(UpdateString);
					 	 stmt.executeUpdate(UpdateString);
					 	 
					 UpdateString="update customer_tbl set outstanding_amount_d="
						 +" outstanding_amount_d + "
						 +" '"+request.getParameter("total"+i)+"'"
						 +" where customerid_i= "+request.getParameter("customer");
						 //System.out.println(UpdateString);
						 stmt.executeUpdate(UpdateString);
				 }
				 //System.out.println(totalval);
				 //System.out.println("<br>Delivery Tbl:"+InsertString);
					stmt.executeUpdate(InsertString);
					//System.out.println("Completed");
					
				if(request.getParameter("customer").equals("0"))
				{
					InsertString="insert into sales_head_tbl (controlid_i,retailer_name_v,bill_no,"
						+"bill_date,total_amount,received_amount,created_by_i,created_date) values ("
						+" "+controlid+", '"+request.getParameter("retail")+"', '"+request.getParameter("billno")+"', "
						+" '"+dtFormatyyyymmdd(request.getParameter("billdate"))+"', "+totalval+", "+totalval+",1, now())";
				}
				else
				{
					InsertString="insert into sales_head_tbl (controlid_i,customerid_i,bill_no,"
						+"bill_date,total_amount,created_by_i,created_date) values ("
						+" "+controlid+", '"+request.getParameter("customer")+"', '"+request.getParameter("billno")+"', "
						+" '"+dtFormatyyyymmdd(request.getParameter("billdate"))+"', "+totalval+", 1, now())";
				}
				//System.out.println("<br>Delivery Tbl:"+InsertString);
				stmt.executeUpdate(InsertString);
				//System.out.println("Completed");

			 }
			 con.commit();
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace();
		 }
		 response.sendRedirect("/Mobile/salesList");
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
