package com.ram.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ram.services.BookService;

public class ViewAllController extends HttpServlet {
	public  void doGet(HttpServletRequest request,HttpServletResponse response) 
			   throws ServletException,IOException 
			{
				RequestDispatcher rd = null;
				int bookId=0;
				String title="";
				float price=0;

	BookService bookService3=new BookService();
	ArrayList<String> a1=bookService3.showBook();
	System.out.println("All Records are : ");
	for(String name:a1) {
		System.out.println(name);
	}
	if (a1==null) {
		rd = request.getRequestDispatcher("/error.jsp");
		
	} else {
		rd = request.getRequestDispatcher("/table.jsp");
	}
	rd.forward(request, response);
			}
	
}
