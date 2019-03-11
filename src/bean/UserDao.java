package bean;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {
	

		public static boolean validate(LoginBean bean){
			boolean status1=false;
			try{
				Connection con=(Connection) ConnectionProvider.getCon();
				
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from reg where mailid=? and password=?");
				ps.setString(1,bean.getMailid());
				ps.setString(2, bean.getPassword());
				
				ResultSet rs=ps.executeQuery();
				System.out.println(rs.toString());
				status1=rs.next();
				
			}catch(Exception e){}
			return status1;
		}
	}


