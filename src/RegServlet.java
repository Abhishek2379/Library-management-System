
 //create table reg(username varchar(20),password varchar(20),age varchar(20),contact varchar(20),address varchar(20),mailid varchar(20),qualification varchar(20));



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class RegServlet extends HttpServlet {
   
    public  void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    	response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        try {
           
            
       String   username=request.getParameter("uname");
       String   password=request.getParameter("pword");
       String   age=request.getParameter("age");
       String   contact=request.getParameter("cno");
       String   address=request.getParameter("add");
       String   mailid=request.getParameter("eid");
       String   qualification=request.getParameter("qu");
       
       
            
       Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "test";
		String driver = "com.mysql.jdbc.Driver";
		//String userName = "root"; 
		//String password = "root";	
		  
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,"root","root");
			String query="insert into reg values(?,?,?,?,?,?,?)";	
			
			//Step1 :  Get PreparedStatement 
			PreparedStatement pstmt=conn.prepareStatement(query);
			//Step2 :  Set parameters
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setString(3,age);
			pstmt.setString(4,contact);
			pstmt.setString(5, address);
			pstmt.setString(6, mailid);
			pstmt.setString(7,qualification);
	
			
			//Step3 : execute the query
			int i=pstmt.executeUpdate();
			System.out.println("Record inserted count"+i);
		 
		  
			
			    
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormParameters</title>");  
            out.println("</head>");
            out.println("<body bgcolor='#DFBDEA'>");
            out.println("<center>");
            out.println("<table>");
            out.println("<tr><td> User Name :</td><td>" + username +"</td></tr>");
            out.println("<tr><td> Password  : </td><td>" + password + "</td></tr>");
            out.println("<tr><td> Age :</td><td> " + age + "</td></tr>");
            out.println("<tr><td> Contact :</td><td> " +contact + "</td></tr>");
            out.println("<tr><td>Address : </td><td>" + address + "</td></tr>");
            out.println("<tr><td> Mail Id :</td><td>" + mailid + "</td></tr>");
            out.println("<tr><td> Qualtification :</td><td> " + qualification + "</td></tr>");
            out.println("<tr><td> Record inserted count :</td><td> " + i + "</td></tr>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
            
            catch(Exception e)
  		      {
  			  System.out.println(e);
  		      }
            
             finally { 
            out.close();
        }
    } 

}
