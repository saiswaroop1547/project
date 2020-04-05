<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body,html
{
background-image:url("C:\Users\cogjava37\eclipse-workspace\BankApplication\WebContent\images\bg.jpg"); 
 height: 100%; 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover; 
}
#g
{
color:white;
text-shadow: 2px 2px 8px #000000;
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

<body>
<ul>
<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li></ul>
<form method=get action="http://localhost:8082/BankApplication/LoginServlet">
	<h1 align='center'>Login to Apana Bank</h1>
<table align='center'>
<tr> <td>&nbsp;</td> </tr>
<tr> <td>&nbsp;</td> </tr>
<tr> <td>&nbsp;</td> </tr>

<tr >
    <td align='center' style="font-size:20px;"> <font color="red">*</font>User ID:</td>
    <td><input type='text' name='userId' required style="height: 20px; width: 175px;" ></td>
</tr>

<tr> <td>&nbsp;</td> </tr>

<tr >
    <td align='center' style="font-size:20px;"><font color="red">*</font>Password:</td>
    <td><input type='password' name='password' required style="height: 20px; width: 175px;" id="myInput"></td>
    <td><input type="checkbox" onclick="myFunction()">Show Password</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
	<table align='center'>
	<tr>
	    <td align='center'><button type="submit" style="background-color: darkblue; height: 35px; width: 100px;font-size:18px;"><font color="white">Login</font></button></td>
	</tr>
	
	<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("credentialsError") == null) ? "" : request.getAttribute("credentialsError")%></span>
	</td>
	</tr>
	<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("loginAttemptError") == null) ? "" : request.getAttribute("loginAttemptError")%></span>
	</td>
	</tr>
	</table>
</form>
</body>
<script>
function myFunction() {
	  var x = document.getElementById("myInput");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
</script>
</html>
































































