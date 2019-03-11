package com.ram.controller;
import com.ram.services.BookService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ram.services.BookService;

public class BookController extends HttpServlet
{
public  void doGet(HttpServletRequest request,HttpServletResponse response) 
   throws ServletException,IOException 
{
	RequestDispatcher rd = null;
	int bookId=0;
	String title="";
	float price=0;
	/*Scanner s=new Scanner(System.in);
	System.out.println("Enter Book BooId");
		bookId = s.nextInt();
		System.out.println("Enter Book Titile");
		title = s.next();	
		System.out.println("Enter Book price");
		price = s.nextFloat();
		*/
		String id=request.getParameter("bookId");
		bookId=Integer.parseInt(id);
		title=request.getParameter("title");
		String p=request.getParameter("price");
		price=Float.parseFloat(p);
		
		BookService bookService = new BookService();
		
		
   int updateCount = bookService.addBookService(bookId, title, price);
		
		System.out.println("inserted "+updateCount+" record   Success");
		
		if (updateCount==1) {
			rd = request.getRequestDispatcher("/success.jsp");
			
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
		
		
		
}

