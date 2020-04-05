<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>

</head>
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
text-shadow: 2px 2px 8px 	#000;
font-size:25px;
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
<body align="right" >
<ul>
<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li>
<li style="float:right"><a href="<%=request.getContextPath()%>/views/LogoutSuccessPage.jsp">Logout</a></li></ul>
<h1 align="center">Services </h1>

<table align="center">
<tr> <td>&nbsp;</td> </tr>
<tr> <td>&nbsp;</td> </tr>
<tr> <td>&nbsp;</td> </tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
<td ><a href="<%=request.getContextPath()%>/views/CheckBalancePage.jsp"><button type="button" style="background-color: darkblue; height: 50px; width: 150px;font-size:20px;">
<font color="white">Check Balance</font></button></a>
<td><a href="<%=request.getContextPath()%>/views/DepositPage.jsp"><button type="button" style="background-color: darkblue; height: 50px; width: 150px;font-size:20px;">
<font color="white">Deposit</font></button></a></td>

<td><a href="<%=request.getContextPath()%>/views/WithdrawPage.jsp"><button type="button" style="background-color: darkblue; height: 50px; width: 150px;font-size:20px;">
<font color="white">Withdraw</font></button></a></td>
<td><a href="<%=request.getContextPath()%>/views/TransferPage.jsp"><button type="button" style="background-color: darkblue; height: 50px; width: 150px;font-size:20px;">
<font color="white">Transfer</font></button></a></td>
<td><a href="<%=request.getContextPath()%>/views/CloseAccountPage.jsp"><button type="button" style="background-color: darkblue; height: 50px; width: 150px;font-size:20px;">
<font color="white">Close Account</font></button></a></td>
</tr>
</table>

</body>
</html>



