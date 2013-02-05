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
 * Servlet implementation class modelList
 */
public class modelList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modelList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List dataList = new ArrayList();
		
		String strQueryString;
		int lno=0;
		int id=0;
		
		 Connection con = DBConnection.getConnection();
		 try
		 {
			 Statement s = con.createStatement();
			 //ResultSet rs=s.executeQuery("select * from brand_tbl");
			 
			 strQueryString=" SELECT modelid_i,model_no_v,brand_name_v FROM model_tbl m "
				 +"JOIN brand_tbl b ON b.brandid_i=m.brandid_i ";
			 
			 ResultSet rs=s.executeQuery(strQueryString);
			 
			 lno=1;
			 while(rs.next())
			 {
				 dataList.add(lno);
				 dataList.add(rs.getInt("modelid_i"));
				 dataList.add(rs.getString("model_no_v"));
				 dataList.add(rs.getString("brand_name_v"));
				 
				 lno=lno+1;
				 
				 //request.setAttribute("id", id);
			 }
			 rs.close();
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace(); 
		 }
		 
		 request.setAttribute("data",dataList);
		 
		 //Dispatching request
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("modelList.jsp");
		 
		 if(dispatcher!= null)
		 {
			 dispatcher.forward(request, response);
		 }
	}
}
