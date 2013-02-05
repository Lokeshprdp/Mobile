package com.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;

/**
 * Servlet implementation class mobileEdit
 */
public class mobileEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mobileEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		Map<String, String> dataList = new HashMap<String, String>();
		String strQueryString;
				
		 Connection con = DBConnection.getConnection();
		 String id=request.getParameter("modelid");
		 try
		 {
			
			 
			 Statement s = con.createStatement();
			 //ResultSet rs=s.executeQuery("select * from brand_tbl");
			 
			 strQueryString=" SELECT m.*,brand_name_v,quantity_i "
				 +" FROM model_tbl m "
				 +"JOIN brand_tbl b ON b.brandid_i=m.brandid_i "
				 +"JOIN stock_tbl s on s.modelno_v=m.model_no_v"
				 +" where modelid_i="+id;
			 
			 System.out.println(strQueryString);
			 
			 ResultSet rs=s.executeQuery(strQueryString);
			 
			 rs.first();
			 
				 
				 //dataList.add(rs.getInt("modelid_i"));
				 dataList.put("Brand", (rs.getString("brand_name_v")));
				 dataList.put("Model Name", (rs.getString("model_no_v")));
				 dataList.put("Model Spec", (rs.getString("model_name_v")));
				 dataList.put("Quantity", (rs.getString("quantity_i")));
				 dataList.put("Rate", (rs.getString("rate_d")));
				 dataList.put("wholesale1", (rs.getString("wholesale_rate1_d")));
				 dataList.put("wholesale2", (rs.getString("wholesale_rate2_d")));
				 dataList.put("customerrate", (rs.getString("customer_rate_d")));
				 dataList.put("Id",id);
				 //request.setAttribute("id", id);
			 rs.close();
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace(); 
		 }
		 
		request.setAttribute("data",dataList);
		 //servletContext.setAttribute("data", dataList);
		 
		 //Dispatching request
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("modelEdit.jsp");
		 
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
						
		Connection con=DBConnection.getConnection();
		String id=request.getParameter("modelid");
		try
		{
			Statement s=con.createStatement();
			
			
			 String QueryString="select now() as date ";
	        ResultSet rs = s.executeQuery(QueryString);

	        rs.first();
	        
	    	String transdate=rs.getString("date");
	    	
	    	/* QueryString="select max(stockid_i) from stock_tbl";
	    	rs=s.executeQuery(QueryString);
	    	
	    	rs.first();
	    	int stockid=rs.getInt(1)+1; */
	    	
	    	/* String strSql="Insert into model_tbl(modelid_i,brandid_i,model_no_v,model_name_v,rate_d,"
	    	+"created_date_dt) values (" + id + ",'"+request.getParameter("brand")+"','"+request.getParameter("modelname")+"',"
	    	+" '"+ request.getParameter("modelspec") +"', '"+ request.getParameter("price")+"', '"+transdate+"') ";
	    	
	    	s.executeUpdate(strSql); */
	    	
	    	String updateString="update model_tbl set"
	    		+" model_no_v='"+ request.getParameter("modelname") +"'," 
	    		+" model_name_v='"+ request.getParameter("modelspec")+"',"
	    		+" rate_d='"+ request.getParameter("price")+"',"
	    		+" updated_date_dt='"+ transdate +"'"
	    		+" where modelid_i="+id;
	    	
	    	out.println(updateString);
	    	s.executeUpdate(updateString);
	    	
	    	
	    				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		out.println("<head>");
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Register Success!");
        
        response.sendRedirect("/Mobile/modelList");

		
	}

}
