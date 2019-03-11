package com.ram.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ram.services.BookService;

public class DeleteBookController extends HttpServlet {
	
	
	public  void doGet(HttpServletRequest request,HttpServletResponse response) 
			   throws ServletException,IOException 
			{
				RequestDispatcher rd = null;
				int bookId=0;
				
					String id=request.getParameter("bookId");
					bookId=Integer.parseInt(id);
					BookService bookService1 = new BookService();
					
					   int updateCount1 = bookService1.delBookService(bookId);
							
							System.out.println("deleted "+updateCount1+" record   Success");
							
							if (updateCount1==1) {
								rd = request.getRequestDispatcher("/table.jsp");
								
							} else {
								rd = request.getRequestDispatcher("/errordelete.jsp");
							}
							rd.forward(request, response);
						}

}
