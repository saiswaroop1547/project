<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Page</title>
<style>
body,html
{
background-image:url("D:/Project/BankApplication/WebContent/images/bg.jpg");

  background-position: center;
  background-repeat: no-repeat;
background-size: 500% 500%; 
}
#g
{
color:	white;
text-shadow: 2px 2px 8px 	#000000;
font-size:20px;
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
<form method=post action="<%=request.getContextPath()%>/Withdraw">
<ul>
<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li>
<li style="float:right"><a href="<%=request.getContextPath()%>/views/LogoutSuccessPage.jsp">Logout</a></li><li style="float:right"><a href="<%=request.getContextPath()%>/views/ServicesPage.jsp">Back</a></li></ul>
<br>&nbsp;</br>
<h1 align='center'>Withdraw Details</h1>
<table align="center">
<tr>&nbsp;</tr>
<tr>
<td><font size="5">Account Number:</font></td>
<td><input type="text" name="accountNo" placeholder="Account Number" style="height: 20px; width: 175px;" required></td>
</tr>
<tr>&nbsp;</tr>
<tr>
<td><font size="5">User Id:</font></td>
<td><input type="text" name="userId" placeholder="User Id" style="height: 20px; width: 175px;" required></td>
</tr>
<tr>&nbsp;</tr>
<tr><td><font size="5">Amount:</font></td>
<td><input type="number" name="amount" placeholder="Amount"  style="height: 20px; width: 175px;" required></td>
</tr>

</table>
<table align='center'>
<tr><td>&nbsp;</td></tr>
<tr>
	    <td align='center'><input type='submit' style="background-color: darkblue; height: 35px; width: 100px;font-size:18px;color:white;" value="SUBMIT"></td>
	    <td align='center'><input type='reset' style="background-color: darkblue; height: 35px; width: 100px;font-size:18px;color:white;" name='RESET'value="RESET"></td>
	</tr>
	<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("accountNoError") == null) ? "" : request.getAttribute("accountNoError")%></span>
	</td>
	</tr>
	<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("withdrawError") == null) ? "" : request.getAttribute("withdrawError")%></span>
	</td>
	</tr>
	<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("amountError") == null) ? "" : request.getAttribute("amountError")%></span>
	</td>
	</tr>
</table>
</form>
</body>
</html>