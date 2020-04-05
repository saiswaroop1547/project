<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
</head>
<style>
#g
{
color:	white;
text-shadow: 2px 2px 8px 	#000000;
font-size:20px;
}
body,html
{
background-image:url("D:/Project/BankApplication/WebContent/images/bg.jpg"); 
 height: 100%; 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover; 
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
<li style="ba"><a href="<%=request.getContextPath()%>/index.html">Home</a></li></ul>

  <h2 align="center">Registration</h2>

<form method=get action="http://localhost:8082/BankApplication/RegisterServlet">
<table  align="center">
 <font size="5">
<tr>
    <td ><font color="red" size="3">*</font>First Name:</td>
    <td><input type='text' name="firstName" placeholder="First Name" required style="height: 20px; width: 175px;"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr >
    <td ><font color="red" size="3">*</font>Last Name:</td>
    <td><input type='text' name="lastName" placeholder="Last Name" required style="height: 20px; width: 175px;"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr >
    <td ><font color="red" size="3">*</font>Gender:</td>
    <td><input type='radio' name="gender" value='male'>Male
   <input type='radio' name="gender" value='female'>Female
    <input type='radio' name="gender" value='others' >Others</td>
</tr>
<tr> <td>&nbsp;</td> </tr>

<tr >
    <td ><font color="red" size="3">*</font>Address1:</td>
    <td><input type='text' name="address1" placeholder="Address 1" required style="height: 20px; width: 175px;">
    </td>
</tr>

<tr> <td>&nbsp;</td> </tr>

<tr>
    <td >Address2:</td>
     <td><input type='text' name="address2" placeholder="Address 2" required style="height: 20px; width: 175px;">
    </td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr >
    <td><font color="red" size="3">*</font>Mobile:</td>
    <td><input type='number' name="mobile" placeholder="Mobile No" maxlength="10" pattern=".{10,}" 
      title="Invalid phone number" required style="height: 20px; width: 175px;"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr >
    <td><font color="red" size="3">*</font>Email:</td>
    <td><input type='text' name="email" placeholder="Email"
    pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Ex:abc@xyz.com"  style="height: 20px; width: 175px;"  required ></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td><font color="red" size="3">*</font>AccountNo:</td>
    <td><input type='text' name="accountNo" placeholder="accountNo"
       style="height: 20px; width: 175px;"  required ></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td><font color="red" size="3">*</font>Balance:</td>
    <td><input type="number" name="balance" placeholder="Balance"
       style="height: 20px; width: 175px;"  required ></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td ><font color="red" size="3">*</font>User Id:</td>
    <td><input type='text' name="userId" placeholder="User Id" required style="height: 20px; width: 175px;"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr >
    <td ><font color="red" size="3">*</font>Password:</td>
    <td><input type='password' name="password" placeholder="Password" id="myInput" style="height: 20px; width: 175px;" 
    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></td>
 <td><input type="checkbox" onclick="myFunction()">Show Password</td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr >
    <td ><font color="red" size="3">*</font>Confirm Password:</td>
    <td><input type='password' name="cpassword" placeholder="Retype Password"  style="height: 20px; width: 175px;"
     pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8}"
title="Must contain at least one number and one uppercase and lowercase letter, not more than 8 characters" required></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='right'><button type='submit' name='REGISTER' value="Register" style="background-color: darkblue; 
    height: 35px; width: 100px;font-size:18px;"><font color="white">Register</font></button></td>
    <td align='left'><button type='button' name='RESET' value="Reset" style="background-color: darkblue; height: 35px; width: 100px;font-size:18px;">
    <font color="white">Reset</font></button></td>
</tr>

<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("passwordMismatchError") == null) ? "" : request.getAttribute("passwordMismatchError")%></span>
	</td>
	</tr>
<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("registrationError") == null) ? "" : request.getAttribute("registrationError")%></span>
	</td>
	</tr>
	<tr>
	<td>
	<span style="color:red"><%=(request.getAttribute("userIdError") == null) ? "" : request.getAttribute("userIdError")%></span>
	</td>
	</tr>	
</font>
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
