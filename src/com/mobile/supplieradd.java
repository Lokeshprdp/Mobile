package com.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.db.DBConnection;
/**
 * Servlet implementation class supplieradd
 */
public class supplieradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplieradd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		Connection con=DBConnection.getConnection();
		try
		{
			Statement s=con.createStatement();
			
			String QueryString="select max(supplierid_i),now() as date from supplier_tbl";
	        ResultSet rs = s.executeQuery(QueryString);

	        rs.first();
	    	int supplierid=rs.getInt(1)+1;
	    	String transdate=rs.getString("date");
	    	
	    	QueryString="insert into supplier_tbl (supplierid_i,suppliername_v,cp_name_v,"
	    		+" cp_no_v,created_by_i,created_date_dt) values (" +supplierid+ ","
	    		+" '"+request.getParameter("suppliername")+"', '"+request.getParameter("cpname")+"', "
	    		+" '"+request.getParameter("cpno")+"', '"+1+"','"+transdate+"')" ;
	    	
	    	System.out.println(QueryString);
	    	s.executeUpdate(QueryString);
			
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
		
        response.sendRedirect("/Mobile/supplierList");
	}

}
