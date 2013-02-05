<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.mobile.db.DBConnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Mobile Model</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<script type="text/javascript">

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

 function validation()
 {
	var form = document.getElementById("frmmodeladd");
	var brandname = form["brand"].value;
	var modelname = form["modelname"].value;
	var modelspec = form["modelspec"].value;
	var rate = form["rate"].value;
	var wholesale1 = form["wholesale1"].value;
	var wholesale2 = form["wholesale2"].value;
	var customerrate = form["customerrate"].value;
	
	if(brandname == "0")
	{
		alert("Please Select Mobile Brand Name");
		return false;
	}

    alert("inside");
	
	if(modelname == "")
	{
		alert("Please Enter Mobile Model Name");
		return false;
	}
	
	if(modelspec == "")
	{
		alert("Please Enter Mobile Model Spec details");
		return false;
	}
	if(rate == "0")
	{
		alert("Please Enter Valid Price");
		return false;
	}
	if(wholesale1 == "0")
	{
		alert("Please Enter Valid WholeSale Price1");
		return false;
	}
	if(wholesale2 == "0")
	{
		alert("Please Enter Valid WholeSale Price2");
		return false;
	}
	if(customerate == "0")
	{
		alert("Please Enter Valid Customer Price");
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
        <FORM NAME="frmmodeladd" method="POST" action="modelAdd"  onsubmit="javascript:return validation();" style="margin:0px">
        
        <table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
<TR CLASS='TRData1'>
				<TD ALIGN='center'>Add Mobile Model Detail's</TD>
			</TR>

<%!

  Connection con = DBConnection.getConnection();
  ResultSet rs;
%>

        <table align="center" border="0" cellspacing="0" cellpadding="0" width="60%">
             <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center"> Select Brand :</TD>
             <TD CLASS="TDData1">
             
             <%
       Statement stmtmodel = con.createStatement();
     String strQueryString="select * from brand_tbl order by brandid_i " ;
      
       rs = stmtmodel.executeQuery(strQueryString);
       out.println("<Select id='brand' name='brand' class='clsdropdown'>");
       out.println("<Option value='0'>Select Brand </option>");
       while (rs.next())
        {
           out.println("<Option value=" + rs.getString("brandid_i") + ">"+ rs.getString("brand_name_v") + "</Option> <br>");
        }
       rs.close(); 
%>
      <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">Model Name :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="modelname" value='' class='textbox'>
          </TD>
          </TR>

		<TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">Model Spec :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" name="modelspec" value='' class='textbox' size='50'>
          </TD>
          </TR>
          
        <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">Quantity :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" onkeypress="return isNumber(event)" name="qty" value='0' class='textbox'>
          </TD>
          </TR>
          
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">Price :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" onkeypress="return isNumber(event)" name="rate" value='0' class='textbox'>
          </TD>
          </TR>
          
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">WholeSale Price1 :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" onkeypress="return isNumber(event)" name="wholesale1" value='0' class='textbox'>
          </TD>
          </TR>
          
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">WholeSale Price2 :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" onkeypress="return isNumber(event)" name="wholesale2" value='0' class='textbox'>
          </TD>
          </TR>
          
          <TR HEIGHT='20px'><TD colspan='2'></TD></TR>
          <TR ALIGN="left">
          <TD CLASS="TRData1">Customer Price :</TD>
          <TD class='TDData1'>
          	<INPUT TYPE="text" onkeypress="return isNumber(event)" name="customerrate" value='0' class='textbox'>
          </TD>
          </TR>
          
          
        
</TD>
</TR>
</table>
</table>
<br><br>
                <table align="center" width="50%">
        	<tr align="center">
        		<td>
                            <input type="submit" class="button" value="Add"/> 
        			<!--  <input type="button" name="btnupdate" value="Add" accesskey="a" onclick='validation()' class="button"> --> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick=funcFormSubmit(document.frmpaytermadd,'ebmPaymentTerms_list.jsp') class="button">
        		</td>
        	</tr>
       </table>
        </Form>
    </body>
</html>
