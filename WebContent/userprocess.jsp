
<%@page import="bean.UserDao"%>
<jsp:useBean id="bean" class="bean.LoginBean"/>
<jsp:setProperty property="*" name="bean"/>

<%
boolean status1=UserDao.validate(bean);
System.out.println("USER dao.."+status1);
if(status1){
out.println("You r successfully logged in");
%>
<jsp:include page="UserLoginView.jsp"></jsp:include>
<%
session.setAttribute("session","TRUE");
}
else
{
out.print("Sorry, email or password error");
%>
<jsp:include page="Home.jsp"></jsp:include>
<%
}
%>