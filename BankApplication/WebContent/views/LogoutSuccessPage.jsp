<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogoutSuccessPage</title>
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
</head>
<body>
	<ul>
<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li>
</ul>
<table align="center">
<tr><td>&nbsp;</tr></td>
<tr><td>&nbsp;</tr></td>
<tr><td>&nbsp;</tr></td>
<tr><td>&nbsp;</tr></td>
<tr><td>&nbsp;</tr></td>
<tr><td><h3>Logged out successfully !</h3></td></tr> 
 <%session.invalidate(); %>
<tr>
    <td align='right'><a href="<%=request.getContextPath()%>/views/LoginPage.jsp"><button type='submit' name='LOGIN' value="Login" style="background-color: darkblue; 
    height: 35px; width: 100px;font-size:18px;"><font color="white">Login</font></button></a></td></tr>
</table>
</body>
</html>