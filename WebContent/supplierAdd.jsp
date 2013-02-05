<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Supplier</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<script type="text/javascript">

 function validation()
 {
	var form = document.getElementById("frmsupplieradd");
	var suppliername = form["suppliername"].value;
	var cpname = form["cpname"].value;
	var cpno = form["cpno"].value;
	 if(suppliername == "")
	{
		alert("Please Enter Supplier Name");
		return false;
	}
	if(cpname == "")
	{
		alert("Please Enter Contact Person");
		return false;
	}		
	if(cpno == "/^[1-9]+[0-9\,]+\d*$/")
	{
		alert("Please Enter Correct Phone No.")
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
        <FORM NAME="frmsupplieradd" method="POST" action="supplieradd"  onsubmit="javascript:return validation();" style="margin:0px">
        <table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
		<TR CLASS='TRData1'>
				<TD ALIGN='center'>Add Supplier Detail's</TD>
			</TR>

        <table align="center" border="0" cellspacing="0" cellpadding="0" width="60%">
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD class='TRData1'>Supplier Name :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="suppliername" value='' class='textbox' size="50" >
          </TD>
          </TR>
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD class='TRData1'>Contact Person :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="cpname" value='' class='textbox' size="25" >
          </TD>
          </TR>
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD class='TRData1'>Contact No :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="cpno" value='' class='textbox' size="15" >
          </TD>
          </TR>
          
        </table><br><br>
             <table align="center" border="0" cellspacing="0" cellpadding="0" width="60%">
        	<tr align="center">
        		<td>
                            <input type="submit" class="button" value="Add"/> 
        			<!--  <input type="button" name="btnupdate" value="Add" accesskey="a" onclick='validation()' class="button"> --> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick=funcFormSubmit(document.frmpaytermadd,'ebmPaymentTerms_list.jsp') class="button">
        		</td>
        	</tr>
       </table>
       </table>
        </Form>
    </body>
</html>