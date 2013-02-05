<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Brand</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<script type="text/javascript">

 function validation()
 {
	var form = document.getElementById("frmbrandadd");
	var brandname = form["brandname"].value;
	if(brandname == "")
	{
		alert("Please Enter Mobile Brand Name");
		return false;
	}
	else
	{
		return true;
	}
 }

</script>
</head>
<body>
        <FORM NAME="frmbrandadd" method="POST" action="brand"  onsubmit="javascript:return validation();" style="margin:0px">
        <h1 align="center">BRAND</h1>

        <table align="center" border="0" cellspacing="0" cellpadding="0" width="60%">
             <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
             <TR ALIGN="left">
          <TD>Brand Name :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="brandname" value='' class='textbox' size="50" >
          </TD>
          </TR>
          
        </table><br><br>
                <table align="center" width="50%">
        	<tr align="center">
        		<td>
                            <input type="submit" class="button" value="Add"/> 
        			<!--  <input type="button" name="btnupdate" value="Add" accesskey="a" onclick='validation()' class="button"> --> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick='history.go(-1)' class="button">
        		</td>
        	</tr>
       </table>
        </Form>
    </body>
</html>
