package com.mobile.DAO;

import java.text.*;
import java.util.*;
import java.sql.*;

import com.mobile.db.DBConnection;


public class UserDAO {

	static Connection currentCon = null;
    static ResultSet rs = null;  

    public static UserBean login(UserBean bean)
    {
    	Statement stmt=null;
    	
    	String username = bean.getUsername();
    	String password = bean.getPassword();
    	
    	String searchQuery =
            "select * from users_tbl where user_name_v='"
                     + username
                     + "' AND password_v='"
                     + password
                     + "'";
    	System.out.println("Your user name is " + username);          
        System.out.println("Your password is " + password);
        System.out.println("Query: "+searchQuery);
        
        try
        {
        	currentCon= DBConnection.getConnection();
        	stmt=currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);	        
            boolean more = rs.next();
            
            if (!more) 
            {
               System.out.println("Incorrect UserName and Password");
               bean.setValid(false);
            }
            else if (more) 
            {
               String firstName = rs.getString("first_name_v");
               String lastName = rs.getString("last_name_v");
   	     	
               System.out.println("Welcome " + firstName);
               bean.setFirstName(firstName);
               bean.setLastName(lastName);
               bean.setValid(true);
            }
        }
        catch (Exception ex) 
        {
           System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
        finally
        {
        	 if (rs != null)	{
                 try {
                    rs.close();
                 } catch (Exception e) {}
                    rs = null;
                 }
        	 
        	 if (stmt != null) {
                 try {
                    stmt.close();
                 } catch (Exception e) {}
                    stmt = null;
                 }
        	 
        	 if (currentCon != null) {
                 try {
                    currentCon.close();
                 } catch (Exception e) {
                 }

                 currentCon = null;
              }
        }
        return bean;
    }
}
