package com.ram.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.ram.services.BookService;

public class ShowBookIdController extends HttpServlet {

	public  void doGet(HttpServletRequest request,HttpServletResponse response) 
	   throws ServletException,IOException 
	{
		RequestDispatcher rd = null;
		int bookId=0;
		String title="";
		float price=0;
		
			String id=request.getParameter("bookId");
			bookId=Integer.parseInt(id);
			BookService bookService2 = new BookService();
			
		    ArrayList a = null;
			try {
				a = bookService2.searchBook(bookId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    java.util.Iterator i1=a.iterator();
			System.out.println(" records are :");
			while(i1.hasNext())
			{
			System.out.println(i1.next());	
			}
			
			if (i1==null) {
				rd = request.getRequestDispatcher("/error.jsp");
				
			} else {
				rd = request.getRequestDispatcher("/TableId.jsp");
			}
			rd.forward(request, response);
		}
			
			
}
	


	
	


