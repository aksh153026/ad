java servlet 
package controllers;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
SCa
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JDBCClass {
	
	
	@SuppressWarnings("null")
	public static boolean connectionMethod(String USERNAME,String PASSWORD) 
	{
		 
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("Connectiong to database..");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
			//String query="select * from detail";
			String query = "select USERNAME,PASSWORD from detail where USERNAME=? and PASSWORD=?";
			PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, USERNAME);
            ps.setString(2, PASSWORD);
            System.out.println(query);
            ResultSet rs =ps.executeQuery();
            
            if(rs==null){
            	System.out.println("user no valid");
            }
            else {
            	System.out.println("valid user");
            	return true;
            }
            
			/*
			 * while(rs.next()) { LoginValidation.doPost(request,response); return true; }
			 */
    }
		catch(Exception e) {
			System.out.println("Exception");
		}
		return false;
		
		
	}
}
	
	



