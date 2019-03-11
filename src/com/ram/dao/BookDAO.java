package com.ram.dao;

import com.ram.beans.BookBean;
import java.sql.*;
import java.util.ArrayList;


public class BookDAO 
{
	
	
  public int addBook(BookBean obj)
  {
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  try
	  {
		  /* Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	         "jdbc:mysql://localhost:3309/accdb","root","root"); 
	     */
		  con=BookDB.getConnection(); 
		  
		  String ins_str = 
			  "insert into book values(?,?,?,?)";
		  
		  pstmt = con.prepareStatement(ins_str);
		  
		  pstmt.setInt(1,obj.getBookId());
		  pstmt.setString(2,obj.getTitle());
		  pstmt.setFloat(3,obj.getPrice());
		  pstmt.setString(4,obj.getGrade());
		  
		  
		  int updateCount = pstmt.executeUpdate();
		  
		  con.close();
		  
		  return updateCount;
		  
		  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex.toString());
		  return 0;
	  }
	  
  }
  
  
  
  
  public int delBook(int bookId) 
  {  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  try
	  {
		
		  con=BookDB.getConnection(); 
		  
  String del_str = 
		  "delete from book where bookId = ?";
	  
	  pstmt = (PreparedStatement) con.prepareStatement(del_str);
	  pstmt.setInt(1,bookId);
	  int updateCount1 = pstmt.executeUpdate();
	  
	  con.close();
	  
	  return updateCount1;
	  
	  
  }
	  catch(Exception ex)
	  {
		  System.out.println(ex.toString());
		  return 0;
	  }
  }
  
  // Below method, Search by ID Module.    
  public ArrayList getBookDetailsById(int bookId)
			throws Exception
			{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				con = BookDB.getConnection();
				
		    String sel_str ="Select title,price from book where bookId=?";
				  
				  
				  pstmt = con.prepareStatement(sel_str);
				  pstmt.setInt(1,bookId);
				  rs = pstmt.executeQuery();
				  
				  ArrayList result = new ArrayList();
				  if(rs.next())
				  {
					  result.add(rs.getString(1));
					  result.add(rs.getString(2));
					  
				  }
				  else
				  {
					  result.add("Invalid Id");
				  }
				  return result;
				
			}
  
  public ArrayList getAllRecord()
			throws Exception
			{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				con = BookDB.getConnection();
				
		    String sel_str1 ="Select * from book";
				  
				  
				  pstmt = con.prepareStatement(sel_str1);
				  rs = pstmt.executeQuery();
				  
				  ArrayList result = new ArrayList();
				  while(rs.next())
				  {
					  result.add(rs.getString(1)
							  );
					  result.add(rs.getString(2));
					  result.add(rs.getString(3));
					  
				  }
				  
				  return result;
}}
