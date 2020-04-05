<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.apn.bo.*,com.apn.services.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WithdrawSuccessPage</title>
</head>
<style>
body,html
{
background-image:url("D:/Project/BankApplication/WebContent/images/bg.jpg");

  background-position: center;
  background-repeat: no-repeat;
  background-size: 5000% 5000%; 
}
ul {
list-style-type:none;
margin:0;
padding:0;
overflow:hidden;
background-color:darkblue;
}
li{
float:left;
}
li a{
display:block;
color:white;
text_align:center;
padding:14px 16px;
text_decoration:none;
}
li a:hover:not(.active){
background-color:#111;
}
.active{
background-color:#4CAF50;
}
</style>
<body>
<ul>
<li style="ba"><a href="index.html">Home</a></li>
<li style="float:right"><a href="<%=request.getContextPath()%>/views/LogoutSuccessPage.jsp">Logout</a></li>
<li style="float:right"><a href="<%=request.getContextPath()%>/views/ServicesPage.jsp">Back</a></li></ul>
			<% UserBO user = (UserBO)session.getAttribute("user");
			
			Float amount = (Float)session.getAttribute("amount");
				Float balance = (Float)session.getAttribute("balance");
			%>
			<table align="center">	
			<tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>Amount <b><%= amount %></b> has been withdrawn successfully</td></tr>
			<tr><td>&nbsp;</td></tr>
				<tr><td>Your balance is <b><%=balance%></b></td></tr>
				</table>
</body>
</html>