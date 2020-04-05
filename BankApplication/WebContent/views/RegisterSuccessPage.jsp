<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.apn.bo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterSuccessPage</title>
</head>
<style>
body,html
{
background-image:url("D:/Project/BankApplication/WebContent/images/bg.jpg");

  background-position: center;
  background-repeat: no-repeat;
  background-size: 1000% 1000%; 
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
<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li>
<li style="float:right"><a href="<%=request.getContextPath()%>/index.html">Back</a></li></ul> 

<%UserBO user =(UserBO)session.getAttribute("user"); %>
<table align="center">
	<tr> <td>&nbsp;</td> </tr>
		<tr> <td>&nbsp;</td> </tr>
			<tr> <td>&nbsp;</td> </tr>
	<tr><td>Welcome <b><%= user.getFirstName() %></b></td></tr>
	<tr> <td>&nbsp;</td> </tr>
			<tr><td>Your User ID is <b><%= user.getUserId()%></b></td></tr>
			<tr><td>Your Account Number <b><%= user.getAccountNo()%></b></td></tr>
			<tr> <td>&nbsp;</td> </tr>
			<tr>
    <td align='right'><a href="<%=request.getContextPath()%>/views/LoginPage.jsp"><button type='submit' name='LOGIN' value="Login" style="background-color: darkblue; 
    height: 35px; width: 100px;font-size:18px;"><font color="white">Login</font></button></a></td></tr>
	</table>      <%session.invalidate(); %>
</body>
</html>