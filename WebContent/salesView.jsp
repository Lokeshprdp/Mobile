<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales View</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
</head>
<body>
<table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
<TR CLASS='TRData'>
				<TD ALIGN='center'>Sales Details</TD>
			</TR>
</table>
<table align='center'>

	  	
		<%! Iterator itr;
		Set set=null; %>
	<% Map data= (Map)request.getAttribute("data");

	set=data.entrySet();
	itr=set.iterator();
	while(itr.hasNext())	{
	Map.Entry me = (Map.Entry)itr.next(); 
	System.out.print(me.getKey() + ": "); 
	System.out.println(me.getValue());
	}
%>
				
              <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="35%" align="left">sales No :</TD>
             <TD CLASS="TDData1">
             <%= data.get("sales no") %>
             </TD>
             <TD CLASS="TRData1" width="35%" align="right">sales Date: </TD>
             <TD CLASS="TDData1">
             <%= data.get("sales date") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">Bill No :</TD>
             <TD CLASS="TDData1">
             <%= data.get("bill no") %>
             </TD>
             <TD CLASS="TRData1" width="25%" align="right">Bill Date: </TD>
             <TD CLASS="TDData1">
             <%= data.get("bill date") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">Customer Name :</TD>
             <TD CLASS="TDData1">
             <%= data.get("customer") %>
             </TD>
             </TR>
          <BR>
</table>        
<table align="center">
<tr align="center" class="TRData1">
<TD CLASS="TRData1" colspan="8" align="center">Product Details</TD>
</tr>
</table>     
<TABLE ALIGN="center"  BORDER=1 CELLSPACING=1 CELLPADDING=2 WIDTH="95%">
<tr align="left" class="TRHead">
<td nowrap=true class="TRData1"><b>SI No</b></td>
<td nowrap=true class="TRData1"><b>Model Name</b></td>
<td nowrap=true class="TRData1"><b>Imei No</b></td>
<td nowrap=true class="TRData1"><b>Quantity</b></td>
<td nowrap=true class="TRData1"><b>Rate</b></td>
<td nowrap=true class="TRData1"><b>Discount Value</b></td>
<td nowrap=true class="TRData1"><b>Tax Value</b></td>
<td nowrap=true class="TRData1"><b>Total Value</b></td>
</tr>

<%! Iterator itr1; %>
<% List part = (List)request.getAttribute("part"); 
for (itr1=part.iterator(); itr1.hasNext(); )
{ 
	
%>
<tr>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
<td nowrap=true CLASS='TDData1'><%=itr1.next()%></td>
</tr>
<% } %>
<tr>
<td colspan="5" align="right" class="TRData1">Total</td>
<td class="TRData1" align="right"><%= data.get("total amount") %></td>
</tr>
</table>

</body>
</html>