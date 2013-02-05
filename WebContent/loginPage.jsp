<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
</head>
<body>
<form name="login" action="login">
<table align="center" border="0" cellspacing="0" cellpadding="0" width="60%">

<TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">User Name :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="uname" value='' class='textbox'>
          </TD>
          </TR>
          
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">Password :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="pwd" value='' class='textbox'>
          </TD>
          </TR>
</table>
<table align="center" width="50%">
        	<tr align="center">
        		<td>
                            <input type="submit" class="button" value="Login"/> 
        			<!--  <input type="button" name="btnupdate" value="Add" accesskey="a" onclick='validation()' class="button"> --> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick=funcFormSubmit(document.frmpaytermadd,'ebmPaymentTerms_list.jsp') class="button">
        		</td>
        	</tr>
       </table>
</form>
</body>
</html>