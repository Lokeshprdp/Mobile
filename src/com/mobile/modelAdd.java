package com.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;

/**
 * Servlet implementation class modelAdd
 */
public class modelAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modelAdd() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        	
    }	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
						
		Connection con=DBConnection.getConnection();
		try
		{
			Statement s=con.createStatement();
			
			String QueryString="select max(modelid_i),now() as date from model_tbl";
	        ResultSet rs = s.executeQuery(QueryString);

	        rs.first();
	    	int modelid=rs.getInt(1)+1;
	    	String transdate=rs.getString("date");
	    	
	    	QueryString="select max(stockid_i) from stock_tbl";
	    	rs=s.executeQuery(QueryString);
	    	
	    	rs.first();
	    	int stockid=rs.getInt(1)+1;
	    	
	    	String strSql="Insert into model_tbl(modelid_i,brandid_i,model_no_v,model_name_v,rate_d,"
	    	+"wholesale_rate1_d,wholesale_rate2_d,customer_rate_d,created_date_dt) values (" + modelid + ","
	    	+"'"+request.getParameter("brand")+"','"+request.getParameter("modelname")+"', '"+ request.getParameter("modelspec") +"',"
	    	+"'"+ request.getParameter("rate")+"', '"+request.getParameter("wholesale1")+"', '"+request.getParameter("wholesale2")+"',"
	    	+"'"+request.getParameter("customerrate")+"','"+transdate+"') ";
	    	
	    	System.out.println(strSql);
	    	s.executeUpdate(strSql);
	    	
	    	
	    	strSql="Insert into stock_tbl(stockid_i,modelno_v,quantity_i"
	    		+") values (" + stockid +",'"+request.getParameter("modelname")+"', '"+request.getParameter("qty")+"') ";
	    	
	    	s.executeUpdate(strSql);
	    				
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
