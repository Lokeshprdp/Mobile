<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Edit</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
</head>
<body>
<FORM NAME="frmcustomeredit">
<table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
<TR CLASS='TRData'>
				<TD ALIGN='center'>Customer Details</TD>
			</TR>
</table>

<table align='center'>

	  	
		<%! Iterator itr1; 
		Set set=null; %>
	<% Map data= (Map)request.getAttribute("data");

	set=data.entrySet();
	itr=set.iterator();
	while(itr.hasNext()) { 
	Map.Entry me = (Map.Entry)itr.next(); 
	System.out.print(me.getKey() + ": "); 
	System.out.println(me.getValue()); 
}
%>
		
				
              <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="35%" align="left">Customer Name :</TD>
             <TD CLASS="TDData1">
             <%= data.get("Customer") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">Contact Person :</TD>
             <TD CLASS="TDData1">
             <%= data.get("CP Name") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">Contact No :</TD>
             <TD CLASS="TDData1">
             <%= data.get("CP No") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">OutStanding Amount :</TD>
             <TD CLASS="TDData1">
             <%= data.get("OutStanding") %>
             </TD>
             </TR>
             
          <BR>
             
</table>
<table align='center'>
 <TR ALIGN="center" class="TRData1">
             <TD CLASS="TRData1" colspan="8" align="center">Receipt Details</TD>
             </TR></table>
<TABLE ALIGN="center"  BORDER=0 CELLSPACING=1 CELLPADDING=2 WIDTH="95%">
		<TR ALIGN="left" CLASS='TRHead'>
			<td nowrap=true CLASS="TRData1"><b>SI No.</b></td>
          	<td nowrap=true CLASS="TRData1"><b>Select</b></td>
			<td nowrap=true CLASS="TRData1"><b>Bill No</b></td>
			<td nowrap=true CLASS="TRData1"><b>Bill Date</b></td>
			<td nowrap=true CLASS="TRData1"><b>Bill Amount</b></td>
			<td nowrap=true CLASS="TRData1"><b>Due Amount</b></td>
			<td nowrap=true CLASS="TRData1"><b>Pay Amount</b></td>
		</TR>
		
<%! Iterator itr;%>
<% List receipt= (List)request.getAttribute("receipt");
for (itr=receipt.iterator(); itr.hasNext(); )
{
%>
<tr>
<td nowrap=true CLASS="TDData1"><%= itr.next()%></td>
<TD class='TDData1' align='center'><INPUT type='checkbox' class='checkbox' name='invoice"+lno+"' id='invoice"+lno+"'></INPUT></TD>
<td nowrap=true CLASS="TDData1"><%= itr.next()%></td>
<td nowrap=true CLASS="TDData1"><%= itr.next()%></td>
<td nowrap=true CLASS="TDData1"><%= itr.next()%></td>
<td nowrap=true CLASS="TDData1"><%= itr.next()%></td>
<TD class='TDData1' align='center'><INPUT type='textbox' class='textbox' name='payamount"+lno+"' id='payamount"+lno+"'></INPUT></TD>
</tr>
<%} %>
	
</TABLE>
 </FORM>
</body>
</html>