package com.mobile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobile.DAO.UserBean;
import com.mobile.DAO.UserDAO;
/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{	    

		     UserBean user = new UserBean();
		     user.setUsername(request.getParameter("uname"));
		     user.setPassword(request.getParameter("pwd"));

		     user = UserDAO.login(user);
			   		    
		     if (user.isValid())
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          response.sendRedirect("homePage.jsp"); //logged-in page      		
		     }
			        
		     else 
		          response.sendRedirect("loginPage.jsp"); //error page 
		} 
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}
}
