package bean;
import java.sql.*;
public class LoginDao {

	public static boolean validate(LoginBean1 bean){
		boolean status=false;
		try{
			Connection con=ConnectionProvider.getCon();
			
			PreparedStatement ps=con.prepareStatement("select * from myuser where email=? and pass=?");
			System.out.println("Email  :"+bean.getEmail());
			System.out.println("Password :"+bean.getPass());
			
			ps.setString(1,bean.getEmail());
			ps.setString(2, bean.getPass());
			
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.toString());
			//status=rs.next();
			System.out.println("Login Status.. :"+status);
			status=true;
		}catch(Exception e){}
		return status;
	}
}
