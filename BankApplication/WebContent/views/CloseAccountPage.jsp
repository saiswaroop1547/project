<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<title>close account</title>

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
	<body>
		<ul>
		<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li>
		<li style="float:right"><a href="<%=request.getContextPath()%>/views/LogoutSuccessPage.jsp">Logout</a></li>
		<li style="float:right"><a href="<%=request.getContextPath()%>/views/ServicesPage.jsp">Back</a></li></ul>
		<br>&nbsp;</br>
		<h1 align='center'>Close Account</h1>
		
		<form method =post action=<%=request.getContextPath()%>/CloseAccount>
		
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
			<tr><td><font size="5">Password:</font></td>
			<td><input type="password" name="password" placeholder="Password" style="height: 20px; width: 175px;" required></td>
			</tr>
			</table>
			<table align='center'>
			<tr>
			<br>
			<br>
			    <td align='center'><input type='submit' name='SUBMIT' value="SUBMIT" style="background-color: darkblue; height: 35px; width: 100px;font-size:18px;color:white;" id="demo"></td>
			
			 <td algin='center'>
			<input type="submit" name="RESET" value="RESET" style="background-color: darkblue; height: 35px; width: 100px;font-size:18px;color:white;"> </a>
			</td></tr>
				<tr><td><span style="color:red"><%=(request.getAttribute("invalidCredentialsError") == null) ? "" : request.getAttribute("invalidCredentialsError")%></span></td></tr>
			</table>
			
		</form>
	
	</body>
	
</html>